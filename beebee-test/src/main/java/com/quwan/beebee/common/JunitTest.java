
package com.quwan.beebee.common;

import com.quwan.beebee.HttpPostService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试common模块
 */
public class JunitTest {

    private static final String PORT = "9721";

    /**
     * 发送验证码
     */
    @Test
    public void sendAuthcode() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", "13132900244");
        param.put("type", "2");
        HttpPostService.testService(param, PORT, "/common/sendAuthcode");
    }

    /**
     * 检查验证码是否被使用过
     */
    @Test
    public void checkAuthcode() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", "13132900244");
        param.put("type", "2");
        HttpPostService.testService(param, PORT, "/common/checkAuthcode");
    }

    /**
     * 修改验证码状态
     */
    @Test
    public void updateAuthcodeStatus() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", "13132900244");
        param.put("type", "2");
        HttpPostService.testService(param, PORT, "/common/updateAuthcodeStatus");
    }

    /**
     * 获取banner
     */
    @Test
    public void getBanner() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("block", "2");
        param.put("classify", "首页");
        param.put("type", "2");
        HttpPostService.testService(param, PORT, "/third/getBanner");
    }

    /**
     * 上传图片
     */
    @Test
    public void uploadImg() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("data", "/tmp/seven.jpg");
        HttpPostService.testService(param, PORT, "/common/uploadImg");
    }

    /**
     * 获取七牛token
     */
    @Test
    public void getUploadToken(){
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("data", "");
        HttpPostService.testService(param, PORT, "/common/getUploadToken");
    }

    /**
     * 短信下发
     */
    @Test
    public void sendMsg(){
        Map<String, String> param = new HashMap<String, String>();
        param.put ("phone", "13132900244");
        HttpPostService.testService(param, PORT, "/third/sendMsg");
    }
    
    /**
     * 获取预设
     */
    @Test
    public void getPreset(){
    	Map<String, String> param = new HashMap<String, String>();
    	param.put ("type", "1");
    	HttpPostService.testService(param, PORT, "/third/getPreset");
    }


}
