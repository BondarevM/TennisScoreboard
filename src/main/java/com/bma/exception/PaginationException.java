package com.bma.exception;

public class PaginationException extends Exception{
    public PaginationException() {
    }

    public PaginationException(String message) {
        super(message);
    }
}