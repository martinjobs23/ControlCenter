package com.ceit.desktop.grpc;

import com.ceit.desktop.grpc.caCenter.CaCenterGrpc;
import com.ceit.desktop.utils.FileConfigUtil;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;

public class CaGrpcClient {
    public CaCenterGrpc.CaCenterBlockingStub stub;
    private static FileConfigUtil fileConfigUtil = new FileConfigUtil();

    public CaGrpcClient() {
        String ip = "";
        int port = 0;
        try{
            ip = fileConfigUtil.load("desktop.properties","ca.grpc.ip");
            port = Integer.parseInt(fileConfigUtil.load("desktop.properties","ca.grpc.port"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(ip,port)
                .usePlaintext()
                .build();
        stub = CaCenterGrpc.newBlockingStub(channel);
    }
}
