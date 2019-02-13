package com.quwan.beebee.resp.common;

public class GetBannerResp {
	
	private int type;
	
	private String content;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "GetBannerResp [type=" + type + ", content=" + content + "]";
	}
	

}
