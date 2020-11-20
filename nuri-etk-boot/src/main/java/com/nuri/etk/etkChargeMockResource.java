package com.nuri.etk;

import com.nuri.etk.entity.API.Charge;
import com.nuri.etk.entity.API.ChargeCallback;
import com.nuri.etk.entity.pojo.ChargeCancelInfo;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.facade.flow.ChargeFlowFacade;
import com.nuri.etk.spec.ChargeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
                              @RequestHeader("async") boolean async,
//                              @RequestHeader("callbackUrl") String callbackUrl,
                              @RequestHeader HttpHeaders headers,
                              @RequestBody ChargeInfo chargeInfo) throws Exception {
        System.out.println("######## Charge parameter {meterId} : " + meterId + " ########");
        System.out.println("######## Charge parameter {chargeInfo} : " + chargeInfo.toString() + " ########");

        return chargeService.meterCharge(meterId, headers, chargeInfo);
    }

    @Override
    @ApiOperation(value = "충전 취소 요청", notes = "충전 취소 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @PostMapping(value="/{meterId}/charge-cancellation")
    public Charge meterChargeCancle(@PathVariable String meterId,
                                    @RequestHeader("async") boolean async,
                                    @RequestHeader HttpHeaders headers,
                                    @RequestBody ChargeCancelInfo chargeCancelInfo){

        System.out.println("######## Charge Cancle parameter {meterId} : " + meterId + " ########");
        System.out.println("######## Charge Cancle parameter {chargeCancelInfo} : " + chargeCancelInfo.toString() + " ########");

        Charge charge = new Charge();
        charge = charge.meterChargeCancle(meterId, headers, chargeCancelInfo);

        if("true".equals(charge.getResultDetail())){
            // async = true일 시 callback 호출
            if(async){
                ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        executorService.execute((Runnable) chargeCancleCallback(meterId, headers, chargeCancelInfo));
                    }
                });
            }
        }

        return charge;
    }

    public ChargeCallback chargeCallback (String meterId, HttpHeaders headers, ChargeInfo chargeInfo){
        return ChargeCallback.meterChargeCallback(meterId, headers, chargeInfo);
    }

    public ChargeCallback chargeCancleCallback (String meterId, HttpHeaders headers, ChargeCancelInfo chargeCancelInfo){
        return ChargeCallback.meterChargeCancleCallback(meterId, headers, chargeCancelInfo);
    }
}
