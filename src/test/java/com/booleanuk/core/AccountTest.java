package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    //User story 4
    @Test
    public void assertAmountIsAddedToBalance() {
        Account account = new Account(123, new BankStatementGenerator());
        double originalBalance = account.getBalance();
        account.deposit(100);
        double newBalance =  account.getBalance();
        Assertions.assertEquals(originalBalance+100, newBalance);
    }
}
