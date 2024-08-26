package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class AccountTest {
    @Test
    public void DepositAndWithdrawalTest(){
        /*
        As a customer,
        So I can use my account,
        I want to deposit and withdraw funds.
         */
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
    public void NoOverdraftWithdrawTest(){
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        account.deposit(2000);

        boolean result = account.withdraw(3000);

        // Assert that withdrawal failed.
        Assertions.assertFalse(result);

        // Request and accept overdraft
        account.requestOverdraft();
        account.acceptOverdraftRequest();

        result = account.withdraw(3000);

        // Assert that the transaction was successful.
        Assertions.assertTrue(result);
    }

    @Test
    public void CalculateCurrentBalanceTest(){
        /*
        As an engineer,
        So I don't need to keep track of state,
        I want account balances to be calculated based on
        transaction history instead of stored in memory.
         */
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

        Assertions.assertEquals(1337+7331+1234, c.getAccounts().getFirst().calculateCurrentBalance());
    }

    @Test
    public void GenerateBankStatementTest(){
        /*
        As a customer,
        So I can keep a record of my finances,
        I want to generate bank statements with transaction dates,
        amounts, and balance at the time of transaction.
         */
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
        /*
        As a customer,
        So I have an emergency fund,
        I want to be able to request an overdraft on my account.
         */
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        Assertions.assertFalse(account.overdraftRequested);

        account.requestOverdraft();

        Assertions.assertTrue(account.overdraftRequested);
    }

    @Test
    public void approveOrRejectOverdraftRequestTest(){
        /*
        As a bank manager,
        So I can safeguard our funds,
        I want to approve or reject overdraft requests.
         */
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        account.requestOverdraft();

        // Assert that overdraft has been requested.
        Assertions.assertTrue(account.overdraftRequested);

        account.rejectOverdraftRequest();

        // Assert that account can not be overdrafted.
        Assertions.assertFalse(account.canOverdraft);

        account.acceptOverdraftRequest();

        // Assert that account can be overdrafted.
        Assertions.assertTrue(account.canOverdraft);
    }

    @Test
    public void accountAssociatedWithSpecificBranchTest(){
        /*
        As a bank manager,
        So I can expand,
        I want accounts to be associated with specific branches.
         */
        Customer c = new Customer();
        Branch b = new Branch("Oslo");
        c.createAccount(Customer.AccountType.CURRENT, b);

        Account account = c.getAccounts().getFirst();

        // Assert that branch is associated with account
        Assertions.assertEquals("Oslo", account.getOwnerBranch().getName());
    }
}
