package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BankTest {

    Bank bank = new Bank();
    Customer customer = new Customer("Bob Bagel", 1234);

    @Test
    public void createCurrentAccountTest() {
        ArrayList<Account> accounts = bank.getAccounts(customer);
        Assertions.assertNull(accounts);
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals(accountId, bank.getAccounts(customer).get(0).getId());
    }

    @Test
    public void createCurrentAndSavingsAccountTest() {
        ArrayList<Account> accounts = bank.getAccounts(customer);
        Assertions.assertNull(accounts);
        int currentAccountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals(currentAccountId, bank.getAccounts(customer).get(0).getId());
        int savingsAccountId = bank.createSavingsAccount(customer);
        Assertions.assertEquals(currentAccountId, bank.getAccounts(customer).get(0).getId());
        Assertions.assertEquals(savingsAccountId, bank.getAccounts(customer).get(1).getId());
        Assertions.assertNotEquals(currentAccountId, savingsAccountId);
    }

    @Test
    public void nonExistentCustomerTriesToDepositTest() {
        String expected = "Customer doesn't exist.";
        Assertions.assertEquals(expected, bank.deposit(2, customer, 123));
    }

}
