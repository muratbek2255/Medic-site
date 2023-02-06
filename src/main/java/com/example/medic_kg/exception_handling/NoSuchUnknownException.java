package com.example.medic_kg.exception_handling;

public class NoSuchUnknownException extends RuntimeException {

    public NoSuchUnknownException(String message) {
        super(message);
    }
}
