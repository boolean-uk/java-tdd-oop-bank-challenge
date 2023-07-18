package com.booleanuk.core.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
    }

    @Test
    public void depositAddsTransaction() {
        account.deposit(19.99);
        account.deposit(19.99);

        assertEquals(39.98, account.getBalance());
    }

    @Test
    void depositThrowsErrorForNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20));
    }
}