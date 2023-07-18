package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    @Test
    public void depositWithPositiveAmountTest() {
        CurrentAccount account = new CurrentAccount();
        account.deposit(100);
        Assertions.assertEquals(100.00, account.getAccountBalance());
        account.deposit(100.55);
        Assertions.assertEquals(200.55, account.getAccountBalance());
        account.deposit(100.44);
        Assertions.assertEquals(300.99, account.getAccountBalance());
    }
}
