package com.ceit.desktop;

import com.ceit.desktop.grpc.server.GrpcServer;
import com.ceit.desktop.grpc.server.WebGrpcserver;
import com.ceit.desktop.netty.AgentAdminService;
import com.ceit.desktop.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);
    private static FileConfigUtil fileConfigUtil =new FileConfigUtil();

    public static void main(String[] args) {
        int grpcPort =0;
        int port =0;

        try{
            grpcPort = Integer.parseInt(fileConfigUtil.load("desktop.properties","web.grpc.port"));
            port = Integer.parseInt(fileConfigUtil.load("desktop.properties","device.port"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebGrpcserver webGrpcserver = new WebGrpcserver();
        GrpcServer grpcServer = new GrpcServer();
        try{
            grpcServer.StartGrpc(grpcPort);
//            grpcServer.StartGrpc(grpcPort,"com.ceit.desktop.grpc.server.WebGrpcserver","com.ceit.desktop.grpc.server.NetManageGrpcserver","com.ceit.desktop.grpc.server.TestStreamGrpcServer");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        NetManageGrpcserver netManageGrpcserver = new NetManageGrpcserver();
//        try{
//            netManageGrpcserver.StartGrpc(grpcPort + 1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*TestStreamGrpcServer testStreamGrpcServer = new TestStreamGrpcServer();
        try{
            testStreamGrpcServer.StartGrpc(50062);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
/*        try {
            System.in.read();
        }catch (Exception e){

        }*/
        //testrpc();
        //testconf();
        AgentAdminService nettyServer = new AgentAdminService();
        nettyServer.init(port);
    }

//    public static void testrpc(){
//        TestGrpcClient testGrpcClient = new TestGrpcClient();
//        testGrpcClient.teststream();
//        //SoftInfoRequest softInfoRequest //= SoftInfoRequest.newBuilder().setFilename("D:\\caj\\CAJViewer 8.1\\associateFile.exe").setDevIp("192.168.109.120").setHash("B8AD2634394EA2EFDD64B318F32413D2").setType(0).setFlag(1).setInstallTime("2023-04-04 14:59:00").setModifyTime("2022-11-04 16:22:00").setTime("2023-04-04 17:21:40").build();
//        //SoftInfoReply softInfoReply = testGrpcClient.stub.softExceptionHandle(softInfoRequest);
//        //System.out.println(softInfoReply.getStatus());
//    }

//    public static void testconf(){
//        /*try {
//            XML send = NetconfUtils.send(
//                    //"<rpc xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\" message-id=\"1\">\n" +
//                    "    <huawei-capture:trace-pkt xmlns:huawei-capture=\"urn:huawei:params:xml:ns:yang:huawei-capture\">\n" +
//                            "    <huawei-capture:source-ip-address>192.168.109.120</huawei-capture:source-ip-address>\n" +
//                            "    <huawei-capture:timeout>30</huawei-capture:timeout>\n" +
//                            "  </huawei-capture:trace-pkt>"
//                    //"</rpc>"
//            );
//            System.out.println(send);
//            System.out.println(NetconfUtils.parseXml(send,"data.result"));
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }*/
//        //FlowCheckService flowCheckService = new FlowCheckService();
//        //flowCheckService.test("D:\\caj\\CAJViewer 8.1\\associateFile.exe");
//        //flowCheckService.computeflow("192.168.109.223","192.168.109.120",15);
//        //NetManageService netManageService = new NetManageService();
//        //netManageService.UpdateSwitchMac("192.168.109.223",1,5);
//        WorkOrderService ws = new WorkOrderService();
//        System.out.println(ws.getDevipByUsername("zhangsan"));
//    }

}
