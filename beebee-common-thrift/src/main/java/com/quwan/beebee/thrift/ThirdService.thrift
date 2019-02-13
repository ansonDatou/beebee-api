namespace java com.quwan.beebee.service.third

include "ThirdParam.thrift"

// 第三方服务类
service ThirdService {

    // 发送验证码
    string sendAuthcode(1: required ThirdParam.AuthcodeParam param);

    // 文本检测-何飞达-2018年1月9日20：28
    string checkText(1: required ThirdParam.CheckTextParam param);

    // 图片检测-何飞达-2018年1月10日13：28
    string checkImage(1: required ThirdParam.CheckImageParam param);

    // 短信下发-于浩-2018年1月15日18：53
    string sendMsg(1: required ThirdParam.SendMsgParam param);
     
}