package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount("1234-5678-9101-1121", 1, "123");
    }

    @Test
    void testDepositShouldSucceed() {
        savingsAccount.deposit(100.0d);
        Assertions.assertEquals(100.0d, savingsAccount.getBalance());
    }

    @Test
    void testDepositShouldFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.deposit(-100.0d));
    }

    @Test
    void testWithdrawShouldSucceed() {
        savingsAccount.deposit(100.0d);
        savingsAccount.withdraw(50.0d);
        Assertions.assertEquals(50.0d, savingsAccount.getBalance());
    }

    @Test
    void testWithdrawShouldFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.withdraw(-100.0d));
    }

    @Test
    void testWithdrawShouldFailWhenOverdrawn() {
        savingsAccount.deposit(50.0d);
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.withdraw(100.0d));
    }
}
