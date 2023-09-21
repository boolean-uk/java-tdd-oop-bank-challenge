package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testGetBalanceWorks() {
        Account account = new Account(123456, 500.00);

        Assertions.assertEquals(500.00, account.getBalance());

    }

    @Test
    public void testDepositAmountWorks() {
        Account account = new Account(123456, 500.00);
        account.depositAmount(150.00);

        Assertions.assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertEquals(650.00, account.getNewBalance(), 0.01);
    }
}
