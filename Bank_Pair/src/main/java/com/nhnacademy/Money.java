package com.nhnacademy;

public class Money {

    private final double amount; //금액
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getMoney() {
        return this.amount;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Money))
            return false;
        Money m = (Money) o;
        return m.getMoney() == amount && m.getCurrency().equals(getCurrency());
    }


}
