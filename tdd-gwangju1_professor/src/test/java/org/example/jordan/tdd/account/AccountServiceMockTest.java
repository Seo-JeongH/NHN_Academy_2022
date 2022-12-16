package org.example.jordan.tdd.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceMockTest {
    private AccountService service;
    private AccountRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class);
        service = new AccountService(repository);
    }

    @Test
    void login() {
        String username = "jordan";
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        Account result = service.login(username, password);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull().isPositive();
        assertThat(result.getUsername()).isEqualTo(username);
        assertThat(result.getPassword()).isEqualTo(password);

        verify(repository).findByUsername(username);    // !! verify(mock)
    }

    @Test
    void login_usernameIsNull_throwIllegalArgumentException() {
        String username = null;
        String password = "P@s5w0rd";

        //        Account account = new Account(username, password);
        //        when(repository.findByUsername(username)).thenReturn(account);

        assertThatIllegalArgumentException().isThrownBy(() -> service.login(username, password))
                                            .withMessageContaining("null");

        verify(repository, never()).findByUsername(any());  // !! verify never
    }

    @Test
    void login_failed2times_then_LoginFailedException() {
        String username = "jordan";
        String password = "invalid.password";

        Account account = new Account(username, "valid.password");
        when(repository.findByUsername(username)).thenReturn(account);

        // login failed 2times: LoginFailedException
        for (int i = 1; i < 3; i++) {
            assertThatThrownBy(() -> service.login(username, password))
                    .as("Login failed {0} times", i)
                    .isInstanceOf(LoginFailedException.class)
                    .hasMessageContainingAll("Login failed", username);
        }
        verify(repository, times(2)).findByUsername(username);  // !! verify never
    }

    @Test
    void login_failed3times_then_lockedAccount() {
        String username = "jordan";
        String password = "invalid.password";

        Account account = new Account(username, "valid.password");
        when(repository.findByUsername(username)).thenReturn(account);

        // login failed 2times: LoginFailedException
        for (int i = 1; i < 3; i++) {
            assertThatThrownBy(() -> service.login(username, password))
                    .as("Login failed {0} times", i)
                    .isInstanceOf(LoginFailedException.class)
                    .hasMessageContainingAll("Login failed", username);
        }
        // login failed 3times: AccountLockedException
        assertThatThrownBy(() -> service.login(username, password))
                .isInstanceOf(AccountLockedException.class)
                .hasMessageContainingAll("locked", username);

        verify(repository, times(3)).findByUsername(username);
    }

    @Test
    void login_failed2times_then_success_failed2times_then_LoginFailedException() {
        String username = "jordan";
        String password = "invalid.password";

        Account account = new Account(username, "valid.password");
        when(repository.findByUsername(username)).thenReturn(account);

        // login failed 2times: LoginFailedException
        for (int i = 1; i < 3; i++) {
            assertThatThrownBy(() -> service.login(username, password))
                    .as("Login failed {0} times", i)
                    .isInstanceOf(LoginFailedException.class)
                    .hasMessageContainingAll("Login failed", username);
        }
        // success 1times
        @SuppressWarnings("unused")
        Account result = service.login(username, "valid.password");

        // login failed 2times: LoginFailedException
        for (int i = 1; i < 3; i++) {
            assertThatThrownBy(() -> service.login(username, password))
                    .as("Login failed {0} times", i)
                    .isInstanceOf(LoginFailedException.class)
                    .hasMessageContainingAll("Login failed", username);
        }
        verify(repository, times(5)).findByUsername(username);
    }
}
