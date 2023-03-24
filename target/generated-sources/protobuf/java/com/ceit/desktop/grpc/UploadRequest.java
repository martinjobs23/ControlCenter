// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: softwareupload.proto

package com.ceit.desktop.grpc;

/**
 * Protobuf type {@code softwareupload.UploadRequest}
 */
public final class UploadRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:softwareupload.UploadRequest)
    UploadRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UploadRequest.newBuilder() to construct.
  private UploadRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UploadRequest() {
    uploadlist_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UploadRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UploadRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              uploadlist_ = new java.util.ArrayList<com.ceit.desktop.grpc.UploadList>();
              mutable_bitField0_ |= 0x00000001;
            }
            uploadlist_.add(
                input.readMessage(com.ceit.desktop.grpc.UploadList.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        uploadlist_ = java.util.Collections.unmodifiableList(uploadlist_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ceit.desktop.grpc.SoftwareUploadProto.internal_static_softwareupload_UploadRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ceit.desktop.grpc.SoftwareUploadProto.internal_static_softwareupload_UploadRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ceit.desktop.grpc.UploadRequest.class, com.ceit.desktop.grpc.UploadRequest.Builder.class);
  }

  public static final int UPLOADLIST_FIELD_NUMBER = 1;
  private java.util.List<com.ceit.desktop.grpc.UploadList> uploadlist_;
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.ceit.desktop.grpc.UploadList> getUploadlistList() {
    return uploadlist_;
  }
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.ceit.desktop.grpc.UploadListOrBuilder> 
      getUploadlistOrBuilderList() {
    return uploadlist_;
  }
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  @java.lang.Override
  public int getUploadlistCount() {
    return uploadlist_.size();
  }
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  @java.lang.Override
  public com.ceit.desktop.grpc.UploadList getUploadlist(int index) {
    return uploadlist_.get(index);
  }
  /**
   * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
   */
  @java.lang.Override
  public com.ceit.desktop.grpc.UploadListOrBuilder getUploadlistOrBuilder(
      int index) {
    return uploadlist_.get(index);
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
    for (int i = 0; i < uploadlist_.size(); i++) {
      output.writeMessage(1, uploadlist_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < uploadlist_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, uploadlist_.get(i));
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
    if (!(obj instanceof com.ceit.desktop.grpc.UploadRequest)) {
      return super.equals(obj);
    }
    com.ceit.desktop.grpc.UploadRequest other = (com.ceit.desktop.grpc.UploadRequest) obj;

    if (!getUploadlistList()
        .equals(other.getUploadlistList())) return false;
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
    if (getUploadlistCount() > 0) {
      hash = (37 * hash) + UPLOADLIST_FIELD_NUMBER;
      hash = (53 * hash) + getUploadlistList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ceit.desktop.grpc.UploadRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ceit.desktop.grpc.UploadRequest parseFrom(
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
  public static Builder newBuilder(com.ceit.desktop.grpc.UploadRequest prototype) {
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
   * Protobuf type {@code softwareupload.UploadRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:softwareupload.UploadRequest)
      com.ceit.desktop.grpc.UploadRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ceit.desktop.grpc.SoftwareUploadProto.internal_static_softwareupload_UploadRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ceit.desktop.grpc.SoftwareUploadProto.internal_static_softwareupload_UploadRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ceit.desktop.grpc.UploadRequest.class, com.ceit.desktop.grpc.UploadRequest.Builder.class);
    }

    // Construct using com.ceit.desktop.grpc.UploadRequest.newBuilder()
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
        getUploadlistFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (uploadlistBuilder_ == null) {
        uploadlist_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        uploadlistBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ceit.desktop.grpc.SoftwareUploadProto.internal_static_softwareupload_UploadRequest_descriptor;
    }

    @java.lang.Override
    public com.ceit.desktop.grpc.UploadRequest getDefaultInstanceForType() {
      return com.ceit.desktop.grpc.UploadRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.ceit.desktop.grpc.UploadRequest build() {
      com.ceit.desktop.grpc.UploadRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ceit.desktop.grpc.UploadRequest buildPartial() {
      com.ceit.desktop.grpc.UploadRequest result = new com.ceit.desktop.grpc.UploadRequest(this);
      int from_bitField0_ = bitField0_;
      if (uploadlistBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          uploadlist_ = java.util.Collections.unmodifiableList(uploadlist_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.uploadlist_ = uploadlist_;
      } else {
        result.uploadlist_ = uploadlistBuilder_.build();
      }
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
      if (other instanceof com.ceit.desktop.grpc.UploadRequest) {
        return mergeFrom((com.ceit.desktop.grpc.UploadRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ceit.desktop.grpc.UploadRequest other) {
      if (other == com.ceit.desktop.grpc.UploadRequest.getDefaultInstance()) return this;
      if (uploadlistBuilder_ == null) {
        if (!other.uploadlist_.isEmpty()) {
          if (uploadlist_.isEmpty()) {
            uploadlist_ = other.uploadlist_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureUploadlistIsMutable();
            uploadlist_.addAll(other.uploadlist_);
          }
          onChanged();
        }
      } else {
        if (!other.uploadlist_.isEmpty()) {
          if (uploadlistBuilder_.isEmpty()) {
            uploadlistBuilder_.dispose();
            uploadlistBuilder_ = null;
            uploadlist_ = other.uploadlist_;
            bitField0_ = (bitField0_ & ~0x00000001);
            uploadlistBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getUploadlistFieldBuilder() : null;
          } else {
            uploadlistBuilder_.addAllMessages(other.uploadlist_);
          }
        }
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
      com.ceit.desktop.grpc.UploadRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ceit.desktop.grpc.UploadRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.ceit.desktop.grpc.UploadList> uploadlist_ =
      java.util.Collections.emptyList();
    private void ensureUploadlistIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        uploadlist_ = new java.util.ArrayList<com.ceit.desktop.grpc.UploadList>(uploadlist_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.ceit.desktop.grpc.UploadList, com.ceit.desktop.grpc.UploadList.Builder, com.ceit.desktop.grpc.UploadListOrBuilder> uploadlistBuilder_;

    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public java.util.List<com.ceit.desktop.grpc.UploadList> getUploadlistList() {
      if (uploadlistBuilder_ == null) {
        return java.util.Collections.unmodifiableList(uploadlist_);
      } else {
        return uploadlistBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public int getUploadlistCount() {
      if (uploadlistBuilder_ == null) {
        return uploadlist_.size();
      } else {
        return uploadlistBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public com.ceit.desktop.grpc.UploadList getUploadlist(int index) {
      if (uploadlistBuilder_ == null) {
        return uploadlist_.get(index);
      } else {
        return uploadlistBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder setUploadlist(
        int index, com.ceit.desktop.grpc.UploadList value) {
      if (uploadlistBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUploadlistIsMutable();
        uploadlist_.set(index, value);
        onChanged();
      } else {
        uploadlistBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder setUploadlist(
        int index, com.ceit.desktop.grpc.UploadList.Builder builderForValue) {
      if (uploadlistBuilder_ == null) {
        ensureUploadlistIsMutable();
        uploadlist_.set(index, builderForValue.build());
        onChanged();
      } else {
        uploadlistBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder addUploadlist(com.ceit.desktop.grpc.UploadList value) {
      if (uploadlistBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUploadlistIsMutable();
        uploadlist_.add(value);
        onChanged();
      } else {
        uploadlistBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder addUploadlist(
        int index, com.ceit.desktop.grpc.UploadList value) {
      if (uploadlistBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUploadlistIsMutable();
        uploadlist_.add(index, value);
        onChanged();
      } else {
        uploadlistBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder addUploadlist(
        com.ceit.desktop.grpc.UploadList.Builder builderForValue) {
      if (uploadlistBuilder_ == null) {
        ensureUploadlistIsMutable();
        uploadlist_.add(builderForValue.build());
        onChanged();
      } else {
        uploadlistBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder addUploadlist(
        int index, com.ceit.desktop.grpc.UploadList.Builder builderForValue) {
      if (uploadlistBuilder_ == null) {
        ensureUploadlistIsMutable();
        uploadlist_.add(index, builderForValue.build());
        onChanged();
      } else {
        uploadlistBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder addAllUploadlist(
        java.lang.Iterable<? extends com.ceit.desktop.grpc.UploadList> values) {
      if (uploadlistBuilder_ == null) {
        ensureUploadlistIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, uploadlist_);
        onChanged();
      } else {
        uploadlistBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder clearUploadlist() {
      if (uploadlistBuilder_ == null) {
        uploadlist_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        uploadlistBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public Builder removeUploadlist(int index) {
      if (uploadlistBuilder_ == null) {
        ensureUploadlistIsMutable();
        uploadlist_.remove(index);
        onChanged();
      } else {
        uploadlistBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public com.ceit.desktop.grpc.UploadList.Builder getUploadlistBuilder(
        int index) {
      return getUploadlistFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public com.ceit.desktop.grpc.UploadListOrBuilder getUploadlistOrBuilder(
        int index) {
      if (uploadlistBuilder_ == null) {
        return uploadlist_.get(index);  } else {
        return uploadlistBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public java.util.List<? extends com.ceit.desktop.grpc.UploadListOrBuilder> 
         getUploadlistOrBuilderList() {
      if (uploadlistBuilder_ != null) {
        return uploadlistBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(uploadlist_);
      }
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public com.ceit.desktop.grpc.UploadList.Builder addUploadlistBuilder() {
      return getUploadlistFieldBuilder().addBuilder(
          com.ceit.desktop.grpc.UploadList.getDefaultInstance());
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public com.ceit.desktop.grpc.UploadList.Builder addUploadlistBuilder(
        int index) {
      return getUploadlistFieldBuilder().addBuilder(
          index, com.ceit.desktop.grpc.UploadList.getDefaultInstance());
    }
    /**
     * <code>repeated .softwareupload.UploadList uploadlist = 1;</code>
     */
    public java.util.List<com.ceit.desktop.grpc.UploadList.Builder> 
         getUploadlistBuilderList() {
      return getUploadlistFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.ceit.desktop.grpc.UploadList, com.ceit.desktop.grpc.UploadList.Builder, com.ceit.desktop.grpc.UploadListOrBuilder> 
        getUploadlistFieldBuilder() {
      if (uploadlistBuilder_ == null) {
        uploadlistBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.ceit.desktop.grpc.UploadList, com.ceit.desktop.grpc.UploadList.Builder, com.ceit.desktop.grpc.UploadListOrBuilder>(
                uploadlist_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        uploadlist_ = null;
      }
      return uploadlistBuilder_;
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


    // @@protoc_insertion_point(builder_scope:softwareupload.UploadRequest)
  }

  // @@protoc_insertion_point(class_scope:softwareupload.UploadRequest)
  private static final com.ceit.desktop.grpc.UploadRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ceit.desktop.grpc.UploadRequest();
  }

  public static com.ceit.desktop.grpc.UploadRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UploadRequest>
      PARSER = new com.google.protobuf.AbstractParser<UploadRequest>() {
    @java.lang.Override
    public UploadRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UploadRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UploadRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UploadRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ceit.desktop.grpc.UploadRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
