package com.nuri.etk.entity.aimir;

import java.util.HashSet;
import java.util.Set;

import com.nuri.etk.entity.aimir.OperationList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * AIMIR System 에서 사용하는 Device들의 모델 정보를 나타낸다.
 * 장비 제조사에 속해있는 모델정보 
 * Device의 벤더 정보, Device의 고유 코드 , Device 타입, 모델명, 이미지 경로, 장비와 연관된 고유 설정 정보등을 가진다.
 * 본 정보는 AIMIR System에서 Device들의 일반적인 모델 정보를 보여주기에 앞서 Device별로 고유한 오퍼레이션이나
 * 데이터를 해석할 때 활용한다.
 */

@Getter
@Setter
@NoArgsConstructor
public class DeviceModel {

	private Integer id;
	
	private DeviceVendor deviceVendor;
	
	private Integer deviceVendorId;

	private Integer code;
	
	private Code deviceType;
	
	private Integer deviceTypeCodeId;
	
	private DeviceConfig deviceConfig;
	
	private String name;
	
	private String image;
	
	private Set<OperationList> operationList = new HashSet<OperationList>(0);

	private String description;
	
	private String mdsIdPattern="[0-9]*";

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public DeviceVendor getDeviceVendor() {
		return deviceVendor;
	}
	public void setDeviceVendor(DeviceVendor deviceVendor) {
		this.deviceVendor = deviceVendor;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public Code getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Code deviceType) {
		this.deviceType = deviceType;
	}
	
	public DeviceConfig getDeviceConfig() {
		return deviceConfig;
	}
	public void setDeviceConfig(DeviceConfig deviceConfig) {
		this.deviceConfig = deviceConfig;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Set<OperationList> getOperationList() {
		return operationList;
	}
	public void setOperationList(Set<OperationList> operationList) {
		this.operationList = operationList;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeviceVendorId() {
        return deviceVendorId;
    }
    public void setDeviceVendorId(Integer deviceVendorId) {
        this.deviceVendorId = deviceVendorId;
    }
    public Integer getDeviceTypeCodeId() {
        return deviceTypeCodeId;
    }
    public void setDeviceTypeCodeId(Integer deviceTypeCodeId) {
        this.deviceTypeCodeId = deviceTypeCodeId;
    }
    
    public String getMdsIdPattern() {
        return mdsIdPattern;
    }
    public void setMdsIdPattern(String mdsIdPattern) {
        this.mdsIdPattern = mdsIdPattern;
    }
}
