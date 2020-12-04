package com.nuri.etk.async.data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nuri.etk.async.constants.StsConstants.DLMS_REQUEST_TYPE;
import com.nuri.etk.util.DateTimeUtil;

public abstract class AbstractAsyncData implements Serializable {
	private static Log log = LogFactory.getLog(AbstractAsyncData.class);
	
	private static final long serialVersionUID = -4304572178499044255L;
	
	private String uuid;
	
	private DLMS_REQUEST_TYPE dlmsReqType;
	
	private String dcuId; 	//mcu - sysId
	private String modemId; //modem - deviceSerial
	private String meterId;	//meter - mds_id
	
	private String receiveTime;
	private int amount = 0; //minute
	
	private String callbackURI;
	
	public AbstractAsyncData( ) {
		receiveTime = DateTimeUtil.getDateString(new Date());
	}
	
	public String getDcuId() {
		return dcuId;
	}

	public void setDcuId(String dcuId) {
		this.dcuId = dcuId;
	}

	public String getModemId() {
		return modemId;
	}

	public void setModemId(String modemId) {
		this.modemId = modemId;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCallbackURI() {
		return callbackURI;
	}

	public void setCallbackURI(String callbackURI) {
		this.callbackURI = callbackURI;
	}
	
	public DLMS_REQUEST_TYPE getDlmsReqType() {
		return dlmsReqType;
	}

	public void setDlmsReqType(DLMS_REQUEST_TYPE dlmsReqType) {
		this.dlmsReqType = dlmsReqType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return 
	 * false : expired time
	 * true : non expired time
	 * 
	 */
	public boolean isTimeout() {
		try {
			if(amount == 0)
				return false;
			
			if(receiveTime != null) {
				Date now = new Date();
				Date limitTime = DateTimeUtil.getDateFromYYYYMMDDHHMMSS(receiveTime);
				
				Calendar c = Calendar.getInstance();
				c.setTime(limitTime);
				c.add(Calendar.MINUTE, amount);
				limitTime = c.getTime();
				
				if(now.before(limitTime))
					return false;
				else
					return true;
			}
		}catch(Exception e) {
			log.error(e, e);
		}
		
		return true;
	}
}

