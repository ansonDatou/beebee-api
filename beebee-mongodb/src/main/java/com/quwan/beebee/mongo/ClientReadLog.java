package com.quwan.beebee.mongo;

import com.quwan.beebee.common.Constants;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jongo.marshall.jackson.oid.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T_ClientReadLog")
public class ClientReadLog {
	@Id
	private String id;

	private Integer userId;

	private Integer archId; //文章Id
	
	private Integer topicId;  //哔哔id
	
	private Integer type; //阅读内容  0：文章 1：哔哔说、哔哔投
	
	private String deviceId;  //设备号
	
	private Integer deviceType; //类型（1-android；2-ios；3-html5）
	
	private int isrank;//是否已参与排序
	
	private int readstatus;//阅读状态，0-初始，1-已阅读完，2-未阅读完
	
	private String addTime;

	public ClientReadLog() {

	}

	public ClientReadLog(Integer archId, Integer userId,Integer type, String deviceId, Integer deviceType) {
		this.archId = archId;
		this.userId = userId;
		this.type = type;
		this.deviceId = deviceId;
		this.deviceType = deviceType;
		this.addTime = DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME);
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

	public int getIsrank() {
		return isrank;
	}

	public void setIsrank(int isrank) {
		this.isrank = isrank;
	}

	public int getReadstatus() {
		return readstatus;
	}

	public void setReadstatus(int readstatus) {
		this.readstatus = readstatus;
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
		return "ClientReadLog [id=" + id + ", userId=" + userId + ", archId=" + archId + ", topicId=" + topicId
				+ ", type=" + type + ", deviceId=" + deviceId + ", deviceType=" + deviceType + ", isrank=" + isrank + ", readstatus="
				+ readstatus + ", addTime=" + addTime + "]";
	}
	
}
