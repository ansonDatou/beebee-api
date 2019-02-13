package com.quwan.beebee.param.user;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by anson on 2017/11/15.
 * 发送验证码参数
 */

public class AuthcodeParam implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "mobile not be empty")
    private String mobile;

    @NotEmpty(message = "type not be empty")
    private String type;

    private String authcode;

    private String addTime;

    private String used;

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AuthcodeParam{" +
                "mobile='" + mobile + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
