package me.plich.cashregistersystem.exception;

public class CustomerExistException extends RuntimeException {
    public CustomerExistException(String customerNip) {
        super("There is already a customer with nip number: "+customerNip);
    }
}
