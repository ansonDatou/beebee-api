package com.quwan.beebee.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.quwan.beebee.meta.IntegralTypeEnum;
import com.quwan.beebee.mongo.UserIntegral;
import com.quwan.beebee.mongo.UserIntegralLog;
import com.quwan.beebee.service.UserIntegralService;
import com.quwan.beebee.utils.DateUtils;

@Service("integralService")
public class UserIntegralServiceImpl implements UserIntegralService {

	@Autowired  
    private MongoTemplate mongoTemplate;  
	
	/**
	* @Title: getCountByCondition 
	* @Description: 查询今日是否获取积分
	* @param userId
	* @param type
	* @param addTime
	* @return long    返回类型 
	 */
	@Override
	public long getCountByCondition(int userId ,int type, String addTime) {  
        Criteria criteria = new Criteria();  
        criteria.and("userId").is(userId);  
        criteria.and("type").is(type); 
        if(IntegralTypeEnum.READ_3.code == type || IntegralTypeEnum.SIGN.code == type ||
        		IntegralTypeEnum.COMMENT.code == type || IntegralTypeEnum.SHARE.code == type)
        	criteria.and("addTime").gte(addTime); 
        if(IntegralTypeEnum.SHARE.code == type)
        	criteria.and("shares").gte(5); 
        Query query = new Query(criteria);  
        
        return this.mongoTemplate.count(query, UserIntegralLog.class);  
    } 
	
	/**
	* @Title: getStatistics 
	* @Description: 获取积分统计信息
	* @param userId
	* @return Integral    返回类型 
	* @author 李静
	* @throws
	 */
	@Override
	public UserIntegral getStatistics(int userId){
		
		SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simdf.format(DateUtils.getDayBegin());
        String theWeek = simdf.format(DateUtils.getBeginDayOfWeek());
        String theMonth = simdf.format(DateUtils.getBeginDayOfMonth());
        String total = "2017-01-01 00:00:00";
		DBCollection coll = this.mongoTemplate.getCollection("T_IntegralLog");
		UserIntegral integral = new UserIntegral();
		integral.setToday(getStatistic(userId, today, coll, false));
		integral.setTheWeek(getStatistic(userId, theWeek, coll, false));
		integral.setTheMonth(getStatistic(userId, theMonth, coll, false));
		integral.setTotal(getStatistic(userId, total, coll, false));
		integral.setIntegral(getStatistic(userId, total, coll, true));
		return integral;
	}
	
	/**
	* @Title: getStatistic 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param userId
	* @param time
	* @param coll
	* @param isValid 是否获取有效积分
	* @return int    返回类型 
	* @author 李静
	* @throws
	 */
	private int getStatistic(int userId, String time, DBCollection coll, boolean isValid){
		DBObject match = null;
		if(isValid){
			/*创建 $match, 作用相当于query*/
			match = new BasicDBObject("$match", 
					new BasicDBObject("userId", userId).append("addTime",new BasicDBObject("$gte",time)));
		}else{
			match = new BasicDBObject("$match", 
					new BasicDBObject("userId", userId).append("addTime",new BasicDBObject("$gte",time))
						.append("integral",new BasicDBObject("$gt",0)));
		}
		
		/* Group操作*/
		DBObject groupFields = new BasicDBObject("_id", "$userId");
		groupFields.put("total", new BasicDBObject("$sum", "$integral"));
		DBObject group = new BasicDBObject("$group", groupFields);
		
		/* 查看Group结果 */
		AggregationOutput output = coll.aggregate(match, group); // 执行 aggregation命令
		int total = 0;
		for(DBObject result: output.results())
		   total = Integer.parseInt(result.get("total").toString());
		
		return total;
		
	}

	@Override
	public void save(UserIntegral integral) {
		mongoTemplate.save(integral);
	}

	/**
	* @Title: getIntegralLogsByCondition 
	* @Description: 根据条件查询积分日志
	* @param userId
	* @param title
	* @return List<IntegralLog>    返回类型 
	* @author 李静
	 */
	@Override
	public List<UserIntegralLog> getIntegralLogsByCondition(int userId, String title) {
		Query queryUpdate = new Query();
		Criteria criteriaUpdate = new Criteria();
		criteriaUpdate.and("userId").is(userId);
		criteriaUpdate.and("title").is(title);
		queryUpdate.addCriteria(criteriaUpdate);
		return mongoTemplate.find(queryUpdate,UserIntegralLog.class);
	}

	//每日开始时间更新积分表
	@Override
	public void initIntegralOfStartDay() {
		
		//昨天没有签到，连续签到置为 0 
		mongoTemplate.updateMulti(new Query(Criteria.where("todaysignin").is(0)), 
				new Update().set("signindays", 0), UserIntegralService.class);
		
		//昨天没有阅读三篇，连续阅读置为 0 
		mongoTemplate.updateMulti(new Query(Criteria.where("todayread").is(0)), 
				new Update().set("readdays", 0), UserIntegralService.class);
		
		//把今日积分、今日阅读、今日签到、今日评论、今日分享 置0
		mongoTemplate.updateMulti(null, new Update().
				set("today", 0).set("todaysignin", 0).set("todayread", 0)
				.set("todayComment", 0).set("todayShare", 0).set("shares", 0), UserIntegralService.class);
	}

	//每周开始时间更新积分表
	@Override
	public void initIngegralOfStartWeek() {
		mongoTemplate.updateMulti(null, new Update().set("theweek", 0),
				UserIntegralService.class);
	}

	//每月开始时间更新积分表
	@Override
	public void initIngegralOfStartMonth() {
		mongoTemplate.updateMulti(null, new Update().set("themonth", 0),
				UserIntegralService.class);
	}
}
