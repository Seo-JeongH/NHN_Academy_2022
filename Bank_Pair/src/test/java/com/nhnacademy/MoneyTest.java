package com.nhnacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    Bank bank;
    @BeforeEach
    void set(){
        bank = new Bank();
    }
    @Test
    void add_amount_success() {
        Money money1 = new Money(1000, Currency.Won);
        Money money2 = new Money(1000,Currency.Won);

        Money result = bank.add(money1, money2);
        assertThat(result.getMoney()).isEqualTo(2000);
    }

    @Test
    void add_amount_fail() {
        Money money1 = new Money(-1000, Currency.Won);
        Money money2 = new Money(1000,Currency.Won);

        assertThatThrownBy(() -> bank.add(money1, money2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("cannot add money");
    }

    @Test
    void isequal_amount_success() {
        Money money1 = new Money(1000,Currency.Won);
        Money money2 = new Money(1000,Currency.Won);

        assertThat(money1).isEqualTo(money2);
    }

    @Test
    void money_is_not_negative_number () {
        int money = -1000;
        assertThatThrownBy(() -> bank.deposit(money,Currency.Won))
                .isInstanceOf(DepositFailedException.class)
                .hasMessageContainingAll("Deposit failed " + money);
    }

    @Test
    void money_is_positive_number() {
        Money money = new Money(1000,Currency.Won);

        Money resultMoney = bank.deposit(1000 , Currency.Won);
        assertThat(money).isEqualTo(resultMoney);
    }

    @Test
    void dollar_sub_success() {
        Money money1 = new Money(5,Currency.Dollar);
        Money money2 = new Money(6,Currency.Dollar);

        assertThatThrownBy(() -> bank.sub(money1, money2))
                .isInstanceOf(ChangeFailedException.class)
                .hasMessageContainingAll("Change failed : Sub Method");
    }
    @Test
    void doubleType(){
        Money money1 = new Money(5.25,Currency.Dollar);
        Money money2 = new Money(5.25,Currency.Dollar);

        Money result = bank.add(money1, money2);

        assertThat(new Money(10.5, Currency.Dollar)).isEqualTo(result);
    }


}

