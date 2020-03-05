package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ServicemanNotFoundAdvice  {

    @ResponseBody
    @ExceptionHandler(ServicemanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ServicemanNotFoundHandler(ServicemanNotFoundException e) {
        return e.getMessage();
    }
}
