package com.zeroing.utils;

import java.util.Base64;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 2:05 PM 2018/12/24 Created with Intellij IDEA
 * @Description:
 */
public class Base64Util {
    /**
     * BASE64解密 * @param key * @return * @throws Exception
     */
//    public static byte[] decryptBASE64(String  key) throws Exception {
//        //return (new Base64()).decode(key);
//        byte[] bt = null;
//        try {
//            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
//            bt = decoder.decodeBuffer(key);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bt;
//
//    }

    /**
     * BASE64加密 * @param key * @return * @throws Exception
     * 编码
     */
//    public static String encryptBASE64(byte[] key) throws Exception {
//        //return (new Base64()).encode(key);
//        return new sun.misc.BASE64Encoder().encode(key);
//    }


    /**
     *加密
     */
    public static String encode(byte[] key) throws Exception {
        return Base64.getEncoder().encodeToString(key);
    }
    /**
     *解密
     */
    public static byte[] decode(String  key) throws Exception {
        return Base64.getDecoder().decode(key);
    }
}
