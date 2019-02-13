package com.quwan.beebee.controller;

import com.quwan.beebee.common.Method;
import com.quwan.beebee.common.Server;
import com.quwan.beebee.param.common.*;
import com.quwan.beebee.param.third.AuthcodeParam;
import com.quwan.beebee.param.third.CheckImageParam;
import com.quwan.beebee.param.third.CheckTextParam;
import com.quwan.beebee.param.third.SendMsgParam;
import com.quwan.beebee.utils.EurekaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anson on 2017/10/9.
 * 公共模块
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/third")
public class ThirdController {

    @Autowired
    private EurekaUtil eurekaUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdController.class);

    /**
     * 发送验证码
     * @param param
     * @return
     */
    @PostMapping("/sendAuthcode")
    public String sendAuthcode(AuthcodeParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_THIRD_SERVICE_THRIFT_PROVIDER_CLIENT, Method.THIRD_SEND_AUTHCODE, param);
    }

    /**
     * 文本检测
     * 何飞达
     * @param param
     * @return
     */
    @PostMapping("/checkText")
    public String checkText(CheckTextParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_THIRD_SERVICE_THRIFT_PROVIDER_CLIENT, Method.THIRD_CHECK_TEXT, param);
    }

    /**
     * 图片检测
     * 何飞达
     * @param param
     * @return
     */
    @PostMapping("/checkImage")
    public String checkImage(CheckImageParam param) { return eurekaUtil.remoteInvoke(Server.BEEBEE_THIRD_SERVICE_THRIFT_PROVIDER_CLIENT, Method.THIRD_CHECK_IMAGE, param);
    }

    /**
     * 短信下发
     * 于浩
     * @param param
     * @return
     */
    @PostMapping("/sendMsg")
    public String sendMsg(SendMsgParam param) {
        return eurekaUtil.remoteInvoke (Server.BEEBEE_THIRD_SERVICE_THRIFT_PROVIDER_CLIENT, Method.THIRD_SEND_MSG, param);
    }
}
