package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.Dcu;

import java.util.List;

public interface DcuFlowFacade {
    Dcu findDcuById(String dcuId);
    List<Dcu> findDcus();
}
