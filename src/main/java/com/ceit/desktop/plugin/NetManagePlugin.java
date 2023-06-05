package com.ceit.desktop.plugin;

import com.ceit.desktop.entity.AgentSession;

import com.ceit.desktop.grpc.TerminalLogOffReply;
import com.ceit.desktop.grpc.TerminalLogOffRequest;
import com.ceit.desktop.netty.EncoderOrDecoder;
import com.ceit.desktop.service.NetManageService;
import com.google.protobuf.InvalidProtocolBufferException;


public class NetManagePlugin {
    public int OnLogin(AgentSession agent) {
        return 0;
    }

    public int OnLogout(AgentSession agent) {
        return 0;
    }

    public int TerminalNetReplyHandle(AgentSession agent,int msg_type,byte[] stream,String clientIP) throws InvalidProtocolBufferException{
        int result = 0;
        TerminalLogOffReply terminalLogOffRequest = TerminalLogOffReply.parseFrom(stream);
        String msg = terminalLogOffRequest.getReason();
        int status = terminalLogOffRequest.getStatus();
        NetManageService netManageService = new NetManageService();
        result = netManageService.TerminalStatusChange(clientIP);

        return result;
    }

    public int TerminaleNetBlockAfter(AgentSession agent,String clientIP){
        NetManageService netManageService = new NetManageService();
        int result = netManageService.TerminalStatusChange(clientIP);
        return  result;
    }

    public EncoderOrDecoder TerminalNetBlock(String msg,int status){
        EncoderOrDecoder encoderOrDecoder = new EncoderOrDecoder();
        TerminalLogOffReply terminalLogOffReply = TerminalLogOffReply.newBuilder().setReason(msg).setStatus(status).build();

        encoderOrDecoder.setPlugin_type(7);
        encoderOrDecoder.setMsg_type(0);
        encoderOrDecoder.setLength(terminalLogOffReply.toByteArray().length);
        encoderOrDecoder.setContent(terminalLogOffReply.toByteArray());
        return encoderOrDecoder;
    }
}
