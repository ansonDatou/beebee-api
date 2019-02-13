package com.quwan.beebee.mongo;

import com.quwan.beebee.common.Constants;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jongo.marshall.jackson.oid.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T_UserReadLog")
public class UserReadLog {
	@Id
	private String id;

	private Integer userId;

	private Integer archId; //文章Id

	private Integer topicId;  //哔哔id

	private Integer type; //阅读内容  0：文章 1：哔哔说、哔哔投

	private String addTime;

	public UserReadLog() {

	}

	public UserReadLog(int userId, int type, int archId) {
		this.userId = userId;
		this.type = type;
		this.archId = archId;
		this.addTime = DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME);
	}

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

	public Integer getArchId() {
		return archId;
	}

	public void setArchId(Integer archId) {
		this.archId = archId;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReadLog [id=" + id + ", userId=" + userId + ", archId=" + archId + ", topicId=" + topicId + ", addTime="
				+ addTime + "]";
	}


}
