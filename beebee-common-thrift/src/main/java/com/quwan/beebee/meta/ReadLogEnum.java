package com.quwan.beebee.meta;

/**
* @ClassName: ArchivesEnum 
* @Description: 
* @author lijing
* @date 2018年1月4日 下午2:50:09 
*
 */
public enum ReadLogEnum {

	TYPE_ARCHIVE(0,"文章"),
	TYPE_TOPIC(1,"活动");
	
	public int code;
	
	public String message;
	
	private ReadLogEnum(int code,String message){
		this.code = code;
		this.message = message;
	}
}
