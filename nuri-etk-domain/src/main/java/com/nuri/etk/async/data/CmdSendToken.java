package com.nuri.etk.async.data;

import java.io.Serializable;

import com.nuri.etk.async.constants.ETKConstants.ChargeType;
import com.google.gson.Gson;

public class CmdSendToken extends AbstractAsyncData implements Serializable {
	private static final long serialVersionUID = 5996937400528002459L;
	
	private ChargeType chargeType;
	private String token;
	private String chargeId;	
	
	public CmdSendToken() { }
	
	public ChargeType getChargeType() {
		return chargeType;
	}

	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

}
