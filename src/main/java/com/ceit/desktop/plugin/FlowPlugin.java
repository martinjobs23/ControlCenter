package com.ceit.desktop.plugin;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.service.FlowCheckService;
import com.ceit.desktop.service.SoftCheckService;
import com.google.protobuf.InvalidProtocolBufferException;

public class FlowPlugin {

    private FlowCheckService flowCheckService = new FlowCheckService();

    public int OnLogin(AgentSession agent) {
        return 0;
    }

    public int OnLogout(AgentSession agent) {
        return 0;
    }

    //流量认证
    public int flowCheck(AgentSession agent,int msg_type, byte[] stream, String clientIP) throws InvalidProtocolBufferException {
        int result = 0;
        result =flowCheckService.flowCheck(msg_type,stream,clientIP);
        return result;
    }
}
