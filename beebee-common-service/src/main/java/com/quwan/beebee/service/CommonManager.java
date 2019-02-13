package com.quwan.beebee.service;

import com.quwan.beebee.param.third.AuthcodeParam;
import org.apache.thrift.TException;

import com.quwan.beebee.meta.IntegralTypeEnum;
import com.quwan.beebee.utils.Result;

public interface CommonManager {

	// 获取验证码的状态
	String checkAuthcode(AuthcodeParam param) throws TException;

	// 更新验证码
	String updateAuthcodeStatus(AuthcodeParam param) throws TException;
	
	//送花朵
	Result sendIntegral(int userId, IntegralTypeEnum integralTypeEnum, int integralNum) throws TException;
}
