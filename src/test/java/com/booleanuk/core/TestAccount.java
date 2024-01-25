package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class TestAccount {

    private Branch mockBranch;

    @BeforeEach
    public void setup() {
        // Create a mock branch for testing
        mockBranch = new Branch("Mock Branch", "123 Mock Street");
    }

    @Test
    public void testInitialAccountSetup() {
        Account account = new Account("Saving Account", 1000.0, mockBranch);
        double balance = account.calculateBalance();
        Assertions.assertEquals(1000.0, balance, "Initial balance should be 1000.0");
    }

    @Test
    public void testAddingTransactions() {
        Account account = new Account("Saving Account", 1000.0, mockBranch);
        account.addTransaction(new Transaction(LocalDateTime.now(), 200.0, 1200.0, "Credit"));
        account.addTransaction(new Transaction(LocalDateTime.now(), 100.0, 1100.0, "Debit"));

        List<Transaction> transactions = account.getTransactionHistory();
        Assertions.assertEquals(3, transactions.size(), "There should be 3 transactions in total");
    }

    @Test
    public void testBalanceCalculation() {
        Account account = new Account("Saving Account", 1000.0, mockBranch);
        account.addTransaction(new Transaction(LocalDateTime.now(), 200.0, 1200.0, "Credit"));
        account.addTransaction(new Transaction(LocalDateTime.now(), 100.0, 1100.0, "Debit"));

        double balance = account.calculateBalance();
        Assertions.assertEquals(1100.0, balance, "Balance should be 1100.0 after transactions");
    }

    @Test
    public void testTransactionHistory() {
        Account account = new Account("Saving Account", 1000.0, mockBranch);
        Transaction transaction1 = new Transaction(LocalDateTime.now(), 200.0, 1200.0, "Credit");
        Transaction transaction2 = new Transaction(LocalDateTime.now(), 100.0, 1100.0, "Debit");
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);

        List<Transaction> transactions = account.getTransactionHistory();
        Assertions.assertTrue(transactions.contains(transaction1) && transactions.contains(transaction2),
                "Transaction history should contain all transactions");
    }
}
