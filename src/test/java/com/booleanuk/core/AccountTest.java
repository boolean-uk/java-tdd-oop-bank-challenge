package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class AccountTest {

    public AccountTest() {

    }

    @Test
    public void testCreateCurrentAccount() {
        Account currentAccount = new CurrentAccount("AC1");

        currentAccount.getAccountNumber("AC1", currentAccount.getAccountNumber());
    }

}
