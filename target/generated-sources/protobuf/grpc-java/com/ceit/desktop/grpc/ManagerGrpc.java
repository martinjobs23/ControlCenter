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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.34.1)",
    comments = "Source: manager.proto")
public final class ManagerGrpc {

  private ManagerGrpc() {}

  public static final String SERVICE_NAME = "manage.Manager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ceit.desktop.grpc.ManagerCheckRequest,
      com.ceit.desktop.grpc.ManagerCheckReply> getManagerCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ManagerCheck",
      requestType = com.ceit.desktop.grpc.ManagerCheckRequest.class,
      responseType = com.ceit.desktop.grpc.ManagerCheckReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ceit.desktop.grpc.ManagerCheckRequest,
      com.ceit.desktop.grpc.ManagerCheckReply> getManagerCheckMethod() {
    io.grpc.MethodDescriptor<com.ceit.desktop.grpc.ManagerCheckRequest, com.ceit.desktop.grpc.ManagerCheckReply> getManagerCheckMethod;
    if ((getManagerCheckMethod = ManagerGrpc.getManagerCheckMethod) == null) {
      synchronized (ManagerGrpc.class) {
        if ((getManagerCheckMethod = ManagerGrpc.getManagerCheckMethod) == null) {
          ManagerGrpc.getManagerCheckMethod = getManagerCheckMethod =
              io.grpc.MethodDescriptor.<com.ceit.desktop.grpc.ManagerCheckRequest, com.ceit.desktop.grpc.ManagerCheckReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ManagerCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.ManagerCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.ManagerCheckReply.getDefaultInstance()))
              .setSchemaDescriptor(new ManagerMethodDescriptorSupplier("ManagerCheck"))
              .build();
        }
      }
    }
    return getManagerCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagerStub>() {
        @java.lang.Override
        public ManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagerStub(channel, callOptions);
        }
      };
    return ManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagerBlockingStub>() {
        @java.lang.Override
        public ManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagerBlockingStub(channel, callOptions);
        }
      };
    return ManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagerFutureStub>() {
        @java.lang.Override
        public ManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagerFutureStub(channel, callOptions);
        }
      };
    return ManagerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ManagerImplBase implements io.grpc.BindableService {

    /**
     */
    public void managerCheck(com.ceit.desktop.grpc.ManagerCheckRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.ManagerCheckReply> responseObserver) {
      asyncUnimplementedUnaryCall(getManagerCheckMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getManagerCheckMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ceit.desktop.grpc.ManagerCheckRequest,
                com.ceit.desktop.grpc.ManagerCheckReply>(
                  this, METHODID_MANAGER_CHECK)))
          .build();
    }
  }

  /**
   */
  public static final class ManagerStub extends io.grpc.stub.AbstractAsyncStub<ManagerStub> {
    private ManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagerStub(channel, callOptions);
    }

    /**
     */
    public void managerCheck(com.ceit.desktop.grpc.ManagerCheckRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.ManagerCheckReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getManagerCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ManagerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ManagerBlockingStub> {
    private ManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ceit.desktop.grpc.ManagerCheckReply managerCheck(com.ceit.desktop.grpc.ManagerCheckRequest request) {
      return blockingUnaryCall(
          getChannel(), getManagerCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ManagerFutureStub extends io.grpc.stub.AbstractFutureStub<ManagerFutureStub> {
    private ManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ceit.desktop.grpc.ManagerCheckReply> managerCheck(
        com.ceit.desktop.grpc.ManagerCheckRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getManagerCheckMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MANAGER_CHECK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MANAGER_CHECK:
          serviceImpl.managerCheck((com.ceit.desktop.grpc.ManagerCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.ManagerCheckReply>) responseObserver);
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

  private static abstract class ManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ceit.desktop.grpc.ManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Manager");
    }
  }

  private static final class ManagerFileDescriptorSupplier
      extends ManagerBaseDescriptorSupplier {
    ManagerFileDescriptorSupplier() {}
  }

  private static final class ManagerMethodDescriptorSupplier
      extends ManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (ManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ManagerFileDescriptorSupplier())
              .addMethod(getManagerCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
