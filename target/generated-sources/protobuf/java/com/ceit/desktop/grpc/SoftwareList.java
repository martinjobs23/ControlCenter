// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: software.proto

package com.ceit.desktop.grpc;

/**
 * Protobuf type {@code software.SoftwareList}
 */
public final class SoftwareList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:software.SoftwareList)
    SoftwareListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SoftwareList.newBuilder() to construct.
  private SoftwareList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SoftwareList() {
    filename_ = "";
    hash_ = "";
    installTime_ = "";
    modifyTime_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SoftwareList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SoftwareList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
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
            java.lang.String s = input.readStringRequireUtf8();

            filename_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            hash_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            installTime_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            modifyTime_ = s;
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
    return com.ceit.desktop.grpc.SoftwareProto.internal_static_software_SoftwareList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ceit.desktop.grpc.SoftwareProto.internal_static_software_SoftwareList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ceit.desktop.grpc.SoftwareList.class, com.ceit.desktop.grpc.SoftwareList.Builder.class);
  }

  public static final int FILENAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object filename_;
  /**
   * <code>string filename = 1;</code>
   * @return The filename.
   */
  @java.lang.Override
  public java.lang.String getFilename() {
    java.lang.Object ref = filename_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      filename_ = s;
      return s;
    }
  }
  /**
   * <code>string filename = 1;</code>
   * @return The bytes for filename.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFilenameBytes() {
    java.lang.Object ref = filename_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      filename_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HASH_FIELD_NUMBER = 2;
  private volatile java.lang.Object hash_;
  /**
   * <code>string hash = 2;</code>
   * @return The hash.
   */
  @java.lang.Override
  public java.lang.String getHash() {
    java.lang.Object ref = hash_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      hash_ = s;
      return s;
    }
  }
  /**
   * <code>string hash = 2;</code>
   * @return The bytes for hash.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getHashBytes() {
    java.lang.Object ref = hash_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      hash_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int INSTALL_TIME_FIELD_NUMBER = 3;
  private volatile java.lang.Object installTime_;
  /**
   * <code>string install_time = 3;</code>
   * @return The installTime.
   */
  @java.lang.Override
  public java.lang.String getInstallTime() {
    java.lang.Object ref = installTime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      installTime_ = s;
      return s;
    }
  }
  /**
   * <code>string install_time = 3;</code>
   * @return The bytes for installTime.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getInstallTimeBytes() {
    java.lang.Object ref = installTime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      installTime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MODIFY_TIME_FIELD_NUMBER = 4;
  private volatile java.lang.Object modifyTime_;
  /**
   * <code>string modify_time = 4;</code>
   * @return The modifyTime.
   */
  @java.lang.Override
  public java.lang.String getModifyTime() {
    java.lang.Object ref = modifyTime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      modifyTime_ = s;
      return s;
    }
  }
  /**
   * <code>string modify_time = 4;</code>
   * @return The bytes for modifyTime.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getModifyTimeBytes() {
    java.lang.Object ref = modifyTime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      modifyTime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getFilenameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, filename_);
    }
    if (!getHashBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, hash_);
    }
    if (!getInstallTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, installTime_);
    }
    if (!getModifyTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, modifyTime_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getFilenameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, filename_);
    }
    if (!getHashBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, hash_);
    }
    if (!getInstallTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, installTime_);
    }
    if (!getModifyTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, modifyTime_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ceit.desktop.grpc.SoftwareList)) {
      return super.equals(obj);
    }
    com.ceit.desktop.grpc.SoftwareList other = (com.ceit.desktop.grpc.SoftwareList) obj;

    if (!getFilename()
        .equals(other.getFilename())) return false;
    if (!getHash()
        .equals(other.getHash())) return false;
    if (!getInstallTime()
        .equals(other.getInstallTime())) return false;
    if (!getModifyTime()
        .equals(other.getModifyTime())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FILENAME_FIELD_NUMBER;
    hash = (53 * hash) + getFilename().hashCode();
    hash = (37 * hash) + HASH_FIELD_NUMBER;
    hash = (53 * hash) + getHash().hashCode();
    hash = (37 * hash) + INSTALL_TIME_FIELD_NUMBER;
    hash = (53 * hash) + getInstallTime().hashCode();
    hash = (37 * hash) + MODIFY_TIME_FIELD_NUMBER;
    hash = (53 * hash) + getModifyTime().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ceit.desktop.grpc.SoftwareList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ceit.desktop.grpc.SoftwareList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ceit.desktop.grpc.SoftwareList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code software.SoftwareList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:software.SoftwareList)
      com.ceit.desktop.grpc.SoftwareListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ceit.desktop.grpc.SoftwareProto.internal_static_software_SoftwareList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ceit.desktop.grpc.SoftwareProto.internal_static_software_SoftwareList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ceit.desktop.grpc.SoftwareList.class, com.ceit.desktop.grpc.SoftwareList.Builder.class);
    }

    // Construct using com.ceit.desktop.grpc.SoftwareList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      filename_ = "";

      hash_ = "";

      installTime_ = "";

      modifyTime_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ceit.desktop.grpc.SoftwareProto.internal_static_software_SoftwareList_descriptor;
    }

    @java.lang.Override
    public com.ceit.desktop.grpc.SoftwareList getDefaultInstanceForType() {
      return com.ceit.desktop.grpc.SoftwareList.getDefaultInstance();
    }

    @java.lang.Override
    public com.ceit.desktop.grpc.SoftwareList build() {
      com.ceit.desktop.grpc.SoftwareList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ceit.desktop.grpc.SoftwareList buildPartial() {
      com.ceit.desktop.grpc.SoftwareList result = new com.ceit.desktop.grpc.SoftwareList(this);
      result.filename_ = filename_;
      result.hash_ = hash_;
      result.installTime_ = installTime_;
      result.modifyTime_ = modifyTime_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ceit.desktop.grpc.SoftwareList) {
        return mergeFrom((com.ceit.desktop.grpc.SoftwareList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ceit.desktop.grpc.SoftwareList other) {
      if (other == com.ceit.desktop.grpc.SoftwareList.getDefaultInstance()) return this;
      if (!other.getFilename().isEmpty()) {
        filename_ = other.filename_;
        onChanged();
      }
      if (!other.getHash().isEmpty()) {
        hash_ = other.hash_;
        onChanged();
      }
      if (!other.getInstallTime().isEmpty()) {
        installTime_ = other.installTime_;
        onChanged();
      }
      if (!other.getModifyTime().isEmpty()) {
        modifyTime_ = other.modifyTime_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.ceit.desktop.grpc.SoftwareList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ceit.desktop.grpc.SoftwareList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object filename_ = "";
    /**
     * <code>string filename = 1;</code>
     * @return The filename.
     */
    public java.lang.String getFilename() {
      java.lang.Object ref = filename_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        filename_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string filename = 1;</code>
     * @return The bytes for filename.
     */
    public com.google.protobuf.ByteString
        getFilenameBytes() {
      java.lang.Object ref = filename_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        filename_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string filename = 1;</code>
     * @param value The filename to set.
     * @return This builder for chaining.
     */
    public Builder setFilename(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      filename_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string filename = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFilename() {
      
      filename_ = getDefaultInstance().getFilename();
      onChanged();
      return this;
    }
    /**
     * <code>string filename = 1;</code>
     * @param value The bytes for filename to set.
     * @return This builder for chaining.
     */
    public Builder setFilenameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      filename_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object hash_ = "";
    /**
     * <code>string hash = 2;</code>
     * @return The hash.
     */
    public java.lang.String getHash() {
      java.lang.Object ref = hash_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hash_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string hash = 2;</code>
     * @return The bytes for hash.
     */
    public com.google.protobuf.ByteString
        getHashBytes() {
      java.lang.Object ref = hash_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        hash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string hash = 2;</code>
     * @param value The hash to set.
     * @return This builder for chaining.
     */
    public Builder setHash(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      hash_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string hash = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearHash() {
      
      hash_ = getDefaultInstance().getHash();
      onChanged();
      return this;
    }
    /**
     * <code>string hash = 2;</code>
     * @param value The bytes for hash to set.
     * @return This builder for chaining.
     */
    public Builder setHashBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      hash_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object installTime_ = "";
    /**
     * <code>string install_time = 3;</code>
     * @return The installTime.
     */
    public java.lang.String getInstallTime() {
      java.lang.Object ref = installTime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        installTime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string install_time = 3;</code>
     * @return The bytes for installTime.
     */
    public com.google.protobuf.ByteString
        getInstallTimeBytes() {
      java.lang.Object ref = installTime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        installTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string install_time = 3;</code>
     * @param value The installTime to set.
     * @return This builder for chaining.
     */
    public Builder setInstallTime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      installTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string install_time = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearInstallTime() {
      
      installTime_ = getDefaultInstance().getInstallTime();
      onChanged();
      return this;
    }
    /**
     * <code>string install_time = 3;</code>
     * @param value The bytes for installTime to set.
     * @return This builder for chaining.
     */
    public Builder setInstallTimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      installTime_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object modifyTime_ = "";
    /**
     * <code>string modify_time = 4;</code>
     * @return The modifyTime.
     */
    public java.lang.String getModifyTime() {
      java.lang.Object ref = modifyTime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        modifyTime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string modify_time = 4;</code>
     * @return The bytes for modifyTime.
     */
    public com.google.protobuf.ByteString
        getModifyTimeBytes() {
      java.lang.Object ref = modifyTime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        modifyTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string modify_time = 4;</code>
     * @param value The modifyTime to set.
     * @return This builder for chaining.
     */
    public Builder setModifyTime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      modifyTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string modify_time = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearModifyTime() {
      
      modifyTime_ = getDefaultInstance().getModifyTime();
      onChanged();
      return this;
    }
    /**
     * <code>string modify_time = 4;</code>
     * @param value The bytes for modifyTime to set.
     * @return This builder for chaining.
     */
    public Builder setModifyTimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      modifyTime_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:software.SoftwareList)
  }

  // @@protoc_insertion_point(class_scope:software.SoftwareList)
  private static final com.ceit.desktop.grpc.SoftwareList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ceit.desktop.grpc.SoftwareList();
  }

  public static com.ceit.desktop.grpc.SoftwareList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SoftwareList>
      PARSER = new com.google.protobuf.AbstractParser<SoftwareList>() {
    @java.lang.Override
    public SoftwareList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SoftwareList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SoftwareList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SoftwareList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ceit.desktop.grpc.SoftwareList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

