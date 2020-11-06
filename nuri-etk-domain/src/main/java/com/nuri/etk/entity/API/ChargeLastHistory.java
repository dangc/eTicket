package com.nuri.etk.entity.API;


import com.nuri.etk.entity.pojo.PaymentInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChargeLastHistory {

    private Integer code;
    private List<PaymentInfo> paymentInfo;

    public ChargeLastHistory(Integer code, List<PaymentInfo> paymentInfo) {
        this.code = code;
        this.paymentInfo = paymentInfo;
    }

    /*public static ChargeLastHistory chargeLast(String meterId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        PaymentInfo paymentInfo = new PaymentInfo(meterId, "20200825", "MobileMoney", 100.0, 80.0,
                15.0000, 95.0000, "00CCE225", 15, "16691535439905570",
                "ECG", "Card", "GHC", "39295113524654887973", "66785113524654885456",
                dateFormat.format(new Date()),10.0000, 10.0000);

        ChargeLastHistory charge = new ChargeLastHistory(200, paymentInfo);

        return charge;
    }*/
}
