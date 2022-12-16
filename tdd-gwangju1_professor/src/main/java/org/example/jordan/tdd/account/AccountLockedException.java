package org.example.jordan.tdd.account;

public class AccountLockedException extends RuntimeException {
    public AccountLockedException(String username) {
        super("Account locked: " + username);
    }
}
