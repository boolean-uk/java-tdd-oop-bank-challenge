package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAffiliateTest {

    @Test
    public void testCurrentAccountCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "", "Oslo", 0.00);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccount);

        boolean currentAccountCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertTrue(currentAccountCreated);
    }

    @Test
    public void testCurrentAccountNotCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Current Account", "Oslo", 0.00);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccount);

        boolean currentAccountNotCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertFalse(currentAccountNotCreated);
    }

    @Test
    public void testSavingsAccountCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "", "Oslo", 0.00);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccount);

        boolean savingsAccountCreated = bankAffiliate.createSavingsAccount(bankAccount);

        Assertions.assertTrue(savingsAccountCreated);
    }

    @Test
    public void testSavingsAccountNotCreated() {
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Savings Account", "Oslo", 0.00);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccount);

        boolean currentAccountNotCreated = bankAffiliate.createSavingsAccount(bankAccount);

        Assertions.assertFalse(currentAccountNotCreated);
    }
}
