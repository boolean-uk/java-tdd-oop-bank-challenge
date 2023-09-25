package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void userCreatesAccountTypes() {
        CurrentAccount currentAccount = new CurrentAccount();
        String banktype1 = currentAccount.getBankType();
        Assertions.assertEquals("current", banktype1);

        SavingsAccount savingsaccount = new SavingsAccount();
        String banktype2 = savingsaccount.getBankType();
        Assertions.assertEquals("savings", banktype2);
    }

    @Test

    public void userAddsMoneyToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(1000.00);
        currentAccount.deposit(400.00);
        double newBalance = currentAccount.balance;
        
        Assertions.assertEquals(1400.00, newBalance);


    }



}
