package com.zeroing.utils;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * Created by lindec on 2016/3/7.
 */
public class ConversionUtil {
    //private static final Logger logger = LoggerFactory.getLogger(gudi.baseprj.cocofei.utils.ConversionUtil.class);

    public static ConversionUtil getInstance() {
        return new ConversionUtil();
    }


    /**
     * byte[] ->int
     *
     * @param bytes
     * @param len   bytes长度
     * @return byte[] bytes = {0x01,0x02} -> 0x0102 (int类)
     */
    public int bytes2int(byte[] bytes, int len) {
        if (len == 2) {
            return (((bytes[0] >= 0 ? bytes[0] : 256 + bytes[0]) & 0x00ff) << 8) +
                    (bytes[1] >= 0 ? bytes[1] : 256 + bytes[1]);
        }
        if (len == 4) {
            return (((bytes[0] >= 0 ? bytes[0] : 256 + bytes[0]) & 0x000000ff) << 24) +
                    (((bytes[1] >= 0 ? bytes[1] : 256 + bytes[1]) & 0x000000ff) << 16) +
                    (((bytes[2] >= 0 ? bytes[2] : 256 + bytes[2]) & 0x000000ff) << 8) +
                    ((bytes[3] >= 0 ? bytes[3] : 256 + bytes[3]) & 0x000000ff);
        }
        return 0;
    }

    /**
     * byte[] ->int[]
     *
     * @param bytes
     * @param len
     * @return
     */
    public int[] bytes2array(byte[] bytes, int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = (bytes[i] >= 0 ? bytes[i] : 256 + bytes[i]);
        }
        return array;
    }

    /**
     * Btye 转换成 Str
     *
     * @param b    byte
     * @param flag true ：表示输出如0x03->03 ;false:表示输出0x03->3
     * @return Str
     */
    public String byte2Str(byte b, boolean flag) {
        String stmp = Integer.toHexString(b & 0xFF);
        if (!flag) {
            return stmp;
        } else {
            StringBuilder sb = new StringBuilder("");
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
            stmp = sb.toString();
            return stmp.toUpperCase().trim();
        }


    }

    /**
     * bytes转换成十六进制字符串
     *
     * @param b byte数组
     * @return String 每个Byte值之间空格分隔(可以更加需求更改)  {0x01,0x02} -> "01 02"
     */
    public String byte2HexStr(byte[] b, boolean flag) {
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
            if (flag) {
                sb.append(" ");
            }
        }
        return sb.toString().toUpperCase().trim();
    }

    /**
     * ints转换成十六进制字符串
     *
     * @param b byte数组
     * @return String 每个int值之间空格分隔(可以更加需求更改)  {0x01,0x02} -> "01 02"
     */
    public String ints2HexStr(int[] b) {
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n]);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
            //sb.append(" ");
        }
        return sb.toString().toUpperCase().trim();
    }

    /**
     * ints转换成字符串
     *
     * @param b byte数组
     * @return String 每个int值之间空格分隔(可以更加需求更改)  {0x01,0x02,0x33} -> "1233"
     */
    public String ints2Str(int[] b) {
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < b.length; n++) {
            String stmp = Integer.toString(b[n]);
            sb.append(stmp);
        }
        return sb.toString().toUpperCase().trim();
    }

    /**
     * 字符串转成数组
     * @param str  String srt = "12305"-> {1,2,3,0,5}
     * @return
     */
    public int[] str2ints(String str) {
        int len = str.length();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.parseInt(str.substring(i,i+1));
        }
        return array;
    }

//    public static void main(String[] args) {
////        int[] ss = new int[]{11,01,3,0};
////        System.out.println(ConversionUtil.getInstance().ints2Str(ss));
//
////        String ss = "102345";
////        int[] array = ConversionUtil.getInstance().str2ints(ss);
////        for(int i = 0; i < array.length; i++){
////            System.out.println(array[i]);
////        }
//
//    }

    /**
     * bytes字符串转换为Byte值
     *
     * @param string Byte字符串，每个Byte之间没有分隔符发
     * @param flag   true：允许超过7f（127） false：不允许允许超过7f（127），如：80就会有错误
     * @return byte[]    "020a7f" -> {0x02,0x0a,0x7f}
     */
    public byte[] hexStr2Bytes(String string, boolean flag) {
        int l;
        String str = string;
        if (str.length() % 2 == 0) {
            l = str.length() / 2;
        } else {
            l = (str.length() / 2) + 1;
            str = "0" + str;
        }
        byte[] ret = new byte[l];

        if (flag) {
            for (int i = 0; i < l; i++) {
                int temp = Integer.decode("0x" + str.substring(i * 2, i * 2 + 1) + str.substring(i * 2 + 1, i * 2 + 2));
                ret[i] = (byte) temp;
            }
        } else {
            for (int i = 0; i < l; i++) {
                ret[i] = Byte.decode("0x" + str.substring(i * 2, i * 2 + 1) + str.substring(i * 2 + 1, i * 2 + 2));
            }
        }

        return ret;
    }

    /**
     * String的字符串转换成unicode的String
     *
     * @param strText 全角字符串
     * @return String 每个unicode之间无分隔符 如："我是天才" -> "\u6211\u662f\u5929\u624d"
     * @throws Exception
     */
    public String strToUnicode(String strText)
            throws Exception {
        char c;
        StringBuilder str = new StringBuilder();
        int intAsc;
        String strHex;
        for (int i = 0; i < strText.length(); i++) {
            c = strText.charAt(i);
            intAsc = (int) c;
            strHex = Integer.toHexString(intAsc);
            if (intAsc > 128)
                str.append("\\u" + strHex);
            else // 低位在前面补00
                str.append("\\u00" + strHex);
        }
        return str.toString();
    }

    /**
     * unicode的String转换成String的字符串
     *
     * @param hex 16进制值字符串 （一个unicode为2byte）
     * @return String 全角字符串 如："\\u6211\\u662f\\u5929\\u624d" -> "我是天才"
     */
    public String unicodeToString(String hex) {
        int t = hex.length() / 6;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = hex.substring(i * 6, (i + 1) * 6);
            // 高位需要补上00再转
            String s1 = s.substring(2, 4) + "00";
            // 低位直接转
            String s2 = s.substring(4);
            // 将16进制的string转为int
            int n = Integer.valueOf(s1, 16) + Integer.valueOf(s2, 16);
            // 将int转换为字符
            char[] chars = Character.toChars(n);
            str.append(new String(chars));
        }
        return str.toString();
    }

//    public byte[] str2ascii(String str) {
//        byte[] as = new byte[str.length()];
//        as= str.getBytes();
//        return as;
//    }


}