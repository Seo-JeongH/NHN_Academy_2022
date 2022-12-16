package org.example.jordan.tdd.account;

public class Account {
    private static final int LOGIN_FAIL_LOCKED_LIMIT = 3;
    private Long id;
    private String username;
    private String password;
    private int loginFailCount = 0;

    public Account(String username, String password) {
        this.id = nextUuid();
        this.username = username;
        this.password = password;
    }

    private static long nextUuid() {
        // Generate Id
        return System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean matchedPassword(String password) {
        return this.password.equals(password);
    }

    public void failLogin() {
        this.loginFailCount++;
    }

    public boolean isLocked() {
        return this.loginFailCount >= LOGIN_FAIL_LOCKED_LIMIT;
    }

    public void unlock() {
        this.loginFailCount = 0;
    }
}
