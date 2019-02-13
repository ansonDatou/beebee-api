package com.quwan.beebee.filter;


import javax.servlet.*;
import java.io.IOException;


public class SignVerifyCommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

//        // 1 获取请求的参数
//        Enumeration<String> enu = request.getParameterNames();
//        Map<String, String> params = new HashMap<String, String>();
//        String sign = null;
//        while (enu.hasMoreElements()) {
//            String key = enu.nextElement();
//            if ("sign".equals(key)) {
//                sign = request.getParameter("sign");
//            } else {
//                params.put(key, request.getParameter(key));
//            }
//        }
//
//        // 2 校验公共参数是否为空
//        if (sign == null || !params.containsKey("timestamp")) {
//            JsonUtil.outputJson((HttpServletResponse)resp, ErrorCode.ParameterMissing);
//            return ;
//        }
//
//        // 3 验证签名
//        if (sign.length() != 32 && !SecurityUtil.checkSign(params, sign)) {
//            JsonUtil.outputJson((HttpServletResponse)resp, ErrorCode.SignFail);
//            return;
//        }
//
//        // 4 验证时间戳
//        String timestamp = params.get("timestamp");
//        long currentTime = System.currentTimeMillis();
//        long diff = currentTime - Long.valueOf(timestamp);
//        if (diff > DateUtils.MILLIS_PER_MINUTE) {
//            JsonUtil.outputJson((HttpServletResponse)resp, ErrorCode.RequestTimeout);
//            return;
//        }

        System.out.println("签名验证");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}