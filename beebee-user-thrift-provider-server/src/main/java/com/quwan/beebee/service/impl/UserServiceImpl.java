package com.quwan.beebee.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.quwan.beebee.mongo.LoyaltyLog;
import com.quwan.beebee.param.third.AuthcodeParam;
import com.quwan.beebee.param.user.*;
import com.quwan.beebee.resp.user.*;
import com.quwan.beebee.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.common.Constants;
import com.quwan.beebee.constant.IntegralConstant;
import com.quwan.beebee.dao.UserSignLogDao;
import com.quwan.beebee.dao.UserDao;
import com.quwan.beebee.entity.user.User;
import com.quwan.beebee.exception.ErrorCode;
import com.quwan.beebee.meta.IntegralTypeEnum;
import com.quwan.beebee.mongo.UserSignLog;
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
import com.quwan.beebee.resp.user.UserPersonalPageResp;
import com.quwan.beebee.resp.user.UserSigninLogResp;
import com.quwan.beebee.service.CommonManager;
import com.quwan.beebee.service.LoyaltyService;
import com.quwan.beebee.service.UserReadService;
import com.quwan.beebee.utils.MD5;
import com.quwan.beebee.utils.PageUtil;
import com.quwan.beebee.utils.Result;


/**
 * user模块
 */
@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService.Iface {

	@Autowired
	public UserDao userDao;

	@Autowired
	private LoyaltyService loyaltyService;

	@Autowired
	private UserSignLogDao signLogDao;

	@Autowired
	private UserReadService userReadService;
	
	@Autowired
	private CommonManager commonManager;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);

	/**
	 * 注册用户
	 * 
	 * @param param
	 * @return 0 = 成功，101 = 验证码错误，102 = 账户已被注册
	 * @throws TException
	 */
	@Override
	public String registering(RegisterParam param) throws TException {

		AuthcodeParam authcodeParam = new AuthcodeParam();
		authcodeParam.setAuthcode(param.getAuthCode());
		authcodeParam.setMobile(param.getMobile());
		try {
			// 1 校验验证码
			String used = commonManager.checkAuthcode(authcodeParam);
			
			if (StringUtils.isEmpty(used) || Boolean.valueOf(used)) {
				return JSON.toJSONString(Result.response(ErrorCode.AuthcodeFail));
			}
	
			// 2 查询手机号是否已被注册
			Integer userMobile = userDao.getUserByMobile(param);
			if (userMobile != null) {
				return JSON.toJSONString(Result.response(ErrorCode.MobileRegistered));
			}
			
	
			// 3 注册
			long millis = System.currentTimeMillis();
			String createTime = DateFormatUtils.format(millis,
					Constants.FORMAT_DATETIME);
			param.setPwd(MD5.encrypt(MD5.encrypt(param.getPwd()) + createTime));
			param.setAddTime(createTime);
			userDao.registerUser(param);
			Integer userId = userDao.getUserByMobile(param);
			
			// 4.“注册”送花朵  @李静
			commonManager.sendIntegral(userId, 
					IntegralTypeEnum.REGISTER, IntegralConstant.REGISTER_NUM);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl registering error",
					e);
			return JSON.toJSONString(Result.response(ErrorCode.ServerError));
		}
		
		// 4 更新验证码
		commonManager.updateAuthcodeStatus(authcodeParam);
		/*eurekaUtil.remoteInvoke(Server.BEEBEE_COMMON_SERVICE_THRIFT_CONSUMER,
				Method.COMMON_UPDATE_AUTHCODE_STATUS, authcodeParam);*/
		return JSON.toJSONString(Result.success());
	}

	/**
	 * 用户登录 TODO 需要调用方存User
	 * 
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String login(LoginParam param) throws TException {

		// 1 通过mobile查询user
		User user = userDao.getUserByPhone(param.getMobile());
		if (user == null) {
			return JSON.toJSONString(Result
					.response(ErrorCode.MobileUnregistered));
		}

		// 2 验证密码 TODO user.getAddtime() ----> 2017-12-01 15:15:57.0
		String addTime = null;
		try {
			addTime = DateFormatUtils.format(new SimpleDateFormat(
					Constants.FORMAT_DATETIME).parse(user.getAddTime()),
					Constants.FORMAT_DATETIME);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String pwd = MD5.encrypt(MD5.encrypt(param.getPwd()) + addTime);
		if (!StringUtils.equals(pwd, user.getPwd())) {
			return JSON.toJSONString(Result.response(ErrorCode.PasswordFail));
		}

		// 3 更新用户信息
		String loginTime = DateFormatUtils.format(System.currentTimeMillis(),
				Constants.FORMAT_DATETIME);
		user.setLoginTime(loginTime);
		if (StringUtils.isNotEmpty(param.getLoginIp())) {
			user.setLoginIp(param.getLoginIp());
		}
		if (StringUtils.isNotEmpty(param.getDeviceId())) {
			user.setDeviceId(param.getDeviceId());
		}
		if (StringUtils.isNotEmpty(String.valueOf(param.getDeviceType()))) {
			user.setDeviceType(param.getDeviceType());
		}
		try {
			userDao.updateForLogin(user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Unexpected exception", e);
			return JSON.toJSONString(Result.response(ErrorCode.ServerError));
		}
		
		// 4.查询用户的id,昵称,头像,积分
		UserInfoResp userInfo = userDao.getUserInfo(param.getMobile());
		if (userInfo != null) {
			int userIntegralById = userDao.getUserIntegralById(Integer
					.parseInt(userInfo.getId()));
			userInfo.setIntegral(userIntegralById);
			return JSON.toJSONString(Result.okObject(userInfo));
		} else {
			return JSON.toJSONString(Result.response(ErrorCode.UserIsNotExist));
		}
	}

	/**
	 * 用户修改密码
	 * 
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String modifyPwd(ModifyPwdParam param) throws TException {

		try {
			
			// 1 通过userid，查询User，并用mobile验证
			User user = userDao.getDetail(param.getUserId());
			if (user == null || !StringUtils.equals(user.getMobile(), param.getMobile())) {
				return JSON.toJSONString(Result.response(ErrorCode.UserIsNull));
			}
	
			// 2 验证旧密码 TODO 不知原接口传递的old密码是明文还是密文, user.getAddtime() ----> 2017-12-01
			// 15:15:57.0
			String addTime = DateFormatUtils.format(new SimpleDateFormat(
						Constants.FORMAT_DATETIME).parse(user.getAddTime()),
						Constants.FORMAT_DATETIME);
			String oldPwd = MD5.encrypt(MD5.encrypt(param.getOldPwd()) + addTime);
			if (!StringUtils.equals(oldPwd, user.getPwd())) {
				return JSON.toJSONString(Result.response(ErrorCode.OldPasswordFail));
			}
	
			// 3 修改密码
			String newPwd = MD5.encrypt(MD5.encrypt(param.getPwd()) + addTime);
			param.setPwd(newPwd);
			userDao.modifyPwd(param);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Unexpected exception", e);
			return JSON.toJSONString(Result.response(ErrorCode.ServerError));
		}
		return JSON.toJSONString(Result.success());
	}

	/**
	 * 通过userid获取User
	 * 
	 * @param userId
	 * @return
	 * @throws TException
	 */
	@Override
	public String getDetail(int userId) throws TException {
		GetTaskListParam param = new GetTaskListParam();
		param.setUserId(userId);
		User user = userDao.getDetail(userId);
		if (user != null) {
			UserIntegralMoveResp userIntegralDetail = userDao
					.getUserIntegralDetail(param);
			int userIntegralById = userDao.getUserIntegralById(userId);
			user.setIntegral(userIntegralById);
			user.setTodaySignIn(userIntegralDetail == null ? 0 : userIntegralDetail.getTodaysignin());
			user.setSignInDays(userIntegralDetail == null ? 0 : userIntegralDetail.getSignindays());
			return JSON.toJSONString(Result.okObject(user));
		} else {
			return JSON.toJSONString(Result.response(ErrorCode.UserIsNull));
		}
	}

	/**
	 * 获取用户历史浏览记录
	 * 
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String getReadedList(HistoryArchivesParam param) throws TException {
		Integer index = PageUtil.convertIndex(param.getPageNumber(),
				param.getPageSize());
		param.setPageNumber(index);
		Integer total = null;
		List<HistoryArchivesResp> list = null;
		try {
			//total = userDao.getHistoryTotal(param.getUserId());
			//list = userDao.getHistoryArchives(param);
			
			//MongoDB 查询阅读记录（文章、活动） 暂时只显示文章，以后会加上活动  @李静
			List<UserReadLog> readLogs = userReadService.getUserReadLogsByUserId(param.getUserId());
			if(readLogs.size()>0){
				list = userDao.getHistoryReadLog(readLogs, param);
				total = userDao.getHistoryReadLogTotal(readLogs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Unexpected exception", e);
			return JSON.toJSONString(Result.response(ErrorCode.ServerError));
		}
		Result result = Result.okList(param.getPageNumber(),
				param.getPageSize(), total, list);
		return JSON.toJSONString(result);
	}

	/**
	 * 修改用户资料
	 * 
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String update(UpdateUserParam param) throws TException {
		try {
			User user = userDao.getDetail(param.getUserId());
			if (user == null) {
				return JSON.toJSONString(Result.response(ErrorCode.UserIsNull));
			}
			if(StringUtils.isNotEmpty(param.getNicker())){
				user.setNicker(param.getNicker());
			}
			if(0 != param.getSex()){
				user.setSex(param.getSex());
			}
			if(StringUtils.isNotEmpty(param.getBirthday())){
				user.setBirthday(param.getBirthday());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     	        int age = getAgeByBirth(format.parse(param.getBirthday()));
     	        user.setAge(age);
			}
			if(StringUtils.isNotEmpty(param.getRegion())){
				user.setRegion(param.getRegion());
			}
			if(StringUtils.isNotEmpty(param.getHead())){
				user.setHead(param.getHead());
			}
			if(StringUtils.isNotEmpty(param.getSignature())){
				user.setSignature(param.getSignature());
			}
			userDao.update(user);
			
			// 用户资料中所有个人信息都不能为空
			if (user.getSex() != 0 && user.getBirthday() != null
					&& user.getNicker() != null && user.getRegion() != null
					&& user.getHead() != null) {
				
				//“完善资料”送花朵  @李静
				commonManager.sendIntegral(param.getUserId(), 
						IntegralTypeEnum.PERFECT_INFORMATION, IntegralConstant.PERFECT_INFORMATION_NUM);
			} else {
				return JSON.toJSONString(Result.success());
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Unexpected exception", e);
			return JSON.toJSONString(Result.response(ErrorCode.ServerError));
		}
		return JSON.toJSONString(Result.success());
	}

	//根据出生日期计算年龄
	private int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
           return 0;
        }
    }
	
	/**
	 * 用户忘记密码
	 * 
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String retrievePwd(RetrievePwdParam param) throws TException {

		// 1 检测mobile
		User user = userDao.getUserByPhone(param.getMobile());
		if (user == null) {
			return JSON.toJSONString(Result.response(ErrorCode.UserIsNull));
		}

		// 2 检测验证码
		AuthcodeParam authcodeParam = new AuthcodeParam();
		authcodeParam.setAuthcode(param.getAuthcode());
		authcodeParam.setMobile(param.getMobile());
		String used = commonManager.checkAuthcode(authcodeParam);
		if (Boolean.valueOf(used)) {
			return JSON.toJSONString(Result.response(ErrorCode.AuthcodeFail));
		}

		// 3 修改密码
		String addTime = null;
		try {
			addTime = DateFormatUtils.format(new SimpleDateFormat(
					Constants.FORMAT_DATETIME).parse(user.getAddTime()),
					Constants.FORMAT_DATETIME);
			String newPwd = MD5.encrypt(MD5.encrypt(param.getPwd()) + addTime);
			userDao.modifyPwd(new ModifyPwdParam().setPwd(newPwd)
					.setUserId(user.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Unexpected exception", e);
			return JSON.toJSONString(Result.response(ErrorCode.ServerError));
		}

		// 4 更新验证码
		commonManager.updateAuthcodeStatus(authcodeParam);
		/*eurekaUtil.remoteInvoke(Server.BEEBEE_COMMON_SERVICE_THRIFT_CONSUMER,
				Method.COMMON_UPDATE_AUTHCODE_STATUS, authcodeParam);*/
		return JSON.toJSONString(Result.success());
	}

	/**
	 * 用户签到
	 * 
	 * @param userId
	 * @return
	 * @throws TException
	 */
	@Override
	public String signed(int userId) throws TException {
		Result result = null;
		try {
			// 1 检测userId
			User user = userDao.getDetail(userId);
			if (user == null) {
				return JSON.toJSONString(Result.response(ErrorCode.UserIsNull));
			}
			
			// 2.“签到”送花朵  @李静
			result = commonManager.sendIntegral(userId, 
					IntegralTypeEnum.SIGN, IntegralConstant.SIGN_NUM);
			if(Integer.parseInt(result.get("error").toString()) == 0){
				
				// 3.插入签到记录
				UserSignLog userSignLog = new UserSignLog();
				userSignLog.setUserId(userId);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				userSignLog.setSignDate(sdf.format(new Date()));
				userSignLog.setAddTime(DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME));
				signLogDao.insert(userSignLog);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl signed error",
					e);
			return JSON.toJSONString(Result.error());
		}
		return JSON.toJSONString(result);
	}

	/**
	 * 获取积分列表，最近7天
	 * 
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String getIntegralList(IntegralListParam param) throws TException {
		Integer index = PageUtil.convertIndex(param.getPageNumber(),
				param.getPageSize());
		param.setPageNumber(index);
		List<UserSigninLogResp> list = userDao.getIntegralList(param);
		Integer total = userDao.getIntegralListTotal(param);
		return JSON.toJSONString(Result.okList(param.getPageNumber(),
				param.getPageSize(), total, list));
	}

	/**
	 * 更新用户头像 陈晓婵 2017年12月22日15:32:06
	 */
	@Override
	public String updateHead(UpdateHeadParam param) throws TException {
		try {
			Integer updateHead = userDao.updateHead(param);
			if (updateHead != 0) {
				return JSON.toJSONString(Result.okObject(updateHead));
			}

			return JSON.toJSONString(Result.response(ErrorCode.UserIsNull));
		} catch (Exception e) {
			e.getStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl updateHead error",
					e);
			return JSON.toJSONString(Result.error());
		}
	}

	/**
	 * 更新用户权限 陈晓婵 2017年12月22日18:30:11
	 */
	@Override
	public String setwitch(SetwitchParam param) throws TException {
		try {
			
			// 1.查询数据库中是否有关于这个权限的记录
			Integer switchl = userDao.getSwitch(param);
			
			// 2.有,执行更新操作.没有,执行插入操作
			if (switchl > 0) {
				Integer updateWitch = userDao.updateWitch(param);
				Result okObject = Result.okObject(updateWitch);
				return JSON.toJSONString(okObject);
			} else {
				
				// 1.将用户权限更新到mysql数据库中 --暂留
				Integer setWitch = userDao.setWitch(param);
				
				// 开启推送功能
				if (param.getType() == 1 && param.getValid() == 1) {
					
					// “开启推送”送花朵  @李静
					commonManager.sendIntegral(param.getUserId(), 
							IntegralTypeEnum.OPEN_PUSH, IntegralConstant.OPEN_PUSH_NUM);
				}
				
				// 开启定位功能
				if (param.getType() == 2 && param.getValid() == 1) {
					
					// “开启定位”送花朵  @李静
					commonManager.sendIntegral(param.getUserId(), 
							IntegralTypeEnum.OPEN_LOCATION, IntegralConstant.OPEN_LOCATION_NUM);
				}
				
				// 开启通讯录功能
				if (param.getType() == 3 && param.getValid() == 1) {
					
					// “开启通讯录”送花朵  @李静
					commonManager.sendIntegral(param.getUserId(), 
							IntegralTypeEnum.OPEN_ADDRESS_BOOK, IntegralConstant.OPEN_ADDRESS_BOOK_NUM);
				}
				Result okObject = Result.okObject(setWitch);
				return JSON.toJSONString(okObject);
			}
		} catch (Exception e) {
			e.getStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl setwitch error",
					e);
			return JSON.toJSONString(Result.error());
		}
	}

	/**
	 * 获得花朵-陈晓婵-2017年12月22日20:47:45
	 */
	@Override
	public String getTaskList(GetTaskListParam param) throws TException {
		try {
			List<LoyaltyLog> init = loyaltyService.init(param.getUserId());
			Result okObject = Result.okObject(init);
			return JSON.toJSONString(okObject);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl getTaskList error ",
					e);
			return JSON.toJSONString(Result.error());
		}
	}

	/**
	 * 获取我的收藏
	 *
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String getCollectionList(CollectionParam param) throws TException {
		Integer index = PageUtil.convertIndex(param.getPageNumber(),
				param.getPageSize());
		param.setPageNumber(index);
		List<CollectionResp> list = userDao.getCollectionList(param);
		Integer total = userDao.getCollectionListTotal(param);
		return JSON.toJSONString(Result.okList(param.getPageNumber(),
				param.getPageSize(), total, list));
	}

	/**
	 * 蜜蜂集市-获取商品列表
	 *
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String getGoodsList(GoodsListParam param) throws TException {
		Integer index = PageUtil.convertIndex(param.getPageNumber(),
				param.getPageSize());
		param.setPageNumber(index);
		List<GoodsListResp> list = userDao.getGoodsList(param);
		Integer total = userDao.getGoodsListTotal(param);
		return JSON.toJSONString(Result.okList(param.getPageNumber(),
				param.getPageSize(), total, list));
	}

	/**
	 * 蜜蜂集市-获取商品详情
	 *
	 * @param goodsId
	 * @return
	 * @throws TException
	 */
	@Override
	public String getGoodsDetail(int goodsId) throws TException {
		GoodsDetailResp resp = userDao.getGoodsDetail(goodsId);
		return JSON.toJSONString(Result.okObject(resp));
	}

	/**
	 * 获取订单列表
	 *
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String getOrderList(OrderListParam param) throws TException {
		Integer index = PageUtil.convertIndex(param.getPageNumber(),
				param.getPageSize());
		param.setPageNumber(index);
		List<OrderListResp> list = userDao.getOrderList(param);
		Integer total = userDao.getOrderListTotal(param);
		return JSON.toJSONString(Result.okList(param.getPageNumber(),
				param.getPageSize(), total, list));
	}

	/**
	 * 获取商品详情
	 *
	 * @param orderId
	 * @return
	 * @throws TException
	 */
	@Override
	public String getOrderDetail(int orderId) throws TException {
		OrderListResp resp = userDao.getOrderDetail(orderId);
		LOGGER.info("orderId=" + orderId + "consignee=" + resp.getConsignee());
		return JSON.toJSONString(Result.okObject(resp));
	}

	/**
	 * 系统通知 陈晓婵 2017年12月23日11:54:28
	 */
	@Override
	public String getNotificationList(NotificationParam param)
			throws TException {
		try {
			Integer notificationListTotal = userDao
					.getNotificationListTotal(param);
			List<NotificationListResp> notificationList = userDao
					.getNotificationList(param);
			Result okList = Result.okList(param.getPageNumber(),
					param.getPageSize(), notificationListTotal,
					notificationList);
			return JSON.toJSONString(okList);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl getNotificationList error ",
					e);
			return JSON.toJSONString(Result.error());
		}
	}

	/**
	 * 我的评论 陈晓婵 2017年12月23日11:55:11
	 */
	@Override
	public String getMineCommentList(NotificationParam param) throws TException {
		try {
			Integer index = PageUtil.convertIndex(param.getPageNumber(),
					param.getPageSize());
			param.setPageNumber(index);
			Integer mineCommentListTotal = userDao
					.getMineCommentListTotal(param);
			List<TopicCommentResp> mineCommentList = userDao
					.getMineCommentList(param);
			Result okList = Result.okList(param.getPageNumber(),
					param.getPageSize(), mineCommentListTotal, mineCommentList);
			return JSON.toJSONString(okList);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl getMineCommentList error",
					e);
			return JSON.toJSONString(Result.error());
		}
	}

	/**
	 * 兑换商品 陈晓婵 2017年12月23日17:20:59
	 */
	@Override
	public String exchange(ExchangeParam param) throws TException {

		// 1 更新到order表中
		try {
			// 根据goodsId查询商品价格
			GoodsDetailResp goodsDetail = userDao.getGoodsDetail(param
					.getGoodsId());
			if (goodsDetail == null) {
				return JSON.toJSONString(Result
						.response(ErrorCode.NotExistThisGoods));
			}
			String price = goodsDetail.getPrice();
			int parseInt = Integer.parseInt(price);
			// 查询用户的花朵数是否大于商品兑换金额
			User detail = userDao.getDetail(param.getUserId());
			if (detail.getIntegral() < parseInt) {
				return JSON.toJSONString(Result
						.response(ErrorCode.AmountCountNotEnough));
			}
			GoodsDetailResp resp = userDao.getGoodsDetail(param
					.getGoodsId());
			if (resp == null) {
				return JSON.toJSONString(Result
						.response(ErrorCode.UserParamIsError));
			}
			// 随机生成订单号
			String sn = randomSn();
			param.setSn(sn);
			// 商品总价
			int amount = param.getGoodsNumber()
					* Integer.parseInt(resp.getPrice());
			param.setAmount(amount);
			Integer exchange = userDao.exchange(param);
			if (exchange != 0) {
				ExchangeResp goodsId = userDao.getGoodsInfo(exchange);
				Integer insertOrderGoods = userDao
						.insertOrderGoods(goodsId);
				return JSON.toJSONString(Result.okObject(insertOrderGoods));
			}
			return JSON.toJSONString(Result.error());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl exchange error",
					e);
			return JSON.toJSONString(Result.error());
		}
	}

	/**
	 * 生成随机订单号：当前年月日时分秒+五位随机数
	 * 
	 * @return
	 */
	private String randomSn() {
		SimpleDateFormat simpleDateFormat;
		simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String str = simpleDateFormat.format(date);
		Random random = new Random();
		int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
		return rannum + str;// 当前时间
	}

	/**
	 * mysql中添加积分日志-陈晓婵-2018年1月17日21:15:49
	 * 
	 * @param param
	 * @return
	 */
	public int insertIntegralLog(UserIntegralLogResp param) {
		int insertIntegralLog = userDao.insertIntegralLog(param);
		return insertIntegralLog;
	}
	
	
	/**
	* @Description: 个人主页-个人信息
	* @author 李静
	* @date 2018年1月30日 下午4:36:43 
	* @param param
	* @throws TException
	 */
	@Override
	public String getUserPersonalPage(UserPersonalPageParam param) throws TException {
		UserPersonalPageResp userPersonalInfo = null;
		try {
			userPersonalInfo =  userDao.getUserPersonalPage(param);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl getUserPersonalPage error",
					e);
			return JSON.toJSONString(Result.error());
		}
		return JSON.toJSONString(Result.okObject(userPersonalInfo));
	}
	
	/**
	* @Description: 个人主页 - 身份墙 - 修改身份隐藏状态
	* @author 李静
	* @date 2018年1月30日 下午7:09:00 
	* @param param
	* @throws TException
	 */
	@Override
	public String hideUserIdentitys(HideUserIdentitysParam param) throws TException {
		try {
			String identityIds = param.getIdentityIds();
			String[] identityIdArray = identityIds.split(",");
			if(identityIdArray.length > 0){
				userDao.displayUserIdentitys(param.getUserId());
				userDao.hideUserIdentitys(identityIdArray);
			}
			return JSON.toJSONString(Result.success());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl hideUserIdentitys error",
					e);
			return JSON.toJSONString(Result.error());
		}
	}

	/**
    * @Title: getCommentsByUserIdentity
    * @Description: 根据用户id和身份id查询参与的哔哔
    * @param param
    * @return String    返回类型
    * @author 李静
     */
	@Override
	public String getCommentsByUserIdentity(GetCommentsByUserIdentityParam param) throws TException {
		List<GetCommentsByUserIdentityResp> list = null;
		int total = 0;
		try {
			Integer index = PageUtil.convertIndex(param.getPageNumber(),
					param.getPageSize());
			param.setPageNumber(index);
			list = userDao.getCommentsByUserIdentity(param);
			total = userDao.getCommentsByUserIdentityTotal(param);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl getCommentsByUserIdentity error",
					e);
			return JSON.toJSONString(Result.error());
		}
		Result result = Result.okList(param.getPageNumber(),
				param.getPageSize(), total, list);
		return JSON.toJSONString(result);
	}

	/**
	* @Description: 获取我的动态
	* @author 李静
	* @date 2018年1月31日 下午3:47:20
	* @param param
	* @throws TException
	 */
	@Override
	public String getUserDynamic(UserDynamicParam param) throws TException {
		List<UserDynamicResp> list = null;
		int total = 0;
		Result result = null;
		try {
			Integer index = PageUtil.convertIndex(param.getPageNumber(),
					param.getPageSize());
			param.setPageNumber(index);

			//类型：1-参与的哔哔2-发起的哔哔3-进行的回复
			if(2 == param.getType()){
				list = userDao.getStartTopics(param);
				total = userDao.getStartTopicTotal(param);
			}else if(3 == param.getType()){
				List<UserDynamicCommentResp> commentList = userDao.getComments(param);
				total = userDao.getCommentTotal(param);
				result = Result.okList(param.getPageNumber(),
						param.getPageSize(), total, commentList);
				return JSON.toJSONString(result);
			}else{
				list = userDao.getParticipateTopics(param);
				total = userDao.getParticipateTopicTotal(param);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl getUserDynamic error",
					e);
			return JSON.toJSONString(Result.error());
		}
		result = Result.okList(param.getPageNumber(),
				param.getPageSize(), total, list);
		return JSON.toJSONString(result);
	}

	/**
	 * 判断用户是否领取了红包
	 * @param param
	 * @return
	 * @throws TException
	 */
    @Override
    public String checkRedPacket(RedPacketParam param) throws TException {
		RedPacketResp resp = userDao.checkRedPacket(param);
		if(resp == null){
			return JSON.toJSONString(Result
					.response(ErrorCode.UserParamIsError));
		}


		return null;

    }

	/**
	 * 加入黑名单
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String addBlacklist(BlacklistParam param) throws TException {
		Integer id = userDao.getBlacklist(param);
		if (id != null) {
			return JSON.toJSONString(Result.response(ErrorCode.AlreadyJoinedBlacklist));
		}
		userDao.addBlacklist(param);
		return JSON.toJSONString(Result.success());
	}

	/**
	 * 移除黑名单
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String removeBlackList(BlacklistParam param) throws TException {
		Integer id = userDao.getBlacklist(param);
		if(id == null){
			return JSON.toJSONString(Result.response(ErrorCode.NoExistBlackList));
		}
		userDao.removeBlackList(param);
		return JSON.toJSONString(Result.success());
	}


	/**
	 * 黑名单列表
	 * @param param
	 * @return
	 * @throws TException
	 */
	@Override
	public String getBlackList(NotificationParam param) throws TException {
		try {
			Integer index = PageUtil.convertIndex(param.getPageNumber(),
					param.getPageSize());
			param.setPageNumber(index);
			Integer blackListTotal = userDao
					.getBlackListTotal(param);
			List<UserBlackResp> respList = userDao
					.getBlackList(param.getUserId());
			Result okList = Result.okList(param.getPageNumber(),
					param.getPageSize(), blackListTotal, respList);
			return JSON.toJSONString(okList);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.UserServiceImpl getBlackList error",
					e);
			return JSON.toJSONString(Result.error());
		}
	}

}
