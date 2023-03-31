package com.ceit.desktop.softmarket;

import com.ceit.desktop.grpc.CaGrpcClient;
import com.ceit.desktop.grpc.caCenter.SoftRegisteReply;
import com.ceit.desktop.grpc.caCenter.SoftRegisterRequest;
import com.ceit.desktop.utils.JdbcUtil;
import com.ceit.desktop.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoftMarketUpload {
    private static Logger logger = LoggerFactory.getLogger(SoftMarketUpload.class);
    private JdbcUtil jdbcUtil = new JdbcUtil();
    // 这个地方需要开始和CA中心进行沟通，申请证书
    public Result softwareRegister(String sha256Hash){    //按类型查找
        System.out.println(sha256Hash);
        if (sha256Hash.equals(null) ||sha256Hash.equals("")){
            return new Result("error",000,"Hash值为空，上传失败。");
        }
        CaGrpcClient caGrpcClient = new CaGrpcClient();
        SoftRegisteReply softRegisteReply = caGrpcClient.stub.softRegister(SoftRegisterRequest.newBuilder().setSoftHash(sha256Hash).build());
        System.out.println("code: "+softRegisteReply.getStatus());
        System.out.println("data: "+softRegisteReply.getResult());
        System.out.println("msg: "+softRegisteReply.getMsg());
        return new Result(softRegisteReply.getMsg(),softRegisteReply.getStatus(),softRegisteReply.getResult());
//      如果申请证书成功，可以直接将uploadList中的内容添加到soft_cert表，如下
//        if(softRegisteReply.getStatus() == 200){
//            filename = uploadList.getFilename();
//            desc = uploadList.getDesc();
//            size = uploadList.getSize();
//            url = uploadList.getUrl();
//            type = uploadList.getType();
//            org = uploadList.getOrg();
//            version = uploadList.getVersion();
//            Date date = new Date(); //獲取當前時間
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            time = simpleDateFormat.format(date);
//            sw_public = uploadList.getPublic();
//            String sql = "insert into soft_cert (sw_name,sw_desc,sw_size,sw_url,sw_hash,sw_type,sw_public,sw_organization,sw_version,sw_time ) values(?,?,?,?,?,?,?,?,?,?)";
//            int res = jdbcUtil.executeUpdate(sql,filename,desc,size,url,hash,type,sw_public,org,version,time);
//            if(res == 0){
//                return new Result("error", 300, "写入数据库失败。");
//            }
//        }
    }
}
