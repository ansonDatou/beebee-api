package com.quwan.beebee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.quwan.beebee.service.ClientService;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired  
    private MongoTemplate mongoTemplate; 
	
	/**
	* @Description: 查询今日阅读了几次文章和活动
	* @author 李静
	* @date 2018年1月8日 下午2:23:18 
	* @param userId
	* @param readType 阅读内容 类型：archId,topicId
	* @param addTime
	* @return int
	 */
	@Override
	public int getReadtimesByCondition(int userId, String readType, String addTime) {
        
        DBObject query = new BasicDBObject();
        query.put("userId", userId);
        query.put(readType, new BasicDBObject("$ne",null));
        query.put("addTime",new BasicDBObject("$gte",addTime) );
		List list = this.mongoTemplate.getCollection("T_ClientReadLog").distinct(readType,query);
        return list.size();
	}

}
