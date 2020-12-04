package com.nuri.etk.async.service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.nuri.etk.async.callback.CallBackData;
import com.nuri.etk.async.callback.CallBackResultData;
import com.nuri.etk.async.constants.DLMSConstants;
import com.nuri.etk.async.constants.StsConstants.API_SERVICE_POINT;
import com.nuri.etk.async.data.AbstractAsyncData;
import com.nuri.etk.async.data.CmdSendToken;
import com.nuri.etk.async.util.EtkUtil;
import com.nuri.etk.async.ws.client.FepCommandWS;
import com.nuri.etk.async.ws.client.FepCommandWS_Client;
import com.nuri.etk.async.ws.client.ResponseMap;
import com.nuri.etk.entity.aimir.APICallBackHistory;
import com.nuri.etk.store.ChargeStore;
import com.nuri.etk.util.DateTimeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import com.nuri.etk.async.constants.ETKConstants.ErrorType;
import com.google.gson.Gson;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmdSendTokenService extends AbstractService {
	private static Log log = LogFactory.getLog(CmdSendTokenService.class);

	public CmdSendTokenService(ChargeStore chargeStore) {
		super(chargeStore);
	}

	@Override
	public void execute(AbstractAsyncData message) throws Exception {
		CmdSendToken cmdSendToken = (CmdSendToken)message;
		
		String requestBody = null;
		String uuid = cmdSendToken.getUuid();

		APICallBackHistory apiCallBackHistory = new APICallBackHistory();
		
		if(cmdSendToken.isTimeout()) {
			log.info("tid [" + cmdSendToken.getChargeId()+"] Timeout");
			
			CallBackData callBackData = new CallBackData(ErrorType.etcError.getIntValue(), "TIMEOUT");
			
			requestBody = new Gson().toJson(callBackData);
			apiCallBackHistory.setRequestBody(requestBody);
			
			sendCallback(uuid, cmdSendToken.getCallbackURI(), cmdSendToken.getChargeId(), requestBody, apiCallBackHistory);
			return;
		}
			

		int classId = DLMSConstants.DLMS_CLASS.TOKEN_GATEWAY.getClazz();
		int attrId = DLMSConstants.DLMS_CLASS_ATTR.TOKEN_ATTR01.getAttr();
		String obisCode = EtkUtil.convertObis(DLMSConstants.OBIS.TOKEN_GATEWAY.getCode());
		String param = obisCode + "|" + classId + "|" + attrId + "|RW|octet-string|" + cmdSendToken.getToken();
		
		log.info("dcuId:" + cmdSendToken.getDcuId() +", meterId : "+cmdSendToken.getMeterId());
		FepCommandWS ws = FepCommandWS_Client.getCommandWS(getProtocolType(cmdSendToken.getDcuId(), cmdSendToken.getMeterId(), null));
		ResponseMap responseMap = ws.cmdSTSGeneralCommand(cmdSendToken.getModemId(), cmdSendToken.getMeterId(), cmdSendToken.getDlmsReqType().name(), param);
		
		Map<String, Object> map = new HashMap<String, Object>();
		for (ResponseMap.Response.Entry e : responseMap.getResponse().getEntry()) {
			map.put(e.getKey().toString(), e.getValue());
			log.debug("key[" + e.getKey().toString() + "] value[" + e.getValue() + "]");
		}
		
		try {
			CallBackData callBackData = null;
			Object resObj = map.get("RESULT_VALUE");
			if(resObj != null && "Success".equalsIgnoreCase(resObj.toString())) {
				callBackData = new CallBackData(ErrorType.Ok.getIntValue(), "Success");
			} else {
				Object resultValue = map.get("resultValue");
				if(resultValue != null)
					callBackData = new CallBackData(ErrorType.etcError.getIntValue(), resultValue.toString());
				else if(resObj != null) 
					callBackData = new CallBackData(ErrorType.etcError.getIntValue(), resObj.toString());
				else
					callBackData = new CallBackData(ErrorType.etcError.getIntValue(), "ERROR");
			}
			
			requestBody = new Gson().toJson(callBackData);
			apiCallBackHistory.setRequestBody(requestBody);
			
			sendCallback(uuid, cmdSendToken.getCallbackURI(), cmdSendToken.getChargeId(), requestBody, apiCallBackHistory);
			
			/////////////////////////////////////////////////
			//������ ���ۿ� ������ �̷��� ������ �������Ѵ�(������ ���� ����)
			
			List<APICallBackHistory> retryList = getrResentCallBackList(cmdSendToken.getCallbackURI());
			log.info("retryList : " + retryList.size());
			if(retryList != null && retryList.size() > 0) {
				log.info("retry callback  send length : "+retryList.size());
				for(APICallBackHistory history : retryList) {
					sendCallback(history.getUuid(), history.getCallBackURI(), history.getTid(), history.getRequestBody(), history);
				}
			}
			
		}catch(Exception e) {
			log.error(e,e);
		}		
	}
	
	public void sendCallback(String uuid, String uri, String tid, String content, APICallBackHistory apiCallBackHistory) throws Exception {
		try {
			if(uri != null && tid != null) {
				CallBackResultData cbResultData = actionCallback(uri, tid, content);
				
				if(cbResultData != null) {
					apiCallBackHistory.setCallBackURL(cbResultData.getUrl());
					apiCallBackHistory.setResponseStatus(cbResultData.getHttpStatus().value());
					apiCallBackHistory.setResponseBody(cbResultData.getBody());
				}
				
				update(uuid, apiCallBackHistory);
			} else {
				apiCallBackHistory.setDescr("callBackURL or TID Empty.");
				
				update(uuid, apiCallBackHistory);
			}
		}catch(UnknownHostException e) {
			apiCallBackHistory.setDescr("Exception : " + e.getMessage());
			update(uuid, apiCallBackHistory);
		}catch(Exception e) {
			apiCallBackHistory.setDescr("Exception : " + e.getMessage());
			update(uuid, apiCallBackHistory);
		}
	}
	
	public List<APICallBackHistory> getrResentCallBackList(String uri) {
		List<APICallBackHistory> resList = new ArrayList<APICallBackHistory>();
		TransactionStatus txStatus = null;
		try {
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("servicePoint", API_SERVICE_POINT.ETK);
			conditionMap.put("maxRetryCount", MAX_RETRY_COUNT);
			conditionMap.put("maxRetryHour", MAX_RETRY_HOUR);
			conditionMap.put("uri", uri);
			
//			List<APICallBackHistory> l = apiCallBackHistoryDao.getrResentCallBackList(conditionMap);
//			resList = l;
			
		}catch(Exception e) {
			log.error(e,e);
		}
		
		return resList;
	}

	public void update(String uuid, APICallBackHistory apiCallBackHistory) throws Exception {
		TransactionStatus txStatus = null;
		try {
			APICallBackHistory queryHistory = chargeStore.getAPICallBackHistory(uuid);
			
			if(queryHistory != null) {
				if(apiCallBackHistory.getResponseStatus() != null)
					queryHistory.setResponseStatus(apiCallBackHistory.getResponseStatus());
				
				if(apiCallBackHistory.getRequestBody() != null)
					queryHistory.setRequestBody(apiCallBackHistory.getRequestBody());
				
				if(apiCallBackHistory.getDescr() != null)
					queryHistory.setDescr(apiCallBackHistory.getDescr());				
				
				if(apiCallBackHistory.getCallBackURL()!= null)
					queryHistory.setCallBackURL(apiCallBackHistory.getCallBackURL());
				
				queryHistory.setUpdatDate(DateTimeUtil.getDateString(new Date()));
				
				if(apiCallBackHistory.getResponseStatus() == 200) {
					queryHistory.setCallBackCnt(queryHistory.getCallBackCnt() + 1);
				}
				
//				apiCallBackHistoryDao.update(queryHistory);
			}
			
		}catch(Exception e) {
			log.error(e,e);
		}
	}
	
	@Override
	public void update(AbstractAsyncData data) throws Exception {
		
	}
}

