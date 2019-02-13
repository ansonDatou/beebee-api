package com.quwan.beebee.dao;

import java.util.List;

import com.quwan.beebee.entity.user.User;
import com.quwan.beebee.param.common.*;
import com.quwan.beebee.param.third.AuthcodeParam;
import com.quwan.beebee.resp.common.CommonPushResp;
import com.quwan.beebee.resp.common.GetBannerResp;

import com.quwan.beebee.resp.common.GetLastVersionResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("commonDao")
public interface CommonDao {

    // 获取验证码的状态
    String getAuthcode(AuthcodeParam param);

    // 更新验证码
    void updateAuthcodeStatus(AuthcodeParam param);

    // 获取banner
    List<GetBannerResp> getBanner(GetBannerParam param);

    // 上传图片
    Integer uploadImg(@Param("param") UploadImgParam param);

    // 获取预设内容
    List<String> getPreset(@Param("type") int type);

    /**
     * 查找用户
     * @param userId
     * @return
     */
    Integer queryUser(@Param("userId") int userId);

    /**
     * 更新推送数量
     * @param userId
     */
    Integer updateUserCount(@Param("userId") int userId);

    /**
     * 增加推送数量
     * @param userId
     * @return
     */
    Integer updatePushCount(@Param("userId") int userId);

    /**
     * 24小时没有推送更新一次时间
     * @param userId
     * @return
     */
    Integer updatePushTime(@Param("userId") int userId);

    /**
     * 添加发布内容
     * @param userId
     * @return
     */
    Integer addUser(@Param("userId") int userId);

    /**
     * 获取推送列表
     * @return
     */
    List<CommonPushResp> getPushList();

    /**
     * 获取最新版本号
     * @return
     */
    List<GetLastVersionResp> getLastVersion();

    /**
     * 用户添加反馈
     * @param param
     * @return
     */
    Integer addUserFeedBack(@Param("param") UserFeedBackParam param);

    /* 获取黑名单 */
    List<Integer> getBLacklist(Integer userId);
}
