package com.nuri.etk.exception;

public class STSNumberDoesNotExistException extends RuntimeException {
    public STSNumberDoesNotExistException() {}
    public STSNumberDoesNotExistException(String message) {
        super(message);
    }
}
