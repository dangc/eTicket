package com.nuri.etk.exception;

public class NoContentException extends RuntimeException {
    public NoContentException() {}
    public NoContentException(String message) {
        super(message);
    }
}
