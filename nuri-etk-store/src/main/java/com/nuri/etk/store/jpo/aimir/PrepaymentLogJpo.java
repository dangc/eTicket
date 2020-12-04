package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 선불내역
 *  - 선불정보는 Contract 테이블에 갱신되며, 갱신될때마다 PrepaymentLog에 기록된다.
 */

@Getter
@Setter
@NoArgsConstructor
public class PrepaymentLogJpo {

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

    public PrepaymentLog toDomain(){
        PrepaymentLog prepaymentLog = new PrepaymentLog();
        prepaymentLog.setLastTokenDate(this.lastTokenDate);
        prepaymentLog.setChargedCredit(this.chargedCredit);
        prepaymentLog.setPreBalance(this.preBalance);
        prepaymentLog.setBalance(this.balance);
        prepaymentLog.setLastTokenId(this.lastTokenId);
        prepaymentLog.setDaysFromCharge(this.daysFromCharge);
        prepaymentLog.setToken(this.token);
        prepaymentLog.setCancelToken(this.cancelToken);
        prepaymentLog.setCancelDate(this.cancelDate);
        prepaymentLog.setCancelReason(this.cancelReason);
        prepaymentLog.setChargedArrears(this.chargedArrears);
        prepaymentLog.setIsCanceled(this.isCanceled);
        prepaymentLog.setContractId(this.contractId);
        return prepaymentLog;
    }
}

