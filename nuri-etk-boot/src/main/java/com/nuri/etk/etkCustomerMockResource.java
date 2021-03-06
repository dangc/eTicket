package com.nuri.etk;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.MeterSerial;
import com.nuri.etk.facade.flow.CustomerFlowFacade;
import com.nuri.etk.spec.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Api(description = "고객 정보 Resource")
@RequestMapping("/v2.0")
public class etkCustomerMockResource implements CustomerFlowFacade {
    private CustomerService customerService;

    public etkCustomerMockResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @ApiOperation(value = "고객 조회", notes = "고객 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerNo", value = "고객 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/customers/{customerNo}"})
    public ChargeHistory.Customer getCustomerByNo(@PathVariable String customerNo) {
        System.out.println("######## getCustomerByNo parameter {customerNo} : " + customerNo + " ########");
//        return Customer.getCustomerByNo(customerNo);
        return customerService.getCustomerByNo(customerNo);
    }

    @Override
    @ApiOperation(value = "고객 미터 시리얼 번호 조회", notes = "고객 미터 시리얼 정보 요청 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerNo", value = "고객 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(value={"/customers/{customerNo}/meters"})
    public MeterSerial getCustomerByMeter(@PathVariable String customerNo) {
        System.out.println("######## getCustomerByMeter parameter {customerNo} : " + customerNo + " ########");
        return customerService.getCustomerByMeter(customerNo);
    }
}
