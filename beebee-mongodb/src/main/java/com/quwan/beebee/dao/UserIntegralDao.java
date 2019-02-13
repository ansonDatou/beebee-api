package com.quwan.beebee.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quwan.beebee.mongo.UserIntegral;

public interface UserIntegralDao extends MongoRepository<UserIntegral, String>{

	/**
	 * 积分总和-陈晓婵-2018年1月5日15:08:53
	 */
	public UserIntegral insert(UserIntegral integral);
	
	/**
	 * 通过用户id查询积分-陈晓婵-2018年1月5日15:12:53
	 * @param userId
	 * @return
	 */
	public List<UserIntegral> findByUserId(Integer userId);
}
