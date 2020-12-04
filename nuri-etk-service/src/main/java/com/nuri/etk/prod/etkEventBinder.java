package com.nuri.etk.prod;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(etkEventSource.class)
public class etkEventBinder implements EventProducer {

    private final etkEventSource etkEventSource;

    public etkEventBinder(etkEventSource etkEventSource) {
        this.etkEventSource = etkEventSource;
    }

    @Override
    public void publish(String payload) {
        Logger log = null;
        log.info("payload : {}", payload);

        boolean result = etkEventSource.etiketEventChannel().send(MessageBuilder.withPayload(payload).build());
        log.info("result : {}", result);
    }
}