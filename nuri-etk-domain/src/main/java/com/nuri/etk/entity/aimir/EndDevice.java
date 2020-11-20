package com.nuri.etk.entity.aimir;

import java.util.HashSet;
import java.util.Set;

import com.nuri.etk.entity.aimir.CommonConstants.Protocol;
import com.nuri.etk.entity.aimir.CommonConstants.SimpleSignalLevel;
import com.nuri.etk.entity.aimir.Code;
import com.nuri.etk.entity.aimir.DeviceModel;
import com.nuri.etk.entity.aimir.Location;
import com.nuri.etk.entity.aimir.Supplier;
import com.nuri.etk.entity.aimir.Zone;


/**
 * 
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * <p>EndDevice.java Description </p>
 * End Device (Appliance Control Device에 연결되어 스스로가 아닌 ACD에 의해 전력 차단이나 사용량 측정이 되는 장치) <br>
 * 워터펌프, 가전기기 에어콘 등등 <br>
 * <pre>
 * 가전기기 또는 설비(공조, 냉온항습기, 조명, 화재, 보안 등)는 ACD 장치와 붙거나 PLC 모뎀과 통신하여 기기정보획득이나 제어가 가능해질 전망이다. 
 * 각 종 설비는 그 자체적으로 에너지 사용량 정보와 통신 프로토콜을 가지고 있을 수 있다. FMS를 통해서 그러한 정보를 수집할 수도 있다. 
 * </pre>
 * 
 * <pre>
 * Date          Version     Author   Description 
 * -              V1.0       -         신규작성 
 * 2011. 5. 04.   v1.1       eunmiae   [HEMS] 항목추가 : 그룹명, 이미지파일명         
 * 2011. 5. 09.   v1.2       eunmiae   [HEMS] 항목명 변경 : endDeviceGroupName -> homeDeviceGroupName로 변경 
 * 2011. 5. 25.   v1.3       eunmiae   [HEMS] 항목명 변경 : categoryCode의 데이터 내용 변경
 * </pre>
 * 
 */

public class EndDevice {

	private Integer id;

    private Supplier supplier;
    
    private Integer supplierId;
    
    private Modem modem;
    
    private Integer modemId;
    
	private Location location;
    
    private Integer locationId;
    
	private Zone zone;
    
    private Integer zoneId;

    private	String uuid;
    
    private	String upc;

    private Code categoryCode;
    
    private Integer categoryCodeId;
    
    private Code controllerCode;
    
    private Integer controllerCodeId;
    
	private	String friendlyName;
    
    private DeviceModel model;
    
    private Integer deviceModelId;

    private	String manufacturer;

	private	String modelName;
	
    private	String modelNumber;
    
    private	String serialNumber;
    
    private Double powerConsumption;
    
    private Integer energyEfficiency;
    
    private Code statusCode;
    
    private Integer statusCodeId;
    
    private	String macAddr;
    
    private Protocol protocolType;
    
    private String installDate;
    
    private String manufactureDate;
    
    private Set<Meter> meters = new HashSet<Meter>(0);

	private Code energyType;

	private Boolean loadControl;

	private Integer drLevel;

	private Boolean drProgramMandatory; // DR 프로그램이필수인지여부 (사용자의동의)

	private SimpleSignalLevel simpleSignalLevel;

    private String homeDeviceGroupName;

    private String homeDeviceImgFilename;

	private Code installStatus;
    
    private Integer installStatusCodeId;

    public Code getInstallStatus() {
		return installStatus;
	}

	public void setInstallStatus(Code installStatus) {
		this.installStatus = installStatus;
	}

	public String getHomeDeviceGroupName() {
		return homeDeviceGroupName;
	}

	public void setHomeDeviceGroupName(String homeDeviceGroupName) {
		this.homeDeviceGroupName = homeDeviceGroupName;
	}

	public String getHomeDeviceImgFilename() {
		return homeDeviceImgFilename;
	}

	public void setHomeDeviceImgFilename(String homeDeviceImgFilename) {
		this.homeDeviceImgFilename = homeDeviceImgFilename;
	}

    /* 2011. 5. 04 v1.1 HEMS 제품관리관리를 위한 항목 추가 ADD END eunmiae */
    
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

	public Modem getModem() {
		return modem;
	}

	public void setModem(Modem modem) {
		this.modem = modem;
	}
	    
    public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Code getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(Code categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	public Code getControllerCode() {
		return controllerCode;
	}

	public void setControllerCode(Code controllerCode) {
		this.controllerCode = controllerCode;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	    
    public DeviceModel getModel() {
		return model;
	}

	public void setModel(DeviceModel model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Double getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(Double powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public Integer getEnergyEfficiency() {
		return energyEfficiency;
	}

	public void setEnergyEfficiency(Integer energyEfficiency) {
		this.energyEfficiency = energyEfficiency;
	}

	public Code getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Code statusCode) {
		this.statusCode = statusCode;
	}

	public String getMacAddr() {
		return macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	public Protocol getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(Protocol protocolType) {
		this.protocolType = protocolType;
	}
	
	
	public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }
    
    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Set<Meter> getMeters() {
        return meters;
    }

    public void setMeters(Set<Meter> meters) {
        this.meters = meters;
    }

    public Code getEnergyType() {
		return energyType;
	}

	public void setEnergyType(Code energyType) {
		this.energyType = energyType;
	}

	public Boolean getLoadControl() {
		return loadControl;
	}

	public void setLoadControl(Boolean loadControl) {
		this.loadControl = loadControl;
	}

	public Integer getDrLevel() {
		return drLevel;
	}

	public void setDrLevel(Integer drLevel) {
		this.drLevel = drLevel;
	}

	public Boolean getDrProgramMandatory() {
		return drProgramMandatory;
	}

	public void setDrProgramMandatory(Boolean drProgramMandatory) {
		this.drProgramMandatory = drProgramMandatory;
	}

	public SimpleSignalLevel getSimpleSignalLevel() {
		return simpleSignalLevel;
	}

	public void setSimpleSignalLevel(SimpleSignalLevel simpleSignalLevel) {
		this.simpleSignalLevel = simpleSignalLevel;
	}

	public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getModemId() {
        return modemId;
    }

    public void setModemId(Integer modemId) {
        this.modemId = modemId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getCategoryCodeId() {
        return categoryCodeId;
    }

    public void setCategoryCodeId(Integer categoryCodeId) {
        this.categoryCodeId = categoryCodeId;
    }

    public Integer getControllerCodeId() {
        return controllerCodeId;
    }

    public void setControllerCodeId(Integer controllerCodeId) {
        this.controllerCodeId = controllerCodeId;
    }

    public Integer getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(Integer deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public Integer getStatusCodeId() {
        return statusCodeId;
    }

    public void setStatusCodeId(Integer statusCodeId) {
        this.statusCodeId = statusCodeId;
    }

    public Integer getInstallStatusCodeId() {
        return installStatusCodeId;
    }

    public void setInstallStatusCodeId(Integer installStatusCodeId) {
        this.installStatusCodeId = installStatusCodeId;
    }
}