package com.nuri.etk.prod;

public interface EventProducer {
    void publish(String payload);
}
