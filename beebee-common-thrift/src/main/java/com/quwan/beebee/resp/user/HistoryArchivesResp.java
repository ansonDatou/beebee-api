package com.quwan.beebee.resp.user;

/**
 * Created by anson on 2017/12/5.
 */
public class HistoryArchivesResp {

	private Integer id;
	private String cat1;
	private Integer click;
	private Integer comment;
	private String largePic;
	private String litPic1;
	private String litPic2;
	private String litPic3;
	private String modTime;
	private String pubTime;
	private String source;
	private String sourceType;
	private String tags;
	private String title;
	private String videoUrl;
	private String writer;
	private String imgurl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCat1() {
		return cat1;
	}

	public void setCat1(String cat1) {
		this.cat1 = cat1;
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

	public String getLargePic() {
		return largePic;
	}

	public void setLargePic(String largePic) {
		this.largePic = largePic;
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

	public String getModTime() {
		return modTime;
	}

	public void setModTime(String modTime) {
		this.modTime = modTime;
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

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "HistoryArchivesResp [id=" + id + ", cat1=" + cat1 + ", click="
				+ click + ", comment=" + comment + ", largePic=" + largePic
				+ ", litPic1=" + litPic1 + ", litPic2=" + litPic2
				+ ", litPic3=" + litPic3 + ", modTime=" + modTime
				+ ", pubTime=" + pubTime + ", source=" + source
				+ ", sourceType=" + sourceType + ", tags=" + tags + ", title="
				+ title + ", videoUrl=" + videoUrl + ", writer=" + writer
				+ ", imgurl=" + imgurl + "]";
	}

}
