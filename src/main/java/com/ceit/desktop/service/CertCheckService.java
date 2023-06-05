package com.ceit.desktop.service;

import com.ceit.desktop.grpc.CaGrpcClient;
import com.ceit.desktop.grpc.caCenter.*;
import com.ceit.desktop.grpc.controlCenter.DevRegisterRequest;
import com.ceit.desktop.utils.CAUtil;
import com.ceit.desktop.utils.JdbcUtil;
import com.ceit.desktop.utils.PolicyUtil;
import com.ceit.desktop.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CertCheckService {

    private static Logger logger = LoggerFactory.getLogger(CertCheckService.class);

    private JdbcUtil jdbcUtil = new JdbcUtil();
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
        try{
            caGrpcClient.shutdown();
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
        try{
            caGrpcClient.shutdown();
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
        try{
            caGrpcClient.shutdown();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("msg: " + deviceCheckReply.getMsg());
        System.out.println("result: " + deviceCheckReply.getResult());
        System.out.println("status: " + deviceCheckReply.getStatus());
        if (deviceCheckReply.getStatus()==200){
            return 1;
        } else {
            DeviceExeceptionHandle(deviceCheckReply.getMsg(),deviceHash,deviceIp);
            return 0;
        }
    }

    public Result DevRegister_selfCA(DevRegisterRequest request){
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
        String hash = serial.substring(0,31);
        String mac = serial.substring(32,43);
        //请求CA中心终端注册接口
        int ret = CAUtil.gen_CA(hash);
        if(ret == 0){
            System.out.println("gen_CA error");
            return new Result("gen_CA failed",250,"生成证书失败");
        }
        String[] CAInfo = CAUtil.get_CA(hash);
        if(CAInfo == null){
            System.out.println("get_CA error");
            return new Result("get_CA failed",350,"解析证书失败");
        }

        Date date_start = null;
        Date date_end = null;
        try{
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            date_start = ft.parse(CAInfo[4]);
            date_end = ft.parse(CAInfo[5]);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        String sql = "insert into device_cert_cp1 (dev_id,dev_name,username,device_mac,device_ip,org_id,cert_name,cert_time," +
                "cert_sn,cert_csr,cert_cst,cert_key,cert_issuer,start_time,end_time) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        int res = jdbcUtil.executeUpdate(sql,hash,dev_name,hash,mac,device_ip,org_id,hash + "cer.pem",date_start,
                CAInfo[1],serial + "csr.pem","/home/workspace_yzk/CA_CEIT/newcers",serial + "key.pem",CAInfo[3],date_start,date_end);

        return new Result("生成证书",200,res);
    }
    public int test_ca(String hash1){
        int is_handle = 1531;
        String serial = hash1 + "1C2X3F4G5H6J";
        String dev_name = "YZK";
        String org_id = "909";
        String device_ip = "192.168.109.120";
        System.out.println("is_handle：" + is_handle);
        System.out.println("serial：" + serial);
        System.out.println("dev_name：" + dev_name);
        System.out.println("org_id：" + org_id);
        System.out.println("device_ip：" + device_ip);
        String hash = serial.substring(0,31);
        String mac = serial.substring(32,43);
        //请求CA中心终端注册接口
        int ret = CAUtil.gen_CA(hash);
        if(ret == 0){
            System.out.println("gen_CA error");
            return -1;
        }
        String[] CAInfo = CAUtil.get_CA(hash);
        if(CAInfo == null){
            System.out.println("get_CA error");
            return -2;
        }

        Date date_start = null;
        Date date_end = null;
        try{
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            date_start = ft.parse(CAInfo[4]);
            date_end = ft.parse(CAInfo[5]);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        String sql = "insert into device_cert_cp1 (dev_id,dev_name,username,device_mac,device_ip,org_id,cert_name,cert_time," +
                "cert_sn,cert_csr,cert_cst,cert_key,cert_issuer,start_time,end_time,tran_id) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        int res = jdbcUtil.executeUpdate(sql,hash,dev_name,hash,mac,device_ip,org_id,hash + "cer.pem",date_start,
                CAInfo[1],hash + "csr.pem","/home/workspace_yzk/CA_CEIT/newcers",hash + "key.pem",CAInfo[3],date_start,date_end,"tran_id");

        return 0;
    }

    private int updateDevCheckInfo(String msg,String type,String time,String devIp){
        if(msg == "该设备不存在"){
            String sql1 = "insert into dev_check_info_copy1(device_name,device_ip,time,type,description) values(?,?,?,?,?)";
            jdbcUtil.executeUpdate(sql1,"no device_name",devIp,time,type,"该设备不存在");
            return 0;
        }
        else{
            String sqlForIp = "SELECT * FROM device_cert WHERE device_ip = ?";
            List<Map<String,Object>> listForIp=jdbcUtil.executeQuery(sqlForIp,devIp);
            Map<String,Object> mapForIP = listForIp.get(0);
            String insertForIP = "insert into dev_check_info_copy1(device_name,device_ip,time,type,description) values(?,?,?,?,?)";
            jdbcUtil.executeUpdate(insertForIP,mapForIP.get("dev_name"),devIp,time,type,"设备硬件存在异常");
            return 1;
        }
    }

    public void DeviceExeceptionHandle(String msg,String devHash,String devIp){
        int policy = PolicyUtil.getDevPolicy();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        String type = "通知管理员";
        int resupdateDevCheckInfo = 0;
        switch (policy){
            case 0:                 //仅通知管理员
                type = "通知管理员";
                resupdateDevCheckInfo = updateDevCheckInfo(msg,type,time,devIp);
                break;
            case 1:
                type = "阻断入网";
                resupdateDevCheckInfo = updateDevCheckInfo(msg,type,time,devIp);
                if(resupdateDevCheckInfo == 1){
                    //禁止入网
                    String sqlUpdate = "update device_cert set status = 0 where device_ip =?";
                    jdbcUtil.executeUpdate(sqlUpdate,devIp);
                }
                //通知对应ip终端下线
                NetManageService netManageService = new NetManageService();
                netManageService.NotifyTerminalLogoff(msg,devIp,"",0);
                break;
            default:
                break;
        }

    }
}