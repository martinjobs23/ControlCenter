package com.ceit.desktop;

import com.ceit.desktop.grpc.server.WebGrpcserver;
import com.ceit.desktop.netty.AgentAdminService;
import com.ceit.desktop.utils.FileConfigUtil;
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
        try{
            webGrpcserver.StartGrpc(grpcPort);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AgentAdminService nettyServer = new AgentAdminService();
        nettyServer.init(port);
    }
}
