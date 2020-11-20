package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
public class ContractJpo {

	private Integer id;
	
    private String contractNumber;

	private Customer customer;
	
	private String customerId;
	
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


    public Contract toDomain(){
    	Contract contract = new Contract();
		contract.setId(this.id);
		contract.setContractNumber(this.contractNumber);
		contract.setCustomerId(this.customerId);
		contract.setLastTokenDate(this.lastTokenDate);
		contract.setCurrentCredit(this.currentCredit);
		contract.setChargedCredit(this.chargedCredit);
		contract.setCurrentArrears(this.currentArrears);
		contract.setLastTokenDate(this.lastTokenDate);
		contract.setCashPoint(this.cashPoint);
		contract.setTariffIndex(this.tariffIndex);
		contract.setTariffIndexId(this.tariffIndexId);
		contract.setStatus(this.status);
		return contract;
	}

}
