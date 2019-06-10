package com.ash.workorder.utils;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;

/**
 * @Created by Ash on 2018/12/26 14:29
 * 使用固定slat进行加密
 */
public class MD5Utils {
    private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public static String encode(String origin, String charsetName) {
        String resultStr = null;
        try {
            resultStr = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (StringUtils.isBlank(charsetName)) {
                resultStr = byteArrayToHexString(md.digest(resultStr.getBytes()));
            } else {
                resultStr = byteArrayToHexString(md.digest(resultStr.getBytes(charsetName)));
            }
        } catch (Exception e) {

        }
        return resultStr;
    }

    private static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }
}
