package com.nuri.etk.entity.pojo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ArrearsDebt {

    @ApiModelProperty(value = "debtType", example = "")
    private String debtType;

    @ApiModelProperty(value = "debtRef", example = "")
    private String debtRef;

    @ApiModelProperty(value = "paidDebtAmount", example = "")
    private Double paidDebtAmount;

    public ArrearsDebt(String debtType, String debtRef, Double paidDebtAmount) {
        this.debtType = debtType;
        this.debtRef = debtRef;
        this.paidDebtAmount = paidDebtAmount;
    }

    public ArrearsDebt(Map<String, Object> stringObjectMap) {
        this.debtType = stringObjectMap.get("debtType").toString();
        this.debtRef = stringObjectMap.get("debtType").toString();
        this.paidDebtAmount = (Double) stringObjectMap.get("debtType");
    }

    @Override
    public String toString() {
        return "ArrearsDebt{" +
                "debtType='" + debtType + '\'' +
                ", debtRef='" + debtRef + '\'' +
                ", paidDebtAmount=" + paidDebtAmount +
                '}';
    }
}
