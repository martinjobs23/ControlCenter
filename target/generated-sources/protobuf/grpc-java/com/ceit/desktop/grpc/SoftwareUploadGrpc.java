package com.ceit.desktop.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *Java后端上传内容到软件超市
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.34.1)",
    comments = "Source: softwareupload.proto")
public final class SoftwareUploadGrpc {

  private SoftwareUploadGrpc() {}

  public static final String SERVICE_NAME = "softwareupload.SoftwareUpload";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ceit.desktop.grpc.UploadRequest,
      com.ceit.desktop.grpc.UploadRespond> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Upload",
      requestType = com.ceit.desktop.grpc.UploadRequest.class,
      responseType = com.ceit.desktop.grpc.UploadRespond.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ceit.desktop.grpc.UploadRequest,
      com.ceit.desktop.grpc.UploadRespond> getUploadMethod() {
    io.grpc.MethodDescriptor<com.ceit.desktop.grpc.UploadRequest, com.ceit.desktop.grpc.UploadRespond> getUploadMethod;
    if ((getUploadMethod = SoftwareUploadGrpc.getUploadMethod) == null) {
      synchronized (SoftwareUploadGrpc.class) {
        if ((getUploadMethod = SoftwareUploadGrpc.getUploadMethod) == null) {
          SoftwareUploadGrpc.getUploadMethod = getUploadMethod =
              io.grpc.MethodDescriptor.<com.ceit.desktop.grpc.UploadRequest, com.ceit.desktop.grpc.UploadRespond>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.UploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.UploadRespond.getDefaultInstance()))
              .setSchemaDescriptor(new SoftwareUploadMethodDescriptorSupplier("Upload"))
              .build();
        }
      }
    }
    return getUploadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SoftwareUploadStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftwareUploadStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftwareUploadStub>() {
        @java.lang.Override
        public SoftwareUploadStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftwareUploadStub(channel, callOptions);
        }
      };
    return SoftwareUploadStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SoftwareUploadBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftwareUploadBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftwareUploadBlockingStub>() {
        @java.lang.Override
        public SoftwareUploadBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftwareUploadBlockingStub(channel, callOptions);
        }
      };
    return SoftwareUploadBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SoftwareUploadFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftwareUploadFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftwareUploadFutureStub>() {
        @java.lang.Override
        public SoftwareUploadFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftwareUploadFutureStub(channel, callOptions);
        }
      };
    return SoftwareUploadFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Java后端上传内容到软件超市
   * </pre>
   */
  public static abstract class SoftwareUploadImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *rpc FileDetail_by_Name (FileDetailRequest_by_Name) returns (FileDetailRespone);
     * </pre>
     */
    public void upload(com.ceit.desktop.grpc.UploadRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.UploadRespond> responseObserver) {
      asyncUnimplementedUnaryCall(getUploadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUploadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ceit.desktop.grpc.UploadRequest,
                com.ceit.desktop.grpc.UploadRespond>(
                  this, METHODID_UPLOAD)))
          .build();
    }
  }

  /**
   * <pre>
   *Java后端上传内容到软件超市
   * </pre>
   */
  public static final class SoftwareUploadStub extends io.grpc.stub.AbstractAsyncStub<SoftwareUploadStub> {
    private SoftwareUploadStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftwareUploadStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftwareUploadStub(channel, callOptions);
    }

    /**
     * <pre>
     *rpc FileDetail_by_Name (FileDetailRequest_by_Name) returns (FileDetailRespone);
     * </pre>
     */
    public void upload(com.ceit.desktop.grpc.UploadRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.UploadRespond> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Java后端上传内容到软件超市
   * </pre>
   */
  public static final class SoftwareUploadBlockingStub extends io.grpc.stub.AbstractBlockingStub<SoftwareUploadBlockingStub> {
    private SoftwareUploadBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftwareUploadBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftwareUploadBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *rpc FileDetail_by_Name (FileDetailRequest_by_Name) returns (FileDetailRespone);
     * </pre>
     */
    public com.ceit.desktop.grpc.UploadRespond upload(com.ceit.desktop.grpc.UploadRequest request) {
      return blockingUnaryCall(
          getChannel(), getUploadMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Java后端上传内容到软件超市
   * </pre>
   */
  public static final class SoftwareUploadFutureStub extends io.grpc.stub.AbstractFutureStub<SoftwareUploadFutureStub> {
    private SoftwareUploadFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftwareUploadFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftwareUploadFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *rpc FileDetail_by_Name (FileDetailRequest_by_Name) returns (FileDetailRespone);
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ceit.desktop.grpc.UploadRespond> upload(
        com.ceit.desktop.grpc.UploadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPLOAD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SoftwareUploadImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SoftwareUploadImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD:
          serviceImpl.upload((com.ceit.desktop.grpc.UploadRequest) request,
              (io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.UploadRespond>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SoftwareUploadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SoftwareUploadBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ceit.desktop.grpc.SoftwareUploadProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SoftwareUpload");
    }
  }

  private static final class SoftwareUploadFileDescriptorSupplier
      extends SoftwareUploadBaseDescriptorSupplier {
    SoftwareUploadFileDescriptorSupplier() {}
  }

  private static final class SoftwareUploadMethodDescriptorSupplier
      extends SoftwareUploadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SoftwareUploadMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SoftwareUploadGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SoftwareUploadFileDescriptorSupplier())
              .addMethod(getUploadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
