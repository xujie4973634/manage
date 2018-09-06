package com.hemai.manage.utils;

import org.apache.commons.lang.math.NumberUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * pe date utils
 *
 * @author LiYanCheng@HF
 * @version 1.0.0
 * @since 2016年10月9日14:34:01
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils{

    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String FORMAT_YYYYMMDD="yyyy/MM/dd";

    public static String format(Date date, String formatStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
        return dateFormat.format(date);
    }

    public static Date parse(String dateString, String formatStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }


    public static Date parse(Date date, String formatStr) {
        String dateString = format(date, formatStr);
        return parse(dateString, formatStr);
    }


    public static long reduceDate(Date date, Date reduceDate) {
        if (date == null || reduceDate == null) {
            return NumberUtils.INTEGER_ZERO;
        }

        return (date.getTime() - reduceDate.getTime()) / 1000;
    }

    public static Date getFirstDate(Date date) {
        Date firstDate = org.apache.commons.lang.time.DateUtils.setHours(date, 0);
        firstDate = org.apache.commons.lang.time.DateUtils.setMinutes(firstDate, 0);
        return org.apache.commons.lang.time.DateUtils.setSeconds(firstDate, 0);
    }

    public static Date getEndDate(Date date) {
        Date lastTime = org.apache.commons.lang.time.DateUtils.setHours(date, 23);
        lastTime = org.apache.commons.lang.time.DateUtils.setMinutes(lastTime, 59);
        return org.apache.commons.lang.time.DateUtils.setSeconds(lastTime, 59);
    }

    public static String secToTime(int time) {
        String timeStr = "00:00";
        if (time <= 0) {
            return timeStr;
        }

        int minute = time / 60;
        if (minute < 60) {
            int second = time % 60;
            timeStr = unitFormat(minute) + ":" + unitFormat(second);
        } else {
            int hour = minute / 60;
            if (hour > 99) {
                return "99:59:59";
            }

            minute = minute % 60;
            int second = time - hour * 3600 - minute * 60;
            timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
        }

        return timeStr;
    }

    private static String unitFormat(int i) {
        if (i >= 0 && i < 10) {
            return "0" + i;
        }

        return "" + i;
    }
}
