package com.quwan.beebee.dao;

import java.util.List;

import com.quwan.beebee.param.user.*;
import com.quwan.beebee.resp.user.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quwan.beebee.entity.user.User;
import com.quwan.beebee.entity.user.UserIdentity;
import com.quwan.beebee.entity.user.UserSigninLog;
import com.quwan.beebee.mongo.UserIntegral;
import com.quwan.beebee.mongo.UserReadLog;
import com.quwan.beebee.resp.topic.TopicCommentResp;
import com.quwan.beebee.resp.user.CollectionResp;
import com.quwan.beebee.resp.user.ExchangeResp;
import com.quwan.beebee.resp.user.GetCommentsByUserIdentityResp;
import com.quwan.beebee.resp.user.GoodsDetailResp;
import com.quwan.beebee.resp.user.GoodsListResp;
import com.quwan.beebee.resp.user.HistoryArchivesResp;
import com.quwan.beebee.resp.user.NotificationListResp;
import com.quwan.beebee.resp.user.OrderListResp;
import com.quwan.beebee.resp.user.UserDynamicCommentResp;
import com.quwan.beebee.resp.user.UserDynamicResp;
import com.quwan.beebee.resp.user.UserInfoResp;
import com.quwan.beebee.resp.user.UserIntegralLogResp;
import com.quwan.beebee.resp.user.UserIntegralMoveResp;
import com.quwan.beebee.resp.user.UserPersonalPageResp;
import com.quwan.beebee.resp.user.UserSigninLogResp;

@Mapper
@Repository("userDao")
public interface UserDao {

	/* 注册用户 */
	Integer registerUser(@Param("param") RegisterParam param);

	/* 查询手机号是否已被注册 */
	Integer getUserByMobile(@Param("param") RegisterParam param);

	/* 通过mobile查询user */
	User getUserByPhone(String mobile);

	/* 登录后更新用户信息 */
	void updateForLogin(@Param("user") User user);

	/* 用过userId获取User */
	User getDetail(Integer userId);

	/* 获取用户历史浏览的总数 */
	Integer getHistoryTotal(Integer userId);

	/* 获取用户历史浏览的文章 */
	List<HistoryArchivesResp> getHistoryArchives(@Param("param") HistoryArchivesParam param);
	
	/* 获取用户历史浏览的文章  mongoDB 暂时只查文章 ，以后还会加活动 @李静 */
	List<HistoryArchivesResp> getHistoryReadLog(@Param("list") List<UserReadLog> list,
			@Param("param") HistoryArchivesParam param);
	
	/* 获取用户历史浏览的文章总数  mongoDB @李静 */
	Integer getHistoryReadLogTotal(@Param("list") List<UserReadLog> list);
	
	/* 用户修改密码 */
	void modifyPwd(@Param("param") ModifyPwdParam param);

	/* 修改用户资料 */
	void update(User user);

	/* 查询用户签到 */
	UserSigninLog getSigned(@Param("userId") int userId, @Param("currentDate") String currentDate);

	/* 插入用户签到日志 */
	void addUserSigninLog(UserSigninLog log);

	/* 获取积分列表 */
	List<UserSigninLogResp> getIntegralList(@Param("param") IntegralListParam param);

	/* 获取积分列表，总数 */
	Integer getIntegralListTotal(@Param("param") IntegralListParam param);

	/**
	 * 修改用户头像
	 * 陈晓婵
	 * 2017年12月22日15:12:40
	 */
	Integer updateHead(@Param("param") UpdateHeadParam param);

	/**
	 * 查询用户权限
	 * 陈晓婵
	 * 2017年12月22日18:28:51
	 */
	Integer getSwitch(@Param("param") SetwitchParam param);

	/**
	 * 对用户开启权限
	 * 陈晓婵
	 * 2017年12月22日18:29:41
	 */
	Integer setWitch(@Param("param") SetwitchParam param);

	/**
	 * 更新用户权限
	 * 陈晓婵
	 * 2017年12月22日18:29:50
	 */
	Integer updateWitch(@Param("param") SetwitchParam param);

	/**
	 * 查询我的收藏
	 */
	List<CollectionResp> getCollectionList(CollectionParam param);

	/**
	 * 我的收藏总数
	 */
	Integer getCollectionListTotal(CollectionParam param);

	/**
	 * 获取商品列表
	 */
	List<GoodsListResp> getGoodsList(GoodsListParam param);

	/**
	 * 获取商品详情
	 */
	Integer getGoodsListTotal(GoodsListParam param);

	/**
	 * 获取商品详情
	 */
	GoodsDetailResp getGoodsDetail(int goodsId);

	/**
	 * 获取订单列表-兑换记录
	 */
	List<OrderListResp> getOrderList(OrderListParam param);

	/**
	 * 兑换记录总数
	 */
	Integer getOrderListTotal(OrderListParam param);

	/**
	 * 获取订单详情
	 */
	OrderListResp getOrderDetail(int orderId);

	/**
	 * 系统通知
	 * 陈晓婵
	 * 2017年12月23日11:22:24
	 */
	List<NotificationListResp> getNotificationList(@Param("param") NotificationParam param);

	/**
	 * 系统通知total
	 * 陈晓婵
	 * 2017年12月23日15:30:12
	 */
	Integer getNotificationListTotal(@Param("param") NotificationParam param);

	/**
	 * 我的评论
	 * 陈晓婵
	 * 2017年12月23日14:25:24
	 */
	List<TopicCommentResp> getMineCommentList(@Param("param") NotificationParam param);

	/**
	 * 我的评论total
	 * 陈晓婵
	 * 2017年12月23日15:31:35
	 */
	Integer getMineCommentListTotal(@Param("param") NotificationParam param);

	/**
	 * 兑换商品
	 * 陈晓婵
	 * 2017年12月23日17:21:41
	 */
	Integer exchange(@Param("param") ExchangeParam param);

	/**
	 * 兑换商品
	 * 陈晓婵
	 * 2017年12月23日18:25:15
	 */
	Integer insertOrderGoods(@Param("param") ExchangeResp param);

	/**
	 * 查看商品信息
	 * 陈晓婵
	 * 2017年12月23日18:57:28
	 */
	ExchangeResp getGoodsInfo(int goodsId);

	/**
	 * 根据手机号获取用户登陆的信息
	 * 陈晓婵
	 * 2018年1月12日10:58:373
	 */
	UserInfoResp getUserInfo(String mobile);

	/**
	 * 根据用户id更新积分
	 *
	 * @param param
	 * @return
	 */
	void updateIntegral(@Param("param") UpdateIntegralParam param);
	
	/* 保存用户积分，同步MySQL，因为运营后台有用到 ---暂时保留   李静 */
    void saveUserIntegral(@Param("param") UserIntegral param);
	
	 /**
     * 获取用户当天的评论文章的个数-陈晓婵-2018年1月8日15:56:28
     * @param userId
     * @return
     */
    int getArchivesCommentCount(int userId);
    
    /**
     * 获取用户当天的评论哔哔的个数-陈晓婵-2018年1月8日15:58:32
     * @param userId
     * @return
     */
    int getTopicCommentCount(int userId);

    /**
     * 判断今天是否回复别人的评论-陈晓婵-2018年1月8日19:35:24
     * @param userId
     * @return
     */
    int getCommentAnswer(int userId);
    
    /**
     *获取当天活动分享个数-陈晓婵-2018年1月6日17:03:05
     * @param userId
     * @return
     */
    int getTopicShareCount(int userId);

    /**
     * 获取当天文章分享个数-陈晓婵-2018年1月6日17:03:42
     * @param userId
     * @return
     */
    int getArchiShareCount(int userId);
    
    /**
     * 获取用户最近一周的签到日志-陈晓婵-2018年1月16日19:32:38
     * @param userId
     * @return
     */
    int getUserSignLog(int userId);
    
	/**
	 * 新增用户积分日志-陈晓婵-2018年1月17日21:14:27
	 * 
	 * @param param
	 * @return
	 */
	int insertIntegralLog(@Param("param") UserIntegralLogResp param);
	
	/**
	 * 查询用户id-陈晓婵-2018年1月18日15:32:57
	 * @return
	 */
	List<GetTaskListParam> getUserId();
	
	/**
	 * 根据用户id查询积分详情-陈晓婵-2018年1月18日15:48:18
	 * @param param
	 * @return
	 */
	UserIntegralMoveResp getUserIntegralDetail(@Param("param")GetTaskListParam param);
	
	/**
	* @Title: addUserIdentity
	* @Description: 添加用户身份
	* @param userIdentity
	* @return int    返回类型
	* @author 李静
	 */
	int addUserIdentity(UserIdentity userIdentity);
	
	/**
	* @Title: getIdentitys
	* @Description: 跟用userId和身份查库中是否已存在该用户身份
	* @param userIdentity
	* @return List<UserIdentity>    返回类型
	* @author 李静
	 */
	List<UserIdentity> getIdentitys(UserIdentity userIdentity);

	/**
	* @Title: getUserPersonalPage
	* @Description: 查询用户个人主页信息
	* @param param
	* @return UserPersonalPageResp    返回类型
	* @author 李静
	 */
	UserPersonalPageResp getUserPersonalPage(UserPersonalPageParam param);

	// 个人主页 - 身份墙 - 修改身份隐藏状态
	int displayUserIdentitys(@Param("userId")int userId);

	int hideUserIdentitys(@Param("array")String[] identityIdArray);

	// 根据用户id和身份id查询参与的哔哔  - 李静
	List<GetCommentsByUserIdentityResp> getCommentsByUserIdentity(GetCommentsByUserIdentityParam param);

	int getCommentsByUserIdentityTotal(GetCommentsByUserIdentityParam param);
	
	// 个人主页 - 参与的哔哔   @李静
	List<UserDynamicResp> getParticipateTopics(UserDynamicParam param);

	int getParticipateTopicTotal(UserDynamicParam param);
	
	// 个人主页 - 发起的哔哔  @李静
	List<UserDynamicResp> getStartTopics(UserDynamicParam param);

	int getStartTopicTotal(UserDynamicParam param);
	
	// 个人主页 - 回复    @李静
	List<UserDynamicCommentResp> getComments(UserDynamicParam param);
	
	int getCommentTotal(UserDynamicParam param);

	/**
	 * 插入红包信息
	 * @param userId
	 * @param money
	 * @return
	 */
	int insertRedPacket(int userId, int money);

	/**
	 * 判断红包是否存在
	 * @param param
	 * @return
	 */
	RedPacketResp checkRedPacket(RedPacketParam param);

	/**
	 * 根据用户id查询积分总和
	 */
	int getUserIntegralById(int userId);

	/* 加入黑名单 */
    void addBlacklist(BlacklistParam param);

    /* 根据id查询黑名单 */
    Integer getBlacklist(BlacklistParam param);

	/* 移除黑名单 */
	void removeBlackList(BlacklistParam param);

	/* 黑名单列表 */
	List<UserBlackResp> getBlackList(int userId);

	Integer getBlackListTotal(NotificationParam param);
}
