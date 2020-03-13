package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class CustomerExistAdvice {

    @ExceptionHandler(CustomerExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String CustomerExistHandler(CustomerExistException e) {
        return e.getMessage();
    }
}
