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
    comments = "Source: software.proto")
public final class SoftwareGrpc {

  private SoftwareGrpc() {}

  public static final String SERVICE_NAME = "software.Software";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ceit.desktop.grpc.SoftwareCheckRequest,
      com.ceit.desktop.grpc.SoftwareCheckReply> getHardwareCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HardwareCheck",
      requestType = com.ceit.desktop.grpc.SoftwareCheckRequest.class,
      responseType = com.ceit.desktop.grpc.SoftwareCheckReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ceit.desktop.grpc.SoftwareCheckRequest,
      com.ceit.desktop.grpc.SoftwareCheckReply> getHardwareCheckMethod() {
    io.grpc.MethodDescriptor<com.ceit.desktop.grpc.SoftwareCheckRequest, com.ceit.desktop.grpc.SoftwareCheckReply> getHardwareCheckMethod;
    if ((getHardwareCheckMethod = SoftwareGrpc.getHardwareCheckMethod) == null) {
      synchronized (SoftwareGrpc.class) {
        if ((getHardwareCheckMethod = SoftwareGrpc.getHardwareCheckMethod) == null) {
          SoftwareGrpc.getHardwareCheckMethod = getHardwareCheckMethod =
              io.grpc.MethodDescriptor.<com.ceit.desktop.grpc.SoftwareCheckRequest, com.ceit.desktop.grpc.SoftwareCheckReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HardwareCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.SoftwareCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.SoftwareCheckReply.getDefaultInstance()))
              .setSchemaDescriptor(new SoftwareMethodDescriptorSupplier("HardwareCheck"))
              .build();
        }
      }
    }
    return getHardwareCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SoftwareStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftwareStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftwareStub>() {
        @java.lang.Override
        public SoftwareStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftwareStub(channel, callOptions);
        }
      };
    return SoftwareStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SoftwareBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftwareBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftwareBlockingStub>() {
        @java.lang.Override
        public SoftwareBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftwareBlockingStub(channel, callOptions);
        }
      };
    return SoftwareBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SoftwareFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftwareFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftwareFutureStub>() {
        @java.lang.Override
        public SoftwareFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftwareFutureStub(channel, callOptions);
        }
      };
    return SoftwareFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SoftwareImplBase implements io.grpc.BindableService {

    /**
     */
    public void hardwareCheck(com.ceit.desktop.grpc.SoftwareCheckRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.SoftwareCheckReply> responseObserver) {
      asyncUnimplementedUnaryCall(getHardwareCheckMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHardwareCheckMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ceit.desktop.grpc.SoftwareCheckRequest,
                com.ceit.desktop.grpc.SoftwareCheckReply>(
                  this, METHODID_HARDWARE_CHECK)))
          .build();
    }
  }

  /**
   */
  public static final class SoftwareStub extends io.grpc.stub.AbstractAsyncStub<SoftwareStub> {
    private SoftwareStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftwareStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftwareStub(channel, callOptions);
    }

    /**
     */
    public void hardwareCheck(com.ceit.desktop.grpc.SoftwareCheckRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.SoftwareCheckReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHardwareCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SoftwareBlockingStub extends io.grpc.stub.AbstractBlockingStub<SoftwareBlockingStub> {
    private SoftwareBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftwareBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftwareBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ceit.desktop.grpc.SoftwareCheckReply hardwareCheck(com.ceit.desktop.grpc.SoftwareCheckRequest request) {
      return blockingUnaryCall(
          getChannel(), getHardwareCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SoftwareFutureStub extends io.grpc.stub.AbstractFutureStub<SoftwareFutureStub> {
    private SoftwareFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftwareFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftwareFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ceit.desktop.grpc.SoftwareCheckReply> hardwareCheck(
        com.ceit.desktop.grpc.SoftwareCheckRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHardwareCheckMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HARDWARE_CHECK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SoftwareImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SoftwareImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HARDWARE_CHECK:
          serviceImpl.hardwareCheck((com.ceit.desktop.grpc.SoftwareCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.SoftwareCheckReply>) responseObserver);
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

  private static abstract class SoftwareBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SoftwareBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ceit.desktop.grpc.SoftwareProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Software");
    }
  }

  private static final class SoftwareFileDescriptorSupplier
      extends SoftwareBaseDescriptorSupplier {
    SoftwareFileDescriptorSupplier() {}
  }

  private static final class SoftwareMethodDescriptorSupplier
      extends SoftwareBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SoftwareMethodDescriptorSupplier(String methodName) {
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
      synchronized (SoftwareGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SoftwareFileDescriptorSupplier())
              .addMethod(getHardwareCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
