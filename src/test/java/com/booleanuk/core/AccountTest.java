package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testGetBalanceWorks() {
        Account account = new Account(123456, 500.00);

        assertEquals(500.00, account.getBalance());

    }

    @Test
    public void testSetBalanceWorks() {
        Account account = new Account(123456, 500.00);

        assertEquals(500.00, account.getBalance());
        account.setBalance(750.00);
        assertEquals(750.00, account.getBalance());
    }

    @Test
    public void testDepositAmountWorks() {
        Account account = new Account(123456, 500.00);

        assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertTrue(account.depositAmount(150));
        assertEquals(650.00, account.getBalance(), 0.01);
    }

    @Test
    public void testDepositAmountFails() {
        Account account = new Account(123456, 500.00);

        Assertions.assertFalse(account.depositAmount(-10.00));
        assertEquals(500.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawAmountWorks() {
        Account account = new Account(123456, 500.00);

        assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertTrue(account.withdrawAmount(150));
        assertEquals(350.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawAmountFails() {
        Account account = new Account(123456, 500.00);

        assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertFalse(account.withdrawAmount(-10));
        assertEquals(500.00, account.getBalance(), 0.01);
    }

    @Test
    public void testAddTransactionHistory() {
        Account account = new Account(123456, 500.00);
        Transaction transaction = new Transaction("15-02-2023", 50.00, 10.00, 500.00);

        Assertions.assertTrue(add.TotransactionHistory(transaction));
        List<Transaction> transactionHistory = transactionHistory.getTransaction();
        assertEquals(1, transactionHistory.size());
        assertEquals(transaction, transactionHistory.get(0));
    }
}
