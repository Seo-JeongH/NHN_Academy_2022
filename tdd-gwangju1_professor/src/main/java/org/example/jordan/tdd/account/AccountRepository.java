package org.example.jordan.tdd.account;

public interface AccountRepository {
    void insert(Account account);

    Account findById(Long id);

    Account findByUsername(String username);
}
