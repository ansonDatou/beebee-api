package com.quwan.beebee.mongo;

import java.util.List;

public class Loyalty {

	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 积分详情
	 */
	private List<LoyaltyLog> data;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<LoyaltyLog> getData() {
		return data;
	}

	public void setData(List<LoyaltyLog> data) {
		this.data = data;
	}


}
