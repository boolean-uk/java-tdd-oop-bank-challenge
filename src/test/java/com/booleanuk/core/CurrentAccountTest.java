package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    private CurrentAccount currentAccount;

    @BeforeEach
    void setUp() {
        currentAccount = new CurrentAccount("1234-5678-9101-1121", 1, "123");
    }

    @Test
    void testDepositShouldSucceed() {
        currentAccount.deposit(100.0d);
        Assertions.assertEquals(100.0d, currentAccount.getBalance());
    }

    @Test
    void testDepositShouldFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> currentAccount.deposit(-100.0d));
    }

    @Test
    void testWithdrawShouldSucceed() {
        currentAccount.deposit(100.0d);
        currentAccount.withdraw(50.0d);
        Assertions.assertEquals(50.0d, currentAccount.getBalance());
    }

    @Test
    void testWithdrawShouldFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> currentAccount.withdraw(-100.0d));
    }

    @Test
    void testWithdrawShouldFailWhenOverdrawn() {
        currentAccount.deposit(50.0d);
        Assertions.assertThrows(IllegalArgumentException.class, () -> currentAccount.withdraw(100.0d));
    }
}
