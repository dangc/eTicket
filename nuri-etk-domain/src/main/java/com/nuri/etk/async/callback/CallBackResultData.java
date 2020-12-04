package com.nuri.etk.async.callback;

import org.springframework.http.HttpStatus;

/**
 * @author Han seung woo
 *
 */
public class CallBackResultData {
	private String url;
	private HttpStatus httpStatus;
	private String body;
	
	public CallBackResultData() {}
	public CallBackResultData(String url, HttpStatus httpStatus, String body) {
		this.url = url;
		this.httpStatus = httpStatus;
		this.body = body;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
