package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Dcu;

import java.util.List;

public interface SampleService {

    List<Dcu> findDcus();

    Dcu findById(String dcuId);
}
