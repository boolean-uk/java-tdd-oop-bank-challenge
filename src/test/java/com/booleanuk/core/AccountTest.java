package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class AccountTest {
    @Test
    public void DepositAndWithdrawalTest(){
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        // Assert that the transaction history is empty
        Assertions.assertTrue(account.getTransactionHistory().isEmpty());

        int deposit = 1337;
        account.deposit(deposit);

        // Get amount in the first transaction in the log.
        int amount = account.getTransactionHistory().getFirst().getAmount();

        // Assert that the sum is registered in the transactions.
        Assertions.assertEquals(deposit, amount);

        int withdrawal = 1000;

        account.withdraw(withdrawal);

        int accountBalance = 0;

        // Compute the leftover in the account.
        for (Transaction t : account.getTransactionHistory()){
            accountBalance += t.getAmount();
        }

        // Assert that the remaining amount is correct
        Assertions.assertEquals(deposit - withdrawal, accountBalance);
    }

    @Test
    public void CalculateCurrentBalanceTest(){
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        // Assert that the transaction history is empty
        Assertions.assertTrue(account.getTransactionHistory().isEmpty());

        int deposit = 1337;
        int deposit2 = 7331;
        int deposit3 = 1234;

        account.deposit(deposit);
        account.deposit(deposit2);
        account.deposit(deposit3);

        int currentBalance = c.getAccounts().getFirst().calculateCurrentBalance();

        Assertions.assertEquals(1337+7331+1234, currentBalance);
    }

    @Test
    public void GenerateBankStatementTest(){
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        int deposit = 20;

        int withdraw = 15;

        account.deposit(deposit);
        account.withdraw(withdraw);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        account.generateBankStatement();

        assert(out.toString().contains("26/08/2024 || 20.00      ||            || 20.00"));
        assert(out.toString().contains("26/08/2024 ||            || 15.00      || 5.00"));
    }

    @Test
    public void RequestOverdraftTest(){
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        Assertions.assertFalse(account.overdraftRequested);

        account.requestOverdraft();

        Assertions.assertTrue(account.overdraftRequested);
    }
}
