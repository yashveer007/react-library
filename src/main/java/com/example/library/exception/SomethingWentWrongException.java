package com.example.library.exception;

public class SomethingWentWrongException extends RuntimeException {
    public SomethingWentWrongException(String message){
        super(message);
    }
}
