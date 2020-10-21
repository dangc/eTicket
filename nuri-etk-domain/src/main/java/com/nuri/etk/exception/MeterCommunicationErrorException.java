package com.nuri.etk.exception;

public class MeterCommunicationErrorException extends RuntimeException {
    public MeterCommunicationErrorException() {}
    public MeterCommunicationErrorException(String message) {
        super(message);
    }
}
