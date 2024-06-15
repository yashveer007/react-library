package com.example.library.exception;

public class NoAccountFoundException extends RuntimeException{

    String errorMsg;

    public NoAccountFoundException(String errorMsg){
        this.errorMsg = errorMsg;
    }
}
