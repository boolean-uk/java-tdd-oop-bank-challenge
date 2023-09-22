package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testGetBalanceWorks() {
        Account account = new Account("SA123456", 500.00, "SavingsAccount");

        assertEquals(500.00, account.getBalance());

    }

    @Test
    public void testSetBalanceWorks() {
        Account account = new Account("SA123456", 500.00, "SavingsAccount");

        assertEquals(500.00, account.getBalance());
        account.setBalance(750.00);
        assertEquals(750.00, account.getBalance());
    }

    @Test
    public void testDepositAmountWorks() {
        Account account = new Account("SA123456", 500.00, "SavingsAccount");

        assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertTrue(account.depositAmount(150));
        assertEquals(650.00, account.getBalance(), 0.01);
    }

    @Test
    public void testDepositAmountFails() {
        Account account = new Account("SA123456", 500.00, "SavingsAccount");

        Assertions.assertFalse(account.depositAmount(-10.00));
        assertEquals(500.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawAmountWorks() {
        Account account = new Account("SA123456", 500.00, "SavingsAccount");

        assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertTrue(account.withdrawAmount(150));
        assertEquals(350.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawAmountFails() {
        Account account = new Account("SA123456", 500.00, "SavingsAccount");

        assertEquals(500.00, account.getBalance(), 0.01);
        Assertions.assertFalse(account.withdrawAmount(-10));
        assertEquals(500.00, account.getBalance(), 0.01);
    }

    @Test
    public void testAddTransactionHistory() {
        Account account = new Account("SA123456", 500.00, "SavingsAccount");
        Transaction transaction = new Transaction("15-02-2023", 50.00, 10.00, 500.00);

        Assertions.assertTrue(account.addToTransactionHistory(transaction));
        List<Transaction> transactionHistory = account.getTransactionHistory();
        assertEquals(1, transactionHistory.size());
        assertEquals(transaction, transactionHistory.get(0));
    }

    @Test
    public void testGetTransactionHistoryWorks() {

        Account account = new Account("SA123456", 500.00, "SavingsAccount");
        Transaction transaction = new Transaction("15-02-2023", 50.00, 10.00, 500.00);
        Transaction transactionTwo = new Transaction("16-02-2023", 80.00, 20.00, 560.00);
        //not added to the transactionHistory so shouldn't be found in the history
        Transaction transactionThree = new Transaction("17-02-2023", 50.00, 60.00, 560.00);

        Assertions.assertTrue(account.addToTransactionHistory(transaction));
        Assertions.assertTrue(account.addToTransactionHistory(transactionTwo));

        List<Transaction> transactionHistory = account.getTransactionHistory();

        Assertions.assertTrue(transactionHistory.contains(transaction));
        Assertions.assertTrue(transactionHistory.contains(transactionTwo));
        Assertions.assertFalse(transactionHistory.contains(transactionThree));
    }

    @Test
    public void testGenerateBankStatement(){
        Account account = new Account("SA123456", 500.00, "SavingsAccount");
        Transaction transaction = new Transaction("15-02-2023", 50.00, 10.00, 500.00);
        Transaction transactionTwo = new Transaction("16-02-2023", 80.00, 20.00, 560.00);

        Assertions.assertTrue(account.addToTransactionHistory(transaction));
        Assertions.assertTrue(account.addToTransactionHistory(transactionTwo));

        String bankStatement = account.generateBankStatement();
        String expectedBankStatement= "date       || credit  || debit  || balance\n" +
                "15-02-2023 ||    50,00||   10,00||  500,00\n" +
                "16-02-2023 ||    80,00||   20,00||  560,00\n";

        Assertions.assertEquals(expectedBankStatement, bankStatement);
    }
}
