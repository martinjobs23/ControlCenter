// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: softwareupload.proto

package com.ceit.desktop.grpc;

public interface UploadRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:softwareupload.UploadRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  java.util.List<com.ceit.desktop.grpc.UploadList> 
      getUploadlistList();
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  com.ceit.desktop.grpc.UploadList getUploadlist(int index);
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  int getUploadlistCount();
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  java.util.List<? extends com.ceit.desktop.grpc.UploadListOrBuilder> 
      getUploadlistOrBuilderList();
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  com.ceit.desktop.grpc.UploadListOrBuilder getUploadlistOrBuilder(
      int index);
}
