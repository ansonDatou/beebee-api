package com.quwan.beebee.meta;

/**
* @ClassName: TopicTypeEnum 
* @Description: 活动类型
* @author 李静
* @date 2018年1月18日 下午3:53:23 
*
 */
public enum TopicTypeEnum {

	TOPIC_ALL(0,"全部"),
	TOPIC_SPEAK(1,"哔哔说"),
	TOPIC_VOTE(2,"哔哔投");
	
	public int code;
	
	public String message;
	
	private TopicTypeEnum(int code,String message){
		this.code = code;
		this.message = message;
	}
}
