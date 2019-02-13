package com.quwan.beebee.service;

public interface ClientService {

	/**
	* @Description: 查询今日阅读了几次文章和活动
	* @author 李静
	* @date 2018年1月8日 下午2:23:18 
	* @param userId
	* @param readType 阅读内容 类型：archId,topicId
	* @param addTime
	* @return int
	 */
	int getReadtimesByCondition(int userId, String readType, String addTime);
	
}
