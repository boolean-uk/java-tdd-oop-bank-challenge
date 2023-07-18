package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    @Test
    public void depositWithPositiveAmountTest() {
        CurrentAccount account = new CurrentAccount();
        account.deposit(100);
        Assertions.assertEquals(100.00, account.getAccountBalance());
    }
}
