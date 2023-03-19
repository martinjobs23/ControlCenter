package com.ceit.desktop.grpc.controlCenter;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.34.1)",
    comments = "Source: web.proto")
public final class WebGrpc {

  private WebGrpc() {}

  public static final String SERVICE_NAME = "web.Web";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ceit.desktop.grpc.controlCenter.DevRegisterRequest,
      com.ceit.desktop.grpc.controlCenter.DevRegisterReply> getDevRegisterCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DevRegisterCheck",
      requestType = com.ceit.desktop.grpc.controlCenter.DevRegisterRequest.class,
      responseType = com.ceit.desktop.grpc.controlCenter.DevRegisterReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ceit.desktop.grpc.controlCenter.DevRegisterRequest,
      com.ceit.desktop.grpc.controlCenter.DevRegisterReply> getDevRegisterCheckMethod() {
    io.grpc.MethodDescriptor<com.ceit.desktop.grpc.controlCenter.DevRegisterRequest, com.ceit.desktop.grpc.controlCenter.DevRegisterReply> getDevRegisterCheckMethod;
    if ((getDevRegisterCheckMethod = WebGrpc.getDevRegisterCheckMethod) == null) {
      synchronized (WebGrpc.class) {
        if ((getDevRegisterCheckMethod = WebGrpc.getDevRegisterCheckMethod) == null) {
          WebGrpc.getDevRegisterCheckMethod = getDevRegisterCheckMethod =
              io.grpc.MethodDescriptor.<com.ceit.desktop.grpc.controlCenter.DevRegisterRequest, com.ceit.desktop.grpc.controlCenter.DevRegisterReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DevRegisterCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.controlCenter.DevRegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.controlCenter.DevRegisterReply.getDefaultInstance()))
              .setSchemaDescriptor(new WebMethodDescriptorSupplier("DevRegisterCheck"))
              .build();
        }
      }
    }
    return getDevRegisterCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest,
      com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply> getDevUnRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DevUnRegister",
      requestType = com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest.class,
      responseType = com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest,
      com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply> getDevUnRegisterMethod() {
    io.grpc.MethodDescriptor<com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest, com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply> getDevUnRegisterMethod;
    if ((getDevUnRegisterMethod = WebGrpc.getDevUnRegisterMethod) == null) {
      synchronized (WebGrpc.class) {
        if ((getDevUnRegisterMethod = WebGrpc.getDevUnRegisterMethod) == null) {
          WebGrpc.getDevUnRegisterMethod = getDevUnRegisterMethod =
              io.grpc.MethodDescriptor.<com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest, com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DevUnRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply.getDefaultInstance()))
              .setSchemaDescriptor(new WebMethodDescriptorSupplier("DevUnRegister"))
              .build();
        }
      }
    }
    return getDevUnRegisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WebStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebStub>() {
        @java.lang.Override
        public WebStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebStub(channel, callOptions);
        }
      };
    return WebStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebBlockingStub>() {
        @java.lang.Override
        public WebBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebBlockingStub(channel, callOptions);
        }
      };
    return WebBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WebFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebFutureStub>() {
        @java.lang.Override
        public WebFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebFutureStub(channel, callOptions);
        }
      };
    return WebFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WebImplBase implements io.grpc.BindableService {

    /**
     */
    public void devRegisterCheck(com.ceit.desktop.grpc.controlCenter.DevRegisterRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.controlCenter.DevRegisterReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDevRegisterCheckMethod(), responseObserver);
    }

    /**
     */
    public void devUnRegister(com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDevUnRegisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDevRegisterCheckMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ceit.desktop.grpc.controlCenter.DevRegisterRequest,
                com.ceit.desktop.grpc.controlCenter.DevRegisterReply>(
                  this, METHODID_DEV_REGISTER_CHECK)))
          .addMethod(
            getDevUnRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest,
                com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply>(
                  this, METHODID_DEV_UN_REGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class WebStub extends io.grpc.stub.AbstractAsyncStub<WebStub> {
    private WebStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebStub(channel, callOptions);
    }

    /**
     */
    public void devRegisterCheck(com.ceit.desktop.grpc.controlCenter.DevRegisterRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.controlCenter.DevRegisterReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDevRegisterCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void devUnRegister(com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDevUnRegisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WebBlockingStub extends io.grpc.stub.AbstractBlockingStub<WebBlockingStub> {
    private WebBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ceit.desktop.grpc.controlCenter.DevRegisterReply devRegisterCheck(com.ceit.desktop.grpc.controlCenter.DevRegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getDevRegisterCheckMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply devUnRegister(com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getDevUnRegisterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WebFutureStub extends io.grpc.stub.AbstractFutureStub<WebFutureStub> {
    private WebFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ceit.desktop.grpc.controlCenter.DevRegisterReply> devRegisterCheck(
        com.ceit.desktop.grpc.controlCenter.DevRegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDevRegisterCheckMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply> devUnRegister(
        com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDevUnRegisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DEV_REGISTER_CHECK = 0;
  private static final int METHODID_DEV_UN_REGISTER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WebImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WebImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEV_REGISTER_CHECK:
          serviceImpl.devRegisterCheck((com.ceit.desktop.grpc.controlCenter.DevRegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.controlCenter.DevRegisterReply>) responseObserver);
          break;
        case METHODID_DEV_UN_REGISTER:
          serviceImpl.devUnRegister((com.ceit.desktop.grpc.controlCenter.DevUnRegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.controlCenter.DevUnRegisterReply>) responseObserver);
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

  private static abstract class WebBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WebBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ceit.desktop.grpc.controlCenter.WebProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Web");
    }
  }

  private static final class WebFileDescriptorSupplier
      extends WebBaseDescriptorSupplier {
    WebFileDescriptorSupplier() {}
  }

  private static final class WebMethodDescriptorSupplier
      extends WebBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WebMethodDescriptorSupplier(String methodName) {
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
      synchronized (WebGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WebFileDescriptorSupplier())
              .addMethod(getDevRegisterCheckMethod())
              .addMethod(getDevUnRegisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
