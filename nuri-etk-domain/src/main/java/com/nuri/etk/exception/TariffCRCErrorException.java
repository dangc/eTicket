package com.nuri.etk.exception;

public class TariffCRCErrorException extends RuntimeException {
    public TariffCRCErrorException() {}
    public TariffCRCErrorException(String message) {
        super(message);
    }
}
