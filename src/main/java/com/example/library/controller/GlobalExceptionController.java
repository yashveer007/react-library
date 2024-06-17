package com.example.library.controller;

import com.example.library.dto.ExceptionResponse;
import com.example.library.exception.NoAccountFoundException;
import com.example.library.exception.SomethingWentWrongException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = {SomethingWentWrongException.class, NoAccountFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    private ExceptionResponse handleNotFound(RuntimeException ex , HttpServletRequest request){
        return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
    }
}
