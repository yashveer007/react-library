package com.example.library.exception;

public class SomethingWentWrongException extends RuntimeException {

    String errorMsg;

    public SomethingWentWrongException(String msg){
        this.errorMsg = msg;
    }
}
