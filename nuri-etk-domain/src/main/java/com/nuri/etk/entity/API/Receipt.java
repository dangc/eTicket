package com.nuri.etk.entity.API;


import com.nuri.etk.entity.pojo.CustomerInfo;
import com.nuri.etk.entity.pojo.ErrorCode;
import com.nuri.etk.entity.pojo.PaymentInfo;
import com.nuri.etk.exception.MissingRequiredDataException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Receipt {
    private Integer code;
    private CustomerInfo customerInfo;
    private PaymentInfo paymentInfo;

    public Receipt(Integer code, CustomerInfo customerInfo, PaymentInfo paymentInfo) {
        this.code = code;
        this.customerInfo = customerInfo;
        this.paymentInfo = paymentInfo;
    }

    public static Receipt getReceipt(String meterId, String chargeId){
        CustomerInfo customerInfo = new CustomerInfo();
        PaymentInfo paymentInfo = new PaymentInfo();
        Receipt receipt = new Receipt();

        try {
            // 날짜 validation - chargeId null값 체크
            if(chargeId.isEmpty()){
                throw new MissingRequiredDataException();
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

            customerInfo = new CustomerInfo("etoken_user", "03042100320101500", "10180723-01", "Resident", "East Legon District", "8120-DAWHENYA, St1 - Prampram - DAWHENYA");

            paymentInfo = new PaymentInfo(meterId, "20200901145714", "MobileMoney", 1000.0, 900.0,
                    10.0, 910.0, chargeId, 15, "16691535439905570",
                    "ECG", "Card", "GHC", "39295113524654887973", "66785113524654885456",
                    dateFormat.format(new Date()),50.0, 50.0);

            receipt = new Receipt(200, customerInfo, paymentInfo);

        }catch (MissingRequiredDataException e){
            receipt = new Receipt(330, customerInfo, paymentInfo);
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(receipt.getCode()) + " ########");
            e.printStackTrace();
        }catch (Exception e){
            receipt = new Receipt(500, customerInfo, paymentInfo);
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(receipt.getCode()) + " ########");
            e.printStackTrace();
        }finally {
            return receipt;
        }
    }
}
