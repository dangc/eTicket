package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.DebtLog;
import com.nuri.etk.entity.aimir.PrepaymentLog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 선불내역
 *  - 선불정보는 Contract 테이블에 갱신되며, 갱신될때마다 PrepaymentLog에 기록된다.
 *  
 */

@Getter
@Setter
@NoArgsConstructor
public class DebtLogJpo {

	private Long id;
	
	private PrepaymentLog prepaymentLog;
	
	private Long prepaymentLogId;
	
	private String customerId;
	
	private String debtType;
	
    private String debtRef;
	
	private Double preDebt;
	
	private Double debt;

	private Double chargedDebt;
	
	private String partpayInfo;

	public DebtLog toDomain(){
		DebtLog debtLog = new DebtLog();
		debtLog.setId(this.id);
		debtLog.setPrepaymentLogId(this.prepaymentLogId);
		debtLog.setCustomerId(this.customerId);
		debtLog.setDebtType(this.debtType);
		debtLog.setDebtRef(this.debtRef);
		debtLog.setPreDebt(this.preDebt);
		debtLog.setDebt(this.debt);
		debtLog.setChargedDebt(this.chargedDebt);
		debtLog.setPartpayInfo(this.partpayInfo);
		return debtLog;
	}
}
