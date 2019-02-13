package com.quwan.beebee.dao;

import com.quwan.beebee.param.common.GetBannerParam;
import com.quwan.beebee.param.common.UploadImgParam;
import com.quwan.beebee.param.third.AuthcodeParam;
import com.quwan.beebee.param.third.SendMsgParam;
import com.quwan.beebee.resp.common.CommonPushResp;
import com.quwan.beebee.resp.common.GetBannerResp;
import com.quwan.beebee.resp.common.GetLastVersionResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("thirdDao")
public interface ThirdDao {

    // 添加验证码
    void addAuthcode(AuthcodeParam param);

    // 短信下发
    Integer sendMsg(@Param("param") SendMsgParam param);
}
