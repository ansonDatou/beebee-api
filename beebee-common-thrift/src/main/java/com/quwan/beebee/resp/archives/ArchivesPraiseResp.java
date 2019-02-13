package com.quwan.beebee.resp.archives;

/**
 * Created by hefei on 2017/12/27.
 */
public class ArchivesPraiseResp {
    private Integer id;
    private Integer archId;
    private Integer userId;
    private String deviceId;
    private Integer deviceType;
    private Integer valid;
    private String modTime;
    private String addTime;

    public ArchivesPraiseResp() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArchId() {
        return archId;
    }

    public void setArchId(Integer archId) {
        this.archId = archId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getModTime() {
        return modTime;
    }

    public void setModTime(String modTime) {
        this.modTime = modTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "ArchivesPraiseResp{" +
                "id=" + id +
                ", archId=" + archId +
                ", userId=" + userId +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType=" + deviceType +
                ", valid=" + valid +
                ", modTime='" + modTime + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}
