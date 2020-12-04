package com.nuri.etk.entity.pojo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChargeCancelInfo {

    @ApiModelProperty(value = "operatorId", example = "")
    private String operatorId;

    @ApiModelProperty(value = "chargeId", example = "")
    private String chargeId;

    @ApiModelProperty(value = "cancelReason", example = "")
    private String cancelReason;

    public ChargeCancelInfo(String operatorId, String chargeId, String cancelReason) {
        this.operatorId = operatorId;
        this.chargeId = chargeId;
        this.cancelReason = cancelReason;
    }

    @Override
    public String toString() {
        return "ChargeCancelInfo{" +
                "operatorId='" + operatorId + '\'' +
                ", chargeId='" + chargeId + '\'' +
                ", cancelReason='" + cancelReason + '\'' +
                '}';
    }
}
