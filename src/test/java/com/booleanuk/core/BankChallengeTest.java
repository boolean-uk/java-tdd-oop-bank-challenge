package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankChallengeTest {

    @Test
    public void createCurrentAccount() {
        CurrentAccount current = new CurrentAccount();

        Assertions.assertNotNull(current);
    }
    @Test
    public void currentAccountBalance() {
        CurrentAccount current = new CurrentAccount();

        Assertions.assertEquals(0.0, current.getBalance());
    }
}
