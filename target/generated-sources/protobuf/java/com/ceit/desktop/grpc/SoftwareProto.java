// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: software.proto

package com.ceit.desktop.grpc;

public final class SoftwareProto {
  private SoftwareProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_software_SoftwareCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_software_SoftwareCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_software_SoftwareCheckReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_software_SoftwareCheckReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_software_SoftwareList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_software_SoftwareList_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016software.proto\022\010software\"@\n\024SoftwareCh" +
      "eckRequest\022(\n\010software\030\001 \003(\0132\026.software." +
      "SoftwareList\"4\n\022SoftwareCheckReply\022\016\n\006st" +
      "atus\030\001 \001(\005\022\016\n\006result\030\002 \001(\t\"Y\n\014SoftwareLi" +
      "st\022\020\n\010filename\030\001 \001(\t\022\014\n\004hash\030\002 \001(\t\022\024\n\014in" +
      "stall_time\030\003 \001(\t\022\023\n\013modify_time\030\004 \001(\t2[\n" +
      "\010Software\022O\n\rHardwareCheck\022\036.software.So" +
      "ftwareCheckRequest\032\034.software.SoftwareCh" +
      "eckReply\"\000B.\n\025com.ceit.desktop.grpcB\rSof" +
      "twareProtoP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_software_SoftwareCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_software_SoftwareCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_software_SoftwareCheckRequest_descriptor,
        new java.lang.String[] { "Software", });
    internal_static_software_SoftwareCheckReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_software_SoftwareCheckReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_software_SoftwareCheckReply_descriptor,
        new java.lang.String[] { "Status", "Result", });
    internal_static_software_SoftwareList_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_software_SoftwareList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_software_SoftwareList_descriptor,
        new java.lang.String[] { "Filename", "Hash", "InstallTime", "ModifyTime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
