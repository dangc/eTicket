package com.nuri.etk.util;

import com.nuri.etk.entity.aimir.DecimalPattern;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DecimalUtil {

    public static DecimalFormat getDecimalFormat(DecimalPattern dp) {

        if(dp == null){
            dp = new DecimalPattern("###,###,###,##0.###","r");
        }
        if(dp.getPattern() == null || "".equals(dp.getPattern())){
            dp.setPattern("###,###,###,##0.###");
        }
        if(dp.getRound() == null || "".equals(dp.getRound())){
            dp.setRound("r");
        }

        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        if(dp.getGroupingSeperator()!=null && !dp.getGroupingSeperator().equals(",")) {
            dfs.setGroupingSeparator(dp.getGroupingSeperator().charAt(0));
        }
        if(dp.getDecimalSeperator()!=null && !dp.getDecimalSeperator().equals(".")) {
            dfs.setDecimalSeparator(dp.getDecimalSeperator().charAt(0));
        }
        DecimalFormat df = new DecimalFormat(dp.getPattern(), dfs);

        if(dp.getRound().equals("r")) {
            df.setRoundingMode(RoundingMode.HALF_UP);
        } else if(dp.getRound().equals("f")) {
            df.setRoundingMode(RoundingMode.DOWN);
        } else if(dp.getRound().equals("c")) {
            df.setRoundingMode(RoundingMode.CEILING);
        }

        return df;
    }

    public static DecimalFormat getIntegerDecimalFormat(DecimalPattern dp) {
        if(dp == null){
            dp = new DecimalPattern("###,###,###,##0","r");
        }
        if(dp.getPattern() == null || "".equals(dp.getPattern())){
            dp.setPattern("###,###,###,##0");
        }
        if(dp.getRound() == null || "".equals(dp.getRound())){
            dp.setRound("r");
        }

        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        if(dp.getGroupingSeperator()!=null && !dp.getGroupingSeperator().equals(",")) {
            dfs.setGroupingSeparator(dp.getGroupingSeperator().charAt(0));
        }
        if(dp.getDecimalSeperator()!=null && !dp.getDecimalSeperator().equals(".")) {
            dfs.setDecimalSeparator(dp.getDecimalSeperator().charAt(0));
        }
        DecimalFormat df = new DecimalFormat(dp.getPattern().substring(0,dp.getPattern().indexOf(".")), dfs);

        if(dp.getRound().equals("r")) {
            df.setRoundingMode(RoundingMode.HALF_UP);
        } else if(dp.getRound().equals("f")) {
            df.setRoundingMode(RoundingMode.DOWN);
        } else if(dp.getRound().equals("c")) {
            df.setRoundingMode(RoundingMode.CEILING);
        }

        return df;
    }


    /**
     * method name : getIntDecimalFormat<b/>
     * method Desc : Integer 타입 숫자 formatting
     *
     * @param zero 값이 없을때 0 보여줄지 여부
     * @return
     */
    public static DecimalFormat getIntDecimalFormat(boolean zero) {
        String pattern = null;
        if (zero) {
            pattern = "###,###,###,##0";
        } else {
            pattern = "###,###,###,###";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df;
    }

    /**
     * method name : ConvertNumberToInteger<b/>
     * method Desc : Oracle DB 에서 원본 데이터가 Integer 일 경우 Hibernate 에서 리턴되는 타입이 BigDecimal 이므로 Integer 로 변환을 시켜준다.
     *
     * @param number
     * @return
     */
    public static Integer ConvertNumberToInteger(Object number) {

        if (number == null) {
            return null;
        } else if (number instanceof String) {
            return Integer.valueOf((String)number);
        } else {
            return ((Number)number).intValue();
        }
    }

    /**
     * method name : ConvertNumberToDouble<b/>
     * method Desc : Oracle DB 에서 원본 데이터가 Double 일 경우 Hibernate 에서 리턴되는 타입이 BigDecimal 이므로 Double 로 변환을 시켜준다.
     *
     * @param number
     * @return
     */
    public static Double ConvertNumberToDouble(Object number) {

        if (number == null) {
            return null;
        } else if (number instanceof String) {
            return Double.valueOf((String)number);
        } else {
            return ((Number)number).doubleValue();
        }
    }

    /**
     * method name : ConvertNumberToLong<b/>
     * method Desc : Oracle DB 에서 원본 데이터가 Long 일 경우 Hibernate 에서 리턴되는 타입이 BigDecimal 이므로 Long 으로 변환을 시켜준다.
     *
     * @param number
     * @return
     */
    public static Long ConvertNumberToLong(Object number) {

        if (number == null) {
            return null;
        } else if (number instanceof String) {
            return Long.valueOf((String)number);
        } else {
            return ((Number)number).longValue();
        }
    }

    /**
     * 
     * method name : getMDStyle<b/>
     * method Desc : 공급사에 맞게 설정된 MdPattern을 가져와 그 형식에 맞춘 후 소수점만 제거한 값을 반환한다.
     *
     * @param dp
     * @return
     */
    public static DecimalFormat getMDStyle(DecimalPattern dp) {     
        DecimalPattern copyDP = new DecimalPattern();
        copyDP.setPattern(dp.getPattern());
        String mdPattern = copyDP.getPattern();
        
        int commaPos = mdPattern.indexOf(",");
        int dotPos = mdPattern.indexOf(".");
        int dot = -1;
        if (commaPos > dotPos)
            dot = mdPattern.indexOf(",");
        else
            dot = mdPattern.indexOf(".");

        if(dot != -1)
            copyDP.setPattern(mdPattern.substring(0,dot));
        return getDecimalFormat(copyDP);
    }

}
