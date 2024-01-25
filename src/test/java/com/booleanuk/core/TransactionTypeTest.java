package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTypeTest {

    @Test
    public void testTransactionType() {
        TransactionType withdraw = TransactionType.WITHDRAW;
        TransactionType deposit = TransactionType.DEPOSIT;

        Assertions.assertEquals("Credit", deposit.toString());
        Assertions.assertEquals("Debit", withdraw.toString());
    }
}