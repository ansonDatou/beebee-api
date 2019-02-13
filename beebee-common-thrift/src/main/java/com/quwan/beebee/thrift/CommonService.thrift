namespace java com.quwan.beebee.service.common

include "CommonParam.thrift"

// 公共服务类
service CommonService {

    // 获取banner-陈晓婵-2017年12月24日15:04:18
    string getBanner(1: required CommonParam.GetBannerParam param);

	// 上传图片-陈晓婵-2017年12月25日11:15:00
	string uploadImg(1: required CommonParam.UploadImgParam param);
	
    // 获取七牛token-于浩-2018年1月12日14：28
    string getUploadToken(1: required CommonParam.UploadImgParam param);

    // 获取预设内容
    string getPreset(1: required i32 param);

    // 获取版本号
    string getLastVersion();

    // 添加用户反馈
    string addUserFeedBack(1: required CommonParam.UserFeedBackParam param);
}