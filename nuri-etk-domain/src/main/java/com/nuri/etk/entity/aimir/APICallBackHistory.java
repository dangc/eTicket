package com.nuri.etk.entity.aimir;

import com.nuri.etk.entity.aimir.CommonConstants.HTTP_METHOD;
import com.nuri.etk.async.constants.StsConstants.API_SERVICE_POINT;

/**
 * 웹서비스로 인터페이스 즉 웹서비스를 통해 상호간 데이터를 전달하는 경우 해당 이력 정보를 가지고 있는 클래스
 * 
 * @since 2020.03.25
 * @author Han seung woo
 * @implNote https://jira.nuritelecom.com/browse/NGM-409
 *
 */

public class APICallBackHistory {
	private String uuid;

	private String mdevId;
	
	private String yyyymmdd;
	
	private String yyyymmddhh;
	
	private String operatorId;
		
	private String url;
	
	private HTTP_METHOD method;
	
	private String tid;
	
	private String sourceIP;
	
	private String callBackURI;
	
	private String callBackURL;
	
	private Integer callBackCnt;
	
	private String requestBody;
	
	private Integer responseStatus;
	
	private String responseBody;
	
	private String writeDate;
	
	private String updatDate;
	
	private API_SERVICE_POINT servicePoint;

	private Long prepaymentLogId;

	private String descr;
	
	private String column01;
		
	private String column02;
	
	private String column03;
	
	private String column04;
	
	private String column05;
	
	private String column06;
	
	private String column07;
	
	private String column08;
	
	private String column09;
	
	private String column10;
	
	
	/*
	 * 이걸 수행하려고 했지만 prepaymetn보다 webservice의 insert 타이밍이 빠르기 때문에 insert 발생시 오류가 발생한다.
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="prepaymentlog_fk")	
	private PrepaymentLog prepaymentLog;
	*/

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getMdevId() {
		return mdevId;
	}

	public void setMdevId(String mdevId) {
		this.mdevId = mdevId;
	}
	
	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getYyyymmdd() {
		return yyyymmdd;
	}

	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}

	public String getYyyymmddhh() {
		return yyyymmddhh;
	}

	public void setYyyymmddhh(String yyyymmddhh) {
		this.yyyymmddhh = yyyymmddhh;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HTTP_METHOD getMethod() {
		return method;
	}

	public void setMethod(HTTP_METHOD method) {
		this.method = method;
	}
	
	public void setMethod(String method) {
		this.method = HTTP_METHOD.valueOf(method);
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getSourceIP() {
		return sourceIP;
	}

	public void setSourceIP(String sourceIP) {
		this.sourceIP = sourceIP;
	}

	public String getCallBackURI() {
		return callBackURI;
	}

	public void setCallBackURI(String callBackURI) {
		this.callBackURI = callBackURI;
	}

	public String getCallBackURL() {
		return callBackURL;
	}

	public void setCallBackURL(String callBackURL) {
		this.callBackURL = callBackURL;
	}

	public Integer getCallBackCnt() {
		return callBackCnt;
	}

	public void setCallBackCnt(Integer callBackCnt) {
		this.callBackCnt = callBackCnt;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getUpdatDate() {
		return updatDate;
	}

	public void setUpdatDate(String updatDate) {
		this.updatDate = updatDate;
	}

	public API_SERVICE_POINT getServicePoint() {
		return servicePoint;
	}

	public void setServicePoint(API_SERVICE_POINT servicePoint) {
		this.servicePoint = servicePoint;
	}
	
	public Long getPrepaymentLogId() {
		return prepaymentLogId;
	}

	public void setPrepaymentLogId(Long prepaymentLogId) {
		this.prepaymentLogId = prepaymentLogId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getColumn01() {
		return column01;
	}

	public void setColumn01(String column01) {
		this.column01 = column01;
	}

	public String getColumn02() {
		return column02;
	}

	public void setColumn02(String column02) {
		this.column02 = column02;
	}

	public String getColumn03() {
		return column03;
	}

	public void setColumn03(String column03) {
		this.column03 = column03;
	}

	public String getColumn04() {
		return column04;
	}

	public void setColumn04(String column04) {
		this.column04 = column04;
	}

	public String getColumn05() {
		return column05;
	}

	public void setColumn05(String column05) {
		this.column05 = column05;
	}

	public String getColumn06() {
		return column06;
	}

	public void setColumn06(String column06) {
		this.column06 = column06;
	}

	public String getColumn07() {
		return column07;
	}

	public void setColumn07(String column07) {
		this.column07 = column07;
	}

	public String getColumn08() {
		return column08;
	}

	public void setColumn08(String column08) {
		this.column08 = column08;
	}

	public String getColumn09() {
		return column09;
	}

	public void setColumn09(String column09) {
		this.column09 = column09;
	}

	public String getColumn10() {
		return column10;
	}

	public void setColumn10(String column10) {
		this.column10 = column10;
	}
}
