package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    public void createAccount() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        Assertions.assertEquals(user, a.getOwner());
        Assertions.assertEquals(0, a.getTransactions().size());
        Assertions.assertEquals(0.00, a.getBalance());
    }

    @Test
    public void shouldReturnTrueDeposit() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        Assertions.assertTrue(a.deposit(20.00));
        Assertions.assertTrue(a.deposit(1.99));
        Assertions.assertEquals(21.99, a.getBalance());
    }

    @Test
    public void shouldReturnFalseDeposit() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        Assertions.assertFalse(a.deposit(-1.29));
        Assertions.assertFalse(a.deposit(0));
        Assertions.assertEquals(0.00, a.getBalance());
    }
}
