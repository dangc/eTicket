package com.nuri.etk.store.jpo;

import com.nuri.etk.entity.API.Dcu;
import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.entity.API.Meters;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MeterJpo {

    private String meterId;
    private String modemId;

    public MeterJpo(Meters meters) {
        if(meters != null) {
            this.meterId = meters.getMeterId();
            this.modemId = meters.getModemId();
        }
    }

    public Meters toDomain() {
        Meters meters = new Meters();
        meters.setMeterId(this.meterId);
        meters.setModemId(this.modemId);
        return meters;
    }
}
