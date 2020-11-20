package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.nuri.etk.entity.aimir.Code;
import com.nuri.etk.entity.aimir.Contract;
import com.nuri.etk.entity.aimir.Customer;
import com.nuri.etk.entity.aimir.DeviceModel;
import com.nuri.etk.entity.aimir.Location;
import com.nuri.etk.entity.aimir.Supplier;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * <p> 전기, 가스,수도 , 열량, 등의 미터 정보의 공통 속성을 정의한 클래스 </p>
 * 
 * 전기,수도,가스,열량,대용량가스
 * 모뎀이 M-Bus인 경우 또는 여러개의 미터를 가질 수 있는 모뎀의 경우 포트로 구분한다. 
 */

@Getter
@Setter
@NoArgsConstructor
public class Meter {
    
	/**
	 * 시스템이 부여한 시퀀스 아이디
	 */
	private Integer id;

	/**
	 * 미터 아이디
	 * <br>사람 혹은 장비에서 올라오는 값. 반드시 있어야 하는 값이며, 중복 되는 값은 사용할 수 없음
	 */
    private String mdsId;
    
    /**
     * 미터 설치 정보 (미터시리얼번호 외에 미터에서 관리하는 관리번호등등의 값이 될 수 있음
     */
    private String installProperty;

    /**
     * 공급사
     */
    private Supplier supplier;
    
    private Integer supplierId;
    
    /**
     * 미터 제조 정보
     */
    private DeviceModel model;
    
    private Integer modelId;
    
    /**
     * 미터 유형 코드
     * <br>1:전기, 2:수도, 3:가스, 4:열량, 5:보정기
     */
    private String meterType;

    private Integer meterTypeCodeId;
    /**
     * MBus 모뎀과 연결된 미터를 구분하기 위한 포트 번호
     */
    private Integer modemPort;

	/**
	 * 설치일자 yyyymmddhhmmss
	 */
    private String installDate;
    private String installDateHidden;
    private String installDateUpdate;

	/**
	 * 설치 아이디
	 */
    private String installId;

    /**
     * IHD 아이디
     */
    private String ihdId;

    /**
     * 사용량 임계치
     */
    private Double usageThreshold;
    
    /**
     * 계약정보
     */
    private Contract contract;
    
    
    /**
     * 검침주기 (5, 15, 30, 60분)
     */
    private Integer lpInterval;

    /**
     * 미터 시간과 서버 시간의 차. 시간차가 많으면 동기화를 해줘야 한다. 미터 관리 가젯
     */
    private Long timeDiff;

    /**
     * 미터와 연결된 모뎀 정보
     */
    private Modem modem;
    
    private Integer modemId;
    
    /**
     * 미터가 계측하는 대상 장비 (설비 또는 기타)
     */
    private EndDevice endDevice;
    
    private Integer endDeviceId;

    /**
     * 소프트웨어 버젼. 디지털  방식의 미터인 경우 해당 정보 있음 : Code 1.3.6 참조
     */
    private String swVersion;
    
    /**
     * 하드웨어 버젼. 디지털  방식의 미터인 경우 해당 정보 있음 : Code 1.3.7 참조
     */
    private String hwVersion;

    /**
     * 소프트웨어 명칭
     */
    private String swName;

    /**
     * 소프트웨어 업데이트 날짜. yyyymmddhhmmss
     */
    private String swUpdateDate;

    /**
     * 설치 이미지. 현장에 설치된 이미지를 실어야 한다.
     */
    private String installedSiteImg;

    /**
     * 미터 에러 발생 원인. 에러에 대한 원인 보여주기 위한 필드이지만 현재 이 정보를 갱신하는 곳이 없다.
     */
    private String meterCaution;

    /**
     * 미터에서 발생한 에러정보. 중요한 에러 정보를 보여주기 위한 필드이지만 현재 이 정보를 갱신하는 곳이 없다.
     */
    private String meterError;

    /**
     * 미터가 설치된 위치. 주소와는 다르다. 공급사(빌딩)에서 관리하는 공급(관리)지역
     */
	private Location location;

    private Integer locationId;
    /**
     * 미터가 설치된 상세 주소
     */
    private String address;

    /**
     * GIS 연동 X 좌표
     */
    private Double gpioX;

    /**
     * GIS 연동 Y 좌표
     */
    private Double gpioY;

    /**
     * GIS 연동 Z 좌표
     */
    private Double gpioZ;

    /**
     * 마지막 통신 날짜. yyyymmddhhmmss
     */
    private String lastReadDate;
    
    /**
     * 마지막 시간 동기화 날짜. yyyymmddhhmmss
     */
    private String lastTimesyncDate;
    
    /**
     * 마지막 변경날짜. yyyymmddhhmmss
     */
    private String writeDate;
    
    /**
     * 최종 검침 값
     */
    private Double lastMeteringValue;

    /**
     * 검침 최초 시작일. yyyymmddhhmmss
     */
    private String qualifiedDate;
    
	/**
	 * 유효기간. yyyymmddhhmmss
	 */
    private String expirationDate;
    
    /**
     * 펄스 상수 또는 에너지 상수(ke). 검침값을 kW로 환산하기 위한 상수이다.
     * <br>예로 펄스식 계량기의 경우 100펄스 당 1kW로 계산한다면 상수값을 100을 입력한다.
     * <br>주의해야할 점은 파서마다 상수를 이용한 환산 방법이 다를 수 있으므로 확인후 정확한 값을 입력해야 한다.
     */
    private Double pulseConstant;

    /**
     * 미터 상태. 미터 유형에 따라 상태값이 다르므로 코드를 참조한다.
     * <br>유형에 따른 미터 상태가 없으면 Code 1.3.3 을 이용한다.
     * <br>수도, 수도의 경우 1.3.1.2.1, 1.3.1.3.1을 참조한다.
     */
    private String meterStatus;
    
    private Integer meterStatusCodeId;
    /**
     * 미터가 하드웨어적/소프트웨어적으로 선불기능을 포함하고 있는지 아닌지 체크 
     * <br>default : false
     */
    private Boolean prepaymentMeter;
    
    /**
     * 미터제조일자. yyyymmddhhmmss
     */
    private String manufacturedDate;
	
    /**
     * 구입금액.
     */
	private Double purchasePrice;
	
	/**
     * GS1 - 바코드
     */
	private String gs1;

	private Double currentCredit;
	
	private Double oweCredit;
	
	private Double oweThreshold;
	
	private Integer distTrfmrSubstationId;
	
    private Integer shortId;

	public Meter getDistTrfmrSubstationMeter_A() {
		return distTrfmrSubstationMeter_A;
	}

	public void setDistTrfmrSubstationMeter_A(Meter distTrfmrSubstationMeterA) {
		distTrfmrSubstationMeter_A = distTrfmrSubstationMeterA;
	}

	public Integer getDistTrfmrSubstationMeter_A_id() {
		return distTrfmrSubstationMeter_A_id;
	}

	public void setDistTrfmrSubstationMeter_A_id(Integer distTrfmrSubstationMeterAId) {
		distTrfmrSubstationMeter_A_id = distTrfmrSubstationMeterAId;
	}

	public Meter getDistTrfmrSubstationMeter_B() {
		return distTrfmrSubstationMeter_B;
	}

	public void setDistTrfmrSubstationMeter_B(Meter distTrfmrSubstationMeterB) {
		distTrfmrSubstationMeter_B = distTrfmrSubstationMeterB;
	}

	public Integer getDistTrfmrSubstationMeter_B_id() {
		return distTrfmrSubstationMeter_B_id;
	}

	public void setDistTrfmrSubstationMeter_B_id(Integer distTrfmrSubstationMeterBId) {
		distTrfmrSubstationMeter_B_id = distTrfmrSubstationMeterBId;
	}

	public Meter getDistTrfmrSubstationMeter_C() {
		return distTrfmrSubstationMeter_C;
	}

	public void setDistTrfmrSubstationMeter_C(Meter distTrfmrSubstationMeterC) {
		distTrfmrSubstationMeter_C = distTrfmrSubstationMeterC;
	}

	public Integer getDistTrfmrSubstationMeter_C_id() {
		return distTrfmrSubstationMeter_C_id;
	}

	public void setDistTrfmrSubstationMeter_C_id(Integer distTrfmrSubstationMeterCId) {
		distTrfmrSubstationMeter_C_id = distTrfmrSubstationMeterCId;
	}

	private Meter distTrfmrSubstationMeter_A;
	
	private Integer distTrfmrSubstationMeter_A_id;

	private Meter distTrfmrSubstationMeter_B;
	
	private Integer distTrfmrSubstationMeter_B_id;

	private Meter distTrfmrSubstationMeter_C;
	
	private Integer distTrfmrSubstationMeter_C_id;
	
    private String protocolVersion;  //protocol Version
    
    private Integer amiNetworkDepth;  //AMI Virtual Network Depth
	
    private String amiNetworkAddress;  //AMI Virtual Network Address
	
	private Integer isManualMeter;
	
	private String friendlyName;

    private String deleteDate;
    
    private String phase;
    
    private String msa;
    

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	
	public Integer getIsManualMeter() {
		return isManualMeter;
	}

	public void setIsManualMeter(Integer isManualMeter) {
		this.isManualMeter = isManualMeter;
	}
	
	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	private String conditions;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMdsId() {
        return mdsId;
    }

    /**
     * 미터 아이디
     * <br>사람 혹은 장비에서 올라오는 값. 반드시 있어야 하는 값이며, 중복 되는 값은 사용할 수 없음
     * @param mdsId 미터아이디
     */
    public void setMdsId(String mdsId) {
        this.mdsId = mdsId;
    }
    
    public String getInstallProperty() {
		return installProperty;
	}

	public void setInstallProperty(String installProperty) {
		this.installProperty = installProperty;
	}

	public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }    

    public DeviceModel getModel() {
		return model;
	}

	public void setModel(DeviceModel model) {
		this.model = model;
	}	

	public String getMeterType() {
		return meterType;
	}

	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}

    public Integer getModemPort() {
        return modemPort;
    }

    public void setModemPort(Integer modemPort) {
        this.modemPort = modemPort;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }
    
    public String getInstallId() {
        return installId;
    }

    public void setInstallId(String installId) {
        this.installId = installId;
    }
    
	public void setInstallDateHidden(String installDate) {
        this.installDateHidden = installDate;
    }
    //temp Data
    public String getInstallDateHidden() {
        return installDateHidden;
    }
    
    //업데이트시 반영할 포멧(포멧팅 처리안함)
    public String getInstallDateUpdate() {
        return installDateUpdate;
    }

    public void setInstallDateUpdate(String installDate) {
        this.installDateUpdate = installDate;
    }

    public String getIhdId() {
        return ihdId;
    }

    public void setIhdId(String ihdId) {
        this.ihdId = ihdId;
    }

    public Double getUsageThreshold() {
        return usageThreshold;
    }

    public void setUsageThreshold(Double usageThreshold) {
        this.usageThreshold = usageThreshold;
    }
    
    public MCU getMcu() {
    	if(modem!=null && modem.getMcu()!=null)
    		return modem.getMcu();
    	else return null;
    }

    public Customer getCustomer() {
    	if(contract!=null && contract.getCustomer()!=null)
    		return contract.getCustomer();
    	else return null;
    }

    public void setCustomer(Customer customer) {
        this.contract.setCustomer(customer);
    }

    public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Integer getLpInterval() {
        return lpInterval==null ? 15:lpInterval;
    }

    public void setLpInterval(Integer lpInterval) {
        this.lpInterval = lpInterval;
    }

    public Long getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(Long timeDiff) {
        this.timeDiff = timeDiff;
    }

    public Modem getModem() {
        return modem;
    }

    public void setModem(Modem modem) {
        this.modem = modem;
    }

    public String getSwVersion() {
        return swVersion;
    }

    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion;
    }

	public String getHwVersion() {
        return hwVersion;
    }

    public void setHwVersion(String hwVersion) {
        this.hwVersion = hwVersion;
    }

    public String getSwName() {
        return swName;
    }

    public void setSwName(String swName) {
        this.swName = swName;
    }

    public String getSwUpdateDate() {
        return swUpdateDate;
    }

    public void setSwUpdateDate(String swUpdateDate) {
        this.swUpdateDate = swUpdateDate;
    }

    public String getInstalledSiteImg() {
        return installedSiteImg;
    }

    public void setInstalledSiteImg(String installedSiteImg) {
        this.installedSiteImg = installedSiteImg;
    }

    public String getMeterCaution() {
        return meterCaution;
    }

    public void setMeterCaution(String meterCaution) {
        this.meterCaution = meterCaution;
    }

    public String getMeterError() {
        return meterError;
    }

    public void setMeterError(String meterError) {
        this.meterError = meterError;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastReadDate() {
        return lastReadDate;
    }

    public void setLastReadDate(String lastReadDate) {
        this.lastReadDate = lastReadDate;
    }    
    
    public String getLastTimesyncDate() {
		return lastTimesyncDate;
	}

	public void setLastTimesyncDate(String lastTimesyncDate) {
		this.lastTimesyncDate = lastTimesyncDate;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
    public Double getLastMeteringValue() {
		return lastMeteringValue;
	}

	public void setLastMeteringValue(Double lastMeteringValue) {
		this.lastMeteringValue = lastMeteringValue;
	}	
    
    public String getQualifiedDate() {
		return qualifiedDate;
	}

	public void setQualifiedDate(String qualifiedDate) {
		this.qualifiedDate = qualifiedDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

    public void setPulseConstant(Double pulseConstant) {
        this.pulseConstant = pulseConstant;
    }

    public Double getPulseConstant() {
        return pulseConstant;
    }

    public Boolean getPrepaymentMeter() {
		return prepaymentMeter;
	}

	public void setPrepaymentMeter(Boolean prepaymentMeter) {
		this.prepaymentMeter = prepaymentMeter;
	}	

	public String getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
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
	
    public String getGs1() {
        return gs1;
    }

    public void setGs1(String gs1) {
        this.gs1 = gs1;
    }

    public void setMeterStatus(String meterStatus) {
        this.meterStatus = meterStatus;
    }

    public String getMeterStatus() {
        return meterStatus;
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

    public EndDevice getEndDevice() {
        return endDevice;
    }

    public void setEndDevice(EndDevice endDevice) {
        this.endDevice = endDevice;
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

    public Integer getModemId() {
        return modemId;
    }

    public void setModemId(Integer modemId) {
        this.modemId = modemId;
    }

    public Integer getEndDeviceId() {
        return endDeviceId;
    }

    public void setEndDeviceId(Integer endDeviceId) {
        this.endDeviceId = endDeviceId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getMeterTypeCodeId() {
        return meterTypeCodeId;
    }

    public void setMeterTypeCodeId(Integer meterTypeCodeId) {
        this.meterTypeCodeId = meterTypeCodeId;
    }

    public Integer getMeterStatusCodeId() {
        return meterStatusCodeId;
    }

    public void setMeterStatusCodeId(Integer meterStatusCodeId) {
        this.meterStatusCodeId = meterStatusCodeId;
    }

    public Integer getDistTrfmrSubstationId() {
        return distTrfmrSubstationId;
    }

    public void setDistTrfmrSubstationId(Integer distTrfmrSubstationId) {
        this.distTrfmrSubstationId = distTrfmrSubstationId;
    }

    public Integer getShortId() {
        return shortId;
    }

    public void setShortId(Integer shortId) {
        this.shortId = shortId;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }    

    public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getMsa() {
		return msa;
	}

	public void setMsa(String msa) {
		this.msa = msa;
	}
	
	public Double getCurrentCredit() {
		return currentCredit;
	}

	public void setCurrentCredit(Double currentCredit) {
		this.currentCredit = currentCredit;
	}

	public Double getOweCredit() {
		return oweCredit;
	}

	public void setOweCredit(Double oweCredit) {
		this.oweCredit = oweCredit;
	}

	public Double getOweThreshold() {
		return oweThreshold;
	}

	public void setOweThreshold(Double oweThreshold) {
		this.oweThreshold = oweThreshold;
	}
}