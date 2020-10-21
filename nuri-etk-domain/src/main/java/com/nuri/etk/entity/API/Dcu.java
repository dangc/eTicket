package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Dcu {

    private String dcuId;
    private String ip;
    private Integer port;
    private String nameSpace;
    private String dcuStatus;

    public Dcu (String dcuId, String ip, int port) {
        this.dcuId = dcuId;
        this.ip = ip;
        this.port = port;
    }

    public static List<Dcu> sample() {

        List<Dcu> dcus = new ArrayList<Dcu>();

        dcus.add(new Dcu("1000","127.0.0.1", 8000));
        dcus.add(new Dcu("1001","127.0.0.2", 8000));
        dcus.add(new Dcu("1002","127.0.0.3", 8080));

        return dcus;
    }
}
