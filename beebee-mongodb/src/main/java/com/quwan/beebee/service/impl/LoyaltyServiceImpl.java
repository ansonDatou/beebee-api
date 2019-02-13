package com.quwan.beebee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quwan.beebee.constant.IntegralConstant;
import com.quwan.beebee.dao.UserIntegralDao;
import com.quwan.beebee.meta.IntegralTypeEnum;
import com.quwan.beebee.mongo.Loyalty;
import com.quwan.beebee.mongo.LoyaltyDetail;
import com.quwan.beebee.mongo.LoyaltyLog;
import com.quwan.beebee.mongo.UserIntegral;
import com.quwan.beebee.service.LoyaltyService;

/**
* @ClassName: LoyaltyServiceImpl 
* @Description: 获得花朵详情
* @author 李静
* @date 2018年1月8日 下午8:15:52 
*
 */
@Service("loyaltyService")

public class LoyaltyServiceImpl implements LoyaltyService {

	@Autowired
	private UserIntegralDao integralDao;
	
	@Override
	public List<LoyaltyLog> init(int userId) throws TException{
		//查询用户积分总表  ---加缓存----
		List<UserIntegral> userIntegralList = integralDao.findByUserId(userId);
		UserIntegral integral = new UserIntegral();
		if(userIntegralList.size() > 0){
			integral = userIntegralList.get(0);
		}
		Loyalty loyalty = new Loyalty();
		loyalty.setUserId(userId);
		List<LoyaltyLog> listLoyaltyLog = new ArrayList<>();
		// 每日阅读
		LoyaltyLog read = new LoyaltyLog();
		read.setCode(IntegralTypeEnum.READ_3.code);
		read.setName(IntegralTypeEnum.READ_3.message);
		read.setReward("已阅读"+integral.getReadDays()+"天");
		List<LoyaltyDetail> listDetail = new ArrayList<>();
		LoyaltyDetail dayOne = new LoyaltyDetail();
		dayOne.setName("第1天登录当天阅读3篇以上");
		dayOne.setReward(IntegralConstant.READ_3_NUM+"朵花朵");
		LoyaltyDetail dayTwo = new LoyaltyDetail();
		dayTwo.setName("第2天登录当天阅读3篇以上");
		dayTwo.setReward(IntegralConstant.READ_3_NUM+1+"朵花朵");
		LoyaltyDetail dayThree = new LoyaltyDetail();
		dayThree.setName("第3天登录当天阅读3篇以上");
		dayThree.setReward(IntegralConstant.READ_3_NUM+2+"朵花朵");
		LoyaltyDetail dayFour = new LoyaltyDetail();
		dayFour.setName("第4天登录当天阅读3篇以上");
		dayFour.setReward(IntegralConstant.READ_3_NUM+3+"朵花朵");
		LoyaltyDetail dayFive = new LoyaltyDetail();
		dayFive.setName("第5天登录当天阅读3篇以上");
		dayFive.setReward(IntegralConstant.READ_3_NUM+4+"朵花朵");
		LoyaltyDetail daySix = new LoyaltyDetail();
		daySix.setName("第6天登录当天阅读3篇以上");
		daySix.setReward(IntegralConstant.READ_3_NUM+5+"朵花朵");
		LoyaltyDetail daySeven = new LoyaltyDetail();
		daySeven.setName("第7天登录当天阅读3篇以上");
		daySeven.setReward((IntegralConstant.READ_3_NUM+6)*2+"朵花朵");
		listDetail.add(dayOne);
		listDetail.add(dayTwo);
		listDetail.add(dayThree);
		listDetail.add(dayFour);
		listDetail.add(dayFive);
		listDetail.add(daySix);
		listDetail.add(daySeven);
		read.setDetail(listDetail);

		// 完善资料
		LoyaltyLog update = new LoyaltyLog();
		update.setCode(IntegralTypeEnum.PERFECT_INFORMATION.code);
		update.setName(IntegralTypeEnum.PERFECT_INFORMATION.message);
		update.setFinished(integral.getPerfectData());
		update.setReward(IntegralConstant.PERFECT_INFORMATION_NUM+"朵花朵");
		// 开启定位
		LoyaltyLog location = new LoyaltyLog();
		location.setCode(IntegralTypeEnum.OPEN_LOCATION.code);
		location.setName(IntegralTypeEnum.OPEN_LOCATION.message);
		location.setFinished(integral.getLocated());
		location.setReward(IntegralConstant.OPEN_LOCATION_NUM+"朵花朵");
		// 评论1次
		LoyaltyLog comment = new LoyaltyLog();
		comment.setCode(IntegralTypeEnum.COMMENT.code);
		comment.setName(IntegralTypeEnum.COMMENT.message);
		comment.setFinished(integral.getTodayComment());
		comment.setReward(IntegralConstant.COMMENT_NUM+"朵花朵");
		// 分享(每天)
		LoyaltyLog share = new LoyaltyLog();
		share.setCode(IntegralTypeEnum.SHARE.code);
		share.setName(IntegralTypeEnum.SHARE.message);
		share.setFinished(integral.getTodayShare());
		share.setReward("("+integral.getShares()+"/5)*2朵花朵");
		// 注册账号
		LoyaltyLog loyaltyLogParam = new LoyaltyLog();
		loyaltyLogParam.setCode(IntegralTypeEnum.REGISTER.code);
		loyaltyLogParam.setFinished(1);
		loyaltyLogParam.setName(IntegralTypeEnum.REGISTER.message);
		loyaltyLogParam.setReward(IntegralConstant.REGISTER_NUM+"朵花朵");
		// 开启通讯录
		LoyaltyLog mailList = new LoyaltyLog();
		mailList.setCode(IntegralTypeEnum.OPEN_ADDRESS_BOOK.code);
		mailList.setFinished(integral.getAddressList());
		mailList.setName(IntegralTypeEnum.OPEN_ADDRESS_BOOK.message);
		mailList.setReward(IntegralConstant.OPEN_ADDRESS_BOOK_NUM+"朵花朵");
		// 开启推送
		LoyaltyLog push = new LoyaltyLog();
		push.setCode(IntegralTypeEnum.OPEN_PUSH.code);
		push.setFinished(integral.getPushed());
		push.setName(IntegralTypeEnum.OPEN_PUSH.message);
		push.setReward(IntegralConstant.OPEN_PUSH_NUM+"朵花朵");

		// 签到
		// LoyaltyLog sign = new LoyaltyLog();
		// sign.setCode(IntegralTypeEnum.SIGN.code);
		// sign.setFinished(0);
		// sign.setName(IntegralTypeEnum.SIGN.message);
		// sign.setReward("已连续签到"+integral.getSignInDays()+"天");

		listLoyaltyLog.add(read);
		listLoyaltyLog.add(update);
		listLoyaltyLog.add(location);
		listLoyaltyLog.add(comment);
		listLoyaltyLog.add(share);
		listLoyaltyLog.add(loyaltyLogParam);
		listLoyaltyLog.add(mailList);
		listLoyaltyLog.add(push);
		// listLoyaltyLog.add(sign);
		loyalty.setData(listLoyaltyLog);
		return listLoyaltyLog;
	}
	

}
