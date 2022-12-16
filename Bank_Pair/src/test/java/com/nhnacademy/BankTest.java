package com.nhnacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {
    Bank bank;
    @BeforeEach
    void set(){
        bank = new Bank();
    }
    @Test
    void won_to_dollar_exchange() {
        Money money = new Money(1000,Currency.Won);

        money = bank.foreignCurrencyExchange(money, Currency.Dollar); // money return

        assertThat(new Money(1,Currency.Dollar)).isEqualTo(money);
    }


    @Test
    void doller_to_won_exchange() {
        Money money = new Money(5.25,Currency.Dollar);

        money = bank.currencyExchangeInKorean(money, Currency.Dollar); // money return

        assertThat(new Money(5250,Currency.Won)).isEqualTo(money);
    }

    @Test
    void won_to_dollar_exchange_rounding() {
        Money money = new Money(1005,Currency.Won);

        money = bank.foreignCurrencyExchange(money, Currency.Dollar); // money return

        assertThat(new Money(1.01,Currency.Dollar)).isEqualTo(money);
        assertThat(1.01).isEqualTo(money.getMoney());

    }

    @Test
    void dollar_to_won_exchange_rounding() {
        Money money = new Money(1.005,Currency.Dollar);

        money = bank.currencyExchangeInKorean(money, Currency.Dollar);

        assertThat(new Money(1010, Currency.Won)).isEqualTo(money);
    }
    @Test
    void won_to_euro_exchange_rounding() {
        Money money = new Money(1005,Currency.Won);

        money = bank.foreignCurrencyExchange(money, Currency.Euro); // money return

        assertThat(0.84).isEqualTo(money.getMoney());
        assertThat(new Money(0.84,Currency.Euro)).isEqualTo(money);
    }

    @Test
    void euro_to_won_exchange_rounding() {
        Money money = new Money(1.005,Currency.Euro);

        money = bank.currencyExchangeInKorean(money, Currency.Euro);

        assertThat(new Money(1210, Currency.Won)).isEqualTo(money);

    }
}
