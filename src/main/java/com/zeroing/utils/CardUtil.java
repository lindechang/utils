package com.zeroing.utils;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 4:53 下午 2019/12/24 Created with Intellij IDEA
 * @Description: 卡牌工具
 */
public class CardUtil {

    private final static String[] CheckNum = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

//    public static void main(String[] args) {
//        System.out.println(getIdCard("12345678901234567"));
//        System.out.println(checkCardCrc("123456789012345677"));
//        System.out.println(checkCardCrc("123456789012345679"));
//    }

    /**
     * 根据前17位 生成 18位身份证号
     *
     * @param IdNumStr17
     * @return
     */
    public static String getIdCard(String IdNumStr17) {
        String id = IdNumStr17;
        int len = id.length();
        if (len < 17) {
            return "";
        }
        int[] IdNum = new int[17];
        for (int i = 0; i < 17; i++) {
            IdNum[i] = Integer.parseInt(id.substring(i, i + 1));
        }
        String crc = getIdCardCrc(IdNum);
        return id.substring(0, 17) + crc;
    }

    /**
     * 生成校验位
     *
     * @return
     */
    public static String getIdCardCrc(int[] IdNum) {
        if (IdNum.length != 17) {
            return "";
        }
        //String[] CheckNum = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        int Sum = IdNum[0] * 7 + IdNum[1] * 9 + IdNum[2] * 10 + IdNum[3] * 5 + IdNum[4] * 8 + IdNum[5] * 4 + IdNum[6] * 2 + IdNum[7] * 1 + IdNum[8] * 6
                + IdNum[9] * 3 + IdNum[10] * 7 + IdNum[11] * 9 + IdNum[12] * 10 + IdNum[13] * 5 + IdNum[14] * 8 + IdNum[15] * 4 + IdNum[16] * 2;
        return CheckNum[Sum % 11];
    }

    /**
     * 校验卡牌id是否符合规则
     * @param idCard 18位卡牌id
     * @return
     */
    public static Boolean checkCardCrc(String idCard) {
        int[] IdNum17 = new int[17];
        if (idCard.length() != 18) {
            return false;
        }
        try {
            IdNum17 = ConversionUtil.getInstance().str2ints(idCard.substring(0, 17));
        } catch (Exception e) {
            return false;
        }
        String IdNumStr18 = idCard.substring(17, 18);
        String crc = getIdCardCrc(IdNum17);
        return IdNumStr18.equals(crc);
    }


}
