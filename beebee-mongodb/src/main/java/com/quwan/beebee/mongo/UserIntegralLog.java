package com.quwan.beebee.mongo;

import org.jongo.marshall.jackson.oid.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 用户积分日志
 * 
 * @author chan
 *
 */
@Document(collection = "T_UserIntegralLog")
public class UserIntegralLog {

	@Id
	private String id;

	private Integer userId;

	/**
	 *  1-邀请好友;2-签到;3-每日阅读3篇以上;
	 *  4-注册账号;5-完善资料;6-开启推送;
	 *  7-开启定位;8-开启通讯录;9-评论;
	 *  10-分享;11-绑定微信;
	 */
	private Integer type;
	/**
	 * 积分
	 */
	private Integer integral;

	/**
	 * 标题
	 */
	private String title;
	/**
	 * 标题描述
	 */
	private String typeDesc;

	private String addTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
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


	@Override
	public String toString() {
		return "IntegralLog [id=" + id + ", userId=" + userId + ", type="
				+ type + ", integral=" + integral + ", title=" + title
				+ ", typeDesc=" + typeDesc + "]";
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

}
