package com.nuri.etk;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.ChargeLastHistory;
import com.nuri.etk.facade.flow.ChargeHistoryFlowFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@RestController
@CrossOrigin("*")
@Api(description = "충전 이력 정보 Resource")
@RequestMapping("/v2.0")
public class etkChargeHistoryMockResource implements ChargeHistoryFlowFacade {

    @Override
    @ApiOperation(value = "마지막 충전 이력", notes = "마지막 충전 이력 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/charge/last"})
    public ChargeLastHistory chargeLast(@PathVariable String meterId) {
        System.out.println("######## chargeLast parameter {meterId} : " + meterId + " ########");
        return ChargeLastHistory.chargeLast(meterId);
    }

    @Override
    @ApiOperation(value = "모든 충전 이력 조회", notes = "모든 충전 이력 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = ""),
            @ApiImplicitParam(name = "startDate", value = "조회 시작일자(yyyyMM)", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "endDate", value = "조회 종료일자(yyyyMM)", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "paymentType", value = "지불수단(All, Elmo, Cash, Mobile Money, Credit Card)", required = false, dataType = "string", paramType = "query", defaultValue = "All"),
            @ApiImplicitParam(name = "listCount", value = "페이징처리 - 한 페이지 개수", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "pageCount", value = "페이징처리 - 페이지 번호", required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/charge/history"})
    public ChargeHistory chargeHistory(@PathVariable String meterId,
                                       @RequestParam(value="startDate", required=true) String startDate,
                                       @RequestParam(value="endDate", required=true) String endDate,
                                       @RequestParam(value="paymentType", required=false, defaultValue = "All") String paymentType,
                                       @RequestParam(value="listCount", required=true) String listCount,
                                       @RequestParam(value="pageCount", required=true) String pageCount) throws Exception {

        System.out.println("######## chargeHistory parameter {meterId : " + meterId + "} {startDate : " + startDate + "} {endDate : " + endDate + "} {paymentType : "+ paymentType +"} {listCount : "+ listCount +"} {pageCount : "+ pageCount +"} ########");

        // 쿼리 스트링 파싱 startDate, endDate
        SimpleDateFormat format = new SimpleDateFormat( "YYYYMM");

        // startDate, endDate 데이터 검증

        return ChargeHistory.chargeHistory(meterId, startDate, endDate, paymentType, listCount, pageCount);
    }
}
