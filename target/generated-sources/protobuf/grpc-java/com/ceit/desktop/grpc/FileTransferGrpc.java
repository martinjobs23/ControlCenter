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
    comments = "Source: filetransfer.proto")
public final class FileTransferGrpc {

  private FileTransferGrpc() {}

  public static final String SERVICE_NAME = "filetransfer.FileTransfer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ceit.desktop.grpc.FileDetailRequest_by_Type,
      com.ceit.desktop.grpc.FileDetailRespone> getFileDetailByTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FileDetail_by_Type",
      requestType = com.ceit.desktop.grpc.FileDetailRequest_by_Type.class,
      responseType = com.ceit.desktop.grpc.FileDetailRespone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ceit.desktop.grpc.FileDetailRequest_by_Type,
      com.ceit.desktop.grpc.FileDetailRespone> getFileDetailByTypeMethod() {
    io.grpc.MethodDescriptor<com.ceit.desktop.grpc.FileDetailRequest_by_Type, com.ceit.desktop.grpc.FileDetailRespone> getFileDetailByTypeMethod;
    if ((getFileDetailByTypeMethod = FileTransferGrpc.getFileDetailByTypeMethod) == null) {
      synchronized (FileTransferGrpc.class) {
        if ((getFileDetailByTypeMethod = FileTransferGrpc.getFileDetailByTypeMethod) == null) {
          FileTransferGrpc.getFileDetailByTypeMethod = getFileDetailByTypeMethod =
              io.grpc.MethodDescriptor.<com.ceit.desktop.grpc.FileDetailRequest_by_Type, com.ceit.desktop.grpc.FileDetailRespone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FileDetail_by_Type"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.FileDetailRequest_by_Type.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.FileDetailRespone.getDefaultInstance()))
              .setSchemaDescriptor(new FileTransferMethodDescriptorSupplier("FileDetail_by_Type"))
              .build();
        }
      }
    }
    return getFileDetailByTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ceit.desktop.grpc.FileDetailRequest_by_Name,
      com.ceit.desktop.grpc.FileDetailRespone> getFileDetailByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FileDetail_by_Name",
      requestType = com.ceit.desktop.grpc.FileDetailRequest_by_Name.class,
      responseType = com.ceit.desktop.grpc.FileDetailRespone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ceit.desktop.grpc.FileDetailRequest_by_Name,
      com.ceit.desktop.grpc.FileDetailRespone> getFileDetailByNameMethod() {
    io.grpc.MethodDescriptor<com.ceit.desktop.grpc.FileDetailRequest_by_Name, com.ceit.desktop.grpc.FileDetailRespone> getFileDetailByNameMethod;
    if ((getFileDetailByNameMethod = FileTransferGrpc.getFileDetailByNameMethod) == null) {
      synchronized (FileTransferGrpc.class) {
        if ((getFileDetailByNameMethod = FileTransferGrpc.getFileDetailByNameMethod) == null) {
          FileTransferGrpc.getFileDetailByNameMethod = getFileDetailByNameMethod =
              io.grpc.MethodDescriptor.<com.ceit.desktop.grpc.FileDetailRequest_by_Name, com.ceit.desktop.grpc.FileDetailRespone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FileDetail_by_Name"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.FileDetailRequest_by_Name.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ceit.desktop.grpc.FileDetailRespone.getDefaultInstance()))
              .setSchemaDescriptor(new FileTransferMethodDescriptorSupplier("FileDetail_by_Name"))
              .build();
        }
      }
    }
    return getFileDetailByNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileTransferStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileTransferStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileTransferStub>() {
        @java.lang.Override
        public FileTransferStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileTransferStub(channel, callOptions);
        }
      };
    return FileTransferStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileTransferBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileTransferBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileTransferBlockingStub>() {
        @java.lang.Override
        public FileTransferBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileTransferBlockingStub(channel, callOptions);
        }
      };
    return FileTransferBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileTransferFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileTransferFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileTransferFutureStub>() {
        @java.lang.Override
        public FileTransferFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileTransferFutureStub(channel, callOptions);
        }
      };
    return FileTransferFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FileTransferImplBase implements io.grpc.BindableService {

    /**
     */
    public void fileDetailByType(com.ceit.desktop.grpc.FileDetailRequest_by_Type request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.FileDetailRespone> responseObserver) {
      asyncUnimplementedUnaryCall(getFileDetailByTypeMethod(), responseObserver);
    }

    /**
     */
    public void fileDetailByName(com.ceit.desktop.grpc.FileDetailRequest_by_Name request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.FileDetailRespone> responseObserver) {
      asyncUnimplementedUnaryCall(getFileDetailByNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFileDetailByTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ceit.desktop.grpc.FileDetailRequest_by_Type,
                com.ceit.desktop.grpc.FileDetailRespone>(
                  this, METHODID_FILE_DETAIL_BY_TYPE)))
          .addMethod(
            getFileDetailByNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ceit.desktop.grpc.FileDetailRequest_by_Name,
                com.ceit.desktop.grpc.FileDetailRespone>(
                  this, METHODID_FILE_DETAIL_BY_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class FileTransferStub extends io.grpc.stub.AbstractAsyncStub<FileTransferStub> {
    private FileTransferStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileTransferStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileTransferStub(channel, callOptions);
    }

    /**
     */
    public void fileDetailByType(com.ceit.desktop.grpc.FileDetailRequest_by_Type request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.FileDetailRespone> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFileDetailByTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fileDetailByName(com.ceit.desktop.grpc.FileDetailRequest_by_Name request,
        io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.FileDetailRespone> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFileDetailByNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FileTransferBlockingStub extends io.grpc.stub.AbstractBlockingStub<FileTransferBlockingStub> {
    private FileTransferBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileTransferBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileTransferBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ceit.desktop.grpc.FileDetailRespone fileDetailByType(com.ceit.desktop.grpc.FileDetailRequest_by_Type request) {
      return blockingUnaryCall(
          getChannel(), getFileDetailByTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ceit.desktop.grpc.FileDetailRespone fileDetailByName(com.ceit.desktop.grpc.FileDetailRequest_by_Name request) {
      return blockingUnaryCall(
          getChannel(), getFileDetailByNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileTransferFutureStub extends io.grpc.stub.AbstractFutureStub<FileTransferFutureStub> {
    private FileTransferFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileTransferFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileTransferFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ceit.desktop.grpc.FileDetailRespone> fileDetailByType(
        com.ceit.desktop.grpc.FileDetailRequest_by_Type request) {
      return futureUnaryCall(
          getChannel().newCall(getFileDetailByTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ceit.desktop.grpc.FileDetailRespone> fileDetailByName(
        com.ceit.desktop.grpc.FileDetailRequest_by_Name request) {
      return futureUnaryCall(
          getChannel().newCall(getFileDetailByNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FILE_DETAIL_BY_TYPE = 0;
  private static final int METHODID_FILE_DETAIL_BY_NAME = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileTransferImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileTransferImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FILE_DETAIL_BY_TYPE:
          serviceImpl.fileDetailByType((com.ceit.desktop.grpc.FileDetailRequest_by_Type) request,
              (io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.FileDetailRespone>) responseObserver);
          break;
        case METHODID_FILE_DETAIL_BY_NAME:
          serviceImpl.fileDetailByName((com.ceit.desktop.grpc.FileDetailRequest_by_Name) request,
              (io.grpc.stub.StreamObserver<com.ceit.desktop.grpc.FileDetailRespone>) responseObserver);
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

  private static abstract class FileTransferBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileTransferBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ceit.desktop.grpc.FiletransferProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileTransfer");
    }
  }

  private static final class FileTransferFileDescriptorSupplier
      extends FileTransferBaseDescriptorSupplier {
    FileTransferFileDescriptorSupplier() {}
  }

  private static final class FileTransferMethodDescriptorSupplier
      extends FileTransferBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FileTransferMethodDescriptorSupplier(String methodName) {
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
      synchronized (FileTransferGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileTransferFileDescriptorSupplier())
              .addMethod(getFileDetailByTypeMethod())
              .addMethod(getFileDetailByNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
