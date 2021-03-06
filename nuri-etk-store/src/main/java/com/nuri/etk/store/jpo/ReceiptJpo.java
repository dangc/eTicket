package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.API.Receipt;
import com.nuri.etk.entity.pojo.CustomerInfo;
import com.nuri.etk.entity.pojo.ErrorCode;
import com.nuri.etk.entity.pojo.PaymentInfo;
import com.nuri.etk.exception.MissingRequiredDataException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReceiptJpo {
    private Integer code;
    private List<CustomerInfo> customerInfo;
    private List<PaymentInfo> paymentInfo;

    public ReceiptJpo(Receipt receipt) {
        if(receipt != null){
            this.code = receipt.getCode();
            this.customerInfo = receipt.getCustomerInfo();
            this.paymentInfo = receipt.getPaymentInfo();
        }
    }

    public Receipt toDomain() {
        Receipt receipt = new Receipt();
        receipt.setCode(this.code);
        receipt.setCustomerInfo(this.customerInfo);
        receipt.setPaymentInfo(this.paymentInfo);
        return receipt;
    }

}
