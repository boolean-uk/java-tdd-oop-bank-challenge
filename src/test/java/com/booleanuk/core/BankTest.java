package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public void customerSuccessfullyTriesToWithdrawFromCurrentAccountTest() {
        String expected = "The withdrawal has been performed.";
        int accountId = bank.createCurrentAccount(customer);
        bank.deposit(22.342, customer, accountId);
        Assertions.assertEquals(22.342, bank.getAccounts(customer).get(0).getBalance());
        Assertions.assertEquals(expected, bank.withdraw(2.234673, customer, accountId));
        Assertions.assertEquals(22.342-2.234673, bank.getAccounts(customer).get(0).getBalance());
    }


    @Test
    public void customerSuccessfullyTriesToWithdrawFromSavingsAccountTest() {
        String expected = "The withdrawal has been performed.";
        int accountId = bank.createSavingsAccount(customer);
        bank.deposit(22.342, customer, accountId);
        Assertions.assertEquals(22.342, bank.getAccounts(customer).get(0).getBalance());
        Assertions.assertEquals(expected, bank.withdraw(2.234673, customer, accountId));
        Assertions.assertEquals(22.342-2.234673, bank.getAccounts(customer).get(0).getBalance());
    }

    @Test
    public void customerTriesToWithdrawsMoreThanTheirBalanceFromSavingsAccountTest() {
        String expected = "The withdrawal could not be performed.";
        int accountId = bank.createSavingsAccount(customer);
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
                        new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + " ||         || 500.00 || 2500.00\n" +
                        new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + " || 2000.00 ||        || 3000.00\n" +
                        new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + " || 1000.00 ||        || 1000.00";

        int accountId = bank.createCurrentAccount(customer);
        bank.deposit(1000, customer, accountId);
        bank.deposit(2000, customer, accountId);
        bank.withdraw(500, customer, accountId);

        Assertions.assertEquals(expected, bank.generateBankStatements(customer, accountId));
    }

    @Test
    public void nonExistentCustomerRequestsOverdraft() {
        Assertions.assertEquals("Customer doesn't exist.", bank.requestsOverdraft(customer, 123, 200));
    }

    @Test
    public void customerWithNonExistentAccountRequestsOverdraft() {
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals("Account doesn't exist.", bank.requestsOverdraft(customer, 123, 200));
    }

    @Test
    public void customerTriesToRequestsOverdraftForSavingsAccount() {
        int accountId = bank.createSavingsAccount(customer);
        Assertions.assertEquals("You can't have an overdraft on a savings account." , bank.requestsOverdraft(customer, accountId, 200));
    }

    @Test
    public void customerMakesValidOverdraftRequest() {
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals("Your request has been sent." , bank.requestsOverdraft(customer, accountId, 200));
    }

    @Test
    public void customerGetsOverdraftRequestApprovedTest() {
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals("Your request has been sent." , bank.requestsOverdraft(customer, accountId, 200));
        Assertions.assertEquals("The withdrawal could not be performed.", bank.withdraw(200, customer, accountId));
        bank.approveAllOverdraftRequest();
        Assertions.assertEquals("The withdrawal has been performed." , bank.withdraw(200, customer, accountId));
        Assertions.assertEquals(-200, bank.getAccounts(customer).get(0).getBalance());
    }

    @Test
    public void customerRequestsOverdraftThatIsAlreadyApprovedTest() {
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals("Your request has been sent." , bank.requestsOverdraft(customer, accountId, 200));
        bank.approveAllOverdraftRequest();
        Assertions.assertEquals("You already have an approved overdraft for this account and amount." , bank.requestsOverdraft(customer, accountId, 200));
        Assertions.assertEquals("You already have an approved overdraft for this account and amount." , bank.requestsOverdraft(customer, accountId, 150));

    }

    @Test
    public void overdraftRequestTest() {
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals("Your request has been sent." , bank.requestsOverdraft(customer, accountId, 200));
        Assertions.assertEquals("The withdrawal could not be performed.", bank.withdraw(200, customer, accountId));
        bank.approveAllOverdraftRequest();
        Assertions.assertEquals("The withdrawal has been performed." , bank.withdraw(200, customer, accountId));
        Assertions.assertEquals(-200, bank.getAccounts(customer).get(0).getBalance());
        Assertions.assertEquals("Your request has been sent." , bank.requestsOverdraft(customer, accountId, 700));
        Assertions.assertEquals("The withdrawal could not be performed.", bank.withdraw(200, customer, accountId));
        bank.approveAllOverdraftRequest();
        Assertions.assertEquals("The withdrawal has been performed." , bank.withdraw(200, customer, accountId));

    }

    @Test
    public void customerGetsOverdraftRequestManuallyApprovedTest() {
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals("Your request has been sent." , bank.requestsOverdraft(customer, accountId, 200));
        Assertions.assertEquals("The withdrawal could not be performed.", bank.withdraw(200, customer, accountId));
        bank.approveOverdraftRequest(customer, accountId, 200);
        Assertions.assertEquals("The withdrawal has been performed." , bank.withdraw(200, customer, accountId));
        Assertions.assertEquals(-200, bank.getAccounts(customer).get(0).getBalance());
    }

    @Test
    public void customerGetsOverdraftRequestRejectedTest() {
        int accountId = bank.createCurrentAccount(customer);
        Assertions.assertEquals("Your request has been sent." , bank.requestsOverdraft(customer, accountId, 200));
        Assertions.assertEquals("The withdrawal could not be performed.", bank.withdraw(200, customer, accountId));
        bank.rejectOverdraftRequest(customer, accountId, 200);
        Assertions.assertEquals("The withdrawal could not be performed." , bank.withdraw(200, customer, accountId));
        Assertions.assertEquals(0, bank.getAccounts(customer).get(0).getBalance());
    }
}
