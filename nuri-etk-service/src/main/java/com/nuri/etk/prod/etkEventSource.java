package com.nuri.etk.prod;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface etkEventSource {
    String ETIKET_CHANNEL = "etiketChannel";

    @Input(ETIKET_CHANNEL)
    MessageChannel etiketEventChannel();
}
