package com.ceit.desktop.softmarket;

import com.ceit.desktop.grpc.*;
import com.ceit.desktop.utils.JdbcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SoftMarketSearch {
    //软件超市查找
    private static Logger logger = LoggerFactory.getLogger(SoftMarketSearch.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();
    public List softSearchByType(int soft_type){    //按类型查找
        String checkSql = "select * from softcheck where soft_type=?";
        List<Map<String,Object>> list1 = jdbcUtil.executeQuery(checkSql,String.valueOf(soft_type));
        if(list1.size() == 0){
            return null;
        }
        List<OneFileDetail> list2 = new ArrayList<>();
        String filename, desc, size, url, hash, org;
        int sw_public;
        for (Map map:list1){
            filename = (String) map.get("sw_name");
            desc = (String) map.get("sw_desc");
            size = (String) map.get("sw_size");
            url = (String) map.get("sw_location");
            hash = (String) map.get("sw_hash");
            org = (String) map.get("sw_organization");
            sw_public = (int) map.get("sw_public");
            if (sw_public == 0){
                list2.add(OneFileDetail.newBuilder().setFilename(filename).setDesc(desc).setSize(size).setUrl("").setHash(hash).setOrg(org).build());
            } else  {
                list2.add(OneFileDetail.newBuilder().setFilename(filename).setDesc(desc).setSize(size).setUrl(url).setHash(hash).setOrg(org).build());
            }
        }
        return list2;
    }
    public List softSearchByName(String sw_name){   //按软件名查找
        String checkSql = "select * from softcheck where sw_name =?";
        List<Map<String,Object>> list1 = jdbcUtil.executeQuery(checkSql,sw_name);
        if(list1.size() == 0){
            return null;
        }
        List<OneFileDetail> list2 = new ArrayList<>();
        String filename, desc, size, url, hash, org;
        int sw_public;
        for (Map map:list1){
            filename = (String) map.get("sw_name");
            desc = (String) map.get("sw_desc");
            size = (String) map.get("sw_size");
            url = (String) map.get("sw_location");
            hash = (String) map.get("sw_hash");
            org = (String) map.get("sw_organization");
            sw_public = (int) map.get("sw_public");
            if (sw_public == 0){
                list2.add(OneFileDetail.newBuilder().setFilename(filename).setDesc(desc).setSize(size).setUrl("").setHash(hash).setOrg(org).build());
            } else  {
                list2.add(OneFileDetail.newBuilder().setFilename(filename).setDesc(desc).setSize(size).setUrl(url).setHash(hash).setOrg(org).build());
            }
        }
        return list2;
    }
}