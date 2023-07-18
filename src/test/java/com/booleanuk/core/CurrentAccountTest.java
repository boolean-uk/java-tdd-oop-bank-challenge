package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentAccountTest {
    @Test
    public void testDeposit() {
        CurrentAccount account = new CurrentAccount();
        BigDecimal depositAmount = new BigDecimal("1000");

        account.deposit(depositAmount);

        assertEquals(depositAmount, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        CurrentAccount account = new CurrentAccount();
        BigDecimal initialBalance = new BigDecimal("2000");
        BigDecimal withdrawalAmount = new BigDecimal("500");
        account.deposit(initialBalance);

        account.withdraw(withdrawalAmount);

        assertEquals(initialBalance.subtract(withdrawalAmount), account.getBalance());
    }
}
