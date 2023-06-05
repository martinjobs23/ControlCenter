package com.ceit.desktop.grpc;

import com.ceit.desktop.grpc.controlCenter.WebGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class TestGrpcClient {
    public WebGrpc.WebBlockingStub stub1;
    public NetManageGrpc.NetManageBlockingStub stub;
    public TestStreamGrpc.TestStreamBlockingStub stub11;

    private ManagedChannel selfchannel = null;

    public TestGrpcClient(){
        String ip = "192.168.109.120";
        int port = 50062;
        selfchannel = ManagedChannelBuilder.forAddress(ip,port).usePlaintext().build();
        stub11 = TestStreamGrpc.newBlockingStub(selfchannel);
    }

    public void teststream(){
        workorderrequest request = workorderrequest.newBuilder().setMsg("????").build();
        try{
            Iterator<workorderreply> ttt = stub11.submitwork(request);

            while(ttt.hasNext()) {
                workorderreply wo = ttt.next();
                System.out.println("test =========" + wo.getMsg());
            }

            }catch(Exception ee) {
            ee.printStackTrace();
        }
    }
}
