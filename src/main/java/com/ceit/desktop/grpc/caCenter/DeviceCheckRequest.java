// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: device.proto

package com.ceit.desktop.grpc.caCenter;

/**
 * <pre>
 *硬件认证
 * </pre>
 *
 * Protobuf type {@code caCenter.DeviceCheckRequest}
 */
public final class DeviceCheckRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:caCenter.DeviceCheckRequest)
    DeviceCheckRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeviceCheckRequest.newBuilder() to construct.
  private DeviceCheckRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeviceCheckRequest() {
    deviceHash_ = "";
    deviceIp_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new DeviceCheckRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DeviceCheckRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            String s = input.readStringRequireUtf8();

            deviceHash_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            deviceIp_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return CAProto.internal_static_caCenter_DeviceCheckRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CAProto.internal_static_caCenter_DeviceCheckRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            DeviceCheckRequest.class, Builder.class);
  }

  public static final int DEVICEHASH_FIELD_NUMBER = 1;
  private volatile Object deviceHash_;
  /**
   * <code>string deviceHash = 1;</code>
   * @return The deviceHash.
   */
  @Override
  public String getDeviceHash() {
    Object ref = deviceHash_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      deviceHash_ = s;
      return s;
    }
  }
  /**
   * <code>string deviceHash = 1;</code>
   * @return The bytes for deviceHash.
   */
  @Override
  public com.google.protobuf.ByteString
      getDeviceHashBytes() {
    Object ref = deviceHash_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      deviceHash_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DEVICE_IP_FIELD_NUMBER = 2;
  private volatile Object deviceIp_;
  /**
   * <code>string device_ip = 2;</code>
   * @return The deviceIp.
   */
  @Override
  public String getDeviceIp() {
    Object ref = deviceIp_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      deviceIp_ = s;
      return s;
    }
  }
  /**
   * <code>string device_ip = 2;</code>
   * @return The bytes for deviceIp.
   */
  @Override
  public com.google.protobuf.ByteString
      getDeviceIpBytes() {
    Object ref = deviceIp_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      deviceIp_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getDeviceHashBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, deviceHash_);
    }
    if (!getDeviceIpBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, deviceIp_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDeviceHashBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, deviceHash_);
    }
    if (!getDeviceIpBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, deviceIp_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof DeviceCheckRequest)) {
      return super.equals(obj);
    }
    DeviceCheckRequest other = (DeviceCheckRequest) obj;

    if (!getDeviceHash()
        .equals(other.getDeviceHash())) return false;
    if (!getDeviceIp()
        .equals(other.getDeviceIp())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DEVICEHASH_FIELD_NUMBER;
    hash = (53 * hash) + getDeviceHash().hashCode();
    hash = (37 * hash) + DEVICE_IP_FIELD_NUMBER;
    hash = (53 * hash) + getDeviceIp().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static DeviceCheckRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeviceCheckRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeviceCheckRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeviceCheckRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeviceCheckRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeviceCheckRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeviceCheckRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DeviceCheckRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static DeviceCheckRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static DeviceCheckRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static DeviceCheckRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DeviceCheckRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(DeviceCheckRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *硬件认证
   * </pre>
   *
   * Protobuf type {@code caCenter.DeviceCheckRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:caCenter.DeviceCheckRequest)
      DeviceCheckRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CAProto.internal_static_caCenter_DeviceCheckRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CAProto.internal_static_caCenter_DeviceCheckRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              DeviceCheckRequest.class, Builder.class);
    }

    // Construct using com.ceit.desktop.grpc.caCenter.DeviceCheckRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      deviceHash_ = "";

      deviceIp_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CAProto.internal_static_caCenter_DeviceCheckRequest_descriptor;
    }

    @Override
    public DeviceCheckRequest getDefaultInstanceForType() {
      return DeviceCheckRequest.getDefaultInstance();
    }

    @Override
    public DeviceCheckRequest build() {
      DeviceCheckRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public DeviceCheckRequest buildPartial() {
      DeviceCheckRequest result = new DeviceCheckRequest(this);
      result.deviceHash_ = deviceHash_;
      result.deviceIp_ = deviceIp_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof DeviceCheckRequest) {
        return mergeFrom((DeviceCheckRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(DeviceCheckRequest other) {
      if (other == DeviceCheckRequest.getDefaultInstance()) return this;
      if (!other.getDeviceHash().isEmpty()) {
        deviceHash_ = other.deviceHash_;
        onChanged();
      }
      if (!other.getDeviceIp().isEmpty()) {
        deviceIp_ = other.deviceIp_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      DeviceCheckRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (DeviceCheckRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object deviceHash_ = "";
    /**
     * <code>string deviceHash = 1;</code>
     * @return The deviceHash.
     */
    public String getDeviceHash() {
      Object ref = deviceHash_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        deviceHash_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string deviceHash = 1;</code>
     * @return The bytes for deviceHash.
     */
    public com.google.protobuf.ByteString
        getDeviceHashBytes() {
      Object ref = deviceHash_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        deviceHash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string deviceHash = 1;</code>
     * @param value The deviceHash to set.
     * @return This builder for chaining.
     */
    public Builder setDeviceHash(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      deviceHash_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string deviceHash = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDeviceHash() {
      
      deviceHash_ = getDefaultInstance().getDeviceHash();
      onChanged();
      return this;
    }
    /**
     * <code>string deviceHash = 1;</code>
     * @param value The bytes for deviceHash to set.
     * @return This builder for chaining.
     */
    public Builder setDeviceHashBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      deviceHash_ = value;
      onChanged();
      return this;
    }

    private Object deviceIp_ = "";
    /**
     * <code>string device_ip = 2;</code>
     * @return The deviceIp.
     */
    public String getDeviceIp() {
      Object ref = deviceIp_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        deviceIp_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string device_ip = 2;</code>
     * @return The bytes for deviceIp.
     */
    public com.google.protobuf.ByteString
        getDeviceIpBytes() {
      Object ref = deviceIp_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        deviceIp_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string device_ip = 2;</code>
     * @param value The deviceIp to set.
     * @return This builder for chaining.
     */
    public Builder setDeviceIp(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      deviceIp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string device_ip = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDeviceIp() {
      
      deviceIp_ = getDefaultInstance().getDeviceIp();
      onChanged();
      return this;
    }
    /**
     * <code>string device_ip = 2;</code>
     * @param value The bytes for deviceIp to set.
     * @return This builder for chaining.
     */
    public Builder setDeviceIpBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      deviceIp_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:caCenter.DeviceCheckRequest)
  }

  // @@protoc_insertion_point(class_scope:caCenter.DeviceCheckRequest)
  private static final DeviceCheckRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new DeviceCheckRequest();
  }

  public static DeviceCheckRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeviceCheckRequest>
      PARSER = new com.google.protobuf.AbstractParser<DeviceCheckRequest>() {
    @Override
    public DeviceCheckRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DeviceCheckRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeviceCheckRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<DeviceCheckRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public DeviceCheckRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

