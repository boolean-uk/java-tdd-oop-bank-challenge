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
        BankAccount bankAccount = new  BankAccount("James Bond", "12345", "Current", "Oslo", 0.00);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer", bankAccount);

        boolean currentAccountNotCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertFalse(currentAccountNotCreated);
    }
}
