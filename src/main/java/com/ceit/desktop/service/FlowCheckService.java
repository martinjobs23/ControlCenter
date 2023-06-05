package com.ceit.desktop.service;

import com.ceit.desktop.grpc.SoftwareCheckRequest;
import com.ceit.desktop.grpc.SoftwareList;
import com.ceit.desktop.grpc.TrafficCheckRequest;
import com.ceit.desktop.utils.JdbcUtil;
import com.ceit.desktop.utils.NetconfUtils;
import com.ceit.desktop.utils.PolicyUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import net.juniper.netconf.XML;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class FlowCheckService {
    private static Logger logger = LoggerFactory.getLogger(FlowCheckService.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();

    public int flowCheck(int msg_type, byte[] stream,String clientIP) throws InvalidProtocolBufferException {
        int result = 0;
        if (msg_type == 0){     //首次上传软件列表
            //反序列化
            TrafficCheckRequest trafficCheckRequest = TrafficCheckRequest.parseFrom(stream);
            int output = trafficCheckRequest.getOutputBytes();
            int input = trafficCheckRequest.getInputBytes();
            System.out.println("outputBytes: " + output);
            System.out.println("inputBytes: " + input);

//            String sql = "insert into dev_sw_info (filename,hash,time,dev_ip) values(?,?,?,?)";
//            int res = jdbcUtil.executeUpdate(sql,filename,hash,time,clientIP);
//
//            } else if (msg_type == 2){  //软件更新
//            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
//            List list = softwareCheckRequest.getSoftwareList();
//            for (int i=0;i<list.size();i++){
//                SoftwareList softwareList = (SoftwareList) list.get(i);
//                String filename = softwareList.getFilename();
//                String hash = softwareList.getHash();
//                String time = softwareList.getTime();
//                Date date = new Date();
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String check_time = simpleDateFormat.format(date);
//                System.out.println("filename: " + filename + ", hash: " + hash + ", time: " + time);
//                String checkSql = "select * from dev_sw_info where hash =?";
//                List list1 = jdbcUtil.executeQuery(checkSql,hash);
//                if (list1.size()==0){
//                    String sql = "insert into soft_check_info (soft_name,soft_hash,device_ip,time,check_time,description) values(?,?,?,?,?,?)";
//                    int res = jdbcUtil.executeUpdate(sql,filename,hash,clientIP,time,check_time,"此软件未在软件列表");
//                    System.out.println("filename: " + filename + "此软件未在软件列表");
//                }
//            }
//            result = 1;
        }

        return result;
    }

    public void updateflowStatistic(String devIp, String devMac, long flowin, long flowout, long pktin, long pktout, String time1, String time2){
        int inMax = PolicyUtil.getInmax();
        int outMax = PolicyUtil.getOutmax();
        int pktinMax = PolicyUtil.getInPktmax();
        int pktoutMax = PolicyUtil.getOutPktmax();
        int policy = PolicyUtil.getTrafficPolicy();
        int description = 0; //"正常"

        if(flowin > inMax || flowout > outMax || pktin > pktinMax || pktout > pktoutMax){
            switch (policy){
                case 0:
                    description =  1; //"通知管理员"
                    break;
                case 1:
                    description =  2; //"阻断入网"
                    String sqlUpdate = "update dev_cert set status = 0 where dev_ip =?";
                    jdbcUtil.executeUpdate(sqlUpdate,devIp);
                    //通知对应ip终端下线
                    NetManageService netManageService = new NetManageService();
                    netManageService.NotifyTerminalLogoff("流量情况异常",devIp,"",0);
                    break;
                default:
                    break;
            }
        }

        String checksql = "select * from dev_flow_statistic where time >= ? and time < ? and dev_ip = ?";
        String updatesql = "update dev_flow_statistic set flow_in = ?, flow_out = ?, pkt_in = ?, pkt_out = ? ,description = ? where dev_tp = ? and time = ?";
        String insertsql = "insert into dev_flow_statistic(dev_ip,dev_mac,flow_in,flow_out,pkt_in,pkt_out,time,description) values(?,?,?,?,?,?,?,?)";
        List list1 = jdbcUtil.executeQuery(checksql,time1,time2,devIp);
        if(list1.size() == 0){
            int res = jdbcUtil.executeUpdate(insertsql,devIp,devMac,flowin,flowout,pktin,pktout,time1,description);
        }
        else{
            int res = jdbcUtil.executeUpdate(updatesql,flowin,flowout,pktin,pktout,description,devIp,time1);
        }
    }

    public void computeflow(String agentIp, String devIp, String devMac, int ifIndex){
        Date date = new Date();
        long ltime = date.getTime();
        Date dateplus = new Date();
        dateplus.setTime(ltime + 1000 * 60 * 60 * 24);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time1 = simpleDateFormat.format(date);
        String time2 = simpleDateFormat.format(dateplus);

        String checksql = "select * from dev_sflow_counter where time >= ? and time < ? and agent_ip = ? and if_index = ? order by time";
        List<Map<String,Object>> list1 = jdbcUtil.executeQuery(checksql,time1,time2,agentIp,ifIndex);
        if(list1.size() == 0){
            System.out.println("ip:" + devIp +"当日无统计数据");
            return;
        }
        Map<String,Object> map1 = list1.get(0);
        Map<String,Object> map2 = list1.get(list1.size() - 1);
        long inOct = (long)map2.get("in_oct") - (long)map1.get("in_oct");
        long outOct = (long)map2.get("out_oct") - (long)map1.get("out_oct");
        long  inPkt = (long)map2.get("in_pkt") - (long)map1.get("in_pkt");
        long  outPkt = (long)map2.get("out_pkt") - (long)map1.get("out_pkt");
        updateflowStatistic(devIp,devMac,inOct,outOct,inPkt,outPkt,time1,time2);
    }

    public int updateflowStatisticAll(){
        int res = 0;
        String ipmacsql = "select dev_ip,dev_mac from dev_cert ";
        String macifindexsql = "select * from dev_switch_mac";

        List<Map<String,Object>> ip_mac = jdbcUtil.executeQuery(ipmacsql);
        List<Map<String,Object>> sw_mac = jdbcUtil.executeQuery(macifindexsql);

        if(ip_mac.size() == 0){
            return -1;          //没有ip-mac绑定信息
        }
        Map<String,String> ip_mac_map = new HashMap<String,String>();
        for(Map<String,Object> map1 : ip_mac){
            String mac = (String)map1.get("dev_mac");
            String dev_ip = (String)map1.get("dev_ip");
            ip_mac_map.put(mac,dev_ip);
        }

        for(Map<String,Object> map2 : sw_mac){
            String agent_ip = (String)map2.get("switch_ip");
            String dev_mac = (String)map2.get("mac");
            int ifindex = (int)map2.get("interface") + 6;
            String dev_ip = ip_mac_map.get(dev_mac);
            if(dev_ip != null) {
                computeflow(agent_ip, dev_ip, dev_mac, ifindex);
                res++;
            }else{
                System.out.println("mac:" + dev_mac + "无ip绑定信息");
            }
        }

        return res;
    }
    public int flowpackatCount_old(String ip,int flag){
        String destOrsour1  = flag == 0 ? "destination-ip-address" : "source-ip-address" ;
        String destOrsour2 = flag == 0 ? "output-interface":"input-interface";
        String sendXml1 = "<huawei-capture:trace-pkt xmlns:huawei-capture=\"urn:huawei:params:xml:ns:yang:huawei-capture\">\n" +
                "    <huawei-capture:" + destOrsour1 + ">" + ip + "</huawei-capture:" + destOrsour1 +">\n" +
                "    <huawei-capture:timeout>30</huawei-capture:timeout>\n" +
                "  </huawei-capture:trace-pkt>";
        String sendXml2 = "<huawei-capture:get-pkt-trace xmlns:huawei-capture=\"urn:huawei:params:xml:ns:yang:huawei-capture\"/>\n";
        int count = 0;
        try {
            XML send1 = NetconfUtils.send(sendXml1);
            if(!NetconfUtils.parseXml(send1,"data.result").equals("respond")){
                System.out.println(send1);
                return -1;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            XML send2 = NetconfUtils.send(sendXml2);

            List<String> result1 = null;
            List<Integer> result2 = null;
            SAXReader reader = new SAXReader();
            Document doc = reader.read(new StringReader(send2.toString()));
            String xpath = "/xmlns:rpc-reply/xmlns:data/xmlns:" + destOrsour2 + "/xmlns:packet-interface-list";
            List<Object> list = NetconfUtils.parseXml(doc,xpath,"packet-counter");

        } catch (Exception e){
            e.printStackTrace();
        }
            return  count;
    }

    public void test(String filename){
        String sql = "select * from dev_sw_change_info where filename = ?";
        List ret = jdbcUtil.executeQuery(sql,filename);
        if(ret.size() == 0){
            System.out.println("?????????????????");
        }
    }
}
