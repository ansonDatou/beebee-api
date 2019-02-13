package com.quwan.beebee.resp.topic;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TopicResp {
	private int id;
	private byte type;
	private String title;
	private String content;
	private String img;
	private String addTime;
	private int people;
	private String replierIdentity;
	private String pubTime;
	private Integer userId;
	private String  nicker;
	private String  head;
	
	public TopicResp() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public JSONArray getImg() {
		try {
			return JSONArray.parseArray(img);
		}catch (Exception e){
			JSONArray array = new JSONArray();
			JSONObject object = new JSONObject();
			object.put("type","img");
			object.put("img",img);
			array.add(object);
			return array;
		}
	}


	public void setImg(String img) {
		this.img = img;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public JSONArray getReplierIdentity() {
		return JSONArray.parseArray(replierIdentity);
	}

	public void setReplierIdentity(String replierIdentity) {
		this.replierIdentity = replierIdentity;
	}

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
}
