package com.nuri.etk.exception;

public class ContractDoesNotExistException extends RuntimeException {
    public ContractDoesNotExistException() {}
    public ContractDoesNotExistException(String message) {
        super(message);
    }
}
