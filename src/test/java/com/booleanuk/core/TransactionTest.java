package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testCreateTransactionInstance() {
        double amountToDeposit = 100.00;
        Transaction transaction = new Transaction(amountToDeposit);
        Assertions.assertNotNull(transaction);
    }

    @Test
    public void testTransactionGetters() {
        double amountToDeposit = 100.00;
        Transaction transaction = new Transaction(amountToDeposit, amountToDeposit);
        Assertions.assertNotNull(transaction);
        Assertions.assertNotNull(transaction.getDate());
        Assertions.assertEquals(amountToDeposit, transaction.getAmount());
        Assertions.assertEquals(amountToDeposit, transaction.getBalanceAfterTransaction());
    }

}
