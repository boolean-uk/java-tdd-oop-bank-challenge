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

    



}
