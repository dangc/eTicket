package com.nuri.etk.entity.aimir;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * Energy Consumer(에너지 소비자)의 계약과 관련된 정보 변경 시 변경된 정보 타입 및 변경전, 변경 후 정보가 이력으로 기록된다.
 * Contract 클래스의 변경이력을 나타내는 모델 클래스이다.
 */
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}

	public String getChangeField() {
		return changeField;
	}

	public void setChangeField(String changeField) {
		this.changeField = changeField;
	}

	public String getBeforeValue() {
		return beforeValue;
	}

	public void setBeforeValue(String beforeValue) {
		this.beforeValue = beforeValue;
	}

	public String getAfterValue() {
		return afterValue;
	}

	public void setAfterValue(String afterValue) {
		this.afterValue = afterValue;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getWriteDatetime() {
		return writeDatetime;
	}

	public void setWriteDatetime(String writeDatetime) {
		this.writeDatetime = writeDatetime;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
