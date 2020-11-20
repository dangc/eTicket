package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class MeterJpo {
    
	private Integer id;

    private String mdsId;
    
    private String installProperty;

    private Supplier supplier;
    
    private Integer supplierId;
    
    private DeviceModel model;
    
    private Integer modelId;
    
    private String meterType;

    private Integer meterTypeCodeId;
    private Integer modemPort;

    private String installDate;
    private String installDateHidden;
    private String installDateUpdate;

    private String installId;

    private String ihdId;

    private Double usageThreshold;
    
    private Contract contract;

    private Integer lpInterval;

    private Long timeDiff;

    private Modem modem;
    
    private Integer modemId;
    
    private EndDevice endDevice;
    
    private Integer endDeviceId;

    private String swVersion;
    private String hwVersion;

    private String swName;

    private String swUpdateDate;

    private String installedSiteImg;

    private String meterCaution;

    private String meterError;

	private Location location;

    private Integer locationId;
    private String address;

    private Double gpioX;

    private Double gpioY;

    private Double gpioZ;

    private String lastReadDate;
    
    private String lastTimesyncDate;
    
    private String writeDate;
    
    private Double lastMeteringValue;

    private String qualifiedDate;
    
    private String expirationDate;
    
    private Double pulseConstant;

    private String meterStatus;
    
    private Integer meterStatusCodeId;
    private Boolean prepaymentMeter;
    
    private String manufacturedDate;
	
	private Double purchasePrice;

	private String gs1;

	private Double currentCredit;
	
	private Double oweCredit;
	
	private Double oweThreshold;
	
	private Integer distTrfmrSubstationId;
	
    private Integer shortId;

	private MeterJpo distTrfmrSubstationMeter_A;
	
	private Integer distTrfmrSubstationMeter_A_id;

	private MeterJpo distTrfmrSubstationMeter_B;
	
	private Integer distTrfmrSubstationMeter_B_id;

	private MeterJpo distTrfmrSubstationMeter_C;
	
	private Integer distTrfmrSubstationMeter_C_id;
	
    private String protocolVersion;  //protocol Version
    
    private Integer amiNetworkDepth;  //AMI Virtual Network Depth
	
    private String amiNetworkAddress;  //AMI Virtual Network Address
	
	private Integer isManualMeter;
	
	private String friendlyName;

    private String deleteDate;
    
    private String phase;
    
    private String msa;

	private String conditions;

	public Meter toDomain(){
        Meter meter = new Meter();
        meter.setMdsId(this.mdsId);
        meter.setIhdId(this.ihdId);
        meter.setMeterType(this.meterType);
        meter.setMeterStatus(this.meterStatus);
	    return meter;
    }




}