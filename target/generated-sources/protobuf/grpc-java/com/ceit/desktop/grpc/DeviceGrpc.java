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
    comments = "Source: device.proto")
public final class DeviceGrpc {

  private DeviceGrpc() {}

  public static final String SERVICE_NAME = "device.Device";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ceit.desktop.grpc.HardwareCheckRequest,
      com.ceit.desktop.grpc.HardwareCheckReply> getHardwareCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HardwareCheck",
      requestType = com.ceit.desktop.grpc.HardwareCheckRequest.class,
      responseType = com.ceit.desktop.grpc.HardwareCheckReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ceit.desktop.grpc.HardwareCheckRequest,
      com.ceit.desktop.grpc.HardwareCheckReply> getHardwareCheckMethod() {
    io.grpc.MethodDescriptor<com.ceit.desktop.grpc.HardwareCheckRequest, com.ceit.desktop.grpc.HardwareCheckReply> getHardwareCheckMethod;
    if ((getHardwareCheckMethod = DeviceGrpc.getHardwareCheckMethod) == null) {
      synchronized (DeviceGrpc.class) {
        if ((getHardwareCheckMethod = DeviceGrpc.getHardwareCheckMethod) == null) {
          DeviceGrpc.getHardwareCheckMethod = getHardwareCheckMethod =
              io.grpc.MethodDescriptor.<com.ceit.desktop.grpc.HardwareCheckRequest, com.ceit.desktop.grpc.HardwareCheckReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HardwareCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.HardwareCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.HardwareCheckReply.getDefaultInstance()))
              .setSchemaDescriptor(new DeviceMethodDescriptorSupplier("HardwareCheck"))
              .build();
        }
      }
    }
    return getHardwareCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeviceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceStub>() {
        @java.lang.Override
        public DeviceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceStub(channel, callOptions);
        }
      };
    return DeviceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeviceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceBlockingStub>() {
        @java.lang.Override
        public DeviceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceBlockingStub(channel, callOptions);
        }
      };
    return DeviceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeviceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceFutureStub>() {
        @java.lang.Override
        public DeviceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceFutureStub(channel, callOptions);
        }
      };
    return DeviceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DeviceImplBase implements io.grpc.BindableService {

    /**
     */
    public void hardwareCheck(com.ceit.desktop.grpc.HardwareCheckRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.HardwareCheckReply> responseObserver) {
      asyncUnimplementedUnaryCall(getHardwareCheckMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHardwareCheckMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ceit.desktop.grpc.HardwareCheckRequest,
                com.ceit.desktop.grpc.HardwareCheckReply>(
                  this, METHODID_HARDWARE_CHECK)))
          .build();
    }
  }

  /**
   */
  public static final class DeviceStub extends io.grpc.stub.AbstractAsyncStub<DeviceStub> {
    private DeviceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceStub(channel, callOptions);
    }

    /**
     */
    public void hardwareCheck(com.ceit.desktop.grpc.HardwareCheckRequest request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.HardwareCheckReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHardwareCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DeviceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DeviceBlockingStub> {
    private DeviceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ceit.desktop.grpc.HardwareCheckReply hardwareCheck(com.ceit.desktop.grpc.HardwareCheckRequest request) {
      return blockingUnaryCall(
          getChannel(), getHardwareCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DeviceFutureStub extends io.grpc.stub.AbstractFutureStub<DeviceFutureStub> {
    private DeviceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ceit.desktop.grpc.HardwareCheckReply> hardwareCheck(
        com.ceit.desktop.grpc.HardwareCheckRequest request) {
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
    private final DeviceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeviceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HARDWARE_CHECK:
          serviceImpl.hardwareCheck((com.ceit.desktop.grpc.HardwareCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.HardwareCheckReply>) responseObserver);
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

  private static abstract class DeviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeviceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ceit.desktop.grpc.DeviceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Device");
    }
  }

  private static final class DeviceFileDescriptorSupplier
      extends DeviceBaseDescriptorSupplier {
    DeviceFileDescriptorSupplier() {}
  }

  private static final class DeviceMethodDescriptorSupplier
      extends DeviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeviceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeviceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeviceFileDescriptorSupplier())
              .addMethod(getHardwareCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
