package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

@Getter
@Setter
@NoArgsConstructor
public class MCUJpo {

    private Integer id;

    private List<MCUJpo> childMcus = new ArrayList<MCUJpo>(0);

    private Long mcuVarId;

    private Integer mcuCodeId;

    private DeviceModel deviceModel;

    private Integer deviceModelId;

    private MCUJpo mcu;

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
    
    public MCU toDomain(){
        MCU mcu = new MCU();


        return mcu;
    }
}