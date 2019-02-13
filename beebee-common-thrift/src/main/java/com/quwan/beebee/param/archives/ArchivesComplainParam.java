/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.quwan.beebee.param.archives;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2018-01-09")
public class ArchivesComplainParam implements org.apache.thrift.TBase<ArchivesComplainParam, ArchivesComplainParam._Fields>, java.io.Serializable, Cloneable, Comparable<ArchivesComplainParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ArchivesComplainParam");

  private static final org.apache.thrift.protocol.TField ARCH_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("archId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField REASON_FIELD_DESC = new org.apache.thrift.protocol.TField("reason", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DEVICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceId", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField DEVICE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceType", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ArchivesComplainParamStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ArchivesComplainParamTupleSchemeFactory();

  public int archId; // required
  public int userId; // optional
  public String reason; // required
  public String deviceId; // required
  public int deviceType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ARCH_ID((short)1, "archId"),
    USER_ID((short)2, "userId"),
    REASON((short)3, "reason"),
    DEVICE_ID((short)4, "deviceId"),
    DEVICE_TYPE((short)5, "deviceType");

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
        case 1: // ARCH_ID
          return ARCH_ID;
        case 2: // USER_ID
          return USER_ID;
        case 3: // REASON
          return REASON;
        case 4: // DEVICE_ID
          return DEVICE_ID;
        case 5: // DEVICE_TYPE
          return DEVICE_TYPE;
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
  private static final int __ARCHID_ISSET_ID = 0;
  private static final int __USERID_ISSET_ID = 1;
  private static final int __DEVICETYPE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.USER_ID};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ARCH_ID, new org.apache.thrift.meta_data.FieldMetaData("archId", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.REASON, new org.apache.thrift.meta_data.FieldMetaData("reason", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEVICE_ID, new org.apache.thrift.meta_data.FieldMetaData("deviceId", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEVICE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("deviceType", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ArchivesComplainParam.class, metaDataMap);
  }

  public ArchivesComplainParam() {
  }

  public ArchivesComplainParam(
    int archId,
    String reason,
    String deviceId,
    int deviceType)
  {
    this();
    this.archId = archId;
    setArchIdIsSet(true);
    this.reason = reason;
    this.deviceId = deviceId;
    this.deviceType = deviceType;
    setDeviceTypeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ArchivesComplainParam(ArchivesComplainParam other) {
    __isset_bitfield = other.__isset_bitfield;
    this.archId = other.archId;
    this.userId = other.userId;
    if (other.isSetReason()) {
      this.reason = other.reason;
    }
    if (other.isSetDeviceId()) {
      this.deviceId = other.deviceId;
    }
    this.deviceType = other.deviceType;
  }

  public ArchivesComplainParam deepCopy() {
    return new ArchivesComplainParam(this);
  }

  @Override
  public void clear() {
    setArchIdIsSet(false);
    this.archId = 0;
    setUserIdIsSet(false);
    this.userId = 0;
    this.reason = null;
    this.deviceId = null;
    setDeviceTypeIsSet(false);
    this.deviceType = 0;
  }

  public int getArchId() {
    return this.archId;
  }

  public ArchivesComplainParam setArchId(int archId) {
    this.archId = archId;
    setArchIdIsSet(true);
    return this;
  }

  public void unsetArchId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ARCHID_ISSET_ID);
  }

  /** Returns true if field archId is set (has been assigned a value) and false otherwise */
  public boolean isSetArchId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ARCHID_ISSET_ID);
  }

  public void setArchIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ARCHID_ISSET_ID, value);
  }

  public int getUserId() {
    return this.userId;
  }

  public ArchivesComplainParam setUserId(int userId) {
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

  public String getReason() {
    return this.reason;
  }

  public ArchivesComplainParam setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public void unsetReason() {
    this.reason = null;
  }

  /** Returns true if field reason is set (has been assigned a value) and false otherwise */
  public boolean isSetReason() {
    return this.reason != null;
  }

  public void setReasonIsSet(boolean value) {
    if (!value) {
      this.reason = null;
    }
  }

  public String getDeviceId() {
    return this.deviceId;
  }

  public ArchivesComplainParam setDeviceId(String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  public void unsetDeviceId() {
    this.deviceId = null;
  }

  /** Returns true if field deviceId is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceId() {
    return this.deviceId != null;
  }

  public void setDeviceIdIsSet(boolean value) {
    if (!value) {
      this.deviceId = null;
    }
  }

  public int getDeviceType() {
    return this.deviceType;
  }

  public ArchivesComplainParam setDeviceType(int deviceType) {
    this.deviceType = deviceType;
    setDeviceTypeIsSet(true);
    return this;
  }

  public void unsetDeviceType() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DEVICETYPE_ISSET_ID);
  }

  /** Returns true if field deviceType is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceType() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DEVICETYPE_ISSET_ID);
  }

  public void setDeviceTypeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DEVICETYPE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ARCH_ID:
      if (value == null) {
        unsetArchId();
      } else {
        setArchId((Integer)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Integer)value);
      }
      break;

    case REASON:
      if (value == null) {
        unsetReason();
      } else {
        setReason((String)value);
      }
      break;

    case DEVICE_ID:
      if (value == null) {
        unsetDeviceId();
      } else {
        setDeviceId((String)value);
      }
      break;

    case DEVICE_TYPE:
      if (value == null) {
        unsetDeviceType();
      } else {
        setDeviceType((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ARCH_ID:
      return getArchId();

    case USER_ID:
      return getUserId();

    case REASON:
      return getReason();

    case DEVICE_ID:
      return getDeviceId();

    case DEVICE_TYPE:
      return getDeviceType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ARCH_ID:
      return isSetArchId();
    case USER_ID:
      return isSetUserId();
    case REASON:
      return isSetReason();
    case DEVICE_ID:
      return isSetDeviceId();
    case DEVICE_TYPE:
      return isSetDeviceType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ArchivesComplainParam)
      return this.equals((ArchivesComplainParam)that);
    return false;
  }

  public boolean equals(ArchivesComplainParam that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_archId = true;
    boolean that_present_archId = true;
    if (this_present_archId || that_present_archId) {
      if (!(this_present_archId && that_present_archId))
        return false;
      if (this.archId != that.archId)
        return false;
    }

    boolean this_present_userId = true && this.isSetUserId();
    boolean that_present_userId = true && that.isSetUserId();
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    boolean this_present_reason = true && this.isSetReason();
    boolean that_present_reason = true && that.isSetReason();
    if (this_present_reason || that_present_reason) {
      if (!(this_present_reason && that_present_reason))
        return false;
      if (!this.reason.equals(that.reason))
        return false;
    }

    boolean this_present_deviceId = true && this.isSetDeviceId();
    boolean that_present_deviceId = true && that.isSetDeviceId();
    if (this_present_deviceId || that_present_deviceId) {
      if (!(this_present_deviceId && that_present_deviceId))
        return false;
      if (!this.deviceId.equals(that.deviceId))
        return false;
    }

    boolean this_present_deviceType = true;
    boolean that_present_deviceType = true;
    if (this_present_deviceType || that_present_deviceType) {
      if (!(this_present_deviceType && that_present_deviceType))
        return false;
      if (this.deviceType != that.deviceType)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + archId;

    hashCode = hashCode * 8191 + ((isSetUserId()) ? 131071 : 524287);
    if (isSetUserId())
      hashCode = hashCode * 8191 + userId;

    hashCode = hashCode * 8191 + ((isSetReason()) ? 131071 : 524287);
    if (isSetReason())
      hashCode = hashCode * 8191 + reason.hashCode();

    hashCode = hashCode * 8191 + ((isSetDeviceId()) ? 131071 : 524287);
    if (isSetDeviceId())
      hashCode = hashCode * 8191 + deviceId.hashCode();

    hashCode = hashCode * 8191 + deviceType;

    return hashCode;
  }

  @Override
  public int compareTo(ArchivesComplainParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetArchId()).compareTo(other.isSetArchId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArchId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.archId, other.archId);
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
    lastComparison = Boolean.valueOf(isSetReason()).compareTo(other.isSetReason());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReason()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reason, other.reason);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeviceId()).compareTo(other.isSetDeviceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceId, other.deviceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeviceType()).compareTo(other.isSetDeviceType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceType, other.deviceType);
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
    StringBuilder sb = new StringBuilder("ArchivesComplainParam(");
    boolean first = true;

    sb.append("archId:");
    sb.append(this.archId);
    first = false;
    if (isSetUserId()) {
      if (!first) sb.append(", ");
      sb.append("userId:");
      sb.append(this.userId);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("reason:");
    if (this.reason == null) {
      sb.append("null");
    } else {
      sb.append(this.reason);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("deviceId:");
    if (this.deviceId == null) {
      sb.append("null");
    } else {
      sb.append(this.deviceId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("deviceType:");
    sb.append(this.deviceType);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'archId' because it's a primitive and you chose the non-beans generator.
    if (reason == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'reason' was not present! Struct: " + toString());
    }
    if (deviceId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'deviceId' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'deviceType' because it's a primitive and you chose the non-beans generator.
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

  private static class ArchivesComplainParamStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ArchivesComplainParamStandardScheme getScheme() {
      return new ArchivesComplainParamStandardScheme();
    }
  }

  private static class ArchivesComplainParamStandardScheme extends org.apache.thrift.scheme.StandardScheme<ArchivesComplainParam> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ArchivesComplainParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ARCH_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.archId = iprot.readI32();
              struct.setArchIdIsSet(true);
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
          case 3: // REASON
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reason = iprot.readString();
              struct.setReasonIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DEVICE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.deviceId = iprot.readString();
              struct.setDeviceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // DEVICE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.deviceType = iprot.readI32();
              struct.setDeviceTypeIsSet(true);
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
      if (!struct.isSetArchId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'archId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetDeviceType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'deviceType' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ArchivesComplainParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ARCH_ID_FIELD_DESC);
      oprot.writeI32(struct.archId);
      oprot.writeFieldEnd();
      if (struct.isSetUserId()) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        oprot.writeI32(struct.userId);
        oprot.writeFieldEnd();
      }
      if (struct.reason != null) {
        oprot.writeFieldBegin(REASON_FIELD_DESC);
        oprot.writeString(struct.reason);
        oprot.writeFieldEnd();
      }
      if (struct.deviceId != null) {
        oprot.writeFieldBegin(DEVICE_ID_FIELD_DESC);
        oprot.writeString(struct.deviceId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(DEVICE_TYPE_FIELD_DESC);
      oprot.writeI32(struct.deviceType);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ArchivesComplainParamTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ArchivesComplainParamTupleScheme getScheme() {
      return new ArchivesComplainParamTupleScheme();
    }
  }

  private static class ArchivesComplainParamTupleScheme extends org.apache.thrift.scheme.TupleScheme<ArchivesComplainParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ArchivesComplainParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.archId);
      oprot.writeString(struct.reason);
      oprot.writeString(struct.deviceId);
      oprot.writeI32(struct.deviceType);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetUserId()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetUserId()) {
        oprot.writeI32(struct.userId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ArchivesComplainParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.archId = iprot.readI32();
      struct.setArchIdIsSet(true);
      struct.reason = iprot.readString();
      struct.setReasonIsSet(true);
      struct.deviceId = iprot.readString();
      struct.setDeviceIdIsSet(true);
      struct.deviceType = iprot.readI32();
      struct.setDeviceTypeIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.userId = iprot.readI32();
        struct.setUserIdIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
