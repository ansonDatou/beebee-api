package com.quwan.beebee.utils;

import java.security.MessageDigest;

/**
 * Created by anson on 2017/11/10.
 */
public class MD5 {

    public static String encrypt(String str) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = str.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char cs[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                cs[k++] = hexDigits[byte0 >>> 4 & 0xf];
                cs[k++] = hexDigits[byte0 & 0xf];
            }

            return new String(cs);
        } catch (Exception e) {
            return null;
        }
    }
}
