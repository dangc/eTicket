package com.nuri.etk.exception;

public class MissingRequiredDataException extends RuntimeException {
    public MissingRequiredDataException() {}
    public MissingRequiredDataException(String message) {
        super(message);
    }
}
