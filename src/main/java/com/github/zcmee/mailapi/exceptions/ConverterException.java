package com.github.zcmee.mailapi.exceptions;

public class ConverterException extends RuntimeException {

    public ConverterException() {
        super("Konwersja pliku się nie powiodła");
    }

    public ConverterException(String message) {
        super(message);
    }

    public ConverterException(Exception ex) {
        super(ex);
    }

}
