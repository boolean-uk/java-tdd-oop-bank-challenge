package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    @Test
    public void testDeposit(){
        // the test should increase the balance and add a transaction of type CREDIT
        SavingAccount account = new SavingAccount(0);
        account.deposit(100.00);

        Assertions.assertEquals(100.00,account.getBalance());

    }
}
