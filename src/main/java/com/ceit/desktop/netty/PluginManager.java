package com.ceit.desktop.netty;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.grpc.*;
import com.ceit.desktop.plugin.DevicePlugin;
import com.ceit.desktop.plugin.FlowPlugin;
import com.ceit.desktop.plugin.NetManagePlugin;
import com.ceit.desktop.plugin.SoftwarePlugin;
import com.ceit.desktop.service.CertCheckService;
import com.ceit.desktop.service.FlowCheckService;
import com.ceit.desktop.service.NetManageService;
import com.ceit.desktop.service.SoftCheckService;
import com.ceit.desktop.utils.JdbcUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PluginManager {

    private AgentSessionManager _agentManager = null;

    //插件管理
    public static DevicePlugin devicePlugin = null;
    public static SoftwarePlugin softwarePlugin = null;
    public static FlowPlugin flowPlugin = null;
    public static NetManagePlugin netManagePlugin = null;

    //插件类型定义
    private static final int DEV_CHECK = 4;
    private static final int SOFTWARE_CHECK = 5;
    private static final int FLOW_CHECK = 6;
    private static final int NET_MANAGE = 7;
    private static Logger logger = LoggerFactory.getLogger(PluginManager.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();


    public void setAgentSessionManager(AgentSessionManager agentSessionManager) {
        _agentManager = agentSessionManager;
    }

    public void LoadPlugins()
    {
        //硬件插件
        if (devicePlugin == null)
        {
            devicePlugin = new DevicePlugin();
//            devicePlugin.setAgentSessionManager(_agentManager);
//            devicePlugin.setPluginManager(this);
        }

        //软件插件
        if (softwarePlugin == null)
        {
            softwarePlugin = new SoftwarePlugin();
//            softwarePlugin.setAgentSessionManager(_agentManager);
//            softwarePlugin.setPluginManager(this);

        }

        //流量插件
        if (flowPlugin == null)
        {
            flowPlugin = new FlowPlugin();
//            flowPlugin.setAgentSessionManager(_agentManager);
//            flowPlugin.setPluginManager(this);
        }

        //终端网络阻断插件
        if(netManagePlugin == null){
            netManagePlugin = new NetManagePlugin();
        }

    }

    public void NotifyAgentAuthState(AgentSession agent, Boolean authorized){
        if(authorized)
        {
            if (devicePlugin != null)
            {
                devicePlugin.OnLogin(agent);
            }

            if (softwarePlugin != null)
            {
                softwarePlugin.OnLogin(agent);
            }

            if (flowPlugin != null)
            {
                flowPlugin.OnLogin(agent);
            }

            if(netManagePlugin != null)
            {
                netManagePlugin.OnLogin(agent);
            }
        }
        else
        {
            if (devicePlugin != null)
            {
                devicePlugin.OnLogout(agent);
            }

            if (softwarePlugin != null)
            {
                softwarePlugin.OnLogout(agent);
            }

            if (flowPlugin != null)
            {
                flowPlugin.OnLogout(agent);
            }

            if(netManagePlugin != null)
            {
                netManagePlugin.OnLogout(agent);
            }
        }
    }


    public EncoderOrDecoder DispatchPluginMessage(AgentSession agent,int plugin_type, int msg_type, byte[] stream, String clientIP) throws InvalidProtocolBufferException {
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();
        int result = 0;

        switch(plugin_type)
        {
            case DEV_CHECK:
                result = devicePlugin.HardwareCheck(agent,msg_type,stream,clientIP);
                String checkResult = "hardWare check failed";
                if (result == 1){
                    checkResult = "hardWare check success";
                }
                HardwareCheckReply hardwareCheckReply = HardwareCheckReply.newBuilder().setStatus(result).setResult(checkResult).build();
                encoderOrDecoder.setPlugin_type(plugin_type);
                encoderOrDecoder.setMsg_type(1);;
                encoderOrDecoder.setLength(hardwareCheckReply.toByteArray().length);
                encoderOrDecoder.setContent(hardwareCheckReply.toByteArray());
                break;
            case SOFTWARE_CHECK:
                result = softwarePlugin.SoftwareCheck(agent,msg_type,stream,clientIP);
                String SoftCheckResult = "failed";
                int msg_Type = 0;
                if (result == 1){
                    SoftCheckResult = "success";
                    msg_Type = 1;
                }
                if (result == 60 || result == 61 ){
                    msg_Type = 6;
                    if (result == 61 ) {
                        result = 1;
                        SoftCheckResult = "success";
                    } else if (result == 60){
                        result = 0;
                        SoftCheckResult = "success";
                    }

                }
                SoftwareCheckReply softwareCheckReply = SoftwareCheckReply.newBuilder().setStatus(result).setResult(SoftCheckResult).build();
                encoderOrDecoder.setPlugin_type(plugin_type);
                encoderOrDecoder.setMsg_type(msg_Type);
                encoderOrDecoder.setLength(softwareCheckReply.toByteArray().length);
                encoderOrDecoder.setContent(softwareCheckReply.toByteArray());
                break;
            case FLOW_CHECK:
                result = flowPlugin.flowCheck(agent,msg_type,stream,clientIP);
                break;
            case NET_MANAGE:
                //下面的好像不需要了又
                //检查对应dev_ip 是否在线，如果在线说明下发下线指令失败，如果下线则更新在线设备表
                /*
                检查代码以及报错日志
                */
                result = netManagePlugin.TerminalNetReplyHandle(agent,msg_type,stream,clientIP);
                //if(result == 1){        //顺利处理

                //}
                break;
            default:
                logger.debug("plugin_type 异常");
        }
        return encoderOrDecoder;
    }

}
