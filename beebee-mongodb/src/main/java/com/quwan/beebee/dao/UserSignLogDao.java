package com.quwan.beebee.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quwan.beebee.mongo.UserSignLog;

public interface UserSignLogDao extends MongoRepository<UserSignLog, String>{

	/**
	 * 添加签到日志
	 *
	 * @param signLogParam
	 * @return
	 */
	public UserSignLog insert(UserSignLog userSignLog);

	/**
	 * 根据用户ID查询签到记录-陈晓婵-2018年1月3日15:04:41
	 *
	 * @param userId
	 * @return
	 */
	public List<UserSignLog> findByUserId(Integer userId);
}
