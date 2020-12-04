package com.nuri.etk.async.service;

import java.net.URI;
import java.net.URLEncoder;

import javax.annotation.Resource;

import com.nuri.etk.async.callback.CallBackResultData;
import com.nuri.etk.async.data.AbstractAsyncData;
import com.nuri.etk.store.ChargeStore;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.nuri.etk.entity.aimir.CommonConstants.Protocol;
import com.nuri.etk.entity.aimir.MCU;
import com.nuri.etk.entity.aimir.Meter;
import com.nuri.etk.entity.aimir.Modem;

@Service
public abstract class AbstractService {
	private Log log = LogFactory.getLog(AbstractService.class);

    protected final ChargeStore chargeStore;

    protected final int MAX_RETRY_COUNT = 5;
    protected final int MAX_RETRY_HOUR = 24;

    public AbstractService(ChargeStore chargeStore) {
        this.chargeStore = chargeStore;
    }

    protected String getProtocolType(String mcuId, String meterId, String modemId) {
        try {
            MCU mcu = null;
            if (mcuId != null && !"".equals(mcuId))
                mcu = chargeStore.getMCU(mcuId);
            
            if (mcu != null)
                return mcu.getProtocolType().getName();

            Meter meter = null;
            if (meterId != null && !"".equals(meterId)) {
                meter = chargeStore.getMeter(meterId);
                if (meter != null && meter.getModem() != null)
                    return meter.getModem().getProtocolType().name();
            }

            Modem modem = null;
            if (modemId != null && !"".equals(modem)) {
                modem = meter.getModem();
                
                if (modem != null)
                    return modem.getProtocolType().name();
            }
        }catch(Exception e) {
        	log.error(e,e);
        }finally {

        }

        return Protocol.LAN.name();
    }
    
    public CallBackResultData actionCallback(String baseUri, String tid, String requestJson) throws Exception {
    	CallBackResultData cbResultData = null;
    	URI url = null;
    	
    	try {
    		String encodingTId = URLEncoder.encode(tid, "UTF-8");
    		url = URI.create(baseUri + "/" + encodingTId);
    		RestTemplate template = new RestTemplate();
    		log.debug("url : " +url.toString()+", requestJson : "+requestJson);
    		
    		HttpHeaders headers = new HttpHeaders();
    		headers.setContentType(MediaType.APPLICATION_JSON);
    		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
    		
    		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.PUT, entity, String.class);
    		log.info("url : " +url.toString()+", requestJson : "+requestJson+", callback response : "+responseEntity);
    		
    		cbResultData = new CallBackResultData(url.toString(), responseEntity.getStatusCode(), responseEntity.getBody());
    	}catch(HttpClientErrorException ex) {
    		cbResultData = new CallBackResultData(url.toString(), ex.getStatusCode(), ex.getResponseBodyAsString());
    	} catch(Exception e) {
    		log.error(e,e);
    		throw e;
    	}
    	
    	return cbResultData;
    }
    
    public abstract void update(AbstractAsyncData data) throws Exception;
    
	public abstract void execute(AbstractAsyncData message) throws Exception;
}
