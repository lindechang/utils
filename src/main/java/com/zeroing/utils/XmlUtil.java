package com.zeroing.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

//import org.dom4j.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.*;

/**
 * xml工具类
 *
 * @author sleep
 * @date 2016-09-13
 */
public class XmlUtil {
//
//    /**
//     * String 转 org.dom4j.Document
//     *
//     * @param xml
//     * @return
//     * @throws DocumentException
//     */
//    public static Document strToDocument(String xml) throws DocumentException {
//        return DocumentHelper.parseText(xml);
//    }
//
//    /**
//     * org.dom4j.Document 转  com.alibaba.fastjson.JSONObject
//     *
//     * @param xml
//     * @return
//     * @throws DocumentException
//     */
//    public static JSONObject documentToJSONObject(String xml) throws DocumentException {
//        return elementToJSONObject(strToDocument(xml).getRootElement());
//    }
//
//    /**
//     *
//     * @param request
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    public static JSONObject HttpServletToJSONObject(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        InputStream in = request.getInputStream();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while ((len = in.read(buffer)) != -1) {
//            out.write(buffer, 0, len);
//        }
//        out.close();
//        in.close();
//        String content = new String(out.toByteArray(), "utf-8");//xml数据
//        return documentToJSONObject(content);
//    }
//
//    /**
//     * org.dom4j.Element 转  com.alibaba.fastjson.JSONObject
//     *
//     * @param node
//     * @return
//     */
//    public static JSONObject elementToJSONObject(Element node) {
//        JSONObject result = new JSONObject();
//        // 当前节点的名称、文本内容和属性
//        List<Attribute> listAttr = node.attributes();// 当前节点的所有属性的list
//        for (Attribute attr : listAttr) {// 遍历当前节点的所有属性
//            result.put(attr.getName(), attr.getValue());
//        }
//        // 递归遍历当前节点所有的子节点
//        List<Element> listElement = node.elements();// 所有一级子节点的list
//        if (!listElement.isEmpty()) {
//            for (Element e : listElement) {// 遍历所有一级子节点
//                if (e.attributes().isEmpty() && e.elements().isEmpty()) // 判断一级节点是否有属性和子节点
//                    result.put(e.getName(), e.getTextTrim());// 沒有则将当前节点作为上级节点的属性对待
//                else {
//                    if (!result.containsKey(e.getName())) // 判断父节点是否存在该一级节点名称的属性
//                        result.put(e.getName(), new JSONArray());// 没有则创建
//                    ((JSONArray) result.get(e.getName())).add(elementToJSONObject(e));// 将该一级节点放入该节点名称的属性对应的值中
//                }
//            }
//        }
//        return result;
//    }
//
//
//    /**
//     * 将Map转换为XML格式的字符串
//     *
//     * @param data Map类型数据
//     * @return XML格式的字符串
//     * @throws Exception
//     */
//    public static String mapToXml(Map<String, String> data) throws Exception {
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//        org.w3c.dom.Document document = documentBuilder.newDocument();
//        org.w3c.dom.Element root = document.createElement("xml");
//        document.appendChild(root);
//        for (String key : data.keySet()) {
//            String value = data.get(key);
//            if (value == null) {
//                value = "";
//            }
//            value = value.trim();
//            org.w3c.dom.Element filed = document.createElement(key);
//            filed.appendChild(document.createTextNode(value));
//            root.appendChild(filed);
//        }
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer transformer = tf.newTransformer();
//        DOMSource source = new DOMSource(document);
//        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//        StringWriter writer = new StringWriter();
//        StreamResult result = new StreamResult(writer);
//        transformer.transform(source, result);
//        String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
//        try {
//            writer.close();
//        } catch (Exception ex) {
//        }
//        return output;
//    }
//
//
//    /*
//     * 将SortedMap<Object,Object> 集合转化成 xml格式
//     */
//    public static String getRequestXml(SortedMap<Object, Object> parameters) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("<xml>");
//        Set es = parameters.entrySet();
//        Iterator it = es.iterator();
//        while (it.hasNext()) {
//            Map.Entry entry = (Map.Entry) it.next();
//            String k = (String) entry.getKey();
//            String v = (String) entry.getValue();
//            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
//                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
//            } else {
//                sb.append("<" + k + ">" + v + "</" + k + ">");
//            }
//        }
//        sb.append("</xml>");
//        return sb.toString();
//    }


}