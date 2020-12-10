package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.DebtEnt;
import com.nuri.etk.entity.aimir.DebtEntPk;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DebtEntJpo implements Serializable{

	private static final long serialVersionUID = 4958774426119312422L;

//    public DebtEntPk id = new DebtEntPk();
    private String customerId;

    private String debtRef;

    private String debtType;
    
    private Double debtAmount;
    
    private String installmentDueDate;
    
    private String debtStatus;
    
    private String writeDate;

	private Double firstDebt;
	
	private Integer debtContractCount;
	
	private Integer debtPaymentCount;

    public DebtEnt toDoamin(){
        DebtEnt debtEnt = new DebtEnt();
        debtEnt.setCustomerId(this.customerId);
        debtEnt.setDebtRef(this.debtRef);
        debtEnt.setDebtType(this.debtType);
        debtEnt.setDebtAmount(this.debtAmount);
        debtEnt.setInstallmentDueDate(this.installmentDueDate);
        debtEnt.setDebtStatus(this.debtStatus);
        debtEnt.setWriteDate(this.writeDate);
        debtEnt.setFirstDebt(this.firstDebt);
        debtEnt.setDebtContractCount(this.debtContractCount);
        debtEnt.setDebtPaymentCount(this.debtPaymentCount);
        return debtEnt;
    }
}
