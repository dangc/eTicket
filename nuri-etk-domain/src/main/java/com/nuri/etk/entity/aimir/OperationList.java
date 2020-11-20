package com.nuri.etk.entity.aimir;

import com.nuri.etk.entity.aimir.Code;
import com.nuri.etk.entity.aimir.DeviceModel;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * 각각의 모델별로 실행가능한 오퍼레이션들을 관리하기 위한 테이블
 * 제약 사항에 상관없이 해당 모델이 제공하는 모든 오퍼레이션들을 등록해둔다.
 */

public class OperationList {

    private Integer id;

    private Code deviceTypeCode;
	
	private Integer deviceTypeCodeId;

    private Code operationCode;
    
    private Integer operationCodeId;

    private DeviceModel model;
    
    private Integer modelId;

    private Integer level;

    private String desc;
    
    private Integer paramType;

    private String equipment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Code getDeviceTypeCode() {
		return deviceTypeCode;
	}

	public void setDeviceTypeCode(Code deviceTypeCode) {
		this.deviceTypeCode = deviceTypeCode;
	}

	public Code getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(Code operationCode) {
		this.operationCode = operationCode;
	}

	public DeviceModel getModel() {
		return model;
	}

	public void setModel(DeviceModel model) {
		this.model = model;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

    public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getDeviceTypeCodeId() {
        return deviceTypeCodeId;
    }

    public void setDeviceTypeCodeId(Integer deviceTypeCodeId) {
        this.deviceTypeCodeId = deviceTypeCodeId;
    }

    public Integer getOperationCodeId() {
        return operationCodeId;
    }

    public void setOperationCodeId(Integer operationCodeId) {
        this.operationCodeId = operationCodeId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }
    
    public Integer getParamType() {
        return this.paramType;
    }
}
