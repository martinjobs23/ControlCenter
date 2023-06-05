package com.ceit.desktop.grpc.server;

import com.ceit.desktop.grpc.*;
import com.ceit.desktop.grpc.TerminalLogOffRequest;
import com.ceit.desktop.service.NetManageService;
import com.ceit.desktop.service.SoftCheckService;
import com.ceit.desktop.service.TerminalPushService;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class NetManageGrpcserver extends NetManageGrpc.NetManageImplBase {
    private static Logger logger = LoggerFactory.getLogger(NetManageGrpcserver.class);

    private static NetManageService netManageService = new NetManageService();
    private static TerminalPushService terminalPushService = new TerminalPushService();
    public NetManageGrpcserver(){

    }

//    public void StartGrpc(int port) throws IOException {
//        logger.info("Control_Center start NetManage gRPC listening on " + port);
//        ServerBuilder.forPort(port)
//                .addService(new NetManageGrpcserver())
//                .build()
//                .start();
//    }

    public void netManager(TerminalLogOffRequest request, StreamObserver<TerminalLogOffReply> streamObserver) {
        String dev_ip = request.getDevIp();
        String reason = request.getReason();
        String dev_name = request.getDevName();
        int result = netManageService.NotifyTerminalLogoff(reason,dev_ip,dev_name,1);
        String msg = "Failed";
        if(result == 1) msg = "Success";
        streamObserver.onNext(TerminalLogOffReply.newBuilder().setStatus(200).setReason(msg).build());
        streamObserver.onCompleted();
    }

    public void terminalCollect(TerminalCollectRequest request, StreamObserver<TerminalCollectReply> streamObserver){
        int type = request.getType();
        String dev_ip = request.getDevIp();
        terminalPushService.TerminalCollect(type,dev_ip);

        streamObserver.onNext(TerminalCollectReply.newBuilder().setStatus(200).setResult("send").build());
        streamObserver.onCompleted();
    }

    public void softExceptionHandle(SoftInfoRequest request, StreamObserver<SoftInfoReply> streamObserver){
        int type = request.getType();
        int flag = request.getFlag();
        String dev_ip = request.getDevIp();
        String time = request.getTime();
        String install_time = "";
        String modify_time = "";
        String filename = request.getFilename();
        String hash = request.getHash();
        SoftCheckService softCheckService = new SoftCheckService();
        int res = 0;
        if(type == 0){
            install_time = request.getInstallTime();
            modify_time = request.getModifyTime();
            res = softCheckService.SoftChangeExceptionManagerHandle(filename,hash,install_time,modify_time,time,dev_ip,flag);
        } else if (type == 1) {
            res = softCheckService.SoftRunExceptionManagerHandle(filename,hash,time,dev_ip,flag);
        }
        if(res < 1){
            streamObserver.onNext(SoftInfoReply.newBuilder().setStatus(100).setResult("Failed").build());
        }
        else {
            streamObserver.onNext(SoftInfoReply.newBuilder().setStatus(200).setResult("Success").build());
        }
        streamObserver.onCompleted();
    }

    public void blacklistPush(BlacklistPushRequest request, StreamObserver<BlacklistPushReply> streamObserver){
        int type = request.getType();
        String dev_ip = request.getDevIp();
        TerminalPushService terminalPushService = new TerminalPushService();
        int res = terminalPushService.TerminalPushBlacklist(type,dev_ip);
        if(res < 0){
            streamObserver.onNext(BlacklistPushReply.newBuilder().setStatus(100).setResult("Failed").build());
        }
        else {
            streamObserver.onNext(BlacklistPushReply.newBuilder().setStatus(200).setResult("Success").build());
        }
        streamObserver.onCompleted();
    }

    public void terminalPushNotice(TerminalNotice request, StreamObserver<TerminalNotice> responseObserver){

    }
    public void test(testRequest request,StreamObserver<testReply> replyStreamObserver){
        long size = request.getReq();
        System.out.println("---------------------------------"+size+"---------------------------------");
        replyStreamObserver.onNext(testReply.newBuilder().setRep("copy.").build());
        replyStreamObserver.onCompleted();
    }
}
