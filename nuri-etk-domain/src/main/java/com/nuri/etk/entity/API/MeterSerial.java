package com.nuri.etk.entity.API;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MeterSerial {
    private Integer code;
    private String meterId;

    public MeterSerial(Integer code, String meterId) {
        this.code = code;
        this.meterId = meterId;
    }

    public MeterSerial(MeterSerial meterSerial) {
        if(meterSerial != null){
            this.code = meterSerial.getCode();
            this.meterId = meterSerial.getMeterId();
        }
    }
}
