package com.nuri.etk.entity.aimir;

import java.io.Serializable;

/**
 * Copyright NuriTelecom Co.Ltd. since 2009
 *
 * 시스템에서 숫자 (정수,소수, 통화 ) 등의 정보를 표현할 때 Decimal Format과 절삭,반올림 등의 적용을 표현한 클래스 주로
 * 공급사 정보(Supplier) 에서 해당 클래스를 참조하여 사용한다.
 */
public class DecimalPattern implements Serializable {

    private String pattern;
    private String round;
    private String groupingSeperator;
    private String decimalSeperator;

    public DecimalPattern() {
    }

    public DecimalPattern(String pattern, String round) {
        this.pattern = pattern;
        this.round = round;
        this.groupingSeperator = ",";
        this.decimalSeperator = ".";
    }

    public DecimalPattern(String pattern, String round, String groupingSeperator, String decimalSeperator) {
        this.pattern = pattern;
        this.round = round;
        this.groupingSeperator = groupingSeperator;
        this.decimalSeperator = decimalSeperator;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getGroupingSeperator() {
        if(groupingSeperator != null && !groupingSeperator.equals("")) {
            return groupingSeperator;
        } else {
            return ",";
        }
    }

    public void setGroupingSeperator(String groupingSeperator) {
        this.groupingSeperator = groupingSeperator;
    }

    public String getDecimalSeperator() {
        if(decimalSeperator != null && !decimalSeperator.equals("")) {
            return decimalSeperator;
        } else {
            return ".";
        }
    }

    public void setDecimalSeperator(String decimalSeperator) {
        this.decimalSeperator = decimalSeperator;
    }
}
