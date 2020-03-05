package me.plich.cashregistersystem.exception;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(Long id) {
        super("Location with id:"+id+" not found");
    }
}
