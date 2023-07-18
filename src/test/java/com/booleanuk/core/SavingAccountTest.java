package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    CurrentAccount account;
    public SavingAccountTest() {
        account = new CurrentAccount();
    }

    @Test
    public void depositWithPositiveAmountTest() {

        account.deposit(100);

        Assertions.assertEquals(100.00, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());
        account.deposit(100.55);
        Assertions.assertEquals(200.55, account.getBalance());
        account.deposit(100.44);
        Assertions.assertEquals(300.99, account.getBalance());
        Assertions.assertEquals(3,account.getTransactions().size());
    }

    @Test
    public void depositWith0OrNegativeAmountTest() {
        account.deposit(100.11);
        Assertions.assertEquals(100.11, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());

        account.deposit(0);
        account.deposit(-100.11);
        Assertions.assertEquals(100.11, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());
    }
}
