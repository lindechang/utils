package com.zeroing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author :lindec
 * Email  :lindec@163.com
 * Create : 2017/9/4 Created with Intellij IDEA.
 * Description:
 */
public class TimeUtil {

    private SimpleDateFormat SimpleDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd-HH:mm:ss");

    public static SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat(
                "yyyy-MM-dd-HH:mm:ss");
    }

    public static String getTime() {
        return new SimpleDateFormat(
                "yyyy-MM-dd-HH:mm:ss").format(new Date());
    }

    public static String getDayTime() {
        return new SimpleDateFormat(
                "yyyy-MM-dd").format(new Date());
    }


    public static String getZwTime(Long time) {
        return new SimpleDateFormat(
                "yyyy年MM月dd日 HH:mm").format(time);
    }

    public static String getZwDayTime(Long time) {
        return new SimpleDateFormat(
                "yyyy年MM月dd日").format(time);
    }

    /**
     * @param
     * @return Data  -->   yyyy-MM-dd
     */
    public static String getDayTime(Long time) {
        return new SimpleDateFormat(
                "yyyy-MM-dd").format(time);
    }

    /**
     * @param date
     * @return Data  -->   yyyy-MM-dd-HH:mm:ss
     */
    public static String getTime(Date date) {
        return new SimpleDateFormat(
                "yyyy-MM-dd-HH:mm:ss").format(date);
    }

    /**
     * @param time
     * @return Long --> yyyy-MM-dd-HH:mm:ss
     */
    public static String getTime(Long time) {
        return new SimpleDateFormat(
                "yyyy-MM-dd-HH:mm:ss").format(time);
    }

    /**
     * @param time
     * @param format
     * @return 注意time 格式要和 format格式符合 如：
     * 2018-03-01-21:56:21 对于格式SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss")
     */
    public static Date getDataByTime(String time, SimpleDateFormat format) {
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获得时间戳
     * 精确到毫秒
     */
    public static String getData() {
        return String.valueOf(new Date().getTime());
    }

    /**
     * 获得时间戳
     * 精确到秒
     */
    public static String getSec() {
        return String.valueOf(new Date().getTime() / 1000);
    }


    /**
     * 获得当天凌晨0点
     *
     * @return
     */
    public static Date getAMZero() {
        return getDataByTime(getDayTime(), new SimpleDateFormat("yyyy-MM-dd"));
    }

    /**
     * 获得明天0分
     *
     * @return
     */
    public static Date getPMZero() {
        return getDataByTime(getDayTime(getTomorrow().getTime()), new SimpleDateFormat("yyyy-MM-dd"));
    }

    /**
     * 获得当天的23：59
     *
     * @return
     */
    public static Date getTodayEnd() {
        return new Date(getPMZero().getTime() - 1);
    }


    /**
     * 获得某一天的凌晨0点
     *
     * @return
     */
    public static Date getOneAMZero(Long date) {
        return getDataByTime(getDayTime(date), new SimpleDateFormat("yyyy-MM-dd"));
    }

    /**
     * 获得某一天天的23：59
     *
     * @return
     */
    public static Date getOneDayEnd(Long date) {
        return new Date(getOneAMZero(date + 1000 * 60 * 60 * 24).getTime() - 1);
    }

    /**
     * 昨天的此刻
     *
     * @return
     */
    public static Date getYesterday() {
        return new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
    }

    public static Date getTomorrow() {
        return new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
    }


    /**
     * 判断是否同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(long date1, long date2) {
        if (getOneDayEnd(date1).equals(getOneDayEnd(date2))) {
            return true;
        }
        return false;
    }




    /**
     * 计算间隔天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int countDay(long date1, long date2) {
        long base = 24 * 3600 * 1000L;
        int date;
        if (date2 > date1) {
            date = (int) ((date2 - date1) / base);
        } else {
            date = (int) ((date1 - date2) / base);
        }
        return date;
    }
//    public static void main(String[] args) {
//        System.out.println("--------:" + TimeUtil.getAMZero());
//        System.out.println("--------:" + TimeUtil.getPMZero());
//        System.out.println("--------:" + TimeUtil.getTodayEnd());
//
//        System.out.println("--------:" + TimeUtil.getOneAMZero(1527823080000L));
//        System.out.println("--------:" + TimeUtil.getOneDayEnd(1527823080000L));
//        System.out.println("----1----:" + TimeUtil.getZwTime(new Date().getTime()));
//        System.out.println("-----2---:" + TimeUtil.getZwDayTime(new Date().getTime()));
//    }

}
