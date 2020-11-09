package cn.htl.web.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    //
    public static String stringToMD5(String plainText) {//参1 明文
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());//对明文的字节进行摘要
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        //16或者32
        String md5code = new BigInteger(1, secretBytes).toString(16);

        //补0 一个字节转两位的16进制
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}

