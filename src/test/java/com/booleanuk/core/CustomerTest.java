package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    Customer customer;

    @BeforeEach
    public void dummyData() {
        customer = new Customer("Perrin Aybara");

    }

    @Test
    public void createAccountTest() {
        Assertions.assertTrue(customer.getAccounts().isEmpty());
        customer.createAccount(AccountType.SAVINGS, "Savings Account");
        customer.createAccount(AccountType.CURRENT, "Current Account");
        Assertions.assertFalse(customer.getAccounts().isEmpty());
        Assertions.assertInstanceOf(SavingsAccount.class, customer.getAccounts().get(0));
        Assertions.assertInstanceOf(CurrentAccount.class, customer.getAccounts().get(1));

    }
}
