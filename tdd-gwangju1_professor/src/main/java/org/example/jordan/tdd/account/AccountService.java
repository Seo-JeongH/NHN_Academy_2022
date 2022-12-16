package org.example.jordan.tdd.account;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void join(Account account) {
        repository.insert(account);
    }

    public Account getAccount(Long id) {
        return repository.findById(id);
    }

    public Account login(String username, String password) {
        checkInput(username);

        Account account = repository.findByUsername(username);
        if (account == null) {
            return null;
        }
        checkPassword(username, password, account);
        // 로그인 성공.
        account.unlock();
        return account;
    }

    private void checkPassword(String username, String password, Account account) {
        if (!account.matchedPassword(password)) {
            account.failLogin();
            checkLockAccount(username, account);
            throw new LoginFailedException(username);
        }
    }

    private void checkInput(String username) {
        if (username == null) {
            throw new IllegalArgumentException("username is null");
        }
    }

    private void checkLockAccount(String username, Account account) {
        if (account.isLocked()) {
            throw new AccountLockedException(username);
        }
    }
}
