package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testGetBalanceWorks() {
        Account account = new Account(123456, 500.00);

        Assertions.assertEquals(500.00, account.getBalance());

    }

    @Test
    public void testSetBalanceWorks() {
        Account account = new Account(123456, 500.00);

        Assertions.assertEquals(500.00, account.getBalance());
        account.setBalance(750.00);
        Assertions.assertEquals(750.00, account.getBalance());
    }

    @Test
    public void testDepositAmountWorks() {
        Account account = new Account(123456, 500.00);

        Assertions.assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertTrue(account.depositAmount(150));
        Assertions.assertEquals(650.00, account.getBalance(), 0.01);
    }

    @Test
    public void testDepositAmountFails() {
        Account account = new Account(123456, 500.00);

        Assertions.assertFalse(account.depositAmount(-10.00));
        Assertions.assertEquals(500.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawAmountWorks() {
        Account account = new Account(123456, 500.00);

        Assertions.assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertTrue(account.withdrawAmount(150));
        Assertions.assertEquals(350.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawAmountFails() {
        Account account = new Account(123456, 500.00);

        Assertions.assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertFalse(account.withdrawAmount(-10));
        Assertions.assertEquals(500.00, account.getBalance(), 0.01);
    }
}
