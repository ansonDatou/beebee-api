package com.quwan.beebee.resp.user;

import java.sql.Timestamp;

import com.quwan.beebee.utils.RelativeDateFormatUtil;

public class UserDynamicCommentResp {

	//文章id / 活动id
	private int id;
	
	// 哔哔类型：1-问答2-猜猜3-投票/ 回复类型：0-评论 1-回复
	private int type;
	
	private String title;
	
	private String nicker;
	
	private String imgUrl;
	
	private Timestamp pubTime;
	
	private String content;
	
	private String source;
	
	private int comment;
	
	private int collection;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNicker() {
		return nicker;
	}

	public void setNicker(String nicker) {
		this.nicker = nicker;
	}

	public String getPubTime() {
		return RelativeDateFormatUtil.format(pubTime);
	}

	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "UserDynamicCommentResp [id=" + id + ", type=" + type + ", title=" + title + ", nicker=" + nicker
				+ ", source=" + source + ", imgUrl=" + imgUrl + ", pubTime=" + pubTime + ", comment=" + comment
				+ ", collection=" + collection + ", content=" + content + "]";
	}

}
