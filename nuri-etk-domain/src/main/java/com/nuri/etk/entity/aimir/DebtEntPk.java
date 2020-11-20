package com.nuri.etk.entity.aimir;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * AsyncCommandLog 클래스의 Primary Key 정보를 정의한 클래스
 */
public class DebtEntPk {

    private String customerId;
    
    private String debtRef;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDebtRef() {
        return debtRef;
    }

    public void setDebtRef(String debtRef) {
        this.debtRef = debtRef;
    }
}