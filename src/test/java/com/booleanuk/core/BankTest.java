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

    @Test
    public void customerWithNonExistentAccountIdTriesToDepositTest() {
        String expected = "Account doesn't exist.";
        bank.createCurrentAccount(customer);
        Assertions.assertEquals(0, bank.getAccounts(customer).get(0).getBalance());
        Assertions.assertEquals(expected, bank.deposit(2, customer, 123));
        Assertions.assertEquals(0, bank.getAccounts(customer).get(0).getBalance());
    }

    @Test
    public void customerSuccessfullyTriesToDepositTest() {
        String expected = "The deposit has been performed.";
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals(0, bank.getAccounts(customer).get(0).getBalance());
        Assertions.assertEquals(expected, bank.deposit(2, customer, accountId));
        Assertions.assertEquals(2, bank.getAccounts(customer).get(0).getBalance());
    }

    @Test
    public void nonExistentCustomerTriesToWithdrawTest() {
        String expected = "Customer doesn't exist.";
        Assertions.assertEquals(expected, bank.withdraw(2, customer, 123));
    }


}
