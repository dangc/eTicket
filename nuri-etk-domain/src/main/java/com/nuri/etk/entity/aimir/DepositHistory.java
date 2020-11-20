package com.nuri.etk.entity.aimir;

import com.nuri.etk.entity.aimir.Meter;
import com.nuri.etk.entity.aimir.Contract;
import com.nuri.etk.entity.aimir.Customer;
import com.nuri.etk.entity.aimir.Operator;
import com.nuri.etk.entity.aimir.PrepaymentLog;

/**
 * @FileName DepositHistory.java
 * @Descr 예치금 변경 이력
 */

public class DepositHistory {

	private Integer id;

	private Operator operator;

	private Integer operatorId;
	
	private Operator loginUser;

	private Integer loginUserId;
	
	private Customer customer;
	
	private Integer customerId;
	
	private Meter meter;
	
	private Integer meterId;
		
	private Contract contract;
	
	private Integer contractId;
	
	private String changeDate;
	
	private Double chargeDeposit;
	
	private Double chargeCredit;
	
	private Double deposit;
	
	private Float commission;
	
	private Double value;
	
	private Float taxRate;
	
	private Double tax;
	
	private Double netValue;
	
	private PrepaymentLog prepaymentLog;
	
	private Long prepaymentLogId;
	
	private Long receiptRangeLogDetailId;
	
	private Boolean isCanceled;
	
	private String cancelDate;
	
	private String cancelReason;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	
	public Operator getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Operator loginUser) {
		this.loginUser = loginUser;
	}

	public Integer getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(Integer loginUserId) {
		this.loginUserId = loginUserId;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}
	
	public Integer getMeterId() {
		return meterId;
	}

	public void setMeterId(Integer meterId) {
		this.meterId = meterId;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	public Double getChargeDeposit() {
		return chargeDeposit;
	}

	public void setChargeDeposit(Double chargeDeposit) {
		this.chargeDeposit = chargeDeposit;
	}

	public Double getChargeCredit() {
		return chargeCredit;
	}

	public void setChargeCredit(Double chargeCredit) {
		this.chargeCredit = chargeCredit;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	
	
	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Float taxRate) {
		this.taxRate = taxRate;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getNetValue() {
		return netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
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

	public Long getReceiptRangeLogDetailId() {
		return receiptRangeLogDetailId;
	}

	public void setReceiptRangeLogDetailId(Long receiptRangeLogDetailId) {
		this.receiptRangeLogDetailId = receiptRangeLogDetailId;
	}
	
	public Boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
}
