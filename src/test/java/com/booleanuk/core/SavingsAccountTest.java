package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    //User story 2
    @Test
    public void assertSavingsAccountWasCreated() {
        int accountId = 123;
        SavingsAccount savingsAccount = new SavingsAccount(accountId, Branch.PERSONAL);
        Assertions.assertEquals(accountId, savingsAccount.getAccountId());
        Assertions.assertEquals(0.0, savingsAccount.getBalance());
    }

    //User story 4
    @Test
    public void assertBalanceCannotBeNegative() {
        SavingsAccount savingsAccount = new SavingsAccount(123, Branch.PERSONAL);
        double originalBalance = savingsAccount.getBalance();
        savingsAccount.withdraw(100);
        double newBalance = savingsAccount.getBalance();
        Assertions.assertEquals(originalBalance, newBalance);
    }

    //User story 7
    @Test
    public void assertRequestOverdraftHasBeenMade() {
        SavingsAccount savingsAccount = new SavingsAccount(123, Branch.PERSONAL);
        boolean requestMade = savingsAccount.requestOverdraft();
    }
}
