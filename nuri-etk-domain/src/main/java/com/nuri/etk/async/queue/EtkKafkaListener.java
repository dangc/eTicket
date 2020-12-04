package com.nuri.etk.async.queue;

import java.util.HashMap;
import java.util.Map;

import com.nuri.etk.async.data.AbstractAsyncData;
import com.nuri.etk.async.data.CmdSendToken;
import com.nuri.etk.async.service.CmdSendTokenService;
import com.nuri.etk.async.util.DataUtil;
import com.nuri.etk.async.util.ETKProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

public class EtkKafkaListener {
	private static Log log = LogFactory.getLog(EtkKafkaListener.class);
	
	public EtkKafkaListener() {
		boolean kafkaEnable = Boolean.parseBoolean(ETKProperty.getProperty("kafka.enable"));
		if(kafkaEnable) {
			new KafkaListenerThread(AsyncQueueHandler.SERVICE_ETK_SEND_TOKEN).start();
		}
	}
	
	class KafkaListenerThread extends Thread {
		private String topicName;
	        
        KafkaListenerThread(String topicName) {
            this.topicName = topicName;
        }

		@Override
		public void run() {
			MessageListenerContainer jcontainer = messageListenerContainer(topicName);
            jcontainer.setupMessageListener(new MessageListener<Integer, String>() {

                @Override
                public void onMessage(ConsumerRecord<Integer, String> record) {
                	String value = record.value();
                	StringJsonMessageConverter converter = new StringJsonMessageConverter();
                	
                	AbstractAsyncData msg = null;
                	if(value.contains("CmdSendToken")) {
                		msg = (CmdSendToken)converter.toMessage(record, null, null, CmdSendToken.class).getPayload();
                	}
                	
                	if(msg != null) {
                		try {
                			if(msg instanceof CmdSendToken) {
                    			CmdSendTokenService tService = DataUtil.getBean(CmdSendTokenService.class);
                    			tService.execute(msg);
                    		}	
                		}catch(Exception e) {
                			log.error(e,e);
                		}
                	}
                }
            });
            jcontainer.start();
		} 
	}
	
	public MessageListenerContainer messageListenerContainer(String groupName) {
		ConcurrentMessageListenerContainer<Integer, String> container = 
                new ConcurrentMessageListenerContainer<Integer, String>(consumerFactory(groupName), new ContainerProperties(groupName));
		
	    int concurrency = 1;
        if (groupName.equals(AsyncQueueHandler.SERVICE_ETK_SEND_TOKEN))
            concurrency = Integer.parseInt(ETKProperty.getProperty("send.token.thread.poolSize"));
        
        container.setConcurrency(concurrency);
        
        return container;
	}
	
	public ConsumerFactory<Integer, String> consumerFactory(String groupName) {
		 Map<String, Object> props = new HashMap<>();
	        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupName);
	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, EtkKafkaProducer.brokerAddress);
	        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.parseBoolean(ETKProperty.getProperty("kafka.consumer.auto.commit")));
	        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
	        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        return new DefaultKafkaConsumerFactory<>(props);
	}
}
