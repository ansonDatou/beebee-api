package com.quwan.beebee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.quwan.beebee.dao.UserReadLogDao;
import com.quwan.beebee.mongo.UserReadLog;
import com.quwan.beebee.service.UserReadService;

@Service("userReadService")
public class UserReadServiceImpl implements UserReadService {

	@Autowired  
    private MongoTemplate mongoTemplate; 
	
	@Autowired  
	private UserReadLogDao userReadLogDao; 
	
	/**
	* @Description: 查询今日阅读了几次文章和活动
	* @author 李静
	* @date 2018年1月8日 下午2:23:18 
	* @param userId
	* @param addTime
	* @return int
	 */
	@Override
	public int getReadtimesByCondition(int userId, String addTime) {
        
        DBObject query = new BasicDBObject();
        
        //不同文章阅读几篇
        query.put("userId", userId);
        query.put("archId", new BasicDBObject("$ne",null));
        query.put("addTime",new BasicDBObject("$gte",addTime) );
		List archList = this.mongoTemplate.getCollection("T_UserReadLog").distinct("archId",query);
		
		//不同哔哔说、哔哔投打开几次
		query.removeField("archId");
		query.put("topicId", new BasicDBObject("$ne",null));
		List topicList = this.mongoTemplate.getCollection("T_UserReadLog").distinct("topicId",query);
        return archList.size() + topicList.size();
	}

	/**
	* @Title: getUserReadLogsByUserId 
	* @Description: 根据用户id 查询阅读记录
	* @param userId
	* @return List<UserReadLog>    返回类型 
	* @author 李静
	 */
	@Override
	public List<UserReadLog> getUserReadLogsByUserId(int userId) {
		List<UserReadLog> list = userReadLogDao.getUserReadLogsByUserId(userId);
		return list;
	}

}
