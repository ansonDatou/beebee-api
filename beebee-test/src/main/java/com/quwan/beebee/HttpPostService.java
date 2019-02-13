
package com.quwan.beebee;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;


public class HttpPostService {

    // 服务器地址
//    private static final String URL = "http://localhost:";

    // 测试服务器地址
//    private static final String URL = "http://47.94.23.204";

    // 测试服务器地址
//    private static final String URL = "https://apitest.anson-zhifu.cn:";

    // 正式服务器地址
//    private static final String URL = "https://apiwin.tiantdu.cn";

    // 测试服务器地址
    private static final String URL = "https://api.anson-zhifu.cn";

    public static void testService(Map<String, String> param, String port, String uri) {
//        String sign = getSign(param);
//        param.put("sign", sign);
        HttpClient client = new HttpClient();
        client.getParams().setContentCharset("UTF-8");
        PostMethod method = null;
        if (URL.contains("apiwin.tiantdu.cn") || URL.contains("api.anson-zhifu.cn") || URL.contains("47.94.23.204")) {
            method = new PostMethod(URL + uri);
            System.err.println("URL: " + URL + uri);
        } else {
            method = new PostMethod(URL + port + uri);
            System.err.println("URL: " + URL + port + uri);
        }

        Iterator<Entry<String, String>> it = param.entrySet().iterator();

        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            method.addParameter(entry.getKey(), entry.getValue());
            System.err.println("参数: " + entry.getKey() + ":" + entry.getValue());
        }

        try {
            client.executeMethod(method);
            String response = method.getResponseBodyAsString().trim();
            System.err.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取签名
     *
     * @param param
     * @return
     */
    public static String getSign(Map<String, String> param) {
        try {
            if (param == null) {
                return "";
            }
            List<String> list = new ArrayList<String>();
            Set<String> keySet = param.keySet();
            for (String string : keySet) {
                if (!keySet.equals("avatar")) {
                    list.add(string);
                }
            }
            Collections.sort(list);
            String string = new String();
            for (int i = 0; i < list.size(); i++) {
                string += (list.get(i) + "=" + param.get(list.get(i)) + "&");
            }
            if (string.length() > 0 && '&' == string.charAt(string.length() - 1)) {
                string = string.substring(0, string.length() - 1);
            }
            string = MD5(string);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 对目标字符串进行MD5加密
     * @param source
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws Exception
     */
    public static String MD5(String source) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String resultHash = null;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] result = new byte[md5.getDigestLength()];
        md5.reset();
        md5.update(source.getBytes("UTF-8"));
        result = md5.digest();

        StringBuffer buf = new StringBuffer(result.length * 2);

        for (int i = 0; i < result.length; i++) {
            int intVal = result[i] & 0xff;
            if (intVal < 0x10) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(intVal));
        }

        resultHash = buf.toString();

        return resultHash.toString();

    }

    /**
     * 设置公共参数
     *
     * @param params
     */
    public static void setCommonParams(Map<String, String> params) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        params.put("imei", "");
        params.put("imsi", "");
        params.put("phone", "18773168550");
        params.put("os_version", "v4.0.0");
        params.put("platform", "ios");
        params.put("app_version", "v1.0.0");
        params.put("request_time", fmt.format(new Date()));
        params.put("tokenKey", "F957BCAA4DCA44F1BF1CEEB9CDFAD2FC5A4");
        params.put("client_type", "s");
    }


}