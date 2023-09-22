package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    void currentAccountCreationTest() {
        CurrentAccount currentAccount = new CurrentAccount("0001");
        AccountsList accountsList = new AccountsList();
        Assertions.assertTrue(currentAccount.getAccountId().length() == 8);
        Assertions.assertTrue(accountsList.addAccount(currentAccount));
    }

    @Test
    void savingsAccountCreationTest() {
        SavingsAccount savingsAccount = new SavingsAccount("0002");
        AccountsList accountsList = new AccountsList();
        Assertions.assertTrue(savingsAccount.getAccountId().length() == 8);
        Assertions.assertTrue(accountsList.addAccount(savingsAccount));
    }

    @Test
    void DepositTest() {
        CurrentAccount account = new CurrentAccount("0001");
        Assertions.assertTrue(account.deposit(100.20));
        Assertions.assertEquals(100.20d,account.getBalance());
        account.deposit(49.8d);
        Assertions.assertEquals(150.00d,account.getBalance());
    }

}
