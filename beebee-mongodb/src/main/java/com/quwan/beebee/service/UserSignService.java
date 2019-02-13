package com.quwan.beebee.service;

import org.apache.thrift.TException;

import com.quwan.beebee.mongo.UserSignLog;

public interface UserSignService {

	
	/**
	* @Title: save 
	* @Description: 插入或者更新签到表
	* @param integral void    返回类型 
	* @author 李静
	* @throws
	 */
	void save(UserSignLog SignLog) throws TException;
	
}
