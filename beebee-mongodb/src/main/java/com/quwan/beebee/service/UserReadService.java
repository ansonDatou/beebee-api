package com.quwan.beebee.service;

import java.util.List;

import com.quwan.beebee.mongo.UserReadLog;

public interface UserReadService {

	/**
	* @Description: 查询今日阅读了几次文章和活动
	* @author 李静
	* @date 2018年1月8日 下午2:23:18 
	* @param userId
	* @param addTime
	* @return int
	 */
	int getReadtimesByCondition(int userId, String addTime);
	
	List<UserReadLog> getUserReadLogsByUserId(int userId);
}
