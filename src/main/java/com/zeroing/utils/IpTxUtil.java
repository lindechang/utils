package com.zeroing.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.TreeMap;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 2:39 PM 2018/11/24 Created with Intellij IDEA
 * @Description:腾讯 ip地址查询 webAPI
 */
public class IpTxUtil {

    private static final String ipApiUrl = "https://apis.map.qq.com/ws/location/v1/ip?ip=IP&key=KEY&output=TYPE";

    private static  String map_key;

    public IpTxUtil() {
    }

    public IpTxUtil(String key) {
        this.map_key = key;
    }


    public static String getIpInfo(String ip) {
//        Map<String,String> param = new TreeMap<>();
//        param.put("ip",ip);//IP地址，缺省时会使用请求端的IP
//        param.put("key",KEY);//开发密钥（Key）
//        param.put("output","json");//返回格式：支持JSON/JSONP，默认JSON
//        //param.put("callback","function1");//JSONP方式回调函数

        String url = ipApiUrl.replace("IP", ip);
        url = url.replace("KEY", map_key);
        url = url.replace("TYPE", "json");
        return HttpUtil.httpConnect(
                url, "", new TreeMap<String,String>(), "GET").toString();
    }

    public static String getResult(String ip) {
        return JSON.parseObject(getIpInfo(ip), JSONObject.class).get("result").toString();
    }

    public static String getCountry(String ip) {
        return JSON.parseObject(JSON.parseObject(getResult(ip)).get("ad_info").toString()).get("nation").toString();
    }
    public static String getProvince(String ip) {
        return JSON.parseObject(JSON.parseObject(getResult(ip)).get("ad_info").toString()).get("province").toString();
    }

    public static String getCity(String ip) {
        return JSON.parseObject(JSON.parseObject(getResult(ip)).get("ad_info").toString()).get("city").toString();
    }


    public static String getDistrict(String ip) {
        return JSON.parseObject(JSON.parseObject(getResult(ip)).get("ad_info").toString()).get("district").toString();
    }

    public static String getAdcode(String ip) {
        return JSON.parseObject(JSON.parseObject(getResult(ip)).get("ad_info").toString()).get("adcode").toString();
    }

    public static String getAddrInfo(String ip) {
        return JSON.parseObject(getResult(ip)).get("ad_info").toString();
    }

    public static String getLocation(String ip) {
        return JSON.parseObject(getResult(ip)).get("location").toString();
    }


//    public static void main(String[] args) {
//        System.out.println("------ip:" + IpWxUtil.getLocation("60.177.123.191"));
//    }


}
