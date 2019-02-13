package com.quwan.beebee.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quwan.beebee.mongo.ClientReadLog;

/**
* @ClassName: UserReadLog 
* @Description: 用户阅读日志（文章、活动）
* @author lijing
* @date 2018年1月4日 下午2:39:41 
*
 */
public interface ClientReadLogDao extends MongoRepository<ClientReadLog, String> {

	/**
	* @Title: insert 
	* @Description: 增加一条阅读记录 
	 */
	public ClientReadLog insert(ClientReadLog readLog);

}
