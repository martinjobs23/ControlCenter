package com.ceit.desktop.softmarket;

import com.ceit.desktop.grpc.controlCenter.OneFileDetail;
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
    public List softSearchByType(int soft_type){    //按类型查找，0为查找所有值
        String checkSql;
        List<Map<String,Object>> list1;
        if (soft_type == 0){
            checkSql = "select * from soft_cert";
            list1 = jdbcUtil.executeQuery(checkSql);
        }else {
            checkSql = "select * from soft_cert where sw_type=?";
            list1 = jdbcUtil.executeQuery(checkSql,String.valueOf(soft_type));
        }
        if(list1.isEmpty()) return null;
        List<OneFileDetail> list2 = new ArrayList<>();
        String filename, desc, size, url, hash, org, sw_public, image;
        for (Map map:list1){
            filename = (String) map.get("sw_name");
            desc = (String) map.get("sw_desc");
            size = (String) map.get("sw_size");
            url = (String) map.get("sw_url");
            hash = (String) map.get("sw_hash");
            org = (String) map.get("sw_organization");
            sw_public = String.valueOf(map.get("sw_public"));
            image = (String) map.get("sw_image");
                list2.add(OneFileDetail.newBuilder().setFilename(filename).setDesc(desc).setSize(size)
                        .setUrl(url).setHash(hash).setOrg(org).setImage(image).build());
        }
        return list2;
    }
    public List softSearchByName(String sw_name){   //按软件名查找
        String checkSql = "select * from soft_cert where sw_name like '%?%'";
        List<Map<String,Object>> list1 = jdbcUtil.executeQuery(checkSql,sw_name);
        if(list1.isEmpty()){
            return null;
        }
        List<OneFileDetail> list2 = new ArrayList<>();
        String filename, desc, size, url, hash, org, image, sw_public;
        for (Map map:list1) {
            filename = (String) map.get("sw_name");
            desc = (String) map.get("sw_desc");
            size = (String) map.get("sw_size");
            url = (String) map.get("sw_url");
            hash = (String) map.get("sw_hash");
            org = (String) map.get("sw_organization");
            sw_public = String.valueOf(map.get("sw_public"));
            image = (String) map.get("sw_image");
//            if (sw_public == "0" || sw_public.equals("0")){
//                list2.add(OneFileDetail.newBuilder().
//                        setFilename(filename).
//                        setDesc(desc).
//                        setSize(size).
//                        setUrl("").
//                        setHash(hash).
//                        setOrg(org).
//                        setImage(image).
//                        build());
//            } else  {
            list2.add(OneFileDetail.newBuilder().
                    setFilename(filename).
                    setDesc(desc).
                    setSize(size).
                    setUrl(url).
                    setHash(hash).
                    setOrg(org).
                    setImage(image).
                    build());
        //}
        }
        return list2;
    }
    public OneFileDetail softSearchByHash(String sw_hash){   //按软件hash查找
        String checkSql = "select * from soft_cert where sw_hash =?";
        List<Map<String,Object>> list1 = jdbcUtil.executeQuery(checkSql,sw_hash);
        if(list1.isEmpty()){
            return null;
        }
        String filename, desc, size, url, hash, org;
        int sw_public;
        Map map = list1.get(0);
        filename = (String) map.get("sw_name");
        desc = (String) map.get("sw_desc");
        size = (String) map.get("sw_size");
        url = (String) map.get("sw_url");
        hash = (String) map.get("sw_hash");
        org = (String) map.get("sw_organization");
        sw_public = (int) map.get("sw_public");
        if (sw_public == 0){
            return OneFileDetail.newBuilder().setFilename(filename).setDesc(desc).setSize(size).setUrl("").setHash(hash).setOrg(org).build();
        } else  {
            return OneFileDetail.newBuilder().setFilename(filename).setDesc(desc).setSize(size).setUrl(url).setHash(hash).setOrg(org).build();
        }

    }
}