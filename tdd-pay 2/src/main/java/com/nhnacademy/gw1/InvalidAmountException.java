package com.nhnacademy.gw1;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(long amount) {
        super("InvalidAmount"+amount);
    }
}
