package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.pojo.DebtInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DebtInfoJpo {

    private String debtRef;
    private String customerId;
    private String installmentDueDate;
    private String debtStatus;
    private String debtType;
    private Double debtAmount;

    public DebtInfoJpo(DebtInfo debtInfo) {
        if(debtInfo != null){
            this.debtRef = debtInfo.getDebtRef();
            this.customerId = debtInfo.getCustomerId();
            this.installmentDueDate = debtInfo.getInstallmentDueDate();
            this.debtStatus = debtInfo.getDebtStatus();
            this.debtType = debtInfo.getDebtType();
            this.debtAmount = debtInfo.getDebtAmount();
        }
    }

    public DebtInfo toDomain() {
        DebtInfo debtInfo = new DebtInfo();
        debtInfo.setDebtRef(this.debtRef);
        debtInfo.setCustomerId(this.customerId);
        debtInfo.setInstallmentDueDate(this.installmentDueDate);
        debtInfo.setDebtStatus(this.debtStatus);
        debtInfo.setDebtType(this.debtType);
        debtInfo.setDebtAmount(this.debtAmount);
        return debtInfo;
    }
}
