package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.ColorUIResource;

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
        CurrentAccount account1 = new CurrentAccount("0001");
        Assertions.assertTrue(account1.deposit(100.20d));
        Assertions.assertEquals(100.20d,account1.getBalance());
        Assertions.assertTrue(account1.deposit(49.8d));
        Assertions.assertEquals(150d,account1.getBalance());
    }

    @Test
    void withdrawTest() {
        CurrentAccount account = new CurrentAccount("0002");
        account.deposit(100.00d);
        Assertions.assertTrue(account.withdraw(50.00d));
        CurrentAccount account1 = new CurrentAccount("0003");
        Assertions.assertFalse(account1.withdraw(10.00d));
    }

    @Test
    void amoundCalculatedByStatementsTest() {
        CurrentAccount account = new CurrentAccount("0002");
        account.deposit(500.00d);
        account.withdraw(100.00d);
        account.withdraw(0.51);
        Assertions.assertEquals(399.49d,account.getBalance());
    }

}
