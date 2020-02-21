package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class IncorrectEmailAdvice {

    @ExceptionHandler(IncorrectEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String incorrectEmailHandler(IncorrectEmailException ex) {
        return ex.getMessage();
    }
}



