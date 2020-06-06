package com.zeroing.utils;

import java.math.BigDecimal;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 下午6:12 2018/5/24 Created with Intellij IDEA
 * @Description:
 */
public class MathUtil {

//    public static void main(String[] args) {
//
//        BigDecimal a = new BigDecimal(10);
//        BigDecimal b = new BigDecimal(100000);
//        System.out.println(getlog(b, a));
////
//    }

    /**
     * ds=2 ps=8  ——>返回4
     * ds=10 ps=100  ——>返回2
     *
     * @param ds
     * @param ps
     * @return
     */
    public static double getlog(int ds, int ps) {
        BigDecimal a = new BigDecimal(ds);
        BigDecimal b = new BigDecimal(ps);
        return Math.log(b.doubleValue()) / Math.log(a.doubleValue());
    }


}
