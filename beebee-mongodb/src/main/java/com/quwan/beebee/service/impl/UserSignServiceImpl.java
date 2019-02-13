package com.quwan.beebee.service.impl;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.quwan.beebee.mongo.UserSignLog;
import com.quwan.beebee.service.UserSignService;

@Service("signService")
public class UserSignServiceImpl implements UserSignService {

	@Autowired  
    private MongoTemplate mongoTemplate;  
	
	
	/**
	* @Title: save 
	* @Description: 插入或者更新签到表
	* @param integral void    返回类型 
	* @author 李静
	* @throws
	 */
	@Override
	public void save(UserSignLog signLog) throws TException{
		mongoTemplate.save(signLog);
	}
}
