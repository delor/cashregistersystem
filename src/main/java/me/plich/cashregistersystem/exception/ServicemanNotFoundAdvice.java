package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ServicemanNotFoundAdvice  {


    @ExceptionHandler(ServicemanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ServicemanNotFoundHandler(ServicemanNotFoundException e) {
        return e.getMessage();
    }
}
