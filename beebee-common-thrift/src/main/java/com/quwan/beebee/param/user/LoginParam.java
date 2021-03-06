/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.quwan.beebee.param.user;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2018-01-22")
public class LoginParam implements org.apache.thrift.TBase<LoginParam, LoginParam._Fields>, java.io.Serializable, Cloneable, Comparable<LoginParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LoginParam");

  private static final org.apache.thrift.protocol.TField MOBILE_FIELD_DESC = new org.apache.thrift.protocol.TField("mobile", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PWD_FIELD_DESC = new org.apache.thrift.protocol.TField("pwd", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DEVICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceId", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DEVICE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceType", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LOGIN_IP_FIELD_DESC = new org.apache.thrift.protocol.TField("loginIp", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new LoginParamStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new LoginParamTupleSchemeFactory();

  public java.lang.String mobile; // required
  public java.lang.String pwd; // required
  public java.lang.String deviceId; // required
  public int deviceType; // required
  public java.lang.String loginIp; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MOBILE((short)1, "mobile"),
    PWD((short)2, "pwd"),
    DEVICE_ID((short)3, "deviceId"),
    DEVICE_TYPE((short)4, "deviceType"),
    LOGIN_IP((short)5, "loginIp");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

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
        case 1: // MOBILE
          return MOBILE;
        case 2: // PWD
          return PWD;
        case 3: // DEVICE_ID
          return DEVICE_ID;
        case 4: // DEVICE_TYPE
          return DEVICE_TYPE;
        case 5: // LOGIN_IP
          return LOGIN_IP;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __DEVICETYPE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MOBILE, new org.apache.thrift.meta_data.FieldMetaData("mobile", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PWD, new org.apache.thrift.meta_data.FieldMetaData("pwd", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEVICE_ID, new org.apache.thrift.meta_data.FieldMetaData("deviceId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEVICE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("deviceType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LOGIN_IP, new org.apache.thrift.meta_data.FieldMetaData("loginIp", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LoginParam.class, metaDataMap);
  }

  public LoginParam() {
  }

  public LoginParam(
    java.lang.String mobile,
    java.lang.String pwd,
    java.lang.String deviceId,
    int deviceType,
    java.lang.String loginIp)
  {
    this();
    this.mobile = mobile;
    this.pwd = pwd;
    this.deviceId = deviceId;
    this.deviceType = deviceType;
    setDeviceTypeIsSet(true);
    this.loginIp = loginIp;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LoginParam(LoginParam other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetMobile()) {
      this.mobile = other.mobile;
    }
    if (other.isSetPwd()) {
      this.pwd = other.pwd;
    }
    if (other.isSetDeviceId()) {
      this.deviceId = other.deviceId;
    }
    this.deviceType = other.deviceType;
    if (other.isSetLoginIp()) {
      this.loginIp = other.loginIp;
    }
  }

  public LoginParam deepCopy() {
    return new LoginParam(this);
  }

  @Override
  public void clear() {
    this.mobile = null;
    this.pwd = null;
    this.deviceId = null;
    setDeviceTypeIsSet(false);
    this.deviceType = 0;
    this.loginIp = null;
  }

  public java.lang.String getMobile() {
    return this.mobile;
  }

  public LoginParam setMobile(java.lang.String mobile) {
    this.mobile = mobile;
    return this;
  }

  public void unsetMobile() {
    this.mobile = null;
  }

  /** Returns true if field mobile is set (has been assigned a value) and false otherwise */
  public boolean isSetMobile() {
    return this.mobile != null;
  }

  public void setMobileIsSet(boolean value) {
    if (!value) {
      this.mobile = null;
    }
  }

  public java.lang.String getPwd() {
    return this.pwd;
  }

  public LoginParam setPwd(java.lang.String pwd) {
    this.pwd = pwd;
    return this;
  }

  public void unsetPwd() {
    this.pwd = null;
  }

  /** Returns true if field pwd is set (has been assigned a value) and false otherwise */
  public boolean isSetPwd() {
    return this.pwd != null;
  }

  public void setPwdIsSet(boolean value) {
    if (!value) {
      this.pwd = null;
    }
  }

  public java.lang.String getDeviceId() {
    return this.deviceId;
  }

  public LoginParam setDeviceId(java.lang.String deviceId) {
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

  public LoginParam setDeviceType(int deviceType) {
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

  public java.lang.String getLoginIp() {
    return this.loginIp;
  }

  public LoginParam setLoginIp(java.lang.String loginIp) {
    this.loginIp = loginIp;
    return this;
  }

  public void unsetLoginIp() {
    this.loginIp = null;
  }

  /** Returns true if field loginIp is set (has been assigned a value) and false otherwise */
  public boolean isSetLoginIp() {
    return this.loginIp != null;
  }

  public void setLoginIpIsSet(boolean value) {
    if (!value) {
      this.loginIp = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case MOBILE:
      if (value == null) {
        unsetMobile();
      } else {
        setMobile((java.lang.String)value);
      }
      break;

    case PWD:
      if (value == null) {
        unsetPwd();
      } else {
        setPwd((java.lang.String)value);
      }
      break;

    case DEVICE_ID:
      if (value == null) {
        unsetDeviceId();
      } else {
        setDeviceId((java.lang.String)value);
      }
      break;

    case DEVICE_TYPE:
      if (value == null) {
        unsetDeviceType();
      } else {
        setDeviceType((java.lang.Integer)value);
      }
      break;

    case LOGIN_IP:
      if (value == null) {
        unsetLoginIp();
      } else {
        setLoginIp((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case MOBILE:
      return getMobile();

    case PWD:
      return getPwd();

    case DEVICE_ID:
      return getDeviceId();

    case DEVICE_TYPE:
      return getDeviceType();

    case LOGIN_IP:
      return getLoginIp();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case MOBILE:
      return isSetMobile();
    case PWD:
      return isSetPwd();
    case DEVICE_ID:
      return isSetDeviceId();
    case DEVICE_TYPE:
      return isSetDeviceType();
    case LOGIN_IP:
      return isSetLoginIp();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof LoginParam)
      return this.equals((LoginParam)that);
    return false;
  }

  public boolean equals(LoginParam that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_mobile = true && this.isSetMobile();
    boolean that_present_mobile = true && that.isSetMobile();
    if (this_present_mobile || that_present_mobile) {
      if (!(this_present_mobile && that_present_mobile))
        return false;
      if (!this.mobile.equals(that.mobile))
        return false;
    }

    boolean this_present_pwd = true && this.isSetPwd();
    boolean that_present_pwd = true && that.isSetPwd();
    if (this_present_pwd || that_present_pwd) {
      if (!(this_present_pwd && that_present_pwd))
        return false;
      if (!this.pwd.equals(that.pwd))
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

    boolean this_present_loginIp = true && this.isSetLoginIp();
    boolean that_present_loginIp = true && that.isSetLoginIp();
    if (this_present_loginIp || that_present_loginIp) {
      if (!(this_present_loginIp && that_present_loginIp))
        return false;
      if (!this.loginIp.equals(that.loginIp))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetMobile()) ? 131071 : 524287);
    if (isSetMobile())
      hashCode = hashCode * 8191 + mobile.hashCode();

    hashCode = hashCode * 8191 + ((isSetPwd()) ? 131071 : 524287);
    if (isSetPwd())
      hashCode = hashCode * 8191 + pwd.hashCode();

    hashCode = hashCode * 8191 + ((isSetDeviceId()) ? 131071 : 524287);
    if (isSetDeviceId())
      hashCode = hashCode * 8191 + deviceId.hashCode();

    hashCode = hashCode * 8191 + deviceType;

    hashCode = hashCode * 8191 + ((isSetLoginIp()) ? 131071 : 524287);
    if (isSetLoginIp())
      hashCode = hashCode * 8191 + loginIp.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(LoginParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetMobile()).compareTo(other.isSetMobile());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMobile()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mobile, other.mobile);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPwd()).compareTo(other.isSetPwd());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPwd()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pwd, other.pwd);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDeviceId()).compareTo(other.isSetDeviceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceId, other.deviceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDeviceType()).compareTo(other.isSetDeviceType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceType, other.deviceType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetLoginIp()).compareTo(other.isSetLoginIp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLoginIp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.loginIp, other.loginIp);
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
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("LoginParam(");
    boolean first = true;

    sb.append("mobile:");
    if (this.mobile == null) {
      sb.append("null");
    } else {
      sb.append(this.mobile);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pwd:");
    if (this.pwd == null) {
      sb.append("null");
    } else {
      sb.append(this.pwd);
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
    if (!first) sb.append(", ");
    sb.append("loginIp:");
    if (this.loginIp == null) {
      sb.append("null");
    } else {
      sb.append(this.loginIp);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (mobile == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'mobile' was not present! Struct: " + toString());
    }
    if (pwd == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pwd' was not present! Struct: " + toString());
    }
    if (deviceId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'deviceId' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'deviceType' because it's a primitive and you chose the non-beans generator.
    if (loginIp == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'loginIp' was not present! Struct: " + toString());
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LoginParamStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public LoginParamStandardScheme getScheme() {
      return new LoginParamStandardScheme();
    }
  }

  private static class LoginParamStandardScheme extends org.apache.thrift.scheme.StandardScheme<LoginParam> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LoginParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MOBILE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mobile = iprot.readString();
              struct.setMobileIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PWD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.pwd = iprot.readString();
              struct.setPwdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEVICE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.deviceId = iprot.readString();
              struct.setDeviceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DEVICE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.deviceType = iprot.readI32();
              struct.setDeviceTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LOGIN_IP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.loginIp = iprot.readString();
              struct.setLoginIpIsSet(true);
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
      if (!struct.isSetDeviceType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'deviceType' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, LoginParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.mobile != null) {
        oprot.writeFieldBegin(MOBILE_FIELD_DESC);
        oprot.writeString(struct.mobile);
        oprot.writeFieldEnd();
      }
      if (struct.pwd != null) {
        oprot.writeFieldBegin(PWD_FIELD_DESC);
        oprot.writeString(struct.pwd);
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
      if (struct.loginIp != null) {
        oprot.writeFieldBegin(LOGIN_IP_FIELD_DESC);
        oprot.writeString(struct.loginIp);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LoginParamTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public LoginParamTupleScheme getScheme() {
      return new LoginParamTupleScheme();
    }
  }

  private static class LoginParamTupleScheme extends org.apache.thrift.scheme.TupleScheme<LoginParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LoginParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.mobile);
      oprot.writeString(struct.pwd);
      oprot.writeString(struct.deviceId);
      oprot.writeI32(struct.deviceType);
      oprot.writeString(struct.loginIp);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LoginParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.mobile = iprot.readString();
      struct.setMobileIsSet(true);
      struct.pwd = iprot.readString();
      struct.setPwdIsSet(true);
      struct.deviceId = iprot.readString();
      struct.setDeviceIdIsSet(true);
      struct.deviceType = iprot.readI32();
      struct.setDeviceTypeIsSet(true);
      struct.loginIp = iprot.readString();
      struct.setLoginIpIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

