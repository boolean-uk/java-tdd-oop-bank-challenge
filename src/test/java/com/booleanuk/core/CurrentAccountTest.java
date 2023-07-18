package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CurrentAccountTest {

    CurrentAccount account;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount();
    }

    @Test
    void shouldIncreaseTransactionCount() {
        account.deposit(BigDecimal.valueOf(1000.00), LocalDate.of(2012, 1, 10));
        Assertions.assertEquals(1, account.getTransactions().size());

        account.withdraw(BigDecimal.valueOf(500.00), LocalDate.of(2012, 1, 14));
        Assertions.assertEquals(2, account.getTransactions().size());
    }

    @Test
    void shouldReturnBalance() {
        account.deposit(BigDecimal.valueOf(1000.00), LocalDate.of(2012, 1, 10));
        account.deposit(BigDecimal.valueOf(2000.00), LocalDate.of(2012, 1, 13));
        account.withdraw(BigDecimal.valueOf(500.00), LocalDate.of(2012, 1, 14));
        Assertions.assertEquals(BigDecimal.valueOf(2500.00), account.getBalance());
    }
}
