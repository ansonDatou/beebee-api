package com.quwan.beebee.resp.user;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.quwan.beebee.utils.RelativeDateFormatUtil;

public class UserDynamicResp {

	//文章id / 活动id
	private int id;
	
	// 哔哔类型：1-问答2-猜猜3-投票/ 回复类型：0-评论 1-回复
	private int type;
	
	private String title;
	
	private String nicker;
	
	private String imgUrl;
	
	private Timestamp pubTime;
	
	private String content;
	
	private int participants;
	
	private String identity;
	
	private String identityColor;
	
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

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public String getContent() {
		try {
			JSONArray jSONArray = JSONArray.parseArray(content);
			JSONObject object = (JSONObject) jSONArray.get(0);
			return object.getString("content");
		}catch (Exception e){
			return content;
		}
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgUrl() {
		if(StringUtils.isNotEmpty(imgUrl)){
			try{
				JSONArray ja = JSONArray.parseArray(imgUrl);
				JSONObject img= (JSONObject) ja.get(0);
				return img.getString("url");
			}catch(Exception e){
				return "";
			}
		}else{
			return imgUrl;
		}
	}

	public void setImg(String imgUrl) {
		this.imgUrl = imgUrl;
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

	@Override
	public String toString() {
		return "UserDynamicResp [id=" + id + ", type=" + type + ", title=" + title + ", nicker=" + nicker + ", imgUrl="
				+ imgUrl + ", pubTime=" + pubTime + ", participants=" + participants + ", identity=" + identity
				+ ", identityColor=" + identityColor + ", content=" + content + "]";
	}

	
}
