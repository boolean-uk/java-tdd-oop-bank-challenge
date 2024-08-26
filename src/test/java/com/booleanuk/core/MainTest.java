package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainTest {

    Bank bank;
    Branch stockholmBranch;
    Branch lundBranch;
    Costumer costumer = new Costumer("Individual");
    SavingsAccount savingsAccount;
    CurrentAccount currentAccount;
    Manager manager;

    MainTest() {
        this.bank = new Bank();
        this.stockholmBranch = new Branch("Stockholm");
        this.lundBranch = new Branch("individualBranch");
        this.savingsAccount = new SavingsAccount("12345", lundBranch);
        this.currentAccount = new CurrentAccount("12345", lundBranch);
        this.manager = new Manager(lundBranch);

    }

    @Test
    public void testAddBranch() {
        bank.addBranch(stockholmBranch);
        bank.addBranch(lundBranch);
        Assertions.assertEquals(2, bank.getSizeOfBranch());
    }

    @Test
    public void testAddAccountToBranchSavingsAccount() {
        int deposit = 500;
        stockholmBranch.createSavingsAccount(costumer,deposit);
        Assertions.assertEquals(1, stockholmBranch.getAccountsForBranch().size());
        lundBranch.createSavingsAccount(costumer,deposit);
        Assertions.assertEquals(1, lundBranch.getAccountsForBranch().size());
    }

    @Test
    public void testAddAccountToCostumerSavingsAccount() {
        int deposit = 500;
        stockholmBranch.createSavingsAccount(costumer, deposit);
        Assertions.assertEquals(1, stockholmBranch.getAccountsForBranch().size());

        lundBranch.createSavingsAccount(costumer, deposit);
        Assertions.assertEquals(1, lundBranch.getAccountsForBranch().size());
    }

    @Test
    public void testAddAccountToBranchCurrentAccount() {
        int deposit = 500;
        stockholmBranch.createCurrentAccount(costumer);
        Assertions.assertEquals(1, stockholmBranch.getAccountsForBranch().size());

        lundBranch.createCurrentAccount(costumer);
        Assertions.assertEquals(1, lundBranch.getAccountsForBranch().size());
    }

    @Test
    public void testAddAccountToCostumerCurrentAccount() {
        stockholmBranch.createCurrentAccount(costumer);
        Assertions.assertEquals(1, costumer.getAccountsForCostumer().size());

        lundBranch.createCurrentAccount(costumer);
        Assertions.assertEquals(2, costumer.getAccountsForCostumer().size());
    }

    @Test
    public void testDepositSavingsAccount() {
        savingsAccount.deposit(500);
        Assertions.assertEquals(1, savingsAccount.getTransactions().size());

        ArrayList<Transaction> transactions = savingsAccount.getTransactions();
        Transaction transaction = transactions.get(0);
        Assertions.assertEquals(500, transaction.getAmount());

    }

    @Test
    public void testWithdrawSavingsAccount() {
        savingsAccount.deposit(500);
        ArrayList<Transaction> transactions = savingsAccount.getTransactions();
        Transaction transaction = transactions.get(0);
        Assertions.assertEquals(500, transaction.getAmount());

        savingsAccount.withdraw(500);
        Transaction transaction1 = transactions.get(1);
        Assertions.assertEquals(500,transaction.getAmount());
        Assertions.assertFalse(transaction1.getIsCredit());

    }

    @Test
    public void testDepositCurrentAccount() {
        currentAccount.deposit(500);
        Assertions.assertEquals(1, currentAccount.getTransactions().size());

        ArrayList<Transaction> transactions = currentAccount.getTransactions();
        Transaction transaction = transactions.get(0);
        Assertions.assertEquals(500, transaction.getAmount());

    }

    @Test
    public void testWithdrawCurrentAccount() {
        currentAccount.deposit(500);
        ArrayList<Transaction> transactions = currentAccount.getTransactions();
        Transaction transaction = transactions.get(0);
        Assertions.assertEquals(500, transaction.getAmount());

        currentAccount.withdraw(500);
        Transaction transaction1 = transactions.get(1);
        Assertions.assertEquals(500,transaction.getAmount());
        Assertions.assertFalse(transaction1.getIsCredit());

    }

    @Test
    public void testGetBalance() {
        currentAccount.deposit(500);
        Assertions.assertEquals(500, currentAccount.getBalance());
        currentAccount.withdraw(200);
        Assertions.assertEquals(300, currentAccount.getBalance());
    }

    @Test
    public void testRequestOverDraft() {
        Assertions.assertTrue(currentAccount.requestOverDraft(manager, 500));
        Assertions.assertFalse(currentAccount.requestOverDraft(manager, 1001));

    }

    @Test
    public void testPrintStatement() {
        currentAccount.deposit(500);
        currentAccount.withdraw(100);
        currentAccount.withdraw(200);
        currentAccount.printStatement();
    }
}


