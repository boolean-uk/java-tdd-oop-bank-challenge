package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testSetDateWorks() {
        Transaction transaction = new Transaction("15-02-2023", 50.00, 10.00, 500.00);

        Assertions.assertEquals("15-02-2023", transaction.getDate());
        transaction.setDate("16-02-2023");
        Assertions.assertEquals("16-02-2023", transaction.getDate());

    }

    @Test
    public void testSetCreditWorks() {
        Transaction transaction = new Transaction("15-02-2023", 50.00, 10.00, 500.00);

        Assertions.assertEquals(50.00, transaction.getCredit());
        transaction.setCredit(25.00);
        Assertions.assertEquals(25.00, transaction.getCredit());
    }

    @Test
    public void testSetDebitWorks() {
        Transaction transaction = new Transaction("15-02-2023", 50.00, 10.00, 500.00);

        Assertions.assertEquals(10.00, transaction.getDebit());
        transaction.setDebit(20.00);
        Assertions.assertEquals(20.00, transaction.getDebit());
    }

    @Test
    public void testSetDebitWorks() {
        Transaction transaction = new Transaction("15-02-2023", 50.00, 10.00, 500.00);

        Assertions.assertEquals(10.00, transaction.getBalance());
        transaction.setBalance(20.00);
        Assertions.assertEquals(20.00, transaction.getBalance());
    }
}

