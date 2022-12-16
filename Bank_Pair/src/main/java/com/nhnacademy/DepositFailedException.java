package com.nhnacademy;

public class DepositFailedException extends RuntimeException{
    public DepositFailedException(int money){
        super("Deposit failed " + money);
    }

}
