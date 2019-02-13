package com.quwan.beebee.resp.topic;

import java.sql.Timestamp;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.quwan.beebee.utils.DateUtils;
import com.quwan.beebee.utils.RelativeDateFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicCommentResp {

	private int id;
	private String content;
	private Timestamp addTime;
	private String nicker;
	private int parentUserId;
	private String identity;
	private String identityColor;
	private int userId;
	private int praise;
	private String head;
	private int topicId;
	private int parentId;
	private int isParise;
	private int comments;
	private String replierIdentity;
	private String replierID;
	private String img;
	private List<TopicCommentReplyThreeListResp> commentReplyThreeListRespList;
	
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
		return RelativeDateFormatUtil.format(addTime);
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

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getIdentityColor() {
		return identityColor;
	}

	public void setIdentityColor(String identityColor) {
		this.identityColor = identityColor;
	}

	
	public JSONArray getReplierIdentity() {
		return JSONArray.parseArray(String.format("[{\"identity\":\"%s\",\"color\":\"%s\"}]", identity, identityColor));
	}

	public void setReplieridentity(String replierIdentity) {
		this.replierIdentity = replierIdentity;
	}

	
	public String getReplierID() {
		return replierID;
	}

	public void setReplierID(String replierID) {
		this.replierID = replierID;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<TopicCommentReplyThreeListResp> getCommentReplyThreeListRespList() {
		return commentReplyThreeListRespList;
	}

	public void setCommentReplyThreeListRespList(List<TopicCommentReplyThreeListResp> commentReplyThreeListRespList) {
		this.commentReplyThreeListRespList = commentReplyThreeListRespList;
	}

	@Override
	public String toString() {
		return "TopicCommentResp [id=" + id + ", content=" + content
				+ ", addTime=" + addTime + ", nicker=" + nicker
				+ ", parentUserId=" + parentUserId + ", identity=" + identity
				+ ", identityColor=" + identityColor + ", userId=" + userId
				+ ", praise=" + praise + ", head=" + head + ", topicId="
				+ topicId + ", parentId=" + parentId + ", isParise=" + isParise
				+ ", comments=" + comments + ", replierIdentity="
				+ replierIdentity + ", replierID=" + replierID + "]";
	}


}
