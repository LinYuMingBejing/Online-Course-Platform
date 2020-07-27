package com.items.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final String dateFormat = "yyyy-MM-dd";

    public static String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    // 在日期date上加上amount天
    public static Date addDays(Date date, int amount){
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + amount);
        return now.getTime();
    }
}
