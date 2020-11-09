package com.nuri.etk;

import ch.qos.logback.classic.Logger;
import com.nuri.etk.entity.API.Usage;
import com.nuri.etk.entity.API.UsageBalance;
import com.nuri.etk.entity.API.UsageMonthly;
import com.nuri.etk.entity.API.UsageYearly;
import com.nuri.etk.facade.flow.UsageFlowFacade;
import com.nuri.etk.spec.UsageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Api(description = "사용량 정보 Resource")
@RequestMapping("/v2.0")
public class etkUsageMockResource implements UsageFlowFacade {
    private UsageService usageService;
    Logger log = null;

    public etkUsageMockResource(UsageService usageService) {
        this.usageService = usageService;
    }

    @Override
    @ApiOperation(value = "현재 잔액 및 사용량 조회", notes = "현재 잔액 및 사용량 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/balance"})
    public UsageBalance getBalance(@PathVariable String meterId) {
        System.out.println("######## getBalance parameter {meterId} : " + meterId + " ########");
        return usageService.getBalance(meterId);
    }

    @Override
    @ApiOperation(value = "현재 사용량/요금 조회", notes = "현재 사용량/요금 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/usage"})
    public Usage getUsage(@PathVariable String meterId) {
//        log.info("meterId : {}", meterId);
        System.out.println("######## getUsage parameter {meterId} : " + meterId + " ########");
        return usageService.getUsage(meterId);
    }

    @Override
    @ApiOperation(value = "현재 월 사용량/요금 조회", notes = "현재 월 사용량/요금 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/usage/monthly"})
    public UsageMonthly getUsageMonthly(@PathVariable String meterId) {
        System.out.println("######## getUsageMonthly parameter {meterId} : " + meterId + " ########");
        return usageService.getUsageMonthly(meterId);
    }

    @Override
    @ApiOperation(value = "연간 월별 사용량/요금 조회", notes = "연간 월별 사용량/요금 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = ""),
            @ApiImplicitParam(name = "startDate", value = "조회 시작일자(yyyyMM)", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "endDate", value = "조회 종료일자(yyyyMM)", required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/usage/yearly"})
//    public UsageYearly getUsageYearly(@PathVariable String meterId, HttpServletRequest req) {
    public UsageYearly getUsageYearly(@PathVariable String meterId,
                                      @RequestParam(value="startDate", required=false) String startDate,
                                      @RequestParam(value="endDate", required=false) String endDate) {

        System.out.println("######## getUsageYearly parameter {meterId : " + meterId + "} {startDate : " + startDate + "} {endDate : " + endDate + "} ########");
        return usageService.getUsageYearly(meterId, startDate, endDate);
    }
}
