package com.ceit.desktop.grpc.server;

import com.ceit.desktop.grpc.controlCenter.*;
import com.ceit.desktop.service.CertCheckService;
import com.ceit.desktop.service.SayHelloService;
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
    private static SayHelloService sayHelloService = new SayHelloService();

    public WebGrpcserver() {
    }

    public void StartGrpc(int port) throws IOException {
        logger.info("Control_Center start Web gRPC listening on " + port);
        ServerBuilder.forPort(port)
                .addService(new WebGrpcserver())
                .build()
                .start();
    }
    public void fileDetailByType(FileDetailRequestByType fileDetailRequestbytype, StreamObserver<FileDetailRespone> streamObserver){
        int soft_type = fileDetailRequestbytype.getType();
        List<OneFileDetail> list = softMarketSearch.softSearchByType(soft_type);
        //list.add(OneFileDetail.newBuilder().setDesc("").setFilename("").setSize("").setUrl("").setHash("").setOrg("").build());
        streamObserver.onNext(FileDetailRespone.newBuilder().addAllDetaillist(list).setCount(list.size()).build());
        streamObserver.onCompleted();
    }

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



    public void fileDetailByName(FileDetailRequestByName fileDetailRequestByname, StreamObserver<FileDetailRespone> streamObserver){
        String sw_name = fileDetailRequestByname.getName();
        List<OneFileDetail> list = softMarketSearch.softSearchByName(sw_name);
        list.add(OneFileDetail.newBuilder().setDesc("").setFilename("").setSize("").setUrl("").setHash("").setOrg("").build());
        streamObserver.onNext(FileDetailRespone.newBuilder().addAllDetaillist(list).setCount(list.size()-1).build());
        streamObserver.onCompleted();
    }

    /**
     * 这个地方需要给Java后端返回是否上传成功
     * 需要把返回值给到streamObserver里面
     */
    public void softwareRegister(UploadRequest uploadRequest, StreamObserver<UploadRespond> streamObserver){
        //List<UploadList> list= uploadRequest.getUploadlistList();
        String sha256Hash = uploadRequest.getHash();
        Result result = softMarketUpload.softwareRegister(sha256Hash);
        streamObserver.onNext(UploadRespond.newBuilder().setCode(result.getCode()).setMsg(result.getMsg()).setData((String) result.getData()).build());
        streamObserver.onCompleted();
//        List<OneFileDetail> list = softMarketSearch.softSearchByName(sw_name);
//        list.add(OneFileDetail.newBuilder().setDesc("").setFilename("").setSize("").setUrl("").setHash("").build());
//        streamObserver.onNext(FileDetailRespone.newBuilder().addAllDetaillist(list).setCount(list.size()).build());
//        streamObserver.onCompleted();
    }

    public void sayHello(HelloRequest helloRequest,StreamObserver<HelloReply> streamObserver){
        String name = helloRequest.getName();
        String reply = sayHelloService.Greet(name);
        streamObserver.onNext(HelloReply.newBuilder().setMessage(reply).build());
        streamObserver.onCompleted();
    }
}
