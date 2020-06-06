package com.zeroing.utils;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 10:08 下午 2019/12/31 Created with Intellij IDEA
 * @Description:
 */
public class GPS {
    private double lat;
    private double lon;

    public GPS(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String toString() {
        return "lat:" + lat + "," + "lon:" + lon;
    }
}
