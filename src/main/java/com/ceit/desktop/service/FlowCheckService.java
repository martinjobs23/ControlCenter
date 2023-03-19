package com.ceit.desktop.service;

import com.ceit.desktop.grpc.SoftwareCheckRequest;
import com.ceit.desktop.grpc.SoftwareList;
import com.ceit.desktop.grpc.TrafficCheckRequest;
import com.ceit.desktop.utils.JdbcUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
}
