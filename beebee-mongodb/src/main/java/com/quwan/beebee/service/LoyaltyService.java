package com.quwan.beebee.service;

import java.util.List;

import org.apache.thrift.TException;

import com.quwan.beebee.mongo.LoyaltyLog;

public interface LoyaltyService {

	//初始化Loyalty数据
	List<LoyaltyLog> init(int userId) throws TException ;
	
}
