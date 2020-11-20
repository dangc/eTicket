package com.nuri.etk.entity.aimir;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 각 에너지 원별  CO2를 발생량을 계산하는 공식 정보를 가지고 있는 모델 정보<br>
 * 에너지 타입으로 전기, 가스,수도, 열량 등이 있으며<br>
 * 각 단위 사용량별 탄소 배출량 정보등의 정보를 가진다.<br>
 * 
 * @author YeonKyoung Park(goodjob)
 *
 */
public class Co2Formula {

	private Integer id;

    private String name;
	
	private Code supplyTypeCode;
	
	private Integer supplyTypeCodeId;
	
	private Double unitUsage;
	
	private Double co2emissions;
	
	private Double co2factor;
	
	private String unit;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Code getSupplyTypeCode() {
		return supplyTypeCode;
	}

	public void setSupplyTypeCode(Code code) {
		this.supplyTypeCode = code;
	}

	public Double getUnitUsage() {
		return unitUsage;
	}

	public void setUnitUsage(Double unitUsage) {
		this.unitUsage = unitUsage;
	}

	public Double getCo2emissions() {
		return co2emissions;
	}

	public void setCo2emissions(Double co2emissions) {
		this.co2emissions = co2emissions;
	}

	public Double getCo2factor() {
		return co2factor;
	}

	public void setCo2factor(Double co2factor) {
		this.co2factor = co2factor;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

    public Integer getSupplyTypeCodeId() {
        return supplyTypeCodeId;
    }

    public void setSupplyTypeCodeId(Integer supplyTypeCodeId) {
        this.supplyTypeCodeId = supplyTypeCodeId;
    }
}
