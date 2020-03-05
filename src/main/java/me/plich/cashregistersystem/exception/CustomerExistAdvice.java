package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//RestControllerAdvice ??
@ControllerAdvice
public class CustomerExistAdvice {

    @ResponseBody
    @ExceptionHandler(CustomerExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String CustomerExistHandler(CustomerExistException e) {
        return e.getMessage();
    }
}
