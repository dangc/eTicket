package com.nuri.etk.entity.aimir;

import java.io.Serializable;

public class DebtEnt implements Serializable{

	private static final long serialVersionUID = 4958774426119312422L;

    public DebtEntPk id = new DebtEntPk();
	
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
    
    public String getCustomerId() {
        return id.getCustomerId();
    }
    public void setCustomerId(String customerId) {
        id.setCustomerId(customerId);
    }
    public String getDebtType() {
        return debtType;
    }
    public void setDebtType(String debtType) {
        this.debtType = debtType;
    }
    public Double getDebtAmount() {
        return debtAmount;
    }
    public void setDebtAmount(Double debtAmount) {
        this.debtAmount = debtAmount;
    }
    public String getDebtStatus() {
        return debtStatus;
    }
    public void setDebtStatus(String debtStatus) {
        this.debtStatus = debtStatus;
    }
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getDebtRef() {
        return id.getDebtRef();
    }
    public void setDebtRef(String debtRef) {
        id.setDebtRef(debtRef);
    }
    public String getInstallmentDueDate() {
        return installmentDueDate;
    }
    public void setInstallmentDueDate(String installmentDueDate) {
        this.installmentDueDate = installmentDueDate;
    }

	public Double getFirstDebt() {
		return firstDebt;
	}
	public void setFirstDebt(Double firstDebt) {
		this.firstDebt = firstDebt;
	}
	public Integer getDebtContractCount() {
		return debtContractCount;
	}
	public void setDebtContractCount(Integer debtContractCount) {
		this.debtContractCount = debtContractCount;
	}
	public Integer getDebtPaymentCount() {
		return debtPaymentCount;
	}
	public void setDebtPaymentCount(Integer debtPaymentCount) {
		this.debtPaymentCount = debtPaymentCount;
	}
}
