package com.nuri.etk;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.ChargeLastHistory;
import com.nuri.etk.facade.flow.ChargeHistoryFlowFacade;
import com.nuri.etk.spec.ChargeHistoryService;
import com.nuri.etk.spec.ReceiptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@RestController
@CrossOrigin("*")
@Api(description = "충전 이력 정보 Resource")
@RequestMapping("/v2.0")
public class etkChargeHistoryMockResource implements ChargeHistoryFlowFacade {
    private ChargeHistoryService chargeHistoryService;

    public etkChargeHistoryMockResource(ChargeHistoryService chargeHistoryService) {
        this.chargeHistoryService = chargeHistoryService;
    }

    @Override
    @ApiOperation(value = "마지막 충전 이력", notes = "마지막 충전 이력 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/charge/last"})
    public ChargeLastHistory chargeLast(@PathVariable String meterId) {
        System.out.println("######## chargeLast parameter {meterId} : " + meterId + " ########");
        return chargeHistoryService.chargeLast(meterId);
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
                                       @RequestHeader HttpHeaders headers
                                       /*@RequestParam(value="startDate", required=true) String startDate,
                                       @RequestParam(value="endDate", required=true) String endDate,
                                       @RequestParam(value="paymentType", required=false, defaultValue = "All") String paymentType,
                                       @RequestParam(value="listCount", required=true) String listCount,
                                       @RequestParam(value="pageCount", required=true) String pageCount*/) throws Exception {


        // 쿼리 스트링 파싱
        SimpleDateFormat format = new SimpleDateFormat( "YYYYMM");
        String startDate = headers.get("startDate").get(0);
        String endDate = headers.get("endDate").get(0);
        String paymentType = headers.get("paymentType").get(0);
        String listCount = headers.get("listCount").get(0);
        String pageCount = headers.get("pageCount").get(0);

        System.out.println("######## chargeHistory parameter {meterId : " + meterId + "} {startDate : " + startDate + "} {endDate : " + endDate + "} {paymentType : "+ paymentType +"} {listCount : "+ listCount +"} {pageCount : "+ pageCount +"} ########");
        return chargeHistoryService.chargeHistory(meterId, startDate, endDate, paymentType, listCount, pageCount);
    }
}
