package com.quwan.beebee.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quwan.beebee.mongo.UserReadLog;

/**
* @ClassName: UserReadLog 
* @Description: 用户阅读日志（文章、活动）
* @author 李静
* @date 2018年1月4日 下午2:39:41 
*
 */
public interface UserReadLogDao extends MongoRepository<UserReadLog, String> {

	/**
	* @Title: insert 
	* @Description: 增加一条阅读记录 
	* @param readLog void    返回类型 
	* @throws
	 */
	public UserReadLog insert(UserReadLog readLog);
	
	/**
	* @Title: getUserReadLogsByUserId 
	* @Description: 根据用户id 查询阅读记录
	* @param userId
	* @return List<UserReadLog>    返回类型 
	* @author 李静
	 */
	public List<UserReadLog> getUserReadLogsByUserId(int userId);
}
