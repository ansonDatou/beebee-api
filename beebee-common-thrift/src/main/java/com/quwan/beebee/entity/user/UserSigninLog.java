/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.quwan.beebee.entity.user;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-12-07")
public class UserSigninLog implements org.apache.thrift.TBase<UserSigninLog, UserSigninLog._Fields>, java.io.Serializable, Cloneable, Comparable<UserSigninLog> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserSigninLog");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SIGNDATE_FIELD_DESC = new org.apache.thrift.protocol.TField("signdate", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField ADDTIME_FIELD_DESC = new org.apache.thrift.protocol.TField("addtime", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new UserSigninLogStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new UserSigninLogTupleSchemeFactory();

  public int id; // required
  public int userId; // required
  public String signdate; // required
  public String addtime; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    USER_ID((short)2, "userId"),
    SIGNDATE((short)3, "signdate"),
    ADDTIME((short)4, "addtime");

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
        case 1: // ID
          return ID;
        case 2: // USER_ID
          return USER_ID;
        case 3: // SIGNDATE
          return SIGNDATE;
        case 4: // ADDTIME
          return ADDTIME;
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __USERID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SIGNDATE, new org.apache.thrift.meta_data.FieldMetaData("signdate", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ADDTIME, new org.apache.thrift.meta_data.FieldMetaData("addtime", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserSigninLog.class, metaDataMap);
  }

  public UserSigninLog() {
  }

  public UserSigninLog(
    int id,
    int userId,
    String signdate,
    String addtime)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.userId = userId;
    setUserIdIsSet(true);
    this.signdate = signdate;
    this.addtime = addtime;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserSigninLog(UserSigninLog other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.userId = other.userId;
    if (other.isSetSigndate()) {
      this.signdate = other.signdate;
    }
    if (other.isSetAddtime()) {
      this.addtime = other.addtime;
    }
  }

  public UserSigninLog deepCopy() {
    return new UserSigninLog(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setUserIdIsSet(false);
    this.userId = 0;
    this.signdate = null;
    this.addtime = null;
  }

  public int getId() {
    return this.id;
  }

  public UserSigninLog setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public int getUserId() {
    return this.userId;
  }

  public UserSigninLog setUserId(int userId) {
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

  public String getSigndate() {
    return this.signdate;
  }

  public UserSigninLog setSigndate(String signdate) {
    this.signdate = signdate;
    return this;
  }

  public void unsetSigndate() {
    this.signdate = null;
  }

  /** Returns true if field signdate is set (has been assigned a value) and false otherwise */
  public boolean isSetSigndate() {
    return this.signdate != null;
  }

  public void setSigndateIsSet(boolean value) {
    if (!value) {
      this.signdate = null;
    }
  }

  public String getAddtime() {
    return this.addtime;
  }

  public UserSigninLog setAddtime(String addtime) {
    this.addtime = addtime;
    return this;
  }

  public void unsetAddtime() {
    this.addtime = null;
  }

  /** Returns true if field addtime is set (has been assigned a value) and false otherwise */
  public boolean isSetAddtime() {
    return this.addtime != null;
  }

  public void setAddtimeIsSet(boolean value) {
    if (!value) {
      this.addtime = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Integer)value);
      }
      break;

    case SIGNDATE:
      if (value == null) {
        unsetSigndate();
      } else {
        setSigndate((String)value);
      }
      break;

    case ADDTIME:
      if (value == null) {
        unsetAddtime();
      } else {
        setAddtime((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case USER_ID:
      return getUserId();

    case SIGNDATE:
      return getSigndate();

    case ADDTIME:
      return getAddtime();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case USER_ID:
      return isSetUserId();
    case SIGNDATE:
      return isSetSigndate();
    case ADDTIME:
      return isSetAddtime();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserSigninLog)
      return this.equals((UserSigninLog)that);
    return false;
  }

  public boolean equals(UserSigninLog that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
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

    boolean this_present_signdate = true && this.isSetSigndate();
    boolean that_present_signdate = true && that.isSetSigndate();
    if (this_present_signdate || that_present_signdate) {
      if (!(this_present_signdate && that_present_signdate))
        return false;
      if (!this.signdate.equals(that.signdate))
        return false;
    }

    boolean this_present_addtime = true && this.isSetAddtime();
    boolean that_present_addtime = true && that.isSetAddtime();
    if (this_present_addtime || that_present_addtime) {
      if (!(this_present_addtime && that_present_addtime))
        return false;
      if (!this.addtime.equals(that.addtime))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + userId;

    hashCode = hashCode * 8191 + ((isSetSigndate()) ? 131071 : 524287);
    if (isSetSigndate())
      hashCode = hashCode * 8191 + signdate.hashCode();

    hashCode = hashCode * 8191 + ((isSetAddtime()) ? 131071 : 524287);
    if (isSetAddtime())
      hashCode = hashCode * 8191 + addtime.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(UserSigninLog other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
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
    lastComparison = Boolean.valueOf(isSetSigndate()).compareTo(other.isSetSigndate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSigndate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.signdate, other.signdate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAddtime()).compareTo(other.isSetAddtime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAddtime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.addtime, other.addtime);
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
    StringBuilder sb = new StringBuilder("UserSigninLog(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("userId:");
    sb.append(this.userId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("signdate:");
    if (this.signdate == null) {
      sb.append("null");
    } else {
      sb.append(this.signdate);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("addtime:");
    if (this.addtime == null) {
      sb.append("null");
    } else {
      sb.append(this.addtime);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'id' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'userId' because it's a primitive and you chose the non-beans generator.
    if (signdate == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'signdate' was not present! Struct: " + toString());
    }
    if (addtime == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'addtime' was not present! Struct: " + toString());
    }
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

  private static class UserSigninLogStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public UserSigninLogStandardScheme getScheme() {
      return new UserSigninLogStandardScheme();
    }
  }

  private static class UserSigninLogStandardScheme extends org.apache.thrift.scheme.StandardScheme<UserSigninLog> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserSigninLog struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userId = iprot.readI32();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SIGNDATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.signdate = iprot.readString();
              struct.setSigndateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ADDTIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.addtime = iprot.readString();
              struct.setAddtimeIsSet(true);
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
      if (!struct.isSetId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'id' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetUserId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'userId' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserSigninLog struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI32(struct.userId);
      oprot.writeFieldEnd();
      if (struct.signdate != null) {
        oprot.writeFieldBegin(SIGNDATE_FIELD_DESC);
        oprot.writeString(struct.signdate);
        oprot.writeFieldEnd();
      }
      if (struct.addtime != null) {
        oprot.writeFieldBegin(ADDTIME_FIELD_DESC);
        oprot.writeString(struct.addtime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserSigninLogTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public UserSigninLogTupleScheme getScheme() {
      return new UserSigninLogTupleScheme();
    }
  }

  private static class UserSigninLogTupleScheme extends org.apache.thrift.scheme.TupleScheme<UserSigninLog> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserSigninLog struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.id);
      oprot.writeI32(struct.userId);
      oprot.writeString(struct.signdate);
      oprot.writeString(struct.addtime);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserSigninLog struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.id = iprot.readI32();
      struct.setIdIsSet(true);
      struct.userId = iprot.readI32();
      struct.setUserIdIsSet(true);
      struct.signdate = iprot.readString();
      struct.setSigndateIsSet(true);
      struct.addtime = iprot.readString();
      struct.setAddtimeIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

