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
import java.util.Map;

public class SoftCheckService {
    private static Logger logger = LoggerFactory.getLogger(SoftCheckService.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();

    public int softCheck(int msg_type, byte[] stream,String clientIP) throws InvalidProtocolBufferException {
        System.out.println("msg_type: " + msg_type);
        int result = 0;
        if (msg_type == 0){     //首次上传软件列表
            //反序列化
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i=0;i<list.size();i++){
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String filename = softwareList.getFilename();
                String hash = softwareList.getHash();
                String time = softwareList.getTime();

                //hash值相同的看作同一个软件，不再重复存储
                String checkSql = "select * from dev_sw_info where hash =? and dev_ip=?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash,clientIP);
                if (list1.size()!=0){
                    continue;
                } else {
                    String sql = "insert into dev_sw_info (filename,hash,time,dev_ip ) values(?,?,?,?)";
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,time,clientIP);
                }
            }
            result = 1;
        } else if (msg_type == 1){  //软件认证
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i=0;i<list.size();i++){
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String filename = softwareList.getFilename();
                String hash = softwareList.getHash();
                String time = softwareList.getTime();
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String check_time = simpleDateFormat.format(date);
                System.out.println("filename: " + filename + ", hash: " + hash + ", time: " + time);
                String checkSql = "select * from dev_sw_info where hash =? and dev_ip =?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash,clientIP);
                if (list1.size()==0){
                    String sql = "insert into soft_check_info (soft_name,soft_hash,device_ip,time,check_time,description) values(?,?,?,?,?,?)";
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,clientIP,time,check_time,"此软件未在软件列表");
                    System.out.println("filename: " + filename + "此软件未在软件列表");
                }
            }
            result = 1;
        } else if (msg_type == 2){  //软件更新
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i=0;i<list.size();i++){
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String filename = softwareList.getFilename();
                String hash = softwareList.getHash();
                String time = softwareList.getTime();
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String check_time = simpleDateFormat.format(date);
                System.out.println("filename: " + filename + ", hash: " + hash + ", time: " + time);
                String checkSql = "select * from dev_sw_info where hash =? dev_ip = ?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash,clientIP);
                if (list1.size()==0){
                    String sql = "insert into dev_sw_info (filename,hash,time,dev_ip ) values(?,?,?,?)";
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,time,clientIP);
                }
            }
            result = 1;
        } else if (msg_type == 3){     //首次上传软件运行列表
            //反序列化
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i=0;i<list.size();i++){
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String filename = softwareList.getFilename();
                String hash = softwareList.getHash();
//                String time = softwareList.getTime();
//            System.out.println("filename: " + filename + ", hash: " + hash + ", time: " + time);

                //hash值相同的看作同一个软件，不再重复存储
                String checkSql = "select * from dev_sw_run_info where hash =?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash);
                if (list1.size()!=0){
                    continue;
                } else {
                    String sql = "insert into dev_sw_run_info (softname,hash,dev_ip) values(?,?,?)";
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,clientIP);
                }
            }
            result = 1;
        } else if (msg_type == 9){  //软件运行列表认证
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i=0;i<list.size();i++){
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String filename = softwareList.getFilename();
                String hash = softwareList.getHash();
//                String time = softwareList.getTime();
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String check_time = simpleDateFormat.format(date);
                System.out.println("filename: " + filename + ", hash: " + hash);
                String checkSql = "select * from dev_sw_run_info where hash =?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash);
                if (list1.size()==0){
                    String sql = "insert into soft_check_info (soft_name,soft_hash,device_ip,check_time,description) values(?,?,?,?,?)";
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,clientIP,check_time,"此软件未在软件运行白名单");
                    System.out.println("filename: " + filename + "此软件未在软件运行白名单");
                }
            }
            result = 1;
        } else if (msg_type == 5){  //查询是否已上传全部软件
            String querySql = "select soft_status from device_cert where device_ip =?";
            List<Map<String,Object>> list1 = jdbcUtil.executeQuery(querySql,clientIP);
            int soft_status=0;
            for (Map map:list1){
                soft_status = ((Number) map.get("soft_status")).intValue() ;
            }
            if (soft_status==0){
                return 60;
            } else if (soft_status==1){
                return 61;
            }
        } else if (msg_type == 4){  //全部软件上传完成
            String updateSql = "update device_cert set soft_status = 1 where device_ip =?";
            int res = jdbcUtil.executeUpdate(updateSql,clientIP);
            result = 61;
        }
        return result;
    }
}
