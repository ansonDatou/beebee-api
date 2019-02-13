package com.quwan.beebee.resp.topic;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by hefei on 2017/12/22.
 */
public class TopicBarrageListResp {
    private String content;
    private String level;
    private String nicker;
    private String head;

    public TopicBarrageListResp() {

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
