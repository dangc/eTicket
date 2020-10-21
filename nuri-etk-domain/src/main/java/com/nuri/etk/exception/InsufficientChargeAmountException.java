package com.nuri.etk.exception;

public class InsufficientChargeAmountException extends RuntimeException {
    public InsufficientChargeAmountException() {}
    public InsufficientChargeAmountException(String message) {
        super(message);
    }
}
