package com.quwan.beebee.resp.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.quwan.beebee.utils.DateUtils;

import java.sql.Timestamp;

public class MineCommentResp {

	private int id;
	private String content;
	private Timestamp addTime;
	private String nicker;
	private int parentUserId;
	private String replierIdentity;
	private int userId;
	private int praise;
	private String head;
	private int sourceId;  //文章、活动id
	private int type;  //0:文章 1：活动
	private int parentId;
	private int isParise;
	private int comments;
	public MineCommentResp() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JSONArray getContent() {
		try {
			return JSONArray.parseArray(content);
		}catch (Exception e){
			JSONArray array = new JSONArray();
			JSONObject object = new JSONObject();
			object.put("type","text");
			object.put("content",content);
			array.add(object);
			return array;
		}
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddTime(){
		return DateUtils.parseTime(addTime);
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public String getNicker() {
		return nicker;
	}

	public void setNicker(String nicker) {
		this.nicker = nicker;
	}

	public int getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(int parentUserId) {
		this.parentUserId = parentUserId;
	}

	public JSONArray getReplierIdentity() {
		return JSONArray.parseArray (replierIdentity);
	}

	public void setReplierIdentity(String replierIdentity) {
		this.replierIdentity = replierIdentity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getIsParise() {
		return isParise;
	}

	public void setIsParise(int isParise) {
		this.isParise = isParise;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
