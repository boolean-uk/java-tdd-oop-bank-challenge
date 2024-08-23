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

    MainTest() {
        this.bank = new Bank();
        this.stockholmBranch = new Branch("Stockholm");
        this.lundBranch = new Branch("individualBranch");
        this.savingsAccount = new SavingsAccount("12345", lundBranch);

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
        Assertions.assertEquals(1, costumer.getAccountsForCostumer().size());
        lundBranch.createSavingsAccount(costumer, deposit);
        Assertions.assertEquals(1, costumer.getAccountsForCostumer().size());
    }

    @Test
    public void testAddAccountToBranchCurrentAccount() {
        int deposit = 500;
        stockholmBranch.createSavingsAccount(costumer,deposit);
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
    public void testDeposit() {
        savingsAccount.deposit(500);
        Assertions.assertEquals(1, savingsAccount.getTransactions().size());

        ArrayList<Transaction> transactions = savingsAccount.getTransactions();
        Transaction transaction = transactions.get(0);
        Assertions.assertEquals(500, transaction.getAmount());

    }

    @Test
    public void testWithdraw() {
        savingsAccount.deposit(500);
        ArrayList<Transaction> transactions = savingsAccount.getTransactions();
        Transaction transaction = transactions.get(0);
        Assertions.assertEquals(500, transaction.getAmount());

        savingsAccount.withdraw(500);
        Transaction transaction1 = transactions.get(1);
        Assertions.assertEquals(500,transaction.getAmount());
        Assertions.assertFalse(transaction1.getIsCredit());


    }
}


