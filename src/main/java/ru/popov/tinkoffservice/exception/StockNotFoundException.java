package ru.popov.tinkoffservice.exception;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String format) {
        super(format);
    }
}
