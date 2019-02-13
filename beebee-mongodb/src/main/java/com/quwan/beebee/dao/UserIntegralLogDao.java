package com.quwan.beebee.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quwan.beebee.mongo.UserIntegralLog;
import com.quwan.beebee.mongo.Loyalty;

public interface UserIntegralLogDao extends MongoRepository<UserIntegralLog, String> {

	public List<Loyalty> findByUserId(Integer userId);
	
	/**
	 * 添加积分日志-陈晓婵-2018年1月5日10:52:27
	 * @param loyaltyResp
	 * @return
	 */
	public UserIntegralLog insert(UserIntegralLog integralLog);
}

