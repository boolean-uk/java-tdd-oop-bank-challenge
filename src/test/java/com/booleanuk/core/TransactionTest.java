package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {
    @Test
    public void gettersTest() {
        Transaction transaction1 = new Transaction(100.0);
        Transaction transaction2 = new Transaction(150.0, 4.20);
        Assertions.assertEquals(100.0, transaction1.getAmount());
        Assertions.assertEquals(150.0, transaction2.getAmount());
        Assertions.assertEquals(0.0, transaction1.getFee());
        Assertions.assertEquals(4.20, transaction2.getFee());
    }
}
