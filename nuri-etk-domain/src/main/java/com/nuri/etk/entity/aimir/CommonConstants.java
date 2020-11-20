package com.nuri.etk.entity.aimir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuri.etk.entity.aimir.Code;

/**
 * CommonConstants.java Description 
 *
 * 
 * Date          Version     Author   Description
 * 2011. 5. 26.   v1.0       김상연         기기별 카테고리 타입
 *
 */
public class CommonConstants {
    private static Log log = LogFactory.getLog(CommonConstants.class);

    /**
     * 전기,가스,수도별로 순발열량/원유1톤순발열량 값으로
     * 사용량을 곱하면 TOE값을 구할수 있다.
     * 수도의경우 전력과 수도의 배출계수를 나눠어 나온 값인 0.783 을
     * 전력의  순발열량/원유1톤순발열량 에 곱하여 구한 값이다.
     * 
     * TOE 
     * 전력     : 사용량(kwh) * 순발열량(2150) / 원유1톤순발열량(10000000) =  사용량 * 0.000215 
     * 가스(LNG): 사용량(m3) * 순발열량(9550) / 원유1톤순발열량(10000000) =  사용량 * 0.000955 
     * 수도     : 사용량(m3) * 순발열량(2150) / 원유1톤순발열량(10000000)
     *                   * 0.783(수도배출계수(332) / 전력배출계수(424)) =  사용량 * 0.000168345 
     */
    public enum TOE{
        Energy(0.000215),
        GasLng(0.000955),
        Water(0.000168345),
        Heat(0.000215);
        
        private double value;
        
        TOE(double value){
            this.value = value;
        }
        public double getValue() {
            return value;
        }
    }
    
    public enum YesNo{
        Yes("1"),
        No("0");
        
        private String code;
        
        YesNo(String code){
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }
    
    public enum DefaultDate{
        LAST_HHMMSS("235959");
        
        private String value;
        DefaultDate(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum DateType{
        HOURLY("0"),           /** 시간별 */
        DAILY("1"),            /** 일별 */
        PERIOD("2"),           /** 기간별 */
        WEEKLY("3"),           /** 주별 */
        MONTHLY("4"),          /** 월별 */
        MONTHLYPERIOD("5"),    /** 월별 */
        WEEKDAILY("6"),        /** 요일별 */
        SEASONAL("7"),         /** 계절별 */
        YEARLY("8"),           /** 연별 */
        QUARTERLY("9");        /** 분기별 */

        private String code;
        
        DateType(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
    public enum WeekDay{
        Sunday("0","일","Sun"),       
        Monday("1","월","Mon"),       
        Tuesday("2","화","Tue"),      
        Wednesday ("3","수","Wed"),   
        Thursday ("4","목","Thu"),   
        Friday ("5","금","Fri"),      
        Saturday ("6","토","Sat");
        
        
        private String code;
        private String kor;
        private String eng;
        
        WeekDay(String code,String kor,String eng) {
            this.code = code;
            this.kor = kor;
            this.eng = eng;
        }
        
        public String getCode() {
            return this.code;
        }
        public String getKorName() {
            return this.kor;
        }
        public String getEngName() {
            return this.eng;
        }
    }

    public enum MeterType {
        EnergyMeter     ("METERINGDATA_EM","LP_EM","DAY_EM", "MONTH_EM", "MeteringDataEM","LpEM","DayEM", "MonthEM", "3.1"),
        GasMeter        ("METERINGDATA_GM","LP_GM","DAY_GM", "MONTH_GM", "MeteringDataGM","LpGM","DayGM", "MonthGM", "3.3"),
        WaterMeter      ("METERINGDATA_WM","LP_WM","DAY_WM", "MONTH_WM", "MeteringDataWM","LpWM","DayWM", "MonthWM", "3.2"),
        HeatMeter       ("METERINGDATA_HM","LP_HM","DAY_HM", "MONTH_HM", "MeteringDataHM","LpHM","DayHM", "MonthHM", "3.4"),
        VolumeCorrector("METERINGDATA_VC","LP_VC","DAY_VC", "MONTH_VC", "MeteringDataVC","LpVC","DayVC", "MonthVC", "3.5"),
        Electric        ("METERINGDATA_EM","LP_EM","DAY_EM", "MONTH_EM", "MeteringDataEM","LpEM","DayEM", "MonthEM", "3.1"),
        SolarPowerMeter("METERINGDATA_SPM","LP_SPM","DAY_SPM", "MONTH_SPM", "MeteringDataSPM","LpSPM","DaySPM", "MonthSPM", "3.6"),
        Inverter         ("METERINGDATA_EM","LP_EM","DAY_EM", "MONTH_EM", "MeteringDataEM","LpEM","DayEM", "MonthEM", "3.1"),
    	Compensator		 ("METERINGDATA_EM","LP_EM","DAY_EM", "MONTH_EM", "MeteringDataEM","LpEM","DayEM", "MonthEM", "3.1");
        
        private String meteringTableName;
        private String lpTableName;
        private String dayTableName;
        private String monthTableName;
        private String meteringClassName;
        private String lpClassName;
        private String dayClassName;
        private String monthClassName;
        private String serviceType;
        
        MeterType(String meteringTableName,String lpTableName, String dayTableName,
                String monthTableName,String meteringClassName,String lpClassName,
                String dayClassName, String monthClassName, String serviceType) {
            this.meteringTableName  = meteringTableName;
            this.lpTableName        = lpTableName;
            this.dayTableName       = dayTableName;
            this.monthTableName     = monthTableName;
            this.meteringClassName  = meteringClassName;
            this.lpClassName        = lpClassName;
            this.dayClassName       = dayClassName;
            this.monthClassName     = monthClassName;
            this.serviceType        = serviceType;
        }
        
        public String getLpTableName() {
            return lpTableName;
        }
        public String getMeteringTableName() {
            return meteringTableName;
        }
        public String getDayTableName() {
            return dayTableName;
        }
        public String getMonthTableName() {
            return monthTableName;
        }
        public String getServiceType() {
            return serviceType;
        }
        public String getMeteringClassName() {
            return meteringClassName;
        }
        public String getLpClassName() {
            return lpClassName;
        }
        public String getDayClassName() {
            return dayClassName;
        }
        public String getMonthClassName() {
            return monthClassName;
        }
        
        public static MeterType getByServiceType(String serviceType){
            for(MeterType m : MeterType.values()){
                if(m.getServiceType().equals(serviceType))
                    return m;
            }
            return null;
        }
    }
    
    public static Hashtable<String, Code> meterTypes = null;
    
    public enum Paging{
        FIRST(0),
        ROWPERPAGE(10),
        ROWPERPAGE_20(20),
        ROWPERPAGE_25(25),
        ROWPERPAGE_100(100);

        private int pageNum;
        
        Paging(int pageNum) {
            this.pageNum = pageNum;
        }
        
        public int getPageNum() {
            return this.pageNum;
        }
    }
    
    public enum Season{
        SPRING("Spring"),
        SUMMER("Summer"),
        AUTUMN("Autumn"),
        WINTER("Winter");

        private String season;
        
        Season(String season) {
            this.season = season;
        }
        
        public String getSeason() {
            return this.season;
        }
    }

    public enum RankingType{
        ZERO("0"),
        BEST("1"),
        WORST("2");

        private String type;
        
        RankingType(String type) {
            this.type = type;
        }
        
        public String getType() {
            return this.type;
        }
    }
    
    public enum ContractStatus{
        NORMAL("2.1.0"),    // 정상
        PAUSE ("2.1.1"),    // 휴지  코드나 화면상으로는 Temporary Pause 로 표시
        STOP  ("2.1.2"),    // 정지  코드나 화면상으로는 Pause 로 표시
        CANCEL("2.1.3"),    // 해지 코드나 화면상으로는 Termination으로 표시
        SUSPENDED("2.1.4"); // 유예

        private String code;
        
        ContractStatus(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
    /*
     * @ 탄소사용량 계산시 들어가는 SupplyTypeCode
     */
    public enum ChangeMeterTypeName {
        EM("EnergyMeter"),  
        WM("WaterMeter"),
        GM("GasMeter"),
        HM("HeatMeter"),
        VC("VolumeCorrector"),
        SPM("SolarPowerMeter");

        private String code;
        
        ChangeMeterTypeName(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
    public enum NativeDayTable{
        /*
        public static final String EM = "DAY_EM";
        public static final String GM = "DAY_GM";
        public static final String WM = "DAY_WM";
        public static final String HM = "DAY_HM";
        */
        EM("DAY_EM"),
        GM("DAY_GM"),
        WM("DAY_WM"),
        HM("DAY_HM"),
        SPM("DAY_SPM");

        private String tableName;
        
        NativeDayTable(String tableName) {
            this.tableName = tableName;
        }
        
        public String getTableName() {
            return this.tableName;
        }
    }
    
    private static Hashtable<String, Code> protocolCodes = null;
    
    public static String getProtocolType(String type, String mode)
    {
        String protocolType = "";
        
        int mobileType = Integer.parseInt(type);
        int commMode = Integer.parseInt(mode);
        
        if (MobileType.DISABLE.getCode() == mobileType)
        {
            protocolType = Protocol.LAN.name();
        }
        else if (MobileType.GSM.getCode() == mobileType)
        {
            if (CommunicationMode.CSD.getCode() == commMode || 
                    CommunicationMode.PACKET.getCode() == commMode)
            {
                protocolType = Protocol.GSM.name();
            }
            else if (CommunicationMode.ALWAYSON.getCode() == commMode)
            {
                protocolType = Protocol.GPRS.name();
            }
        }
        else if (MobileType.CDMA.getCode() == mobileType)
        {
            if (CommunicationMode.CSD.getCode() == commMode ||
                    CommunicationMode.PACKET.getCode() == commMode)
                protocolType = Protocol.CDMA.name();
            else if (CommunicationMode.ALWAYSON.getCode() == commMode)
                protocolType = Protocol.LAN.name();
        }
        else if (MobileType.PSTN.getCode() == mobileType)
        {
            protocolType = Protocol.PSTN.name();
        }

        return protocolType;
    }
    
    
    public enum MobileType {
        DISABLE(0),
        GSM(1),
        CDMA(2),
        PSTN(3);        
        
        private Integer code;
        
        MobileType(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
    }
    
    public enum CommunicationMode {
        CSD(0),
        PACKET(1),
        ALWAYSON(2);        
        
        private Integer code;
        
        CommunicationMode(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
    }
    
    /**
     * <p>Java class for protocol.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;simpleType name="protocol">
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *     &lt;enumeration value="IP"/>
     *     &lt;enumeration value="CDMA"/>
     *     &lt;enumeration value="GSM"/>
     *     &lt;enumeration value="GPRS"/>
     *     &lt;enumeration value="PSTN"/>
     *     &lt;enumeration value="LAN"/>
     *     &lt;enumeration value="ZigBee"/>
     *     &lt;enumeration value="UDP"/>
     *     &lt;enumeration value="WiMAX"/>
     *     &lt;enumeration value="Serial"/>
     *     &lt;enumeration value="PLC"/>
     *     &lt;enumeration value="Bluetooth"/>
     *     &lt;enumeration value="SMS"/>
     *     &lt;enumeration value="REVERSEGPRS"/>
     *     &lt;enumeration value="BYPASS"/>
     *   &lt;/restriction>
     * &lt;/simpleType>
     * </pre>
     * 
     */

    @XmlType(name = "protocol")
    @XmlEnum
    public enum Protocol {
    	@XmlEnumValue("IP")
        IP,
        @XmlEnumValue("CDMA")
        CDMA,
        @XmlEnumValue("GSM")
        GSM,
        @XmlEnumValue("GPRS")
        GPRS,
        @XmlEnumValue("PSTN")
        PSTN,
        @XmlEnumValue("LAN")
        LAN,
        @XmlEnumValue("ZigBee")
        ZigBee,
        @XmlEnumValue("UDP")
        UDP,
        @XmlEnumValue("WiMAX")
        WiMAX,
        @XmlEnumValue("Serial")
        Serial,
        @XmlEnumValue("PLC")
        PLC,
        @XmlEnumValue("Bluetooth")
        Bluetooth,
        @XmlEnumValue("SMS")
        SMS,
        @XmlEnumValue("REVERSEGPRS")
        REVERSEGPRS,
        @XmlEnumValue("BYPASS")
    	BYPASS;
    }
    
    public static McuType getMCUType(int code) {
        for (McuType type : McuType.values()) {
            if (type.getCode() == code)
                return type;
        }

        return McuType.Indoor;
    }
    
    private static Hashtable<String, Code> mcuTypes = null;
    
    public enum McuStatus {
    //집중기 삭제 여부 판별 코드
        Normal("1.1.4.1"),
        Delete("1.1.4.2"),
        PowerDown("1.1.4.3"),
        SecurityError("1.1.4.4"),
        CommError("1.1.4.5"),
        Deativate("1.1.4.6");
        
        private String code;
        
        McuStatus(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
        
    }
    
    /**
     * <p>Java class for mcuType.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;simpleType name="mcuType">
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *     &lt;enumeration value="Indoor"/>
     *     &lt;enumeration value="Outdoor"/>
     *     &lt;enumeration value="DUALGW"/>
     *     &lt;enumeration value="DCU"/>
     *     &lt;enumeration value="MMIU"/>
     *     &lt;enumeration value="IEIU"/>
     *     &lt;enumeration value="Converter"/>
     *     &lt;enumeration value="UNKNOWN"/>
     *   &lt;/restriction>
     * &lt;/simpleType>
     * </pre>
     * 
     */
    @XmlType(name = "mcuType")
    @XmlEnum
    public enum McuType {
        @XmlEnumValue("Indoor")
        Indoor(3),
        @XmlEnumValue("Outdoor")
        Outdoor(4),
        @XmlEnumValue("DUALGW")
        DUALGW(8),
        @XmlEnumValue("DCU")
        DCU(7),
        @XmlEnumValue("MMIU")
        MMIU(11),
        @XmlEnumValue("IEIU")
        IEIU(13),
        @XmlEnumValue("SubGiga")
        SubGiga(17),
        @XmlEnumValue("ZRU")
        ZRU(18), 
        @XmlEnumValue("Converter")
        Converter(19),
        @XmlEnumValue("UNKNOWN")
        UNKNOWN(0);
        
        private int code;
        
        McuType(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }
    }
    
    private static Hashtable<String, Code> interfaceCodes;
    
    /**
     * <p>Java class for interface.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;simpleType name="interface">
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *     &lt;enumeration value="IF1"/>
     *     &lt;enumeration value="IF2"/>
     *     &lt;enumeration value="IF3"/>
     *     &lt;enumeration value="Unknown"/>
     *     &lt;enumeration value="IF4"/>
     *     &lt;enumeration value="IF5"/>
     *     &lt;enumeration value="IF6"/>
     *     &lt;enumeration value="IF7"/>
     *     &lt;enumeration value="IF8"/>
     *     &lt;enumeration value="IF9"/>
     *     &lt;enumeration value="AMU"/>
     *     &lt;enumeration value="TNG"/>
     *     &lt;enumeration value="SMS"/>
     *   &lt;/restriction>
     * &lt;/simpleType>
     * </pre>
     * 
     */
    @XmlType(name = "interface")
    @XmlEnum
    public enum Interface {
        @XmlEnumValue("IF1")
        IF1("IF1"),
        @XmlEnumValue("IF2")
        IF2("IF2"),
        @XmlEnumValue("IF3")
        IF3("IF3"),
        @XmlEnumValue("Unknown")
        Unknown("Unknown"),
        @XmlEnumValue("IF4")
        IF4("IF4/5"),
        @XmlEnumValue("IF5")
        IF5("IF4/5"),
        @XmlEnumValue("IF6")
        IF6("IF6"),
        @XmlEnumValue("IF7")
        IF7("IF7"),
        @XmlEnumValue("IF8")
        IF8("IF8"),
        @XmlEnumValue("IF9")
        IF9("IF9"),
        @XmlEnumValue("AMU")
        AMU("AMU"),
        @XmlEnumValue("TNG")
        TNG("TNG"),
        @XmlEnumValue("SMS")
        SMS("SMS");
        
        private String name;
        
        Interface(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
    }
    
    private static Hashtable<String, Code> headerSvcs = null;
    
    private static Hashtable<String, Code> dataSvcs = null;
    
    public static DataSVC getDataSVC(int code) {
        for (DataSVC svc : DataSVC.values()) {
            if (svc.getCode() == code)
                return svc;
        }

        return DataSVC.Unknown;
    }
    
    public enum DataSVC {
        Unknown(0), Electricity(1), Gas(2), Water(3), WarmWater(4),
        Cooling(5), Heating(6), Volume(7), ColdWater(8), SmokeDetector(9),
        Solar(10), InterfaceDevice(10), EnvSensor(11), SmartEnergyGW(97);
        
        private int code;
        
        DataSVC(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }
    }
    
    private static Hashtable<String, Code> senderReceivers = null;
    
    public static Hashtable<String, Code> modemPowerTypes = null;
    
    public enum ModemPowerType {
        Unknown(0x00),
        Line(0x01),
        Battery(0x02),
        Solar(0x04);
        
        private int code;
        
        ModemPowerType(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }
    }
    
    public static ModemPowerType getModemPowerType(int code) {
        for (ModemPowerType type : ModemPowerType.values()) {
            if (type.getCode() == code)
                return type;
        }

        return ModemPowerType.Unknown;
    }
    
    public static Hashtable<String, Code> modemTypes = null;
    
    public static ModemType getModemType(int code) {
        for (ModemType type : ModemType.values()) {
            if (code == type.getCode()) {
                return type;
            }
        }

        return ModemType.Unknown;
    }
    
    public static ModemType getModemTypeName(String name) {
        for (ModemType type : ModemType.values()) {
            if (type.name().equals(name)) {
                return type;
            }
        }

        return ModemType.Unknown;
    }
    
    public enum CommandType {
        DeviceRead(0), DeviceWrite(1);        
                
        private Integer code;
        
        CommandType(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
    }

    // sjhan 외주개발과제 전용으로 사용하기 위해 SmartEnergyGW(97)를 추가하였습니다.
    public enum ModemType {
        Unknown(0), ZRU(1), ZMU(2), MMIU(11), IEIU(13), PLCIU(18), ZEUPLS(5), 
        ZEUMBus(14), ZBRepeater(98), IHD(15), ACD(16), HMU(17), Converter(19), 
        PLC_G3(23), PLC_PRIME(24), SmartEnergyGW(97), SubGiga(101), ZigBee(200), LTE(201);
                
        private Integer code;
        
        ModemType(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
        
        public static boolean isModemType(String name){
            for (ModemType type : ModemType.values()) {
                if (type.name().equals(name)) {
                    return true;
                }
            }
            return false;
        }
        
        
    }
    
    public enum ModemNetworkType {
        Unknown(0xFF), RFD(0x08), FFD(0x00);
        
        private int code;
        
        ModemNetworkType(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }
    }
    
    public static ModemNetworkType getModemNetworkType(int code) {
        for (ModemNetworkType type : ModemNetworkType.values()) {
            if (type.getCode() == code) {
                return ModemNetworkType.RFD;
            }
        }
        return ModemNetworkType.Unknown;
    }
    
    public enum ModemNodeKind {
        Unknown(0), Gas(1), Water(2), Electronic(3), ACD(4), HMU(5), SmokeDector(100), Repeater(255);
        
        private int code;
        
        ModemNodeKind(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }
    }
    
    public static ModemNodeKind getModemNodeKind(int code) {
        for (ModemNodeKind kind : ModemNodeKind.values()) {
            if (kind.getCode() == code)
                return kind;
        }
        return ModemNodeKind.Unknown;
    }
    
    public static Hashtable<String, Code> contractStatus = null;
    
    public static Hashtable<String, Code> meterStatuses = null;
    
    public enum MeterStatus {
    	Normal("1.3.3.1"),
        BreakDown("1.3.3.2"),
        Repair("1.3.3.3"),
        CutOff("1.3.3.4"),
        PowerDown("1.3.3.5"),
        MeteringFail("1.3.3.6"),
        LogView("1.3.3.7"),
        NewRegistered("1.3.3.8"),
        Delete("1.3.3.9"),
        Activation("1.3.3.10"),
        Deactivation("1.3.3.11"),
        Abnormal("1.3.3.12"),
        SecurityError("1.3.3.13"),
        CommError("1.3.3.14");
    	
        private String code;
        
        MeterStatus(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
    public static Hashtable<String, Code> gasMeterStatuses = null;
    
    public static Hashtable<String, Code> gasAlarmStatuses = null;
    
    public static Hashtable<String, Code> waterMeterStatuses = null;
    
    public static Hashtable<String, Code> waterAlarmStatuses = null;
    
    public enum DeviceType {

        MCU(0), Modem(1), Meter(2), EndDevice(3);
        
        private Integer code;
        
        DeviceType(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public static DeviceType getDeviceType(int code){
            
            DeviceType value = null;
            for (DeviceType type: DeviceType.values()) {
                if (type.getCode() == code)
                    value = type;
            }
            
            return value;
        }
    }

    public enum MeterVendor {

        UNKNOWN(new Integer[]{0x00}, "Unknown"),
        KAMSTRUP(new Integer[]{0x01, 0x28, 0x29}, "Kamstrup"), // 0x01:2.4.2.1 Aidon 5530 / Kmastup KMP Metering, 0x28:2.4.2.2 Kamstrup Enhanced, 0x29:Kamstrup Omnipower
        GE(new Integer[]{0x02}, "GE"),
        ELSTER(new Integer[]{0x03}, "Elster"),
        LANDIS(new Integer[]{0x04}, "Ladis+Gyr"),
        AIDON(new Integer[]{0x05}, "Aidon"),
        LSIS(new Integer[]{0x06}, "LSIS"),
        WIZIT(new Integer[]{0x07}, "Wizit"),
        Actaris(new Integer[]{0x08}, "Actraris"),
        GASMETER(new Integer[]{0x09}, "GasMeter"),
        EDMI(new Integer[]{0x0A}, "EDMI"),
        KETI(new Integer[]{0x0B}, "KETI"),
        Namjunsa(new Integer[]{0x0C}, "Namjunsa"),
        Daehan(new Integer[]{0x0D}, "Daehan"),
        ABB(new Integer[]{0x0E}, "ABB"),
        Kumho(new Integer[]{0x0F}, "Kumho"),
        Iljin(new Integer[]{0x10}, "Iljin"),
        Taegwang(new Integer[]{0x11}, "Taegwang"),
        PSTec(new Integer[]{0x12}, "PSTec"),
        KT(new Integer[]{0x13}, "KT"),
        Seochang(new Integer[]{0x14}, "Seochang"),
        Chunil(new Integer[]{0x15}, "Chunil"),
        AMAltec(new Integer[]{0x16}, "AMAltec"),
        DMPower(new Integer[]{0x17}, "DMPower"),
        AMSTech(new Integer[]{0x18}, "AMSTech"),
        OmniSystem(new Integer[]{0x19}, "OmniSystem"),
        KoreaMicronic(new Integer[]{0x1A}, "KoreaMicronic"),
        Hyupshin(new Integer[]{0x1B}, "Hyupshin"),
        MSM(new Integer[]{0x1C}, "MSM"),
        PowerPluscom(new Integer[]{0x1D}, "PowerPluscom"),
        YPP(new Integer[]{0x1E}, "YPP"),
        Pyongil(new Integer[]{0x1F}, "Pyongil"),
        AEG(new Integer[]{0x20}, "AEG"),
        ANSI(new Integer[]{0x21}, "ANSI"),
        Sensus(new Integer[]{0x22}, "Sensus"),
        Itron(new Integer[]{0x23}, "Itron"),
        Kromschroder(new Integer[]{0x24}, "Kromschroder"),
        Siemens(new Integer[]{0x25}, "Siemens"),
        Mitsubishi(new Integer[]{0x26}, "Mitsubishi"),
        Osaki(new Integer[]{0x27}, "Osaki"),
        Wasion(new Integer[] {0x2F},"Wasion"),
        Kyoungseongjenix(new Integer[]{0x2A}, "Kyoungseongjenix"),
        Shinhanjeongmil(new Integer[]{0x2B}, "Shinhanjeongmil"),
        ETC(new Integer[]{0xFE}, "ETC"),
        Nuritelecom(new Integer[]{0xFF}, "Nuritelecom"),
        NURITelecom(new Integer[] {0xFF}, "NURITelecom"),
        Kaifa(new Integer[]{0x2D}, "Kaifa");
        
        private Integer[] code;
        
        private String name;
        
        MeterVendor(Integer[] code, String name) {
            this.code = code;
            this.name = name;
        }
        
        public Integer[] getCode() {
            return this.code;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
    public static MeterVendor getMeterVendor(int code) {
        for (MeterVendor mv : MeterVendor.values()) {
            for (int _code : mv.getCode())
                if (_code == code) return mv;
        }
        
        return MeterVendor.UNKNOWN;
    }
    
    public enum MeterModel {

        DLMSKEPCO(77),
        MT_MODEL_UNKNOWN(0),
        KAMSTRUP_162(1),
        KAMSTRUP_382(2),
        KAMSTRUP_601(144),
        MULTICAL_COMPACT(1),
        MULTICAL_401(2),
        AIDON_5520(3),
        GE_I210(4),
        GE_KV2C(5),
        AIDON_5540(6),
        ELSTER_A1RL(7),
        ELSTER_A3RLNQ(8),
        LANDIS_ZMD(9),
        LANDIS_ZMQ(10),
        AIDON_5530(11),
        GE_SM110(12),
        GE_I210P(13),
        GE_SM300(20),
        GE_I210_Plus(201),
        GE_I210_Plus_c(202),
        GE_I210_Plus_n(203),
        GE_I210_Plus_cn(204),
        GEFE_Azos_GFI(205),
        ELSTER_A1700(21),
        ELSTER_A1140(22),
        LSIS_LK3410CP_005(14),
        LSIS_LGRW3410(15),
        LSIS_LK1210DRB_120(16),
        LSIS_LK3410DRB_120(17),
        EDMI_Mk6N(18),
        WIZIT_KDH(139),
        ACTARIS_SEVCD(151),
        ACTARIS_SEVC(152),
        ACTARIS_CORUS(153),
        ACTARIS_Saudi(154),
        EQUIPMENT_NEXCORR(171),
        GASMICRO_GASMICRO(191),
        INSTROMET_555(181),
        INSTROMET_999(182),
        ELSTER_EK88(161),
        ELSTER_EK260(162),
        ELSTER_A2R(19),
        SEOCHANG_02(161),
        SEOCHANG_05(162),
        LSIS_05(163),
        LANDIS_02(164),
        LANDIS_05(165),
        MITSUBISHI_MX2(214),
        ELSTER_A1830RLNQ(215),
        EDMI_Mk10A(216),
        EDMI_Mk10E(217);
        
        private Integer code;
        
        MeterModel(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
    }

    
    public enum ResultStatus{
        SUCCESS(0),
        FAIL(1),
        INVALID_PARAMETER(2),
        COMMUNICATION_FAIL(3);
        
        private Integer code;
        
        ResultStatus(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
        
        public static ResultStatus getResultStatus(Integer code) {
            for (ResultStatus status : values()) {
                if (status.getCode() == code) return status;
            }
            return null;
        }
    }
    
    public enum OperatorType{
        SYSTEM(0),
        OPERATOR(1),
        OFFLINE(2);//Field workers
        
        private Integer code;
        
        OperatorType(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }       
    }
    
    public enum GroupType{
        Contract,
        EndDevice,
        HomeGroup,
        IHD,
        Location,
        MCU,
        DCU,
        Meter,
        Modem,
        Operator;
        
    }
    
    public enum PeakType{
        OFF_PEAK,
        PEAK,
        CRITICAL_PEAK;      
    }
    
    public enum PeakAndDemandThreshold {
        
        GOOD(1),
        WARNING(2),
        CRITICAL(3);
        
        private Integer code;
        
        PeakAndDemandThreshold(int code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
    }
    
    public enum LoginStatus{
        LOGIN(0),
        LOGOUT(1),
        INVALID_ID(2),
        INVALID_PASSWORD(3),
        NOT_ALLOWED_IPADDR(4),
        LOGIN_IS_DENIED(5),
    	ACCOUNT_IS_LOCKED(6),
    	ACCOUNT_IS_UNLOCKED(7);
    	
        private Integer code;
        
        LoginStatus(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
    }
    
    public enum DefaultChannel {

        Co2(0), Usage(1), Integrated(98), ValidationStatus(100);
        
        private Integer code;
        
        DefaultChannel(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
    }
    
    public enum ElectricityChannel {

        Co2(0), Usage(1), Integrated(98), PowerFactor(99), ValidationStatus(100);
        
        private Integer channel;
        
        ElectricityChannel(Integer channel) {
            this.channel = channel;
        }
        
        public Integer getChannel() {
            return this.channel;
        }
    }
    
    public enum IntegratedFlag {
        NOTSENDED(0),
        SENDED(1),
        PARTIALSENDED(2),
        FIRSTSENDEDERROR(3);        
        
        private Integer flag;
        
        IntegratedFlag(Integer flag) {
            this.flag = flag;
        }
        
        public Integer getFlag() {
            return this.flag;
        }
    }
    
    /*
     * 우즈벡 가스 밸브 컨트롤의 밸브 상태 코드
     */
    public enum UzkValveState{
        
        VALVE_OPEN(1),
        MANUAL_VALVE_SHUTOFF(2),
        VAVLE_OPEN_ACTIVATED(3),
        VIBRATION_DETECTED_AND_VALVE_SHUTOFF(4),
        VALVE_OPEN_FAULT(5),
        VALVE_SHUTOFF_FAULT(6),
        VALVE_SHUTOFF_FOR_GAS_LEAK(7),
        REMOTE_VALVE_SHUTOFF(8),
        TAMPER_DETECTED_AND_VALVE_SHUTOFF(9),
        CASEOPEN_DETECTED_AND_VALVE_SHUTOFF(10);
        
        private Integer state;
        
        UzkValveState(Integer state){
            this.state = state;
        }
        
        public Integer getCode(){
            return this.state;
        }
        
        public int getIntValve(){
            return this.state.intValue();
        }
    }
    
    /*
     * 우즈벡 가스 계량기 이벤트/알람 메시지
     */
    public  enum GasValveState{
        LOW_BATTERY(1),
        CASE_OPEN(2),
        LOW_BATTERY_AND_CASE_OPEN(3),
        TAMPER_SENSOR_ON(4),
        LOW_BATTERY_AND_TAMPER_SENSOR_ON(5),
        TAMPER_SENSOR_ON_AND_CASE_OPEN(6),
        LOW_BATTERY_AND_TAMPER_SENSOR_ON_AND_CASE_OPEN(7),
        GAS_USED_IN_VALVE_SHUTOFF_STATE(8);
        
        private Integer state;
        
        GasValveState(Integer state){
            this.state = state;
        }
        
        public Integer getCode(){
            return this.state;
        }
        
        public int getIntValve(){
            return this.state.intValue();
        }
    }
    
    public static TR_OPTION[] getTrOption(int code)
    throws Exception
    {
        List<TR_OPTION> trOption = new ArrayList<TR_OPTION>();
        for (int i = 0; i < TR_OPTION.values().length; i++) {
            if (((byte)TR_OPTION.values()[i].getCode() & (byte)code) != 0x00) {
                trOption.add(TR_OPTION.values()[i]);
            }
        }
        if (trOption.size() == 0) {
            throw new Exception("Invalid trcode[" + code + "]");
        }
        else {
            return trOption.toArray(new TR_OPTION[trOption.size()]);
        }
    }
    
    public enum TR_OPTION {
        ASYNC_OPT_RETURN_CODE_EVT(0x01),
        ASYNC_OPT_RETURN_DATA_EVT(0x02),
        ASYNC_OPT_RETURN_CODE_SAVE(0x10),
        ASYNC_OPT_RETURN_DATA_SAVE(0x20);

        private int code;
        TR_OPTION(int code) {
            this.code = code;
        }
        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
    }
    
    public static TR_STATE getTrState(int code)
    throws Exception
    {
        for (int i = 0; i < TR_STATE.values().length; i++) {
            if (TR_STATE.values()[i].getCode() == code) {
                return TR_STATE.values()[i];
            }
        }
        throw new Exception("Invalid trstate[" + code + "]");
    }
    
    public enum TR_STATE {
        Success(0x00),
        Waiting(0x01),
        Running(0x02),
        Terminate(0x04),
        Delete(0x08),
        Unknown(0xFF);

        private int code;
        TR_STATE(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        
        static public TR_STATE valueOf(Integer code){
            TR_STATE[] values = TR_STATE.values();
            for (TR_STATE trigger : values) {
                if(trigger.getCode()==code){
                    return trigger;
                }
            }
            return Unknown;
        }
    }
    
    public static TR_EVENT getTrEvent(int code)
    throws Exception
    {
        for (int i = 0; i < TR_EVENT.values().length; i++) {
            if (TR_EVENT.values()[i].getCode() == code) {
                return TR_EVENT.values()[i];
            }
        }
        throw new Exception("Invalid trevent[" + code + "]");
    }
    
    public enum TR_EVENT {
        CodeEvent(0x01),
        DataEvent(0x02);

        private int code;
        TR_EVENT(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
    }
    
    
    public enum McuDiagnosisResult {
        McuState(0, new String[]{"Normal", "Abnormal"}),
        SINK1State(1, new String[]{"Normal", "Abnormal"}),
        SINK2State(2, new String[]{"Normal", "Abnormal"}),
        PowerState(3, new String[]{"Normal", "Power Fail"}),
        BatteryState(4, new String[]{"Normal", "Low Battery"}),
        TemperatureState(5, new String[]{"Normal", "Abnormal"}),
        MemoryState(6, new String[]{"Normal", "Memory Threshold"}),
        FlashState(7, new String[]{"Normal", "Flash Threshold"}),
        GSMState(8, new String[]{"Normal", "No Modem", "No SIM Card", "Not Ready", "Bad CSQ"}),
        EtherState(9, new String[]{"Link Up", "Link Donw"});
        
        private int code;
        private String[] state;
        
        McuDiagnosisResult(int code, String[] state) {
            this.code = code;
            this.state = state;
        }
        
        public int getCode() {
            return code;
        }
        
        public String[] getState() {
            return state;
        }
    }
    
    public enum FW_EQUIP {
        MCU(0, "MCUFirmware"),
        Modem(1, "ModemFirmware"),
        Coordinator(2, "CodiFirmware"),
        All(99, "");
        
        private int kind;
        @SuppressWarnings("unused")
        private String tableName;
        
        FW_EQUIP(int kind, String tableName) {
            this.kind = kind;
            this.tableName = tableName;
        }
        
        public int getKind() {
            return kind;
        }
    }
    
    public static FW_EQUIP getFwEquip(int kind) {
        for (FW_EQUIP equip : FW_EQUIP.values()) {
            if (equip.getKind() == kind) {
                return equip;
            }
        }
        
        return FW_EQUIP.All;
    }
    
    public enum FW_TRIGGER {
        Init(0),
        Download(1),
        Start(2),
        End(3),
        Success(4),
        Unknown(100);
        
        private int code;
        
        FW_TRIGGER(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }
        
        static public FW_TRIGGER valueOf(Integer code){
            FW_TRIGGER[] values = FW_TRIGGER.values();
            for (FW_TRIGGER trigger : values) {
                if(trigger.getCode()==code){
                    return trigger;
                }
            }
            return Unknown;
        }
    }

    public enum FW_OTA {
        Init(0x00),
        Check(0x01),
        DataSend(0x02),
        Verify(0x04),
        Install(0x08),
        Scan(0x10),
        All(0x1F);
        
        private int step;
        
        FW_OTA(int step) {
            this.step = step;
        }
         
        public int getStep() {
            return step;
        }
        static public FW_OTA stepOf(Integer step){
            FW_OTA[] values = FW_OTA.values();
            for (FW_OTA fwOTA : values) {
                if(fwOTA.getStep()==step){
                    return fwOTA;
                }
            }
            return All;
        }
    }

    public enum FW_STATE {
        Success(0),
        Fail(1),
        Cancel(2),
        Unknown(3);
        
        private int state;
        
        FW_STATE(int state) {
            this.state = state;
        }
        
        public int getState() {
            return state;
        }
        
        static public FW_STATE stateOf(Integer code){
            FW_STATE[] values = FW_STATE.values();
            for (FW_STATE fwSTATE : values) {
                if(fwSTATE.getState()==code){
                    return fwSTATE;
                }
            }
            return Unknown;
        }
    }
    
    public enum EventAlertType {   
        Event,
        Alert;
    }
    
    public enum MonitorType {
        SaveAndMonitor,
        Save,
        NoMonitor,
        AlertWindow;
    }
    
    public enum SeverityType{
        Normal(6),
        Information(5),
        Warning(4),
        Minor(3),
        Major(2),
        Critical(1);
        
        int priority;
        
        SeverityType(int priority) {
            this.priority = priority;
        }
        
        public int getPriority() {
            return this.priority;
        }
    }
    
    public enum EventStatus{
        Open,
        Cleared,
        Acknowledged,
        ClearedManually,
        OpenManually,
        NoSaveEvent;
    }
    
    public enum DisplayType {
        SaveAndDisplay,
        SaveOnly,
        DisplayOnly;
    }
    
    public enum CircuitBreakerStatus {       
        Deactivation(0),
        Activation(1),
        Standby(2);
        
        private int code;
        
        CircuitBreakerStatus(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return this.code;
        }
    }
    
    public enum CircuitBreakerCondition {       
        Emergency,
        Prepayment,
        LackOfBalance,
        ExceedsThreshold,
        HighVoltage;
    }
    
    public enum SupplierType {       
        Electricity,
        Gas,
        Water,
        Heat,
        VolumeCorrector;
    }
    
    public enum MeteringType {
        Normal(0),
        OnDemand(1),
        Recovery(2),
        Manual(3);
        
        private int type;
        
        MeteringType(int type) {
            this.type = type;
        }
        
        public int getType() {
            return this.type;
        }
    }
    
    public enum VEEType {
        Validation,
        Editing,
        Estimation;
    }
    
    public enum VEEParam {
        AbnormalHighDemand,
        AbnormalHighUsage,
        AbnormalLoadFactor,
        AbnormalLowDemand,
        AbnormalLowUsage,
        AbnormalMeterId,
        AbnormalMeterTime,      
        AbnormalPowerFactor,
        DataGaps,
        NegativeConsumption,
        OutOfThreshold,
        ZeroConsumption;
    }
    
    public enum VEETableItem {
        Meter,
        EventAlertLog,
        LoadProfile,
        Day,
        Month;
    }
    
    public enum VEETableItemValue {
        Meter(""),  
        EventAlertLog(""),
        LoadProfile("value_00"),
        Day("total"),
        Month("total");

        private String value;
        
        VEETableItemValue(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return this.value;
        }
    }
    
    public enum VEEThresholdItem {
        Sum,
        Average,
        Maximum,
        Minimum;
    }
    
    public enum VEEThresholdItemValue {
        Sum("SUM"),  
        Average("AVG"),
        Maximum("MAX"),
        Minimum("MIN");

        private String value;
        
        VEEThresholdItemValue(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return this.value;
        }
    }
    
    public enum VEEPeriodItem {
        LastDay,
        LastMonth,
        LastYear;
    }
    
    public enum EditItem{
        Verified(0),
        AutomaticEstimated(1),
        UserDefinedEstimated(2),
        RuleBasedEstimated(3),
        IndividualEdited(4);

        private Integer code;
        
        EditItem(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public int getIntValue() {
            return this.code.intValue();
        }
    }
    
    public enum OutdoorIndoorType {       
        Indoor(0),
        Outdoor(1);
        private Integer inOutdoor;
        OutdoorIndoorType(Integer inOutdoor) {
            this.inOutdoor = inOutdoor;
        }
        
        public Integer getOutdoorIndoorType() {
            return this.inOutdoor;
        }
    }
    
    public enum LoadType {
        Emergency(0),
        Schedule(1),
        OnDemand(2);
        
        private Integer type;
        LoadType(Integer type) {
            this.type = type;
        }
        
        public Integer getCode() {
            return this.type;
        }
        
        public int getIntValue() {
            return this.type.intValue();
        }
    }
    
    public enum ScheduleType {
        Immediately(0),
        Date(1),
        DayOfWeek(2);
        private Integer type;
        ScheduleType(Integer type) {
            this.type = type;
        }
        
        public Integer getCode() {
            return this.type;
        }
        
        public int getIntValue() {
            return this.type.intValue();
        }
    }
    
    public enum OnOffType {
        On(1),
        Off(0);
        private Integer type;
        OnOffType(Integer type) {
            this.type = type;
        }
        
        public Integer getCode() {
            return this.type;
        }
        
        public int getIntValue() {
            return this.type.intValue();
        }
        
        public static OnOffType getOnOffType(int code){
            
            OnOffType unit = null;
            for(OnOffType type: OnOffType.values()) {
                if (type.getIntValue() == code)
                    unit = type;
            }
        
            return unit;
        }
        
        public static String getOnOffTypeName(int code){
            
            OnOffType unit = null;
            for(OnOffType type: OnOffType.values()) {
                if (type.getIntValue() == code)
                    unit = type;
            }
        
            if(unit != null){
                return unit.name();
            }else{
                return "Unknown["+code+"]";
            }
        }
    }
    
    public enum LimitType {
        Demand(0),
        Current(1),
        Usage(2);//kWh
        private Integer type;
        LimitType(Integer type) {
            this.type = type;
        }
        
        public Integer getCode() {
            return this.type;
        }
        
        public int getIntValue() {
            return this.type.intValue();
        }
    }
    
    public enum MeteringDataClass {
        LpEM,
        LpGM,
        LpWM,
        LpHM,
        LpVC,
        LpSPM,
        DayEM,
        DayGM,
        DayWM,
        DayHM,
        DayVC,
        DaySPM,
        MonthEM,
        MonthGM,
        MonthWM,
        MonthHM,
        MonthVC,
        MonthSPM;
    }
    
    /**
     * <p>Java class for MeteringDataType.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;simpleType name="meteringDataType">
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *     &lt;enumeration value="LoadProfile"/>
     *     &lt;enumeration value="Day"/>
     *     &lt;enumeration value="Month"/>
     *   &lt;/restriction>
     * &lt;/simpleType>
     * </pre>
     * 
     */
    @XmlType(name = "meteringDataType")
    @XmlEnum
    public enum MeteringDataType {
        @XmlEnumValue("LoadProfile")
        LoadProfile,
        @XmlEnumValue("Day")
        Day,
        @XmlEnumValue("Month")
        Month;
    }
    
    public enum MeteringFlag {
        Correct(0),
        EnteredManually(1),
        Missing(2),
        Uncertain(3),
        EstimatedReplaced(4),
        Rollback(5),
        Fail(6),
        Overflow(7),
        NotValid(8),
        NotSupported(9),
        NotAvailable(10),
        InvalidMethod(11),
        LossOfPrecision(12),
        InternalError(13),
        DoesNotExist(14),
        PowerFail(15),
        DemandReset(16);
        
        private int flag;
        
        MeteringFlag(int flag) {
            this.flag = flag;
        }
        
        public int getFlag() {
            return flag;
        }
    }
    
    public enum EndDeviceStatus {
        Run("1.9.2.1","운전"),
        Stop("1.9.2.2","정지"),
        Unknown("1.9.2.3","모름");
        
        private String code;
        private String name;
        
        EndDeviceStatus(String code,String name){
            this.code = code;
            this.name = name;
        }
        public String getCode() {
            return code;
        }
        public String getName() {
            return name;
        }
    }
    
    public enum BatteryStatus {

        Normal(1),
        Abnormal(2),
        Replacement(3),
        Unknown(4);
        private int status;

        BatteryStatus(int status){
            this.status = status;
        }
        
        public int getStatus(){
            return status;
        }
    }
    
    public enum ResultType {
        Text,
        File,
        Email,
        FTP;
    }
    
    public enum TriggerType {
        Cron(0),
        Simple(1),
        Unknown(99);
        
        private int code;

        TriggerType(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
    }

    public enum LineType{
        A("Line Missing A"),        //1
        B("Line Missing B"),        //2
        AB("Line Missing A,B"),     //3
        C("Line Missing C"),        //4
        AC("Line Missing A,C"),     //5
        BC("Line Missing B,C"),     //6
        ABC("Line Missing A,B,C");  //7
        
        private String name;
        
        LineType(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
    }
    
    public enum PowerEventStatus{
        Open,
        Closed;
    }
    
    public enum PaymentType {
        
        Credit("2.2.1.0.0"),    
        Debit ("2.2.1.0.1");    

        private String code;
        
        PaymentType(String code) {
            this.code = code; 
        }
        
        public String getCode() {
            return this.code;
        }
    }

    public enum PaymentStatus {
        
       Paid("2.2.0.1.0"),    
       Unpaid ("2.2.0.1.1");    

        private String code;
        
        PaymentStatus(String code) {
            this.code = code; 
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
    // Contract.is_sts (STS 모듈 사용 여부)
    public enum StsMode {
    	Enable("1", true),
    	Disable("0", false);
    	
    	private String code;
    	private Boolean tof;
    	
    	StsMode(String code, Boolean tof) {
    		this.code = code;
    		this.tof = tof;
    	}
    	
    	public String getCode() {
            return this.code;
        } 
    	public Boolean getTof() {
    		return this.tof;
    	}    	
    }
    
    // Contract.is_net_metering (태양광 고객의 요금 계산)
    public enum NetMeteringMode {
    	Enable("1", true),
    	Disable("0", false);
    	
    	private String code;
    	private Boolean tof;
    	
    	NetMeteringMode(String code, Boolean tof) {
    		this.code = code;
    		this.tof = tof;
    	}
    	
    	public String getCode() {
            return this.code;
        }
    	public Boolean getTof() {
    		return this.tof;
    	}
    }
    
    public enum TypeView {
        Voltage                 (1),
        Current                 (2),
        VoltageAngle            (3), 
        CurrentAngle            (4), 
        VoltageTHD              (5),    
        CurrentTHD              (6),
        TDD                     (7),
        PF                      (8),
        DistortionPF            (9), 
        KW                      (10),
        KVAR                    (11),
        KVA                     (12),
        DistortionKVA           (13),
        vol_1st_harmonic_mag    (14),
        vol_2nd_harmonic_mag    (15),
        curr_1st_harmonic_mag   (16),
        curr_2nd_harmonic_mag   (17),
        vol_2nd_harmonic        (18),
        CurrentHarmonic         (19),
        ph_fund_vol             (20),
        ph_vol_pqm              (21),
        ph_fund_curr            (22),
        ph_curr_pqm             (23);
        
        private int type;
        private String[] typeHead = new String[]{"vol","curr","vol_angle","curr_angle","vol_thd","curr_thd","tdd","pf","distortion_pf",
                 "kw","kvar","kva","distortion_kva","vol_1st_harmonic_mag","vol_2nd_harmonic_mag",
                 "curr_1st_harmonic_mag","curr_2nd_harmonic_mag","vol_2nd_harmonic","curr_harmonic",
                 "ph_vol_pqm","ph_fund_curr","ph_curr_pqm"};
        
        TypeView(int type) {
            this.type = type;
        }
        
        public int getType() {
            return type;
        }
        public String getHead(){
            return typeHead[type-1];
        }
    }
    
    public enum MeteringFailReason {
        IntegrationFailed(0),
        DCUConnectionError(1),
        ModemConnectionError(2),
        GPRSProblem(3),
        DCUAcceptableLimits(4),
        MeterAbnormal(5),
        PowerFail(6),       
        Unknown(255);
        
        private int code;

        MeteringFailReason(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
    }
    
    public enum TargetClass {
        Unknown("7.13.0"),
        FEP("7.13.1"), 
        MCU("7.13.2"),
        DCU("7.13.2"),
        Modem("7.13.3"), 
        EnergyMeter("7.13.4"), 
        VolumeCorrector("7.13.5"), 
        AlarmUnit("7.13.6"), 
        WaterMeter("7.13.7"), 
        GasMeter("7.13.8"), 
        HeatMeter("7.13.9"), 
        ZEUMBus("7.13.10"),
        ZRU("7.13.11"),
        ZMU("7.13.12"),
        PLC("7.13.13"),
        PLCIU("7.13.13"),
        ZBRepeater("7.13.14"),
        ZEUPLS("7.13.15"),
        MMIU("7.13.16"),
        IEIU("7.13.17"),
        IHD("7.13.26"),
        ACD("7.13.27"),
        HMU("7.13.28"),
        Operator("7.13.18"),
        Customer("7.13.19"),
        MaintainUser("7.13.20"),
        Role("7.13.21"),
        systemCode("7.13.22"),
        ScheduleJob("7.13.23"),
        Converter("7.13.24"),
        UserGroup("7.9.16"),
        Contract("7.13.29"),
        SolarPowerMeter("7.13.30"),
        SubGiga("7.13.31"),
        LTE("7.13.32"),
        Inverter("7.13.33"),
        Compensator("7.13.34"),
    	Tariff("1.3.1.8"), //Tariff - EVN
    	
    	EthernetModem("7.13.34"),
    	EthernetConverter("7.13.35"),
    	MBBModem("7.13.36"),
 		RFModem("7.13.37"),
 		DCU_TLS("7.13.38");
        

        private String code;
        
        TargetClass(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
public enum SenderReceiverType {
        
        FEP("4.10.1", "1"), 
        MCU("4.10.2", "2"),
        DCU("4.10.2", "2"), 
        Modem("4.10.3", "3"), 
        EnergyMeter("4.10.4", "4"), 
        AlarmUnit("4.10.5", "5"), 
        WaterMeter("4.10.6", "6"), 
        GasMeter("4.10.7", "7"), 
        HeatMeter("4.10.8", "8"), 
        ZEUMBus("4.10.9", "9"),
        ZRU("4.10.10", "10"),
        ZMU("4.10.11", "11"),
        ZBRepeater("4.10.13", "13"),
        ZEUPLS("4.10.14", "14"),
        MMIU("4.10.15", "15"),
        IEIU("4.10.16", "16"),
        Operator("4.10.17", "17"),
        Customer("4.10.18", "18"),
        ScheduleJob("4.10.19", "19");
        

        private String code;
        private String lcode;
        
        SenderReceiverType(String code, String lcode) {
            this.code = code;
            this.lcode = lcode;
        }
        
        public String getCode() {
            return this.code;
        }
        
        public String getLcode() {
            return this.lcode;
        }
    }

    public enum UsingMCUType {
        Indoor("1.1.1.3"),
        Outdoor("1.1.1.4"),
        DCU("1.1.1.7"),
        DUALGW("1.1.1.8");

        private String code;
        
        UsingMCUType(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
    
    public enum SysType {
        Urban(0),   //노르웨이, 국내
        Rural(1),   //노르웨이
        Slave(2),   //노르웨이
        Indoor(3),  //스웨덴, 통합 MCU
        Outdoor(4), //스웨덴, 통합 MCU
        PLCDCU(7),
        DUALGW(8);

        
        private int code;

        SysType(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
    }

    public enum SysEtherType {
        LAN(0), //LAN
        DHCP(1),    //DHCP
        PPPoE(2),   //PPPoE
        PPP(3); //PPP
        
        private int code;

        SysEtherType(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
    }

    public enum SysMobileType {
        DISABLE(0), //사용 안함
        GSM(1), //GSM
        CDMA(2),    //CDMA
        PSTN(3);    //PSTN
        
        private int code;

        SysMobileType(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
    }

    public enum SysMobileMode {
        CSD(0), //Circuit Mode
        Packet(1),  //Packet Mode
        AlwaysOn(2);    //Packet 접속 유지
        
        private int code;

        SysMobileMode(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
    }
    
    public enum RegType {
        Auto,			//시스템상에서 설치시 자동등록
        Manual,			//단건 등록
        Bulk,			//Batch
        Integration,	//외부시스템에 의한 연계
        Shipment		// Shipment File
    }
    
    public enum MeterEventKind {
        STE("Standard Event"),//표준 이벤트
        MFE("ManufacturedEvent"),//미터 제조사가 추가한 이벤트
        STS("StandardStatus"),//표준 상태 정보
        MFS("ManufacturedStatus");//미터 제조사가 추가한 상태 정보       
        
        private String descr;
        
        MeterEventKind(String descr) {
            this.descr = descr;
        }
        
        public String getDescr() {
            return this.descr;
        }
    }
    
    public enum KGOE{
        Energy(0.215),
        GasLng(0.955),
        Water(0.168345),
        Heat(0.215);
        
        private double value;
        
        KGOE(double value){
            this.value = value;
        }
        public double getValue() {
            return value;
        }
    }
    
    
    public enum DefaultImg{
        MCU("mcuDefaultImg.jpg"),
        MODEM("modemDefaultImg.jpg"),
        METER("meterDefaultImg.jpg");
        
        private String ImgPath;
        
        DefaultImg(String ImgPath) {
            this.ImgPath = ImgPath;
        }
        
        public String getDefaultImg() {
            return this.ImgPath;
        }
    }
    /**
     *  NotComm("aimir.meterng.NotComm"),                           //통신 이력 없음
     *  CommstateYellow("aimir.meterng.CommstateYellow"),           //장기간 통신 장애 aimir.commstateYellow
     *  MeteringFormatError("aimir.meterng.MeteringFormatError"),   //검침포멧 이상
     *  MeterChange("aimir.meterng.MeterChange"),                   //미터 교체 및 공급 중단
     *  MeterStatusError("aimir.meterng.MeterStatusError"),         //미터 상태 이상
     *  MeterTimeError("aimir.meterng.MeterTimeError"),             //미터 시간 이상
     *  MeterTimeSucces("aimir.meterng.Success");
     */
    public enum MeteringFailure{
        NotComm(0),                         //통신 이력 없음
        CommstateYellow(1),                 //장기간 통신 장애
        MeteringFormatError(2),             //검침포멧 이상
        MeterChange(3),                     //미터 교체 및 공급 중단
        MeterStatusError(4),                //미터 상태 이상
        MeterTimeError(5),                  //미터 시간 이상
        MeterTimeSucces(6);
        
        private int MeteringMessage;
        
        MeteringFailure(int MeteringMessage){
            this.MeteringMessage = MeteringMessage;
        }
        
        public int getMeteringMessage(){
            return this.MeteringMessage;
        }
        
    }

    /* 
     *  Demand Response Level
     *  ADD START eunmiae */
    public enum SimpleSignalLevel {
        NORMAL, 
        MODERATE, 
        HIGH, 
        SPECIAL;
    }

    /* 
     *  DR Event Status
     *  ADD START eunmiae */
    public enum DemandResponseEventStatus {
        Initiated,
        Completed,
        etc;
    }

    /*
     * DR 이벤트 참여 상태
     */
    public enum DemandResponseEventOptOutStatus {
        Initialization(1),
        Ongoing(2),
        Participated(3),
        Rejected(4),
        Completed(5);

        private int drEventOptOutStatus;
        
        DemandResponseEventOptOutStatus(int drEventOptOutStatus){
            this.drEventOptOutStatus = drEventOptOutStatus;
        }
        
        public int getDrEventOptOutStatus(){
            return this.drEventOptOutStatus;
        }
    }

    
    /* 2011. 5. 04 Home Device GroupName ADD START eunmiae */
    public enum HomeDeviceGroupName {
        room1,
        room2,
        room3,
        room4,
        room5,
        room6,
        room7,
        room8,
        room9,
        room10;
    }
    /* 2011. 5. 04 Home Device GroupName ADD END eunmiae */

    /**
     * CommonConstants.java Description 
     *
     * 
     * Date          Version     Author   Description
     * 2011. 5. 26.   v1.0       김상연         기기별 카테고리 타입
     *
     */
    public enum HomeDeviceCategoryType {
        SMART_CONCENT("13.1"),
        GENERAL_APPLIANCE("13.2"),
        SMART_APPLIANCE("13.3");
        
        private String code;
        
        HomeDeviceCategoryType(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
//    public enum HomeDeviceInstallStatus {
//      InProgress,
//      failed, 
//      completed
//    }   
    
    /* 2011. 9. 14 ReportParameter Type add by goodjob */
    public enum ReportParameterType {
        Location,
        Period,
        MeterType;
    }
    
    /**
     * AuditLog action을 위한 값
     * 2011.09.20 by elevas
     */
    public enum AuditAction {
        SAVED, UPDATED, DELETED
    }

    /* 2011. 9. 26 Report Export Format add by donggyu moon */
    public enum ReportExportFormat {
        Excel,
        PDF,
        PowerPoint,
        Word;
    }

    /* 2011. 10. 13 ReportFile Path by donggyu moon */
    public enum ReportFileDirectory {
        ReportFile(""),                             // Report File 경로 : /birt-viewer/xxx.rptdesign
        ReportData("/ReportData/"),                 // Data File 경로   : /aimir-web/ReportData/xxx.rpt
        ExportFile("/ReportExport/");               // Export File 경로 : /aimir-web/ReportExport/xxx.pdf

        private String code;

        ReportFileDirectory(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }
    
    /*
     *         * 0bit : Case Open(0:Normal, 1:Tamper)
    * 1bit : Tamper(0:Normal, 1:Tamper)
    * 2bit : 진동(0:Normal, 1:진동)
    * 3bit : 차단불안정
    * 4bit : 개방작동 불량 
    * 5bit : 차단작동 불량
     */
    public enum AlarmStatusBit {

        CaseOpen(0),
        Tamper(1),
        Vibration(2),
        UnstableBlock(3),
        OpenMalfunction(4),
        MalfunctionBlock(5);
        
        private int code;
        
        AlarmStatusBit(int code){
            this.code = code;
        }
        
        public int getCode(){
            return this.code;
        }
    }
    
    public static boolean getAlarmStatusSetBitMask(byte src, AlarmStatusBit alarmStatus){
        byte orbit = (byte)(src & alarmStatus.getCode());
        int ival = ((orbit & 0xff) << 0);

        if(ival > 0) {
            return true;
        }
        return false;
    }

    /* 2011. 11. 10 MeterCtrl by donggyu moon */
    /* 2012. 02. 13 update by donggyu moon */
    public enum MeterCommand{
        ON_DEMAND_METERING("OD", "8.1.1", "On demand Metering Result"),
        RELAY_STATUS("RS", "8.1.8", "Relay Status Result"),
        RELAY_ON("RN", "8.1.9", "Relay On Result"),
        RELAY_OFF("RF", "8.1.10", "Relay Off Result"),
        TIME_SYNC("TMS", "8.1.3", "Time Sync Result"),
        GET_SW_VER("SW", "8.1.13", "Get Software Version Result"),
        GET_TAMPERING("TS", "8.1.12", "Get Tampering Status Result"),
        CLEAR_TAMPERING("TC", "8.1.11", "Tampering Clear Result"),
        ADD_PREPAID_DEPOSIT("PA", "8.1.16", "Add value Prepaid Deposit Result"),
        SET_PREPAID_RATE("PS", "8.1.14", "Set Prepaid Rate Result"),
        GET_PREPAID_DEPOSIT("PG", "8.1.15", "Get Prepaid Deposit Result"),
        SET_LP1_TIMING("LP1", "8.1.20", "Set LP1 timing Result"),
        SET_LP2_TIMING("LP2", "8.1.21", "Set LP2 timing Result"),
        SET_METER_DIRECTION("MD", "8.1.22", "Set Meter Direction Result"),
        SET_METER_KIND("MK", "8.1.23", "Set Meter Kind Result"),
        SET_PREPAID_ALERT("PAS", "8.1.24", "Set Prepaid Alert Result"),
        SET_METER_DISPLAY_ITEMS("MDI", "8.1.25", "Set Meter Display Items Result"),
        SET_METER_RESET("MR", "8.1.26", "Set Meter Reset Result")
        ;

        private String ctrlId;
        private String code;
        private String resultMsg;

        MeterCommand(String ctrlId, String code, String resultMsg) {
            this.ctrlId = ctrlId;
            this.code = code;
            this.resultMsg = resultMsg;
        }

        public String getId() {
            return this.ctrlId;
        }

        public String getCode() {
            return this.code;
        }

        public String getResultMsg() {
            return this.resultMsg;
        }
    }

    public static MeterCommand getMeterCommand(String code) {
        for (MeterCommand c : MeterCommand.values()) {
            if (c.getCode().equals(code))
                return c;
        }
        
        return null;
    }
    /*
     * Relay Switch(RS) Command Result Message
     * 2011. 11. 15 by donggyu moon
     */
    public enum RelaySwitchCmdResult {
        OPEN("0", "Open (Deactivation)"),
        CLOSE("1", "Close (Activation)");

        private String code;
        private String message;

        RelaySwitchCmdResult(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * Relay Switch On/Off(RN/RF) Command Result Message
     * 2011. 11. 15 by donggyu moon
     */
    public enum RelaySwitchOnOffCmdResult {
        SUCCESS("00", "Success"),
        NOT_CTRL("01", "Could not control switch"),
        CHARGE_PWR("02", "Switch charge power"),
        INVALID_SET("99", "Invalid Setting");

        private String code;
        private String message;

        RelaySwitchOnOffCmdResult(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * Get Tampering(TS) Command Result Message (Normal / Issue)
     * 2011. 11. 15 by donggyu moon
     */
    public enum GetTamperingCmdResult {
        NORMAL("0", "Normal", "Normal", "Normal"),
        ISSUE("1", "Issue", "Issue (Terminal cover was opened)", "Issue (Front cover was opened)");

        private String code;
        private String message;
        private String message4;
        private String message5;

        GetTamperingCmdResult(String code, String message, String message4, String message5) {
            this.code = code;
            this.message = message;
            this.message4 = message4;
            this.message5 = message5;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public String getMessage4() {
            return this.message4;
        }

        public String getMessage5() {
            return this.message5;
        }
    }

    /*
     * Default Command Result Message (Success / Failure)
     * Time Sync(TMS), Tampering Clear(TC), Add Prepaid Deposit(PA), Set Prepaid Rate(PS)
     * 2011. 11. 15 by donggyu moon
     */
    public enum DefaultCmdResult {
        SUCCESS("00", "Success"),
        FAILURE("01", "Failure"),
        TIMEOUT("02", "Timeout");

        private String code;
        private String message;

        DefaultCmdResult(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /**
     * RelayControl 및 TimeSync 명령을 지원하는 모델들의 목록이다.
     * @author kskim
     *
     */
    public enum EnableCommandModel {
    	Ping("pingControl",new String[]{
    			// Wasion
    			"NRAM-3405CT10","NRDT-1205DR60","NRAM-1405DR60", "NRAM-3410DR100", "NRAM-3405DR100",
    			// DCU
    			"NZC I211",
    			// Modem
    			"NAMR-G106SR","NAMR-W106SR","NAMR-P214SR",
    			// Kamstrup
    			"OmniPower P1","OmniPower P3","OmniPower STS","OmniPower STS P1","OmniPower STS P3","OmniPower CT",
    			// Kaifa
    			"MA304H3","MA105H","MA304H4","MA304T3","MA304T4", }),
    	Traceroute("TracerouteControl",new String[]{
    			// Wasion
    			"NRAM-3405CT10","NRDT-1205DR60","NRAM-1405DR60", "NRAM-3410DR100", "NRAM-3405DR100",
    			// DCU
    			"NZC I211",
    			// Modem
    			"NAMR-G106SR","NAMR-W106SR",
    			// Kamstrup
    			"OmniPower P1","OmniPower P3","OmniPower STS","OmniPower STS P1","OmniPower STS P3","OmniPower CT",
    			// Kaifa
    			"MA304H3","MA105H","NAMR-P214SR","MA304H4","MA304T3","MA304T4"}),
        RelayActivate("relayControl",new String[]{
        		// GE
        		"SM110","I210","I210P","I210+","I210+c","I210+n","I210+cn",
        		// Aidon
        		"Aidon 5530",
        		// Kamstrup
        		"K382M","K382M AB1","K382M X1","K382M X1v2","K162M","K162Mv2",
        		"OmniPower","OmniPower P1","OmniPower P3","OmniPower STS P1","OmniPower STS P3",
        		// LS
        		"LSD3410DR-080SP","LS Smart Meter","LSIQ-1P","LSIQ-3P"}),
        RelayControl("relayControl",new String[]{
        		// Wasion
        		// "NRAM-3405CT10","NRDT-1205DR60","NRAM-1405DR60", "NRAM-3410DR100", "NRAM-3405DR100",
        		// Modem
        		"NAMR-P214SR",
        		// Kaifa
        		"MA304H3","MA105H","MA304H4","MA304T3","MA304T4",
        		// GE
        		"SM110","I210","I210P","I210+","I210+c","I210+n","I210+cn",
        		// Aidon
        		"Aidon 5530",
        		// Kamstrup
        		"K382M","K382M AB1","K382M X1","K382M X1v2","K382Mv2","K162M","K162Mv2",
        		"OmniPower","OmniPower P1","OmniPower P3",
        		// 대성
        		"NJC 130820A","NJC 130821A",
        		// LS
        		"LSD3410DR-080SP","LS Smart Meter","LSIQ-1P","LSIQ-3P"}),
        TimeSync("timeSync",new String[]{
        		// Wasion
        		"NRAM-3405CT10","NRDT-1205DR60","NRAM-1405DR60", "NRAM-3410DR100", "NRAM-3405DR100",
        		// Modem
        		"NAMR-P214SR",
        		// Kaifa
        		"MA304H3","MA105H","MA304H4","MA304T3","MA304T4",
        		// GE
        		"SM110",
        		"MX2","MX2-GPRS",
        		"DLMSKepco","A1830RLN","Mk10E","Mk10A","A1700","A1140",
        		// Kmastrup
        		"K382M","K382M AB1","K382M X1","K382M X1v2","K382Mv2","K162M","K162Mv2","K351C","K351Cv2",
        		"OmniPower","OmniPower CT","OmniPower P1","OmniPower P3","OmniPower STS P1","OmniPower STS P3",
        		// 대성
        		"NJC 130820A","NJC 130821A", 
        		// LS
        		"LSD3410DR-080SP","LS Smart Meter","LSIQ-1P","LSIQ-3P","LSIQ-3PCT","LSIQ-3PCV","G_TYPE_METER","E10_TYPE_METER",
        		"LSKLV1210DR-100S", "LSKLV1210DR-100M", "LSKLV3410DR-100S", "LSKLV3410DR-100M", "LSKLV3410CT-010M", "LSKLV3405CP-010M"}),
        CoapPing("CoapPing",new String[]{
        		// Kaifa
        		"MA105H","MA105H2E","MA304H3","MA304H3E","MA304H4","MA304T3","MA304T4"}),    	
        LimitPowerUsage("LimitPowerUsage",new String[]{
        		// Kaifa
        		"MA105H","MA105H2E","MA304H3","MA304H3E","MA304H4","MA304T3","MA304T4"}),
        OTA("OTA",new String[]{
        		// Wasion
        		"NRAM-3405CT10","NRDT-1205DR60","NRAM-1405DR60", "NRAM-3410DR100", "NRAM-3405DR100",
        		// GE
        		"SM110","MX2","MX2-GPRS",
        		"DLMSKepco","A1830RLN","Mk10E","Mk10A","A1700","A1140",
        		// Kamsrup
        		"K382M","K382M AB1","K382M X1","K382Mv2","K162M","K162Mv2","K351C","K351Cv2","KSTS",
        		"OmniPower","OmniPower CT","OmniPower P1","OmniPower P3",
        		// 대성
        		"NJC 130820A","NJC 130821A",
        		// LS
        		"LSD3410DR-080SP","LS Smart Meter","LSIQ-1P","LSIQ-3P","LSIQ-3PCT","LSIQ-3PCV","G_TYPE_METER","E10_TYPE_METER",
        		// Kaifa
        		"MA105H","MA105H2E","MA304H3","MA304H3E","MA304H4","MA304T3","MA304T4"}),
        FwVersion("FwVersion",new String[]{
        		// Wasion
        		"NRAM-3405CT10","NRDT-1205DR60","NRAM-1405DR60", "NRAM-3410DR100", "NRAM-3405DR100",
        		// GE
        		"SM110","MX2","MX2-GPRS",
        		"DLMSKepco","A1830RLN","Mk10E","Mk10A","A1700","A1140",
        		// Kamstrup
        		"K382M","K382M AB1","K382M X1","K382Mv2","K162M","K162Mv2","K351C","K351Cv2",
        		"OmniPower","OmniPower CT","OmniPower P1","OmniPower P3",
        		"KSTS",
        		// 대성
        		"NJC 130820A","NJC 130821A",
        		// LS
        		"LSD3410DR-080SP","LS Smart Meter","LSIQ-1P","LSIQ-3P","LSIQ-3PCT","LSIQ-3PCV","G_TYPE_METER","E10_TYPE_METER",
        		// Kaifa
        		"MA105H","MA105H2E","MA304H3","MA304H3E","MA304H4","MA304T3","MA304T4"}),
        ValveControl("valveControl",new String[]{
        		// Wasion
    			"NRAM-3405CT10","NRDT-1205DR60","NRAM-1405DR60", "NRAM-3410DR100", "NRAM-3405DR100",
        		"SENSUS_220C","SM150P"}),
        TOUCalendar("TOUCalendar",new String[]{"MX2"}),
        DemandReset("DemandReset",new String[]{"LSKLV1210DR-100M","LSKLV3405CP-010M","LSKLV3410CT-010M","LSKLV3410DR-100M"}),
        EnergyLevel("EnergyLevel",new String[]{"SX1","SX2"}),
        SummerTime("SummerTime",new String[]{"MX2"}),
        FirmwareUpdate("FirmwareUpdate",new String[]{"SX2"}),
        MeterEvent("MeterEvent",new String[]{"NJC Meter DLMSUA"}),
        Billing("Billing",new String[]{"NJC Meter DLMSUA"}),
        RestoreDefaultFW("RestoreDefaultFW",new String[]{"SX2"}),
        DisplayItemSetting("DisplayItemSetting",new String[]{"MX2"}),
        MeterScan("MeterScan", new String[]{"G_TYPE_METER","E10_TYPE_METER"}),
        InverterInformation("InverterInformation", new String[]{"ROCKWELL_INVERTER", "LS_INVERTER", "HYUNDAI_INVERTER"}),
        InverterSetup("InverterSetup", new String[]{"ROCKWELL_INVERTER", "LS_INVERTER", "HYUNDAI_INVERTER"}),
        StsControl_SUNI("stsControl_SUNI",new String[]{"OmniPower STS", "OmniPower STS P1","OmniPower STS P3"}),
    	StsControl_WASION("stsControl_WASION",new String[]{"NRAM-1405DR60","NRAM-3410DR100"}),
    	BillingCycle("BillingCycle",new String[]{"LSKLV3405CP-010M","LSKLV3410CT-010M","LSKLV3410DR-100M","LSKLV3410DR-100S"}),
    	CurrentLoadLimit("CurrentLoadLimit",new String[]{"LSKLV3405CP-010M","LSKLV3410CT-010M","LSKLV3410DR-100M","LSKLV3410DR-100S"}),
    	TOU("TOU",new String[]{"LSKLV3405CP-010M","LSKLV3410CT-010M","LSKLV3410DR-100M","LSKLV3410DR-100S"}),
    	DemandPeriod("DemandPeriod",new String[]{"LSKLV3405CP-010M","LSKLV3410CT-010M","LSKLV3410DR-100M","LSKLV3410DR-100S"});
    	
        
        private String name;

        private String[] models;

        public String getName() {
            return name;
        }
        
        public String[] getModels() {
            return models;
        }
        
        EnableCommandModel(String name, String[] models){
            this.name = name;
            this.models = models;
        }
        
        /**
         * 모델명으로 RelayControl 및 TimeSync 명령이 지원하는지 확인하는 메소드
         * @param modelName
         * @return 해당 Enum Name
         */
        public static final String[] getNameOfContain(String modelName){
            List<String> contains = new ArrayList<String>();
            for(EnableCommandModel ecm : EnableCommandModel.values()){
                for (String model : Arrays.asList(ecm.getModels())) {
                    if("".equals(model))
                        break;
                    if(modelName.equals(model)) {
                        contains.add(ecm.getName());
                        break;
                    }
                }
            }
            return contains.toArray(new String[0]);
        }
    }

    /**
     * 모델Name 별로 로직 분기시 사용함.
     * @author kskim
     *
     */
    public enum NameOfModel{
        SM110("SM110"),
        Aidon_5530("Aidon 5530"),
        Aidon_5540("Aidon 5540"),
        Kamstrup_382("Kamstrup 382"),
        Kamstrup_162("Kamstrup 162"),
        SENSUS_220C("SENSUS_220C"),
        NAMR_P114GP_MX2("NAMR-P114GP_MX2"),
        SX1("SX1"),
        SX2("SX2"),
        K382("K382"),
        K162("K162"),
        K282("K282"),
        K351("K351"),
        NJC("NJC Meter DLMSUA"),
        NJC_130820A("NJC 130820A"),
        NJC_130821A("NJC 130821A");
        
        private String name;
        
        public String getName(){
            return this.name;
        }

        NameOfModel(String name){
            this.name = name;
        }

        /**
         * 해당 이름의 값이 있는지 확인한다.
         * @param name
         * @return
         */
        public boolean equalsOfName(String name) {
            return this.name.equals(name);
        }
    }
    
    /**
     * Valve Status
     * @author kskim
     *
     */
    public enum ValveStatus{
        VALVE_ON(0),
        VALVE_OFF(1),
        VALVE_STANDBY(2);
        
        private int val;
        
        public int getValue(){
            return this.val;
        }
        
        ValveStatus(int val){
            this.val = val;
        }
    }

    /*
     * Meter Command Status
     * 2011. 11. 21 by donggyu moon
     */
    public enum MeterCommandStatus {
        INIT(0, "Initialize (Only registered)"),
        SEND(1, "Send command (AIMIR -> DCU)"),
        RETURN(2, "Return values (DCU -> AIMIR)"),
        TIME_OUT(-1, "Error (Timeout Error)"),
        ERROR(-2, "Error (Other)");

        private Integer code;
        private String message;

        MeterCommandStatus(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * 시스템에 의해 실행되거나 타 시스템 사용자가 실행하는 경우 사용자명
     * 2011. 11. 28 by donggyu moon
     */
    public enum CommandOperator {
        WEBSERVICE("WebService");

        private String operatorName;

        CommandOperator(String operatorName) {
            this.operatorName = operatorName;
        }
        public String getOperatorName() {
            return this.operatorName;
        }
    }

    /*
     * MDIS 에서 사용
     * 2011. 12. 12 by donggyu moon
     */
    public enum StatusChannel {
        Active(2), Reactive(3);
        
        private Integer channel;
        
        StatusChannel(Integer channel) {
            this.channel = channel;
        }
        
        public Integer getChannel() {
            return this.channel;
        }
    }

    /*
     * MDIS 에서 사용. MdisMeter.meterDirection
     * 2011. 12. 22 by donggyu moon
     * 수정 : 명칭 변경
     */
    public enum MdisMeterDirection {
        ACT("00", "Active"),
        REACT("01", "Reactive"),
        ACT_REACT("02", "Active - Reactive"),
        REACT_ACT("03", "Active + Reactive");

        private String code;
        private String message;

        MdisMeterDirection(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * MDIS 에서 사용. MdisMeter.meterKind
     * 2011. 12. 22 by donggyu moon
     * 수정 : 코드값 변경
     */
    public enum MdisMeterKind {
        POSTPAID("00", "postpaid"),
        PREPAID("01", "prepaid");

        private String code;
        private String message;

        MdisMeterKind(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * MDIS 에서 사용. MdisMeter.lp1Timing
     * 2012. 02. 13 by donggyu moon
     */
    public enum MdisLp1Timing {
        T15("15", "15"),
        T30("30", "30"),
        T60("60", "60");

        private String code;
        private String message;

        MdisLp1Timing(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * MDIS 에서 사용. MdisMeter.lp2Pattern
     * 2021. 02. 13 by donggyu moon
     */
    public enum MdisLp2Pattern {
        PATTERN_A("A", "Pattern A"),
        PATTERN_B("B", "Pattern B");

        private String code;
        private String message;

        MdisLp2Pattern(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * MDIS 에서 사용. MdisMeter.lp2Timing
     * 2012. 02. 13 by donggyu moon
     */
    public enum MdisLp2Timing {
        T05("05", "05"),
        T10("10", "10"),
        T15("15", "15"),
        T30("30", "30"),
        T60("60", "60");

        private String code;
        private String message;

        MdisLp2Timing(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }
    
    public enum MeterProtocol {
    	DLMS("DLMS");
    	
    	private String name;
    	
    	MeterProtocol(String name) {
    		this.name = name;
    	}
    	
    	public String getName() {
    		return this.name;
    	}
    }

    /*
     * Meter Program 종류
     * <p>2012.02.17 by elevas</p>
     * <p>Java class for meterProgramKind.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;simpleType name="meterProgramKind">
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *     &lt;enumeration value="TOUCalendar"/>
     *     &lt;enumeration value="TimeSync"/>
     *     &lt;enumeration value="DemandReset"/>
     *     &lt;enumeration value="DaySavingTime"/>
     *     &lt;enumeration value="SAPTable"/>
     *   &lt;/restriction>
     * &lt;/simpleType>
     * </pre>
     * 
     */
    @XmlType(name = "meterProgramKind")
    @XmlEnum
    public enum MeterProgramKind {
        @XmlEnumValue("TOUCalendar")
        TOUCalendar("TOU Calendar"),
        @XmlEnumValue("TimeSync")
        TimeSync("Time Synchronization"),
        @XmlEnumValue("DemandReset")
        DemandReset("Demand Reset"),
        @XmlEnumValue("DaySavingTime")
        DaySavingTime("Day Saving Time"),//summer time
        @XmlEnumValue("SAPTable")
        SAPTable("SAP Table"), // SAP 포멧에 필요한 테이블 읽기.
        @XmlEnumValue("DisplayItemSetting")
        DisplayItemSetting("Display Item Setting");
        
        private String name;
        
        MeterProgramKind(String name) {
            this.name = name;
        }
        
        public String getName() {
            return this.name;
        }
    }

    /*
     * MDIS 에서 사용. Meter.conditions
     * 실제 DB에 저장되는 값은 text 이지만 관리를 위해서 constant 로 생성 
     * 2012. 02. 17 by donggyu moon
     */
    public enum MdisTamperingStatus {
        TAMPERING_ISSUED(0, "Tampering Issued");

        private Integer code;
        private String message;

        MdisTamperingStatus(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * Scheduler 에서 사용.
     * 기본적인 Job 실행 에러 메세지. 
     * 2012. 02. 28 by donggyu moon
     */
    public enum ScheduleJobErrorMsg {
        TRIGGER_MISFIRED(0, "Trigger is misfired"),
        JOB_EXECUTE_ERROR(1, "An Error Occurred While Running a Job"),
        TASK_EXECUTE_ERROR(2, "An Error Occurred While Running a Task")
        ;

        private Integer code;
        private String message;

        ScheduleJobErrorMsg(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }
    
    
    // Relay Switch Satus 
    // This is requirement for SAPSA. by eunmiae
    public enum RelaySwitchStatus {       
        Off(0),
        On(1);
        
        private int code;
        
        RelaySwitchStatus(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return this.code;
        }
    }

    /*
     * EMS 에서 사용.
     * DTS Meter 의 phase 명 
     * 2012. 03. 21 by donggyu moon
     */
    public enum DistTrfmrSubstationMeterPhase {
        LINE_A(0, "Phase A"),
        LINE_B(1, "Phase B"),
        LINE_C(2, "Phase C")
        ;

        private Integer code;
        private String name;

        DistTrfmrSubstationMeterPhase(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getName() {
            return this.name;
        }
    }

    /*
     * MDIS 에서 사용. MdisMeter.lcdDispScroll
     * 2012. 04. 30 by donggyu moon
     */
    public enum MdisLcdDisplayScroll {
        MANUAL("00", "Manual Scroll"),
        AUTO("01", "Auto Scroll"),
        BOTH("02", "Manual/Auto Scroll");

        private String code;
        private String message;

        MdisLcdDisplayScroll(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * MDIS 에서 사용. MdisMeter.lcdDispContentPost/lcdDispContentPre
     * 2012. 04. 30 by donggyu moon
     */
    public enum MdisLcdDisplayContent {
        BALANCE_ACT_PWR("Balance Active Power"),
        ACT_PWR("Active Power"),
        KW("KW"),
        VAR("VAR"),
        VA("VA"),
        V("V"),
        A("A"),
        PF("PF"),
        HZ("Hz"),
        BAL("Bal"),
        DATE("Date"),
        TIME("Time");

        private String message;

        MdisLcdDisplayContent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /*
     * MDIS 에서 사용. MdisMeter.qualitySide
     * 2012. 05. 08 by donggyu moon
     */
    public enum MdisQualitySide {
        MAIN("00", "Main"),
        NEUTRAL("01", "Neutral");

        private String code;
        private String message;

        MdisQualitySide(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }
    
    public enum CustomerSearchType {
        Customer("16.1"),
        Contract("16.2");

        private String code;
        
        CustomerSearchType(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
    public enum ChannelCalcMethod {
        SUM,
        AVG,
        MAX
    }

    /*
     * MeteringData-Detail-Rate tab
     * Date Tab 에 기존날짜조건 이외의 Tab 을 추가 시 사용.
     * 2012. 09. 02 by donggyu moon
     */
    public enum DateTabOther {
        RATE("20"),             /** Rate 별 */
        INTERVAL("21");         /** Interval */

        private String code;

        DateTabOther(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }

    /*
     * MeteringData-Detail-Rate tab
     * 평일과 주말/일요일 구분
     * 2012. 09. 02 by donggyu moon
     */
    public enum UsageRateDateType {
        WEEK_DAY("weekday"),
        WEEK_END("weekend");

        private String code;

        UsageRateDateType(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }

    /*
     * Meter Mini
     * 일반 constant 에 정의하기 애매한 여러 value 들을 사용하기 위함
     * 2013. 04. 29 by donggyu moon
     */
    public enum DefaultUndefinedValue {

        UNKNOWN("Unknown");
        
        private String name;
        
        DefaultUndefinedValue(String name) {
            this.name = name;
        }
        
        public String getName() {
            return this.name;
        }
    }

    /**
     * @FileName CommonConstants.java
     * @Date 2013. 10. 17.
     * @author scmitar1
     * @ModifiedDate
     * @Descr
     */
    public enum CasherStatus {
        WORK(0),
        QUIT(1);
        
        private Integer code;
        
        CasherStatus(Integer code) {
            this.code = code;
        }
        
        public Integer getCode() {
            return this.code;
        }
    }
    
    public enum ServiceType2 {
        NewService(1, "New Service"),
        SeperateMeter(2, "Seperate Meter"),
        AdditionalLoad(3, "Additional Load"),
        Replacement(4, "Replacement"),
        ReplacementFromECash1(5, "Replacement from E Cash1"),
        ReplacementFromECash2(6, "Replacement from E Cash2"),
        ReplacementFromECash3(10, "Replacement from E Cash3"), // 2015.07.28 추가됨.
        ReplacementFromAimir(7, "Replacement from AiMiR"),
        ReplacementFromPnS(8, "Replacement from P n S"),
        ReplacementFromCBIS(9, "Replacement from CBIS");
        ;
        
        private Integer code;
        private String name;
        
        ServiceType2(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
        
        public Integer getCode() {
            return this.code;
        }
        
        public String getName() {
            return this.name;
        }
    }

    /* 
     * Meter 관련 Code 모음
     */
    public enum MeterCodes {
        DELETE_STATUS("1.3.3.9");

        private String code;

        MeterCodes(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }
    
    /*
     * Modem
     */
    public enum ModemSleepMode {
    //모뎀 삭제 코드로 사용
    	BreakDown("1.2.7.1"),
        Delete("1.2.7.2"),
    	Normal("1.2.7.3"),
    	Repair("1.2.7.4"),
    	SecurityError("1.2.7.5"),
    	CommError("1.2.7.6");
        
        private String code;
        
        ModemSleepMode(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
        
    }

    public enum LOCATIONTYPE {
        ELECTRICITY_CONSUMPTION_LOCATION((short)101, "Electricity consumption location"),
        DISTRICT_HEATING_CONSUMPTION_LOCATION((short)102, "District heating consumption location"),
        DISTRICT_COOLING_CONSUMPTION_LOCATION((short)103, "District cooling consumption location"),
        GAS_CONSUMPTION_LOCATION((short)104, "Gas consumption location"),
        WATER_CONSUMPTION_LOCATION((short)105, "Water consumption location"),
        ELECTRICITY_CONSUMPTION_LOCATION_INDIVIDUAL_MEASUREMENT((short)106, "Electricity consumption location, individual measurement"),
        HOT_WATER_CONSUMPTION_LOCATION_INDIVIDUAL_MEASUREMENT((short)107, "Hot water consumption location, individual measurement"),
        COLD_WATER_CONSUMPTION_LOCATION_INDIVIDUAL_MEASUREMENT((short)108, "Cold water consumption location, individual measurement"),
        TEMPERATURE_LOCATION_INDIVIDUAL_MEASUREMENT((short)109, "Temperature location, individual measurement"),
        ELECTRICITY_PRODUCTION_LOCATION((short)121, "Electricity production location"),
        DISTRICT_HEATING_PRODUCTION_LOCATION((short)122, "District heating production location"),
        DISTRICT_COOLING_PRODUCTION_LOCATION((short)123, "District cooling production location"),
        GAS_PRODUCTION_LOCATION((short)124, "Gas production location"),
        WATER_PRODUCTION_LOCATION((short)125, "Water production location"),
        LARGE_MCU_OUTDOOR((short)201, "Large MCU (outdoor)"),
        SMALL_MCU_INDOOR((short)202, "Small MCU (indoor)"),
        LARGE_REPEATER_OUTDOOR((short)203, "Large repeater (outdoor)"),
        SMALL_REPEATER_INDOOR((short)204, "Small repeater (indoor)");

        short value;
        String documentation;

        LOCATIONTYPE(short value, String documentation) {
            this.value = value;
            this.documentation = documentation;
        }

        public short getValue() {
            return value;
        }

        public String getDocumentation() {
            return documentation;
        }

        @Override
        public String toString() {
            return "LOCATIONTYPE [ value:" + value + "  documentation:" + documentation + "]";
        }
    }

    public static LOCATIONTYPE getLOCATIONTYPE(int value) throws Exception {
        for(LOCATIONTYPE os : LOCATIONTYPE.values()) {
            if(os.getValue() == value) {
                return os;
            }
        }

        throw new Exception("Invalid LOCATIONTYPE Code[" + value + "]");
    }
    
    public enum DLMSDataType{
    	NONE(0,"null-date"),
    	BOOLEAN(3,"boolean"),
    	BITSTRING(4,"bit-string"),
    	INT32(5,"double-long"),
    	UINT32(6,"double-long-unsigned"),
    	OCTET_STRING(9,"octet-string"),
    	STRING(10,"visible-string"),
    	STRING_UTF8(12,"utf8-string"),
    	BCD(13,"bcd"),
    	INT8(15,"integer"),
    	INT16(0x10,"long"),
    	UINT8(0x11,"unsigned"),
    	UINT16(0x12,"long-unsigned"),
    	INT64(20,"long64"),
    	UINT64(0x15,"long64-unsigned"),
    	ENUM(0x16,"enum"),
    	FLOAT32(0x17,"float32"),
        FLOAT64(0x18,"float64"),
        DATETIME(0x19,"date-time"),
        DATE(0x1a,"date"),
        TIME(0x1b,"time"),
        ARRAY(1,"array"),
        STRUCTURE(2,"structure"),
        COMPACTARRAY(0x13,"compact array");
    	
    	private int code;
    	private String name;

    	DLMSDataType(int code, String name) {
            this.code = code;
            this.name = name;
        }
        
        public int getCode() {
            return this.code;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
	/**
	 * Vietnam Multi OTA용 타입
	 * 
	 * Remote upgrade type. 
	 * - 0x01: Modem
	 * - 0x02: Sensor/Meter
	 * - 0x03: DCU
	 * - Others: Not supported model

	 * DCU filter
	 *  - 0x01 : MeterID
	 *  - 0x02 : ModemID
	 */
	public enum OTAType {
		// 3.3
		  DCU_COORDINATOR("DCU_COORDINATOR", 5, 0) // 0x05: DCU_COORDINATOR		
		, DCU_COORDINATOR_THIRD_PARTY_COORDINATOR("DCU_COORDINATOR_THIRD_PARTY_COORDINATOR", 6, 2) // 0x05: COORDINATOR, 0x02: FILTER_MODEMID
		, METER_MBB("METER_MBB", 0, 0)
		, METER_ETHERNET("METER_ETHERNET", 0, 0)
		, METER_RF("METER_RF", 0, 0)
		, METER_RF_BY_DCU("METER_RF_BY_DCU", 2, 1)  // 0x02: Sensor/Meter, 0x01: FILTER_METERID		
		, METER_RF_BY_THIRD_PARTY_COORDINATOR("METER_RF_BY_THIRD_PARTY_COORDINATOR", 6, 2)  // 0x06: Third-party Coordinator, 0x02: FILTER_MODEMID
		, METER_RF_BY_THIRD_PARTY_MODEM("METER_RF_BY_THIRD_PARTY_MODEM", 7, 2)  // 0x07: Third-party Modem, 0x02: FILTER_MODEMID
		, MODEM_MBB("MODEM_MBB", 0, 0)
		, MODEM_ETHERNET("MODEM_ETHERNET", 0, 0)
		, MODEM_RF("MODEM_RF", 0, 0)
		, MODEM_RF_BY_DCU("MODEM_RF_BY_DCU", 1, 2)  // 0x01: Modem, 0x02: FILTER_MODEMID
		, MODEM_RF_BY_THIRD_PARTY_COORDINATOR("MODEM_RF_BY_THIRD_PARTY_COORDINATOR", 6, 2)  // 0x06: Third-party Coordinator, 0x02: FILTER_MODEMID
		, MODEM_RF_BY_THIRD_PARTY_MODEM("MODEM_RF_BY_MODEM_CLONE", 7, 2)  // 0x07: Third-party Modem, 0x02: FILTER_MODEMID
		
		// 3.0
		, MODEM_ZIGBEE_BY_DCU("MODEM_ZIGBEE_BY_DCU", 1, 2)
		, METER_ZIGBEE_BY_DCU("METER_ZIGBEE_BY_DCU", 2, 1)  // Vietnam은 미터 OTA가 없음.
		, DCU("DCU", 3, 0)
		, DCU_KERNEL("DCU_KERNEL", 4, 0)
		, DCU_COORDINATE("DCU_COORDINATE", 5, 0)
		, MODEM_GPRS("MODEM_GPRS", 0, 0)
		, METER_GPRS("METER_GPRS", 0, 0);

		private String type;
		private int typeCode;
		private int filterType;
		
		private OTAType(String type, int typeCode, int filterType) {
			this.type = type;
			this.typeCode = typeCode;
			this.filterType = filterType;
		}

		public static OTAType getItem(String value) {
			for (OTAType fc : OTAType.values()) {
				if (fc.type.equals(value)) {
					return fc;
				}
			}
			return null;
		}
		
		
		public String getType() {
			return this.type;
		}

		public int getTypeCode(){
			return this.typeCode;
		}
		
		public int getFilterType(){
			return this.filterType;
		}
	}
	
	public enum OTATargetType {
		DCU("DCU"), DCU_KERNEL("DCU_KERNEL"), DCU_COORDINATE("DCU_COORDINATE"), MODEM("MODEM"), METER("METER");

		@SuppressWarnings("unused")
		private String targetType;

		private OTATargetType(String type) {
			this.targetType = type;
		}

		public static OTATargetType getItem(String value) {
			for (OTATargetType fc : OTATargetType.values()) {
				if (fc.targetType.equals(value)) {
					return fc;
				}
			}
			return null;
		}
	}
    
	public enum OTAExecuteType {
		CLONE_OTA(0), EACH_BY_DCU(1), EACH_BY_HES(2), EACH_BY_MODEM(3);

		private int value;

		private OTAExecuteType(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static OTAExecuteType getItem(String value) {
			if(value != null && !value.equals("")){
				return getItem(Integer.parseInt(value));
			}

			return null;
		}
		
		public static OTAExecuteType getItem(int value) {
			for (OTAExecuteType fc : OTAExecuteType.values()) {
				if (fc.value == value) {
					return fc;
				}
			}
			return null;
		}
	}
	
	/* SP-957 Modem Clone on,off */
	public enum ModemCommandType {
		CLONE_ON("CLONE_ON"), CLONE_OFF("CLONE_OFF");

		private String value;

		private ModemCommandType(String value) {
			this.value = value;
		}

		public static ModemCommandType getItem(String value) {
			for (ModemCommandType fc : ModemCommandType.values()) {
				if (fc.value.equals(value)) {
					return fc;
				}
			}
			return null;
		}
	}

	// INSERT START SP-193
    public enum ThresholdName {
        CRC("CRC")
        , THROUGHPUT("Throughput")
        , INVALID_PACKET("Invalid packet")
        , AUTHENTICATION_ERROR("Authentication error")
        , METER_TIME_GAP("Meter Time Gap");

        private final String thresholdName;

        ThresholdName(String thresholdName) {
            this.thresholdName = thresholdName;
        }
        public String getThresholdNameValue() {
            return this.thresholdName;
        }

		public static ThresholdName getThresholdName(String value) {
			for (ThresholdName name : ThresholdName.values()) {
				if (name.thresholdName.equals(value)) {
					return name;
				}
			}
			return null;
		}        
    }		
	// INSERT END SP-193
    
    // SP-296  Shipment File
   	public enum ShipmentTargetType {
   		EthernetModem("Ethernet Modem"),
    	EthernetConverter("Ethernet-Converter"),
    	MBBModem("MBB Modem"),
 		RFModem("RF Modem");

		private String name;

		ShipmentTargetType(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}
	
    public enum CommStatus {
        Normal(0),
        Init(1),
        CommError(10),
        MeterError(11),
        Error(100);
        
        private int code;

        CommStatus(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
    }
    
    public enum CommResult {
		Failed("4.1.1"), 
		Success("4.1.2");

		private String code;

		CommResult(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}
	}
    
    public enum CmdResultType {
        Waiting("Waiting for the modem onnection. Please refer to [Async Commm. Log/History] section."),
        SocketError("Fail to create TCP socket"),
        CommError("Communication Error"),
        NullTarget("Target ID null"),
        PermissionError("No permission");

		private String desc;
		CmdResultType(String desc) {
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}
	}
    
    public enum SMS_TYPE {
    	ASYNC_COMMAND(0),
      	BUY_CREDIT(1),
      	WARN_CREDIT(2);
    	
    	private int status;
    	
    	SMS_TYPE(int status) {
    		this.status = status;
    	}
    	
    	public int getStatus(){
   			return this.status;
   		}
    }
    
   	public enum ModemStatus {
   		
   		Normal(0), 
   		Init(1), 
   		ConnectError(10),
   		MeterError(11), 
   		Error(100);
   		
   		private int status;
   		
   		ModemStatus(int status) {
   			this.status  = status;
   		}
   		
   		public int getStatus(){
   			return this.status;
   		}
   		
        public static ModemStatus getModemStatus(int type){
            for(ModemStatus m : ModemStatus.values()){
                if(m.getStatus() == type)
                    return m;
            }
            return null;
        }
   	}
   	
   	public static Hashtable<String, Code> modemStatuses = null;
    
    public enum SessionKey {
    	PARTIAL_KEY, SESSION_SUSTAINABLE;
    }
    
    //SP-919, SP-962, SP-953, SP-964, SP-970
    public enum ModemIFType {
        RF,
        MBB,
        Ethernet;
    }
    
    public enum HTTP_METHOD {
    	POST,
    	PUT,
    	GET,
    	DELETE
    }
}
