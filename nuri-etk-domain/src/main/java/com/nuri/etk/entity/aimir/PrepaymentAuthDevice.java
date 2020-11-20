/**
 * OperatorContract.java Copyright NuriTelecom Limited 2011
 */
package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * PrepaymentAuthDevice.java Description 
 *
 * 
 * Date          Version    Author   Description
 * 2011. 8. 9.   v1.0       eunmiae  선불고객의 Emergency Credit Mode전환 인증 디바이스 정보 관리       
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class PrepaymentAuthDevice {

	private Integer id;	//	ID(PK)
	
    private Contract contract;
	
	private Integer contractId;

	private String authKey;	// business key
	
	private String friendlyName;
	
	private String writeDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}
