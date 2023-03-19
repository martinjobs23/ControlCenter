package com.ceit.desktop.plugin;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.grpc.HardwareCheckRequest;
import com.ceit.desktop.service.CertCheckService;
import com.google.protobuf.InvalidProtocolBufferException;

public class DevicePlugin {

    public int OnLogin(AgentSession agent) {
        return 0;
    }

    public int OnLogout(AgentSession agent) {
        return 0;
    }

    //终端注册
    public void DeviceRegister(){
    }

    //硬件认证
    public int HardwareCheck(AgentSession agent,int msg_type, byte[] stream,String clientIP) throws InvalidProtocolBufferException {
        //反序列化
        HardwareCheckRequest hardwareCheckRequest = HardwareCheckRequest.parseFrom(stream);
        CertCheckService certCheckService = new CertCheckService();
        int result = certCheckService.HardwareCheck(hardwareCheckRequest.getHashcode(),clientIP);
        return result;
    }


}
