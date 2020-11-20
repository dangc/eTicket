package com.nuri.etk.entity.aimir;

import java.util.HashSet;
import java.util.Set;

/**
 * 공급사 서비스 타입
 * 공급사가 공급하는 에너지 타입 정보  
 * 공급자는 전기/가스/수도 등 여러가지 에너지를 공급할 수 있다.
 * 
 */
public class SupplyType {

	private Integer id;
	
    private Supplier supplier;
	
	private Integer supplierId;

	private Code typeCode;
	
	private Integer typeCodeId;
	
	private Co2Formula co2Formula;
	
	private Integer co2FormulaId;
	
	private String billDate;
	
	private Set<SupplyTypeLocation> supplyTypeLocations = new HashSet<SupplyTypeLocation>(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Code getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(Code typeCode) {
		this.typeCode = typeCode;
	}
	
	public Co2Formula getCo2Formula() {
		return co2Formula;
	}
	public void setCo2Formula(Co2Formula co2Formula) {
		this.co2Formula = co2Formula;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Set<SupplyTypeLocation> getSupplyTypeLocations() {
		return supplyTypeLocations;
	}
	public void setSupplyTypeLocations(Set<SupplyTypeLocation> supplyTypeLocations) {
		this.supplyTypeLocations = supplyTypeLocations;
	}
	
	public Integer getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    public Integer getTypeCodeId() {
        return typeCodeId;
    }
    public void setTypeCodeId(Integer typeCodeId) {
        this.typeCodeId = typeCodeId;
    }
    public Integer getCo2FormulaId() {
        return co2FormulaId;
    }
    public void setCo2FormulaId(Integer co2FormulaId) {
        this.co2FormulaId = co2FormulaId;
    }
}
