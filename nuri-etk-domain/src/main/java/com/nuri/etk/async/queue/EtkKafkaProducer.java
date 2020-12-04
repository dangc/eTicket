package com.nuri.etk.async.queue;

import java.util.HashMap;
import java.util.Map;

import com.nuri.etk.async.data.AbstractAsyncData;
import com.nuri.etk.async.util.ETKProperty;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;


@Component	
public class EtkKafkaProducer {
	public static String topic = "ServiceData.etiket";

//    public static String messageKey = "etkamm";

    public static String brokerAddress = ETKProperty.getProperty("kafka.broker.list");
    
    public MessageHandler handler() throws Exception {
        KafkaProducerMessageHandler<Integer, AbstractAsyncData> handler =
                new KafkaProducerMessageHandler<>(kafkaTemplate());
        handler.setTopicExpression(new LiteralExpression(EtkKafkaProducer.topic));
//        handler.setMessageKeyExpression(new LiteralExpression(EtkKafkaProducer.messageKey));
        return handler;
    }

    private KafkaTemplate<Integer, AbstractAsyncData> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    private ProducerFactory<Integer, AbstractAsyncData> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, EtkKafkaProducer.brokerAddress);
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }
}
