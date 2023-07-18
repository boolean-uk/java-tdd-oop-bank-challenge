package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    @Test
    public void depositWithPositiveAmountTest() {
        CurrentAccount account = new CurrentAccount();
        account.deposit(100);

        Assertions.assertEquals(100.00, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());
        account.deposit(100.55);
        Assertions.assertEquals(200.55, account.getBalance());
        account.deposit(100.44);
        Assertions.assertEquals(300.99, account.getBalance());
        Assertions.assertEquals(3,account.getTransactions().size());
    }
}
