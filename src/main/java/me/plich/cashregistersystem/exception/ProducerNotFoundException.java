package me.plich.cashregistersystem.exception;

public class ProducerNotFoundException extends RuntimeException {
    public ProducerNotFoundException(Long id) {
        super("Producer with id:"+id+" not found");
    }
}