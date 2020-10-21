package com.nuri.etk.entity.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MonthlyUsages {

    private String responseDateTime;
    private String usage;
    private String usageUnit;
    private Double credit;
    private String creditUnit;

    public MonthlyUsages(String responseDateTime, String usage, String usageUnit, Double credit, String creditUnit) {
        this.responseDateTime = responseDateTime;
        this.usage = usage;
        this.usageUnit = usageUnit;
        this.credit = credit;
        this.creditUnit = creditUnit;
    }

    @Override
    public String toString() {
        return "monthlyUsages{" +
                "responseDateTime='" + responseDateTime + '\'' +
                ", usage='" + usage + '\'' +
                ", usageUnit='" + usageUnit + '\'' +
                ", credit=" + credit +
                ", creditUnit='" + creditUnit + '\'' +
                '}';
    }
}
