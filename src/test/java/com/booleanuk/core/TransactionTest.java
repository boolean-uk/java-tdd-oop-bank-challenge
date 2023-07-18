package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TransactionTest {

    @Test
    public void shouldCreateTransactionWithCurrentDate()
    {
        Transaction transaction = new Transaction(123,TransactionType.credit,500);
        Assertions.assertEquals(LocalDate.now(),transaction.getDate());
    }
    @Test
    public void shouldCreateTransactionCreditType()
        {
            Transaction transaction = new Transaction(123,TransactionType.credit,500);
            Assertions.assertEquals(TransactionType.credit,transaction.getTransactionType());
        }

    @Test
    public void shouldCreateTransactionDebitType()
    {
        Transaction transaction = new Transaction(123,TransactionType.debit,500);
        Assertions.assertEquals(TransactionType.debit,transaction.getTransactionType());
    }

}
