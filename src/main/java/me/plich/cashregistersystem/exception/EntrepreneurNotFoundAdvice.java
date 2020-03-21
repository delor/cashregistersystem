package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntrepreneurNotFoundAdvice {

    @ExceptionHandler(EntrepreneurNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String EntrepreneurNotFoundHandler(EntrepreneurNotFoundException e) {
        return e.getMessage();
    }
}
