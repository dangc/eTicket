package com.nuri.etk.exception;

public class OperatorDoesNotExistException extends RuntimeException {
    public OperatorDoesNotExistException() {}
    public OperatorDoesNotExistException(String message) {
        super(message);
    }
}
