package com.nuri.etk.entity.API;


import com.nuri.etk.entity.pojo.DebtInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Debt {

//    private String meterId;
    private Integer code;
    private Double arrears;
    private ArrayList<DebtInfo> dept;

    public Debt(Integer code, Double arrears, ArrayList<DebtInfo> dept) {
        this.code = code;
        this.arrears = arrears;
        this.dept = dept;
    }

    public static Debt getDebtInfo(String customerNo) {

        ArrayList<DebtInfo> debtList= new ArrayList<>();
        DebtInfo debtInfo1 = new DebtInfo("02002484720120150731", customerNo, "20190101", "ACTIVE", "CD001", 55.0);
        DebtInfo debtInfo2 = new DebtInfo("02002529390120150189", customerNo, "20190102", "ACTIVE", "CD001", 35.0);
        debtList.add(debtInfo1);
        debtList.add(debtInfo2);

        Debt debt = new Debt(200, 10.0, debtList);

        return debt;
    }
}
