// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: filetransfer.proto

package com.ceit.desktop.grpc;

public final class FiletransferProto {
  private FiletransferProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_filetransfer_FileDetailRequest_by_Type_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_filetransfer_FileDetailRequest_by_Type_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_filetransfer_FileDetailRequest_by_Name_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_filetransfer_FileDetailRequest_by_Name_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_filetransfer_FileDetailRespone_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_filetransfer_FileDetailRespone_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_filetransfer_OneFileDetail_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_filetransfer_OneFileDetail_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022filetransfer.proto\022\014filetransfer\")\n\031Fi" +
      "leDetailRequest_by_Type\022\014\n\004type\030\001 \001(\005\")\n" +
      "\031FileDetailRequest_by_Name\022\014\n\004name\030\001 \001(\t" +
      "\"S\n\021FileDetailRespone\022/\n\ndetaillist\030\001 \003(" +
      "\0132\033.filetransfer.OneFileDetail\022\r\n\005count\030" +
      "\n \001(\005\"e\n\rOneFileDetail\022\020\n\010filename\030\001 \001(\t" +
      "\022\014\n\004desc\030\002 \001(\t\022\014\n\004size\030\003 \001(\t\022\013\n\003url\030\004 \001(" +
      "\t\022\014\n\004hash\030\005 \001(\t\022\013\n\003org\030\006 \001(\t2\316\001\n\014FileTra" +
      "nsfer\022^\n\022FileDetail_by_Type\022\'.filetransf" +
      "er.FileDetailRequest_by_Type\032\037.filetrans" +
      "fer.FileDetailRespone\022^\n\022FileDetail_by_N" +
      "ame\022\'.filetransfer.FileDetailRequest_by_" +
      "Name\032\037.filetransfer.FileDetailResponeB2\n" +
      "\025com.ceit.desktop.grpcB\021FiletransferProt" +
      "oP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_filetransfer_FileDetailRequest_by_Type_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_filetransfer_FileDetailRequest_by_Type_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_filetransfer_FileDetailRequest_by_Type_descriptor,
        new java.lang.String[] { "Type", });
    internal_static_filetransfer_FileDetailRequest_by_Name_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_filetransfer_FileDetailRequest_by_Name_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_filetransfer_FileDetailRequest_by_Name_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_filetransfer_FileDetailRespone_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_filetransfer_FileDetailRespone_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_filetransfer_FileDetailRespone_descriptor,
        new java.lang.String[] { "Detaillist", "Count", });
    internal_static_filetransfer_OneFileDetail_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_filetransfer_OneFileDetail_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_filetransfer_OneFileDetail_descriptor,
        new java.lang.String[] { "Filename", "Desc", "Size", "Url", "Hash", "Org", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
