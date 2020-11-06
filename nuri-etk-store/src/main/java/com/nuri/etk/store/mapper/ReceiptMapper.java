package com.nuri.etk.store.mapper;

import com.nuri.etk.entity.API.Receipt;
import com.nuri.etk.store.jpo.CustomerInfoJpo;
import com.nuri.etk.store.jpo.PaymentInfoJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiptMapper {
    List<CustomerInfoJpo> getReceiptInfo_customerInfo(String meterId, String chargeId) throws Exception;
    List<PaymentInfoJpo> getReceiptInfo_paymentInfo(String meterId, String chargeId) throws Exception;
}