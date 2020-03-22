package me.plich.cashregistersystem.exception;

public class InvalidNipNumberException extends RuntimeException {
    public InvalidNipNumberException(String nip) {
        super("Invalid NIP number: "+nip);
    }
}
