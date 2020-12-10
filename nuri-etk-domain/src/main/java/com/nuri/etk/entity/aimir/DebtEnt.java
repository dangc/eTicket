package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DebtEnt {

	private static final long serialVersionUID = 4958774426119312422L;

//    public DebtEntPk id = new DebtEntPk();
    private String customerId;

    private String debtRef;
	
    private String debtType;
    
    private Double debtAmount;
    
    private String installmentDueDate;
    
    private String debtStatus;
    
    private String writeDate;
    
	/**
	 * 분할납부시 사용
	 * FIRSTARREARS, ARREARS_CONTRACT_COUNT, ARREARS_PAYMENT_COUNT
	 * 
	 */
	 
	private Double firstDebt;
	
	private Integer debtContractCount;
	
	private Integer debtPaymentCount;
}
