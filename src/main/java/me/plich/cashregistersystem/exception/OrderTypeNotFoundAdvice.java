package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderTypeNotFoundAdvice {

    @ExceptionHandler(OrderTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String OrderTypeNotFoundHandler(OrderTypeNotFoundException e) {
        return e.getMessage();
    }
}
