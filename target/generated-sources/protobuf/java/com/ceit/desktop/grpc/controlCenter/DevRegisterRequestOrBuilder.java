// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: web.proto

package com.ceit.desktop.grpc.controlCenter;

public interface DevRegisterRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:web.DevRegisterRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 is_handle = 1;</code>
   * @return The isHandle.
   */
  int getIsHandle();

  /**
   * <code>string serial = 2;</code>
   * @return The serial.
   */
  java.lang.String getSerial();
  /**
   * <code>string serial = 2;</code>
   * @return The bytes for serial.
   */
  com.google.protobuf.ByteString
      getSerialBytes();

  /**
   * <code>string dev_name = 3;</code>
   * @return The devName.
   */
  java.lang.String getDevName();
  /**
   * <code>string dev_name = 3;</code>
   * @return The bytes for devName.
   */
  com.google.protobuf.ByteString
      getDevNameBytes();

  /**
   * <code>string org_id = 4;</code>
   * @return The orgId.
   */
  java.lang.String getOrgId();
  /**
   * <code>string org_id = 4;</code>
   * @return The bytes for orgId.
   */
  com.google.protobuf.ByteString
      getOrgIdBytes();

  /**
   * <code>string device_ip = 5;</code>
   * @return The deviceIp.
   */
  java.lang.String getDeviceIp();
  /**
   * <code>string device_ip = 5;</code>
   * @return The bytes for deviceIp.
   */
  com.google.protobuf.ByteString
      getDeviceIpBytes();
}
