package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TransactionTest {
    @Test
    public void correctFormattedTransactionCredit(){
        LocalDateTime dateTime = LocalDateTime.of(2024, 9, 7, 13, 24, 10);
        Transaction transaction = new Transaction(dateTime, 200D, "Credit", 300D);
        String correctlyFormattedTransaction = "2024-09-07T13:24:10 || 200.0    ||        || 300.0";

        Assertions.assertEquals(correctlyFormattedTransaction, transaction.formatTransactionForBankStatement());
    }

    @Test
    public void correctFormattedTransactionDebit(){
        LocalDateTime dateTime = LocalDateTime.of(2024, 9, 7, 13, 24, 10);
        Transaction transaction = new Transaction(dateTime, 200D, "Debit", 300D);
        String correctlyFormattedTransaction = "2024-09-07T13:24:10 ||        || 200.0    || 300.0";


        Assertions.assertEquals(correctlyFormattedTransaction, transaction.formatTransactionForBankStatement());
    }
}
