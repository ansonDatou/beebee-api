package com.quwan.beebee.resp.user;

import java.sql.Timestamp;

public class NotificationListResp {

	private String title;

	private String content;

	private Timestamp addTime;

	public NotificationListResp() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Override
	public String toString() {
		return "NotificationListResp [title=" + title + ", content=" + content
				+ ", addTime=" + addTime + "]";
	}

}
