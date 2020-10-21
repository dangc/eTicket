package com.nuri.etk.exception;

public class FailToSendSTSTokenException extends RuntimeException {
    public FailToSendSTSTokenException() {}
    public FailToSendSTSTokenException(String message) {
        super(message);
    }
}
