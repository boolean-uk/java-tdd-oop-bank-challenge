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

    @Test
    public void customerWithNonExistentAccountIdTriesToWithdrawTest() {
        String expected = "Account doesn't exist.";
        bank.createCurrentAccount(customer);
        Assertions.assertEquals(0, bank.getAccounts(customer).get(0).getBalance());
        Assertions.assertEquals(expected, bank.withdraw(2, customer, 123));
        Assertions.assertEquals(0, bank.getAccounts(customer).get(0).getBalance());
    }

    @Test
    public void customerSuccessfullyTriesToWithdrawTest() {
        String expected = "The withdraw has been performed.";
        int accountId = bank.createCurrentAccount(customer);
        bank.deposit(22.342, customer, accountId);
        Assertions.assertEquals(22.342, bank.getAccounts(customer).get(0).getBalance());
        Assertions.assertEquals(expected, bank.withdraw(2.234673, customer, accountId));
        Assertions.assertEquals(22.342-2.234673, bank.getAccounts(customer).get(0).getBalance());
    }

    @Test
    public void customerTriesToWithdrawMoreThanTheAccountsBalanceTest() {
        String expected = "The withdrawal could not be performed. The balance is too low.";
        int accountId = bank.createCurrentAccount(customer);
        bank.deposit(22.342, customer, accountId);
        Assertions.assertEquals(22.342, bank.getAccounts(customer).get(0).getBalance());
        Assertions.assertEquals(expected, bank.withdraw(22.434673, customer, accountId));
        Assertions.assertEquals(22.342, bank.getAccounts(customer).get(0).getBalance());
    }

    @Test
    public void nonExistentCustomerTriesToGenerateBankStatementsTest() {
        String expected = "Customer doesn't exist.";
        Assertions.assertEquals(expected, bank.generateBankStatements(customer, 123));
    }

    @Test
    public void customerWithNonExistentAccountIdTriesGenerateBankStatementsTest() {
        String expected = "Account doesn't exist.";
        bank.createCurrentAccount(customer);
        Assertions.assertEquals(expected,  bank.generateBankStatements(customer, 123));
    }

    @Test
    public void customerSuccessfullyGenerateBankStatementsTest() {
        String expected =
                        "date       || credit  || debit  || balance\n" +
                        "25/01/2024 ||         || 500.00 || 2500.00\n" +
                        "25/01/2024 || 2000.00 ||        || 3000.00\n" +
                        "25/01/2024 || 1000.00 ||        || 1000.00";

        int accountId = bank.createCurrentAccount(customer);
        bank.deposit(1000, customer, accountId);
        bank.deposit(2000, customer, accountId);
        bank.withdraw(500, customer, accountId);

        Assertions.assertEquals(expected, bank.generateBankStatements(customer, accountId));
    }

}
