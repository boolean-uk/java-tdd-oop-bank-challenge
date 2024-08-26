package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    public AccountTest() {

    }

    @Test
    public void testCreateCurrentAccount() {
        Account currentAccount = new CurrentAccount("AC1");

        Assertions.assertEquals("AC1", currentAccount.getAccountNumber());
    }

    @Test
    public void testCreateSavingsAccount() {
        Account savingsAccount = new SavingsAccount("AC1");

        Assertions.assertEquals("AC1", savingsAccount.getAccountNumber());
    }

}
