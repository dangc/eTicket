package com.nuri.etk.entity.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentInfo {

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

    public PaymentInfo(String meterId, String date, String interfaceType, Double paidAmount, Double chargedAmount, Double beforeBalance, Double currentBalance, String chargeId, Integer daysFromLastCharge, String receiptNo, String vendorName, String paymentType, String creditUnit, String token, String cancelToken, String cancelDate, Double chargedArrears, Double chargedDebt) {
        this.meterId = meterId;
        this.date = date;
        this.interfaceType = interfaceType;
        this.paidAmount = paidAmount;
        this.chargedAmount = chargedAmount;
        this.beforeBalance = beforeBalance;
        this.currentBalance = currentBalance;
        this.chargeId = chargeId;
        this.daysFromLastCharge = daysFromLastCharge;
        this.receiptNo = receiptNo;
        this.vendorName = vendorName;
        this.paymentType = paymentType;
        this.creditUnit = creditUnit;
        this.token = token;
        this.cancelToken = cancelToken;
        this.cancelDate = cancelDate;
        this.chargedArrears = chargedArrears;
        this.chargedDebt = chargedDebt;
    }

    @Override
    public String toString() {
        return "paymentInfo{" +
                "meterId='" + meterId + '\'' +
                ", date='" + date + '\'' +
                ", interfaceType='" + interfaceType + '\'' +
                ", paidAmount=" + paidAmount +
                ", chargedAmount=" + chargedAmount +
                ", beforeBalance=" + beforeBalance +
                ", currentBalance=" + currentBalance +
                ", chargeId='" + chargeId + '\'' +
                ", daysFromLastCharge=" + daysFromLastCharge +
                ", receiptNo='" + receiptNo + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", creditUnit='" + creditUnit + '\'' +
                ", token='" + token + '\'' +
                ", cancelToken='" + cancelToken + '\'' +
                ", cancelDate='" + cancelDate + '\'' +
                ", chargedArrears=" + chargedArrears +
                ", chargedDebt=" + chargedDebt +
                '}';
    }
}
