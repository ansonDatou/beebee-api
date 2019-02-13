package com.quwan.beebee.resp.archives;

/**
 * Created by hefei on 2017/12/27.
 */
public class ArchivesListResp {

    private Integer id;
    private Integer click;
    private Integer comment;
    private Integer collection;
    private Integer relay;
    private String title;
    private String imgUrl;
    private String larImgUrl;
    private String imgSize;
    private String pubTime;
    private String source;
    private String videoUrl;
    private String cat1;
    private String sourceType;

    public ArchivesListResp() {

    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getRelay() {
        return relay;
    }

    public void setRelay(Integer relay) {
        this.relay = relay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLarImgUrl() {
        return larImgUrl;
    }

    public void setLarImgUrl(String larImgUrl) {
        this.larImgUrl = larImgUrl;
    }

    public String getImgSize() {
        return imgSize;
    }

    public void setImgSize(String imgSize) {
        this.imgSize = imgSize;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public String toString() {
        return "ArchivesListResp{" +
                "id=" + id +
                ", click=" + click +
                ", comment=" + comment +
                ", relay=" + relay +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", larImgUrl='" + larImgUrl + '\'' +
                ", imgSize='" + imgSize + '\'' +
                ", pubTime='" + pubTime + '\'' +
                ", source='" + source + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", cat1='" + cat1 + '\'' +
                ", sourceType='" + sourceType + '\'' +
                '}';
    }
}
