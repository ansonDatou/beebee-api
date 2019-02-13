/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.quwan.beebee.param.user;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-12-23")
public class NotificationParam implements org.apache.thrift.TBase<NotificationParam, NotificationParam._Fields>, java.io.Serializable, Cloneable, Comparable<NotificationParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NotificationParam");

  private static final org.apache.thrift.protocol.TField PAGE_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("pageNumber", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PAGE_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("pageSize", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new NotificationParamStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new NotificationParamTupleSchemeFactory();

  public int pageNumber; // required
  public int pageSize; // required
  public int userId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PAGE_NUMBER((short)1, "pageNumber"),
    PAGE_SIZE((short)2, "pageSize"),
    USER_ID((short)3, "userId");

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
        case 1: // PAGE_NUMBER
          return PAGE_NUMBER;
        case 2: // PAGE_SIZE
          return PAGE_SIZE;
        case 3: // USER_ID
          return USER_ID;
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
  private static final int __PAGENUMBER_ISSET_ID = 0;
  private static final int __PAGESIZE_ISSET_ID = 1;
  private static final int __USERID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PAGE_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("pageNumber", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAGE_SIZE, new org.apache.thrift.meta_data.FieldMetaData("pageSize", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NotificationParam.class, metaDataMap);
  }

  public NotificationParam() {
  }

  public NotificationParam(
    int pageNumber,
    int pageSize,
    int userId)
  {
    this();
    this.pageNumber = pageNumber;
    setPageNumberIsSet(true);
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    this.userId = userId;
    setUserIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NotificationParam(NotificationParam other) {
    __isset_bitfield = other.__isset_bitfield;
    this.pageNumber = other.pageNumber;
    this.pageSize = other.pageSize;
    this.userId = other.userId;
  }

  public NotificationParam deepCopy() {
    return new NotificationParam(this);
  }

  @Override
  public void clear() {
    setPageNumberIsSet(false);
    this.pageNumber = 0;
    setPageSizeIsSet(false);
    this.pageSize = 0;
    setUserIdIsSet(false);
    this.userId = 0;
  }

  public int getPageNumber() {
    return this.pageNumber;
  }

  public NotificationParam setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
    setPageNumberIsSet(true);
    return this;
  }

  public void unsetPageNumber() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PAGENUMBER_ISSET_ID);
  }

  /** Returns true if field pageNumber is set (has been assigned a value) and false otherwise */
  public boolean isSetPageNumber() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PAGENUMBER_ISSET_ID);
  }

  public void setPageNumberIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PAGENUMBER_ISSET_ID, value);
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public NotificationParam setPageSize(int pageSize) {
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    return this;
  }

  public void unsetPageSize() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  /** Returns true if field pageSize is set (has been assigned a value) and false otherwise */
  public boolean isSetPageSize() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  public void setPageSizeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PAGESIZE_ISSET_ID, value);
  }

  public int getUserId() {
    return this.userId;
  }

  public NotificationParam setUserId(int userId) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PAGE_NUMBER:
      if (value == null) {
        unsetPageNumber();
      } else {
        setPageNumber((Integer)value);
      }
      break;

    case PAGE_SIZE:
      if (value == null) {
        unsetPageSize();
      } else {
        setPageSize((Integer)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PAGE_NUMBER:
      return getPageNumber();

    case PAGE_SIZE:
      return getPageSize();

    case USER_ID:
      return getUserId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PAGE_NUMBER:
      return isSetPageNumber();
    case PAGE_SIZE:
      return isSetPageSize();
    case USER_ID:
      return isSetUserId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NotificationParam)
      return this.equals((NotificationParam)that);
    return false;
  }

  public boolean equals(NotificationParam that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_pageNumber = true;
    boolean that_present_pageNumber = true;
    if (this_present_pageNumber || that_present_pageNumber) {
      if (!(this_present_pageNumber && that_present_pageNumber))
        return false;
      if (this.pageNumber != that.pageNumber)
        return false;
    }

    boolean this_present_pageSize = true;
    boolean that_present_pageSize = true;
    if (this_present_pageSize || that_present_pageSize) {
      if (!(this_present_pageSize && that_present_pageSize))
        return false;
      if (this.pageSize != that.pageSize)
        return false;
    }

    boolean this_present_userId = true;
    boolean that_present_userId = true;
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + pageNumber;

    hashCode = hashCode * 8191 + pageSize;

    hashCode = hashCode * 8191 + userId;

    return hashCode;
  }

  @Override
  public int compareTo(NotificationParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPageNumber()).compareTo(other.isSetPageNumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageNumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageNumber, other.pageNumber);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageSize()).compareTo(other.isSetPageSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageSize, other.pageSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    StringBuilder sb = new StringBuilder("NotificationParam(");
    boolean first = true;

    sb.append("pageNumber:");
    sb.append(this.pageNumber);
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageSize:");
    sb.append(this.pageSize);
    first = false;
    if (!first) sb.append(", ");
    sb.append("userId:");
    sb.append(this.userId);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'pageNumber' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'pageSize' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'userId' because it's a primitive and you chose the non-beans generator.
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

  private static class NotificationParamStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public NotificationParamStandardScheme getScheme() {
      return new NotificationParamStandardScheme();
    }
  }

  private static class NotificationParamStandardScheme extends org.apache.thrift.scheme.StandardScheme<NotificationParam> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, NotificationParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PAGE_NUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageNumber = iprot.readI32();
              struct.setPageNumberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAGE_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageSize = iprot.readI32();
              struct.setPageSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userId = iprot.readI32();
              struct.setUserIdIsSet(true);
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
      if (!struct.isSetPageNumber()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'pageNumber' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetPageSize()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'pageSize' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetUserId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'userId' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, NotificationParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(PAGE_NUMBER_FIELD_DESC);
      oprot.writeI32(struct.pageNumber);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PAGE_SIZE_FIELD_DESC);
      oprot.writeI32(struct.pageSize);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI32(struct.userId);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class NotificationParamTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public NotificationParamTupleScheme getScheme() {
      return new NotificationParamTupleScheme();
    }
  }

  private static class NotificationParamTupleScheme extends org.apache.thrift.scheme.TupleScheme<NotificationParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, NotificationParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.pageNumber);
      oprot.writeI32(struct.pageSize);
      oprot.writeI32(struct.userId);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, NotificationParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.pageNumber = iprot.readI32();
      struct.setPageNumberIsSet(true);
      struct.pageSize = iprot.readI32();
      struct.setPageSizeIsSet(true);
      struct.userId = iprot.readI32();
      struct.setUserIdIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
