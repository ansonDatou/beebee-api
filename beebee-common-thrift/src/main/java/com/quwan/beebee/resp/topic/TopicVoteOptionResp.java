package com.quwan.beebee.resp.topic;

import org.apache.http.util.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hefei on 2018/1/10.
 */
public class TopicVoteOptionResp {

    private static final String REGEX_IMG = "\"url\":\"(.*)\"";
    private Integer id;
    private String name;
    private int total;
    private int male;
    private int feMale;
    private int unKnownSex;
    private String img;
    private int order;

    public TopicVoteOptionResp() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFeMale() {
        return feMale;
    }

    public void setFeMale(int feMale) {
        this.feMale = feMale;
    }

    public int getUnKnownSex() {
        return unKnownSex;
    }

    public void setUnKnownSex(int unKnownSex) {
        this.unKnownSex = unKnownSex;
    }

    public String getImg() {
        if(TextUtils.isEmpty(img))
            return "";
        if(img.startsWith("http")){
            return img;
        }
        Matcher m = Pattern.compile(REGEX_IMG).matcher(img);
        if (m.find()) {
            return m.group(1);
        }
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
