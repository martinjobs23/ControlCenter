// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: software.proto

package com.ceit.desktop.grpc;

public interface SoftwareCheckRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:software.SoftwareCheckRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .software.SoftwareList software = 1;</code>
   */
  java.util.List<com.ceit.desktop.grpc.SoftwareList> 
      getSoftwareList();
  /**
   * <code>repeated .software.SoftwareList software = 1;</code>
   */
  com.ceit.desktop.grpc.SoftwareList getSoftware(int index);
  /**
   * <code>repeated .software.SoftwareList software = 1;</code>
   */
  int getSoftwareCount();
  /**
   * <code>repeated .software.SoftwareList software = 1;</code>
   */
  java.util.List<? extends com.ceit.desktop.grpc.SoftwareListOrBuilder> 
      getSoftwareOrBuilderList();
  /**
   * <code>repeated .software.SoftwareList software = 1;</code>
   */
  com.ceit.desktop.grpc.SoftwareListOrBuilder getSoftwareOrBuilder(
      int index);
}
