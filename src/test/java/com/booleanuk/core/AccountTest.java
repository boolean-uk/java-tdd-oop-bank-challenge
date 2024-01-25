package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Account account;

    @BeforeEach
    public void dummyData() {
        account = new Account("12345");

    }
    @Test
    public void constructorTest() {
        Assertions.assertEquals("12345", account.getIdentifier());
        Assertions.assertEquals(0, account.getIdentifier());
        Assertions.assertTrue(account.getTransactions().isEmpty());
    }

    @Test
    public void depositTest() {
        account.deposit(500);
        Assertions.assertEquals(500, account.getAmount());
        Assertions.assertFalse(account.getTransactions().isEmpty());
        Assertions.assertEquals(500, account.getTransactions().get(0).getAmount());
        Assertions.assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(0).getType());
    }

    @Test
    public void withdrawlTest() {
        account.withdrawal(100);
        Assertions.assertTrue(account.getTransactions().isEmpty()); // No transaction should happen when the withdrawl is invalid
        Assertions.assertEquals(0, account.getAmount()); // The balance should remain unchanged
        account.deposit(400);
        account.withdrawal(250);
        Assertions.assertEquals(150, account.getAmount());
        Assertions.assertEquals(150, account.getTransactions().get(1).getAmount());
        Assertions.assertEquals(TransactionType.WITHDRAWAL, account.getTransactions().get(1).getType());
    }


    @Test
    public void getBankStatementTest() {

    }
}
