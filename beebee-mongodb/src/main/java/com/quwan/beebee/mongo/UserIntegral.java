package com.quwan.beebee.mongo;

import org.jongo.marshall.jackson.oid.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T_UserIntegral")
public class UserIntegral {

	@Id
	private String id;

	private Integer userId;

	private Integer integral = 0;    //当前积分
	
	private Integer total = 0;       //总获得积分
	
	private Integer today = 0;       //今日获得积分
	
	private Integer theMonth = 0;    //本月积分
	
	private Integer theWeek = 0;     //本周积分
	
	private Integer signInDays = 0;   //签到天数
	
	private Integer todaySignIn = 0;   //今天是否签到
	
	private Integer readDays = 0;      //连续阅读3篇天数
	
	private Integer todayRead = 0;     //今天是否阅读
	
	private Integer perfectData = 0;    //是否完善资料
	
	private Integer todayComment = 0;    //今天是否评论
	
	private Integer todayShare = 0;    //今天是否分享
	
	private Integer shares = 0;    //今天分享次数
	
	private Integer pushed = 0;        //绑定微信，0-未绑定，1-绑定
	
	private Integer bindWechat = 0;        //开启推送，0-未开启，1-开启
	
	private Integer located = 0;        //开启定位，0-未开启，1-开启
	
	private Integer addressList = 0;    //开启通讯录，0-未开启，1-开启
	
	private Integer inviteFriend = 0;    //是否邀请用户
	
	private String addTime;        //添加時間
	
	private String modTime;        //修改时间
	
	

	public Integer getToday() {
		return today;
	}

	public void setToday(Integer today) {
		this.today = today;
	}

	public Integer getTheMonth() {
		return theMonth;
	}

	public void setTheMonth(Integer theMonth) {
		this.theMonth = theMonth;
	}

	public Integer getTheWeek() {
		return theWeek;
	}

	public void setTheWeek(Integer theWeek) {
		this.theWeek = theWeek;
	}

	public Integer getSignInDays() {
		return signInDays;
	}

	public void setSignInDays(Integer signInDays) {
		this.signInDays = signInDays;
	}

	public Integer getTodaySignIn() {
		return todaySignIn;
	}

	public void setTodaySignIn(Integer todaySignIn) {
		this.todaySignIn = todaySignIn;
	}

	public Integer getReadDays() {
		return readDays;
	}

	public void setReadDays(Integer readDays) {
		this.readDays = readDays;
	}

	public Integer getTodayRead() {
		return todayRead;
	}

	public void setTodayRead(Integer todayRead) {
		this.todayRead = todayRead;
	}

	public Integer getPerfectData() {
		return perfectData;
	}

	public void setPerfectData(Integer perfectData) {
		this.perfectData = perfectData;
	}

	public Integer getPushed() {
		return pushed;
	}

	public void setPushed(Integer pushed) {
		this.pushed = pushed;
	}

	public Integer getLocated() {
		return located;
	}

	public void setLocated(Integer located) {
		this.located = located;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	
	public String getModTime() {
		return modTime;
	}
	
	public void setModTime(String modTime) {
		this.modTime = modTime;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getAddressList() {
		return addressList;
	}

	public void setAddressList(Integer addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Integral [id=" + id + ", userId=" + userId + ", integral=" + integral + ", total=" + total + ", today="
				+ today + ", theMonth=" + theMonth + ", theWeek=" + theWeek + ", signInDays=" + signInDays
				+ ", todaySignIn=" + todaySignIn + ", readDays=" + readDays + ", todayRead=" + todayRead
				+ ", perfectData=" + perfectData + ", pushed=" + pushed + ", located=" + located + ", addressList="
				+ addressList + ", addTime=" + addTime + ", modTime=" + modTime + "]";
	}

	public Integer getTodayComment() {
		return todayComment;
	}

	public void setTodayComment(Integer todayComment) {
		this.todayComment = todayComment;
	}

	public Integer getTodayShare() {
		return todayShare;
	}

	public void setTodayShare(Integer todayShare) {
		this.todayShare = todayShare;
	}

	public Integer getBindWechat() {
		return bindWechat;
	}

	public void setBindWechat(Integer bindWechat) {
		this.bindWechat = bindWechat;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	public Integer getInviteFriend() {
		return inviteFriend;
	}

	public void setInviteFriend(Integer inviteFriend) {
		this.inviteFriend = inviteFriend;
	}


}
