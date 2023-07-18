package com.booleanuk.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class CurrentAccountTest {
    private CurrentAccount currentAccount;

    @BeforeEach
    void setUp() {
        currentAccount = new CurrentAccount("1234-5678-9101-1121", 1);
    }

    void testDepositShouldSucceed() {
        currentAccount.deposit(100.0d);
        assertEquals(100.0d, currentAccount.getBalance());
    }

    void testDepositShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> currentAccount.deposit(-100.0d));
    }

    void testWithdrawShouldSucceed() {
        currentAccount.deposit(100.0d);
        currentAccount.withdraw(50.0d);
        assertEquals(50.0d, currentAccount.getBalance());
    }

    void testWithdrawShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> currentAccount.withdraw(-100.0d));
    }

    void testWithdrawShouldFailWhenOverdrawn() {
        currentAccount.deposit(50.0d);
        assertThrows(IllegalArgumentException.class, () -> currentAccount.withdraw(100.0d));
    }
}
