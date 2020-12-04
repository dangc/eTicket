package com.nuri.etk.entity.pojo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChargeInfo {

    @ApiModelProperty(value = "utility", example = "")
    private String utility;

    @ApiModelProperty(value = "operatorId", example = "")
    private String operatorId;

    @ApiModelProperty(value = "chargeId", example = "")
    private String chargeId;

    @ApiModelProperty(value = "paidAmount", example = "")
    private String paidAmount;

    @ApiModelProperty(value = "chargedCredit", example = "")
    private String chargedCredit;

    @ApiModelProperty(value = "chargedArrears", example = "")
    private String chargedArrears;

    private List<ArrearsDebt> debt;

    public ChargeInfo(String utility, String operatorId, String chargeId, String paidAmount, String chargedCredit, String chargedArrears, List<ArrearsDebt> debt) {
        this.utility = utility;
        this.operatorId = operatorId;
        this.chargeId = chargeId;
        this.paidAmount = paidAmount;
        this.chargedCredit = chargedCredit;
        this.chargedArrears = chargedArrears;
        this.debt = debt;
    }

    @Override
    public String toString() {
        return "ChargeInfo{" +
                "utility='" + utility + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", chargeId='" + chargeId + '\'' +
                ", paidAmount='" + paidAmount + '\'' +
                ", chargedCredit='" + chargedCredit + '\'' +
                ", chargedArrears='" + chargedArrears + '\'' +
                ", debt=" + debt +
                '}';
    }
}
