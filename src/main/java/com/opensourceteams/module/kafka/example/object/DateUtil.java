package com.opensourceteams.module.kafka.example.object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {



    public static Date getDateByString(String dateString) throws ParseException {
        return getDateByString(dateString,"yyyy-MM-dd HH:mm:ss") ;
    }

    public static Date getDateByString(String dateString,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateString);
    }

    public static String getStringByDate(Date date,String format)  {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String getStringByDate(Date date)  {
        return  getStringByDate(date,"yyyy-MM-dd HH:mm:ss");
    }

    public static Date calTime(Date date,Integer hour,Integer minute,Integer second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if(hour != null){
            calendar.add(Calendar.HOUR_OF_DAY, hour);
        }

        if(minute !=null){
            calendar.add(Calendar.MINUTE, minute);
        }

        if(second !=null){
            calendar.add(Calendar.SECOND, second);
        }
        return  calendar.getTime();
    }
}
