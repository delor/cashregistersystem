package me.plich.cashregistersystem.exception;

public class OrderTypeNotFoundException extends RuntimeException {
    public OrderTypeNotFoundException(String orderType) {
        super("Order type: "+orderType+" not allowed");
    }
}
