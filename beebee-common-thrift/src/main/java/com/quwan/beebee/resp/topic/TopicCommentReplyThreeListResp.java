package com.quwan.beebee.resp.topic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TopicCommentReplyThreeListResp {

    private int id;
    private int userId;
    private int topicId;
    private int valid;
    private String content;
    private String nicker;
    private String head;

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

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
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