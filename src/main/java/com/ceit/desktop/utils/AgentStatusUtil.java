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
        String sql1 = "select count(*) from dev_cert where dev_hash= ?";
        List<Map<String, Object>> flag = jdbcUtil.executeQuery(sql1,agentId);
        if (flag.size()!=0)
        {
            count = 1;
        }
        return count;
    }

    public String selectDevIdByIp(String ip){
        String dev_id = "x";
        String sql = "select dev_hash from dev_cert where dev_ip = ?";
        List<Map<String, Object>> list = jdbcUtil.executeQuery(sql,ip);
        if (list.size()!=0) {
            for (Map map:list){
                dev_id = (String) map.get("dev_hash");
            }
        }
        return dev_id;
    }

    public int updateDeviceStatusById(String agentId,int onlineStatus)
    {
        int count = 0;
        String sql = "update dev_cert set online=? where dev_hash=?";
        count = jdbcUtil.executeUpdate(sql,onlineStatus,agentId);
        return count;
    }

    public int updateDeviceStatusAll(){
        int count = 0;
        String sql = "update dev_cert set online=?";
        count = jdbcUtil.executeUpdate(sql,0);
        return count;
    }
}
