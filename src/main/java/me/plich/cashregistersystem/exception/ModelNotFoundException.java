package me.plich.cashregistersystem.exception;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(Long id) {
        super("Model with id:"+id+" not found");
    }
}
