package com.ceit.desktop.utils;

import java.util.List;
import java.util.Map;

public class AgentStatusUtil {

    private JdbcUtil jdbcUtil = new JdbcUtil();

    //测试
    public int insertAgent(String agentId)
    {
        int count = 0;
        //
        String sql1 = "select count(*) from device_cert where dev_id= ?";
        List<Map<String, Object>> flag = jdbcUtil.executeQuery(sql1,agentId);
        if (flag.size()!=0)
        {
            count = 1;
        }
        return count;
    }

    public String selectDevIdByIp(String ip){
        String dev_id = "0000";
        String sql = "select dev_id from device_cert where device_ip = ?";
        List<Map<String, Object>> list = jdbcUtil.executeQuery(sql,ip);
        if (list.size()!=0) {
            for (Map map:list){
                dev_id = (String) map.get("dev_id");
            }
        }
        return dev_id;
    }

    public int updateDeviceStatusById(String agentId,int onlineStatus)
    {
        int count = 0;
        String sql = "update device_cert set online=? where dev_id=?";
        count = jdbcUtil.executeUpdate(sql,onlineStatus,agentId);
        return count;
    }
}
