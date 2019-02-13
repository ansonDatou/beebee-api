package com.quwan.beebee.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quwan.beebee.mongo.Loyalty;

/*
 * 获得花朵的接口类-陈晓婵-2017年12月29日11:24:56
 */
public interface LoyaltyDao extends MongoRepository<Loyalty, String> {

	/**
	 * 添加积分日志-陈晓婵-2017年12月29日10:24:23
	 */
	public Loyalty insert(Loyalty loyaltyResp);

	/**
	 * 根据userId查询日志信息-陈晓婵-2017年12月29日14:26:45
	 *
	 * @param userId
	 * @return
	 */
	public List<Loyalty> findByUserId(Integer userId);
	

}
