package com.nuri.etk;

import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.entity.API.RegisterInfoByMeter;
import com.nuri.etk.entity.API.TargetByMeter;
import com.nuri.etk.facade.flow.MeterFlowFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Api(description = "미터 정보 Resource")
@RequestMapping("/v2.0")
public class etkMeterMockResource implements MeterFlowFacade {

    @Override
    @ApiOperation(value = "미터 조회", notes = "미터 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}"})
    public Meter getMeterInfo(@PathVariable String meterId){
        System.out.println("######## getMeterInfo parameter {meterId} : " + meterId + " ########");
        return Meter.getTargetByMeter(meterId);
    }

    @Override
    @GetMapping(value={"/meters/getMeterList"})
    public Meter getMeterList(String customerNo){
        return Meter.getMeterList(customerNo);
    }

    @Override
//    @GetMapping(value={"/meters/getMeterByGC"})
    public Meter getMeterByGC(String supplier, String geocode){
        return Meter.getMeterByGC(supplier, geocode);
    }

    @Override
    @ApiOperation(value = "충전 시 대상 조회", notes = "충전 시 대상 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/target"})
    public TargetByMeter getTargetByMeter(@PathVariable String meterId){
        System.out.println("######## getTargetByMeter parameter {meterId} : " + meterId + " ########");
        return TargetByMeter.getTargetByMeter(meterId);
    }

    @Override
    @ApiOperation(value = "미터 등록시 전화번호 인증", notes = "미터 등록시 전화번호 인증 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/register"})
    public RegisterInfoByMeter getRegisterInfoByMeter(@PathVariable String meterId){
        System.out.println("######## getRegisterInfoByMeter parameter {meterId} : " + meterId + " ########");
        return RegisterInfoByMeter.getRegisterInfoByMeter(meterId);
    }
}
