package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ModelNotFoundAdvice  {


    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ModelNotFoundHandler(ModelNotFoundException e) {
        return e.getMessage();
    }
}
