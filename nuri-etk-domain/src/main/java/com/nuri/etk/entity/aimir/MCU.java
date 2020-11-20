package com.nuri.etk.entity.aimir;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.nuri.etk.entity.aimir.Code;
import com.nuri.etk.entity.aimir.DeviceModel;
import com.nuri.etk.entity.aimir.Location;
import com.nuri.etk.entity.aimir.Supplier;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 *
 * DCU 라고 쓰이나 클래스명은 MCU로 명명한다.
 * Data Concentrator Unit, Master Concentrator Unit
 * Operation 범위는 (집중기 타입이 Indoor, Outdoor인 경우)
 * - Status Monitoring
 * - Self Test
 * - Remote File Access
 * - Metering Data Recovery
 * - Time Sync
 * - MCU Reset
 */

public class MCU {

    private Integer id;

    private List<MCU> childMcus = new ArrayList<MCU>(0);

    private Long mcuVarId;

    private Integer mcuCodeId;

    private DeviceModel deviceModel;

    private Integer deviceModelId;

    private MCU mcu;

    private Integer parentId;

    private Set<Modem> modem = new HashSet<Modem>(0);

    private Supplier supplier;

    private Integer supplierId;

    private Location location;

    private Integer locationId;

    private Integer networkStatus;

    private String installDate;

    private String locDetail;

    private String lastModifiedDate;

    private String ipAddr;

    private String ipv6Addr;

    private String macAddr;

    private Integer serviceAtm;

    private Code mcuType;

    private Integer mcuTypeCodeId;
    private Code protocolType;

    private Integer protocolTypeCodeId;

    private Double gpioX;

    private Double gpioY;

    private Double gpioZ;

    private Integer powerState;

    private Integer lowBatteryFlag;

    private Integer mobileUsageFlag;

    private Integer batteryCapacity;

    private String lastTimeSyncDate;

    private String lastswUpdateDate;

    private String lastCommDate;

    private Integer updateServerPort;

    private Integer fwState;

    private String sysID;

    private Integer sysType;

    private String sysName;

    private String sysDescr;

    private String sysLocation;

    private String sysContact;

    private String sysHwVersion;

    private String sysSwVersion;

    private String sysPhoneNumber;

    private Integer sysEtherType;

    private Integer sysMobileType;

    private Integer sysMobileMode;

    private String sysUpTime;

    private String sysTime;

    private Integer sysCurTemp;

    private Integer sysMinTemp;

    private Integer sysMaxTemp;

    private String sysServer;

    private Integer sysServerPort;

    private Integer sysServerAlarmPort;

    private Integer sysLocalPort;

    private Integer sysSecurePort;

    private Integer sysState;

    private String sysVendor;

    private String sysModel;

    private Integer sysMobileVendor;

    private String sysMobileAccessPointName;

    private String sysSwRevision;

    private Integer sysResetReason;

    private Integer sysJoinNodeCount;

    private Integer sysTimeZone;

    private Integer sysOpMode;

    private Integer sysPowerType;

    private Integer sysStateMask;

    private String protocolVersion; // protocol Version

    private Integer amiNetworkDepth; // AMI Virtual Network Depth

    private String amiNetworkAddress; // AMI Virtual Network Address

    private String amiNetworkAddressV6; // AMI Virtual Network Address

    private String nameSpace;

    private String gs1;

    private String sysHwBuild;

    private String sysSerialNumber;

    private Integer sysTlsPort;

    private String sysTlsVersion;

    private Code mcuStatus;

    private Integer mcuStatusCodeId;

    private String selectedField = "true";

    private String po;
    
    private String imei;
    
    private String simNumber;

    private String iccId;
    
    private String manufacturedDate;
    
    private String networkKey;
    
    private Integer networkKeyIdx;
    

    public void setSelectedField(String selectedField) {
        this.selectedField = selectedField;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MCU> getChildMcus() {
        return childMcus;
    }

    public void setChildMcus(List<MCU> childMcus) {
        this.childMcus = childMcus;
    }

    public DeviceModel getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }

    public MCU getMcu() {
        return mcu;
    }

    public void setMcu(MCU mcu) {
        this.mcu = mcu;
    }

    public Set<Modem> getModem() {
        return modem;
    }

    public void setModem(Set<Modem> modem) {
        this.modem = modem;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSysDescr() {
        return sysDescr;
    }

    public void setSysDescr(String sysDescr) {
        this.sysDescr = sysDescr;
    }

    public String getSysID() {
        return sysID;
    }

    public void setSysID(String sysID) {
        this.sysID = sysID;
    }

    public String getSysLocation() {
        return sysLocation;
    }

    public void setSysLocation(String sysLocation) {
        this.sysLocation = sysLocation;
    }

    public String getSysVendor() {
        return sysVendor;
    }

    public void setSysVendor(String sysVendor) {
        this.sysVendor = sysVendor;
    }

    public String getSysModel() {
        return sysModel;
    }

    public void setSysModel(String sysModel) {
        this.sysModel = sysModel;
    }

    public String getSysContact() {
        return sysContact;
    }

    public void setSysContact(String sysContact) {
        this.sysContact = sysContact;
    }

    public Integer getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(Integer networkStatus) {
        this.networkStatus = networkStatus;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getLocDetail() {
        return locDetail;
    }

    public void setLocDetail(String locDetail) {
        this.locDetail = locDetail;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getIpv6Addr() {
        return ipv6Addr;
    }

    public void setIpv6Addr(String ipv6Addr) {
        this.ipv6Addr = ipv6Addr;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getSysUpTime() {
        return sysUpTime;
    }

    public void setSysUpTime(String sysUpTime) {
        this.sysUpTime = sysUpTime;
    }

    public Integer getServiceAtm() {
        return serviceAtm;
    }

    public void setServiceAtm(Integer serviceAtm) {
        this.serviceAtm = serviceAtm;
    }

    public Code getMcuType() {
        return mcuType;
    }

    public void setMcuType(Code mcuType) {
        this.mcuType = mcuType;
    }

    public Code getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(Code protocolType) {
        this.protocolType = protocolType;
    }

    public String getSysPhoneNumber() {
        return sysPhoneNumber;
    }

    public void setSysPhoneNumber(String sysPhoneNumber) {
        this.sysPhoneNumber = sysPhoneNumber;
    }

    public Integer getPowerState() {
        return powerState;
    }

    public void setPowerState(Integer powerState) {
        this.powerState = powerState;
    }

    public Integer getLowBatteryFlag() {
        return lowBatteryFlag;
    }

    public void setLowBatteryFlag(Integer lowBatteryFlag) {
        this.lowBatteryFlag = lowBatteryFlag;
    }

    public Integer getMobileUsageFlag() {
        return mobileUsageFlag;
    }

    public void setMobileUsageFlag(Integer mobileUsageFlag) {
        this.mobileUsageFlag = mobileUsageFlag;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getLastTimeSyncDate() {
        return lastTimeSyncDate;
    }

    public void setLastTimeSyncDate(String lastTimeSyncDate) {
        this.lastTimeSyncDate = lastTimeSyncDate;
    }

    public String getLastswUpdateDate() {
        return lastswUpdateDate;
    }

    public void setLastswUpdateDate(String lastswUpdateDate) {
        this.lastswUpdateDate = lastswUpdateDate;
    }

    public String getLastCommDate() {
        return lastCommDate;
    }

    public void setLastCommDate(String lastCommDate) {
        this.lastCommDate = lastCommDate;
    }

    public String getSysMobileAccessPointName() {
        return sysMobileAccessPointName;
    }

    public void setSysMobileAccessPointName(String sysMobileAccessPointName) {
        this.sysMobileAccessPointName = sysMobileAccessPointName;
    }

    public Integer getUpdateServerPort() {
        return updateServerPort;
    }

    public void setUpdateServerPort(Integer updateServerPort) {
        this.updateServerPort = updateServerPort;
    }

    public Integer getFwState() {
        return fwState;
    }

    public void setFwState(Integer fwState) {
        this.fwState = fwState;
    }

    public Integer getSysResetReason() {
        return sysResetReason;
    }

    public void setSysResetReason(Integer sysResetReason) {
        this.sysResetReason = sysResetReason;
    }

    public Integer getSysJoinNodeCount() {
        return sysJoinNodeCount;
    }

    public void setSysJoinNodeCount(Integer sysJoinNodeCount) {
        this.sysJoinNodeCount = sysJoinNodeCount;
    }

    public Integer getSysTimeZone() {
        return sysTimeZone;
    }

    public void setSysTimeZone(Integer sysTimeZone) {
        this.sysTimeZone = sysTimeZone;
    }

    public Integer getSysOpMode() {
        return sysOpMode;
    }

    public void setSysOpMode(Integer sysOpMode) {
        this.sysOpMode = sysOpMode;
    }

    public String getSelectedField() {
        return selectedField;
    }

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public Integer getSysMaxTemp() {
        return sysMaxTemp;
    }

    public void setSysMaxTemp(Integer sysMaxTemp) {
        this.sysMaxTemp = sysMaxTemp;
    }

    public Integer getSysMinTemp() {
        return sysMinTemp;
    }

    public void setSysMinTemp(Integer sysMinTemp) {
        this.sysMinTemp = sysMinTemp;
    }

    public Integer getSysCurTemp() {
        return sysCurTemp;
    }

    public void setSysCurTemp(Integer sysCurTemp) {
        this.sysCurTemp = sysCurTemp;
    }

    public Integer getSysSecurePort() {
        return sysSecurePort;
    }

    public void setSysSecurePort(Integer sysSecurePort) {
        this.sysSecurePort = sysSecurePort;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getAmiNetworkAddress() {
        return amiNetworkAddress;
    }

    public void setAmiNetworkAddress(String amiNetworkAddress) {
        this.amiNetworkAddress = amiNetworkAddress;
    }

    public String getAmiNetworkAddressV6() {
        return amiNetworkAddressV6;
    }

    public void setAmiNetworkAddressV6(String amiNetworkAddressV6) {
        this.amiNetworkAddressV6 = amiNetworkAddressV6;
    }

    public Integer getAmiNetworkDepth() {
        return amiNetworkDepth;
    }

    public void setAmiNetworkDepth(Integer amiNetworkDepth) {
        this.amiNetworkDepth = amiNetworkDepth;
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

    public String getNetworkKey() {
		return networkKey;
	}

	public void setNetworkKey(String networkKey) {
		this.networkKey = networkKey;
	}

	public Integer getNetworkKeyIdx() {
		return networkKeyIdx;
	}

	public void setNetworkKeyIdx(Integer networkKeyIdx) {
		this.networkKeyIdx = networkKeyIdx;
	}

    public void setGpioX(Double gpioX) {
        this.gpioX = gpioX;
    }

    public Double getGpioX() {
        return gpioX;
    }

    public void setGpioY(Double gpioY) {
        this.gpioY = gpioY;
    }

    public Double getGpioY() {
        return gpioY;
    }

    public void setGpioZ(Double gpioZ) {
        this.gpioZ = gpioZ;
    }

    public Double getGpioZ() {
        return gpioZ;
    }

    public String getSysHwVersion() {
        return sysHwVersion;
    }

    public void setSysHwVersion(String sysHwVersion) {
        this.sysHwVersion = sysHwVersion;
    }

    public String getSysSwVersion() {
        return sysSwVersion;
    }

    public void setSysSwVersion(String sysSwVersion) {
        this.sysSwVersion = sysSwVersion;
    }

    public Integer getSysEtherType() {
        return sysEtherType;
    }

    public void setSysEtherType(Integer sysEtherType) {
        this.sysEtherType = sysEtherType;
    }

    public Integer getSysMobileType() {
        return sysMobileType;
    }

    public void setSysMobileType(Integer sysMobileType) {
        this.sysMobileType = sysMobileType;
    }

    public Integer getSysMobileMode() {
        return sysMobileMode;
    }

    public void setSysMobileMode(Integer sysMobileMode) {
        this.sysMobileMode = sysMobileMode;
    }

    public String getSysTime() {
        return sysTime;
    }

    public void setSysTime(String sysTime) {
        this.sysTime = sysTime;
    }

    public String getSysServer() {
        return sysServer;
    }

    public void setSysServer(String sysServer) {
        this.sysServer = sysServer;
    }

    public Integer getSysServerPort() {
        return sysServerPort;
    }

    public void setSysServerPort(Integer sysServerPort) {
        this.sysServerPort = sysServerPort;
    }

    public Integer getSysServerAlarmPort() {
        return sysServerAlarmPort;
    }

    public void setSysServerAlarmPort(Integer sysServerAlarmPort) {
        this.sysServerAlarmPort = sysServerAlarmPort;
    }

    public Integer getSysLocalPort() {
        return sysLocalPort;
    }

    public void setSysLocalPort(Integer sysLocalPort) {
        this.sysLocalPort = sysLocalPort;
    }

    public Integer getSysState() {
        return sysState;
    }

    public void setSysState(Integer sysState) {
        this.sysState = sysState;
    }

    public Integer getSysMobileVendor() {
        return sysMobileVendor;
    }

    public void setSysMobileVendor(Integer sysMobileVendor) {
        this.sysMobileVendor = sysMobileVendor;
    }

    public String getSysSwRevision() {
        return sysSwRevision;
    }

    public void setSysSwRevision(String sysSwRevision) {
        this.sysSwRevision = sysSwRevision;
    }

    public Integer getSysPowerType() {
        return sysPowerType;
    }

    public void setSysPowerType(Integer sysPowerType) {
        this.sysPowerType = sysPowerType;
    }

    public Integer getSysStateMask() {
        return sysStateMask;
    }

    public void setSysStateMask(Integer sysStateMask) {
        this.sysStateMask = sysStateMask;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Long getMcuVarId() {
        return mcuVarId;
    }

    public void setMcuVarId(Long mcuVarId) {
        this.mcuVarId = mcuVarId;
    }

    public Integer getMcuCodeId() {
        return mcuCodeId;
    }

    public void setMcuCodeId(Integer mcuCodeId) {
        this.mcuCodeId = mcuCodeId;
    }

    public Integer getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(Integer deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getMcuTypeCodeId() {
        return mcuTypeCodeId;
    }

    public void setMcuTypeCodeId(Integer mcuTypeCodeId) {
        this.mcuTypeCodeId = mcuTypeCodeId;
    }

    public Integer getProtocolTypeCodeId() {
        return protocolTypeCodeId;
    }

    public void setProtocolTypeCodeId(Integer protocolTypeCodeId) {
        this.protocolTypeCodeId = protocolTypeCodeId;
    }

    public Code getMcuStatus() {
        return mcuStatus;
    }

    public void setMcuStatus(Code mcuStatus) {
        this.mcuStatus = mcuStatus;
    }

    public Integer getMcuStatusCodeId() {
        return mcuStatusCodeId;
    }

    public void setMcuStatusCodeId(Integer mcuStatusCodeId) {
        this.mcuStatusCodeId = mcuStatusCodeId;
    }

    public String getSysHwBuild() {
        return sysHwBuild;
    }

    public void setSysHwBuild(String sysHwBuild) {
        this.sysHwBuild = sysHwBuild;
    }

    public String getSysSerialNumber() {
        return sysSerialNumber;
    }

    public void setSysSerialNumber(String sysSerialNumber) {
        this.sysSerialNumber = sysSerialNumber;
    }

    public Integer getSysTlsPort() {
        return sysTlsPort;
    }

    public void setSysTlsPort(int sysTlsPort) {
        this.sysTlsPort = sysTlsPort;
    }

    public String getSysTlsVersion() {
        return sysTlsVersion;
    }

    public void setSysTlsVersion(String sysTlsVersion) {
        this.sysTlsVersion = sysTlsVersion;
    }
    
    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
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
}