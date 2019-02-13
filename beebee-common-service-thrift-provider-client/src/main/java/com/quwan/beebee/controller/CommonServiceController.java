package com.quwan.beebee.controller;

import com.quwan.beebee.param.common.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quwan.beebee.utils.ThriftUtil;

/**
 * Created by anson on 2017/10/9.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/common")
public class CommonServiceController {

    @Autowired
    private ThriftUtil thriftUtil;

    /**
     * 获取banner
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/getBanner")
    public String getBanner(@RequestBody GetBannerParam param) {
        return thriftUtil.remoteInvoke("getBanner", param);
    }

    /**
     * 上传图片
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/uploadImg")
    public String uploadImg(@RequestBody UploadImgParam param) {
        return thriftUtil.remoteInvoke("uploadImg", param);
    }

    /**
     * 获取七牛token
     * 于浩
     * @param param
     * @return
     */
    @PostMapping("/getUploadToken")
    public String getUploadToken(@RequestBody UploadImgParam param) {return thriftUtil.remoteInvoke ("getUploadToken", param);}

    /**
    * @Title: getPreset
    * @Description: 获取预设
    * @param type
    * @return String    返回类型
    * @author 李静
     */
    @PostMapping("/getPreset")
    public String getPreset(@RequestBody Integer type) {
    	return thriftUtil.remoteInvoke ("getPreset", type);
    }

    /**
     * 获取最新版本号
     * @return
     */
    @PostMapping("getLastVersion")
    public String getLastVersion() { return thriftUtil.remoteInvoke("getLastVersion", StringUtils.EMPTY);}

    /**
     * 添加用户反馈
     * @param param
     * @return
     */
    @PostMapping("/addUserFeedBack")
    public String addUserFeedBack(@RequestBody UserFeedBackParam param) {
        return thriftUtil.remoteInvoke("addUserFeedBack",param);
    }
}
