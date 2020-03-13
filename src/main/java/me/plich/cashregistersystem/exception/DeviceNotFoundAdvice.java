package me.plich.cashregistersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class DeviceNotFoundAdvice  {

    @ExceptionHandler(DeviceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String DeviceNotFoundHandler(DeviceNotFoundException e) {
        return e.getMessage();
    }
}
