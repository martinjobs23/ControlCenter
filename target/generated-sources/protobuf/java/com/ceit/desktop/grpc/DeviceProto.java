// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: device.proto

package com.ceit.desktop.grpc;

public final class DeviceProto {
  private DeviceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_device_HardwareCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_device_HardwareCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_device_HardwareCheckReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_device_HardwareCheckReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014device.proto\022\006device\"(\n\024HardwareCheckR" +
      "equest\022\020\n\010hashcode\030\001 \001(\t\"4\n\022HardwareChec" +
      "kReply\022\016\n\006status\030\001 \001(\005\022\016\n\006result\030\002 \001(\t2U" +
      "\n\006Device\022K\n\rHardwareCheck\022\034.device.Hardw" +
      "areCheckRequest\032\032.device.HardwareCheckRe" +
      "ply\"\000B,\n\025com.ceit.desktop.grpcB\013DevicePr" +
      "otoP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_device_HardwareCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_device_HardwareCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_device_HardwareCheckRequest_descriptor,
        new java.lang.String[] { "Hashcode", });
    internal_static_device_HardwareCheckReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_device_HardwareCheckReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_device_HardwareCheckReply_descriptor,
        new java.lang.String[] { "Status", "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}