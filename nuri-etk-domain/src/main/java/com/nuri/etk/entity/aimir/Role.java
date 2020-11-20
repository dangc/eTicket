package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * 사용자 그룹 정보
 * 사용자 롤 그룹 
 */

@Getter
@Setter
@NoArgsConstructor
public class Role {
	
	private Integer id;	//	ID(PK)

	private String name;	// name
	
	private Supplier supplier;	// supplier
	
	private Integer supplierId;
	
	private Set<Operator> operators = new HashSet<Operator>(0);
	
	private String descr;	// description
	private Boolean loginAuthority;	// possibility for login
	private String mtrAuthority;	// Authority for reading or writing the metering data
	private String systemAuthority;	// Authority for reading or writing or command the systemInfo
	private String dlmsAuthority;	// Authority for reading or writing dlms for obisCommand.

	private Set<Code> commands = new HashSet<Code>();	// executable command list
	
	private Boolean hasDashboardAuth;	// authority for dashboard
	private Boolean customerRole;	// 
	
	private Integer maxMeters;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Set<Operator> getOperators() {
		return operators;
	}

	public void setOperators(Set<Operator> operators) {
		this.operators = operators;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Boolean getLoginAuthority() {
		return loginAuthority;
	}

	public void setLoginAuthority(Boolean loginAuthority) {
		this.loginAuthority = loginAuthority;
	}

	public String getMtrAuthority() {
		return mtrAuthority;
	}

	public void setMtrAuthority(String mtrAuthority) {
		this.mtrAuthority = mtrAuthority;
	}

	public String getSystemAuthority() {
		return systemAuthority;
	}

	public void setSystemAuthority(String systemAuthority) {
		this.systemAuthority = systemAuthority;
	}

	public String getDlmsAuthority() {
		return dlmsAuthority;
	}

	public void setDlmsAuthority(String dlmsAuthority) {
		this.dlmsAuthority = dlmsAuthority;
	}

	public Set<Code> getCommands() {
		return commands;
	}

	public void setCommands(Set<Code> commands) {
		this.commands = commands;
	}
	
	public void addCommand(Code command) {
		if (command == null)
			throw new IllegalArgumentException("command is null");
		
		if(commands == null)
			commands = new HashSet<Code>();

		this.commands.add(command);
	}
	
	public Boolean getHasDashboardAuth() {
		return hasDashboardAuth;
	}

	public void setHasDashboardAuth(Boolean hasDashboardAuth) {
		this.hasDashboardAuth = hasDashboardAuth;
	}

	public Boolean getCustomerRole() {
		return customerRole;
	}

	public void setCustomerRole(Boolean customerRole) {
		this.customerRole = customerRole;
	}

	public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getMaxMeters() {
		return maxMeters;
	}

	public void setMaxMeters(Integer maxMeter) {
		this.maxMeters = maxMeter;
	}
}
	