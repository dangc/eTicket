package com.nuri.etk.entity.API;


import com.nuri.etk.exception.MissingRequiredDataException;
import com.nuri.etk.entity.pojo.ErrorCode;
import com.nuri.etk.entity.pojo.MonthlyUsages;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class UsageYearly {

    private Integer code;
    private String meterId;
    private ArrayList<MonthlyUsages> monthlyUsages;

    public UsageYearly(Integer code, String meterId, ArrayList<MonthlyUsages> monthlyUsages) {
        this.code = code;
        this.meterId = meterId;
        this.monthlyUsages = monthlyUsages;
    }

    public static UsageYearly getUsageYearly(String meterId, String startDate, String endDate){
        UsageYearly yearly = new UsageYearly();

        try {
            // 날짜 validation - date null값 체크
            if(startDate.isEmpty() && endDate.isEmpty()){
                throw new MissingRequiredDataException();
            }
            // 날짜 validation - startDate가 endDate보다 큰경우
            if(Integer.parseInt(startDate) > Integer.parseInt(endDate)){
                throw new MissingRequiredDataException();
            }

            Random random = new Random();
            ArrayList<MonthlyUsages> yearlyUsagesArrayList = new ArrayList<>();
            int start = Integer.parseInt(startDate);
            int end = Integer.parseInt(endDate);

            for(int i= start; start <= end; start++){
                yearlyUsagesArrayList.add(new MonthlyUsages(Integer.toString(start), Integer.toString(random.nextInt(30)), "kWh", (double)random.nextInt(50) , "GHC"));
            }
            yearly = new UsageYearly(200, meterId, yearlyUsagesArrayList);

        }catch (MissingRequiredDataException e){
            yearly = new UsageYearly(330, meterId, new ArrayList<>());
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(yearly.getCode()) + " ########");
            e.printStackTrace();
        }catch (Exception e){
            yearly = new UsageYearly(500, meterId, new ArrayList<>());
            System.out.println("######## ErrorCode Message : " + ErrorCode.getMessage(yearly.getCode()) + " ########");
            e.printStackTrace();
        }finally {
            return yearly;
        }
    }
}
