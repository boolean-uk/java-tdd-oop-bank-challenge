package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    //User story 1
    @Test
    public void assertCurrentAccountWasCreated() {
        int accountId = 123;
        CurrentAccount currentAccount = new CurrentAccount(accountId, Branch.PERSONAL);
        Assertions.assertEquals(accountId, currentAccount.getAccountId());
        Assertions.assertEquals(0.0, currentAccount.getBalance());
    }

    //User story 4
    @Test
    public void assertAmountIsSubtractedFromBalance() {
        CurrentAccount currentAccount = new CurrentAccount(123, Branch.PERSONAL);
        double originalBalance = currentAccount.getBalance();
        currentAccount.withdraw(100);
        double newBalance = currentAccount.getBalance();
        Assertions.assertEquals(originalBalance-100, newBalance);
    }
}
