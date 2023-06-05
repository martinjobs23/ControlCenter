package com.ceit.desktop.grpc;

import com.ceit.desktop.grpc.caCenter.CaCenterGrpc;
import com.ceit.desktop.utils.FileConfigUtil;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;

public class CaGrpcClient {
    public CaCenterGrpc.CaCenterBlockingStub stub;
    private static FileConfigUtil fileConfigUtil = new FileConfigUtil();

    private ManagedChannel selfChannel = null;
    public CaGrpcClient() {
        String ip = "";
        int port = 0;
        try{
            ip = fileConfigUtil.load("desktop.properties","ca.grpc.ip");
            port = Integer.parseInt(fileConfigUtil.load("desktop.properties","ca.grpc.port"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        selfChannel = ManagedChannelBuilder
                .forAddress(ip,port)
                .usePlaintext()
                .build();
        stub = CaCenterGrpc.newBlockingStub(selfChannel);
    }

    public void shutdown() throws InterruptedException{
        selfChannel.shutdown();
    }
}
