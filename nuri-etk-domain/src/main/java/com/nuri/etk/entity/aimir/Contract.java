package com.nuri.etk.entity.aimir;

import java.util.HashSet;
import java.util.Set;

import com.nuri.etk.entity.aimir.Meter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>에너지 사용자 (Energy Consumer)와 Utility(에너지 공급사) 간의 계약과 관련된 정보</p>
 * 계약번호(Contract Number)가 유일한 식별자가 되며
 * 계약용량, 공급상태, 과금과 관련된 정보를 가지고 있다.<br>
 * 에너지 사용자가 여러개의 에너지원을 가질수 있다. 이 관계는 Customer와 Contract의 관계로 존재한다.<br>
 * 에너지 계약정보와 미터 (에너지 계량)와 1:1관계가 존재한다.
 *
 * 각 단위 사용량별 탄소 배출량 정보등의 정보를 가진다.<br>
 * 고객과 공급사간의 계약관계를 표현하지만 미터별로 다를 수 있기 때문에 미터와의 관계로 표현한다. <br>
 *
 * 계약 정보에는 <br>
 * - 계약종류 (공급사 코드 참고) <br>
 * - 결제종류 (후불, 선불) <br>
 *     선불시 잔액  <br>
 * - 계약 에너지 사용 여부 <br>
 * - 신용 모드 (credit, dept) <br>
 * - 기타 (할인률, 대가족제도, 세자녀 이상 등) <br>
 *
 * 선결제 <br>
 * 사용량과 tariff 정보를 이용하여 사용금액을 계산하여 저장한다. 잔액이 마이너스(debt) 상태가 되면 경고를 보내고 공급을 차단한다. <br>
 * 공급 차단 오퍼레이션이 안될 수도 있기 때문에 재시도할 수 있도록 한다. <br>
 */

@Getter
@Setter
@NoArgsConstructor
public class Contract {

	private Integer id;
	
    private String contractNumber;

	private Customer customer;
	
	private String customerId;

	private String customerName;

	private Supplier supplier;
	
	private Integer supplierId;
	
	private Code serviceTypeCode;
	
	private Integer serviceTypeCodeId;
	
	private Integer contractIndex;
	
	private Meter meter;
	
	private Integer meterId;
	
	private String preMdsId;
	
	private Integer billDate;
	
	private Location location;		//공급지역
	
	private Integer locationId;
	
	private TariffType tariffIndex;		//계약종별entity
	
	private Integer tariffIndexId;
	
	private Double contractDemand;		//계약용량
	
	private Code status;			//공급상태 : 2.1.*
	
	private Integer statusCodeId;
	
	private Code creditType;		//지불타입(선/후불)
	
	private Integer creditTypeCodeId;
	
	private Code creditStatus;		//선불일경우 지불상태
	
	private Integer creditStatusCodeId;
	
	private Integer prepaymentThreshold;	//선불일 경우 잔액최소임계치
	private Double prepaymentPowerDelay;   //선불인 경우 차단에 도달하는 kWh
	private String emergencyCreditStartTime;//emergency credit start date time

	////////////////////////////////////////////////
	//이하, 선불 고객 관련 속성 START
	////////////////////////////////////////////////	
	private String keyNum;			//지불이 선불일 경우 카드키넘버
	
	private Code keyType;			//지불=선불 카드타입
	
	private Integer keyTypeCodeId;

	private Double chargedCredit;		//선불일 경우 충전총액
	private Double currentCredit;		//선불일 경우 잔액
	
	private String lastTokenDate;	//마지막 충전한 시간
	private String lastTokenId;		//충전 세션키
	
	private Double oweCredit;
	
	private Double oweThreshold;
	
	private Boolean emergencyCreditAvailable;	//
	
	private Boolean emergencyCreditAutoChange;
	
	private Integer emergencyCreditMaxDuration;
	private Integer lastChargeCnt;		//최종 충전횟수
	
	private String contractDate;

	private Double contractPrice;
	
	private Double threshold1;
	
    private Double threshold2;
	
    private Double threshold3;

	private Set<PrepaymentAuthDevice> devices = new HashSet<PrepaymentAuthDevice>(0);

	private Integer notificationPeriod;

	private Integer notificationInterval;

	private Integer notificationTime;

	private Boolean notificationWeeklyMon;

	private Boolean notificationWeeklyTue;
	
	private Boolean notificationWeeklyWed;

	private Boolean notificationWeeklyThu;

	private Boolean notificationWeeklyFri;
	
	private Boolean notificationWeeklySat;
	
	private Boolean notificationWeeklySun;

	private String lastNotificationDate;
	
	private String lastCommSendSMSDate;
	
	private Boolean isRetrySMS;
	
	private String smsNumber;

	private String delayDay;
    
	private String applyDate;

	private Double oldArrears;
	
	private Double currentArrears;

	/**
	 * 분할납부시 사용
	 * FIRSTARREARS, ARREARS_CONTRACT_COUNT, ARREARS_PAYMENT_COUNT
	 * 
	 */
	private Double firstArrears;
	
	private Integer arrearsContractCount;
	
	private Integer arrearsPaymentCount;

	private Meter distTrfmrSubstationMeter_A;
	
	private Code sic;
	
	private Integer sicCodeId;
	
	private String receiptNumber;
	
	private Double amountPaid;
	
	private String barcode;

	private String prepayStartTime;

	private Boolean chargeAvailable;

    private String address1;
    
    private String address2;
    
    private String address3;
    
    private String servicePointId;
    
	private Operator operator;
	
	private Integer operatorId;
    
    private Integer cashPoint;
	
    private Boolean isSts;
	
    private Integer stsId;
	
	private Boolean isNetMetering;
	
	 private String changeDate;
	 
	 private String changeReason;

    private String userMemo;

	 
	/*public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getDelayDay() {
		return delayDay;
	}
	public void setDelayDay(String delayDay) {
		this.delayDay = delayDay;
	}
	////////////////////////////////////////////////
	//상기, 선불 고객 관련 속성 END
	////////////////////////////////////////////////
	public String getLastNotificationDate() {
		return lastNotificationDate;
	}
	public void setLastNotificationDate(String lastNotificationDate) {
		this.lastNotificationDate = lastNotificationDate;
	}
	
	public Set<PrepaymentAuthDevice> getDevices() {
		return devices;
	}
	public void setDevices(Set<PrepaymentAuthDevice> devices) {
		this.devices = devices;
	}
	
	public Integer getNotificationPeriod() {
		return notificationPeriod;
	}
	public void setNotificationPeriod(Integer notificationPeriod) {
		this.notificationPeriod = notificationPeriod;
	}
	public Integer getNotificationInterval() {
		return notificationInterval;
	}
	public void setNotificationInterval(Integer notificationInterval) {
		this.notificationInterval = notificationInterval;
	}
	public Integer getNotificationTime() {
		return notificationTime;
	}
	public void setNotificationTime(Integer notificationTime) {
		this.notificationTime = notificationTime;
	}
	public Boolean getNotificationWeeklyMon() {
		return notificationWeeklyMon;
	}
	public void setNotificationWeeklyMon(Boolean notificationWeeklyMon) {
		this.notificationWeeklyMon = notificationWeeklyMon;
	}
	public Boolean getNotificationWeeklyTue() {
		return notificationWeeklyTue;
	}
	public void setNotificationWeeklyTue(Boolean notificationWeeklyTue) {
		this.notificationWeeklyTue = notificationWeeklyTue;
	}
	public Boolean getNotificationWeeklyWed() {
		return notificationWeeklyWed;
	}
	public void setNotificationWeeklyWed(Boolean notificationWeeklyWed) {
		this.notificationWeeklyWed = notificationWeeklyWed;
	}
	public Boolean getNotificationWeeklyThu() {
		return notificationWeeklyThu;
	}
	public void setNotificationWeeklyThu(Boolean notificationWeeklyThu) {
		this.notificationWeeklyThu = notificationWeeklyThu;
	}
	public Boolean getNotificationWeeklyFri() {
		return notificationWeeklyFri;
	}
	public void setNotificationWeeklyFri(Boolean notificationWeeklyFri) {
		this.notificationWeeklyFri = notificationWeeklyFri;
	}
	public Boolean getNotificationWeeklySat() {
		return notificationWeeklySat;
	}
	public void setNotificationWeeklySat(Boolean notificationWeeklySat) {
		this.notificationWeeklySat = notificationWeeklySat;
	}
	public Boolean getNotificationWeeklySun() {
		return notificationWeeklySun;
	}
	public void setNotificationWeeklySun(Boolean notificationWeeklySun) {
		this.notificationWeeklySun = notificationWeeklySun;
	}
	public String getSmsNumber() {
		return smsNumber;
	}
	public void setSmsNumber(String smsNumber) {
		this.smsNumber = smsNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public Double getContractPrice() {
		return contractPrice;
	}
	public void setContractPrice(Double contractPrice) {
		this.contractPrice = contractPrice;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Code getServiceTypeCode() {
		return serviceTypeCode;
	}
	public void setServiceTypeCode(Code serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
	}
	public Integer getContractIndex() {
		return contractIndex;
	}
	public void setContractIndex(Integer contractIndex) {
		this.contractIndex = contractIndex;
	}
	
	public Meter getMeter() {
		return meter;
	}
	public void setMeter(Meter meter) {
		this.meter = meter;
	}	
	
	public Integer getBillDate() {
		return billDate;
	}
	public void setBillDate(Integer billDate) {
		this.billDate = billDate;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public TariffType getTariffIndex() {
		return tariffIndex;
	}
	public void setTariffIndex(TariffType tariffIndex) {
		this.tariffIndex = tariffIndex;
	}
	public Double getContractDemand() {
		return contractDemand;
	}
	public void setContractDemand(Double contractDemand) {
		this.contractDemand = contractDemand;
	}
	
	public Code getStatus() {
		return status;
	}
	public void setStatus(Code status) {
		this.status = status;
	}
	
	public Code getCreditType() {
		return creditType;
	}
	public void setCreditType(Code creditType) {
		this.creditType = creditType;
	}
	
	public Code getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(Code creditStatus) {
		this.creditStatus = creditStatus;
	}
	public Integer getPrepaymentThreshold() {
		return prepaymentThreshold;
	}
	public void setPrepaymentThreshold(Integer prepaymentThreshold) {
		this.prepaymentThreshold = prepaymentThreshold;
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
	public Double getCurrentCredit() {
		return currentCredit;
	}
	public void setCurrentCredit(Double currentCredit) {
		this.currentCredit = currentCredit;
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
	public Boolean getEmergencyCreditAvailable() {
		return emergencyCreditAvailable;
	}
	public void setEmergencyCreditAvailable(Boolean emergencyCreditAvailable) {
		this.emergencyCreditAvailable = emergencyCreditAvailable;
	}
	public Integer getLastChargeCnt() {
		return lastChargeCnt;
	}
	public void setLastChargeCnt(Integer lastChargeCnt) {
		this.lastChargeCnt = lastChargeCnt;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	public void setEmergencyCreditAutoChange(Boolean emergencyCreditAutoChange) {
		this.emergencyCreditAutoChange = emergencyCreditAutoChange;
	}
	public Boolean getEmergencyCreditAutoChange() {
		return emergencyCreditAutoChange;
	}
	public void setEmergencyCreditMaxDuration(Integer emergencyCreditMaxDuration) {
		this.emergencyCreditMaxDuration = emergencyCreditMaxDuration;
	}
	public Integer getEmergencyCreditMaxDuration() {
		return emergencyCreditMaxDuration;
	}
	public void setPrepaymentPowerDelay(Double prepaymentPowerDelay) {
		this.prepaymentPowerDelay = prepaymentPowerDelay;
	}
	public Double getPrepaymentPowerDelay() {
		return prepaymentPowerDelay;
	}
	public void setEmergencyCreditStartTime(String emergencyCreditStartTime) {
		this.emergencyCreditStartTime = emergencyCreditStartTime;
	}
	public String getEmergencyCreditStartTime() {
		return emergencyCreditStartTime;
	}
	
	public Code getSic() {
        return sic;
    }
    public void setSic(Code sic) {
        this.sic = sic;
    }
    
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    public Integer getMeterId() {
        return meterId;
    }
    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }
	public String getPreMdsId() {
		return preMdsId;
	}
	public void setPreMdsId(String preMdsId) {
		this.preMdsId = preMdsId;
	}
    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
    public Integer getTariffIndexId() {
        return tariffIndexId;
    }
    public void setTariffIndexId(Integer tariffIndexId) {
        this.tariffIndexId = tariffIndexId;
    }
    public Integer getServiceTypeCodeId() {
        return serviceTypeCodeId;
    }
    public void setServiceTypeCodeId(Integer serviceTypeCodeId) {
        this.serviceTypeCodeId = serviceTypeCodeId;
    }
    public Integer getStatusCodeId() {
        return statusCodeId;
    }
    public void setStatusCodeId(Integer statusCodeId) {
        this.statusCodeId = statusCodeId;
    }
    public Integer getCreditTypeCodeId() {
        return creditTypeCodeId;
    }
    public void setCreditTypeCodeId(Integer creditTypeCodeId) {
        this.creditTypeCodeId = creditTypeCodeId;
    }
    public Integer getCreditStatusCodeId() {
        return creditStatusCodeId;
    }
    public void setCreditStatusCodeId(Integer creditStatusCodeId) {
        this.creditStatusCodeId = creditStatusCodeId;
    }
    public Integer getKeyTypeCodeId() {
        return keyTypeCodeId;
    }
    public void setKeyTypeCodeId(Integer keyTypeCodeId) {
        this.keyTypeCodeId = keyTypeCodeId;
    }
    public Integer getSicCodeId() {
        return sicCodeId;
    }
    public void setSicCodeId(Integer sicCodeId) {
        this.sicCodeId = sicCodeId;
    }
    public Double getOldArrears() {
		return oldArrears;
	}
	public void setOldArrears(Double oldArrears) {
		this.oldArrears = oldArrears;
	}
    public Double getCurrentArrears() {
		return currentArrears;
	}
	public void setCurrentArrears(Double arrears) {
		this.currentArrears = arrears;
	}
	public Double getFirstArrears() {
		return firstArrears;
	}
	public void setFirstArrears(Double firstArrears) {
		this.firstArrears = firstArrears;
	}
	public Integer getArrearsContractCount() {
		return arrearsContractCount;
	}
	public void setArrearsContractCount(Integer arrearsContractCount) {
		this.arrearsContractCount = arrearsContractCount;
	}
	public Integer getArrearsPaymentCount() {
		return arrearsPaymentCount;
	}
	public void setArrearsPaymentCount(Integer arrearsPaymentCount) {
		this.arrearsPaymentCount = arrearsPaymentCount;
	}
    public String getPrepayStartTime() {
        return prepayStartTime;
    }

    public void setPrepayStartTime(String prepayStartTime) {
        this.prepayStartTime = prepayStartTime;
    }

    public Boolean getChargeAvailable() {
        return chargeAvailable;
    }

    public void setChargeAvailable(Boolean chargeAvailable) {
        this.chargeAvailable = chargeAvailable;
    }

	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
    public Double getThreshold1() {
        return threshold1;
    }
    public void setThreshold1(Double threshold1) {
        this.threshold1 = threshold1;
    }
    public Double getThreshold2() {
        return threshold2;
    }
    public void setThreshold2(Double threshold2) {
        this.threshold2 = threshold2;
    }
    public Double getThreshold3() {
        return threshold3;
    }
    public void setThreshold3(Double threshold3) {
        this.threshold3 = threshold3;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getAddress3() {
        return address3;
    }
    public void setAddress3(String address3) {
        this.address3 = address3;
    }
    public String getServicePointId() {
        return servicePointId;
    }
    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
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
    public Integer getCashPoint() {
        return cashPoint;
    }
    public void setCashPoint(Integer cashPoint) {
        this.cashPoint = cashPoint;
    }
	public String getLastCommSendSMSDate() {
		return lastCommSendSMSDate;
	}
	public void setLastCommSendSMSDate(String lastCommSendSMSDate) {
		this.lastCommSendSMSDate = lastCommSendSMSDate;
	}
	public Boolean getIsRetrySMS() {
		return isRetrySMS;
	}
	public void setIsRetrySMS(Boolean isRetrySMS) {
		this.isRetrySMS = isRetrySMS;
	}
    public Boolean getIsSts() {
        return isSts;
    }
    public void setIsSts(Boolean isSts) {
        this.isSts = isSts;
    }
    public Boolean getIsNetMetering() {
        return isNetMetering;
    }
    public void setIsNetMetering(Boolean isNetMetering) {
        this.isNetMetering = isNetMetering;
    }
    public Integer getStsId() {
        return stsId;
    }
    public void setStsId(Integer stsId) {
        this.stsId = stsId;
    }

    public Double getOweThreshold() {
		return oweThreshold;
	}
	public void setOweThreshold(Double oweThreshold) {
		this.oweThreshold = oweThreshold;
	}
	public Double getOweCredit() {
		return oweCredit;
	}
	public void setOweCredit(Double oweCredit) {
		this.oweCredit = oweCredit;
	}
	
	public String getUserMemo() { return userMemo; }
    public void setUserMemo(String userMemo) { this.userMemo = userMemo; }*/
}
