package com.nuri.etk.entity.aimir;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 장비 모델에 한정된 특정 구성 정보
 * 장비 모델별 설정명 ( “모델명 + config”) 로 일반적으로 식별 가능하게 설정
 */

public abstract class DeviceConfig {

	private Integer id;

	private String name;

	private DeviceModel deviceModel;
	
	private Integer deviceModelId;
	
    private String parserName;

    private String saverName;
    
    private String ondemandParserName;

    private String ondemandSaverName;
    

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
	
	public DeviceModel getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(DeviceModel deviceModel) {
		this.deviceModel = deviceModel;
	}
    public Integer getDeviceModelId() {
        return deviceModelId;
    }
    public void setDeviceModelId(Integer deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public String getParserName() {
        return parserName;
    }
    public void setParserName(String parserName) {
        this.parserName = parserName;
    }
    
    public String getSaverName() {
        return saverName;
    }
    public void setSaverName(String saverName) {
        this.saverName = saverName;
    }
    public String getOndemandParserName() {
        return ondemandParserName;
    }
    public void setOndemandParserName(String ondemandParserName) {
        this.ondemandParserName = ondemandParserName;
    }
    public String getOndemandSaverName() {
        return ondemandSaverName;
    }
    public void setOndemandSaverName(String ondemandSaverName) {
        this.ondemandSaverName = ondemandSaverName;
    }
    
    
}
