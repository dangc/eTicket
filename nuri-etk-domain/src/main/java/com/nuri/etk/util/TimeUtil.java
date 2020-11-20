package com.nuri.etk.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Time Utilization
 * 현재 시간, 두 날짜 사이의 차 등 시간 관련 메소드 제공
 * @author 2.x버전에서 가져옴
 */
public class TimeUtil
{
	/**
	 * Get 'yyyy-MM-dd HH:mm:ss' formatted date and time
	 * @param inDate
	 * @return String of date and time
	 */
    public static String formatDateTime(String inDate){

        String strDate = inDate;

        if (!"".equals(StringUtil.nullToBlank(inDate))){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

            if (inDate.trim().length() > 14) {
                inDate = inDate.substring(0, 14);
            }

            try {
                Date date = sdf.parse(inDate);
                SimpleDateFormat formatter;
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                strDate = formatter.format(date);
            } catch (ParseException pe) {
                
            }
        }

        return strDate;
    }
    
    /**
     * @return 현재일시(yyyyMMddHHmmssSSS)
     */
    public static String getCurrentTimeMilli() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(new Date());
    }
    
	/**
     *  get current time 'yyyyMMddHHmmss'
     *
     * @return current time <code>String</code>
     */
    public static String getCurrentTime()
    throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        return DateTimeUtil.getDateString(calendar.getTime());
    }
    
    /**
     *  get 'yyyyMMdd' formatted current day 
     *
     * @return current time <code>String</code>
     */
    public static String getCurrentDay()
    throws ParseException
    {
        return getCurrentTime().substring(0, 8);
    }

    /**
     *  get formatted time 'yy-mm-dd hh:mm:ss'
     *
     * @return longTime <code>long</code> long time
     * @return time <code>String</code>
     */
    public static String getFormatTime(long longTime, String lang, String country)
    {
        return getDateFormatTime(longTime, lang, country);
    }

    /**
     * 1970년 1월 1일, 00:00:00 GMT 이후의 밀리세컨드 시간을 로케일을 적용한 날짜 포맷 형식으로 반환
     * @param longTime 1970년 1월 1일, 00:00:00 GMT 이후의 밀리세컨드 시간
     * @param lang 
     * @param country
     * @return
     */
    public static String getFormatDate(long longTime, String lang, String country)
    {
        if(longTime < 1)
            return "";

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                                                   new Locale(lang,country));
        return df.format(new Date(longTime));
    }
    
    /**
     *  get 'yy-mm-dd hh:mm:ss' formatted time from millisecond time
     *
     * @return longTime <code>long</code> long time
     * @return time 
     */
    public static String getDateFormatTime(long longTime, String lang, String country)
    {
        if(longTime < 1)
            return "";

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
        											DateFormat.SHORT,
                                                    new Locale(lang,country));
        return df.format(new Date(longTime));
    }

    /**
     *  get 'yyyyMMddHHmmss' formatted time from Calendar
     *
     * @return longTime <code>long</code> long time
     * @return time <code>String</code>
     */
    public static String getFormatTime(Calendar cal)
    throws ParseException
    {
        return DateTimeUtil.getDateString(cal.getTime());
    }

    /**
     * yyyymmddhhmmss 형식의 날짜를 <code>String</code> 타입으로 전달받아서 <code>Calendar</code> 객체로 반환
     * 길이가 맞지 않을 경우 날짜뒤에 0 을 붙여서 계산.
     *    
     * @param yyyyMMddHHmmss String 타입으로 yyyymmddhhmmss 형식의 날짜
     * @return yyyymmddhhmmss에 해당하는 Calendar 반환 
     * @throws ParseException
     */
    private static Calendar getCalendar(String yyyyMMddHHmmss)
    throws ParseException
    { 
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateTimeUtil.getDateFromYYYYMMDDHHMMSS(yyyyMMddHHmmss));
        return cal;
    }
    
    /**
     * 
     * @param datetime
     * @param lang
     * @param country
     * @return
     * @throws ParseException
     */
    public static String getFormatTime(String datetime, String lang, String country)
    throws ParseException
    {
        if(datetime == null || datetime.startsWith("00000000")){
            return "0000-00-00 00:00:00";
        }else if(datetime.length() < 14){
            int len = 14-datetime.length();
            for(int i = 0; i < len; i++){
                datetime = datetime + "0";
            }
        }
        Calendar cal = getCalendar(datetime);
        return getDateFormatTime(cal.getTimeInMillis(), lang, country);
    }

    public static String getFormatDate(String datetime, String lang, String country)
    throws ParseException
    {
        if(datetime == null || datetime.startsWith("00000000")){
            return "0000-00-00 00:00:00";
        }else if(datetime.length() < 14){
            int len = 14-datetime.length();
            for(int i = 0; i < len; i++){
                datetime = datetime + "0";
            }
        }
        Calendar cal = getCalendar(datetime);
        return getFormatDate(cal.getTimeInMillis(), lang, country);
    }
    
    /**
     * 두 날짜 사이의 차이를 구한다.
     * @param from 시작일. yyyyMMdd 혹은 yyyyMMdd + HHmmss 형식의 날짜
     * @param to 종료일. yyyyMMdd 혹은 yyyyMMdd + HHmmss 형식의 날짜
     * @return 두 날짜의 차이. 단위는 '일(Day)'
     * @throws ParseException
     */
    public static int getDayDuration(String from, String to)
    throws ParseException
    {
        long fromtime = DateTimeUtil.getDateFromYYYYMMDDHHMMSS(from.substring(0,8)+"000000").getTime();
        long totime = DateTimeUtil.getDateFromYYYYMMDDHHMMSS(to.substring(0,8)+"000000").getTime();
        
        return (int) ((totime - fromtime)/1000/60/60/24);
    }
        
    /**
     * @param fromYyyymmddhhmmss 시작일. yyyymmddhhmmss 형식
     * @param toYyyymmddhhmmss 종료일. yyyymmddhhmmss 형식
     * @return 두 날짜의 차이. 단위는 분
     * @throws ParseException
     */
    public static int getMinDuration(String fromYyyymmddhhmmss, String toYyyymmddhhmmss)
    throws ParseException
    {
        long fromtime = DateTimeUtil.getDateFromYYYYMMDDHHMMSS(fromYyyymmddhhmmss).getTime();
        long totime = DateTimeUtil.getDateFromYYYYMMDDHHMMSS(toYyyymmddhhmmss).getTime();
        
        return (int) ((totime - fromtime)/1000/60);
    }
    
    public static long getLongTime(String time) 
    throws ParseException
    {
        return DateTimeUtil.getDateFromYYYYMMDDHHMMSS(time).getTime();
    }

    /**
     * 현재 시간을 <code>long<code> 타입의 밀리세컨드로 반환
     * @return
     */
    public static long getCurrentLongTime() 
    {
        try
        {
        	Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.getTimeInMillis();
        }
        catch(Exception ex)
        {
            return 0;
        }
    }
    
    /**
     * 인자로 주어진 시간에서 -1 시간
     * @param time yyyyMMddHHmmss 형식의 날짜. 길이가 맞지 않을 경우 뒤에 0 을 붙여서 계산.
     * @return time-1을 한 yyyyMMddHHmmss 형식의 날짜
     * @throws ParseException
     */
    public static String getPreHour(String time)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.HOUR,-1);
        return getFormatTime(cal);
    }

    /**
     * time 에서 hour 를 뺀 시간.
     * @param time yyyyMMddHHmmss 형식의 날짜. 길이가 맞지 않을 경우 뒤에 0 을 붙여서 계산.
     * @param hour time 에서 뺄 시간. 보통 lpChoice 를 계산할 때 사용
     * @return time - hour 의 결과
     * @throws ParseException
     */
    public static String getPreHour(String time,int hour)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.HOUR,(0-hour));
        return getFormatTime(cal);
    }

    /**
     * time에 minute을 더한 시간
     * @param time yyyyMMddHHmmss 형식의 날짜. 길이가 맞지 않을 경우 뒤에 0 을 붙여서 계산.
     * @param minute time에 더할 분
     * @return time - 결과
     * @throws ParseException
     */
    public static String getAddMinute(String time, int minute)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.MINUTE, minute);
        return getFormatTime(cal);
    }    
    
    
    /**
     * time 에서 하루를 뺀 날짜
     * @param time yyyyMMddHHmmss 형식의 날짜
     * @return time 전날 
     * @throws ParseException
     */
    public static String getPreDay(String time)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.DATE,-1);
        return getFormatTime(cal);
    }

    /**
     * time 에서 day 이전 날짜
     * @param time yyyyMMddHHmmss 형식의 날짜
     * @param day time 에서 마이너스 할 날짜
     * @return time - day
     * @throws ParseException
     */
    public static String getPreDay(String time,int day)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.DATE,(0-day));
        return getFormatTime(cal);
    }

    /**
     * time 이전 달
     * @param time 
     * @return
     * @throws ParseException
     */
    public static String getPreMonth(String time)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.MONTH,-1);
        return getFormatTime(cal);
    }

    public static String getPreMonth(String time,int month)
    throws ParseException
    {
        Calendar cal = getCalendar(time);
        cal.add(Calendar.MONTH,(0-month));
        return getFormatTime(cal);
    }

    public static String to4Digit(int value)
    {
        DecimalFormat df = new DecimalFormat("0000");
        return df.format(value);
    }

    public static String to2Digit(int value)
    {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(value);
    }
    
    /**
     * 밀리세컨드를 인자로 받아 날짜~시간으로 변환해 준다.
     * 
     * 예) long 타입의 74839924 라는 값을 전달 받으면 날짜를 계산하여 결과로
     * 
     * '0days 20:47:19' 를 반환한다.
     * 
     * @param duration <code>long</code> 타입의 밀리세컨드 값
     * @return duration 값을 시간으로 계산하여 스트링 형태로 반환
     */
    public static String diffOfDate(long duration)
    {
        long diff = duration;
        String result = "";
        
        if(diff < 0){
            result = "-";
            diff   = diff*(-1); 
        }
        long diffDays 			= diff / (24 * 60 * 60 * 1000);
        long diffDaysRemain 	= diff % (24 * 60 * 60 * 1000);
        long diffHours 			= diffDaysRemain/(60 * 60 * 1000);
        long diffHoursRemain 	= diffDaysRemain%(60 * 60 * 1000);
        long diffMinutes 		= diffHoursRemain/(60 * 1000);
        long diffMinutesRemain 	= diffHoursRemain%(60 * 1000);
        long diffSeconds 		= diffMinutesRemain/1000;            

        result 	+= "" + diffDays + "days ";
        
        result	+= diffHours < 10 ? "0" + diffHours : "" + diffHours;
        result	+= ":";
        result	+= diffMinutes < 10 ? "0" + diffMinutes : "" + diffMinutes;
        result	+= ":";
        result	+= diffSeconds < 10 ? "0" + diffSeconds : "" + diffSeconds;
        
        return result;
     }
    
    /**
     * 두 시간 사이의 차이를 문자열 형태로 반환
     * 
     * 예) begin - 74812024, end - 74839924 일 경우
     * 결과
     * 
     * 0days 00:00:27
     * 
     * @param begin Start time
     * @param end End time
     * @return
     */
    public static String diffOfDate(long begin, long end) 
    {
        long diff = end - begin;
        String result = "";
        
        if(diff < 0){
            result	= "-";
            diff 	= diff*(-1); 
        }
        
        long diffDays 			= diff / (24 * 60 * 60 * 1000);
        long diffDaysRemain 	= diff % (24 * 60 * 60 * 1000);
        long diffHours 			= diffDaysRemain/(60 * 60 * 1000);
        long diffHoursRemain 	= diffDaysRemain%(60 * 60 * 1000);
        long diffMinutes 		= diffHoursRemain/(60 * 1000);
        long diffMinutesRemain 	= diffHoursRemain%(60 * 1000);
        long diffSeconds 		= diffMinutesRemain/1000;            

        result 	+= "" + diffDays + "days ";
        
        result	+= diffHours < 10 ? "0" + diffHours : "" + diffHours;
        result	+= ":";
        result	+= diffMinutes < 10 ? "0" + diffMinutes : "" + diffMinutes;
        result	+= ":";
        result	+= diffSeconds < 10 ? "0" + diffSeconds : "" + diffSeconds;
        
        return result;
     }
    
    
    /**
     * 특정 포맷형식의 날짜를 넘기면 해당 형식에서 사용되는 delimeter 를 이용하여 현재 날짜를 반환한다. 
     * 적용되는 delimeter 는 '/', '-', '.' 이다.
     * 
     * 이 외에는 yyyymmdd 형식으로 반환한다.
     *  
     * @param format 특정 포맷 형식의 날짜(Date)
     * @return 파라미터와 동일한 형식의 현재 날짜
     */
	public static String getCurrentDateUsingFormat(String format){
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH)+1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    
	    String delimiter = "";
	    if(format.indexOf("-") > 0){
	    	delimiter = "-";
	    }
	    else if(format.indexOf(".") > 0){
	    	delimiter = ".";
	    }
	    else if(format.indexOf("/") > 0){
	    	delimiter = "/";
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    sb.append(Integer.toString(year));
	    sb.append(delimiter);
	    sb.append(to2Digit(month));
	    sb.append(delimiter);
	    sb.append(to2Digit(day));
	 
	    return sb.toString();
	}
    
    /**
     * 밀리세컨드 값을 지정한 DateFormat 으로 반환
     * 
     * @param longTime 1970-1-1 이후의 밀리세컨드 값
     * @param format <code>SimpleDateFormat</code>에 사용하는 DateFormat
     * @return
     */
	public static String getDateUsingFormat(long longTime, String format) {
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    return sdf.format(new Date(longTime));
	}
	
	/**
	 * yyyyMMddHHmmss 의 날짜에서 hour 시간 이후의 날짜를 구하는 메소드
	 * @param time yyyyMMddHHmmss 형식의 날짜
	 * @param hour hour만큼의 시간을 time 에 더한다.
	 * @return time + hour 를 나타내는 yyyyMMddHHmmss 형식의 날짜
	 * @throws ParseException
	 */
	public static String getAddedHour(String time, int hour) throws ParseException {
		Calendar cal = getCalendar(time);
        cal.add(Calendar.HOUR,(0+hour));
        return getFormatTime(cal);
	}
	
	/**
	 * yyyyMMddHHmmss 의 날짜에서 Day 이후의 날짜를 구하는 메소드
	 * @param time yyyyMMddHHmmss 형식의 날짜
	 * @param day Day만큼의 일수를 time 에 더한다.
	 * @return time + day 를 나타내는 yyyyMMddHHmmss 형식의 날짜
	 * @throws ParseException
	 */
	public static String getAddedDay(String time, int day) throws ParseException {
		Calendar cal = getCalendar(time);
        cal.add(Calendar.DATE,(0+day));
        return getFormatTime(cal);
	}
	
	/**
	 * yyyyMMddHHmmss 의 날짜에서 month 일 이후의 날짜를 구하는 메소드
	 * @param time yyyyMMddHHmmss 형식의 날짜
	 * @param month month만큼의 시간을 time 에 더한다.
	 * @return time + month 를 나타내는 yyyyMMddHHmmss 형식의 날짜
	 * @throws ParseException
	 */
	public static String getAddedMonth(String time, int month) throws ParseException {
		Calendar cal = getCalendar(time);
        cal.add(Calendar.MONDAY,(0+month));
        return getFormatTime(cal);
	}

	/**
	 * method name : checkDate
	 * method Desc : 날짜의 유효성 체크를 실시한다.
	 *
	 * @param yyyymmddhhmmss
	 * @return boolean 
	 */
	public static boolean checkDate(String yyyymmddhhmmss){
		DateFormat DF = new SimpleDateFormat("yyyyMMddHHmmss");
		DF.setLenient(false);
		try
		{
			DF.parse(yyyymmddhhmmss);
		}
		catch (ParseException ex)
		{
			return false;
		}

		return true;
	}
	
    /**
     * @return 현재일시(yyyyMMddHHmmssSSS)
     */
    /**
     * method name : getCurrentTimeMilli
     * method Desc : 데이터 포멧에 맞는 현재 일시를 취득한다.
     *
     * @param dateformat 데이터 포멧
     * @return 포멧에 맞는 현재 일지
     */
    public static String getCurrentTimeMilli(String dateformat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateformat);
        return formatter.format(new Date());
    }
    
}
