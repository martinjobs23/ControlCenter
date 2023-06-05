package com.ceit.desktop.grpc.server;


import com.ceit.desktop.grpc.BlacklistPushReply;
import com.ceit.desktop.grpc.controlCenter.*;
import com.ceit.desktop.service.CertCheckService;
import com.ceit.desktop.service.ClientService;
import com.ceit.desktop.service.TerminalPushService;
import com.ceit.desktop.service.WorkOrderService;
import com.ceit.desktop.utils.FileConfigUtil;
import com.ceit.desktop.softmarket.SoftMarketSearch;
import com.ceit.desktop.softmarket.SoftMarketUpload;
import com.ceit.desktop.utils.Result;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class WebGrpcserver extends WebGrpc.WebImplBase {

    private static Logger logger = LoggerFactory.getLogger(WebGrpcserver.class);

    private static CertCheckService certCheckService = new CertCheckService();
    private static SoftMarketSearch softMarketSearch = new SoftMarketSearch();
    private static SoftMarketUpload softMarketUpload = new SoftMarketUpload();
    private static ClientService clientService = new ClientService();
    public WebGrpcserver() {
    }
//    public void StartGrpc(int port) throws IOException {
//        logger.info("Control_Center start Web gRPC listening on " + port);
//        ServerBuilder.forPort(port)
//                .addService(new WebGrpcserver())
//                .build()
//                .start();
//    }

    public void devRegisterCheck(DevRegisterRequest request, StreamObserver<DevRegisterReply> streamObserver){
        Result result  = certCheckService.DevRegister(request);
        streamObserver.onNext(DevRegisterReply.newBuilder().setCode(result.getCode()).setMsg(result.getMsg()).setData((String) result.getData()).build());
        streamObserver.onCompleted();
    }

    public void devUnRegister(DevUnRegisterRequest request, StreamObserver<DevUnRegisterReply> streamObserver){
        String username = request.getUsername();
        String device_mac = request.getDevicaMac();
        Result result = certCheckService.DevUnRegister(username,device_mac);
        streamObserver.onNext(DevUnRegisterReply.newBuilder().setMsg(result.getMsg()).setCode(result.getCode()).setData((String)result.getData()).build());
        streamObserver.onCompleted();
    }

    public void fileDetailByType(FileDetailRequestByType fileDetailRequestbytype, StreamObserver<FileDetailRespone> streamObserver){
        int soft_type = fileDetailRequestbytype.getType();
        List<OneFileDetail> list = softMarketSearch.softSearchByType(soft_type);
        //list.add(OneFileDetail.newBuilder().setDesc("").setFilename("").setSize("").setUrl("").setHash("").setOrg("").build());
        streamObserver.onNext(FileDetailRespone.newBuilder().addAllDetaillist(list).setCount(list.size()).build());
        streamObserver.onCompleted();
    }

    public void fileDetailByName(FileDetailRequestByName fileDetailRequestByname, StreamObserver<FileDetailRespone> streamObserver){
        String sw_name = fileDetailRequestByname.getName();
        List<OneFileDetail> list = softMarketSearch.softSearchByName(sw_name);
        //list.add(OneFileDetail.newBuilder().setDesc("").setFilename("").setSize("").setUrl("").setHash("").setOrg("").build());
        streamObserver.onNext(FileDetailRespone.newBuilder().addAllDetaillist(list).setCount(list.size()).build());
        streamObserver.onCompleted();
    }

    /**
     * 这个地方需要给Java后端返回是否上传成功
     * 需要把返回值给到streamObserver里面
     */
    public void softwareRegister(UploadRequest uploadRequest, StreamObserver<UploadRespond> streamObserver){
        //List<UploadList> list= uploadRequest.getUploadlistList();
        String md5Hash = uploadRequest.getHash();
        Result result = softMarketUpload.softwareRegister(md5Hash);
        streamObserver.onNext(UploadRespond.newBuilder().setCode(result.getCode()).setMsg(result.getMsg()).setData((String) result.getData()).build());
        streamObserver.onCompleted();
//        List<OneFileDetail> list = softMarketSearch.softSearchByName(sw_name);
//        list.add(OneFileDetail.newBuilder().setDesc("").setFilename("").setSize("").setUrl("").setHash("").build());
//        streamObserver.onNext(FileDetailRespone.newBuilder().addAllDetaillist(list).setCount(list.size()).build());
//        streamObserver.onCompleted();
    }

    public void checkVersion(CheckVersionRequest checkVersionRequest, StreamObserver<CheckVersionResponse> streamObserver){
        int major = checkVersionRequest.getMajor();
        int minor = checkVersionRequest.getMinor();
        CheckVersionResponse checkVersionResponse = clientService.checkVersion(major,minor);
        streamObserver.onNext(checkVersionResponse);
        streamObserver.onCompleted();
    }

    public void updatePassword(UpdatePasswordRequest updatePasswordRequest ,StreamObserver<UpdatePasswordResponse> streamObserver){
        UpdatePasswordResponse updatePasswordResponse;
        String username = updatePasswordRequest.getUsername();
        String pwd = updatePasswordRequest.getNewPassword();
        if(pwd.length() == 0){
            updatePasswordResponse = clientService.setDefaultPassword(username);
        }else {
            updatePasswordResponse = clientService.updatePassword(username,pwd);
        }
        streamObserver.onNext(updatePasswordResponse);
        streamObserver.onCompleted();
    }

    public void submitWorkOrder(WorkOrderRequest request, StreamObserver<WorkOrderReply> streamObserver){
        String username = request.getUsernameOrAdmin();
        int type = request.getType();
        String content = request.getContentOrResult();
        String submit_time = request.getSubmitOrProcessTime();
        WorkOrderService workOrderService = new WorkOrderService();
        int res = workOrderService.receiveWorkOrder(username,type,content,submit_time);
        if(res < 0){
            streamObserver.onNext(WorkOrderReply.newBuilder().setStatus(100).setResult("Failed").build());
        }
        else{
            streamObserver.onNext(WorkOrderReply.newBuilder().setStatus(200).setResult("Success").build());
        }
        streamObserver.onCompleted();
    }

    public void processWorkOrder(WorkOrderRequest request, StreamObserver<WorkOrderReply> streamObserver){
        String admin = request.getUsernameOrAdmin();
        int type = request.getType();
        String result = request.getContentOrResult();
        String process_time = request.getSubmitOrProcessTime();
        String serial = request.getSerial();
        WorkOrderService ws = new WorkOrderService();
        int res = ws.processWorkOrder(serial,admin,process_time,result,type);

        if(res > 0){
            streamObserver.onNext(WorkOrderReply.newBuilder().setStatus(200).setResult("Success").build());
        }
        else{
            streamObserver.onNext(WorkOrderReply.newBuilder().setStatus(100).setResult("Failed").build());
        }
        streamObserver.onCompleted();
    }

    public void pushSoftware(pushSoftwareDetail request,  StreamObserver<pushSoftwareReply> streamObserver){
        String sw_name = request.getSwName();
        String sw_url = request.getSwUrl();
        String sw_version = request.getSwVersion();
        String time = request.getTime();

        List<pushDev> list = request.getDevlistList();
        TerminalPushService tps = new TerminalPushService();
        int res = tps.TerminalPushUrlBatch(sw_name,sw_url,sw_url,time,list);
        if(res >= 0){
            streamObserver.onNext(pushSoftwareReply.newBuilder().setStatus(200).setResult("Success").build());
        }
        else{
            streamObserver.onNext(pushSoftwareReply.newBuilder().setStatus(100).setResult("Failed").build());
        }
        streamObserver.onCompleted();
    }
}
