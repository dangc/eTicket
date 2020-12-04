package com.nuri.etk.async.constants;


/**
 * FEP의 DLMS Variable을 복사.
 * ETK에서 직접 사용하는 것들만 있음.
 */
public class DLMSConstants {

    public enum OBIS {
        TOKEN_GATEWAY("0000132800FF", "Token Gateway"), // 0.0.19.40.0.255
        REMAINING_CREDIT("0141018C01FF", "Remaining Credit"), // 1.65.1.140.1.255
        REMAINING_CREDIT_DECIMAL34("0000138C01FF", "DecimalForBalanceCredit(3,4)"), //잔액이 1000.1234인경우, 해당 코드값은 0.0034임
        EMERGENCY_CREDIT("0141018C08FF", "Emergency Credit"), // 1.65.1.140.8.255

        /*  Meter Information */
        WEAK_LQI_VALUE("00001D0200FF","G3 PLC LQI VALUE"),
        DEVICE_INFO("0000600100FF", "Device Information"),
        MANUFACTURE_SERIAL("0000600101FF","Manufacturer serial"),
        METER_TIME("0000010000FF", "Meter Time"),
        METER_MODEL("0000600103FF","Meter Model"),
        PHASE_TYPE("0100000204FF","Meter Phase Type"),
        LOGICAL_NUMBER("00002A0000FF","Logical Device Number"),
        FW_VERSION("0101000200FF","Firmware Version"),
        //HDLC_SETUP("0000160000FF","HDLC Setup"),
        //SERVICEPOINT_SERIAL("0000600102FF","SP serial number"),
        //CT_RATIO_NUM("0100000402FF","CT Ratio Number"),
        //VT_RATIO_NUM("0100000403FF","VT Ratio Number"),
        //CT_RATIO_DEN("0100000405FF","CT Ratio Den"),
        //VT_RATIO_DEN("0100000406FF","VT Ratio Den"),
        //OVERAL_TRANS_NUM("0100000404FF","Overall transformer ratio (num)"),

        /* Load Profile */
        ENERGY_LOAD_PROFILE("0100630100FF","Energy Load Profile"),
        POWER_LOAD_PROFILE("0100630200FF","Power Load Profile"),
        DAILY_LOAD_PROFILE("0100620101FF","Daily load profile"),
        MONTHLY_BILLING("0000620100FF","Monthly biling event log"),
        ENERGY_OVERFLOW_EVENTLOG("0100636219FF","Energy overflow eventlog"),
        //MONTHLY_ENERGY_PROFILE("0000620101FF", "Monthly Energy Profile"),
        //MONTHLY_DEMAND_PROFILE("0000620102FF", "Monthly Demand Profile"),

        //Error register1(push)	0.0.97.97.0.255
        //Error register2(push)	0.0.97.97.5.255
        //Alarm register1	0.0.97.98.0.255
        //Alarm register2	0.0.97.98.1.255
        //Alarm filter1	0.0.97.98.10.255
        //Alarm filter2	0.0.97.98.11.255
        //Alarm descriptor1	0.0.97.98.20.255
        //Alarm descriptor2	0.0.97.98.21.255

        /* Meter Alarm Information */
        MEASUREMENT_STATUS("0000600A07FF","Measurement Status"),
        DRIVE_STATUS("0000600A06FF","Drive status"),
        METER_STATUS("0000600A05FF","Meter Status"),
        RELAY_STATUS("000060030AFF","Relay Status"),  //0.0.96.3.10.255 Disconnect/reconnect 70 RW
        //FUNCTION_STATUS("","Function Status"), //TODO SET
        //EXTERNAL_RELAY_STATUS("000360030AFF","External Relay Status"), //0.3.96.3.10.255 External Disconnect/reconnect

        /* Meter Event */
        STANDARD_EVENT("0000636200FF","Standard Event"), //0.0.99.98.0.255
        FRAUDDETECTIONLOGEVENT("0000636201FF","Fraud detection Log event"),//0.0.99.98.1.255
        RELAY_EVENT("0000636202FF","Disconnector control log"), //0.0.99.98.2.255
        RELAY_EVENT_OF_SPLIT("010063620CFF","Disconnector control log"), //0.0.99.98.2.255
        MEASUREMENT_EVENT("0100630102FF", "Measurement event log"), //1.0.99.1.2.255
        POWERFAILURE_LOG("0100636100FF","Power Failure log"),  // 1.0.99.97.0.255: Power failure logs for single-phase/poly-phase
        //TAMPER_EVENT("0100636215FF","Tamper event log"),        //1.0.99.98.21.255
        //POWER_QUALITY_LOG("0000636203FF","Power Quality Log"), //0.0.99.98.3.255: power quality logs
        //INCORRECT_PHASE_ROTATION_EVENT("0100636220FF", "Incorrect phase rotation log"),
        //TIME_CHANGE_BEFORE("0100636203FF", "Time Change Before"),
        //TIME_CHANGE_AFTER("0100636204FF", "Time Change After"),
        //MANUAL_DEMAND_RESET("0100636206FF", "Manual Demand Reset"),
        //POWER_FAILURE("0100636100FF","Power Failure"),
        //POWER_RESTORE("0100636202FF","Power Restore"),
        //BATTERY_FAILURE("0100636224FF","Battery failure event"),
        //RELAY_CONTROL_SCRIPT("00000A006AFF","Relay Status"),//0.0.10.0.106.255 Disconnect control script table 9 RW

        /* Channel Information */
        VOLTAGE_L1("0100200700FF","L1 voltage"),
        VOLTAGE_L2("0100340700FF","L2 voltage"),
        VOLTAGE_L3("0100480700FF","L3 voltage"),
        CURRENT_L1("01001F0700FF","L1 current"),
        CURRENT_L2("0100330700FF","L2 current"),
        CURRENT_L3("0100470700FF","L3 current"),
        CT("0100000402FF","CT"),
        VT("0100000403FF","VT"),
        CT_DEN("0100000405FF","CT_DEN"),
        VT_DEN("0100000406FF","VT_DEN"),

        ACTIVE_POWER_L1("0100150700FF","L1 active power"),
        ACTIVE_POWER_L2("0100290700FF","L2 active power"),
        ACTIVE_POWER_L3("01003D0700FF","L3 active power"),
        ACTIVE_POWER_EXPORT_L1("0100160700FF","L1 active power-"),
        ACTIVE_POWER_EXPORT_L2("01002A0700FF","L1 active power-"),
        ACTIVE_POWER_EXPORT_L3("01003E0700FF","L1 active power-"),

        ACTIVEPOWER_IMPORT("0100010700FF","Active Power Import"),
        REACTIVE_POWER_L1("0100170700FF","L1 reactive power"),
        REACTIVE_POWER_L2("01002B0700FF","L2 reactive power"),
        REACTIVE_POWER_L3("01003F0700FF","L3 reactive power"),
        REACTIVEPOWER_IMPORT("0100030700FF","Reactive Power Import"),

        REACTIVE_POWER_EXPORT_L1("0100180700FF","L1 reactive power-"),
        REACTIVE_POWER_EXPORT_L2("01002C0700FF","L2 reactive power-"),
        REACTIVE_POWER_EXPORT_L3("0100400700FF","L3 reactive power-"),
        REACTIVEPOWER_EXPORT("0100040700FF","Reactive Power Export"),

        TOTAL_IMPORT_APPARENT_POWER("0100090700FF", "Total import apparent power (QI+QIV)"),
        TOTAL_EXPORT_APPARENT_POWER("01000A0700FF", "Total export apparent power (QII+QIII)"),

        APPARENT_POWER_L1("01001D0700FF","L1 apparent power"),
        APPARENT_POWER_L2("0100310700FF","L2 apparent power"),
        APPARENT_POWER_L3("0100450700FF","L3 apparent power"),

        APPARENT_POWER_EXPORT_L1("01001E0700FF","L1 apparent power-"),
        APPARENT_POWER_EXPORT_L2("0100320700FF","L2 apparent power-"),
        APPARENT_POWER_EXPORT_L3("0100460700FF","L3 apparent power-"),

        POWER_FACTOR_L1("0100210700FF","L1 power factor"),
        POWER_FACTOR_L2("0100350700FF","L2 power factor"),
        POWER_FACTOR_L3("0100490700FF","L3 power factor"),
        TOTAL_POWER_FACTOR("01000D0700FF","Total power factor"),
        ACTIVEPOWER_EXPORT("0100020700FF","Active Power Export"),

        SUPPLY_FREQUENCY_L1("0100220700FF","L1 supply frequency"),
        SUPPLY_FREQUENCY_L2("0100360700FF","L2 supply frequency"),
        SUPPLY_FREQUENCY_L3("01004A0700FF","L3 supply frequency"),
        TOTAL_SUPPLY_FREQUENCY("01000E0700FF","Total supply frequency"),

        ANGLE_L1("0101510704FF","Angle of I(L1)-U(L1)"),
        ANGLE_L2("010151070FFF","Angle of I(L2)-U(L2)"),
        ANGLE_L3("010151071AFF","Angle of I(L3)-U(L3)"),

        LASTMONTH_ACTIVEENERGY_IMPORT1("010001080001","Last month total import active energy (QI+QIV)1"),
        LASTMONTH_ACTIVEENERGY_IMPORT2("010001080065","Last month total import active energy (QI+QIV)2"),
        LASTMONTH_ACTIVEENERGY_EXPORT1("010002080001","Last month total export active energy (QII+QIII)1"),
        LASTMONTH_ACTIVEENERGY_EXPORT2("010002080065","Last month total export active energy (QII+QIII)2"),
        LASTMONTH_REACTIVEENERGY_IMPORT1("010003080001","Last month total import reactive energy (QI+QII)1"),
        LASTMONTH_REACTIVEENERGY_IMPORT2("010003080065","Last month total import reactive energy (QI+QII)2"),
        LASTMONTH_REACTIVEENERGY_EXPORT1("010004080001","Last month total export reactive energy (QIII+QIV)1"),
        LASTMONTH_REACTIVEENERGY_EXPORT2("010004080065","Last month total export reactive energy (QIII+QIV)2"),

        CUMULATIVE_ACTIVEENERGY_IMPORT1("0100010801FF","Cumulative active energy -import1"),
        CUMULATIVE_ACTIVEENERGY_IMPORT2("0100010802FF","Cumulative active energy -import2"),
        CUMULATIVE_ACTIVEENERGY_IMPORT3("0100010803FF","Cumulative active energy -import3"),
        TOTAL_CUMULATIVE_ACTIVEENERGY_IMPORT("0100010800FF","Cumulative active energy -import"),

        CUMULATIVE_ACTIVEENERGY_EXPORT1("0100020801FF","Cumulative active energy -export1"),
        CUMULATIVE_ACTIVEENERGY_EXPORT2("0100020802FF","Cumulative active energy -export2"),
        CUMULATIVE_ACTIVEENERGY_EXPORT3("0100020803FF","Cumulative active energy -export3"),
        TOTAL_CUMULATIVE_ACTIVEENERGY_EXPORT("0100020800FF","Cumulative active energy -export"),

        CUMULATIVE_REACTIVEENERGY_IMPORT1("0100030801FF","Cumulative reactive energy -import1"),
        CUMULATIVE_REACTIVEENERGY_IMPORT2("0100030802FF","Cumulative reactive energy -import2"),
        CUMULATIVE_REACTIVEENERGY_IMPORT3("0100030803FF","Cumulative reactive energy -import3"),
        TOTAL_CUMULATIVE_REACTIVEENERGY_IMPORT("0100030800FF","Cumulative reactive energy -import"),

        CUMULATIVE_REACTIVEENERGY_EXPORT1("0100040801FF","Cumulative reactive energy -export1"),
        CUMULATIVE_REACTIVEENERGY_EXPORT2("0100040802FF","Cumulative reactive energy -export2"),
        CUMULATIVE_REACTIVEENERGY_EXPORT3("0100040803FF","Cumulative reactive energy -export3"),
        TOTAL_CUMULATIVE_REACTIVEENERGY_EXPORT("0100040800FF","Cumulative reactive energy -export"),

        TOTAL_MAX_DEMAND_IMPORT("0100010600FF","Total max demand +A"),
        TOTAL_MAX_DEMAND_IMPORT_T1("0100010601FF","Total maximum demand +A T1"),
        TOTAL_MAX_DEMAND_IMPORT_T2("0100010602FF","Total maximum demand +A T2"),
        TOTAL_MAX_DEMAND_IMPORT_T3("0100010603FF","Total maximum demand +A T3"),

        TOTAL_ACTIVEENERGY_IMPORT("01000F0800FF","Total energy +A"),
        TOTAL_ACTIVEENERGY_EXPORT("0100100800FF","Total energy -A"),
        TOTAL_MAX_ACTIVEDEMAND_EXPORT("0100020600FF","Total max demand -A"),
        TOTAL_MAX_REACTIVEDEMAND_IMPORT("0100030600FF","Total max demand +R"),
        TOTAL_MAX_REACTIVEDEMAND_EXPORT("0100040600FF","Total max demand -R"),
        TOTAL_CUM_ACTIVEDEMAND_IMPORT  ("0100010200FF","Total cumulative demand +A"),
        TOTAL_CUM_ACTIVEDEMAND_EXPORT  ("0100020200FF","Total cumulative demand -A"),
        TOTAL_CUM_REACTIVEDEMAND_IMPORT("0100030200FF","Total cumulative demand +R"),
        TOTAL_CUM_REACTIVEDEMAND_EXPORT("0100040200FF","Total cumulative demand -R"),

        MANUAL_DEMAND_RESET_EVENT_LOG("0100636206FF","Manual demand reset event log"),

        PAYMENT_MODE_SETTING("0000603244FF","Payment mode Setting"),
        TOKEN_CREDIT_HISTORY("0100630F00FF", "STS Token Credit History"),
        OWE_CREDIT_THRESHOLD("0141018C08FF", "STS owe credit"),
        FRIENDLY_CREDIT_THRESHOLD("0141018C0BFF", "STS Friendly credit"),
        TOTAL_OWE_CREDIT("0141018C04FF","Total owe credit"), //total used(spend) credit
        TOTAL_OWE_CREDIT_DECIMAL34("0000138C02FF","DecimalForOweCredit(3,4)"), //total owe가 8888.9483이면, 이 값은 0.0083임.

        CLOCK("0000010000FF","Clock"),

        ACTIVE_FIRMWARE_DATE("0100000280FF", "Wasion Active Firmware Version"),

        /*
         * START STS TARIFF OBIS
         *  -Each '_decimal' code means the object that pointing to the decimal place.
         */
        ACTIVE_TARIFF_CRC("0080600A08FF", "Active Tariff CRC"),
        PASSIVE_TARIFF_CRC("0080600A09FF", "Passive Tariff CRC"),

        THRESHOLD_SWITCH_TIME("0080600207FF","Threshold of Step Switch Time"),
        ACTIVE_THRESHOLD_STEP1("0141007101FF","Active threshold of step1"),
        ACTIVE_THRESHOLD_STEP2("0141007102FF","Active threshold of step2"),
        ACTIVE_THRESHOLD_STEP3("0141007103FF","Active threshold of step3"),
        ACTIVE_THRESHOLD_STEP4("0141007104FF","Active threshold of step4"),
        ACTIVE_THRESHOLD_STEP5("0141007105FF","Active threshold of step5"),
        ACTIVE_THRESHOLD_STEP6("0141007106FF","Active threshold of step6"),
        ACTIVE_THRESHOLD_STEP7("0141007107FF","Active threshold of step7"),
        ACTIVE_THRESHOLD_STEP8("0141007108FF","Active threshold of step8"),
        ACTIVE_THRESHOLD_STEP9("0141007109FF","Active threshold of step9"),
        PASSIVE_THRESHOLD_STEP1("0141006F01FF","Passive threshold of step1"),
        PASSIVE_THRESHOLD_STEP2("0141006F02FF","Passive threshold of step2"),
        PASSIVE_THRESHOLD_STEP3("0141006F03FF","Passive threshold of step3"),
        PASSIVE_THRESHOLD_STEP4("0141006F04FF","Passive threshold of step4"),
        PASSIVE_THRESHOLD_STEP5("0141006F05FF","Passive threshold of step5"),
        PASSIVE_THRESHOLD_STEP6("0141006F06FF","Passive threshold of step6"),
        PASSIVE_THRESHOLD_STEP7("0141006F07FF","Passive threshold of step7"),
        PASSIVE_THRESHOLD_STEP8("0141006F08FF","Passive threshold of step8"),
        PASSIVE_THRESHOLD_STEP9("0141006F09FF","Passive threshold of step9"),

        RATE_SWITCH_TIME("0080600208FF","Rate price Switch Time"),
        ACTIVE_RATE_PRICE1("0141006701FF","Active rate1 price"),
        ACTIVE_RATE_PRICE2("0141006702FF","Active rate2 price"),
        ACTIVE_RATE_PRICE3("0141006703FF","Active rate3 price"),
        ACTIVE_RATE_PRICE4("0141006704FF","Active rate4 price"),
        ACTIVE_RATE_PRICE5("0141006705FF","Active rate5 price"),
        ACTIVE_RATE_PRICE6("0141006706FF","Active rate6 price"),
        ACTIVE_RATE_PRICE7("0141006707FF","Active rate7 price"),
        ACTIVE_RATE_PRICE8("0141006708FF","Active rate8 price"),
        ACTIVE_RATE_PRICE9("0141006709FF","Active rate9 price"),
        ACTIVE_RATE_PRICE10("014100670AFF","Active rate10 price"),
        ACTIVE_RATE_PRICE_DECIMAL("01BF006700FF","Active Price Rate Decimal"),
        PASSIVE_RATE_PRICE1("0141006501FF","Passive rate1 price"),
        PASSIVE_RATE_PRICE2("0141006502FF","Passive rate2 price"),
        PASSIVE_RATE_PRICE3("0141006503FF","Passive rate3 price"),
        PASSIVE_RATE_PRICE4("0141006504FF","Passive rate4 price"),
        PASSIVE_RATE_PRICE5("0141006505FF","Passive rate5 price"),
        PASSIVE_RATE_PRICE6("0141006506FF","Passive rate6 price"),
        PASSIVE_RATE_PRICE7("0141006507FF","Passive rate7 price"),
        PASSIVE_RATE_PRICE8("0141006508FF","Passive rate8 price"),
        PASSIVE_RATE_PRICE9("0141006509FF","Passive rate9 price"),
        PASSIVE_RATE_PRICE10("014100650AFF","Passive rate10 price"),
        PASSIVE_RATE_PRICE_DECIMAL("01BF006500FF","Passive Price Rate Decimal"),

        SERVICE_CHARGE_SWITCH_TIME("008060020AFF","Service Charge Switch Time"),
        ACTIVE_SERVICE_CHARGE1("01BE008201FF","Active Service Charge Step1"),
        ACTIVE_SERVICE_CHARGE2("01BE008202FF","Active Service Charge Step2"),
        ACTIVE_SERVICE_CHARGE3("01BE008203FF","Active Service Charge Step3"),
        ACTIVE_SERVICE_CHARGE4("01BE008204FF","Active Service Charge Step4"),
        ACTIVE_SERVICE_CHARGE5("01BE008205FF","Active Service Charge Step5"),
        ACTIVE_SERVICE_CHARGE6("01BE008206FF","Active Service Charge Step6"),
        ACTIVE_SERVICE_CHARGE7("01BE008207FF","Active Service Charge Step7"),
        ACTIVE_SERVICE_CHARGE8("01BE008208FF","Active Service Charge Step8"),
        ACTIVE_SERVICE_CHARGE9("01BE008209FF","Active Service Charge Step9"),
        ACTIVE_SERVICE_CHARGE10("01BE00820AFF","Active Service Charge Step10"),
        ACTIVE_SERVICE_CHARGE_DECIMAL("01BF008200FF","Active Service Charge Decimal"), //1.191.0.130.0.255
        PASSIVE_SERVICE_CHARGE1("01BE018201FF","Passive Service Charge Step1"),
        PASSIVE_SERVICE_CHARGE2("01BE018202FF","Passive Service Charge Step2"),
        PASSIVE_SERVICE_CHARGE3("01BE018203FF","Passive Service Charge Step3"),
        PASSIVE_SERVICE_CHARGE4("01BE018204FF","Passive Service Charge Step4"),
        PASSIVE_SERVICE_CHARGE5("01BE018205FF","Passive Service Charge Step5"),
        PASSIVE_SERVICE_CHARGE6("01BE018206FF","Passive Service Charge Step6"),
        PASSIVE_SERVICE_CHARGE7("01BE018207FF","Passive Service Charge Step7"),
        PASSIVE_SERVICE_CHARGE8("01BE018208FF","Passive Service Charge Step8"),
        PASSIVE_SERVICE_CHARGE9("01BE018209FF","Passive Service Charge Step9"),
        PASSIVE_SERVICE_CHARGE10("01BE01820AFF","Passive Service Charge Step10"),
        PASSIVE_SERVICE_CHARGE_DECIMAL("01BF018200FF","Passive Service Charge Decimal"),

        GOV_LEVY_SWITCH_TIME("008060020BFF","Gov Levy Switch Time"),
        ACTIVE_GOV_LEVY("01BE008301FF","Active Gov Levy"),
        ACTIVE_GOV_LEVY_DECIMAL("01BF008300FF","Active Gov Levy Decimal"), //1.191.0.131.0.255
        PASSIVE_GOV_LEVY("01BE018301FF","Passive Gov Levy"),
        PASSIVE_GOV_LEVY_DECIMAL("01BF018300FF","Passive Gov Levy Decimal"), //1.191.1.131.0.255

        STREET_LIGHT_SWITCH_TIME("008060020CFF","Street Light Switch Time"),
        ACTIVE_STREET_LIGHT("01BE008401FF","Active Street Light"),
        ACTIVE_STREET_LIGHT_DECIMAL("01BF008400FF","Active Street Light Decimal"), //1.191.0.132.0.255
        PASSIVE_STREET_LIGHT("01BE018401FF","Passive Street Light"),
        PASSIVE_STREET_LIGHT_DECIMAL("01BF018400FF","Passive Street Light Decimal"), //1.191.1.132.0.255

        VAT_SWITCH_TIME("008060020DFF","Active Vat Switch Time"),
        ACTIVE_VAT("01BE008501FF","Vat of Residential"),
        ACTIVE_VAT_DECIMAL("01BF008500FF","Active Vat of Residential Decimal"), //1.191.0.133.0.255
        PASSIVE_VAT("01BE018501FF","Passive Vat of Residential"),
        PASSIVE_VAT_DECIMAL("01BF018500FF","Passive Vat of Residential Decimal"), //1.191.1.133.0.255

        LIFELINE_SUBSIDY_SWITCH_TIME("008060020EFF","Lifeline Subsidy Switch Time"),
        ACTIVE_LIFELINE_SUBSIDY1("01BE008C01FF","Active Lifeline Subsidy Step1"),
        ACTIVE_LIFELINE_SUBSIDY2("01BE008C02FF","Active Lifeline Subsidy Step2"),
        ACTIVE_LIFELINE_SUBSIDY3("01BE008C03FF","Active Lifeline Subsidy Step3"),
        ACTIVE_LIFELINE_SUBSIDY4("01BE008C04FF","Active Lifeline Subsidy Step4"),
        ACTIVE_LIFELINE_SUBSIDY5("01BE008C05FF","Active Lifeline Subsidy Step5"),
        ACTIVE_LIFELINE_SUBSIDY6("01BE008C06FF","Active Lifeline Subsidy Step6"),
        ACTIVE_LIFELINE_SUBSIDY7("01BE008C07FF","Active Lifeline Subsidy Step7"),
        ACTIVE_LIFELINE_SUBSIDY8("01BE008C08FF","Active Lifeline Subsidy Step8"),
        ACTIVE_LIFELINE_SUBSIDY9("01BE008C09FF","Active Lifeline Subsidy Step9"),
        ACTIVE_LIFELINE_SUBSIDY10("01BE008C0AFF","Active Lifeline Subsidy Step10"),
        ACTIVE_LIFELINE_SUBSIDY_DECIMAL("01BF008C00FF","Active Lifeline Subsidy Decimal"), //1.191.0.140.0.255
        PASSIVE_LIFELINE_SUBSIDY1("01BE018C01FF","Passive Lifeline Subsidy Step1"),
        PASSIVE_LIFELINE_SUBSIDY2("01BE018C02FF","Passive Lifeline Subsidy Step2"),
        PASSIVE_LIFELINE_SUBSIDY3("01BE018C03FF","Passive Lifeline Subsidy Step3"),
        PASSIVE_LIFELINE_SUBSIDY4("01BE018C04FF","Passive Lifeline Subsidy Step4"),
        PASSIVE_LIFELINE_SUBSIDY5("01BE018C05FF","Passive Lifeline Subsidy Step5"),
        PASSIVE_LIFELINE_SUBSIDY6("01BE018C06FF","Passive Lifeline Subsidy Step6"),
        PASSIVE_LIFELINE_SUBSIDY7("01BE018C07FF","Passive Lifeline Subsidy Step7"),
        PASSIVE_LIFELINE_SUBSIDY8("01BE018C08FF","Passive Lifeline Subsidy Step8"),
        PASSIVE_LIFELINE_SUBSIDY9("01BE018C09FF","Passive Lifeline Subsidy Step9"),
        PASSIVE_LIFELINE_SUBSIDY10("01BE018C0AFF","Passive Lifeline Subsidy Step10"),
        PASSIVE_LIFELINE_SUBSIDY_DECIMAL("01BF018C00FF","Passive Lifeline Subsidy Decimal"), //1.191.1.140.0.255

        NORMAL_SUBSIDY_SWITCH_TIME("008060020FFF","Normal Subsidy Switch Time"),
        ACTIVE_NORMAL_SUBSIDY1("01BE008D01FF","Active Normal Subsidy Step1"),
        ACTIVE_NORMAL_SUBSIDY2("01BE008D02FF","Active Normal Subsidy Step2"),
        ACTIVE_NORMAL_SUBSIDY3("01BE008D03FF","Active Normal Subsidy Step3"),
        ACTIVE_NORMAL_SUBSIDY4("01BE008D04FF","Active Normal Subsidy Step4"),
        ACTIVE_NORMAL_SUBSIDY5("01BE008D05FF","Active Normal Subsidy Step5"),
        ACTIVE_NORMAL_SUBSIDY6("01BE008D06FF","Active Normal Subsidy Step6"),
        ACTIVE_NORMAL_SUBSIDY7("01BE008D07FF","Active Normal Subsidy Step7"),
        ACTIVE_NORMAL_SUBSIDY8("01BE008D08FF","Active Normal Subsidy Step8"),
        ACTIVE_NORMAL_SUBSIDY9("01BE008D09FF","Active Normal Subsidy Step9"),
        ACTIVE_NORMAL_SUBSIDY10("01BE008D0AFF","Active Normal Subsidy Step10"),
        ACTIVE_NORMAL_SUBSIDY_DECIMAL("01BF008D00FF","Active Normal Subsidy Decimal"), //1.191.0.141.0.255
        PASSIVE_NORMAL_SUBSIDY1("01BE018D01FF","Passive Normal Subsidy Step1"),
        PASSIVE_NORMAL_SUBSIDY2("01BE018D02FF","Passive Normal Subsidy Step2"),
        PASSIVE_NORMAL_SUBSIDY3("01BE018D03FF","Passive Normal Subsidy Step3"),
        PASSIVE_NORMAL_SUBSIDY4("01BE018D04FF","Passive Normal Subsidy Step4"),
        PASSIVE_NORMAL_SUBSIDY5("01BE018D05FF","Passive Normal Subsidy Step5"),
        PASSIVE_NORMAL_SUBSIDY6("01BE018D06FF","Passive Normal Subsidy Step6"),
        PASSIVE_NORMAL_SUBSIDY7("01BE018D07FF","Passive Normal Subsidy Step7"),
        PASSIVE_NORMAL_SUBSIDY8("01BE018D08FF","Passive Normal Subsidy Step8"),
        PASSIVE_NORMAL_SUBSIDY9("01BE018D09FF","Passive Normal Subsidy Step9"),
        PASSIVE_NORMAL_SUBSIDY10("01BE018D0AFF","Passive Normal Subsidy Step10"),
        PASSIVE_NORMAL_SUBSIDY_DECIMAL("01BF018D00FF","Passive Normal Subsidy Decimal"), //1.191.1.141.0.255

        UTILITY_RELIEF_SUBSIDY_SWITCH_TIME("0080600210FF","Utility Relief Switch Time"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY1("01BE008E01FF","Active Utility Relief Step1"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY2("01BE008E02FF","Active Utility Relief Step2"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY3("01BE008E03FF","Active Utility Relief Step3"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY4("01BE008E04FF","Active Utility Relief Step4"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY5("01BE008E05FF","Active Utility Relief Step5"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY6("01BE008E06FF","Active Utility Relief Step6"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY7("01BE008E07FF","Active Utility Relief Step7"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY8("01BE008E08FF","Active Utility Relief Step8"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY9("01BE008E09FF","Active Utility Relief Step9"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY10("01BE008E0AFF","Active Utility Relief Step10"),
        ACTIVE_UTILITY_RELIEF_SUBSIDY_DECIMAL("01BF008E00FF","Active Utility Relief Decimal"), //1.191.0.142.0.255
        PASSIVE_UTILITY_RELIEF_SUBSIDY1("01BE018E01FF","Passive Utility Relief Step1"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY2("01BE018E02FF","Passive Utility Relief Step2"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY3("01BE018E03FF","Passive Utility Relief Step3"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY4("01BE018E04FF","Passive Utility Relief Step4"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY5("01BE018E05FF","Passive Utility Relief Step5"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY6("01BE018E06FF","Passive Utility Relief Step6"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY7("01BE018E07FF","Passive Utility Relief Step7"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY8("01BE018E08FF","Passive Utility Relief Step8"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY9("01BE018E09FF","Passive Utility Relief Step9"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY10("01BE018E0AFF","Passive Utility Relief Step10"),
        PASSIVE_UTILITY_RELIEF_SUBSIDY_DECIMAL("01BF018E00FF","Passive Utility Relief Decimal"), //1.191.1.142.0.255

        //2018-11 add new tariff ('NHIL', 'GETFUND')
        NHIL_SWITCH_TIME("0080600211FF","NHIL Switch Time"), //0.128.96.2.17.255 DATE-TIME
        ACTIVE_NHIL("01BE008601FF","NHIL"),          // 1.190.0.134.1.255 DOUBLE-LONG-UNSIGNED
        PASSIVE_NHIL("01BE018601FF","Passive NHIL"), // 1.190.1.134.1.255 DOUBLE-LONG-UNSIGNED

        GETFUND_SWITCH_TIME("0080600212FF","GETFUND Switch Time"), //0.128.96.2.18.255
        ACTIVE_GETFUND("01BE008701FF","GETFUND"),           //1.190.0.135.1.255 DOUBLE-LONG-UNSIGNED
        PASSIVE_GETFUND("01BE018701FF","Passive GETFUND"),  //1.190.1.135.1.255
        /*
         * END STS TARIFF OBIS
         */

        /*
         * STS Friendly OBIS
         */
        STS_FRIENDLY_DAY_TABLE("00010B0000FF","Friendly Days Table"),
        STS_FRIENDLY_TIME("00010B0000FF","Friendly Time"),
        STS_FRIENDLY_WEEK("00010B0000FF","Friendly Weekday"),
        /*
         * END STS Friendly OBIS
         */

        /*
         * STS Payment Mode OBIS
         */
        ACTIVE_STS_PAYMENTMODE_SETTING("0000603244FF","Active Payment Mode Setting"),
        PASSIVE_STS_PAYMENTMODE_SETTING("0000603245FF","Passive Payment Mode Setting"),
        PASSIVE_STS_PAYMENTMODE_SWITCH_TIME("0080600209FF","Payment Mode Switch Time");
        /*
         * END STS Payment Mode OBIS
         */


        //Error register1(push)	0.0.97.97.0.255
        //Error register2(push)	0.0.97.97.5.255
        //Alarm register1	0.0.97.98.0.255
        //Alarm register2	0.0.97.98.1.255
        //Alarm filter1	0.0.97.98.10.255
        //Alarm filter2	0.0.97.98.11.255
        //Alarm descriptor1	0.0.97.98.20.255
        //Alarm descriptor2	0.0.97.98.21.255

        private String code;
        private String name;

        OBIS(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return this.code;
        }

        public String getName() {
            return this.name;
        }

        public static OBIS getObis(String code) {
            for (OBIS obis : values()) {
                if (obis.getCode().equals(code)) return obis;
            }
            return null;
        }
    }

    public enum DLMS_CLASS {
        TOKEN_GATEWAY(115),

        DATA(1),
        REGISTER(3),
        EXTEND_REGISTER(4),
        DEMAND_REGISTER(5),
        REGISTER_ACTIVATION(6),
        PROFILE_GENERIC(7),
        CLOCK(8),
        SCRIPT_TABLE(9),
        SCHEDULE(10),
        SPECIAL_DAY(11),
        ACTIVITY_CALENDAR(20),
        ASSOCIATION_LN(15),
        ASSOCIATION_SN(12),
        REGISTER_MONITOR(21),
        SAP_ASSIGN(17),
        UTILITY_TABLE(26),
        SINGLE_ACTION_SCHEDULE(22),
        HDLC(23),
        RELAY_CLASS(70),
        G3_PLC_6LoWPAN(92);

        private int clazz;

        DLMS_CLASS(int clazz) {
            this.clazz = clazz;
        }

        public int getClazz() {
            return this.clazz;
        }
    }

    public enum DLMS_CLASS_ATTR {
        TOKEN_ATTR01(1),
        TOKEN_ATTR02(2),

        DATA_ATTR01(2),            // value
        REGISTER_ATTR02(2),        // value
        REGISTER_ATTR03(3),        // scalar unit
        REGISTER_ATTR04(4),        // status
        REGISTER_ATTR05(5),        // time
        PROFILE_GENERIC_ATTR02(2), // buffer
        PROFILE_GENERIC_ATTR03(3),        // capture_objects array
        PROFILE_GENERIC_ATTR04(4),        // value
        PROFILE_GENERIC_ATTR07(7), // entries in use
        CLOCK_ATTR01(1),//logical name
        CLOCK_ATTR02(2),//time
        CLOCK_ATTR03(3),//time_zone
        CLOCK_ATTR04(4),//status
        CLOCK_ATTR05(5),//dst_start
        CLOCK_ATTR06(6),//dst end
        CLOCK_ATTR07(7),//dst deviation
        CLOCK_ATTR08(8),//dst enable
        CLOCK_ATTR09(9),//clock base
        SCRIPT_TABLE_ATTR01(1),
        SCRIPT_TABLE_ATTR02(2),
        ADP_WEAK_LQI_VALUE(3),
        HDLC_ATTR01(1),
        HDLC_ATTR02(2),
        HDLC_ATTR03(3),
        HDLC_ATTR04(4),
        HDLC_ATTR05(5),
        HDLC_ATTR06(6),
        HDLC_ATTR07(7),
        HDLC_ATTR08(8),
        HDLC_ATTR09(9);

        private int attr;

        DLMS_CLASS_ATTR(int attr) {
            this.attr = attr;
        }

        public int getAttr() {
            return this.attr;
        }
    }



}
