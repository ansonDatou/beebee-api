package com.quwan.beebee.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 签名工具类
 *
 * @author anson
 */
public class SecurityUtil {

    /**
     * 验证签名是否正确
     *
     * @param params
     * @param sign
     * @return
     */
    public static boolean checkSign(Map<String, String> params, String sign) {
        boolean isTrue = false;
        if (sign != null && !sign.trim().equals("") && !params.isEmpty()) {
            isTrue = sign.equals(getSign(params));
        }
        return isTrue;
    }

    /**
     * 获取签名
     *
     * @param params
     * @return
     */
    private static String getSign(Map<String, String> params) {
        if (params == null) {
            return StringUtils.EMPTY;
        }
        
        try {
            // 1 将参数加入list并排序
            List<String> list = new ArrayList<String>();
            Set<String> keySet = params.keySet();
            for (String string : keySet) {
                list.add(string);
            }
            Collections.sort(list);
            
            // 2 将排序后的参数拼接为新的字符串
            String string = new String();
            for (int i = 0; i < list.size(); i++) {
                string += (list.get(i) + "=" + params.get(list.get(i)) + "&");
            }
            if (string.length() > 0 && '&' == string.charAt(string.length() - 1)) {
                string = string.substring(0, string.length() - 1);
            }
            
            // 2 将排序后的字符串MD5加密
            string = MD5(string);

            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return StringUtils.EMPTY;
        }
    }

    /**
     * 对目标字符串进行MD5加密
     *
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
}