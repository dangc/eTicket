package com.nuri.etk.entity.aimir;

import java.util.HashSet;
import java.util.Set;

import com.nuri.etk.entity.aimir.CommonConstants.Interface;
import com.nuri.etk.entity.aimir.CommonConstants.ModemType;
import com.nuri.etk.entity.aimir.CommonConstants.Protocol;
import com.nuri.etk.entity.aimir.Code;
import com.nuri.etk.entity.aimir.DeviceModel;
import com.nuri.etk.entity.aimir.Location;
import com.nuri.etk.entity.aimir.Supplier;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * <p>AMI 네트웍 상에서 통신기능을 가지고 있는 모뎀의 정보</p>
 * <p>용도 및 통신 방식에 따라 여러가지 타입으로 분류할 수 있다.</p>
 *
 * 노드유형
 * - 미터(전자,펄스),M-Bus,리피터,IHD,PLC,가전기기,경보장치, ACD 
 * 파워파입 
 * - 전기,배터리,솔라 
 * 통신유형 
 * - Zigbee 
 * - CDMA(GSM):이런 경우 MCU와 붙지 않는다. 
 * - PLC 
 * 망타입 
 * - Zigbee:RFD,FFD 
 * - PLC, CDMA(GSM) : 없음 
 * 노드가 펄스식 미터인 경우 
 * - 검침주기(업로드는 즉시) 
 *
 */

public class Modem {
    
    private Integer id;

    private String deviceSerial;

    private Modem modem;
    
    private Integer parentModemId;

    private Set<Meter> meter = new HashSet<Meter>(0);

    private MCU mcu;
    
    private Integer mcuId;

    private Supplier supplier;
    
    private Integer supplierId;

    private DeviceModel model;
    
    private Integer modelId;

    private Integer nodeType;

    private String nodeKind;
    
    private String zdzdIfVersion;
   
    private Protocol protocolType;

    private String swVer;

    private String hwVer;

    private String fwVer;
    
    private String fwRevision;

    private Integer commState;

    private Code modemStatus;
    
    private Integer modemStatusCodeId;

    private String protocolVersion;  //protocol Version

    private String installDate;

    private String lastLinkTime;
    
    private Long rfPower;

    private String ipAddr;

    private String macAddr;

    private Double gpioX;

    private Double gpioY;

    private Double gpioZ;

    private String installedSiteImg;

    private String address;

    private Double powerThreshold;

    private Double currentThreshold;
    
    private Integer resetCount;

    private Integer lastResetCode;

    private ModemType modemType;
    
    private Integer lpPeriod;
    
    private Interface interfaceType;

    private Location location;
    
    private Integer locationId;
    
    private Integer idType;
    
    private Integer amiNetworkDepth;  //AMI Virtual Network Depth
    
    private String amiNetworkAddress;  //AMI Virtual Network Address
    
    private String nameSpace;

	private String gs1;
    
    private String po;
    
    private String iccId;
    
    private String manufacturedDate;
    
    private String imei;
    
    private String simNumber;
    
    private String phoneNumber;
    
    private Integer cpuUsage;

    private Integer memoryUsage;
    
    private String bootLoaderVer;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ModemType getModemType() {
        return modemType;
    }

    public void setModemType(String modemType) {
        this.modemType = ModemType.valueOf(modemType);
    }
    

    public void setMeter(Set<Meter> meter) {
        this.meter = meter;
    }

    public Set<Meter> getMeter() {
        return meter;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public Modem getModem() {
        return modem;
    }

    public void setModem(Modem modem) {
        this.modem = modem;
    }

    public MCU getMcu() {
        return mcu;
    }

    public void setMcu(MCU mcu) {
        this.mcu = mcu;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeKind() {
        return nodeKind;
    }

    public void setNodeKind(String nodeKind) {
        this.nodeKind = nodeKind;
    }

    public String getZdzdIfVersion() {
        return zdzdIfVersion;
    }

    public void setZdzdIfVersion(String zdzdIfVersion) {
        this.zdzdIfVersion = zdzdIfVersion;
    }

    public Protocol getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = Protocol.valueOf(protocolType);
    }

    public String getSwVer() {
        return swVer;
    }

    public void setSwVer(String swVer) {
        this.swVer = swVer;
    }

    public String getHwVer() {
        return hwVer;
    }

    public void setHwVer(String hwVer) {
        this.hwVer = hwVer;
    }

    public String getFwRevision() {
        return fwRevision;
    }

    public void setFwRevision(String fwRevision) {
        this.fwRevision = fwRevision;
    }

    public String getFwVer() {
        return fwVer;
    }

    public void setFwVer(String fwVer) {
        this.fwVer = fwVer;
    }

    public void setResetCount(Integer resetCount) {
        this.resetCount = resetCount;
    }

    public void setLastResetCode(Integer lastResetCode) {
        this.lastResetCode = lastResetCode;
    }

    public Integer getCommState() {
        return commState;
    }

    public void setCommState(Integer commState) {
        this.commState = commState;
    }
    
    public Code getModemStatus() {
        return modemStatus;
    }

    public void setModemStatus(Code modemStatus) {
        this.modemStatus = modemStatus;
    }

    public Integer getModemStatusCodeId() {
        return modemStatusCodeId;
    }

    public void setModemStatusCodeId(Integer modemStatusCodeId) {
        this.modemStatusCodeId = modemStatusCodeId;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getLastLinkTime() {
        return lastLinkTime;
    }

    public void setLastLinkTime(String lastLinkTime) {
        this.lastLinkTime = lastLinkTime;
    }

    public Long getRfPower() {
        return rfPower;
    }

    public void setRfPower(Long rfPower) {
        this.rfPower = rfPower;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public Double getGpioX() {
        return gpioX;
    }

    public void setGpioX(Double gpioX) {
        this.gpioX = gpioX;
    }

    public Double getGpioY() {
        return gpioY;
    }

    public void setGpioY(Double gpioY) {
        this.gpioY = gpioY;
    }

    public Double getGpioZ() {
        return gpioZ;
    }

    public void setGpioZ(Double gpioZ) {
        this.gpioZ = gpioZ;
    }

    public String getInstalledSiteImg() {
        return installedSiteImg;
    }

    public void setInstalledSiteImg(String installedSiteImg) {
        this.installedSiteImg = installedSiteImg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPowerThreshold() {
        return powerThreshold;
    }

    public void setPowerThreshold(Double powerThreshold) {
        this.powerThreshold = powerThreshold;
    }

    public Double getCurrentThreshold() {
        return currentThreshold;
    }

    public void setCurrentThreshold(Double currentThreshold) {
        this.currentThreshold = currentThreshold;
    }

    public Integer getResetCount() {
        return resetCount;
    }

    public Integer getLastResetCode() {
        return lastResetCode;
    }

    public Integer getLpPeriod() {
        return lpPeriod;
    }

    public void setLpPeriod(Integer lpPeriod) {
        this.lpPeriod = lpPeriod;
    }
    
    public Interface getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Interface interfaceType) {
        this.interfaceType = interfaceType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getParentModemId() {
        return parentModemId;
    }

    public void setParentModemId(Integer parentModemId) {
        this.parentModemId = parentModemId;
    }

    public Integer getMcuId() {
        return mcuId;
    }

    public void setMcuId(Integer mcuId) {
        this.mcuId = mcuId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getAmiNetworkDepth() {
        return amiNetworkDepth;
    }

    public void setAmiNetworkDepth(Integer amiNetworkDepth) {
        this.amiNetworkDepth = amiNetworkDepth;
    }

    public String getAmiNetworkAddress() {
        return amiNetworkAddress;
    }

    public void setAmiNetworkAddress(String amiNetworkAddress) {
        this.amiNetworkAddress = amiNetworkAddress;
    }   

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }
    
    public String getGs1() {
        return gs1;
    }

    public void setGs1(String gs1) {
        this.gs1 = gs1;
    }
    
    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }
    
    public String getIccId() {
        return iccId;
    }

    public void setIccId(String iccId) {
        this.iccId = iccId;
    }
    
    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }
    
    public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	
	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Integer getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(Integer cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public Integer getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(Integer memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public String getBootLoaderVer() {
		return bootLoaderVer;
	}

	public void setBootLoaderVer(String bootLoaderVer) {
		this.bootLoaderVer = bootLoaderVer;
	}

    public void setModel(DeviceModel model) {
        this.model = model;
    }
	
    public DeviceModel getModel() {
        return model;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }
}