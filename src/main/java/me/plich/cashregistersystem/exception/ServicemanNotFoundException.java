package me.plich.cashregistersystem.exception;

public class ServicemanNotFoundException extends RuntimeException {
    public ServicemanNotFoundException(Long id) {
        super("Serviceman with id:"+id+" not found");
    }
}
