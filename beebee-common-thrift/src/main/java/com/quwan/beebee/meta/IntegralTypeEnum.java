package com.quwan.beebee.meta;

/**
* @ClassName: IntegralTypeEnum 
* @Description: 积分类型
* 类型：1－签到；2-点赞；3-收藏；4-评论；5-转发；6-发表；7-开启推送；8-开启定位；
* 9-开启通讯录；10-阅读3篇以上；11-注册；12-完善资料；13绑定微信；14-意见反馈；15-邀请好友；16-分享；17-抽奖;101-兑换奖品
* @author 李静
* @date 2018年1月5日 下午6:07:01 
*
 */
public enum IntegralTypeEnum {

	SIGN(1, "签到", "签到"),
	PRAISE(2, "点赞" ,"点赞"),
	COLLECTION(3, "收藏", "收藏"),
	COMMENT(4, "评论", "评论1次"),
	RELAY(5, "转发", "转发"),
	PUBLISH(6, "发表", "发表"),
	OPEN_PUSH(7, "开启推送", "开启推送"),
	OPEN_LOCATION(8, "开启定位", "开启定位"),
	OPEN_ADDRESS_BOOK(9, "开启通讯录", "开启通讯录"),
	READ_3(10, "已阅读3篇", "每日阅读"),
	REGISTER(11, "注册", "注册账号"),
	PERFECT_INFORMATION(12, "完善资料", "完善资料"),
	BIND_WECHAT(13, "绑定微信", "绑定微信"),
	FEEDBACK(14, "意见反馈", "意见反馈"),
	INVITE_FRIENDS(15, "邀请好友", "邀请好友"),
	SHARE(16, "分享", "分享（每天）"),
	DRAW(17, "抽奖", "抽奖"),
	EXCHANGE_GOODS(101, "兑换奖品", "兑换奖品");
	
	public int code;
	
	public String title;
	
	public String message;
	
	private IntegralTypeEnum(int code, String title, String message ){
		this.code = code;
		this.title=title;
		this.message = message;
	}
	
}
