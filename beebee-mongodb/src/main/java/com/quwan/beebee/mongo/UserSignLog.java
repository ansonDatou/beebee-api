package com.quwan.beebee.mongo;

import org.jongo.marshall.jackson.oid.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 用户积分日志表-陈晓婵-2018年1月3日11:40:58
 * 
 * @author chan
 *
 */

@Document(collection = "T_UserSignLog")
public class UserSignLog {

	@Id
	private String id;

	private Integer userId;

	private String signDate;
	
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

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

}
