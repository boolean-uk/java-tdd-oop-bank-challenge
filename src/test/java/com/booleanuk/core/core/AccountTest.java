package com.booleanuk.core.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
    }

    @Test
    void depositAddsTransaction() {
        account.deposit(19.99);
        account.deposit(19.99);

        assertEquals(39.98, account.getBalance());
    }

    @Test
    void depositThrowsExceptionForNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20));
    }

    @Test
    void withdrawAddsTransaction() {
        account.deposit(19.99);
        account.deposit(19.99);

        account.withdraw(19.99);

        assertEquals(19.99, account.getBalance());
    }

    @Test
    void withdrawThrowsExceptionWhenBalanceIsInsufficient() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(19.99));
    }

    @Test
    void withdrawThrowsExceptionForNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20));
    }

    @Test
    void generateStatementReturnsStatement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = LocalDateTime.now().format(formatter);
        account.deposit(19.99);
        account.deposit(19.99);
        account.withdraw(19.99);

        assertEquals("""
                date || credit || debit  || balance
                %s   ||        || 19.99  || 19.99
                %s   || 19.99  ||        || 39.98
                %s   || 19.99  ||        || 19.99
                """.formatted(date, date, date), account.generateStatement());
    }
}