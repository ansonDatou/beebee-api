package com.quwan.beebee.meta;

/**
 * 设备类型
 */
public enum DeviceType {
    Unknown(0, "unknown"),
    Android(1, "android"),
    Ios(2, "ios");

    public int id;
    public String name;

    DeviceType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 根据前端传来的值，获取设备类型
     */
    public static DeviceType getDeviceType (int id) {
        for (DeviceType deviceType : DeviceType.values()) {
            if (deviceType.id == id) {
                return deviceType;
            }
        }

        return DeviceType.Unknown;
    }
}
