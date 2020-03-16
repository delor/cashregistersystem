package me.plich.cashregistersystem.exception;

public class InvalidRequestParametersException extends RuntimeException{
    public InvalidRequestParametersException(Long param1, Long param2) {
        super("No resource found with id: " + param1+" or "+param2);
    }
}
