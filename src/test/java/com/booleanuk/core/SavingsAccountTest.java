package com.booleanuk.core;

import org.junit.jupiter.api.BeforeEach;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new CurrentAccount("1234-5678-9101-1121", 1);
    }

    void testDepositShouldSucceed() {
        savingsAccount.deposit(100.0d);
        assertEquals(100.0d, savingsAccount.getBalance());
    }

    void testDepositShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> savingsAccount.deposit(-100.0d));
    }

    void testWithdrawShouldSucceed() {
        savingsAccount.deposit(100.0d);
        savingsAccount.withdraw(50.0d);
        assertEquals(50.0d, savingsAccount.getBalance());
    }

    void testWithdrawShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> savingsAccount.withdraw(-100.0d));
    }

    void testWithdrawShouldFailWhenOverdrawn() {
        savingsAccount.deposit(50.0d);
        assertThrows(IllegalArgumentException.class, () -> savingsAccount.withdraw(100.0d));
    }
}
