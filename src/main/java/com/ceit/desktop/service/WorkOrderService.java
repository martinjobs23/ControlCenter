package com.ceit.desktop.service;

import com.ceit.desktop.grpc.TerminalConfig;
import com.ceit.desktop.utils.JdbcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WorkOrderService {
    private static Logger logger = LoggerFactory.getLogger(TerminalPushService.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();

    public int receiveWorkOrder(String username, int type, String content, String submit_time){
        String serial = "";
        try{
            DateFormat dft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = dft.parse(submit_time);
            Long datetime = date.getTime() / 100000;
            serial += datetime;
        }catch (Exception e){
            e.printStackTrace();
        }
        Random r = new Random();
        int i = r.nextInt(1000);
        serial += i;
        serial += username;

        String insertsql = "insert into work_order(serial,username,type,content,submit_time,ishandle) values (?,?,?,?,?,?)";
        int res = jdbcUtil.executeUpdate(insertsql,serial,username,type,content,submit_time,0);
        if(res == 0){
            logger.info("新增工单提交记录失败");
            return -1;
        }
        //通知java web后端有新工单



        return 1;
    }

    //工单系统  根据工单中的用户名 获取 ip
    public String getDevipByUsername(String username){
        String sql = "select dev_ip from dev_cert where dev_hash = (SELECT substr(username,1,32) as hash  FROM `radpostauth` where substr(username,33) = ?  order by authdate desc  limit 1)";
        List<Map<String,Object>> l = jdbcUtil.executeQuery(sql,username);
        if(l.size() == 0){
            logger.info("没有查询到ip");
            return null;
        }
        return (String)l.get(0).get("dev_ip");
    }

    public int processWorkOrder(String serial, String admin, String process_time, String result, int type){
        String checksql = "select username,type from work_order where serial = ?";
        List<Map<String,Object>> l1 = jdbcUtil.executeQuery(checksql,serial);

        if(l1.size() == 0){
            logger.info("流水号为"+serial +"的工单不存在不存在");
            return -1;
        }
        String username = (String)l1.get(0).get("username");

        String sql = "update work_order set ishandle = 1,process_time = ?,admin = ?,result = ? where serial = ?";
        int res = jdbcUtil.executeUpdate(sql,process_time,admin,result,serial);

        //通知客户端
        String dev_ip = getDevipByUsername(username);
        if(dev_ip == null){
            logger.info("客户端信息异常，无法通知");
            return -2;
        }

        TerminalPushService terminalPushService = new TerminalPushService();
        terminalPushService.TerminalPushWorkOrder(process_time + " " + admin + " 处理完成： " + result,type,dev_ip);

        return res;
    }

}
