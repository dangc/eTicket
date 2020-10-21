package com.nuri.etk.store;

import com.nuri.etk.entity.API.Dcu;

import java.util.List;

public interface DcuStore {

    List<Dcu> retrieveAllDcus(Dcu dcu);

    Dcu retrieveById(String dcuId);

    boolean existDcuById(String dcuId);
}