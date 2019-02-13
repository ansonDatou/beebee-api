package com.quwan.beebee.resp.user;

/**
 * Created by anson on 2017/12/5.
 */
public class CollectionResp {

    private Integer id;
    private String tags;
    private String largePic;
    private String modTime;
    private Integer click;
    private String pubTime;
    private String videoUrl;
    private String cat1;
    private String title;
    private String source;
    private Integer sourceType;
    private Integer comment;
    private Integer collection;
    private String writer;
    private String litPic1;
    private String litPic2; 
    private String litPic3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLargePic() {
        return largePic;
    }

    public void setLargePic(String largePic) {
        this.largePic = largePic;
    }

    public String getModTime() {
        return modTime;
    }

    public void setModTime(String modTime) {
        this.modTime = modTime;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getLitPic1() {
        return litPic1;
    }

    public void setLitPic1(String litPic1) {
        this.litPic1 = litPic1;
    }

    public String getLitPic2() {
        return litPic2;
    }

    public void setLitPic2(String litPic2) {
        this.litPic2 = litPic2;
    }

    public String getLitPic3() {
        return litPic3;
    }

    public void setLitPic3(String litPic3) {
        this.litPic3 = litPic3;
    }

    @Override
    public String toString() {
        return "CollectionResp{" +
                "id=" + id +
                ", tags='" + tags + '\'' +
                ", largePic='" + largePic + '\'' +
                ", modTime='" + modTime + '\'' +
                ", click=" + click +
                ", pubTime='" + pubTime + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", cat1='" + cat1 + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", sourceType=" + sourceType +
                ", comment=" + comment +
                ", writer='" + writer + '\'' +
                ", litPic1='" + litPic1 + '\'' +
                ", litPic2='" + litPic2 + '\'' +
                ", litPic3='" + litPic3 + '\'' +
                '}';
    }
}
