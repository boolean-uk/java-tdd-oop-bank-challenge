package com.booleanuk.core.core;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    void depositAddsTransaction() {
        account.deposit(19.99);
        account.deposit(19.99);

        assertEquals(39.98, account.getBalance());
    }

    void depositThrowsErrorForNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20));
    }
}