package me.plich.cashregistersystem.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LocationNotSetAdvice {
    @ExceptionHandler(LocationNotSetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String LocationNotSetHandler(LocationNotSetException e) {
        return e.getMessage();
    }
}
