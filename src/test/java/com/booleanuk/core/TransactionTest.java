package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testGetAmount(){
        Transaction transaction = new Transaction("deposit", 500);
        Assertions.assertEquals(500, transaction.getAmount());
    }

    @Test
    public void testMakeDateStamp(){
        Transaction transaction = new Transaction("deposit", 500);
        Assertions.assertEquals("22-05-2023", transaction.getDate());
    }


}
