package com.nuri.etk.entity.pojo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Override
    public String toString() {
        return "ArrearsDebt{" +
                "debtType='" + debtType + '\'' +
                ", debtRef='" + debtRef + '\'' +
                ", paidDebtAmount=" + paidDebtAmount +
                '}';
    }
}
