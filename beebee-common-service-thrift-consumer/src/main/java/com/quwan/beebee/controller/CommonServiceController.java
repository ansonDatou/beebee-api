package com.quwan.beebee.controller;

import com.quwan.beebee.common.Method;
import com.quwan.beebee.common.Server;
import com.quwan.beebee.param.common.*;
import com.quwan.beebee.utils.EurekaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anson on 2017/10/9.
 * 公共模块
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/common")
public class CommonServiceController {

    @Autowired
    private EurekaUtil eurekaUtil;

    /**
     * 获取banner
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/getBanner")
    public String getBanner(GetBannerParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_COMMON_SERVICE_THRIFT_PROVIDER_CLIENT, Method.COMMON_GET_BANNER, param);
    }

    /**
     * 上传图片
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/uploadImg")
    public String uploadImg(UploadImgParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_COMMON_SERVICE_THRIFT_PROVIDER_CLIENT, Method.COMMON_UPLOAD_IMG, param);
    }

    /**
     * 获取七牛token
     * 于浩
     * @param param
     * @return
     */
    @PostMapping("/getUploadToken")
    public String getUploadToken(UploadImgParam param) {return eurekaUtil.remoteInvoke(Server.BEEBEE_COMMON_SERVICE_THRIFT_PROVIDER_CLIENT, Method.COMMON_GET_UPLOAD_TOKEN, param);}

    /**
     * @Title: getPreset
     * @Description: 获取预设
     * @return String    返回类型
     * @author 李静
     */
    @PostMapping("/getPreset")
    public String getPreset(Integer type) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_COMMON_SERVICE_THRIFT_PROVIDER_CLIENT, Method.COMMON_GET_PRESET, type);
    }

    /**
     * 获取最新版本号
     * @return
     */
    @PostMapping("/getLastVersion")
    public String getLastVersion() {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_COMMON_SERVICE_THRIFT_PROVIDER_CLIENT, Method.COMMON_LAST_VERSION, StringUtils.EMPTY);
    }

    /**
     * 添加用户反馈
     * @param param
     * @return
     */
    @PostMapping("/addUserFeedBack")
    public String addUserFeedBack(UserFeedBackParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_COMMON_SERVICE_THRIFT_PROVIDER_CLIENT, Method.COMMON_FEED_BACK, param);
    }

}
