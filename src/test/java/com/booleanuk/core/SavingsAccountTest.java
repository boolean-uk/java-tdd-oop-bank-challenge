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
    public void shouldBeTrueIfRequestForOverdraftHasBeenMade() {
        SavingsAccount savingsAccount = new SavingsAccount(123, Branch.PERSONAL);
        double expectedRequest = 100.0;
        savingsAccount.makeRequestForOverdraft(100.0);
        double actualRequest = savingsAccount.getRequestForOverDraft();
        Assertions.assertEquals(expectedRequest, actualRequest);
    }

    //User story 8
    @Test
    public void shouldBeTrueIfRequestForOverdraftHasBeenGranted() {
        SavingsAccount savingsAccount = new SavingsAccount(123, Branch.PERSONAL);
        savingsAccount.makeRequestForOverdraft(100.0);
        savingsAccount.grantOverdraftRequest(true);
        boolean requestForOverdraftIsGranted = savingsAccount.isOverdraftRequestGranted();
        Assertions.assertTrue(requestForOverdraftIsGranted);
    }

    @Test
    public void shouldBeFalseIfRequestForOverdraftHasNotBeenMade() {
        SavingsAccount savingsAccount = new SavingsAccount(123, Branch.PERSONAL);
        savingsAccount.grantOverdraftRequest(true);
        boolean requestForOverdraftIsGranted = savingsAccount.isOverdraftRequestGranted();
        Assertions.assertFalse(requestForOverdraftIsGranted);
    }

    @Test
    public void shouldBeFalseIfOverdraftHasAlreadyBeenMade() {
        SavingsAccount savingsAccount = new SavingsAccount(123, Branch.PERSONAL);
        savingsAccount.makeRequestForOverdraft(100.0);
        savingsAccount.grantOverdraftRequest(true);
        savingsAccount.withdraw(100.0);
        boolean requestForOverdraftIsGranted = savingsAccount.isOverdraftRequestGranted();
        Assertions.assertFalse(requestForOverdraftIsGranted);
    }

}
