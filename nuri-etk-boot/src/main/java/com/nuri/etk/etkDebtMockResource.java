package com.nuri.etk;

import com.nuri.etk.entity.API.Debt;
import com.nuri.etk.facade.flow.DebtFlowFacade;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Api(description = "미수금 정보 Resource")
@RequestMapping("/v2.0")
public class etkDebtMockResource implements DebtFlowFacade {

    @Override
    @ApiOperation(value = "미수금 상세 조회", notes = "미수금 상세 정보 요청 API")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerNo", value = "고객 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/customers/{customerNo}/dept"})
    public Debt getDebtInfo(@PathVariable String customerNo) {
        System.out.println("######## getDebtInfo parameter {customerNo} : " + customerNo + " ########");
        return Debt.getDebtInfo(customerNo);
    }
}
