package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Tariff 타입 (고객종별)
 * 에너지 사용에 요율을 고객 종별 기준으로 나타냅.
 */

@Getter
@Setter
@NoArgsConstructor
public class TariffType {

	private Integer id;
	
	private Integer code;
	
	private String name;
	
	private Supplier supplier;
	
	private Integer supplierId;
	
	private Code serviceTypeCode;
	
	private Integer serviceTypeCodeId;
	
	private String description;


	public TariffType(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
		
    public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Code getServiceTypeCode() {
		return serviceTypeCode;
	}
	public void setServiceTypeCode(Code serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    
    public Integer getServiceTypeCodeId() {
        return serviceTypeCodeId;
    }
    public void setServiceTypeCodeId(Integer serviceTypeCodeId) {
        this.serviceTypeCodeId = serviceTypeCodeId;
    }
}
