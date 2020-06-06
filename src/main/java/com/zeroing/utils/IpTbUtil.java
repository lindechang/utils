package com.zeroing.utils;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 2:39 PM 2018/11/24 Created with Intellij IDEA
 * @Description:淘宝ip地址查询api
 */
public class IpTbUtil {

    private static final String ipApiUrl ="http://ip.taobao.com/service/getIpInfo.php?ip=";


    public static String getIpInfo(String ip){
        return HttpUtil.httpConnect(
                ipApiUrl+ip,"",null,"GET").toString();
    }

//    public static String getIpCountry(String ip){
//        return JSON.parseObject(HttpUtil.httpConnect(
//                ipApiUrl+ip,"",null,"GET").toString(), JSONObject.class).get("data");
//    }

//    public static String getIpProvince(String ip){
//        return JSON.parseObject(HttpUtil.httpConnect(
//                ipApiUrl+ip,"",null,"GET").toString(), TbIpInfoVo.class).getData().get("region");
//    }

//    public static String getIpCity(String ip){
//        return JSON.parseObject(HttpUtil.httpConnect(
//                ipApiUrl+ip,"",null,"GET").toString(), TbIpInfoVo.class).getData().get("city");
//    }


//    public static String getIpIsp(String ip){
//        return JSON.parseObject(HttpUtil.httpConnect(
//                ipApiUrl+ip,"",null,"GET").toString(), TbIpInfoVo.class).getData().get("isp");
//    }

//    public static String getIpAddrInfo(String ip){
//        return getIpCountry(ip)+"."+getIpProvince(ip)+"."+getIpCity(ip)+"."+getIpIsp(ip);
//    }


//    public static void main(String[] args) {
//        System.out.println("------ip:"+ IpTbUtil.getIpInfo("60.177.123.191"));
//    }


}
