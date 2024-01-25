package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankAffiliateTest {

    @Test
    public void testCurrentAccountCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Current Account", "Oslo", 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean currentAccountCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertTrue(currentAccountCreated);
    }

    @Test
    public void testCurrentAccountAlreadyCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Current Account", "Oslo", 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean currentAccountAlreadyCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertFalse(currentAccountAlreadyCreated);
    }

    @Test
    public void testSavingsAccountCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Savings Account", "Oslo", 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean savingsAccountCreated = bankAffiliate.createSavingsAccount(bankAccount);

        Assertions.assertTrue(savingsAccountCreated);
    }

    @Test
    public void testSavingsAccountNotCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Savings Account", "Oslo", 0.00);

        ArrayList<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(bankAccount);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccountList);

        boolean savingsAccountCreated = bankAffiliate.createSavingsAccount(bankAccount);

        Assertions.assertFalse(savingsAccountCreated);
    }
}
