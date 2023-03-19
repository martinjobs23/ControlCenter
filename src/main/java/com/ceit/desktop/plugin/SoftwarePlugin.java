package com.ceit.desktop.plugin;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.service.SoftCheckService;
import com.google.protobuf.InvalidProtocolBufferException;

public class SoftwarePlugin {

    private SoftCheckService softCheckService = new SoftCheckService();

    public int OnLogin(AgentSession agent) {
        return 0;
    }

    public int OnLogout(AgentSession agent) {
        return 0;
    }

    //软件认证
    public int SoftwareCheck(AgentSession agent,int msg_type, byte[] stream,String clientIP) throws InvalidProtocolBufferException {
        int result = 0;
        result =softCheckService.softCheck(msg_type,stream,clientIP);
        return result;
    }
}
