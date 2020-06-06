package com.zeroing.utils;

import java.util.Date;
import java.util.UUID;

/**
 * Author :lindec
 * Email  :lindec@163.com
 * Create : 2017/10/27 Created with Intellij IDEA.
 * Description:
 */
public class UUIDUtil {


    private static final String[] CHARS = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private static final String[] DIGIT = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] ODD = new String[]{"1", "3", "5", "7", "9"};
    private static final String[] EVEN = new String[]{"0", "2", "4", "6", "8"};


    public static UUIDUtil instance() {
        return new UUIDUtil();
    }

    /**
     * 常规uuid
     *
     * @return String
     */
    public String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public String generateUUID(int len) {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < len; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(CHARS[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    /**
     * 8位短uuid
     *
     * @return String
     */
    public String generateShort8UUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(CHARS[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    /**
     * 获得奇数数
     * @param head
     * @param len
     * @return
     */
    public String getOdd(String head, int len) {
        StringBuffer shortBuffer = new StringBuffer();
        shortBuffer.append(head);
        int a[] = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = (int) (5 * (Math.random()));
            shortBuffer.append(ODD[a[i] % 5]);
        }
        return shortBuffer.toString();
    }

    /**
     * 获得偶数
     * @param head
     * @param len
     * @return
     */
    public String getEven(String head, int len) {
        StringBuffer shortBuffer = new StringBuffer();
        shortBuffer.append(head);
        int a[] = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = (int) (5 * (Math.random()));
            shortBuffer.append(EVEN[a[i] % 5]);
        }
        return shortBuffer.toString();
    }
    /**
     * 获得随机数
     *
     * @param head 随机数固定头部
     * @param len  随机数长度  =   头部长度 +len
     * @return
     */
    public String getRrandom(String head, int len) {
        StringBuffer shortBuffer = new StringBuffer();
        shortBuffer.append(head);
        int a[] = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = (int) (10 * (Math.random()));
            shortBuffer.append(DIGIT[a[i] % 10]);
        }
        return shortBuffer.toString();
    }

    /**
     * 获得10位随机数
     *
     * @param head 随机数固定头部
     * @return
     */
    public String getRrandom10(String head) {
        StringBuffer shortBuffer = new StringBuffer();
        int a[] = new int[2];
        for (int i = 0; i < 2; i++) {
            a[i] = (int) (10 * (Math.random()));
            shortBuffer.append(DIGIT[a[i] % 10]);
        }
        return head + shortBuffer.toString() + String.valueOf(new Date().getTime()).substring(6);
    }

    public String getRrandom32() {
        return getRrandom10(getRrandom10(getRrandom10(getRrandom("", 2))));
    }


    /**
     * 生成32位的UUid，
     *
     * @return
     */
    public String generate32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

//
//    public static void main(String[] args) {
//        JSONObject data = new JSONObject();
//        //JSONObject info = new JSONObject();
//
//
////        data.put(WxConstants.MessageTemplate.UNIFIED.FIRST,"dfsa");
//
//        JSONObject info = new JSONObject();
////        info.put("value","您好,收到一个新订单请及时处理");
////        data.put(WxConstants.MessageTemplate.UNIFIED.FIRST,(new JSONObject()).put("value","sdfa1111"));
////        info.remove("value");
////        info.put("value","ssss");
////        data.put(WxConstants.MessageTemplate.UNIFIED.KEY1,info);
////        info.remove("value");
////        info.put("value","sssssafdsa");
////        data.put(WxConstants.MessageTemplate.UNIFIED.KEY2,info);
////
//
//        data.put(WxConstants.MessageTemplate.UNIFIED.KEY3,(new Map<String,String>).put("value","lindec"));
//        data.put(WxConstants.MessageTemplate.UNIFIED.KEY4,(new JSONObject()).put("value","123"));
//        data.put(WxConstants.MessageTemplate.UNIFIED.KEY5,(new JSONObject()).put("value","sdfa"));
//        data.put(WxConstants.MessageTemplate.UNIFIED.REMARK,(new JSONObject()).put("value","点击这里查看处理详细订单"));
//
//        //data.put("data",info);
//
//        System.out.println("=======wxUnifiedMessage====="+ JSON.toJSONString(data));
//    }


}
