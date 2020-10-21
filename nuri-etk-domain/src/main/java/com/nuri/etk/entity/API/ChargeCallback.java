package com.nuri.etk.entity.API;


import com.nuri.etk.entity.pojo.ChargeCancelInfo;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.entity.pojo.ErrorCode;
import com.nuri.etk.exception.MissingRequiredDataException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChargeCallback {

    @ApiModelProperty(value = "chargeId", example = "")
    private String chargeId;

    @ApiModelProperty(value = "code", example = "200")
    private Integer code;

    @ApiModelProperty(value = "resultDetail", example = "true")
    private String resultDetail;

    public ChargeCallback(String chargeId, Integer code, String resultDetail) {
        this.chargeId = chargeId;
        this.code = code;
        this.resultDetail = resultDetail;
    }

    public static ChargeCallback meterChargeCallback (String meterId, HttpHeaders headers, ChargeInfo chargeInfo) {
        ChargeCallback chargeCallback = new ChargeCallback();

        //charge 통신시간 딜레이 주기
        try {
            System.out.println("######## Charge Callback 통신시간 딜레이 ########");
           Thread.sleep(2000);

           List<String> callbackUrl = headers.get("callbackUrl");
           if(!callbackUrl.isEmpty()){
               for(int i=0; i <= callbackUrl.size(); i++){
                   URL url = new URL(callbackUrl.get(i));
                   HttpURLConnection con = (HttpURLConnection) url.openConnection();
                   con.setRequestMethod("PUT"); // HTTP 메소드 설정
                   con.setRequestProperty("chargeId", chargeCallback.getChargeId());
                   con.setRequestProperty("code", Integer.toString(chargeCallback.getCode()));
                   con.setRequestProperty("resultDetail", chargeCallback.getResultDetail());
                   con.setDoOutput(true); // POST 파라미터 전달을 위한 설정
                   con.connect();

                   int responseCode = con.getResponseCode();
                   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), Charset.forName("UTF-8")));
                   String inputLine;
                   StringBuffer response = new StringBuffer();

                   while ((inputLine = in.readLine()) != null) {
                       response.append(inputLine);
                   }
                   in.close();

                   // print result

//                   System.out.println("HTTP 응답 코드 : " + responseCode);
                   System.out.println("HTTP 응답 코드 : " + ErrorCode.getCodeString(responseCode));
                   System.out.println("HTTP body : " + response.toString());

               }

           }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
           e.printStackTrace();
       }finally {
           chargeCallback = new ChargeCallback(chargeInfo.getChargeId(), 200, "true");
       }
        System.out.println("######## Charge Callback 완료 ########");

//        return charge;
        return chargeCallback;
    }

    public static ChargeCallback meterChargeCancleCallback (String meterId, HttpHeaders headers, ChargeCancelInfo chargeCancelInfo) {

        ChargeCallback chargeCancleCallback = new ChargeCallback(chargeCancelInfo.getChargeId(), 200, "true");
        //Cancle 통신시간 딜레이 주기
        try {
            System.out.println("######## Charge Cancle Callback 통신시간 딜레이 2초 ########");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("######## Charge Cancle Callback ########");

        return chargeCancleCallback;
    }

    //충전 결과 전송 callback
    public static ChargeCallback chargeResult (HttpHeaders headers, ChargeCallback chargeCallback) {
        ChargeCallback chargeResult = new ChargeCallback();

        try {
            //ChargeId 검증
            if("".equals(chargeCallback.getChargeId()) || chargeCallback.getChargeId() == null){
                throw new MissingRequiredDataException();
            }

            chargeResult = new ChargeCallback(chargeCallback.getChargeId(), 200, "true");
        }catch (MissingRequiredDataException e){
            chargeResult = new ChargeCallback(chargeCallback.getChargeId(), 330, "false");
            e.printStackTrace();
        }catch (Exception e){
            chargeResult = new ChargeCallback(chargeCallback.getChargeId(), 500, "false");
            e.printStackTrace();
        }finally {
            System.out.println("######## chargeResult 완료 ########");
            return chargeResult;
        }
    }

    @Override
    public String toString() {
        return "ChargeCallback{" +
                "chargeId='" + chargeId + '\'' +
                ", code=" + code +
                ", resultDetail='" + resultDetail + '\'' +
                '}';
    }
}
