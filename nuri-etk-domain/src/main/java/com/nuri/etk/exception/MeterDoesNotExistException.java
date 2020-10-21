package com.nuri.etk.exception;

public class MeterDoesNotExistException extends RuntimeException {
    public MeterDoesNotExistException() {}
    public MeterDoesNotExistException(String message) {super(message);}
}
