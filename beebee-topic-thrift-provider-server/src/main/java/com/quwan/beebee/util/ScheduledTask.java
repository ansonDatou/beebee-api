package com.quwan.beebee.util;

import com.quwan.beebee.dao.CommonDao;
import com.quwan.beebee.resp.common.CommonPushResp;
import com.quwan.beebee.utils.DateUtils;
import com.quwan.beebee.utils.JiguangPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ScheduledTask {

    @Autowired
    public CommonDao commonDao;

    @Scheduled(cron = "0 0/30 * * * ?") //每5分钟执行一次
    public void statusCheck(){
        Date date = new Date();
        List<CommonPushResp> respList = commonDao.getPushList();
        for(CommonPushResp commonPushResp : respList){
            boolean isMore24Hour = DateUtils.is24Hour(commonPushResp.getAddtime(), date);
            if(isMore24Hour){
                //超过24小时不操作，发布推送信息
                if(commonPushResp.getJoinCount() > 0){
                    String ALERT = commonPushResp.getJoinCount() + "人与你进行了互动，快来看一看吧！";
                    JiguangPush.jiguangPush(String.valueOf(commonPushResp.getUserId()), ALERT);
                    commonDao.updatePushTime(commonPushResp.getUserId());
                }
            }
        }
    }
}