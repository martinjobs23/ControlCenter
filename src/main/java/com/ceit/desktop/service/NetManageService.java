package com.ceit.desktop.service;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.grpc.TerminalLogOffReply;
import com.ceit.desktop.grpc.TerminalLogOffRequest;
import com.ceit.desktop.netty.AgentAdminHandler;
import com.ceit.desktop.netty.AgentAdminService;
import com.ceit.desktop.netty.AgentSessionManager;
import com.ceit.desktop.netty.EncoderOrDecoder;
import com.ceit.desktop.utils.AgentStatusUtil;
import com.ceit.desktop.utils.JdbcUtil;
import com.ceit.desktop.utils.NetconfUtils;
import com.google.protobuf.InvalidProtocolBufferException;
import net.juniper.netconf.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NetManageService {
    private static Logger logger = LoggerFactory.getLogger(NetManageService.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();

    private AgentStatusUtil agentStatusUtil = new AgentStatusUtil();
    public static AgentSessionManager agentSessionManager = null;

    public NetManageService(){
        if(agentSessionManager == null){
            agentSessionManager = AgentAdminService.agentSessionManager;
        }
    }
    public int NotifyTerminalLogoff(String msg,String clientIP,String dev_name,int flag){   //flag = 0 管控策略下发  flag = 1 管理员下发
        int result = 0;
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();

        TerminalLogOffReply terminalLogOffReply = TerminalLogOffReply.newBuilder().setStatus(200).setReason(msg).build();
        encoderOrDecoder.setPlugin_type(7);
        encoderOrDecoder.setMsg_type(0);
        encoderOrDecoder.setLength(terminalLogOffReply.toByteArray().length);
        encoderOrDecoder.setContent(terminalLogOffReply.toByteArray());

        //发送给终端
        String agentId = agentStatusUtil.selectDevIdByIp(clientIP);
        AgentSession agent = agentSessionManager.getAgentSessionByAgentId(agentId);
        agent.getContext().write(encoderOrDecoder);

        if(flag == 0){
            return 1;
        }

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String time = ft.format(date);

        //更新下线操作表
        String logoffSql = "insert into dev_check_info (dev_name,dev_ip,time,type,description) values(?,?,?,?,?)";
        result = jdbcUtil.executeUpdate(logoffSql,dev_name,clientIP,time,"阻断",msg);
        return result;
    }

    //更新设备在线表
    public int TerminalStatusChange(String clientIP){
        int result = 0;
        String sql = "update dev_cert set online=? where dev_ip=?";

        //执行sql语句
        result = jdbcUtil.executeUpdate(sql,0,clientIP);
        return  result;
    }

    //交换机禁用mac，前提是知道 IP-MAC关系
    public int BanMAC(String devIp, String agentIp, String description){
        if(agentIp == null)
            agentIp = "192.168.109.223";    //test demo ip
        int res = 0;

        String operation = "添加mac黑名单";

        //查表获得IP-MAC对应关系，获得MAC地址
        String mac = "1c69-7aa4-f0f4";
        String xml = "<edit-config xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\">\n" +
                "  <target>\n" +
                "    <running/>\n" +
                "  </target>\n" +
                "  <config>\n" +
                "    <hw-execute-cli:clis xmlns:hw-execute-cli=\"urn:huawei:params:xml:ns:yang:huawei-execute-cli\">\n" +
                "      <hw-execute-cli:cli>\n" +
                "        <hw-execute-cli:name>cli001</hw-execute-cli:name>\n" +
                "        <hw-execute-cli:execute-cli>\n" +
                "        system-view\n" +
                "mac-address blackhole"+
                mac+ "\n" +
                "</hw-execute-cli:execute-cli>\n" +
                "      </hw-execute-cli:cli>\n" +
                "    </hw-execute-cli:clis>\n" +
                "  </config>\n" +
                "</edit-config>\n";
        try {
            XML send = NetconfUtils.send(xml);
            System.out.println(send);
            if(send.toString().indexOf("ok") != -1)
                res = 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(res == 0){
            operation += " 添加黑名单失败";
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String do_time = simpleDateFormat.format(date);

        String sql = "insert into dev_mac_ban(dev_mac,dev_ip,description,operatiob,time) values(?,?,?,?,?)";
        res = jdbcUtil.executeUpdate(sql,mac,devIp,description,operation,do_time);

        return res;
    }

    //交换机解除禁用mac，前提是知道 IP-MAC关系
    public int UndoBanMAC(String devIp, String agentIp, String description){
        if(agentIp == null)
            agentIp = "192.168.109.223";    //test demo ip
        int res = 0;

        String operation = "取消mac黑名单";

        //查表获得IP-MAC对应关系，获得MAC地址
        String mac = "1c69-7aa4-f0f4";
        String xml = "<edit-config xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\">\n" +
                "  <target>\n" +
                "    <running/>\n" +
                "  </target>\n" +
                "  <config>\n" +
                "    <hw-execute-cli:clis xmlns:hw-execute-cli=\"urn:huawei:params:xml:ns:yang:huawei-execute-cli\">\n" +
                "      <hw-execute-cli:cli>\n" +
                "        <hw-execute-cli:name>cli001</hw-execute-cli:name>\n" +
                "        <hw-execute-cli:execute-cli>\n" +
                "        system-view\n" +
                "undo mac-address blackhole"+
                mac+ "\n" +
                "</hw-execute-cli:execute-cli>\n" +
                "      </hw-execute-cli:cli>\n" +
                "    </hw-execute-cli:clis>\n" +
                "  </config>\n" +
                "</edit-config>\n";
        try {
            XML send = NetconfUtils.send(xml);
            System.out.println(send);
            if(send.toString().indexOf("ok") != -1)
                res = 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(res == 0){
            operation += " 取消黑名单失败";
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String do_time = simpleDateFormat.format(date);

        String sql = "insert into dev_mac_ban(dev_mac,dev_ip,description,operatiob,time) values(?,?,?,?,?)";
        res = jdbcUtil.executeUpdate(sql,mac,devIp,description,operation,do_time);

        return res;
    }

    //查询指定ip的交换机上的端口-mac对应关系  switchIp 交换机ip  firstIf/lastIf 起始/末尾接口号
    public int UpdateSwitchMac(String switchIp, int firstIf, int lastIf){
        //根据交换机ip 获取 netconf 登录账号密码和端口



        //这里没有先按默认的192.168.109.223
        String xml1 = "<huawei-mac:mac-address-table-get xmlns:huawei-mac=\"urn:huawei:params:xml:ns:yang:huawei-mac\"\n" +
                " xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\">\n" +
                "  <huawei-mac:get-num>100</huawei-mac:get-num>\n" +
                "  <huawei-mac:destination-address>\n" +
                "    <huawei-mac:id-type>vlan</huawei-mac:id-type>\n" +
                "    <huawei-mac:id>1</huawei-mac:id>\n" +
                "    <huawei-mac:interface>GigabitEthernet0/0/";
        String xml2 = "</huawei-mac:interface>\n" +
                "    <huawei-mac:search-type>interface</huawei-mac:search-type>\n" +
                "  </huawei-mac:destination-address>\n" +
                "</huawei-mac:mac-address-table-get>";

        String insertsql = "insert into dev_switch_mac(switch_ip,interface,mac) values(?,?,?)";
        int res = 0;

        try{
            for(int i = firstIf ; i <= lastIf ; i++){
                XML send = NetconfUtils.send(xml1 + i + xml2);
                List<String> maclist = NetconfUtils.xml2maclist(send.toString());
                if(maclist == null)
                    continue;
                for(String mac : maclist){
                    res += jdbcUtil.executeUpdate(insertsql,switchIp,i,mac.replace(":","").toUpperCase());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  res;
    }
}
