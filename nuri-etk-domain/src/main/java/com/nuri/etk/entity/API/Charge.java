package com.nuri.etk.entity.API;


import com.nuri.etk.exception.MeterDoesNotExistException;
import com.nuri.etk.exception.MissingRequiredDataException;
import com.nuri.etk.exception.OperatorDoesNotExistException;
import com.nuri.etk.entity.pojo.ChargeCancelInfo;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.entity.pojo.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

@Getter
@Setter
@NoArgsConstructor
public class Charge {

    private Integer code;
    private String token;
    private String resultDetail;

    public Charge(Integer code, String token, String resultDetail) {
        this.code = code;
        this.token = token;
        this.resultDetail = resultDetail;
    }

    public static Charge meterCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo) throws Exception {
        Charge charge = new Charge();

        try {
            //meterId 검증
            if(!"1234".equals(meterId) && !"2233".equals(meterId)){
                throw new MeterDoesNotExistException();
            }
            //OperatorId 검증
            if("".equals(chargeInfo.getOperatorId()) || chargeInfo.getOperatorId() == null){
                throw new OperatorDoesNotExistException();
            }
            //ChargeId 검증
            if("".equals(chargeInfo.getChargeId()) || chargeInfo.getChargeId() == null){
                throw new MissingRequiredDataException();
            }

            //token 정보는 HES로 요청
            charge = new Charge(202, "39295113524654887973", "true");

        }catch (MissingRequiredDataException e){
            charge = new Charge(330, "", "false");
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(charge.getCode()) + " ########");
            e.printStackTrace();
        }catch (MeterDoesNotExistException e){
            charge = new Charge(340, "", "false");
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(charge.getCode()) + " ########");
            e.printStackTrace();
        }catch (OperatorDoesNotExistException e){
            charge = new Charge(343, "", "false");
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(charge.getCode()) + " ########");
            e.printStackTrace();
        }catch (Exception e){
            charge = new Charge(500, "", "false");
            e.printStackTrace();
        }finally {
            System.out.println("######## Meter Charge 종료 ########");
            return charge;
        }
    }

    public static Charge meterChargeCancle(String meterId, HttpHeaders headers, ChargeCancelInfo chargeCancelInfo) {
        Charge charge = new Charge();

        try {
            //meterId 검증
            if(!"1234".equals(meterId)){
                throw new MeterDoesNotExistException();
            }
            //OperatorId 검증
            if("".equals(chargeCancelInfo.getOperatorId()) || chargeCancelInfo.getOperatorId() == null){
                throw new OperatorDoesNotExistException();
            }
            //ChargeId 검증
            if("".equals(chargeCancelInfo.getChargeId()) || chargeCancelInfo.getChargeId() == null){
                throw new MissingRequiredDataException();
            }

            //token 정보는 HES로 요청
            charge = new Charge(202, "39295113524654887973", "true");

        }catch (MissingRequiredDataException e){
            charge = new Charge(330, "", "false");
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(charge.getCode()) + " ########");
            e.printStackTrace();
        }catch (MeterDoesNotExistException e){
            charge = new Charge(340, "", "false");
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(charge.getCode()) + " ########");
            e.printStackTrace();
        }catch (OperatorDoesNotExistException e){
            charge = new Charge(343, "", "false");
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(charge.getCode()) + " ########");
            e.printStackTrace();
        }catch (Exception e){
            charge = new Charge(500, "", "false");
            e.printStackTrace();
        }finally {
            System.out.println("######## Meter Charge Cancle 종료 ########");
            return charge;
        }
    }
}
