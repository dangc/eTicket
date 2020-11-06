package com.nuri.etk.store.mapper;

import com.nuri.etk.entity.API.ChargeLastHistory;
import com.nuri.etk.store.jpo.PaymentInfoJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChargeHistoryMapper {
    List<PaymentInfoJpo> chargeLast(String meterId);
}