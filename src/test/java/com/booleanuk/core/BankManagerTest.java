package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    @Test
    public void makeABankManagerTest() {
        BankManager bankManager = new BankManager();
        String branch = "Stockholm";
        String typeOfAccount = "currentAccount";
        int id = 0;

        bankManager.addAccount(500, typeOfAccount, branch);

        Assertions.assertEquals(500, bankManager.getCurrentAccountWithIDInBranch(branch,typeOfAccount, id).getBalance());
    }

    @Test
    public void makeASavingAccountTest() {
        BankManager bankManager = new BankManager();
        String branch = "Oslo";
        String typeOfAccount = "savingAccount";
        int id = 0;

        Assertions.assertTrue(bankManager.addAccount(500, typeOfAccount, branch));
        Assertions.assertEquals(500, bankManager.getCurrentAccountWithIDInBranch(branch, typeOfAccount, id).getBalance());
    }

    @Test
    public void makeANewTypeOfAccountTest() {
        BankManager bankManager = new BankManager();
        String branch = "Oslo";
        String typeOfAccount = "funAccount";
        int id = 0;

        Assertions.assertFalse(bankManager.addAccount(500, typeOfAccount, branch));

    }

    @Test
    public void overdraftTest() {
        BankManager bankManager = new BankManager();
        String branch = "Göteborg";
        String typeOfAccount = "currentAccount";
        int id = 0;

        bankManager.addAccount(500, typeOfAccount, branch);

        Account account = bankManager.getCurrentAccountWithIDInBranch(branch, typeOfAccount, id);
        account.withdrawMoney(600);
        Assertions.assertEquals(500, account.getBalance());

        account.setCanOverdraft();
        account.setOverdraftLimit(250);
        account.withdrawMoney(600);
        Assertions.assertEquals(-100, account.getBalance());
        account.withdrawMoney(150);
        Assertions.assertEquals(-250, account.getBalance());
    }

    @Test
    public void multipleOverdraftTest() {
        BankManager bankManager = new BankManager();
        String branch = "Oslo";
        String typeOfAccount = "currentAccount";
        int id = 0;

        bankManager.addAccount(500, "currentAccount", branch);

        Account account = bankManager.getCurrentAccountWithIDInBranch(branch, typeOfAccount, id);

        Assertions.assertTrue(bankManager.withdrawFromAccount(account, 250));
        account.setCanOverdraft();

        Assertions.assertFalse(bankManager.withdrawFromAccount(account, 1000));

        Assertions.assertTrue(bankManager.withdrawFromAccount(account, 250));
        account.setOverdraftLimit(250);
        //Should be under the limit of overdraft and return true
        Assertions.assertTrue(bankManager.withdrawFromAccount(account, 250));
        Assertions.assertFalse(bankManager.withdrawFromAccount(account, 249));

        account.printOutTransactions();

    }
}
