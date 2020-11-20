/**
 * OperatorContract.java Copyright NuriTelecom Limited 2011
 */
package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Operator.java Description 
 * 시스템 로그인을 위한 사용자 정보 
 */

@Getter
@Setter
@NoArgsConstructor
public class Operator  extends User{

	private Double deposit;
	
    private Integer cashPoint;

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
    
	public Integer getCashPoint() {
        return cashPoint;
    }
	
    public void setCashPoint(Integer cashPoint) {
        this.cashPoint = cashPoint;
    }
}
	
