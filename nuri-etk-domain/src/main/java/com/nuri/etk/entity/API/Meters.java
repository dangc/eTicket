package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Meters {

    private String meterId;
    private String modemId;

    public Meters(String meterId, String modemId) {
        this.meterId = meterId;
        this.modemId = modemId;
    }

}
