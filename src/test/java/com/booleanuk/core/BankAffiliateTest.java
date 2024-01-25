package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAffiliateTest {

    @Test
    public testCurrentAccountCreated() {
        BankAffiliate bankAffiliate = new BankAffiliate();

        BankAccount bankAccount = new  BankAccount();

        boolean currentAccountCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertTrue(currentAccountCreated);
    }

    @Test
    public testCurrentAccountNotCreated() {
        BankAffiliate bankAffiliate = new BankAffiliate();

        BankAccount bankAccount = new  BankAccount();

        boolean currentAccountNotCreated = bankAffiliate.createCurrentAccount(bankAccount);

        Assertions.assertFalse(currentAccountNotCreated);
    }
}
