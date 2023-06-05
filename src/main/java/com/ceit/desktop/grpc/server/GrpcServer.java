package com.ceit.desktop.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GrpcServer {
    private static Logger logger = LoggerFactory.getLogger(GrpcServer.class);

    private ServerBuilder serverbuilder;
    private NetManageGrpcserver netManageGrpcserver;
    private WebGrpcserver webGrpcserver;

//    public void StartGrpc(int port, String... GrpcServerName) throws Exception {
//
//        logger.info("gRPC listening on " + port);
//        serverbuilder = ServerBuilder.forPort(port);
//        for(String grpc : GrpcServerName){
//            serverbuilder.addService((io.grpc.BindableService) Class.forName(grpc).newInstance());
//        }
//        serverbuilder.build().start();
//    }
        public void StartGrpc(int port) throws IOException {
        logger.info("Control_Center start Web gRPC listening on " + port);
        ServerBuilder.forPort(port)
                .addService(new WebGrpcserver())
                .addService(new NetManageGrpcserver())
                .build()
                .start();
    }
}
