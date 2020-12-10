package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * Energy Consumer(에너지 소비자)의 계약과 관련된 정보 변경 시 변경된 정보 타입 및 변경전, 변경 후 정보가 이력으로 기록된다.
 * Contract 클래스의 변경이력을 나타내는 모델 클래스이다.
 */

@Getter
@Setter
@NoArgsConstructor
public class ContractChangeLog {

	private Long id;
	
	private Customer customer;
	
	private Integer customerId;
	
	private Contract contract;
	
	private Integer contractId;
	
	private String startDatetime;
	
	private String changeField;
	private String beforeValue;
	private String afterValue;
	
	private Operator operator;
	
	private Integer operatorId;
	
	private String writeDatetime;
	private String descr;
}
