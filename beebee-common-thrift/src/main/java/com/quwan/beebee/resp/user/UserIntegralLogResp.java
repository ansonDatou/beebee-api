package com.quwan.beebee.resp.user;

import java.util.Date;

public class UserIntegralLogResp {

	private int id;

	private int userId;

	private int integral;

	private int type;

	private String title;

	private String typeDesc;

	private int typeId;

	private Date addTime;

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

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Override
	public String toString() {
		return "UserIntegralLog [id=" + id + ", userId=" + userId
				+ ", integral=" + integral + ", type=" + type + ", title="
				+ title + ", typeDesc=" + typeDesc + ", typeId=" + typeId
				+ ", addTime=" + addTime + "]";
	}

}
