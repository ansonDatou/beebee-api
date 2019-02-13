package com.quwan.beebee.resp.user;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.quwan.beebee.utils.RelativeDateFormatUtil;

public class GetCommentsByUserIdentityResp {

	//活动id
	private int topicId;
	
	private String title;
	
	private Timestamp pubTime;
	
	private int praise;
	
	private String imgUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubTime() {
		return RelativeDateFormatUtil.format(pubTime);
	}

	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
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

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "GetCommentsByUserIdentityResp [topicId=" + topicId + ", title=" + title + ", pubTime=" + pubTime
				+ ", praise=" + praise + ", imgUrl=" + imgUrl + "]";
	}
	
}
