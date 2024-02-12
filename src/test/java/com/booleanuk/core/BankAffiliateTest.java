package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankAffiliateTest {

    //User Story 1 Test - Case 1: Current account is not already created
    @Test
    public void testCurrentAccountCreated() {
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount bankAccount = new BankAccount("James Bond", "12345", "Current Account", branch, 0.00,0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean currentAccountCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertTrue(currentAccountCreated);
    }

    //User Story 1 Test - Case 2: Current account is already created
    @Test
    public void testCurrentAccountAlreadyCreated() {
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Current Account", branch, 1000, 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean currentAccountAlreadyCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertFalse(currentAccountAlreadyCreated);
    }

    //User Story 2 Test - Case 1: Savings account is not already created
    @Test
    public void testSavingsAccountCreated() {
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", branch, 1000, 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean savingsAccountCreated = bankAffiliate.createSavingsAccount(bankAccount);

        Assertions.assertTrue(savingsAccountCreated);
    }

    //User Story 2 Test - Case 2: Savings account is already created
    @Test
    public void testSavingsAccountAlreadyCreated() {
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", branch,1000, 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean savingsAccountCreated = bankAffiliate.createSavingsAccount(bankAccount);

        Assertions.assertFalse(savingsAccountCreated);
    }

    //Extension User Story 1 Test

    @Test
    public void testGetBalanceWithMultipleTransactions() {
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", branch, 1000.00,0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        // Perform a series of transactions
        bankAffiliate.depositFunds(bankAccount, 1000.0); // Balance: $1000
        bankAffiliate.withdrawFunds(bankAccount, 200.0);  // Balance: $800
        bankAffiliate.depositFunds(bankAccount, 300.0);   // Balance: $1100
        bankAffiliate.withdrawFunds(bankAccount, 100.0);  // Balance: $1000

        // Directly test getBalance
        double expectedBalance = 1000.0;
        Assertions.assertEquals(expectedBalance, bankAccount.getBalance());
    }


    //User Story 4 Test - Case 1: Withdraw funds  and //Extension User Story 1 Test
    @Test
    public void testWithdrawFunds() {
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", branch, 1000.00,1000.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        bankAffiliate.withdrawFunds(bankAccount, 100.00);

        double expectedBalance = 900.00;

        Assertions.assertEquals(expectedBalance, bankAccount.getBalance());

    }

    //User Story 4 Test - Case 2: Deposit funds and //Extension User Story 1 Test
    @Test
    public void testDepositFunds() {
        BankBranch branch = new BankBranch("12345", "Oslo", "Oslo");
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", branch, 1000.00,900.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        bankAffiliate.depositFunds(bankAccount, 100.00);

        double expectedBalance = 1000.00;

        Assertions.assertEquals(expectedBalance, bankAccount.getBalance());

    }
}
