package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2016</p>
 * 선불 STS 연동 로그
 */

@Getter
@Setter
@NoArgsConstructor
public class EcgSTSLog {

//	public EcgSTSLogPk id;

    private String cmd;

    private String meterNumber;

    private String createDate;

    private long asyncTrId;

    private int seq;

    private Integer payMode;
    
    private Integer result;
    
    private String failReason;
    
    private String resultDate;
    
    private String tokenDate;
    
    private String token;
    
    private Double chargedCredit;
    
    private String getDate;
    
    private Integer emergencyCreditMode;
    
    private Integer emergencyCreditDay;
    
    private Double emergencyCreditAmount;
    
    private Integer tariffMode;
    
    private Integer tariffKind;
    
    private Integer tariffCount;
    
    private String condLimit1;
    
    private String condLimit2;
    
    private String consumption;
    
    private String fixedRate;

    private String varRate;
    
    private String condRate1;
    
    private String condRate2;
    
    private String tariffDate;
    
    private String remainingCreditDate;
    
    private Double remainingCredit;
    
    private String netChargeYyyymm;
    
    private Integer netChargeMonthConsumption;
    
    private Double netChargeMonthCost;
    
    private String netChargeYyyymmdd;
    
    private Integer netChargeDayConsumption;
    
    private Double netChargeDayCost;
    
    private Integer fcMode;
    
    private String friendlyDate;
    
    private String friendlyDayType;
    
    private String friendlyFromHHMM;
    
    private String friendlyEndHHMM;
    
    private Double friendlyCreditAmount;
    
    private String stsNumber;
    
    private String kct1;
    
    private String kct2;
    
    private Integer channel;
    
    private Integer panId;
    
    private String activeEnergyCharge;
    
    private String govLey;
    
    private String streetLightLevy;
    
    private String vat;
    
    private String lifeLineSubsidy;
    
    private String switchTime;

    private String nhil;

    private String getFund;

    private String decimalControl;
}
