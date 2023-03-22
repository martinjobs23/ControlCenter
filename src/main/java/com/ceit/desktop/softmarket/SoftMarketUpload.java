package com.ceit.desktop.softmarket;

import com.ceit.desktop.grpc.CaGrpcClient;
import com.ceit.desktop.grpc.UploadList;
import com.ceit.desktop.grpc.caCenter.DeviceRegisteReply;
import com.ceit.desktop.grpc.caCenter.DeviceRegisterRequest;
import com.ceit.desktop.grpc.caCenter.SoftRegisteReply;
import com.ceit.desktop.grpc.caCenter.SoftRegisterRequest;
import com.ceit.desktop.utils.JdbcUtil;
import com.ceit.desktop.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SoftMarketUpload {
    private static Logger logger = LoggerFactory.getLogger(SoftMarketUpload.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();
    int result= 0;
    public Result SoftwareUpload(List<UploadList> list){    //按类型查找
        if (list.isEmpty()){
            return new Result("error",000,"列表为空，上传失败。");
        }
//        for (int i = 0; i < list.size(); i++) {
//        }
        UploadList uploadList = list.get(0);
        String hash = uploadList.getHash();
        String filename, desc, size, url, type, org, version, time;
        int sw_public;
//        String checkSql = "select * from soft_cert where sw_hash=?";    //通过hash判断是否为同一个软件
//        List<Map<String,Object>> list1 = jdbcUtil.executeQuery(checkSql,hash);
//            if (list1.isEmpty()){   //list1中没有hash相同的内容，空表
//            }
//            else {
//                filename = uploadList.getFilename();
//                System.out.println(filename + "已在软件超市中。");
//                result = -1;
//            }
        /**
         * 这个地方需要开始和CA中心进行沟通，申请证书
         * 上述部分中檢查hash的內容在CA中心已有重複部分，所以注釋掉了。
         */
        CaGrpcClient caGrpcClient = new CaGrpcClient();
        SoftRegisteReply softRegisteReply = caGrpcClient.stub.softRegister(SoftRegisterRequest.newBuilder().setSoftHash(hash).build());
        System.out.println("code: "+softRegisteReply.getStatus());
        System.out.println("data: "+softRegisteReply.getResult());
        System.out.println("msg: "+softRegisteReply.getMsg());
        //如果申请证书成功，可以直接将uploadList中的内容添加到soft_cert表，如下
        if(softRegisteReply.getStatus() == 200){
            filename = uploadList.getFilename();
            desc = uploadList.getDesc();
            size = uploadList.getSize();
            url = uploadList.getUrl();
            type = uploadList.getType();
            org = uploadList.getOrg();
            version = uploadList.getVersion();
            Date date = new Date(); //獲取當前時間
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = simpleDateFormat.format(date);
            sw_public = uploadList.getPublic();
            String sql = "insert into soft_cert (sw_name,sw_desc,sw_size,sw_url,sw_hash,sw_type,sw_public,sw_organization,sw_version,sw_time ) values(?,?,?,?,?,?,?,?,?,?)";
            int res = jdbcUtil.executeUpdate(sql,filename,desc,size,url,hash,type,sw_public,org,version,time);
            if(res == 0){
                return new Result("error", 300, "写入数据库失败。");
            }
        }
        return new Result(softRegisteReply.getMsg(),softRegisteReply.getStatus(),softRegisteReply.getResult());
        //return result;
    }
}
