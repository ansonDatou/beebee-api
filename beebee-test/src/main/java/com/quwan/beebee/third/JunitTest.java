package com.quwan.beebee.third;

import com.quwan.beebee.HttpPostService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Third模块
 */
public class JunitTest {

    private static final String PORT = "8721";

    /**
     * 文本检测
     */
    @Test
    public void checkText() {
        Map<String, String> param = new HashMap<>();
        param.put("userId", "64");
        param.put("content", "百度一下");
        HttpPostService.testService(param, PORT, "/third/checkText");
    }

    /**
     * 图片检测
     */
    @Test
    public void checkImage() {
        Map<String, String> param = new HashMap<>();
        param.put("url", "[http://img.beebee.com/upload/482017120417112817688b84feeb200783cec2d6c4abbdf7.jpg]");
        HttpPostService.testService(param, PORT, "/third/checkImage");
    }

}
