package com.nuri.etk.entity.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DailyUsages {

    private String date;
    private String usage;
    private String usageUnit;
    private Double credit;
    private String creditUnit;

    public DailyUsages(String date, String usage, String usageUnit, Double credit, String creditUnit) {
        this.date = date;
        this.usage = usage;
        this.usageUnit = usageUnit;
        this.credit = credit;
        this.creditUnit = creditUnit;
    }

    @Override
    public String toString() {
        return "dailyUsages{" +
                "date='" + date + '\'' +
                ", usage='" + usage + '\'' +
                ", usageUnit='" + usageUnit + '\'' +
                ", credit=" + credit +
                ", creditUnit='" + creditUnit + '\'' +
                '}';
    }
}
