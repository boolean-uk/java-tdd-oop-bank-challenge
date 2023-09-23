package com.booleanuk.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BankTests {
    private Client client;
    private Account currentAccount;
    private Account savingsAccount;
    private Branch branch;

    @BeforeEach
    public void setUp() {
        client = new Client("John Doe", "123-456-7890");
        currentAccount = new Account(AccountType.Current);
        savingsAccount = new Account(AccountType.Savings);
        branch = new Branch("Main Branch");
    }

    @Test
    public void testCustomerCanCreateCurrentAccount() {
        client.createAccount(currentAccount);
        assertEquals(currentAccount, client.getAccounts().get(0));
    }

    @Test
    public void testCustomerCanCreateSavingsAccount() {
        client.createAccount(savingsAccount);
        assertEquals(savingsAccount, client.getAccounts().get(0));
    }

    @Test
    public void testCustomerCanRequestOverdraft() {
        client.createAccount(currentAccount);
        assertTrue(client.requestOverdraft(currentAccount, 1000.0));
    }

    @Test
    public void testCustomerCannotRequestOverdraftForSavingsAccount() {
        client.createAccount(savingsAccount);
        assertFalse(client.requestOverdraft(savingsAccount, 1000.0));
    }

    @Test
    public void testDepositFundsIntoAccount() {
        currentAccount.deposit(new BigDecimal("1000.00"));
        assertEquals(new BigDecimal("1000.00"), currentAccount.getBalance());
    }

    @Test
    public void testWithdrawFundsFromAccount() {
        currentAccount.deposit(new BigDecimal("1000.00"));
        currentAccount.withdraw(new BigDecimal("500.00"));
        assertEquals(new BigDecimal("500.00"), currentAccount.getBalance());
    }

    @Test
    public void testCalculateBalanceBasedOnTransactionHistory() {
        currentAccount.deposit(new BigDecimal("1000.00"));
        currentAccount.withdraw(new BigDecimal("500.00"));
        currentAccount.deposit(new BigDecimal("200.00"));
        assertEquals(new BigDecimal("700.00"), currentAccount.calculateBalance());
    }

    @Test
    public void testGenerateBankStatementWithTransactionDetails() {
        currentAccount.deposit(new BigDecimal("1000.00"));
        currentAccount.withdraw(new BigDecimal("500.00"));
        Statement statement = currentAccount.generateStatement();
        assertNotNull(statement);
        // ... add assertions for statement content
    }

    @Test
    public void testGenerateBankStatementWithNoTransactionHistory() {
        Statement statement = currentAccount.generateStatement();
        assertNotNull(statement);
        // add assertions for empty statement
    }

    @Test
    public void testBranchCreation() {
        assertNotNull(branch);
    }

    @Test
    public void testAssociatingAccountWithBranch() {
        branch.associateAccount(currentAccount);
        assertTrue(branch.getAccounts().contains(currentAccount));
    }

}
