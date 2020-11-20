package com.nuri.etk.entity.aimir;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * BEMS(Building Energy Management System)에서 사용하는 모델 클래스이며
 * 빌딩공급 지역별 계약용량과 목표 달성을 위한 임계치 정보를 가지고 있다.
 * 계약용량 
 * BEMS에서 빌딩 한개 또는 여러 동에 대해서 계약용량이 가능하므로 공급지역(LocationSupplier)과 관계를 가진다. 
 * 
 * @author 박종성(elevas)
 *
 */
public class ContractCapacity {

	private Integer id;

	private Double capacity;

	private Double threshold1;

	private Double threshold2;

	private Double threshold3;

	private TariffType contractTypeCode;

	private Integer tariffTypeId;
	
	private String contractDate;

	private String contractNumber;

	private Set<SupplyTypeLocation> supplyTypeLocations = new HashSet<SupplyTypeLocation>(
			0);

	public ContractCapacity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public TariffType getContractTypeCode() {
		return contractTypeCode;
	}

	public void setContractTypeCode(TariffType contractTypeCode) {
		this.contractTypeCode = contractTypeCode;
	}

	public Double getThreshold1() {
		return threshold1;
	}

	public void setThreshold1(Double threshold1) {
		this.threshold1 = threshold1;
	}

	public Double getThreshold2() {
		return threshold2;
	}

	public void setThreshold2(Double threshold2) {
		this.threshold2 = threshold2;
	}

	public Double getThreshold3() {
		return threshold3;
	}

	public void setThreshold3(Double threshold3) {
		this.threshold3 = threshold3;
	}

	public Set<SupplyTypeLocation> getSupplyTypeLocations() {
		return supplyTypeLocations;
	}

	public void setSupplyTypeLocations(
			Set<SupplyTypeLocation> supplyTypeLocations) {
		this.supplyTypeLocations = supplyTypeLocations;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public Integer getTariffTypeId() {
        return tariffTypeId;
    }

    public void setTariffTypeId(Integer tariffTypeId) {
        this.tariffTypeId = tariffTypeId;
    }
}
