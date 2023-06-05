package com.ceit.desktop.service;

import com.ceit.desktop.grpc.SoftwareCheckReply;
import com.ceit.desktop.grpc.SoftwareCheckRequest;
import com.ceit.desktop.grpc.SoftwareList;
import com.ceit.desktop.utils.CAUtil;
import com.ceit.desktop.utils.JdbcUtil;
import com.ceit.desktop.utils.PolicyUtil;
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
        int swchangePolicy = PolicyUtil.getSwChangePolicy();
        int swrunPolicy = PolicyUtil.getSwRunPolicy();
        int result = 0;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String check_time = simpleDateFormat.format(date);

        if (msg_type == 0){     //首次上传软件列表
            //反序列化
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i=0;i<list.size();i++){
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String filename = softwareList.getFilename();
                String hash = softwareList.getHash();
                String install_time = softwareList.getInstallTime();
                String modify_time = softwareList.getModifyTime();

                //hash值相同的看作同一个软件，不再重复存储
                String checkSql = "select * from dev_sw_info where hash =? and dev_ip=?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash,clientIP);
                if (list1.size()!=0){
                    continue;
                } else {
                 /* Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String check_time = simpleDateFormat.format(date);*/

                    String sql = "insert into dev_sw_info (filename,hash,install_time,update_time,time,dev_ip ) values(?,?,?,?,?,?)";
                    //String sql = "insert into dev_sw_info (filename,hash,install_time,dev_ip ) values(?,?,?,?)";
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,install_time,modify_time,check_time,clientIP);
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
                String install_time = softwareList.getInstallTime();
                String modify_time = softwareList.getModifyTime();
/*                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String check_time = simpleDateFormat.format(date);*/
                System.out.println("filename: " + filename + ", hash: " + hash + ", time: " + install_time);
                String checkSql = "select * from dev_sw_info where hash =? and dev_ip =?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash,clientIP);
                if (list1.size()==0){
                    String sql = "insert into soft_check_info (soft_name,soft_hash,dev_ip,time,check_time,description) values(?,?,?,?,?,?)";
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,clientIP,install_time,check_time,"此软件未在软件列表");
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
                String install_time = softwareList.getInstallTime();
                String modify_time = softwareList.getModifyTime();

/*                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String check_time = simpleDateFormat.format(date);*/

                System.out.println("filename: " + filename + ", hash: " + hash + ", time: " + modify_time);

                String checkSql = "select * from dev_sw_info where hash =? and dev_ip = ?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash,clientIP);
                if (list1.size()==0){
                    /*String sql = "insert into dev_sw_info (filename,hash,install_time,update_time,time,dev_ip ) values(?,?,?,?,?,?)";
                    //String sql = "insert into dev_sw_run_info (filename,hash,time,dev_ip) values(?,?,?,?)"
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,install_time,modify_time,check_time,clientIP);*/
                    SoftChangeExceptionHandle(filename,hash,install_time,modify_time,swchangePolicy,check_time,clientIP);
                }
            }
            //更新统计表
            updateCountTable(0);
            result = 1;
        } else if (msg_type == 3){     //上传软件运行列表
            //反序列化
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i=0;i<list.size();i++){
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String filename = softwareList.getFilename();
                String hash = softwareList.getHash();
//                String time = softwareList.getTime();
//            System.out.println("filename: " + filename + ", hash: " + hash + ", time: " + time);

/*                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String check_time = simpleDateFormat.format(date);*/

                //hash值相同的看作同一个软件，不再重复存储
                String checkSql = "";
                List list1 = null;
                //  此时为对比进程运行黑名单策略
                if(swrunPolicy >= 2){
                    checkSql = "select * from dev_blacklist_process where hash =? or filename = ?";
                    list1 = jdbcUtil.executeQuery(checkSql,hash,filename);
                }else{
                    checkSql = "select * from dev_sw_info_copy1 where hash =? and dev_ip = ?";
                    list1 = jdbcUtil.executeQuery(checkSql,hash,clientIP);
                }

                if (list1.size()!=0){
                    continue;
                } else {
                    //String sql = "insert into dev_sw_run_info (softname,hash,dev_ip) values(?,?,?)";
                    //int res = jdbcUtil.executeUpdate(sql,filename,hash,clientIP);
                    SoftRunExceptionHandle(filename,hash,check_time,clientIP,swrunPolicy);
                }
            }
            //更新统计表
            updateCountTable(1);
            result = 1;
        } else if (msg_type == 19){  //软件运行列表认证
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i=0;i<list.size();i++){
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String filename = softwareList.getFilename();
                String hash = softwareList.getHash();
//                String time = softwareList.getTime();
/*                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String check_time = simpleDateFormat.format(date);*/
                System.out.println("filename: " + filename + ", hash: " + hash);
                String checkSql = "select * from dev_sw_run_info where hash =?";
                List list1 = jdbcUtil.executeQuery(checkSql,hash);
                if (list1.size()==0){
                    String sql = "insert into soft_check_info (soft_name,soft_hash,dev_ip,check_time,description) values(?,?,?,?,?)";
                    int res = jdbcUtil.executeUpdate(sql,filename,hash,clientIP,check_time,"此软件未在软件运行白名单");
                    System.out.println("filename: " + filename + "此软件未在软件运行白名单");
                }
            }
            result = 1;
        } else if (msg_type == 5){  //查询是否已上传全部软件
            String querySql = "select soft_status from dev_cert where dev_ip =?";
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
            String updateSql = "update dev_cert set soft_status = 1 where dev_ip =?";
            int res = jdbcUtil.executeUpdate(updateSql,clientIP);
            result = 61;
        }else if (msg_type == 8) {
            //反序列化
            SoftwareCheckRequest softwareCheckRequest = SoftwareCheckRequest.parseFrom(stream);
            List list = softwareCheckRequest.getSoftwareList();
            for (int i = 0; i < list.size(); i++) {
                SoftwareList softwareList = (SoftwareList) list.get(i);
                String regedit_key = softwareList.getFilename();
                String regedit_value = softwareList.getHash();
                System.out.println("key:" + regedit_key + " value:" + regedit_value);
                String checkSql = "select * from dev_blacklist_selfstart where instr(?,key_value)>0 or instr(?,key_value)>0";
                List<Map<String,Object>> list1 = jdbcUtil.executeQuery(checkSql, regedit_key, regedit_value);
                if (list1.size() != 0) {
                    //有黑名单中的自启动项
                    String black = (String)(list1.get(0).get("key_value"));
                    String insertsql = "insert into dev_blacklist_record (dev_ip,type,detail,time) values(?,?,?,?)";
                    result = jdbcUtil.executeUpdate(insertsql,clientIP,3,black,check_time);
                } else {
                    //String sql = "insert into dev_sw_run_info (softname,hash,dev_ip) values(?,?,?)";
                    //int res = jdbcUtil.executeUpdate(sql,filename,hash,clientIP);

                }
            }
            testpush(clientIP);
        }else if(msg_type == 14) {            //抓包程序上传违规ip访问
            SoftwareCheckReply sc = SoftwareCheckReply.parseFrom(stream);
            String ip = sc.getResult();
            //System.out.println("====================="+ip);
            String sql = "insert into dev_blacklist_record (dev_ip,type,detail,time) values(?,?,?,?)";
            result = jdbcUtil.executeUpdate(sql,clientIP,0,ip,check_time);
        }else if(msg_type == 15) {              //抓包程序上传违规url访问
            SoftwareCheckReply sc = SoftwareCheckReply.parseFrom(stream);
            String url = sc.getResult();
            //System.out.println("====================="+url);
            String sql = "insert into dev_blacklist_record (dev_ip,type,detail,time) values(?,?,?,?)";
            result = jdbcUtil.executeUpdate(sql,clientIP,1,url,check_time);
        }
        return result;
    }

    public int softCertificate(String filename,String hash,String clientIP){
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

        //String sql = "insert into dev_sw_info (filename,hash,time,dev_ip ) values(?,?,?,?)";

        return 1;
    }

    public void SoftChangeExceptionHandle(String filename,String hash,String install_time,String modify_time,int policy,String time,String devIp){
        //筛除重复记录部分
        Date date = new Date();
        long ltime = date.getTime();
        Date dateplus = new Date();
        dateplus.setTime(ltime + 1000 * 60 * 60 * 24);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time1 = simpleDateFormat.format(date);
        String time2 = simpleDateFormat.format(dateplus);

        String checksql = "select * from dev_sw_change_info where time >= ? and time < ? and dev_ip = ? and hash = ?";
        List list = jdbcUtil.executeQuery(checksql,time1,time2,devIp,hash);
        if(list.size()!=0){
            return;
        }

        String type = "通知管理员";
        String sql1 = "insert into dev_sw_change_info(filename,hash,install_time,update_time,time,dev_ip,operation,isHandle) values(?,?,?,?,?,?,?,?)";
        int res = 0;
        switch (policy){
            case 0:                 //仅通知管理员
                type = "通知管理员";

                res = jdbcUtil.executeUpdate(sql1,filename,hash,install_time,modify_time,time,devIp,type,0);
                break;
            case 1:
                type = "阻断入网";
                res = jdbcUtil.executeUpdate(sql1,filename,hash,install_time,modify_time,time,devIp,type,0);
                String sqlUpdate = "update device_cert set status = 0 where device_ip =?";
                jdbcUtil.executeUpdate(sqlUpdate,devIp);
                //通知对应ip终端下线
                NetManageService netManageService = new NetManageService();
                netManageService.NotifyTerminalLogoff("新增软件未在白名单内",devIp,"",0);
                break;
            case 2:                 //直接加入白名单
                type = "直接加入软件列表";
                res = jdbcUtil.executeUpdate(sql1,filename,hash,install_time,modify_time,time,devIp,type,1);
                String sql2 = "insert into dev_sw_info (filename,hash,install_time,update_time,time,dev_ip ) values(?,?,?,?,?,?)";
                res = jdbcUtil.executeUpdate(sql2,filename,hash,install_time,modify_time,time,devIp);
            default:
                break;
        }
    }
    public void SoftRunExceptionHandle(String softname,String hash,String time,String devIp,int policy){
        String add = "";
        if(policy >= 2){
            policy = policy - 1;
            add = "(黑名单策略)";
        }

        //筛除重复记录部分
        Date date = new Date();
        long ltime = date.getTime();
        Date dateplus = new Date();
        dateplus.setTime(ltime + 1000 * 60 * 60 * 24);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time1 = simpleDateFormat.format(date);
        String time2 = simpleDateFormat.format(dateplus);

        String checksql = "select * from dev_sw_run_info where time >= ? and time < ? and dev_ip = ? and hash = ?";
        List list = jdbcUtil.executeQuery(checksql,time1,time2,devIp,hash);
        if(list.size()!=0){
            return;
        }

        String type = "通知管理员";
        String sql1 = "insert into dev_sw_run_info (filename,hash,time,dev_ip,operation,isHandle) values(?,?,?,?,?,?)";
        int res = 0;
        switch (policy){
            case 0:
                type = "通知管理员" + add;
                res = jdbcUtil.executeUpdate(sql1,softname,hash,time,devIp,type,0);
                break;
            case 1:
                type = "阻断入网" + add;
                res = jdbcUtil.executeUpdate(sql1,softname,hash,time,devIp,type,0);
                String sqlUpdate = "update device_cert set status = 0 where device_ip =?";
                jdbcUtil.executeUpdate(sqlUpdate,devIp);
                //通知对应ip终端下线
                NetManageService netManageService = new NetManageService();
                netManageService.NotifyTerminalLogoff("运行软件列表出现非法软件",devIp,"",0);

                break;
            default:
                break;
        }

    }

    public void updateCountTable(int flag){
        Date date = new Date();
        long ltime = date.getTime();
        Date dateplus = new Date();
        dateplus.setTime(ltime + 1000 * 60 * 60 * 24);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time1 = simpleDateFormat.format(date);
        String time2 = simpleDateFormat.format(dateplus);

        if(flag == 0){
            String countsql = "select dev_ip,count(*) as sw_count from dev_sw_change_info where time >= ? and time < ? group by dev_ip";
            String checksql = "select * from dev_sw_change_statistic where time = ? and dev_ip = ?";
            String insertsql = "insert into dev_sw_change_statistic(dev_ip,sw_count,time) values(?,?,?)";
            String updatesql = "update dev_sw_change_statistic set sw_count = ? where dev_ip = ? and time = ?";
            List<Map<String,Object>> list1 = jdbcUtil.executeQuery(countsql,time1,time2);
            if(list1.size() == 0){
                return;
            }
            else{
                for(Map map:list1){
                    String devIp = (String)map.get("dev_ip");
                    int count = ((Number) map.get("sw_count")).intValue();
                    List list2 = jdbcUtil.executeQuery(checksql,time1,devIp);
                    if(list2.size() == 0){
                        int res = jdbcUtil.executeUpdate(insertsql,devIp,count,time1);
                    }
                    else{
                        int res = jdbcUtil.executeUpdate(updatesql,count,devIp,time1);
                    }
                }
            }

        }
        else if(flag == 1){
            String countsql = "select dev_ip,count(*) as sw_count from dev_sw_run_info where time >= ? and time < ? group by dev_ip";
            String checksql = "select * from dev_sw_run_statistic where time = ? and dev_ip = ?";
            String insertsql = "insert into dev_sw_run_statistic(dev_ip,illegal_run_count,time) values(?,?,?)";
            String updatesql = "update dev_sw_run_statistic set illegal_run_count = ? where dev_ip = ? and time = ?";
            List<Map<String,Object>> list1 = jdbcUtil.executeQuery(countsql,time1,time2);
            if(list1.size() == 0){
                return;
            }
            else{
                for(Map map:list1){
                    String devIp = (String)map.get("dev_ip");
                    int count = ((Number) map.get("sw_count")).intValue();
                    List list2 = jdbcUtil.executeQuery(checksql,time1,devIp);
                    if(list2.size() == 0){
                        int res = jdbcUtil.executeUpdate(insertsql,devIp,count,time1);
                    }
                    else{
                        int res = jdbcUtil.executeUpdate(updatesql,count,devIp,time1);
                    }
                }
            }
        }
    }

    //管理员处理告警记录
    public int SoftChangeExceptionManagerHandle(String filename,String hash,String install_time,String modify_time,String time,String dev_ip,int flag){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String check_time = simpleDateFormat.format(date);

        String type = "加入软件列表";
        if(flag == 0)
            type = "禁止该新增软件";

        String updatesql = "update dev_sw_change_info set operation = ?, isHandle = ?, time = ? " +
                "where dev_ip = ? and filename = ? and hash = ? and install_time = ? and update_time = ? and time = ? and isHandle = 0";
        String insertsql = "insert into dev_sw_info (filename,hash,install_time,update_time,time,dev_ip ) values(?,?,?,?,?,?)";
        String checksql = "select * from dev_sw_change_info where dev_ip = ? and filename = ? and hash = ? and install_time = ? and update_time = ? and time = ? and isHandle = 0";

        List list1 = jdbcUtil.executeQuery(checksql,dev_ip,filename,hash,install_time,modify_time,time);
        if(list1.size() == 0){
            System.out.println("filename:" + filename +"记录不存在");
            return 0;
        }

        int res = jdbcUtil.executeUpdate(updatesql,type,1,check_time,dev_ip,filename,hash,install_time,modify_time,time);
        if(res == 1 && flag == 1)
            res = jdbcUtil.executeUpdate(insertsql,filename,hash,install_time,modify_time,check_time,dev_ip);
        else if(res == 1 && flag == 0){
            //下线操作
            NetManageService netManageService = new NetManageService();
            netManageService.NotifyTerminalLogoff("不允许某些新增软件",dev_ip,"",0);
        }
        else if(res == 0){
            System.out.println("记录不存在");
            return 0;
        }

        return res;
    }

    //管理员处理进程告警
    public int SoftRunExceptionManagerHandle(String filename,String hash,String time,String dev_ip,int flag){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String check_time = simpleDateFormat.format(date);

        String type = "允许运行";
        if(flag == 0)
            type = "不允许运行";

        String updatesql = "update dev_sw_run_info set operation = ?, isHandle = ?, time = ? " +
                "where dev_ip = ? and filename = ? and hash = ? and time = ? and isHandle = 0";
        //String insertsql = "insert into dev_sw_info (filename,hash,install_time,update_time,time,dev_ip ) values(?,?,?,?,?,?)";
        String checksql = "select * from dev_sw_run_info where dev_ip = ? and filename = ? and hash = ? and time = ? and isHandle = 0";

        List list1 = jdbcUtil.executeQuery(checksql,dev_ip,filename,hash,time);
        if(list1.size() == 0){
            System.out.println("filename:" + filename +"记录不存在");
            return 0;
        }

        int res = jdbcUtil.executeUpdate(updatesql,type,1,check_time,dev_ip,filename,hash,time);
        //if(res == 1 && flag == 1)
            //res = jdbcUtil.executeUpdate(insertsql,filename,hash,check_time,devIp);
        if(res == 1 && flag == 0){
            //下线操作
            NetManageService netManageService = new NetManageService();
            netManageService.NotifyTerminalLogoff("不允许运行不在软件列表的软件",dev_ip,"",0);
        }
        else if(res == 0){
            System.out.println("记录不存在");
            return 0;
        }

        return res;
    }

    public int testpush(String dev_ip){

        TerminalPushService tm = new TerminalPushService();
        tm.TerminalPushUrl("微信","www.yuanshen.com",dev_ip);
        //tm.TerminalPushBlacklist(7,dev_ip);
        //tm.TerminalPushConfig(0,0,300,300,300,dev_ip);
        tm.TerminalPushWorkOrder("2023-05-18 17:00:00 admin 处理完成: ddddddd",1,dev_ip);
        //tm.TerminalPushBlacklist(4,devIp,l1);
       // tm.TerminalPushBlacklist(5,devIp,l4);
        //tm.TerminalPushBlacklist(6,devIp,l2);
        //tm.TerminalPushBlacklist(7,devIp,l3);

        return 0;
    }
}
