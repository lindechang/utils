package com.zeroing.utils;


//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
//import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

//import com.sun.xml.internal.messaging.saaj.util.Base64;

//import com.sun.org.apache.xml.internal.security.utils.Base64;
//import org.apache.commons.codec.binary.Base64;

//import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 8:03 PM 2019/3/11 Created with Intellij IDEA
 * @Description:
 */
public class QRCodeUtil {

//    public static QRCodeUtil instance() {
//        return new QRCodeUtil();
//    }
//
//    public String crateQRCode(String content, int width, int height) throws IOException {
//
//        String resultImage = "";
//        if (!StringUtils.isEmpty(content)) {
//            ServletOutputStream stream = null;
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            @SuppressWarnings("rawtypes")
//            HashMap<EncodeHintType, Comparable> hints = new HashMap<>();
//            hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 指定字符编码为“utf-8”
//            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); // 指定二维码的纠错等级为中级
//            hints.put(EncodeHintType.MARGIN, 2); // 设置图片的边距
//
//            try {
//                QRCodeWriter writer = new QRCodeWriter();
//                BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
//
//                BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
//                ImageIO.write(bufferedImage, "png", os);
//                /**
//                 * 原生转码前面没有 data:image/png;base64 这些字段，返回给前端是无法被解析，可以让前端加，也可以在下面加上
//                 */
//                //resultImage = new String("data:image/png;base64," + Base64.encode(os.toByteArray()));
//
//                //resultImage = "data:image/png;base64," + Base64Util.encryptBASE64(os.toByteArray());
//                //todo:2019.12.16修改Base64Util 加密包
//                resultImage = "data:image/png;base64," + Base64Util.encode(os.toByteArray());
//
//                return resultImage;
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (stream != null) {
//                    stream.flush();
//                    stream.close();
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 创建二维码
//     *
//     * @param content
//     * @param width
//     * @param height
//     * @return
//     * @throws IOException
//     */
//    public byte[] crateQRCodeReultByte(String content, int width, int height) throws IOException {
//
//        String resultImage = "";
//        if (!StringUtils.isEmpty(content)) {
//            ServletOutputStream stream = null;
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//            @SuppressWarnings("rawtypes")
//            HashMap<EncodeHintType, Comparable> hints = new HashMap<>();
//            hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 指定字符编码为“utf-8”
//            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); // 指定二维码的纠错等级为中级
//            hints.put(EncodeHintType.MARGIN, 0); // 设置图片的边距
//
//            try {
//                QRCodeWriter writer = new QRCodeWriter();
//                BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
//
//                BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
//                ImageIO.write(bufferedImage, "png", os);
//
//                /**
//                 * 原生转码前面没有 data:image/png;base64 这些字段，返回给前端是无法被解析，可以让前端加，也可以在下面加上
//                 */
//                //resultImage = new String("data:image/png;base64," + Base64.encode(os.toByteArray()));
//                //resultImage ="data:image/png;base64,"+ new String( Base64Util.encryptBASE64(os.toByteArray()));
//
//
//                return os.toByteArray();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (stream != null) {
//                    stream.flush();
//                    stream.close();
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 创建并保持
//     *
//     * @param content
//     * @return
//     * @throws IOException
//     */
//    public boolean crateAndSaveQRCodeReultBytess(String content, String fileName, String filePath,
//                                                 int width,int height) throws IOException {
//        String destFileName = filePath + fileName;
//        File destFile = new File(destFileName);
//        destFile.getParentFile().mkdirs();
//        try {
//            ByteArrayInputStream bis = new ByteArrayInputStream(crateQRCodeReultByte(content, width, height));
//            OutputStream os = new FileOutputStream(destFile);
//            int len;
//            byte[] arr = new byte[1024];
//            while ((len = bis.read(arr)) != -1) {
//                os.write(arr, 0, len);
//                os.flush();
//            }
//            os.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }


}
