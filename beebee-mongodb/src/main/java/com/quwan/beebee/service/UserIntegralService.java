package com.quwan.beebee.service;

import java.util.List;

import com.quwan.beebee.mongo.UserIntegral;
import com.quwan.beebee.mongo.UserIntegralLog;

public interface UserIntegralService {

	/**
	* @Title: getCountByCondition 
	* @Description: 查询今日是否获取阅读积分
	* @param userId
	* @param type
	* @param addTime
	* @return long    返回类型 
	 */
	long getCountByCondition(int userId, int type, String addTime);

	/**
	* @Title: getStatistics 
	* @Description: 获取积分统计信息
	* @param userId
	* @return Integral    返回类型 
	* @author 李静
	* @throws
	 */
	UserIntegral getStatistics(int userId);
	
	/**
	* @Title: save 
	* @Description: 插入或者更新积分表
	* @param integral void    返回类型 
	* @author 李静
	* @throws
	 */
	void save(UserIntegral integral);
	
	
	/**
	* @Title: getIntegralLogsByCondition 
	* @Description: 根据条件查询积分日志
	* @param userId
	* @param title
	* @return List<IntegralLog>    返回类型 
	* @author 李静
	 */
	List<UserIntegralLog> getIntegralLogsByCondition(int userId, String title);
	
	//每日开始时间更新积分表
	void initIntegralOfStartDay(); 
	
	//每周开始时间更新积分表
	void initIngegralOfStartWeek(); 
	
	//每月开始时间更新积分表
	void initIngegralOfStartMonth();
}
