// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: softwareupload.proto

package com.ceit.desktop.grpc;

public final class SoftwareUploadProto {
  private SoftwareUploadProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_softwareupload_UploadRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_softwareupload_UploadRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_softwareupload_UploadRespond_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_softwareupload_UploadRespond_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_softwareupload_UploadList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_softwareupload_UploadList_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024softwareupload.proto\022\016softwareupload\"?" +
      "\n\rUploadRequest\022.\n\nuploadlist\030\001 \003(\0132\032.so" +
      "ftwareupload.UploadList\"<\n\rUploadRespond" +
      "\022\016\n\006status\030\001 \001(\005\022\013\n\003msg\030\002 \001(\t\022\016\n\006result\030" +
      "\003 \001(\t\"\221\001\n\nUploadList\022\020\n\010filename\030\001 \001(\t\022\014" +
      "\n\004desc\030\002 \001(\t\022\014\n\004size\030\003 \001(\t\022\013\n\003url\030\004 \001(\t\022" +
      "\014\n\004hash\030\005 \001(\t\022\014\n\004type\030\006 \001(\t\022\016\n\006public\030\007 " +
      "\001(\005\022\013\n\003org\030\010 \001(\t\022\017\n\007version\030\t \001(\t2X\n\016Sof" +
      "twareUpload\022F\n\006Upload\022\035.softwareupload.U" +
      "ploadRequest\032\035.softwareupload.UploadResp" +
      "ondB4\n\025com.ceit.desktop.grpcB\023SoftwareUp" +
      "loadProtoP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_softwareupload_UploadRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_softwareupload_UploadRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_softwareupload_UploadRequest_descriptor,
        new java.lang.String[] { "Uploadlist", });
    internal_static_softwareupload_UploadRespond_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_softwareupload_UploadRespond_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_softwareupload_UploadRespond_descriptor,
        new java.lang.String[] { "Status", "Msg", "Result", });
    internal_static_softwareupload_UploadList_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_softwareupload_UploadList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_softwareupload_UploadList_descriptor,
        new java.lang.String[] { "Filename", "Desc", "Size", "Url", "Hash", "Type", "Public", "Org", "Version", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
