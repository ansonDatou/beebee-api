/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.quwan.beebee.param.common;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2018-02-07")
public class UserFeedBackParam implements org.apache.thrift.TBase<UserFeedBackParam, UserFeedBackParam._Fields>, java.io.Serializable, Cloneable, Comparable<UserFeedBackParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserFeedBackParam");

  private static final org.apache.thrift.protocol.TField CONTENT_FIELD_DESC = new org.apache.thrift.protocol.TField("content", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField DEVICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceId", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DEVICE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceType", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField PHONE_FIELD_DESC = new org.apache.thrift.protocol.TField("phone", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField EMAIL_FIELD_DESC = new org.apache.thrift.protocol.TField("email", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField QQ_FIELD_DESC = new org.apache.thrift.protocol.TField("qq", org.apache.thrift.protocol.TType.STRING, (short)7);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new UserFeedBackParamStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new UserFeedBackParamTupleSchemeFactory();

  public String content; // required
  public int userId; // optional
  public String deviceId; // optional
  public int deviceType; // optional
  public String phone; // optional
  public String email; // optional
  public String qq; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CONTENT((short)1, "content"),
    USER_ID((short)2, "userId"),
    DEVICE_ID((short)3, "deviceId"),
    DEVICE_TYPE((short)4, "deviceType"),
    PHONE((short)5, "phone"),
    EMAIL((short)6, "email"),
    QQ((short)7, "qq");

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
        case 1: // CONTENT
          return CONTENT;
        case 2: // USER_ID
          return USER_ID;
        case 3: // DEVICE_ID
          return DEVICE_ID;
        case 4: // DEVICE_TYPE
          return DEVICE_TYPE;
        case 5: // PHONE
          return PHONE;
        case 6: // EMAIL
          return EMAIL;
        case 7: // QQ
          return QQ;
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
  private static final int __DEVICETYPE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.USER_ID, _Fields.DEVICE_ID, _Fields.DEVICE_TYPE, _Fields.PHONE, _Fields.EMAIL, _Fields.QQ};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CONTENT, new org.apache.thrift.meta_data.FieldMetaData("content", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DEVICE_ID, new org.apache.thrift.meta_data.FieldMetaData("deviceId", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEVICE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("deviceType", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PHONE, new org.apache.thrift.meta_data.FieldMetaData("phone", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EMAIL, new org.apache.thrift.meta_data.FieldMetaData("email", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.QQ, new org.apache.thrift.meta_data.FieldMetaData("qq", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserFeedBackParam.class, metaDataMap);
  }

  public UserFeedBackParam() {
  }

  public UserFeedBackParam(
    String content)
  {
    this();
    this.content = content;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserFeedBackParam(UserFeedBackParam other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetContent()) {
      this.content = other.content;
    }
    this.userId = other.userId;
    if (other.isSetDeviceId()) {
      this.deviceId = other.deviceId;
    }
    this.deviceType = other.deviceType;
    if (other.isSetPhone()) {
      this.phone = other.phone;
    }
    if (other.isSetEmail()) {
      this.email = other.email;
    }
    if (other.isSetQq()) {
      this.qq = other.qq;
    }
  }

  public UserFeedBackParam deepCopy() {
    return new UserFeedBackParam(this);
  }

  @Override
  public void clear() {
    this.content = null;
    setUserIdIsSet(false);
    this.userId = 0;
    this.deviceId = null;
    setDeviceTypeIsSet(false);
    this.deviceType = 0;
    this.phone = null;
    this.email = null;
    this.qq = null;
  }

  public String getContent() {
    return this.content;
  }

  public UserFeedBackParam setContent(String content) {
    this.content = content;
    return this;
  }

  public void unsetContent() {
    this.content = null;
  }

  /** Returns true if field content is set (has been assigned a value) and false otherwise */
  public boolean isSetContent() {
    return this.content != null;
  }

  public void setContentIsSet(boolean value) {
    if (!value) {
      this.content = null;
    }
  }

  public int getUserId() {
    return this.userId;
  }

  public UserFeedBackParam setUserId(int userId) {
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

  public String getDeviceId() {
    return this.deviceId;
  }

  public UserFeedBackParam setDeviceId(String deviceId) {
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

  public UserFeedBackParam setDeviceType(int deviceType) {
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

  public String getPhone() {
    return this.phone;
  }

  public UserFeedBackParam setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public void unsetPhone() {
    this.phone = null;
  }

  /** Returns true if field phone is set (has been assigned a value) and false otherwise */
  public boolean isSetPhone() {
    return this.phone != null;
  }

  public void setPhoneIsSet(boolean value) {
    if (!value) {
      this.phone = null;
    }
  }

  public String getEmail() {
    return this.email;
  }

  public UserFeedBackParam setEmail(String email) {
    this.email = email;
    return this;
  }

  public void unsetEmail() {
    this.email = null;
  }

  /** Returns true if field email is set (has been assigned a value) and false otherwise */
  public boolean isSetEmail() {
    return this.email != null;
  }

  public void setEmailIsSet(boolean value) {
    if (!value) {
      this.email = null;
    }
  }

  public String getQq() {
    return this.qq;
  }

  public UserFeedBackParam setQq(String qq) {
    this.qq = qq;
    return this;
  }

  public void unsetQq() {
    this.qq = null;
  }

  /** Returns true if field qq is set (has been assigned a value) and false otherwise */
  public boolean isSetQq() {
    return this.qq != null;
  }

  public void setQqIsSet(boolean value) {
    if (!value) {
      this.qq = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CONTENT:
      if (value == null) {
        unsetContent();
      } else {
        setContent((String)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Integer)value);
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

    case PHONE:
      if (value == null) {
        unsetPhone();
      } else {
        setPhone((String)value);
      }
      break;

    case EMAIL:
      if (value == null) {
        unsetEmail();
      } else {
        setEmail((String)value);
      }
      break;

    case QQ:
      if (value == null) {
        unsetQq();
      } else {
        setQq((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CONTENT:
      return getContent();

    case USER_ID:
      return getUserId();

    case DEVICE_ID:
      return getDeviceId();

    case DEVICE_TYPE:
      return getDeviceType();

    case PHONE:
      return getPhone();

    case EMAIL:
      return getEmail();

    case QQ:
      return getQq();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CONTENT:
      return isSetContent();
    case USER_ID:
      return isSetUserId();
    case DEVICE_ID:
      return isSetDeviceId();
    case DEVICE_TYPE:
      return isSetDeviceType();
    case PHONE:
      return isSetPhone();
    case EMAIL:
      return isSetEmail();
    case QQ:
      return isSetQq();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserFeedBackParam)
      return this.equals((UserFeedBackParam)that);
    return false;
  }

  public boolean equals(UserFeedBackParam that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_content = true && this.isSetContent();
    boolean that_present_content = true && that.isSetContent();
    if (this_present_content || that_present_content) {
      if (!(this_present_content && that_present_content))
        return false;
      if (!this.content.equals(that.content))
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

    boolean this_present_deviceId = true && this.isSetDeviceId();
    boolean that_present_deviceId = true && that.isSetDeviceId();
    if (this_present_deviceId || that_present_deviceId) {
      if (!(this_present_deviceId && that_present_deviceId))
        return false;
      if (!this.deviceId.equals(that.deviceId))
        return false;
    }

    boolean this_present_deviceType = true && this.isSetDeviceType();
    boolean that_present_deviceType = true && that.isSetDeviceType();
    if (this_present_deviceType || that_present_deviceType) {
      if (!(this_present_deviceType && that_present_deviceType))
        return false;
      if (this.deviceType != that.deviceType)
        return false;
    }

    boolean this_present_phone = true && this.isSetPhone();
    boolean that_present_phone = true && that.isSetPhone();
    if (this_present_phone || that_present_phone) {
      if (!(this_present_phone && that_present_phone))
        return false;
      if (!this.phone.equals(that.phone))
        return false;
    }

    boolean this_present_email = true && this.isSetEmail();
    boolean that_present_email = true && that.isSetEmail();
    if (this_present_email || that_present_email) {
      if (!(this_present_email && that_present_email))
        return false;
      if (!this.email.equals(that.email))
        return false;
    }

    boolean this_present_qq = true && this.isSetQq();
    boolean that_present_qq = true && that.isSetQq();
    if (this_present_qq || that_present_qq) {
      if (!(this_present_qq && that_present_qq))
        return false;
      if (!this.qq.equals(that.qq))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetContent()) ? 131071 : 524287);
    if (isSetContent())
      hashCode = hashCode * 8191 + content.hashCode();

    hashCode = hashCode * 8191 + ((isSetUserId()) ? 131071 : 524287);
    if (isSetUserId())
      hashCode = hashCode * 8191 + userId;

    hashCode = hashCode * 8191 + ((isSetDeviceId()) ? 131071 : 524287);
    if (isSetDeviceId())
      hashCode = hashCode * 8191 + deviceId.hashCode();

    hashCode = hashCode * 8191 + ((isSetDeviceType()) ? 131071 : 524287);
    if (isSetDeviceType())
      hashCode = hashCode * 8191 + deviceType;

    hashCode = hashCode * 8191 + ((isSetPhone()) ? 131071 : 524287);
    if (isSetPhone())
      hashCode = hashCode * 8191 + phone.hashCode();

    hashCode = hashCode * 8191 + ((isSetEmail()) ? 131071 : 524287);
    if (isSetEmail())
      hashCode = hashCode * 8191 + email.hashCode();

    hashCode = hashCode * 8191 + ((isSetQq()) ? 131071 : 524287);
    if (isSetQq())
      hashCode = hashCode * 8191 + qq.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(UserFeedBackParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetContent()).compareTo(other.isSetContent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.content, other.content);
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
    lastComparison = Boolean.valueOf(isSetPhone()).compareTo(other.isSetPhone());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPhone()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.phone, other.phone);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEmail()).compareTo(other.isSetEmail());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmail()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.email, other.email);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQq()).compareTo(other.isSetQq());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQq()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.qq, other.qq);
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
    StringBuilder sb = new StringBuilder("UserFeedBackParam(");
    boolean first = true;

    sb.append("content:");
    if (this.content == null) {
      sb.append("null");
    } else {
      sb.append(this.content);
    }
    first = false;
    if (isSetUserId()) {
      if (!first) sb.append(", ");
      sb.append("userId:");
      sb.append(this.userId);
      first = false;
    }
    if (isSetDeviceId()) {
      if (!first) sb.append(", ");
      sb.append("deviceId:");
      if (this.deviceId == null) {
        sb.append("null");
      } else {
        sb.append(this.deviceId);
      }
      first = false;
    }
    if (isSetDeviceType()) {
      if (!first) sb.append(", ");
      sb.append("deviceType:");
      sb.append(this.deviceType);
      first = false;
    }
    if (isSetPhone()) {
      if (!first) sb.append(", ");
      sb.append("phone:");
      if (this.phone == null) {
        sb.append("null");
      } else {
        sb.append(this.phone);
      }
      first = false;
    }
    if (isSetEmail()) {
      if (!first) sb.append(", ");
      sb.append("email:");
      if (this.email == null) {
        sb.append("null");
      } else {
        sb.append(this.email);
      }
      first = false;
    }
    if (isSetQq()) {
      if (!first) sb.append(", ");
      sb.append("qq:");
      if (this.qq == null) {
        sb.append("null");
      } else {
        sb.append(this.qq);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (content == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'content' was not present! Struct: " + toString());
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

  private static class UserFeedBackParamStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public UserFeedBackParamStandardScheme getScheme() {
      return new UserFeedBackParamStandardScheme();
    }
  }

  private static class UserFeedBackParamStandardScheme extends org.apache.thrift.scheme.StandardScheme<UserFeedBackParam> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserFeedBackParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CONTENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.content = iprot.readString();
              struct.setContentIsSet(true);
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
          case 5: // PHONE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.phone = iprot.readString();
              struct.setPhoneIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // EMAIL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.email = iprot.readString();
              struct.setEmailIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // QQ
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.qq = iprot.readString();
              struct.setQqIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserFeedBackParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.content != null) {
        oprot.writeFieldBegin(CONTENT_FIELD_DESC);
        oprot.writeString(struct.content);
        oprot.writeFieldEnd();
      }
      if (struct.isSetUserId()) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        oprot.writeI32(struct.userId);
        oprot.writeFieldEnd();
      }
      if (struct.deviceId != null) {
        if (struct.isSetDeviceId()) {
          oprot.writeFieldBegin(DEVICE_ID_FIELD_DESC);
          oprot.writeString(struct.deviceId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetDeviceType()) {
        oprot.writeFieldBegin(DEVICE_TYPE_FIELD_DESC);
        oprot.writeI32(struct.deviceType);
        oprot.writeFieldEnd();
      }
      if (struct.phone != null) {
        if (struct.isSetPhone()) {
          oprot.writeFieldBegin(PHONE_FIELD_DESC);
          oprot.writeString(struct.phone);
          oprot.writeFieldEnd();
        }
      }
      if (struct.email != null) {
        if (struct.isSetEmail()) {
          oprot.writeFieldBegin(EMAIL_FIELD_DESC);
          oprot.writeString(struct.email);
          oprot.writeFieldEnd();
        }
      }
      if (struct.qq != null) {
        if (struct.isSetQq()) {
          oprot.writeFieldBegin(QQ_FIELD_DESC);
          oprot.writeString(struct.qq);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserFeedBackParamTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public UserFeedBackParamTupleScheme getScheme() {
      return new UserFeedBackParamTupleScheme();
    }
  }

  private static class UserFeedBackParamTupleScheme extends org.apache.thrift.scheme.TupleScheme<UserFeedBackParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserFeedBackParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.content);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetUserId()) {
        optionals.set(0);
      }
      if (struct.isSetDeviceId()) {
        optionals.set(1);
      }
      if (struct.isSetDeviceType()) {
        optionals.set(2);
      }
      if (struct.isSetPhone()) {
        optionals.set(3);
      }
      if (struct.isSetEmail()) {
        optionals.set(4);
      }
      if (struct.isSetQq()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetUserId()) {
        oprot.writeI32(struct.userId);
      }
      if (struct.isSetDeviceId()) {
        oprot.writeString(struct.deviceId);
      }
      if (struct.isSetDeviceType()) {
        oprot.writeI32(struct.deviceType);
      }
      if (struct.isSetPhone()) {
        oprot.writeString(struct.phone);
      }
      if (struct.isSetEmail()) {
        oprot.writeString(struct.email);
      }
      if (struct.isSetQq()) {
        oprot.writeString(struct.qq);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserFeedBackParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.content = iprot.readString();
      struct.setContentIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.userId = iprot.readI32();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.deviceId = iprot.readString();
        struct.setDeviceIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.deviceType = iprot.readI32();
        struct.setDeviceTypeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.phone = iprot.readString();
        struct.setPhoneIsSet(true);
      }
      if (incoming.get(4)) {
        struct.email = iprot.readString();
        struct.setEmailIsSet(true);
      }
      if (incoming.get(5)) {
        struct.qq = iprot.readString();
        struct.setQqIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

