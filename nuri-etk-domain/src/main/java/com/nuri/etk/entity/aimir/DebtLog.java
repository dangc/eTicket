package com.nuri.etk.entity.aimir;

import com.nuri.etk.entity.aimir.PrepaymentLog;

/**
 * 선불내역
 *  - 선불정보는 Contract 테이블에 갱신되며, 갱신될때마다 PrepaymentLog에 기록된다.
 *  
 */
public class DebtLog {

	private Long id;
	
	private PrepaymentLog prepaymentLog;
	
	private Long prepaymentLogId;
	
	private String customerId;
	
	private String debtType;
	
    private String debtRef;
	
	private Double preDebt;
	
	private Double debt;

	private Double chargedDebt;
	
	private String partpayInfo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public PrepaymentLog getPrepaymentLog() {
		return prepaymentLog;
	}
	public void setPrepaymentLog(PrepaymentLog prepaymentLog) {
		this.prepaymentLog = prepaymentLog;
	}
	public Long getPrepaymentLogId() {
		return prepaymentLogId;
	}
	public void setPrepaymentLogId(Long prepaymentLogId) {
		this.prepaymentLogId = prepaymentLogId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getDebtType() {
		return debtType;
	}
	public void setDebtType(String debtType) {
		this.debtType = debtType;
	}
	public String getDebtRef() {
		return debtRef;
	}
	public void setDebtRef(String debtRef) {
		this.debtRef = debtRef;
	}
	public Double getPreDebt() {
		return preDebt;
	}
	public void setPreDebt(Double preDebt) {
		this.preDebt = preDebt;
	}
	public Double getDebt() {
		return debt;
	}
	public void setDebt(Double debt) {
		this.debt = debt;
	}
	public Double getChargedDebt() {
		return chargedDebt;
	}
	public void setChargedDebt(Double chargedDebt) {
		this.chargedDebt = chargedDebt;
	}
	public String getPartpayInfo() {
		return partpayInfo;
	}
	public void setPartpayInfo(String partpayInfo) {
		this.partpayInfo = partpayInfo;
	}
}
