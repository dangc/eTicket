package com.nuri.etk.async.queue;

import com.nuri.etk.async.data.AbstractAsyncData;
import com.nuri.etk.async.util.ETKProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AsyncQueueHandler {
	private static Log log = LogFactory.getLog(AsyncQueueHandler.class);
	
	public static String SERVICE_ETK_SEND_TOKEN = ETKProperty.getProperty("ServiceData.etk.send.token");

    @Autowired
    private EtkKafkaProducer producer;
    
    private KafkaTemplate<Integer, AbstractAsyncData> toKafka = null;

    @SuppressWarnings("unchecked")
	public void putServiceData(String serviceType, final AbstractAsyncData data) throws Exception {
        if (toKafka == null) {
            KafkaProducerMessageHandler<Integer, AbstractAsyncData> handler =
                    (KafkaProducerMessageHandler<Integer, AbstractAsyncData>)producer.handler();
            toKafka = (KafkaTemplate<Integer, AbstractAsyncData>)handler.getKafkaTemplate();
        }

        log.debug("Put Data to KafkaQueue ==> [" + serviceType + "][" + data.toString() + "]");
        log.debug("broker list : "+producer.brokerAddress);
    		
        toKafka.send(serviceType, data);

    }
}
