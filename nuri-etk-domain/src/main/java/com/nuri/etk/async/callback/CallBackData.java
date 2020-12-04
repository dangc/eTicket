package com.nuri.etk.async.callback;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CallBackData implements Serializable {

	private static final long serialVersionUID = -492128382491108027L;

	private int code;
	private String resultDetail;
	
	public CallBackData(int code, String resultDetail) {
		this.code = code;
		this.resultDetail = resultDetail;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResultDetail() {
		return resultDetail;
	}
	public void setResultDetail(String resultDetail) {
		this.resultDetail = resultDetail;
	}
}
