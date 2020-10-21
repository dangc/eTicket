package com.nuri.etk.entity.API;


import com.nuri.etk.exception.MissingRequiredDataException;
import com.nuri.etk.entity.pojo.ErrorCode;
import com.nuri.etk.entity.pojo.PaymentInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class ChargeHistory {

    private Integer code;
    private Integer totalCount;
    private ArrayList<PaymentInfo> chargeLogs;

    public ChargeHistory(Integer code, Integer totalCount, ArrayList<PaymentInfo> chargeLogs) {
        this.code = code;
        this.totalCount = totalCount;
        this.chargeLogs = chargeLogs;
    }

    public static ChargeHistory chargeHistory(String meterId, String startDate, String endDate, String paymentType, String listCount, String pageCount) throws Exception {
        ChargeHistory chargeHistory = new ChargeHistory();

        try {
            // 날짜 validation - date null값 체크
            if(startDate.isEmpty() && endDate.isEmpty()){
                throw new MissingRequiredDataException();
            }
            // 날짜 validation - startDate가 endDate보다 큰경우
            if(Integer.parseInt(startDate) > Integer.parseInt(endDate)){
                throw new MissingRequiredDataException();
            }

            // 페이징처리 validation - listCount, pageCount null값 체크
            if(listCount.isEmpty() || pageCount.isEmpty()){
                throw new MissingRequiredDataException();
            }

            Random random = new Random();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            int start = Integer.parseInt(startDate);
            int end = Integer.parseInt(endDate);

            ArrayList<PaymentInfo> chargeLogs= new ArrayList<>();

            for(int i= start; start <= end; start++){
                chargeLogs.add(new PaymentInfo(meterId, Integer.toString(start), "VendingStation", 100.0, 90.0,
                        5.0000, 95.0000, "00CCE225", 0, "16691535439905570",
                        "ECG", paymentType, "GHC", "39295113524654887973", "66785113524654885456",
                        dateFormat.format(new Date()),10.0000, 0.0000));
            }

            chargeHistory = new ChargeHistory(200, chargeLogs.size() ,chargeLogs);

        }catch (MissingRequiredDataException e){
            chargeHistory =  new ChargeHistory(330, 0, new ArrayList<PaymentInfo>());
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(chargeHistory.getCode()) + " ########");
            e.printStackTrace();
        }catch (Exception e){
            chargeHistory =  new ChargeHistory(500, 0, new ArrayList<PaymentInfo>());
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(chargeHistory.getCode()) + " ########");
            e.printStackTrace();
        }finally {
            return chargeHistory;
        }
    }
}
