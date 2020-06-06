package com.zeroing.utils;

import java.net.URLEncoder;

/**
 * Author :lindec
 * Email  :lindec@163.com
 * Create : 2017/11/9 Created with Intellij IDEA.
 * Description:
 */
public class EnodeUtil {
    public static String urlEnodeUTF8(String str) {
        String result = str;
        try {
            result = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
