package com.zeroing.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;


/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 6:05 PM 2019/7/30 Created with Intellij IDEA
 * @Description: 阿里云短信服务
 */
public class AliSmsUtil {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private final static String SEND_SERVER = "dysmsapi.aliyuncs.com";

    private static IAcsClient client;

    public AliSmsUtil() {
    }

    public AliSmsUtil(String regionId, String keyId, String keySecret) {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, keyId, keySecret);
        this.client = new DefaultAcsClient(profile);
    }

    public static AliSmsUtil instance() {
        return new AliSmsUtil();
    }

    /**
     *
     * @param PhoneNum 发送的手机号
     * @param signName 签名名称
     * @param template 模块名称
     * @param param    验证码随机数
     * @return
     */
    public static Boolean sendSmsCode(String PhoneNum,String signName,String template, String param) {
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(SEND_SERVER);
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", PhoneNum);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", template);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + param + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            JSONObject result = JSON.parseObject(response.getData());
            System.out.println(response.getData());
            if (result.get("Message").equals("OK")) {
                return true;
            }
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) {
//        AliSmsUtil aliSmsUtil = new AliSmsUtil("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
//        System.out.println("==========ss=====：" + aliSmsUtil.sendSmsCode("15757183605",SIGN_NAMEN,CFZ_CODE, "23421"));
//    }


}
