package me.plich.cashregistersystem.exception;

public class LocationNotSetException extends RuntimeException {
    public LocationNotSetException(Long id) {
        super("Location not set for device with id: "+id);
    }
}
