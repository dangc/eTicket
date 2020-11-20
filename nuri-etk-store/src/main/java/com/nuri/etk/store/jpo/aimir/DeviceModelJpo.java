package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
public class DeviceModelJpo {

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

	/*public Meter toDomain(){
		Meter meter = new Meter();
		DeviceModel deviceModel = new DeviceModel();
		deviceModel.setCode(this.code);
		deviceModel.setDescription(this.description);
		deviceModel.setDeviceType(this.deviceType);
		deviceModel.setDeviceVendor(this.deviceVendor);
		deviceModel.setDeviceVendorId(this.deviceVendorId);
		deviceModel.setName(this.name);
		deviceModel.setImage(this.image);
		deviceModel.setMdsIdPattern(this.mdsIdPattern);
		meter.setModel(deviceModel);
		return meter;
	}*/

	public DeviceModel toDomain(){
		DeviceModel deviceModel = new DeviceModel();
		deviceModel.setCode(this.code);
		deviceModel.setDescription(this.description);
		deviceModel.setDeviceType(this.deviceType);
		deviceModel.setDeviceVendor(this.deviceVendor);
		deviceModel.setDeviceVendorId(this.deviceVendorId);
		deviceModel.setName(this.name);
		deviceModel.setImage(this.image);
		deviceModel.setMdsIdPattern(this.mdsIdPattern);
		return deviceModel;
	}
}
