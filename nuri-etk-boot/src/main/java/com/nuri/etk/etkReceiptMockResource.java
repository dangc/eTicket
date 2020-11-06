package com.nuri.etk;

import com.nuri.etk.entity.API.Receipt;
import com.nuri.etk.facade.flow.ReceiptFlowFacade;
import com.nuri.etk.spec.ReceiptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Api(description = "영수증 정보 Resource")
@RequestMapping("/v2.0")
public class etkReceiptMockResource implements ReceiptFlowFacade {
    private ReceiptService receiptService;

    public etkReceiptMockResource(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @Override
    @ApiOperation(value = "영수증 정보 조회", notes = "영수증 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterId", value = "미터 시리얼 번호", required = true, dataType = "string", paramType = "path", defaultValue = ""),
            @ApiImplicitParam(name = "chargeId", value = "EMS Transaction ID", required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @GetMapping(value={"/meters/{meterId}/receipt"})
    public Receipt getReceiptInfo(@PathVariable String meterId, @RequestParam(value="chargeId", required=false) String chargeId) {
        System.out.println("######## getReceiptInfo parameter {meterId : " + meterId + "} {chargeId : " + chargeId + "} ########");
        return receiptService.getReceiptInfo(meterId, chargeId);
    }
}
