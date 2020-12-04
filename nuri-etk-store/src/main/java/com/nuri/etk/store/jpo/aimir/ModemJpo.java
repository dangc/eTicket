package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.*;
import com.nuri.etk.entity.aimir.CommonConstants.Interface;
import com.nuri.etk.entity.aimir.CommonConstants.ModemType;
import com.nuri.etk.entity.aimir.CommonConstants.Protocol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

@Getter
@Setter
@NoArgsConstructor
public class ModemJpo {
    
    private Integer id;

    private String deviceSerial;

    private ModemJpo modem;
    
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
    
    public Modem toDomain(){
        Modem modem = new Modem();
        modem.setDeviceSerial(this.deviceSerial);
        return modem;
    }
}