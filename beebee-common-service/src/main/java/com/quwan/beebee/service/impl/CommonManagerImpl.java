package com.quwan.beebee.service.impl;

import java.util.List;

import com.quwan.beebee.param.third.AuthcodeParam;
import com.quwan.beebee.param.user.UpdateIntegralParam;
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
import com.quwan.beebee.dao.CommonDao;
import com.quwan.beebee.dao.UserDao;
import com.quwan.beebee.dao.UserIntegralDao;
import com.quwan.beebee.dao.UserIntegralLogDao;
import com.quwan.beebee.meta.IntegralTypeEnum;
import com.quwan.beebee.mongo.UserIntegral;
import com.quwan.beebee.mongo.UserIntegralLog;
import com.quwan.beebee.resp.user.UserIntegralLogResp;
import com.quwan.beebee.service.CommonManager;
import com.quwan.beebee.service.UserIntegralService;
import com.quwan.beebee.service.UserReadService;
import com.quwan.beebee.utils.Result;

/**
* @ClassName: CommonManagerImpl 
* @Description: 公共类
* @author 李静
* @date 2018年1月19日 下午5:00:08 
*
 */
@Service("commonManager")
@Transactional
public class CommonManagerImpl implements CommonManager {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonManagerImpl.class);
	
	@Autowired
    public CommonDao commonDao;
	
	@Autowired
	private UserIntegralService integralService;
	
	@Autowired
	private UserIntegralLogDao integralLogDao;
	
	@Autowired
	private UserIntegralDao integralDao;
	
	@Autowired
	private UserReadService userService;
	
	@Autowired
	public UserDao userDao;
	
	/**
     * 检查验证码
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String checkAuthcode(AuthcodeParam param) throws TException {
        String used = null;
        try {
            used = commonDao.getAuthcode(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unexpected exception", e);
            return Boolean.TRUE.toString();
        }

        return StringUtils.equals("0", used) ? Boolean.FALSE.toString() : Boolean.TRUE.toString();
    }
    
    /**
     * 更新验证码状态
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String updateAuthcodeStatus(AuthcodeParam param) throws TException {
        try {
        	commonDao.updateAuthcodeStatus(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unexpected exception", e);
            return JSON.toJSONString(Result.error());
        }

        return JSON.toJSONString(Result.success());
    }

    /**
     * 获取连续阅读天数
     *
     * @param userId
     * @param integral
     * @return
     */
    /*private int getReadDays(int userId, UserIntegral integral) {
        int readDays = 0;
        List<UserIntegral> inList = integralDao.findByUserId(userId);
        if (inList == null || inList.isEmpty()) {
            return readDays;
        }
        integral = inList.get(0);
        String yesterday = DateFormatUtils.format(DateUtils.getBeginDayOfYesterday().getTime(), Constants.FORMAT_DATETIME);
        //查询昨天不同的文章、活动 阅读次数
        int readCountY = userService.getReadtimesByCondition(userId, yesterday);
        //如果昨天阅读次数小于3，则今天是连续阅读 第一天
        if (readCountY < 3) {
            readDays = integral.getReadDays();
        }
        readDays += 1;
        if (readDays > 7) {
            readDays = 1;  //七天一轮回
        }
        return readDays;
    }*/
    
    /**
    * @Description: 送积分
    * @author 李静
    * @date 2018年1月25日 下午4:53:06 
    * @param userId
    * @param integralTypeEnum
    * @param ingegralNum
    * @return String
    * @throws TException
     */
	@Override
	public Result sendIntegral(int userId, IntegralTypeEnum integralTypeEnum, int integralNum) throws TException {
		
		int days = 1;
		
		//查询用户积分总表  ---先查缓存，加缓存----
		List<UserIntegral> userIntegralList = integralDao.findByUserId(userId);
		UserIntegral integral = new UserIntegral();
		if(userIntegralList.size() > 0){
			integral = userIntegralList.get(0);
			if(IntegralTypeEnum.READ_3.code == integralTypeEnum.code &&
					integral.getTodayRead() == 1){
				return Result.response(1, "今日阅读已领过积分！");
			}else if(IntegralTypeEnum.SIGN.code == integralTypeEnum.code &&
					integral.getTodaySignIn() == 1){
				return Result.response(1, "今日签到已领过积分！");
			}else if(IntegralTypeEnum.COMMENT.code == integralTypeEnum.code &&
					integral.getTodayComment() == 1){
				return Result.response(1, "今日评论已领过积分！");
			}else if(IntegralTypeEnum.SHARE.code == integralTypeEnum.code &&
					integral.getShares() >= 5){
				return Result.response(1, "今日已分享5次领过积分！");
			}else if(IntegralTypeEnum.PERFECT_INFORMATION.code == integralTypeEnum.code &&
					integral.getPerfectData() == 1){
				return Result.response(1, "完善资料已领过积分！");
			}else if(IntegralTypeEnum.OPEN_LOCATION.code == integralTypeEnum.code &&
					integral.getLocated() == 1){
				return Result.response(1, "开启定位已领过积分！");
			}else if(IntegralTypeEnum.OPEN_PUSH.code == integralTypeEnum.code &&
					integral.getPushed() == 1){
				return Result.response(1, "开启推送已领过积分！");
			}else if(IntegralTypeEnum.OPEN_ADDRESS_BOOK.code == integralTypeEnum.code &&
					integral.getAddressList() == 1){
				return Result.response(1, "开启通讯已领过积分！");
			}else if(IntegralTypeEnum.INVITE_FRIENDS.code == integralTypeEnum.code &&
					integral.getInviteFriend() == 1){
				return Result.response(1, "邀请好友已领过积分！");
			}else if(IntegralTypeEnum.BIND_WECHAT.code == integralTypeEnum.code &&
					integral.getBindWechat() == 1){
				return Result.response(1, "绑定微信领过积分！");
			}
	      	
		}
		 // 1、查询积分日志表是否已经获取积分 MongoDB
        String date = DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATE) + " 00:00:00";
        long count = integralService.getCountByCondition(userId, integralTypeEnum.code, date);
        if (count > 0) {
            return Result.response(1, "已领过积分！");
        }
        
		
		//如果是“每日阅读”
		if(IntegralTypeEnum.READ_3.code == integralTypeEnum.code){
			
	        // 2、查询不同的文章活动 阅读次数，如果三次阅读，加花朵
	        int readCount = userService.getReadtimesByCondition(userId, date);
	        if (readCount != 3) {
	            return Result.response(1, "未阅读三篇！");
	        }

	        // 阅读天数,送花朵数
	        if(userIntegralList.size() > 0){
	        	days = integral.getReadDays() + 1;
	        }
	        if(days == 8)
	        	days = 1;
	        integralNum = days;
	        if (days == 7) 
	        	integralNum = 14;
	        
		}else if(IntegralTypeEnum.SIGN.code == integralTypeEnum.code){
			
			//如果是“签到”
			if(userIntegralList.size() > 0)
	        	days = integral.getSignInDays() + 1;
			if(days == 8)
				days = 1;
			//所得花朵=连续签到天数
			integralNum = days;
			
		}
		
		// 保存所有积分（积分总表、积分日志表、用户表中的积分）
		saveAllIntegral(userId, integralTypeEnum, integralNum , days);
		
		return Result.success();
	}
	
	// 保存所有积分（积分总表、积分日志表、用户表中的积分）
	void saveAllIntegral(int userId, IntegralTypeEnum integralTypeEnum, int integralNum , int days) 
			throws TException {
		
		// 3.往T_IntegralLog中添加日志-2017年12月29日11:26:27
		UserIntegralLog integralLog = new UserIntegralLog();
		String createTime = DateFormatUtils.format(System.currentTimeMillis(),
				Constants.FORMAT_DATETIME);
		integralLog.setAddTime(createTime);
		integralLog.setIntegral(integralNum);
		integralLog.setTitle(integralTypeEnum.title);
		integralLog.setType(integralTypeEnum.code);
		integralLog.setTypeDesc(integralTypeEnum.title+"获得花朵");
		integralLog.setUserId(userId);
		integralLogDao.insert(integralLog);
		
		// 4.更新T_Integral表中的该用户的积分
		UserIntegral integral = new UserIntegral();
		UserIntegral newIntegral = integralService.getStatistics(userId);
        integral.setUserId(userId);
        integral.setToday(newIntegral.getToday());
        integral.setTheWeek(newIntegral.getTheWeek());
        integral.setTheMonth(newIntegral.getTheMonth());
        integral.setTotal(newIntegral.getTotal());
		if (newIntegral.getIntegral() == 0) {
			integral.setIntegral(integralNum);
		} else {
			integral.setIntegral(newIntegral.getIntegral());
		}
        integral.setModTime(DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME));
        
        //如果是“每日阅读”
      	if(IntegralTypeEnum.READ_3.code == integralTypeEnum.code){
      		integral.setTodayRead(1);
      		integral.setReadDays(days);
      	}
      	
      	//如果是“签到”
      	if(IntegralTypeEnum.SIGN.code == integralTypeEnum.code){
      		integral.setTodaySignIn(1);
      		integral.setSignInDays(days);
      	}
      	
      	//如果是“评论1次”
      	if(IntegralTypeEnum.COMMENT.code == integralTypeEnum.code)
      		integral.setTodayComment(1);
      		
  		//如果是“分享”
  		if(IntegralTypeEnum.SHARE.code == integralTypeEnum.code){
  			integral.setTodayShare(1);
  			integral.setShares(integral.getShares()+1);
  		}
  		
      	
      	//如果是“完善资料”
      	if(IntegralTypeEnum.PERFECT_INFORMATION.code == integralTypeEnum.code)
      		integral.setPerfectData(1);
      	
      	//如果是“开启定位”
      	if(IntegralTypeEnum.OPEN_LOCATION.code == integralTypeEnum.code)
      		integral.setLocated(1);
      	
      	//如果是“开启推送”
      	if(IntegralTypeEnum.OPEN_PUSH.code == integralTypeEnum.code)
      		integral.setPushed(1);
      	
      	//如果是“开启通讯录”
      	if(IntegralTypeEnum.OPEN_ADDRESS_BOOK.code == integralTypeEnum.code)
      		integral.setAddressList(1);
      	
      	//如果是“绑定微信”
      	if(IntegralTypeEnum.BIND_WECHAT.code == integralTypeEnum.code)
      		integral.setBindWechat(1);
      	
      	//如果是“邀请好友”
      	if(IntegralTypeEnum.INVITE_FRIENDS.code == integralTypeEnum.code)
      		integral.getInviteFriend();
      	
      	
        integralService.save(integral);
        
		// 5.更新T_User表中的积分字段
		UpdateIntegralParam updateIntegralParam = new UpdateIntegralParam();
		updateIntegralParam.setUserId(userId);
		if (newIntegral.getIntegral() == 0) {
			updateIntegralParam.setIntegral(integralNum);
		} else {
			updateIntegralParam.setIntegral(newIntegral.getIntegral());
		}
		userDao.updateIntegral(updateIntegralParam);
		
		// 同步MySQL，因为运营后台有用到 ---暂时保留
		userDao.saveUserIntegral(integral);
        
		// mysql中添加积分  （同步数据  暂时保留）
		UserIntegralLogResp userIntegralLog = new UserIntegralLogResp();
		userIntegralLog.setIntegral(integralNum);
		userIntegralLog.setType(integralTypeEnum.code);
		userIntegralLog.setTitle(integralTypeEnum.title);
		userIntegralLog.setTypeDesc(integralTypeEnum.title+"获得花朵");
		userIntegralLog.setTypeId(0);
		userIntegralLog.setUserId(userId);
		userDao.insertIntegralLog(userIntegralLog);
	}
}
