package com.quwan.beebee.utils;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.exception.ErrorCode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anson on 2017/11/22.
 */
public class JsonUtil {

    /**
     * 用于签名验证输出
     * @param response
     * @param errorCode
     * @throws IOException
     */
    public static void outputJson(HttpServletResponse response, ErrorCode errorCode)
            throws IOException {
        Result result = Result.response(errorCode);
        String jsonResult = JSON.toJSONString(result);
        response.setContentType("text/html;charset=utf8");
        response.getWriter().print(jsonResult);
    }

}
