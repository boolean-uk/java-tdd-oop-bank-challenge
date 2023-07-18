package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsAccountTest {
    @Test
    public void testDeposit() {
        SavingsAccount account = new SavingsAccount();
        BigDecimal depositAmount = new BigDecimal("500");

        account.deposit(depositAmount);

        assertEquals(depositAmount, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        SavingsAccount account = new SavingsAccount();
        BigDecimal initialBalance = new BigDecimal("6000");
        BigDecimal withdrawalAmount = new BigDecimal("1000");
        account.deposit(initialBalance);

        account.withdraw(withdrawalAmount);

        assertEquals(initialBalance.subtract(withdrawalAmount), account.getBalance());
    }
}
