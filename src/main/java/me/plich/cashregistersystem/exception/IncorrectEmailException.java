package me.plich.cashregistersystem.exception;

public class IncorrectEmailException extends RuntimeException {
    public IncorrectEmailException(String email) {
        super("incorrect email address: " + email);
    }
}

