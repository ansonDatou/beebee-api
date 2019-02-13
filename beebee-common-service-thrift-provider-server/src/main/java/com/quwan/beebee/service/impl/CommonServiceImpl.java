package com.quwan.beebee.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.*;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.quwan.beebee.dao.CommonDao;
import com.quwan.beebee.exception.ErrorCode;
import com.quwan.beebee.param.common.*;
import com.quwan.beebee.resp.common.GetBannerResp;
import com.quwan.beebee.resp.common.GetLastVersionResp;
import com.quwan.beebee.service.common.CommonService;
import com.quwan.beebee.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * common-service 模块
 */
@Service("commonServiceImpl")
@Transactional
public class CommonServiceImpl implements CommonService.Iface {

    @Autowired
    public CommonDao commonDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

    /**
     * 获取banner-陈晓婵-2017年12月24日15:25:44
     */
    @Override
    public String getBanner(GetBannerParam param) throws TException {
        try {
            List<GetBannerResp> banner = commonDao.getBanner(param);
            Result okObject = Result.okObject(banner);
            return JSON.toJSONString(okObject);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.CommonServiceImpl getBanner error", e);
            return JSON.toJSONString(Result.error());
        }
    }

    /**
     * 获取七牛token
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String getUploadToken(UploadImgParam param) throws TException {
        // 生成上传凭证，然后准备上传
        String accessKey = "0h0ZKun_1BAo7no3YZ5JkgbagAVYrwB1SVZq-ob4";
        String secretKey = "U8LBRaWgMPuyr2KFj6IBBDz79Sp3lF1Xumq30GQV";
        String bucket = "beebee-test";

//        String localFilePath = param.getData();
        Auth auth = Auth.create(accessKey, secretKey);
        try {
            String upToken = auth.uploadToken(bucket);
            Result okObject = Result.okObject(upToken);
            return JSON.toJSONString(okObject);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.CommonServiceImpl getUploadToken error", e);
            return JSON.toJSONString(Result.error());
        }
    }

    /**
     * 上传图片
     * 陈晓婵
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String uploadImg(UploadImgParam param) throws TException {

        // 构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());

        // 其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        // 生成上传凭证，然后准备上传
        String accessKey = "0h0ZKun_1BAo7no3YZ5JkgbagAVYrwB1SVZq-ob4";
        String secretKey = "U8LBRaWgMPuyr2KFj6IBBDz79Sp3lF1Xumq30GQV";
        String bucket = "beebee-test";

        // 如果是Windows情况下，格式是 D:\\qiniu\\test.png
        // String localFilePath = "/home/qiniu/test.png";
        String localFilePath = param.getData();

        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = StringUtils.EMPTY;
        // key值为userId_+时间戳
        // 时间戳
        long time = System.currentTimeMillis();
        key = "uploadImg_" + param.getUserId() + "_" + time;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            String putRetKey = putRet.key;
            // 存到图片表中
            param.setData(putRetKey);
            Integer uploadImg = commonDao.uploadImg(param);
            Result okObject = Result.okObject(putRetKey);
            return JSON.toJSONString(okObject);
        } catch (QiniuException ex) {
            Response r = ex.response;
            LOGGER.error("com.quwan.beebee.service.impl.CommonServiceImpl uploadImg error", r.toString());
            return JSON.toJSONString(Result.error());
        }
    }

	@Override
	public String getPreset(int param) throws TException {
		try {
			String content = "";
			List<String> contents = commonDao.getPreset(param);
			if(contents.size()>0){
				content = contents.get(0);
			}
			Result okObject = Result.okObject(JSONArray.parseArray(content));
			return JSON.toJSONString(okObject);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.CommonServiceImpl getPreset error", e);
            return JSON.toJSONString(Result.error());
        }
	}

    @Override
    public String getLastVersion() throws TException {

        try {
            List<GetLastVersionResp> respList = commonDao.getLastVersion();
            if(respList == null){
                return JSON.toJSONString(Result.response(ErrorCode.ParameterMissing));
            }

            GetLastVersionResp resp = respList.get(0);
            if(resp == null){
                return JSON.toJSONString(Result.response(ErrorCode.ParameterMissing));
            }

            Result okObject = Result.okObject(resp);
            return JSON.toJSONString(okObject);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.CommonServiceImpl getLastVersion error", e);
            return JSON.toJSONString(Result.error());
        }
    }

    /**
     * 添加用户反馈
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String addUserFeedBack(UserFeedBackParam param) throws TException {
        int num = 0;
        try {

            num = commonDao.addUserFeedBack(param);
            if(num <= 0){
                return JSON.toJSONString(Result.response(ErrorCode.ParameterMissing));
            }

            Result okObject = Result.okObject(num);
            return JSON.toJSONString(okObject);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.CommonServiceImpl addUserFeedBack error", e);
            return JSON.toJSONString(Result.error());
        }

    }

}
