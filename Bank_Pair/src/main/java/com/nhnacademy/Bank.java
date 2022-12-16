package com.nhnacademy;

public class Bank {


    public Money add(Money money, Money money2) {
        if(money.getMoney()<0||money2.getMoney()<0){
            throw new IllegalArgumentException("cannot add money");
        }
        return new Money(money.getMoney() + money2.getMoney(), money.getCurrency());
    }


    public Money deposit(int a, Currency currency) {
        if (a < 0) {
            throw new DepositFailedException(a);
        }
        return new Money(a, currency);
    }

    public Money sub(Money money1, Money money2) {
        double result = money1.getMoney() - money2.getMoney();
        if (result < 0) {
            throw new ChangeFailedException();
        }
        return new Money(result, money1.getCurrency());
    }

    public Money foreignCurrencyExchange(Money money, Currency currency) {
        double amount= money.getMoney() / currency.getExchange();
        double tmp = rounding(amount % 0.01);
        amount = rounding(amount-tmp);

        if (tmp >= 0.005) {
            amount += 0.01;
        }

        Money exchangeResult = new Money(amount, currency);
        return exchangeResult;

    }

    public Money currencyExchangeInKorean(Money money, Currency currency) {
        double amount = money.getMoney() * currency.getExchange();
        double tmp = rounding(amount % 10);
        amount = rounding(amount-tmp);

        if (tmp >= 5) {
            amount += 10;
        }

        Money exchangeResult = new Money(amount, Currency.Won);
        return exchangeResult;
    }

    public double rounding(double tmp){
        return Math.round((tmp)*1000)/1000.0;
    }
}
