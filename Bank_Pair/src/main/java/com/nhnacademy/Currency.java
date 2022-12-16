package com.nhnacademy;

public enum Currency {
    Won(1),
    Dollar(1000),
    Euro(1200);
    private final double exchange;
    Currency(double exchange) {
        this.exchange = exchange;
    }

    public double getExchange(){
        return this.exchange;
    }
}
