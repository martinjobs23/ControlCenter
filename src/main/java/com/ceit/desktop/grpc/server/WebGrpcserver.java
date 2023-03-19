package com.ceit.desktop.grpc.server;


import com.ceit.desktop.grpc.*;
import com.ceit.desktop.grpc.controlCenter.*;
import com.ceit.desktop.grpc.OneFileDetail;
import com.ceit.desktop.service.CertCheckService;
import com.ceit.desktop.softmarket.SoftMarketSearch;
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

    public WebGrpcserver() {
    }
    public void StartGrpc(int port) throws IOException {
        logger.info("Control_Center start Web gRPC listening on " + port);
        ServerBuilder.forPort(port)
                .addService(new WebGrpcserver())
                .build()
                .start();
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

    public void FileDetail_by_Type(FileDetailRequest_by_Type fileDetailRequest_by_type, StreamObserver<FileDetailRespone> streamObserver){
        int soft_type = fileDetailRequest_by_type.getType();
        List<OneFileDetail> list = softMarketSearch.softSearchByType(soft_type);
        list.add(OneFileDetail.newBuilder().setDesc("").setFilename("").setSize("").setUrl("").setHash("").build());
        streamObserver.onNext(FileDetailRespone.newBuilder().addAllDetaillist(list).setCount(list.size()).build());
        streamObserver.onCompleted();
    }

    public void FileDetail_by_Name(FileDetailRequest_by_Name fileDetailRequest_by_name, StreamObserver<FileDetailRespone> streamObserver){
        String sw_name = fileDetailRequest_by_name.getName();
        List<OneFileDetail> list = softMarketSearch.softSearchByName(sw_name);
        list.add(OneFileDetail.newBuilder().setDesc("").setFilename("").setSize("").setUrl("").setHash("").build());
        streamObserver.onNext(FileDetailRespone.newBuilder().addAllDetaillist(list).setCount(list.size()).build());
        streamObserver.onCompleted();
    }
}
