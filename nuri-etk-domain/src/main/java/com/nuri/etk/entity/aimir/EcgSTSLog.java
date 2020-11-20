package com.nuri.etk.entity.aimir;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2016</p>
 * 선불 STS 연동 로그
 */
public class EcgSTSLog {

	public EcgSTSLogPk id;
    
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

    
    public EcgSTSLog() {
        id = new EcgSTSLogPk();
    }
    
    public EcgSTSLogPk getId() {
        return id;
    }

    public void setId(EcgSTSLogPk id) {
        this.id = id;
    }

    public void setCmd(String cmd) {
        id.setCmd(cmd);
    }
    
    public String getCmd() {
        return id.getCmd();
    }
    
    public void setMeterNumber(String meterNumber) {
        id.setMeterNumber(meterNumber);
    }
    
    public void setCreateDate(String createDate) {
        id.setCreateDate(createDate);
    }
    
    public String getCreateDate() {
        return id.getCreateDate();
    }
    
    public void setSeq(int seq) {
        id.setSeq(seq);
    }
    
    public int getSeq() {
        return id.getSeq();
    }
    
    public int getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public int getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(String tokenDate) {
        this.tokenDate = tokenDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getChargedCredit() {
        return chargedCredit;
    }

    public void setChargedCredit(Double chargedCredit) {
        this.chargedCredit = chargedCredit;
    }

    public String getGetDate() {
        return getDate;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
    }

    public int getEmergencyCreditMode() {
        return emergencyCreditMode;
    }

    public void setEmergencyCreditMode(Integer emergencyCreditMode) {
        this.emergencyCreditMode = emergencyCreditMode;
    }

    public int getEmergencyCreditDay() {
        return emergencyCreditDay;
    }

    public void setEmergencyCreditDay(Integer emergencyCreditDay) {
        this.emergencyCreditDay = emergencyCreditDay;
    }
    
    public double getEmergencyCreditAmount() {
        return emergencyCreditAmount;
    }

    public void setEmergencyCreditAmount(double emergencyCreditAmount) {
        this.emergencyCreditAmount = emergencyCreditAmount;
    }

    public int getTariffMode() {
        return tariffMode;
    }

    public void setTariffMode(Integer tariffMode) {
        this.tariffMode = tariffMode;
    }

    public int getTariffKind() {
        return tariffKind;
    }

    public void setTariffKind(Integer tariffKind) {
        this.tariffKind = tariffKind;
    }

    public int getTariffCount() {
        return tariffCount;
    }

    public void setTariffCount(Integer tariffCount) {
        this.tariffCount = tariffCount;
    }

    public String getTariffDate() {
        return tariffDate;
    }

    public void setTariffDate(String tariffDate) {
        this.tariffDate = tariffDate;
    }
    
    public String getConsumption() {
		return consumption;
	}

	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}

    public String getCondLimit1() {
		return condLimit1;
	}

	public void setCondLimit1(String condLimit1) {
		this.condLimit1 = condLimit1;
	}

	public String getCondLimit2() {
		return condLimit2;
	}

	public void setCondLimit2(String condLimit2) {
		this.condLimit2 = condLimit2;
	}

	public String getFixedRate() {
		return fixedRate;
	}

	public void setFixedRate(String fixedRate) {
		this.fixedRate = fixedRate;
	}

	public String getVarRate() {
		return varRate;
	}

	public void setVarRate(String varRate) {
		this.varRate = varRate;
	}

	public String getCondRate1() {
		return condRate1;
	}

	public void setCondRate1(String condRate1) {
		this.condRate1 = condRate1;
	}

	public String getCondRate2() {
		return condRate2;
	}

	public void setCondRate2(String condRate2) {
		this.condRate2 = condRate2;
	}
	
    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public long getAsyncTrId() {
        return id.getAsyncTrId();
    }

    public void setAsyncTrId(long asyncTrId) {
        id.setAsyncTrId(asyncTrId);
    }

    public String getRemainingCreditDate() {
        return remainingCreditDate;
    }

    public void setRemainingCreditDate(String remainingCreditDate) {
        this.remainingCreditDate = remainingCreditDate;
    }

    public Double getRemainingCredit() {
        return remainingCredit;
    }

    public void setRemainingCredit(Double remainingCredit) {
        this.remainingCredit = remainingCredit;
    }

    public String getNetChargeYyyymm() {
        return netChargeYyyymm;
    }

    public void setNetChargeYyyymm(String netChargeYyyymm) {
        this.netChargeYyyymm = netChargeYyyymm;
    }

    public double getNetChargeMonthConsumption() {
        return netChargeMonthConsumption;
    }

    public void setNetChargeMonthConsumption(Integer netChargeMonthConsumption) {
        this.netChargeMonthConsumption = netChargeMonthConsumption;
    }

    public double getNetChargeMonthCost() {
        return netChargeMonthCost;
    }

    public void setNetChargeMonthCost(Double netChargeMonthCost) {
        this.netChargeMonthCost = netChargeMonthCost;
    }

    public String getNetChargeYyyymmdd() {
        return netChargeYyyymmdd;
    }

    public void setNetChargeYyyymmdd(String netChargeYyyymmdd) {
        this.netChargeYyyymmdd = netChargeYyyymmdd;
    }

    public double getNetChargeDayConsumption() {
        return netChargeDayConsumption;
    }

    public void setNetChargeDayConsumption(Integer netChargeDayConsumption) {
        this.netChargeDayConsumption = netChargeDayConsumption;
    }

    public double getNetChargeDayCost() {
        return netChargeDayCost;
    }

    public void setNetChargeDayCost(Double netChargeDayCost) {
        this.netChargeDayCost = netChargeDayCost;
    }

    public int getFcMode() {
        return fcMode;
    }

    public void setFcMode(Integer fcMode) {
        this.fcMode = fcMode;
    }

    public String getFriendlyDate() {
        return friendlyDate;
    }

    public void setFriendlyDate(String friendlyDate) {
        this.friendlyDate = friendlyDate;
    }

    public String getFriendlyDayType() {
        return friendlyDayType;
    }

    public void setFriendlyDayType(String friendlyDayType) {
        this.friendlyDayType = friendlyDayType;
    }

    public String getFriendlyFromHHMM() {
        return friendlyFromHHMM;
    }

    public void setFriendlyFromHHMM(String friendlyFromHHMM) {
        this.friendlyFromHHMM = friendlyFromHHMM;
    }

    public String getFriendlyEndHHMM() {
        return friendlyEndHHMM;
    }

    public void setFriendlyEndHHMM(String friendlyEndHHMM) {
        this.friendlyEndHHMM = friendlyEndHHMM;
    }
    
    public double getFriendlyCreditAmount() {
        return friendlyCreditAmount;
    }

    public void setFriendlyCreditAmount(Double friendlyCreditAmount) {
        this.friendlyCreditAmount = friendlyCreditAmount;
    }
    
    public String getStsNumber() {
		return stsNumber;
	}

	public void setStsNumber(String stsNumber) {
		this.stsNumber = stsNumber;
	}

	public String getKct1() {
		return kct1;
	}

	public void setKct1(String kct1) {
		this.kct1 = kct1;
	}

	public String getKct2() {
		return kct2;
	}

	public void setKct2(String kct2) {
		this.kct2 = kct2;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public Integer getPanId() {
		return panId;
	}

	public void setPanId(Integer panId) {
		this.panId = panId;
	}
	
	public String getActiveEnergyCharge() {
		return activeEnergyCharge;
	}

	public void setActiveEnergyCharge(String activeEnergyCharge) {
		this.activeEnergyCharge = activeEnergyCharge;
	}
	
	public String getGovLey() {
		return govLey;
	}

	public void setGovLey(String govLey) {
		this.govLey = govLey;
	}
	
	public String getStreetLightLevy() {
		return streetLightLevy;
	}

	public void setStreetLightLevy(String streetLightLevy) {
		this.streetLightLevy = streetLightLevy;
	}
	
	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}
	
	public String getLifeLineSubsidy() {
		return lifeLineSubsidy;
	}

	public void setLifeLineSubsidy(String lifeLineSubsidy) {
		this.lifeLineSubsidy = lifeLineSubsidy;
	}
	
	public String getSwitchTime() {
		return switchTime;
	}

	public void setSwitchTime(String switchTime) {
		this.switchTime = switchTime;
	}

    public String getNhil() {
        return nhil;
    }

    public void setNhil(String nhil) {
        this.nhil = nhil;
    }

    public String getGetFund() {
        return getFund;
    }

    public void setGetFund(String getFund) {
        this.getFund = getFund;
    }

    public String getDecimalControl() { return decimalControl; }

    public void setDecimalControl(String decimalControl) { this.decimalControl = decimalControl; }
}
