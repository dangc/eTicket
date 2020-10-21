package com.nuri.etk.exception;

public class FailToGenerateSTSTokenException extends RuntimeException {
    public FailToGenerateSTSTokenException() {}
    public FailToGenerateSTSTokenException(String message) {
        super(message);
    }
}
