package com.nuri.etk.exception;

public class NoTariffInformationException extends RuntimeException {
    public NoTariffInformationException() {}
    public NoTariffInformationException(String message) {
        super(message);
    }
}
