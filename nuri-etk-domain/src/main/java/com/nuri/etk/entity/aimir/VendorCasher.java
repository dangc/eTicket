package com.nuri.etk.entity.aimir;

import com.nuri.etk.entity.aimir.Operator;

public class VendorCasher {

	private Integer id;
	
	private Integer vendorId;
	
	private Operator vendor;
	
	private String casherId;
	
	private String password;
	
	private String name;
	
	private Boolean isManager;
	
	private Integer  status;
	
	private String macAddress;
	
	private String lastUpdateDate;
	
	private Boolean isFirst;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Operator getVendor() {
		return vendor;
	}

	public void setVendor(Operator vendor) {
		this.vendor = vendor;
	}

	public String getCasherId() {
		return casherId;
	}

	public void setCasherId(String casherId) {
		this.casherId = casherId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Boolean getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}
}
