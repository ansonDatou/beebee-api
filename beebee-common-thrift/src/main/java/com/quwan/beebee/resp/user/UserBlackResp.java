package com.quwan.beebee.resp.user;

import java.util.Date;

public class UserBlackResp {

    private int id;

    private int userId;

    private int blackUserId;

    private String nickName;

    private Date addtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlackUserId() {
        return blackUserId;
    }

    public void setBlackUserId(int blackUserId) {
        this.blackUserId = blackUserId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}