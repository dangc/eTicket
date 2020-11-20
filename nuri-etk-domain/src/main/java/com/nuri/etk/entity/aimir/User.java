/**
 * OperatorContract.java Copyright NuriTelecom Limited 2011
 */
package com.nuri.etk.entity.aimir;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Operator.java Description 
 * 시스템 로그인을 위한 사용자 정보 
 */

@Getter
@Setter
@NoArgsConstructor
public abstract class User {

    protected Integer id; //  ID(PK)
	
	protected Role role;	//group id(role)
	
	protected Integer roleId;
	
	protected String loginId;	//loginId
	protected String password;	//OPERATOR PASSWORD
	
	protected String name;	// name
	protected String aliasName;	// alias
	
	protected String email;	// email
	protected String telNo;	// telNo
	
	protected Supplier supplier;	// supplierId
	
	protected Integer supplierId;
	
	protected String lastPasswordChangeTime;	// lastPasswordChangeTime
	
	protected String lastPasswordChangeTimeLocale;	// lastPasswordChangeTime by Locale
	
	protected String lastLoginTime;		// lastLoginTime
	
	protected Boolean loginDenied;		// isDenied
	protected String deniedReason;		// deniedReason
	protected Integer failedLoginCount;	// failedLoginCount
	protected String locale;				// User's locale information
	
	protected Boolean showDefaultDashboard;

	protected String pucNumber;

    protected Integer operatorStatus;

    protected String zipCode;

    protected String address1;

    protected String address2;

    protected String mobileNumber;

	protected Integer smsYn;

	protected Integer emailYn;

	protected String writeDate;
	
	protected String lastChargeDate;

	protected String updateDate;

    protected Boolean useLocation;

	protected Location location;

    protected Integer locationId;
	
	private Boolean isFirstLogin;
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getPucNumber() {
		return pucNumber;
	}

	public void setPucNumber(String pucNumber) {
		this.pucNumber = pucNumber;
	}

	public Integer getOperatorStatus() {
		return operatorStatus;
	}

	public void setOperatorStatus(Integer operatorStatus) {
		this.operatorStatus = operatorStatus;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getSmsYn() {
		return smsYn;
	}

	public void setSmsYn(Integer smsYn) {
		this.smsYn = smsYn;
	}

	public Integer getEmailYn() {
		return emailYn;
	}

	public void setEmailYn(Integer emailYn) {
		this.emailYn = emailYn;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getLastChargeDate() {
		return lastChargeDate;
	}

	public void setLastChargeDate(String lastChargeDate) {
		this.lastChargeDate = lastChargeDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getShowDefaultDashboard() {
		return showDefaultDashboard;
	}
	public void setShowDefaultDashboard(Boolean showDefaultDashboard) {
		this.showDefaultDashboard = showDefaultDashboard;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public String getLastPasswordChangeTime() {
		return lastPasswordChangeTime;
	}
	public void setLastPasswordChangeTime(String lastPasswordChangeTime) {
		this.lastPasswordChangeTime = lastPasswordChangeTime;
	}

	public String getLastPasswordChangeTimeLocale() {
		return lastPasswordChangeTimeLocale;
	}
	public void setLastPasswordChangeTimeLocale(String lastPasswordChangeTimeLocale) {
		this.lastPasswordChangeTimeLocale = lastPasswordChangeTimeLocale;
	}
	
	public Boolean getLoginDenied() {
		return loginDenied;
	}
	
	public void setLoginDenied(Boolean loginDenied) {
		this.loginDenied = loginDenied;
	}
	
	public String getDeniedReason() {
		return deniedReason;
	}
	public void setDeniedReason(String deniedReason) {
		this.deniedReason = deniedReason;
	}
	
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	public Integer getFailedLoginCount() {
		return failedLoginCount;
	}
	public void setFailedLoginCount(Integer failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Boolean getUseLocation() {
        return useLocation;
    }

    public void setUseLocation(Boolean useLocation) {
        this.useLocation = useLocation;
    }

    public Boolean getIsFirstLogin() {
		return isFirstLogin;
	}

	public void setIsFirstLogin(Boolean isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}
}
	
