package com.ceit.desktop.service;

import com.ceit.desktop.grpc.controlCenter.CheckVersionResponse;
import com.ceit.desktop.grpc.controlCenter.UpdatePasswordResponse;
import com.ceit.desktop.utils.JdbcUtil;
import com.ceit.desktop.utils.SM4Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ClientService {
    private static Logger logger = LoggerFactory.getLogger(ClientService.class);

    private JdbcUtil jdbcUtil = new JdbcUtil();

    private final String defaultPwd = "123456";

    public CheckVersionResponse checkVersion(int major, int minor){
        String sql = "select * from soft_version where version_major > ? and version_minor > ? order by version_major desc,version_minor desc";

        List<Map<String,Object>> list1 = jdbcUtil.executeQuery(sql,major,minor);
        if(list1.size()!=0){
            Map<String,Object> updateInfo = list1.get(0);
            String url = (String) updateInfo.get("url");
            String soft_name = (String) updateInfo.get("soft_name");
            int v_major = (int) updateInfo.get("version_major");
            int v_minor = (int) updateInfo.get("version_minor");
            return CheckVersionResponse.newBuilder().setMajor(v_major).setMinor(v_minor).setResult(1).setName(soft_name).setUrl(url).build();
        }

        return CheckVersionResponse.newBuilder().setResult(0).build();
    }

    public UpdatePasswordResponse updatePassword(String username,String password){
        String sql1 = "select username from radcheck where username = ?";
        int res = 0;
        String plaintext = SM4Util.decrypt(password,0);
        String value = SM4Util.encrypt(plaintext,1);
        if(value.length() == 0){
            return UpdatePasswordResponse.newBuilder().setResult(0).setStatus("密码解析存储出错").build();
        }
        List list1 = jdbcUtil.executeQuery(sql1,username);
        if(list1.size()!=0){
            String sql2 = "update radcheck set value = ? where username = ?";
            res = jdbcUtil.executeUpdate(sql2,value,username);
            if(res == 0)
                return UpdatePasswordResponse.newBuilder().setResult(0).setStatus("更新密码出错").build();
            else
                return UpdatePasswordResponse.newBuilder().setResult(1).build();
        }

        return UpdatePasswordResponse.newBuilder().setStatus("用户名不存在").setResult(0).build();
    }

    public UpdatePasswordResponse setDefaultPassword(String username){
        String sql1 = "select username from radcheck where username = ?";
        int res = 0;
        List list1 = jdbcUtil.executeQuery(sql1,username);
        if(list1.size() == 0){
            String value = SM4Util.encrypt(defaultPwd,1);
            //System.out.println("plaintext = "+ defaultPwd+"\ncipher = "+value);
            String sql2 = "insert into radcheck (username,value,attribute,op)  values(?,?,?,?)";
            res = jdbcUtil.executeUpdate(sql2,username,value,"Cleartext-Password",":=");
            if(res == 0)
                return UpdatePasswordResponse.newBuilder().setResult(0).setStatus("添加新用户失败").build();
            else
                return UpdatePasswordResponse.newBuilder().setResult(1).build();
        }
        return UpdatePasswordResponse.newBuilder().setResult(0).setStatus("用户已存在").build();
    }
}
