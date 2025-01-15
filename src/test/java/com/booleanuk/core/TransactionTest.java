package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void getRightAmountTest() {
        Account acc = new Account(AccountType.CURRENT);
        Transaction transaction = new Transaction(acc.getID(), 200.0F);
        Assertions.assertEquals(200.0F, transaction.getAmount());
    }

    @Test
    public void getWrongAmountTest() {
        Account acc = new Account(AccountType.CURRENT);
        Transaction transaction = new Transaction(acc.getID(), 200.0F);
        Assertions.assertNotEquals(500.0F, transaction.getAmount());
    }

    @Test
    public void getRightAccountTest() {
        Account acc = new Account(AccountType.CURRENT);
        Transaction transaction = new Transaction(acc.getID(), 200.0F);
        Assertions.assertEquals(acc.getID(), transaction.getAccountID());
    }
}
