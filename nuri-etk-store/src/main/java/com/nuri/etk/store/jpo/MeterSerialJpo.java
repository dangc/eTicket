package com.nuri.etk.store.jpo;

import com.nuri.etk.entity.API.MeterSerial;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MeterSerialJpo {
    private Integer code;
    private String meterId;

    public MeterSerialJpo(MeterSerial meterSerial) {
        if(meterSerial != null){
            this.code = meterSerial.getCode();
            this.meterId = meterSerial.getMeterId();
        }
    }

    public MeterSerial toDomain(){
        MeterSerial meterSerial = new MeterSerial();
        meterSerial.setCode(this.code);
        meterSerial.setMeterId(this.meterId);
        return meterSerial;
    }
}
