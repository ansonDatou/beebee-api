package com.quwan.beebee.controller;

import com.quwan.beebee.param.common.GetBannerParam;
import com.quwan.beebee.param.common.UploadImgParam;
import com.quwan.beebee.param.third.AuthcodeParam;
import com.quwan.beebee.param.third.CheckImageParam;
import com.quwan.beebee.param.third.CheckTextParam;
import com.quwan.beebee.param.third.SendMsgParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/third")
public class ThirdController {

    @Autowired
    private ThriftUtil thriftUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdController.class);

    /**
     * 发送验证码
     * @param param
     * @return
     */
    @PostMapping("/sendAuthcode")
    public String sendAuthcode(@RequestBody AuthcodeParam param) {
        return thriftUtil.remoteInvoke("sendAuthcode", param);
    }

    /**
     * 文本检测
     * 何飞达
     * @param param
     * @return
     */
    @PostMapping("/checkText")
    public String checkText(@RequestBody CheckTextParam param) {
        return thriftUtil.remoteInvoke("checkText", param);
    }

    /**
     * 图片检测
     * 何飞达
     * @param param
     * @return
     */
    @PostMapping("/checkImage")
    public String checkImage(@RequestBody CheckImageParam param) { return thriftUtil.remoteInvoke("checkImage", param);}

    /**
     * 短信下发
     * 于浩
     * @param param
     * @return
     */
    @PostMapping("/sendMsg")
    public String sendMsg(@RequestBody SendMsgParam param) {
        return thriftUtil.remoteInvoke("sendMsg", param);
    }

}
