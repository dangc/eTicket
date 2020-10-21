package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TargetByMeter {

    private Integer code;
    private String geocode;
    private String address;
    private String lastChargeDate;
    private String customerId;
    private String customerName;
    private String mobileNumber;
    private String supplyState;
    private Double credit;
    private Double arrears;
    private Double debtTotal;

    public TargetByMeter(Integer code, String geocode, String address, String lastChargeDate, String customerId, String customerName, String mobileNumber, String supplyState, Double credit, Double arrears, Double debtTotal) {
        this.code = code;
        this.geocode = geocode;
        this.address = address;
        this.lastChargeDate = lastChargeDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.supplyState = supplyState;
        this.credit = credit;
        this.arrears = arrears;
        this.debtTotal = debtTotal;
    }

    public static TargetByMeter getTargetByMeter(String meterId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        TargetByMeter meter = new TargetByMeter(200,"03042100300702000", "7200-PRAMPRAM, St1 - Prampram - PRAMPRAM",
                dateFormat.format(new Date()),"4014", "ECGCustomer", "+233 24-323-4545", "Normal", 725.77,0.0, 20.0);

        return meter;

    }
}
