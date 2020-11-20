package com.nuri.etk.entity.aimir;

import com.nuri.etk.entity.aimir.VendorCasher;

/**
 * 선불내역
 *  - 선불정보는 Contract 테이블에 갱신되며, 갱신될때마다 PrepaymentLog에 기록된다.
 */

public class PrepaymentLog {

    private Long id;
    
    private Customer customer;
    
    private Integer customerId;

    private VendorCasher vendorCasher;
    
    private Integer vendorCasherId;
    
    private Contract contract;
    
    private Integer contractId;
    
    private String keyNum;          //지불이 선불일 경우 카드키넘버
    
    private Code keyType;           //지불=선불 카드타입
    
    private Integer keyTypeCodeId;
    
    private Double chargedCredit;       //충전한 금액

    private Operator operator;
    
    private Integer operatorId;     // 결제자 접속 id
    
    private String lastTokenDate;   //마지막 충전한 시간
    private String lastTokenId;     //충전 세션키
    private Integer emergencyCreditAvailable;   //
    
    private String descr;       //비고
    
    private Double powerLimit;
    
    private Double preBalance;
    
    private Double balance;
    
    private String authCode;

    private Code municipalityCode;
    
    private Integer municipalityCodeId;
    
    private Double usedCost;
    
    private Double usedConsumption;
    
    private Double preArrears;
    
    private Double arrears;

    private Double chargedArrears;
    
    private Double initCredit;
    
    private Double monthlyTotalAmount;
    
    private Double monthlyPaidAmount;

    private Double monthlyServiceCharge;
    
    private Double publicLevy;
    
    private Double govLevy;
    
    private Double vat;
    
    private Double vatOnSubsidy;

    private Double subsidy;
    
    private Double lifeLineSubsidy;
    
    private Double additionalSubsidy;
    
    private Integer daysFromCharge;
    
    private String partpayInfo;
    
    private Boolean isCanceled;
    
    private String cancelDate;
    
    private String lastLpTime;
    
    private Location location;      //공급지역
    
    private Integer locationId;
    
    private TariffType tariffIndex;     //계약종별entity
    
    private Integer tariffIndexId;
    
    private Code payType;   // cash or Check
    
    private Integer payTypeCodeId;
    
    private String cancelReason;
    
    private String debtRef;
    
    private String chequeNo;
    
    private Integer bankOfficeCode;
    
    private Double utilityRelief;
    
    private Double activeEnergyImport;
    
    private Double activeEnergyExport;
    
    private String token;
    
    private String cancelToken;
    
    private Double nhil;
    
    private Double getFund;
    
    public Double getUsedCost() {
        return usedCost;
    }
    public void setUsedCost(Double usedCost) {
        this.usedCost = usedCost;
    }
    public Double getUsedConsumption() {
        return usedConsumption;
    }
    public void setUsedConsumption(Double usedConsumption) {
        this.usedConsumption = usedConsumption;
    }
    
    public String getAuthCode() {
        return authCode;
    }
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    
    public Code getMunicipalityCode() {
        return municipalityCode;
    }
    public void setMunicipalityCode(Code municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public Double getPreBalance() {
        return preBalance;
    }
    public void setPreBalance(Double preBalance) {
        this.preBalance = preBalance;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public VendorCasher getVendorCasher() {
        return vendorCasher;
    }
    public void setVendorCasher(VendorCasher vendorCasher) {
        this.vendorCasher = vendorCasher;
    }
    public Integer getVendorCasherId() {
        return vendorCasherId;
    }
    public void setVendorCasherId(Integer vendorCasherId) {
        this.vendorCasherId = vendorCasherId;
    }
    public Contract getContract() {
        return contract;
    }
    public String getCancelReason() {
        return cancelReason;
    }
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public String getKeyNum() {
        return keyNum;
    }
    public void setKeyNum(String keyNum) {
        this.keyNum = keyNum;
    }
    
    public Code getKeyType() {
        return keyType;
    }
    public void setKeyType(Code keyType) {
        this.keyType = keyType;
    }
    public Double getChargedCredit() {
        return chargedCredit;
    }
    public void setChargedCredit(Double chargedCredit) {
        this.chargedCredit = chargedCredit;
    }
    public String getLastTokenDate() {
        return lastTokenDate;
    }
    public void setLastTokenDate(String lastTokenDate) {
        this.lastTokenDate = lastTokenDate;
    }
    public String getLastTokenId() {
        return lastTokenId;
    }
    public void setLastTokenId(String lastTokenId) {
        this.lastTokenId = lastTokenId;
    }
    public Integer getEmergencyCreditAvailable() {
        return emergencyCreditAvailable;
    }
    public void setEmergencyCreditAvailable(Integer emergencyCreditAvailable) {
        this.emergencyCreditAvailable = emergencyCreditAvailable;
    }
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
    
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getContractId() {
        return contractId;
    }
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
    public Integer getKeyTypeCodeId() {
        return keyTypeCodeId;
    }
    public void setKeyTypeCodeId(Integer keyTypeCodeId) {
        this.keyTypeCodeId = keyTypeCodeId;
    }
    public Integer getMunicipalityCodeId() {
        return municipalityCodeId;
    }
    public void setMunicipalityCodeId(Integer municipalityCodeId) {
        this.municipalityCodeId = municipalityCodeId;
    }
    public Double getPreArrears() {
        return preArrears;
    }
    public void setPreArrears(Double preArrears) {
        this.preArrears = preArrears;
    }
    public Double getArrears() {
        return arrears;
    }
    public void setArrears(Double arrears) {
        this.arrears = arrears;
    }
    public Operator getOperator() {
        return operator;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    public Integer getOperatorId() {
        return operatorId;
    }
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
    public Double getChargedArrears() {
        return chargedArrears;
    }
    public void setChargedArrears(Double chargedArrears) {
        this.chargedArrears = chargedArrears;
    }

    public void setPowerLimit(Double powerLimit) {
        this.powerLimit = powerLimit;
    }
    public Double getPowerLimit() {
        return powerLimit;
    }
    
    public Double getInitCredit() {
        return initCredit;
    }
    public void setInitCredit(Double initCredit) {
        this.initCredit = initCredit;
    }

    public Double getMonthlyTotalAmount() {
        return monthlyTotalAmount;
    }
    public void setMonthlyTotalAmount(Double monthlyTotalAmount) {
        this.monthlyTotalAmount = monthlyTotalAmount;
    }
    public Double getMonthlyPaidAmount() {
        return monthlyPaidAmount;
    }
    public void setMonthlyPaidAmount(Double monthlyPaidAmount) {
        this.monthlyPaidAmount = monthlyPaidAmount;
    }
    public Double getMonthlyServiceCharge() {
        return monthlyServiceCharge;
    }
    public void setMonthlyServiceCharge(Double monthlyServiceCharge) {
        this.monthlyServiceCharge = monthlyServiceCharge;
    }
    public Double getPublicLevy() {
        return publicLevy;
    }
    public void setPublicLevy(Double publicLevy) {
        this.publicLevy = publicLevy;
    }
    public Double getGovLevy() {
        return govLevy;
    }
    public void setGovLevy(Double govLevy) {
        this.govLevy = govLevy;
    }
    public Double getVat() {
        return vat;
    }
    public void setVat(Double vat) {
        this.vat = vat;
    }
    public Double getVatOnSubsidy() {
        return vatOnSubsidy;
    }
    public void setVatOnSubsidy(Double vatOnSubsidy) {
        this.vatOnSubsidy = vatOnSubsidy;
    }
    public Double getSubsidy() {
        return subsidy;
    }
    public void setSubsidy(Double subsidy) {
        this.subsidy = subsidy;
    }
    public Double getLifeLineSubsidy() {
        return lifeLineSubsidy;
    }
    public void setLifeLineSubsidy(Double lifeLineSubsidy) {
        this.lifeLineSubsidy = lifeLineSubsidy;
    }
    public Double getAdditionalSubsidy() {
        return additionalSubsidy;
    }
    public void setAdditionalSubsidy(Double additionalSubsidy) {
        this.additionalSubsidy = additionalSubsidy;
    }
    public Integer getDaysFromCharge() {
        return daysFromCharge;
    }
    public void setDaysFromCharge(Integer daysFromCharge) {
        this.daysFromCharge = daysFromCharge;
    }
    public String getPartpayInfo() {
        return partpayInfo;
    }
    public void setPartpayInfo(String partpayInfo) {
        this.partpayInfo = partpayInfo;
    }
    public Boolean getIsCanceled() {
        return isCanceled;
    }
    public void setIsCanceled(Boolean isCanceled) {
        this.isCanceled = isCanceled;
    }
    public String getCancelDate() {
        return cancelDate;
    }
    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }
    
    public String getLastLpTime() {
        return lastLpTime;
    }
    public void setLastLpTime(String lastLpTime) {
        this.lastLpTime = lastLpTime;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
    public TariffType getTariffIndex() {
        return tariffIndex;
    }
    public void setTariffIndex(TariffType tariffIndex) {
        this.tariffIndex = tariffIndex;
    }
    public Integer getTariffIndexId() {
        return tariffIndexId;
    }
    public void setTariffIndexId(Integer tariffIndexId) {
        this.tariffIndexId = tariffIndexId;
    }
    
    public Code getPayType() {
        return payType;
    }
    public void setPayType(Code payType) {
        this.payType = payType;
    }
    public Integer getPayTypeCodeId() {
        return payTypeCodeId;
    }
    public void setPayTypeCodeId(Integer payTypeCodeId) {
        this.payTypeCodeId = payTypeCodeId;
    }
    
    public String getDebtRef() {
        return debtRef;
    }
    public void setDebtRef(String debtRef) {
        this.debtRef = debtRef;
    }
    
    public String getChequeNo() {
        return chequeNo;
    }
    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }
    
    public Integer getBankOfficeCode() {
        return bankOfficeCode;
    }
    public void setBankOfficeCode(Integer bankOfficeCode) {
        this.bankOfficeCode = bankOfficeCode;
    }
    
    public Double getUtilityRelief() {
        return utilityRelief;
    }
    public void setUtilityRelief(Double utilityRelief) {
        this.utilityRelief = utilityRelief;
    }
    
    public Double getActiveEnergyImport() {
        return activeEnergyImport;
    }
    public void setActiveEnergyImport(Double activeEnergyImport) {
        this.activeEnergyImport = activeEnergyImport;
    }
    public Double getActiveEnergyExport() {
        return activeEnergyExport;
    }
    public void setActiveEnergyExport(Double activeEnergyExport) {
        this.activeEnergyExport = activeEnergyExport;
    }
    public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCancelToken() {
		return cancelToken;
	}
	public void setCancelToken(String cancelToken) {
		this.cancelToken = cancelToken;
	}
	
	public Double getNhil() {
        return nhil;
    }
    public void setNhil(Double nhil) {
        this.nhil = nhil;
    }
    public Double getGetFund() {
        return getFund;
    }
    public void setGetFund(Double getFund) {
        this.getFund = getFund;
    }
}

