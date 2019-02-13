/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.quwan.beebee.param.topic;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-12-25")
public class TopicCommentPraiseParam implements org.apache.thrift.TBase<TopicCommentPraiseParam, TopicCommentPraiseParam._Fields>, java.io.Serializable, Cloneable, Comparable<TopicCommentPraiseParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TopicCommentPraiseParam");

  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField COMMENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("commentId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField VALID_FIELD_DESC = new org.apache.thrift.protocol.TField("valid", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TopicCommentPraiseParamStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TopicCommentPraiseParamTupleSchemeFactory();

  public int userId; // required
  public int commentId; // required
  public int valid; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_ID((short)1, "userId"),
    COMMENT_ID((short)2, "commentId"),
    VALID((short)3, "valid");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // USER_ID
          return USER_ID;
        case 2: // COMMENT_ID
          return COMMENT_ID;
        case 3: // VALID
          return VALID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __USERID_ISSET_ID = 0;
  private static final int __COMMENTID_ISSET_ID = 1;
  private static final int __VALID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMMENT_ID, new org.apache.thrift.meta_data.FieldMetaData("commentId", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.VALID, new org.apache.thrift.meta_data.FieldMetaData("valid", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TopicCommentPraiseParam.class, metaDataMap);
  }

  public TopicCommentPraiseParam() {
  }

  public TopicCommentPraiseParam(
    int userId,
    int commentId,
    int valid)
  {
    this();
    this.userId = userId;
    setUserIdIsSet(true);
    this.commentId = commentId;
    setCommentIdIsSet(true);
    this.valid = valid;
    setValidIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TopicCommentPraiseParam(TopicCommentPraiseParam other) {
    __isset_bitfield = other.__isset_bitfield;
    this.userId = other.userId;
    this.commentId = other.commentId;
    this.valid = other.valid;
  }

  public TopicCommentPraiseParam deepCopy() {
    return new TopicCommentPraiseParam(this);
  }

  @Override
  public void clear() {
    setUserIdIsSet(false);
    this.userId = 0;
    setCommentIdIsSet(false);
    this.commentId = 0;
    setValidIsSet(false);
    this.valid = 0;
  }

  public int getUserId() {
    return this.userId;
  }

  public TopicCommentPraiseParam setUserId(int userId) {
    this.userId = userId;
    setUserIdIsSet(true);
    return this;
  }

  public void unsetUserId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  public void setUserIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
  }

  public int getCommentId() {
    return this.commentId;
  }

  public TopicCommentPraiseParam setCommentId(int commentId) {
    this.commentId = commentId;
    setCommentIdIsSet(true);
    return this;
  }

  public void unsetCommentId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __COMMENTID_ISSET_ID);
  }

  /** Returns true if field commentId is set (has been assigned a value) and false otherwise */
  public boolean isSetCommentId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __COMMENTID_ISSET_ID);
  }

  public void setCommentIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __COMMENTID_ISSET_ID, value);
  }

  public int getValid() {
    return this.valid;
  }

  public TopicCommentPraiseParam setValid(int valid) {
    this.valid = valid;
    setValidIsSet(true);
    return this;
  }

  public void unsetValid() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __VALID_ISSET_ID);
  }

  /** Returns true if field valid is set (has been assigned a value) and false otherwise */
  public boolean isSetValid() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __VALID_ISSET_ID);
  }

  public void setValidIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __VALID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Integer)value);
      }
      break;

    case COMMENT_ID:
      if (value == null) {
        unsetCommentId();
      } else {
        setCommentId((Integer)value);
      }
      break;

    case VALID:
      if (value == null) {
        unsetValid();
      } else {
        setValid((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_ID:
      return getUserId();

    case COMMENT_ID:
      return getCommentId();

    case VALID:
      return getValid();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_ID:
      return isSetUserId();
    case COMMENT_ID:
      return isSetCommentId();
    case VALID:
      return isSetValid();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TopicCommentPraiseParam)
      return this.equals((TopicCommentPraiseParam)that);
    return false;
  }

  public boolean equals(TopicCommentPraiseParam that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_userId = true;
    boolean that_present_userId = true;
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    boolean this_present_commentId = true;
    boolean that_present_commentId = true;
    if (this_present_commentId || that_present_commentId) {
      if (!(this_present_commentId && that_present_commentId))
        return false;
      if (this.commentId != that.commentId)
        return false;
    }

    boolean this_present_valid = true;
    boolean that_present_valid = true;
    if (this_present_valid || that_present_valid) {
      if (!(this_present_valid && that_present_valid))
        return false;
      if (this.valid != that.valid)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + userId;

    hashCode = hashCode * 8191 + commentId;

    hashCode = hashCode * 8191 + valid;

    return hashCode;
  }

  @Override
  public int compareTo(TopicCommentPraiseParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCommentId()).compareTo(other.isSetCommentId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommentId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commentId, other.commentId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValid()).compareTo(other.isSetValid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.valid, other.valid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TopicCommentPraiseParam(");
    boolean first = true;

    sb.append("userId:");
    sb.append(this.userId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("commentId:");
    sb.append(this.commentId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("valid:");
    sb.append(this.valid);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'userId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'commentId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'valid' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TopicCommentPraiseParamStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TopicCommentPraiseParamStandardScheme getScheme() {
      return new TopicCommentPraiseParamStandardScheme();
    }
  }

  private static class TopicCommentPraiseParamStandardScheme extends org.apache.thrift.scheme.StandardScheme<TopicCommentPraiseParam> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TopicCommentPraiseParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userId = iprot.readI32();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMMENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.commentId = iprot.readI32();
              struct.setCommentIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VALID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.valid = iprot.readI32();
              struct.setValidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetUserId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'userId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetCommentId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'commentId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetValid()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'valid' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TopicCommentPraiseParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI32(struct.userId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(COMMENT_ID_FIELD_DESC);
      oprot.writeI32(struct.commentId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(VALID_FIELD_DESC);
      oprot.writeI32(struct.valid);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TopicCommentPraiseParamTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TopicCommentPraiseParamTupleScheme getScheme() {
      return new TopicCommentPraiseParamTupleScheme();
    }
  }

  private static class TopicCommentPraiseParamTupleScheme extends org.apache.thrift.scheme.TupleScheme<TopicCommentPraiseParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TopicCommentPraiseParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.userId);
      oprot.writeI32(struct.commentId);
      oprot.writeI32(struct.valid);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TopicCommentPraiseParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.userId = iprot.readI32();
      struct.setUserIdIsSet(true);
      struct.commentId = iprot.readI32();
      struct.setCommentIdIsSet(true);
      struct.valid = iprot.readI32();
      struct.setValidIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
