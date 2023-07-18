package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    public void interestGetterTest() {
        SavingsAccount account1 = new SavingsAccount(1000.0);
        SavingsAccount account2 = new SavingsAccount(1000.0, 4.5);
        Assertions.assertEquals(2.0, account1.getInterest());
        Assertions.assertEquals(4.5, account2.getInterest());
    }
    @Test
    public void withdrawTest() {
        SavingsAccount account = new SavingsAccount(1000.0);
        Assertions.assertTrue(account.withdraw(100.3));
        Assertions.assertEquals(1000.0 - 100.3 - 5.0, account.getBalance());
        Assertions.assertFalse(account.withdraw(1000.0));
    }
    @Test
    public void calculateInterestTest() {
        SavingsAccount account1 = new SavingsAccount(1000.0);
        SavingsAccount account2 = new SavingsAccount(1000.0, 4.5);
        Assertions.assertEquals(1000.0 * 102.0 / 100.0, account1.calculateInterestGain());
        Assertions.assertEquals(1000.0 * 104.5 / 100.0, account2.calculateInterestGain());
    }
}
