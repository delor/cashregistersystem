package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ProducerNotFoundAdvice  {


    @ExceptionHandler(ProducerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ProducerNotFoundHandler(ProducerNotFoundException e) {
        return e.getMessage();
    }
}