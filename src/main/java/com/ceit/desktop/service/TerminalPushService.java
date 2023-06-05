package com.ceit.desktop.service;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.grpc.*;
import com.ceit.desktop.grpc.controlCenter.pushDev;
import com.ceit.desktop.netty.AgentAdminService;
import com.ceit.desktop.netty.AgentSessionManager;
import com.ceit.desktop.netty.EncoderOrDecoder;
import com.ceit.desktop.utils.AgentStatusUtil;
import com.ceit.desktop.utils.JdbcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class TerminalPushService {
    private static Logger logger = LoggerFactory.getLogger(TerminalPushService.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();

    private static final int DEVICE = 1;
    private static final int SOFTWARE = 2;
    private static final int TRAFFIC = 3;

    private static final int IP = 4;
    private static final int URL = 5;
    private static final int PROCESS = 6;
    private static final int SELFSTART = 7;

    private AgentStatusUtil agentStatusUtil = new AgentStatusUtil();
    public static AgentSessionManager agentSessionManager = null;

    public TerminalPushService(){
        if(agentSessionManager == null){
            agentSessionManager = AgentAdminService.agentSessionManager;
        }
    }
    //主动采集dev_ip对应终端信息
    public int TerminalCollect(int type,String dev_ip){
        int result = 0;
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();
        switch (type)
        {
            case DEVICE:
                //硬件采集
                HardwareCheckReply hardwareCheckReply = HardwareCheckReply.newBuilder().setStatus(200).setResult("Collect device info again").build();
                encoderOrDecoder.setPlugin_type(4);
                encoderOrDecoder.setMsg_type(2);
                encoderOrDecoder.setLength(hardwareCheckReply.toByteArray().length);
                encoderOrDecoder.setContent(hardwareCheckReply.toByteArray());

                break;
            case SOFTWARE:
                //软件采集
                /*SoftwareCheckReply 1 softwareCheckReply = SoftwareCheckReply.newBuilder().setStatus(200).setResult("Collect software info again").build();
                encoderOrDecoder.setPlugin_type(5);
                encoderOrDecoder.setMsg_type(7);
                encoderOrDecoder.setLength(softwareCheckReply.toByteArray().length);
                encoderOrDecoder.setContent(softwareCheckReply.toByteArray());*/

                break;
            case TRAFFIC:
                //流量采集
                break;
            default:
                logger.debug("type 异常");
        }
        //发送采集指令 send to dev_ip
        String agentId = agentStatusUtil.selectDevIdByIp(dev_ip);
        AgentSession agent = agentSessionManager.getAgentSessionByAgentId(agentId);
        agent.getContext().write(encoderOrDecoder);

        return result;
    }

    public int TerminalPushBlacklist(int type, String dev_ip){
        String sql1 = "select * from dev_blacklist_ip";
        String sql2 = "select * from dev_blacklist_url";
        String sql3 = "select * from dev_blacklist_process";
        String sql4 = "select * from dev_blacklist_selfstart";

        int result = 0;
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();
        int len;
        List<SoftwareList> l;
        SoftwareCheckRequest sq;
        String black = "";
        switch(type)
        {
            case IP:
                List<Map<String,Object>> l1 = jdbcUtil.executeQuery(sql1);
                len = l1.size();
                String ipandip = "";
                int i = 0;
                for(i = 0 ; i < len-1; i++){
                    ipandip = ipandip + "host " + l1.get(i).get("black_ip") + " or ";
                }
                ipandip = ipandip + "host " + l1.get(i).get("black_ip");
                SoftwareCheckReply softwareCheckReply = SoftwareCheckReply.newBuilder().setStatus(11).setResult(ipandip).build();
                encoderOrDecoder.setPlugin_type(5);
                encoderOrDecoder.setMsg_type(11);
                encoderOrDecoder.setLength(softwareCheckReply.toByteArray().length);
                encoderOrDecoder.setContent(softwareCheckReply.toByteArray());
                black = "ip";
                break;
            case URL:
                List<Map<String,Object>> l2 = jdbcUtil.executeQuery(sql2);
                len = l2.size();
                l = new ArrayList<>(len);
                for(Map<String,Object>map : l2){
                    SoftwareList sl = SoftwareList.newBuilder().setHash("x").setFilename((String)map.get("black_url")).setInstallTime("0").setModifyTime("1").build();
                    l.add(sl);
                }
                sq = SoftwareCheckRequest.newBuilder().addAllSoftware(l).build();
                encoderOrDecoder.setPlugin_type(5);
                encoderOrDecoder.setMsg_type(12);
                encoderOrDecoder.setLength(sq.toByteArray().length);
                encoderOrDecoder.setContent(sq.toByteArray());
                black = "url";
                break;
            case PROCESS:
                List<Map<String,Object>> l3 = jdbcUtil.executeQuery(sql3);
                len = l3.size();
                l = new ArrayList<>(len);
                for(Map<String,Object>map : l3){
                    SoftwareList sl = SoftwareList.newBuilder().setHash("Hash:" + map.get("hash")).setFilename("filename" + map.get("filename")).setInstallTime("0").setModifyTime("1").build();
                    l.add(sl);
                }
                sq = SoftwareCheckRequest.newBuilder().addAllSoftware(l).build();
                encoderOrDecoder.setPlugin_type(5);
                encoderOrDecoder.setMsg_type(10);
                encoderOrDecoder.setLength(sq.toByteArray().length);
                encoderOrDecoder.setContent(sq.toByteArray());
                black = "process";
                break;
            case SELFSTART:
                List<Map<String,Object>> l4 = jdbcUtil.executeQuery(sql4);
                len = l4.size();
                l = new ArrayList<>(len);
                for(Map<String,Object>map : l4){
                    SoftwareList sl = SoftwareList.newBuilder().setFilename((String)map.get("key_value")).setHash("x").setInstallTime("0").setModifyTime("1").build();
                    l.add(sl);
                }
                sq = SoftwareCheckRequest.newBuilder().addAllSoftware(l).build();
                encoderOrDecoder.setPlugin_type(5);
                encoderOrDecoder.setMsg_type(9);
                encoderOrDecoder.setLength(sq.toByteArray().length);
                encoderOrDecoder.setContent(sq.toByteArray());
                black = "selfstart";
                break;
            default:
                return -1;
        }

        //发送黑名单 send to dev_ip
        String agentId = agentStatusUtil.selectDevIdByIp(dev_ip);
        AgentSession agent = agentSessionManager.getAgentSessionByAgentId(agentId);
        agent.getContext().write(encoderOrDecoder);

        TerminalPushRecord(4,"下发"+black+"黑名单",dev_ip);

        return result;
    }

    public int TerminalPushUrl(String filename, String url, String dev_ip){
        int res = 0;
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();
        SoftwareList sl = SoftwareList.newBuilder().setFilename(filename).setHash(url).setInstallTime("x").setModifyTime("x").build();
        encoderOrDecoder.setPlugin_type(5);
        encoderOrDecoder.setMsg_type(13);
        encoderOrDecoder.setLength(sl.toByteArray().length);
        encoderOrDecoder.setContent(sl.toByteArray());

        //发送url 给 dev_ip
        String agentId = agentStatusUtil.selectDevIdByIp(dev_ip);
        AgentSession agent = agentSessionManager.getAgentSessionByAgentId(agentId);
        agent.getContext().write(encoderOrDecoder);

        TerminalPushRecord(3,filename + url,dev_ip);

        return res;
    }

    public int TerminalPushConfig(int sw_change, int sw_ps, int sw_change_c, int sw_ps_c, int device_c, String dev_ip){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String change_time = simpleDateFormat.format(date);

        int res = 0;
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();
        TerminalConfig tc = TerminalConfig.newBuilder().setDeviceC(device_c).setSwChangeC(sw_change_c).setSwPsC(sw_ps_c).setSwChange(sw_change).setSwPs(sw_ps).build();
        encoderOrDecoder.setPlugin_type(7);
        encoderOrDecoder.setMsg_type(2);
        encoderOrDecoder.setLength(tc.toByteArray().length);
        encoderOrDecoder.setContent(tc.toByteArray());

        //发送config 给 dev_ip
        String agentId = agentStatusUtil.selectDevIdByIp(dev_ip);
        AgentSession agent = agentSessionManager.getAgentSessionByAgentId(agentId);
        agent.getContext().write(encoderOrDecoder);

        String sql = "select * from dev_config where dev_ip = ?";
        String updatesql = "update dev_config set device_c = ?, sw_change_c = ?, sw_ps_c = ?, sw_change = ?, sw_ps = ?, time = ? where dev_ip = ?";
        String insertsql = "insert into dev_config(device_c, sw_change_c, sw_ps_c, sw_change, sw_ps, dev_ip, time) values(?,?,?,?,?,?,?)";
        List l1 = jdbcUtil.executeQuery(sql,dev_ip);
        if(l1.size() == 0){
            res = jdbcUtil.executeUpdate(insertsql,device_c,sw_change_c,sw_ps_c,sw_change,sw_ps,dev_ip,change_time);
        }else{
            res = jdbcUtil.executeUpdate(updatesql,device_c,sw_change_c,sw_ps_c,sw_change,sw_ps,change_time,dev_ip);
        }

        TerminalPushRecord(2,tc.toString(),dev_ip);

        return res;
    }

    //通知客户端工单处理
    public int TerminalPushWorkOrder(String workorder, int type, String dev_ip){
        int res = 0;
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();
        TerminalNotice tn = TerminalNotice.newBuilder().setType(type).setMsg(workorder).build();
        encoderOrDecoder.setPlugin_type(7);
        encoderOrDecoder.setMsg_type(3);
        encoderOrDecoder.setLength(tn.toByteArray().length);
        encoderOrDecoder.setContent(tn.toByteArray());

        //发送 给 dev_ip
        String agentId = agentStatusUtil.selectDevIdByIp(dev_ip);
        AgentSession agent = agentSessionManager.getAgentSessionByAgentId(agentId);
        agent.getContext().write(encoderOrDecoder);

        TerminalPushRecord(1,workorder,dev_ip);

        return res;
    }

    public int TerminalPushNotice(String msg, int type, String dev_ip){
        int res = 0;
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();
        TerminalNotice tn = TerminalNotice.newBuilder().setType(type).setMsg(msg).build();
        encoderOrDecoder.setPlugin_type(7);
        encoderOrDecoder.setMsg_type(3);
        encoderOrDecoder.setLength(tn.toByteArray().length);
        encoderOrDecoder.setContent(tn.toByteArray());

        //发送url 给 dev_ip
        String agentId = agentStatusUtil.selectDevIdByIp(dev_ip);
        AgentSession agent = agentSessionManager.getAgentSessionByAgentId(agentId);
        agent.getContext().write(encoderOrDecoder);

        TerminalPushRecord(0,msg,dev_ip);

        return res;
    }

    private int TerminalPushRecord(int type, String msg, String dev_ip){
        int res = 0;
        String sql = "insert into dev_push_record(type,content,dev_ip,time) values (?,?,?,?)";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String check_time = simpleDateFormat.format(date);

        res = jdbcUtil.executeUpdate(sql,type,msg,dev_ip,check_time);

        return res;
    }

    public int TerminalPushUrlBatch(String sw_name, String sw_url, String sw_version, String time , List<pushDev> list){
        int res = 0;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date dstdate = simpleDateFormat.parse(time);
            Long now = date.getTime();
            Long dst = dstdate.getTime();
            Long num = (dst - now);
            num = num <=0 ? 0 : num;
            Timer timer = new Timer();
            timer.schedule((new TimerTask() {
                @Override
                public void run() {
                    for(pushDev pd : list){
                        String dev_ip = pd.getDevIp();
                        TerminalPushUrl(sw_name,sw_url,dev_ip);
                    }
                }
            }),num);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

        return res;
    }
}
