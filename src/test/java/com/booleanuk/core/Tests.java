package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    void accountCreationTest() {
        CurrentAccount currentAccount = new CurrentAccount("0001");
        Assertions.assertTrue(currentAccount.getAccountId().length() == 8);
        SavingsAccount savingsAccount = new SavingsAccount("0002");
        Assertions.assertTrue(savingsAccount.getAccountId().length() == 8);
        AccountsList accountsList = new AccountsList();
        Assertions.assertTrue(accountsList.addAccount(currentAccount));
        Assertions.assertTrue(accountsList.addAccount(savingsAccount));
    }
}
