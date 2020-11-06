package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.pojo.PaymentInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentInfoJpo {

    private String meterId;
    private String date;
    private String interfaceType;
    private Double paidAmount;
    private Double chargedAmount;
    private Double beforeBalance;
    private Double currentBalance;
    private String chargeId;
    private Integer daysFromLastCharge;
    private String receiptNo;
    private String vendorName;
    private String paymentType;
    private String creditUnit;
    private String token;
    private String cancelToken;
    private String cancelDate;
    private Double chargedArrears;
    private Double chargedDebt;

    public PaymentInfoJpo(PaymentInfo paymentInfo) {
        if(paymentInfo != null){
            this.meterId = paymentInfo.getMeterId();
            this.date = paymentInfo.getDate();
            this.interfaceType = paymentInfo.getInterfaceType();
            this.paidAmount = paymentInfo.getPaidAmount();
            this.chargedAmount = paymentInfo.getChargedAmount();
            this.beforeBalance = paymentInfo.getBeforeBalance();
            this.currentBalance = paymentInfo.getCurrentBalance();
            this.chargeId = paymentInfo.getChargeId();
            this.daysFromLastCharge = paymentInfo.getDaysFromLastCharge();
            this.receiptNo = paymentInfo.getReceiptNo();
            this.vendorName = paymentInfo.getVendorName();
            this.paymentType = paymentInfo.getPaymentType();
            this.creditUnit = paymentInfo.getCreditUnit();
            this.token = paymentInfo.getToken();
            this.cancelToken = paymentInfo.getCancelToken();
            this.cancelDate = paymentInfo.getCancelDate();
            this.chargedArrears = paymentInfo.getChargedArrears();
            this.chargedDebt = paymentInfo.getChargedDebt();
        }
    }

    public PaymentInfo toDomain() {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setMeterId(this.meterId);
        paymentInfo.setDate(this.date);
        paymentInfo.setInterfaceType(this.interfaceType);
        paymentInfo.setPaidAmount(this.paidAmount);
        paymentInfo.setChargedAmount(this.chargedAmount);
        paymentInfo.setBeforeBalance(this.beforeBalance);
        paymentInfo.setCurrentBalance(this.currentBalance);
        paymentInfo.setChargeId(this.chargeId);
        paymentInfo.setDaysFromLastCharge(this.daysFromLastCharge);
        paymentInfo.setReceiptNo(this.receiptNo);
        paymentInfo.setVendorName(this.vendorName);
        paymentInfo.setPaymentType(this.paymentType);
        paymentInfo.setCreditUnit(this.creditUnit);
        paymentInfo.setToken(this.token);
        paymentInfo.setCancelToken(this.cancelToken);
        paymentInfo.setCancelDate(this.cancelDate);
        paymentInfo.setChargedArrears(this.chargedArrears);
        paymentInfo.setChargedDebt(this.chargedDebt);
        return paymentInfo;
    }
}
