package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Receipt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReceiptService {
    Receipt getReceiptInfo(String meterId, String chargeId);
}
