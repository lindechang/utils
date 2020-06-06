package com.zeroing.utils;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 6:05 PM 2019/7/30 Created with Intellij IDEA
 * @Description:
 */
public class AliOSSUtil {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private final static String HZ_ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";
    private final static String ACCESS_KEY_ID = "";
    private final static String ACCESS_KEY_SECRET = "";
    //用户存储公共空间
    private static String BUCKET_NAME = "";
    //用户存储私有空间
    private static String PRIVSTE_BUCKET_NAME = "";

    private static OSS ossClient;

    public AliOSSUtil() {
    }

    public AliOSSUtil(String endpoint, String accessKeyId, String accessKeySecret, String buckerName) {
        this.ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        this.BUCKET_NAME = buckerName;
    }

    public AliOSSUtil(String endpoint, String accessKeyId, String accessKeySecret, String buckerName, String privateBuckerName) {
        this.ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        this.BUCKET_NAME = buckerName;
        this.PRIVSTE_BUCKET_NAME = privateBuckerName;
    }

    public static AliOSSUtil instance() {
        return new AliOSSUtil();
    }



    /**
     * 保存私有文件
     */
    public boolean savaPriFile(File file, String objectName) {
        System.out.println("========保存私有文件========");
        //OSS oss = setOSS(HZ_ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ossClient.putObject(PRIVSTE_BUCKET_NAME, objectName, file);
        ossClient.shutdown();
        return true;
    }

    public URL getUrl(String objectName) {
        //OSS oss = setOSS(HZ_ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 设置URL过期时间为1小时。
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
        URL url = ossClient.generatePresignedUrl(PRIVSTE_BUCKET_NAME, objectName, expiration);
        return url;
    }

    /**
     * 保存文件
     *
     * @return
     */
    public boolean savaFile(File file, String objectName) {
        //String endpoint = AliOSSUtil.HZ_ENDPOINT;
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        //String accessKeyId = AliOSSUtil.ACCESS_KEY_ID;
        //String accessKeySecret =AliOSSUtil.ACCESS_KEY_SECRET;
        // 创建OSSClient实例。
        // OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(BUCKET_NAME, objectName, file);
        // 关闭OSSClient。
        ossClient.shutdown();
        return true;
    }

    public boolean savaUrl(String url, String objectName) {
        // 创建OSSClient实例。
        //OSS ossClient = new OSSClientBuilder().build(HZ_ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 上传网络流。
        InputStream inputStream = null;
        try {
            inputStream = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        ossClient.putObject(BUCKET_NAME, objectName, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
        return true;
    }

    /**
     * 保存文件流
     *
     * @param inputStream
     * @param objectName
     * @return
     */
    public boolean savaFileInputStream(InputStream inputStream, String objectName) {
        // 创建OSSClient实例。
        //OSS ossClient = new OSSClientBuilder().build(HZ_ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 上传文件流。
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(localFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        ossClient.putObject(BUCKET_NAME, objectName, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
        return true;
    }

    /**
     * 保存Byte数组
     *
     * @param content
     * @param objectName
     * @return
     */
    public boolean savaByets(byte[] content, String objectName) {
        //OSS ossClient = new OSSClientBuilder().build(HZ_ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ossClient.putObject(BUCKET_NAME, objectName, new ByteArrayInputStream(content));
        // 关闭OSSClient。
        ossClient.shutdown();
        return true;
    }


}
