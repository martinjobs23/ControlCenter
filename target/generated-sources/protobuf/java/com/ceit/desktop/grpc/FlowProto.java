// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: traffic.proto

package com.ceit.desktop.grpc;

public final class FlowProto {
  private FlowProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_traffic_TrafficCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_traffic_TrafficCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_traffic_TrafficCheckReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_traffic_TrafficCheckReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rtraffic.proto\022\007traffic\"@\n\023TrafficCheck" +
      "Request\022\023\n\013input_bytes\030\001 \001(\005\022\024\n\014output_b" +
      "ytes\030\002 \001(\005\"3\n\021TrafficCheckReply\022\016\n\006statu" +
      "s\030\001 \001(\005\022\016\n\006result\030\002 \001(\tB*\n\025com.ceit.desk" +
      "top.grpcB\tFlowProtoP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_traffic_TrafficCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_traffic_TrafficCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_traffic_TrafficCheckRequest_descriptor,
        new java.lang.String[] { "InputBytes", "OutputBytes", });
    internal_static_traffic_TrafficCheckReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_traffic_TrafficCheckReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_traffic_TrafficCheckReply_descriptor,
        new java.lang.String[] { "Status", "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
