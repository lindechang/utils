package com.zeroing.utils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;


public class HttpUtil {

    private static final Log logger = LogFactory.getLog(HttpUtil.class);


    public static void HttpParm(HttpServletRequest request){
        //获取所有的请求参数
        Enumeration<String> paraNames=request.getParameterNames();
        for(Enumeration<String> e=paraNames;e.hasMoreElements();){
            String thisName=e.nextElement().toString();
            String thisValue=request.getParameter(thisName);
            System.out.println("param的key:"+thisName+"--------------param的value:"+thisValue);
        }
//获取所有的头部参数
        Enumeration<String> headerNames=request.getHeaderNames();
        for(Enumeration<String> e=headerNames;e.hasMoreElements();){
            String thisName=e.nextElement().toString();
            String thisValue=request.getHeader(thisName);
            System.out.println("header的key:"+thisName+"--------------header的value:"+thisValue);
        }
    }

    /**
     * 获取访问用户的客户端IP（适用于公网与局域网）.
     */
    public static final String getIpAddr(final HttpServletRequest request)
            throws Exception {
        if (request == null) {
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }
        String ipString = request.getHeader("x-forwarded-for");
        if (HttpUtil.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (HttpUtil.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (HttpUtil.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipString.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipString = str;
                break;
            }
        }

        return ipString;
    }

    /**
     * @param s
     * @return 如果<tt>s</tt>为<tt>null</tt>或空白字符串返回<tt>true</tt>
     */
    public static boolean isBlank(String s) {
        return s == null ? true : s.trim().length() == 0;
    }


    public static String getIpAddress(HttpServletRequest request) {
        /**注意：阿里云服务器还有一层代理,所以request.getHeader("X-Real-IP")只能获得最近一层代理的ip。
         * 而我们需要知道的是客户端的ip（即是第一层被代理的ip）,所以用request.getHeader("X-Forwarded-For")获得所有被代理的ip地址
         **/
        //String ip = request.getHeader("X-Real-IP");
        String ip = request.getHeader("X-Forwarded-For");

        //System.out.println("===========getHeader(X-Real-IP)============ip:"+ip);

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if(ip.trim().contains(",")){//为什么会有这一步，因为经过多层代理后会有多个代理，取第一个ip地址就可以了
            String [] ips=ip.split(",");
            ip=ips[0];
        }

        //System.out.println("===========getIpAddress============ip:"+ip);
        return ip;
    }


    /**
     *
     * @param urlString
     * @param param 请求参数（POST）
     * @param map 头部设置
     * @param method
     * @return
     */
    public static StringBuffer httpConnect(String urlString, String param, Map<String, String> map,
                                           String method) {

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        HttpURLConnection con = null;
        URL url;
        OutputStreamWriter osw = null;
        StringBuffer buffer = new StringBuffer();
        try {
            url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(10000);
            con.setRequestMethod(method);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Charset", "UTF-8");
            if (map !=null && map.size()>0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    con.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if (("POST".equals(method) || "PUT".equals(method)) && !param.isEmpty()) {
                osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
                osw.write(param);
                osw.flush();
            }
        } catch (Exception e) {
            logger.error("urlString: " + urlString + " paraType: " + map
                    + " method: " + method, e);
            return buffer.append("timeout");
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (Exception e) {
                    logger.error("" + e);
                }
            }
        }

        if (con != null) {
            con.disconnect();
            InputStream inputStream = null;
            BufferedReader br = null;
            try {
                if (con.getResponseCode() == HttpURLConnection.HTTP_OK || con.getResponseCode() == HttpURLConnection.HTTP_CREATED || con.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT) {
                    inputStream = con.getInputStream();
                } else if (con.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT) {
                    buffer.append("success");
                } else {
                    inputStream = con.getErrorStream();
                }
            } catch (Exception e) {
                con.disconnect();
            }
            try {
                if (inputStream != null) {
                    br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    String temp;
                    while ((temp = br.readLine()) != null) {
                        buffer.append(temp);
                        buffer.append("\n");
                    }
                    if (con.getResponseCode() == HttpURLConnection.HTTP_OK || con.getResponseCode() == HttpURLConnection.HTTP_CREATED || con.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT) {
                        if (buffer.length() == 0) {
                            buffer.append("success");
                        }
                    } else {
                        if (buffer.length() == 0) {
                            buffer.append("error");
                        }
                    }
                }

                return buffer;
            } catch (Exception e) {
                logger.error("urlString: " + urlString + " param: " + param + " paraType: "
                        + map + " method: " + method, e);
            } finally {

                if (br != null) {
                    try {
                        br.close();
                    } catch (Exception e) {
                        logger.error("" + e);
                    }
                }
            }

        }

        return null;
    }


}
