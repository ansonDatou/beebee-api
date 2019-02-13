package com.quwan.beebee.resp.topic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.quwan.beebee.utils.DateUtils;

import java.sql.Timestamp;

/**
* @ClassName: TopicCommentReplyListResp
* @Description: 活动评论回复列表响应参数
* @author lijing
* @date 2017年12月21日 上午19:45:10
*
 */
public class TopicCommentReplyListResp {

	private int id;
	private int userId;
	private int topicId;
	private int parentId;
	private int parentUserId;
	private int praise;
	private String nicker;
	private String head;
	private String content;
	private String img;
	private String replierIdentity;
	private Timestamp addTime;
	private int isParise;
	private String parentUser;


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

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(int parentUserId) {
		this.parentUserId = parentUserId;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public String getNicker() {
		return nicker;
	}

	public void setNicker(String nicker) {
		this.nicker = nicker;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public JSONArray getReplierIdentity() {
		return JSONArray.parseArray(replierIdentity);
	}

	public void setReplierIdentity(String replierIdentity) {
		this.replierIdentity = replierIdentity;
	}

	public String getAddTime() {
		return DateUtils.parseTime (addTime);
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public int getIsParise() {
		return isParise;
	}

	public void setIsParise(int isParise) {
		this.isParise = isParise;
	}

	public String getParentUser() {
		return parentUser;
	}

	public void setParentUser(String parentUser) {
		this.parentUser = parentUser;
	}
}
