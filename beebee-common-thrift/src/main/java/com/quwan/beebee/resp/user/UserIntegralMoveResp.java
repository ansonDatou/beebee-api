package com.quwan.beebee.resp.user;

public class UserIntegralMoveResp {

	private int signindays;
	private int todaysignin;
	private int readdays;
	private int todayread;
	private int perfectdata;
	private int pushed;
	private int located;
	private int addresslist;
	private int userId;
	
	public int getSignindays() {
		return signindays;
	}

	public void setSignindays(int signindays) {
		this.signindays = signindays;
	}

	public int getTodaysignin() {
		return todaysignin;
	}

	public void setTodaysignin(int todaysignin) {
		this.todaysignin = todaysignin;
	}

	public int getReaddays() {
		return readdays;
	}

	public void setReaddays(int readdays) {
		this.readdays = readdays;
	}

	public int getTodayread() {
		return todayread;
	}

	public void setTodayread(int todayread) {
		this.todayread = todayread;
	}

	public int getPerfectdata() {
		return perfectdata;
	}

	public void setPerfectdata(int perfectdata) {
		this.perfectdata = perfectdata;
	}

	public int getPushed() {
		return pushed;
	}

	public void setPushed(int pushed) {
		this.pushed = pushed;
	}

	public int getLocated() {
		return located;
	}

	public void setLocated(int located) {
		this.located = located;
	}

	public int getAddresslist() {
		return addresslist;
	}

	public void setAddresslist(int addresslist) {
		this.addresslist = addresslist;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserIntegralMoveResp [signindays=" + signindays
				+ ", todaysignin=" + todaysignin + ", readdays=" + readdays
				+ ", todayread=" + todayread + ", perfectdata=" + perfectdata
				+ ", pushed=" + pushed + ", located=" + located
				+ ", addresslist=" + addresslist + ", userId=" + userId + "]";
	}
}
