package me.plich.cashregistersystem.exception;

public class EntrepreneurNotFoundException extends RuntimeException {
    public EntrepreneurNotFoundException(String nip) {
        super("Entrepreneur with nip number: "+nip+" not found");
    }
}
