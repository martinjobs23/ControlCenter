package com.ceit.desktop.service;

import com.ceit.desktop.grpc.CaGrpcClient;
import com.ceit.desktop.grpc.caCenter.*;
import com.ceit.desktop.grpc.controlCenter.DevRegisterRequest;
import com.ceit.desktop.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CertCheckService {

    private static Logger logger = LoggerFactory.getLogger(CertCheckService.class);

    //终端注册
    public Result DevRegister(DevRegisterRequest request){
        int is_handle = request.getIsHandle();
        String serial = request.getSerial();
        String dev_name = request.getDevName();
        String org_id = request.getOrgId();
        String device_ip = request.getDeviceIp();
        System.out.println("is_handle：" + is_handle);
        System.out.println("serial：" + serial);
        System.out.println("dev_name：" + dev_name);
        System.out.println("org_id：" + org_id);
        System.out.println("device_ip：" + device_ip);
        //请求CA中心终端注册接口
        CaGrpcClient caGrpcClient = new CaGrpcClient();
        DeviceRegisteReply deviceRegisteReply = caGrpcClient.stub.deviceRegister(DeviceRegisterRequest.newBuilder().setIsHandle(is_handle).setSerial(serial).setDevName(dev_name).setOrgId(org_id).setDeviceIp(device_ip).build());
        System.out.println("code: "+deviceRegisteReply.getCode());
        System.out.println("data: "+deviceRegisteReply.getData());
        System.out.println("msg: "+deviceRegisteReply.getMsg());
        return new Result(deviceRegisteReply.getMsg(),deviceRegisteReply.getCode(),deviceRegisteReply.getData());
    }

    //硬件注册撤销
    public Result DevUnRegister(String username,String device_mac){
        //请求CA中心终端注册撤销接口
        CaGrpcClient caGrpcClient = new CaGrpcClient();
        DeviceUnRegisteReply deviceUnRegisteReply = caGrpcClient.stub.deviceUnRegister(DeviceUnRegisterRequest.newBuilder().setUsername(username).setDevicaMac(device_mac).build());
        System.out.println("code: "+deviceUnRegisteReply.getStatus());
        System.out.println("data: "+deviceUnRegisteReply.getResult());
        System.out.println("msg: "+deviceUnRegisteReply.getMsg());
        return new Result(deviceUnRegisteReply.getMsg(),deviceUnRegisteReply.getStatus(),deviceUnRegisteReply.getResult());
    }
    //硬件认证（终端主动认证）
    public int HardwareCheck(String deviceHash, String deviceIp){
        //终端请求CA中心硬件认证接口
        CaGrpcClient caGrpcClient =new CaGrpcClient();
        DeviceCheckReply deviceCheckReply = caGrpcClient.stub.deviceCheck(DeviceCheckRequest.newBuilder().setDeviceHash(deviceHash).setDeviceIp(deviceIp).build());
        System.out.println("msg: " + deviceCheckReply.getMsg());
        System.out.println("result: " + deviceCheckReply.getResult());
        System.out.println("status: " + deviceCheckReply.getStatus());
        if (deviceCheckReply.getStatus()==200){
            return 1;
        } else {
            return 0;
        }
    }
}
