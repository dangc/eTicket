package com.nuri.etk.entity.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DebtInfo {

    private String debtRef;
    private String customerId;
    private String installmentDueDate;
    private String debtStatus;
    private String debtType;
    private Double debtAmount;

    public DebtInfo(String debtRef, String customerId, String installmentDueDate, String debtStatus, String debtType, Double debtAmount) {
        this.debtRef = debtRef;
        this.customerId = customerId;
        this.installmentDueDate = installmentDueDate;
        this.debtStatus = debtStatus;
        this.debtType = debtType;
        this.debtAmount = debtAmount;
    }

    @Override
    public String toString() {
        return "DebtInfo{" +
                "debtRef='" + debtRef + '\'' +
                ", customerId='" + customerId + '\'' +
                ", installmentDueDate='" + installmentDueDate + '\'' +
                ", debtStatus='" + debtStatus + '\'' +
                ", debtType='" + debtType + '\'' +
                ", debtAmount='" + debtAmount + '\'' +
                '}';
    }
}
