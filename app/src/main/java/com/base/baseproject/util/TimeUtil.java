package com.base.baseproject.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zlq on 2017/12/29.
 */

public class TimeUtil {

    public static String time2MyTime(String date) {
        Date dateT = null;
        String timeOrder = null;
        long minusLongTime = 0;
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dateT = time.parse(date);
            minusLongTime = dateT.getTime() - 86400 * 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (minusLongTime != 0) {
            SimpleDateFormat time2 = new SimpleDateFormat("yyyy-MM-dd");
            timeOrder = time2.format(new Date(minusLongTime));
        }

        return timeOrder;
    }

    /**
     * 格式化好的时间转long
     *
     * @param timeFormat
     * @return
     */
    public static long timeFormatToLongTime(String timeFormat) {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long timeLong = null;
        try {
            Date date = time.parse(timeFormat);
            timeLong = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeLong;
    }

    /**
     * long转String格式化好的时间
     *
     * @param
     * @return
     */
    public static String longTimeToTimeFormat(long timel) {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = time.format(new Date(timel));
        return timeStr;
    }

    /**
     * 获取当天零点的时间
     */
    public static String getCurrent00Time() {
        //获取当前时间，作为图标的名字
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String monthStr = "";
        String dayStr = "";
        if (month <= 9) {
            monthStr = "0" + month;
        } else {
            monthStr = month + "";
        }
        if (day <= 9) {
            dayStr = "0" + day;
        } else {
            dayStr = day + "";
        }
        return year + "-" + monthStr + "-" + dayStr + " 00:00:00";
    }

    /**
     * 获取当天零点的时间
     */
    public static String getCurrent24Time() {
        //获取当前时间，作为图标的名字
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String monthStr = "";
        String dayStr = "";
        if (month <= 9) {
            monthStr = "0" + month;
        } else {
            monthStr = month + "";
        }
        if (day <= 9) {
            dayStr = "0" + day;
        } else {
            dayStr = day + "";
        }
        return year + "-" + monthStr + "-" + dayStr + " 23:59:59";
    }

    /**
     * 获取当前时间
     */
    public static String getCurrentTime(boolean isDate) {
        if (isDate) {
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
            String date = time.format(new Date(System.currentTimeMillis()));
            return date;
        } else {
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = time.format(new Date(System.currentTimeMillis()));
            return date;
        }

    }

}
