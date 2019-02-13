package com.quwan.beebee.resp.topic;


import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hefei on 2017/12/23.
 */
public class TopicDetailResp {
    private Integer id;
    private Integer type;
    private String  title;
    private String content;
    private String img;
    private String addTime;
    private String replierIdentity;
    private Integer multiSelect;
    private List<TopicVoteOptionResp> options;
    private List<Integer> voteIds = new ArrayList<>();



    public TopicDetailResp() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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
        return JSONArray.parseArray(img);
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

    public JSONArray getReplierIdentity() {
        return JSONArray.parseArray(replierIdentity);
    }

    public void setReplierIdentity(String replierIdentity) {
        this.replierIdentity = replierIdentity;
    }

    public List<TopicVoteOptionResp> getOptions() {
        return options;
    }

    public void setOptions(List<TopicVoteOptionResp> options) {
        this.options = options;
    }

    public List<Integer> getVoteIds() {
        return voteIds;
    }

    public void setVoteIds(List<Integer> voteIds) {
        this.voteIds = voteIds;
    }

    public Integer getMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(Integer multiSelect) {
        this.multiSelect = multiSelect;
    }
}