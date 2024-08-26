package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void CreateCurrentAccountTest(){
        Customer c = new Customer();

        // Verify that list of accounts is empty
        assert(c.accounts.isEmpty());

        // Create account
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        // Verify that list of accounts contains one element
        Assertions.assertEquals(1, c.accounts.size());

        // Asserting that account is a current account
        Assertions.assertInstanceOf(CurrentAccount.class, c.accounts.getFirst());
    }

    @Test
    public void CreateSavingsAccountTest(){
        Customer c = new Customer();

        // Verify that list of accounts is empty
        assert(c.accounts.isEmpty());

        // Create account
        c.createAccount(Customer.AccountType.SAVINGS, new Branch("Oslo"));

        // Verify that list of accounts contains one element
        Assertions.assertEquals(1, c.accounts.size());

        // Asserting that account is a savings account
        Assertions.assertInstanceOf(CurrentAccount.class, c.accounts.getFirst());
    }
}
