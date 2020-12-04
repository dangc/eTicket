package com.nuri.etk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuri.etk.entity.API.Charge;
import com.nuri.etk.entity.API.ChargeCallback;
import com.nuri.etk.entity.pojo.ArrearsDebt;
import com.nuri.etk.entity.pojo.ChargeCancelInfo;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.facade.flow.ChargeFlowFacade;
import com.nuri.etk.spec.ChargeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.JSONParser;


@RestController
@CrossOrigin("*")
@Api(description = "충전 요청/취소 Resource")
@RequestMapping("/v2.0/meters")
public class etkChargeMockResource implements ChargeFlowFacade {
    private ChargeService chargeService;
    int threadPoolSize = 5;
    int _timeout = 300;

    public etkChargeMockResource(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @Override
    @ApiOperation(value = "충전 요청", notes = "충전 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @PostMapping(value="/{meterId}/charge")
    public Charge meterCharge(@PathVariable String meterId,
                              @RequestHeader HttpHeaders headers,
                              @RequestBody String bodyInfo) throws Exception {
        //RequestBody Json data convert to POJO
        ChargeInfo chargeInfo = parseJSON_Charge(bodyInfo);

        System.out.println("######## Charge parameter {meterId} : " + meterId + " ########");
        System.out.println("######## Charge parameter {chargeInfo} : " + bodyInfo + " ########");

        return chargeService.meterCharge(meterId, headers, chargeInfo);
    }

    @Override
    @ApiOperation(value = "충전 취소 요청", notes = "충전 취소 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @PostMapping(value="/{meterId}/charge-cancellation")
    public Charge meterChargeCancle(@PathVariable String meterId,
                                    @RequestHeader HttpHeaders headers,
                                    @RequestBody String bodyInfo) throws Exception {
        //RequestBody Json data convert to POJO
        ChargeCancelInfo chargeCancelInfo = parseJSON_ChargeCancle(bodyInfo);

        System.out.println("######## Charge Cancle parameter {meterId} : " + meterId + " ########");
        System.out.println("######## Charge Cancle parameter {chargeCancelInfo} : " + chargeCancelInfo.toString() + " ########");

        return chargeService.meterChargeCancle(meterId, headers, chargeCancelInfo);
    }

    public ChargeCallback chargeCallback (String meterId, HttpHeaders headers, ChargeInfo chargeInfo){
        return ChargeCallback.meterChargeCallback(meterId, headers, chargeInfo);
    }

    public ChargeCallback chargeCancleCallback (String meterId, HttpHeaders headers, ChargeCancelInfo chargeCancelInfo){
        return ChargeCallback.meterChargeCancleCallback(meterId, headers, chargeCancelInfo);
    }

    public ChargeInfo parseJSON_Charge(String bodyStr) throws Exception {
        ChargeInfo chargeInfo = new ChargeInfo();
        List<ArrearsDebt> debts = new ArrayList<>();
        ArrearsDebt arrearsDebt =  new ArrearsDebt();

        String newbodyStr = bodyStr.replaceAll("ChargeInfo", "");
        newbodyStr = newbodyStr.replaceAll("ArrearsDebt", "");
        newbodyStr = newbodyStr.replaceAll("data=", "");
        newbodyStr = newbodyStr.replaceAll(" ", "");
        newbodyStr = newbodyStr.replace("{", "");
        newbodyStr = newbodyStr.replace("}", "");
        newbodyStr = newbodyStr.replace("[", "");
        newbodyStr = newbodyStr.replace("]", "");
        newbodyStr = newbodyStr.replace("'", "");

        String[] values = newbodyStr.split(",");
        int i = 0;
        int j = 0;
        for (String value : values) {
            String[] pair = value.split("=");
            if (pair.length == 2) {
                if("utility".equals(pair[0])){
                    chargeInfo.setUtility(pair[1]);
                }else if("operatorId".equals(pair[0])){
                    chargeInfo.setOperatorId(pair[1]);
                }else if("chargeId".equals(pair[0])){
                    chargeInfo.setChargeId(pair[1]);
                }else if("paidAmount".equals(pair[0])){
                    chargeInfo.setPaidAmount(pair[1]);
                }else if("chargedCredit".equals(pair[0])){
                    chargeInfo.setChargedCredit(pair[1]);
                }else if("chargedArrears".equals(pair[0])){
                    chargeInfo.setChargedArrears(pair[1]);
                }else if("debtType".equals(pair[0])){
                    arrearsDebt.setDebtType(pair[1]);
                    i++;
                }else if("debtRef".equals(pair[0])){
                    arrearsDebt.setDebtRef(pair[1]);
                    i++;
                }else if("paidDebtAmount".equals(pair[0])){
                    arrearsDebt.setPaidDebtAmount(Double.valueOf(pair[1]));
                    i++;
                }
            }
            //JsonArray data parsing
            if(i == 3){
                debts.add(j++, arrearsDebt);
                arrearsDebt = new ArrearsDebt();
                i = 0;
            }
        }
        chargeInfo.setDebt(debts);
        return chargeInfo;
    }

    public ChargeCancelInfo parseJSON_ChargeCancle(String bodyStr) throws Exception {
        ChargeCancelInfo chargeCancelInfo = new ChargeCancelInfo();
//        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";

        String newbodyStr = bodyStr.replaceAll("ChargeCancelInfo", "");
//        newbodyStr = newbodyStr.replaceAll(match, "");
        newbodyStr = newbodyStr.replaceAll(" ", "");
        newbodyStr = newbodyStr.replace("{", "");
        newbodyStr = newbodyStr.replace("}", "");
        newbodyStr = newbodyStr.replace("'", "");
//        newbodyStr = newbodyStr.replace("\"", "");

        String[] values = newbodyStr.split(",");
        for (String value : values) {
            String[] pair = value.split("=");
            if (pair.length == 2) {
                if("operatorId".equals(pair[0])){
                    chargeCancelInfo.setOperatorId(pair[1]);
                }else if("chargeId".equals(pair[0])){
                    chargeCancelInfo.setChargeId(pair[1]);
                }else if("cancelReason".equals(pair[0])){
                    chargeCancelInfo.setCancelReason(pair[1]);
                }
            }
        }
        return chargeCancelInfo;
    }
}
