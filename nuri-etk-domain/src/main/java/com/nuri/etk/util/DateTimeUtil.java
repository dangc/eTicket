package com.nuri.etk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author 2.x버전에서 가져옴
 * @version 1.0
 */
public class DateTimeUtil {
    private static Log log = LogFactory.getLog(DateTimeUtil.class);
    public static final String UTC_ID = "Etc/UTC"; 
    
    public static String getCurrentDateTimeByFormat1(String format) {
        if (null == format || "".equals(format))
            format = "yyyyMMddHHmmss";
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
    }
    
    public static String getCurrentDateTimeByFormat(String format) {
        if (null == format || "".equals(format))
            format = "yyyyMMddHHmmss";
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone(UTC_ID));
        Calendar cal = Calendar.getInstance();
        
        int dst = 0;
        /*if (cal.getTimeZone().inDaylightTime(cal.getTime()))
            dst = cal.getTimeZone().getDSTSavings();*/
        
        String dateStr = sdf.format(new Date(cal.getTimeInMillis() + cal.getTimeZone().getRawOffset()+dst));

        return dateStr;
    }
    public static String getShortTimeString1(long time)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "HHmmss");
        return formatter.format(new Date(time));
    }
    public static String getShortTimeString(long time)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "HHmmss");
        formatter.setTimeZone(TimeZone.getTimeZone(UTC_ID));
        Calendar cal = Calendar.getInstance();
        
        int dst = 0;
        /*if (cal.getTimeZone().inDaylightTime(new Date(time)))
            dst = cal.getTimeZone().getDSTSavings();*/
        
        return formatter.format(new Date(time + cal.getTimeZone().getRawOffset() + dst));
    }
    public static String getShortDateString1(long time)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyyMMdd");
        return formatter.format(new Date(time));
    }
    public static String getShortDateString(long time)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyyMMdd");
        formatter.setTimeZone(TimeZone.getTimeZone(UTC_ID));
        Calendar cal = Calendar.getInstance();
        
        int dst = 0;
        /*if (cal.getTimeZone().inDaylightTime(new Date(time)))
            dst = cal.getTimeZone().getDSTSavings();*/
        
        return formatter.format(new Date(time + cal.getTimeZone().getRawOffset() + dst));
    }
    public static String getDateString(long time)
    {
        return getDateString(new Date(time));
    }
    public static String getDateString1(Date time)
    {
        if(time == null)
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyyMMddHHmmss");
        return formatter.format(time);
    }
    public static String getDateString(Date time, String pattern)
    {
        if(time == null || pattern == null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(time);
    }
    public static String getDateString(Date time)
    {
        if(time == null)
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyyMMddHHmmss");
        formatter.setTimeZone(TimeZone.getTimeZone(UTC_ID));
        Calendar cal = Calendar.getInstance();
        
        int dst = 0;
        /*if (cal.getTimeZone().inDaylightTime(time))
            dst = cal.getTimeZone().getDSTSavings();*/
        
        return formatter.format(new Date(time.getTime() + cal.getTimeZone().getRawOffset() + dst));
    }
    public static Date getDateFromYYYYMMDD(String yyyymmdd)
    throws ParseException
    {
        if(yyyymmdd == null || yyyymmdd.length()<8)
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyyMMddHHmmss");
        return formatter.parse(yyyymmdd.substring(0,8)+"000000");
    }
    public static Date getDateFromYYYYMMDDHHMMSS(String yyyymmddhhmmss)
    throws ParseException
    {
        
        if(yyyymmddhhmmss.length()<14)
            yyyymmddhhmmss = StringUtil.endAppendNStr('0', yyyymmddhhmmss, 14);

        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyyMMddHHmmss");
        return formatter.parse(yyyymmddhhmmss);
    }
    public static Date getDateFromYYYYMMDDHHMM(String yyyymmddhhmm) throws ParseException
    {        
        if(yyyymmddhhmm.length()<12)
            yyyymmddhhmm = StringUtil.endAppendNStr('0', yyyymmddhhmm, 12);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
        return formatter.parse(yyyymmddhhmm);
    }
    
    
    public static String endAppendNStr(char append, String str, int length)
    {
        StringBuffer b = new StringBuffer("");

        if (str.length() < length)
        {
            b.append(str);
            for (int i = 0; i < length - str.length(); i++)
                b.append(append);
        }
        else
        {
            b.append(str);
        }

        return b.toString();
    }
    
    /**
     * @param fromDate  yyyyMMddHHmmss
     * @param toDate    yyyyMMddHHmmss
     * @param interval  minute
     * @return yyyyMMddHHmm list
     * @throws ParseException
     */
    public static String[] getPeriod(String fromDate,String toDate, int interval)
    throws ParseException
    {
        /*
        List<String> l = new ArrayList<String>();
        DecimalFormat df = new DecimalFormat( "00" );
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd" );
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(fromDate.substring(0, 8)));

        int fromHH = Integer.parseInt(fromDate.substring(8, 10));
        int fromMM = Integer.parseInt(fromDate.substring(10, 12));
        String dateIdx = fromDate;
        for (; dateIdx.compareTo(toDate) <= 0; fromMM+=interval) {
            if (fromMM == 60) {
                fromMM = 0;
                fromHH++;
            }
            if (fromHH == 24) {
                fromHH = 0;
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            dateIdx = sdf.format(cal.getTime()) + df.format(fromHH) + df.format(fromMM) + "00";
            log.debug(dateIdx);
            l.add(dateIdx.substring(0, 12));
        }

        return (String[])l.toArray( new String[0] );
        */
        if(interval <= 0)
        {
            throw new ParseException("Invalid Interval!, interval["+interval+"]",0);
        }
        List<String> l = new ArrayList<String>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        sdf.setTimeZone(TimeZone.getTimeZone(UTC_ID));
        
        Calendar fromCal = Calendar.getInstance();
        Calendar toCal = Calendar.getInstance();
        
        fromCal.setTime(sdf.parse(fromDate));
        toCal.setTime(sdf.parse(toDate));
        Calendar calIdx = fromCal;
        
        String dateString = "";
        for (; calIdx.compareTo(toCal) <= 0; calIdx.add(Calendar.MINUTE, interval)) {
            dateString = sdf.format(calIdx.getTime()).substring(0, 12);
            l.add(dateString);
            log.debug(dateString);
        }
        return (String[])l.toArray( new String[0] );
    }
    
    /*
     * 현재일로 부터 전, 이후 년/월/일 계산
     */
    public static Map<String, String> calcDate(int type, int arg) {
        
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(type, arg);
        Date calculatedDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd&hh.mm.ss");
        
        String[] dateArray = format.format(calculatedDate).split("&");
        
        Map<String, String> dateMap = new HashMap<String, String>();
        dateMap.put("date", dateArray[0]);
        dateMap.put("time", dateArray[1]);
        
        return dateMap;
    }  

    /*
     * 현재일로 부터 전, 이후 년/월/일 계산, 리턴형 사용
     */
    public static String calcDate(int type, int arg, String dateFormat) {
        
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(type, arg);
        Date calculatedDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        
        return format.format(calculatedDate);
    
    }
    
    public static Calendar getCalendar(String time)
    throws ParseException
    { 
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateTimeUtil.getDateFromYYYYMMDDHHMMSS(time));
        return cal;
    }
    
    /**
     *  get formatted time 'yyyyMMddHHmmss'
     *
     * @return longTime <code>long</code> long time
     * @return time <code>String</code>
     */
    public static String getFormatTime(Calendar cal)
    throws ParseException
    {
        return getDateString(cal.getTime());
    }
    
    public static String getPreDay(String time)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.DAY_OF_YEAR,-1);
        return getFormatTime(cal);
    }
    
    public static String getPreDay(String time,int day)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.DAY_OF_YEAR,(0-day));
        return getFormatTime(cal);
    }
    
    public static String getPreHour(String time,int hour)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.HOUR_OF_DAY,(0-hour));
        return getFormatTime(cal);
    }
    
    public static int inDST(String timezoneId, String yyyyMMddHHmmss)
    throws ParseException
    {
        /*TimeZone timezone = null;
        if (timezoneId == null) {
            timezone = TimeZone.getDefault();
        }
        else {
            timezone = TimeZone.getTimeZone(timezoneId);
        }
        Calendar cal = getCalendar(yyyyMMddHHmmss);
        if (timezone.inDaylightTime(cal.getTime()))
            return 1;
        else
            return 0;*/
        return 0;
    }
    
    public static String getDST(String timezoneId, String yyyyMMddHHmmss)
    throws ParseException
    {
        /*TimeZone timezone = null;
        if (timezoneId == null) {
            timezone = TimeZone.getDefault();
        }
        else {
            timezone = TimeZone.getTimeZone(timezoneId);
        }
        Calendar cal = getCalendar(yyyyMMddHHmmss);
        long mills = cal.getTimeInMillis() + timezone.getDSTSavings();
        if (timezone.inDaylightTime(new Date(mills))) {
            return getDateString(new Date(mills));
        }*/
        return yyyyMMddHHmmss;
    }
    
    public static String getElapseTimeToString(long elapseTime){
        int tempSec = (int)(elapseTime / 1000);
        int time = tempSec / 3600;
        int min = tempSec % 3600 / 60;
        int sec = tempSec % 3600 % 60 % 60;

        return time + "t " + min + "m "+ sec + "s";
    }
}
