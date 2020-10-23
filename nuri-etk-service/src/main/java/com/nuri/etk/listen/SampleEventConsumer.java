package com.nuri.etk.listen;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
@EnableBinding(SampleEventSink.class)
public class SampleEventConsumer {

    @StreamListener(SampleEventSink.SAMPLE_INPUT_CHANNEL)
    public void listenSampleChannel(@Payload String payload) {
        Logger log = null;
        log.info("listen sample channel : {}", payload);
    }
}
