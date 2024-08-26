package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {
    Transaction t = new Transaction(0, 0, 0);

    @Test
    public void testTransaction() {
        Assertions.assertInstanceOf(Transaction.class, t);
        System.out.println(t.getDate());
        Assertions.assertEquals(0, t.getCredit());
        Assertions.assertEquals(0, t.getDebit());
        //Assertions.assertEquals("25/01/2024", t.getDate());
    }
}
