package org.example.jordan.tdd.account;

public class LoginFailedException extends RuntimeException {
    public LoginFailedException(String username) {
        super("Login failed. username = " + username);
    }
}
