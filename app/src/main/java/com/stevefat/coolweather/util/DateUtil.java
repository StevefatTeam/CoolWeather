package com.stevefat.coolweather.util;

import android.content.Context;
import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期的工具类
 * Author : stevefat
 * Email :ngh8897@gmail.com
 * Created : 17-3-23 上午10:34.
 */

public class DateUtil {

    private Date parseStringToDate(String strDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.parse(strDate);

    }

    private String pars12Hour(String strDate) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = parseStringToDate(strDate);
        return sdformat.format(date);
    }

    private String pars24Hour(String strDate) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = parseStringToDate(strDate);
        return sdformat.format(date);

    }

    public String parseDate(String strDate, Context context) {
        try {
            boolean is24Hour = DateFormat.is24HourFormat(context);
            //如果是24 小时
            String updateTime;
            if (is24Hour) {
                updateTime = pars24Hour(strDate);

            } else {
                updateTime = pars12Hour(strDate);
            }
            return updateTime.substring(updateTime.indexOf("-") + 1);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }
}
