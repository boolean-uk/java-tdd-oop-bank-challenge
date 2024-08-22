package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testCreateAccountInstance() {
        Account account = new Account();
        Assertions.assertNotNull(account);
        Assertions.assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testGetBalance() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getBalance());
    }
}
