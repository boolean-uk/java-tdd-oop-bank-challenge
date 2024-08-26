package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void CreateCurrentAccountTest(){
        /*
        As a customer,
        So I can safely store and use my money,
        I want to create a current account.
         */
        Customer c = new Customer();

        // Verify that list of accounts is empty
        assert(c.getAccounts().isEmpty());

        // Create account
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        // Verify that list of accounts contains one element
        Assertions.assertEquals(1, c.getAccounts().size());

        // Asserting that account is a current account
        Assertions.assertInstanceOf(CurrentAccount.class, c.getAccounts().getFirst());
    }

    @Test
    public void CreateSavingsAccountTest(){
        /*
        As a customer,
        So I can save for a rainy day,
        I want to create a savings account.
        */

        Customer c = new Customer();

        // Verify that list of accounts is empty
        assert(c.getAccounts().isEmpty());

        // Create account
        c.createAccount(Customer.AccountType.SAVINGS, new Branch("Oslo"));

        // Verify that list of accounts contains one element
        Assertions.assertEquals(1, c.getAccounts().size());

        // Asserting that account is a savings account
        Assertions.assertInstanceOf(SavingsAccount.class, c.getAccounts().getFirst());
    }
}
