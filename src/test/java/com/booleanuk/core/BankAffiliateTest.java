package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankAffiliateTest {

    //User Story 1 Test - Case 1: Current account is not already created
    @Test
    public void testCurrentAccountCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Current Account", "Oslo", 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean currentAccountCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertTrue(currentAccountCreated);
    }

    //User Story 1 Test - Case 2: Current account is already created
    @Test
    public void testCurrentAccountAlreadyCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Current Account", "Oslo", 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean currentAccountAlreadyCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertFalse(currentAccountAlreadyCreated);
    }

    //User Story 2 Test - Case 1: Savings account is not already created
    @Test
    public void testSavingsAccountCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", "Oslo", 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean savingsAccountCreated = bankAffiliate.createSavingsAccount(bankAccount);

        Assertions.assertTrue(savingsAccountCreated);
    }

    //User Story 2 Test - Case 2: Savings account is already created
    @Test
    public void testSavingsAccountAlreadyCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", "Oslo", 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean savingsAccountCreated = bankAffiliate.createSavingsAccount(bankAccount);

        Assertions.assertFalse(savingsAccountCreated);
    }

    //User Story 4 Test - Case 1: Withdraw funds
    @Test
    public void testWithdrawFunds() {
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", "Oslo", 500.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        double result = bankAffiliate.withdrawFunds(bankAccount, 100.00);

        Assertions.assertEquals(400.00, result);

    }

    //User Story 4 Test - Case 2: Deposit funds
    @Test
    public void testDepositFunds() {
        BankAccount bankAccount = new  BankAccount("James Bond", "54321", "Savings Account", "Oslo", 500.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        double result = bankAffiliate.depositFunds(bankAccount, 100.00);

        Assertions.assertEquals(600.00, result);
    }
}
