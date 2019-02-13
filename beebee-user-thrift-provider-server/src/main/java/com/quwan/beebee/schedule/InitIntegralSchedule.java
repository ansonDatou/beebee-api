package com.quwan.beebee.schedule;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.quwan.beebee.service.UserIntegralService;

@Component
public class InitIntegralSchedule {

	@Autowired
	UserIntegralService userIntegralService;
	
	/**
	* @Title: initIngegral 
	* @Description: 每天凌晨初始化 用户积分表
	* @author 李静
	* @throws
	 */
	@Scheduled(cron = "00 00 00 * * ?")
	public void initIntegralOfStartDay(){
		System.out.println(" ---- initIngegral initIntegralOfStartDay start....."+new Date());
		
		userIntegralService.initIntegralOfStartDay();
		
		System.out.println(" ---- initIngegral initIntegralOfStartDay end....."+new Date());
	}
	
	/**
	* @Title: initIngegralOfStartWeek 
	* @Description: 每周开始时间更新积分表
	* @author 李静
	* @throws
	 */
	@Scheduled(cron = "59 59 23 ? * SUN")
	public void initIngegralOfStartWeek(){
		System.out.println(" ---- initIngegral initIngegralOfStartWeek start....."+new Date());
		
		userIntegralService.initIngegralOfStartWeek();
		
		System.out.println(" ---- initIngegral initIngegralOfStartWeek end....."+new Date());
	}
	
	/**
	* @Title: initIngegralOfStartMonth 
	* @Description: 每月开始时间更新积分表
	* @author 李静
	* @date 2018年2月1日 下午4:20:35
	* @throws
	 */
	@Scheduled(cron = "0 0 0 1 * ?")
	public void initIngegralOfStartMonth(){
		System.out.println(" ---- initIngegral initIngegralOfStartMonth start....."+new Date());
		
		userIntegralService.initIngegralOfStartMonth();
		
		System.out.println(" ---- initIngegral initIngegralOfStartMonth end....."+new Date());
	}
}
