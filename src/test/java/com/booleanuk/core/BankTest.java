package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void testGetBalance() {
        Account account = new Account("AA123456", 100.00, "SavingsAccount");

        assertEquals(100.00, account.getBalance());

    }

    @Test
    public void testSetBalance() {
        Account account = new Account("AA123456", 100.00, "SavingsAccount");

        assertEquals(100.00, account.getBalance());
        account.setBalance(200.00);
        assertEquals(200.00, account.getBalance());
    }

    @Test
    public void testDeposit() {
        Account account = new Account("AA123456", 100.00, "SavingsAccount");

        assertEquals(100.00, account.getBalance());
        Assertions.assertTrue(account.deposit(100));
        assertEquals(200.00, account.getBalance());
    }

    @Test
    public void testWithdrawSuccessful() {
        Account account = new Account("AA123456", 100.00, "SavingsAccount");

        assertEquals(100.00, account.getBalance());
        Assertions.assertTrue(account.withdraw(50));
        assertEquals(50.00, account.getBalance());
    }

    @Test
    public void testWithdrawFails() {
        Account account = new Account("AA123456", 100.00, "SavingsAccount");

        assertEquals(100.00, account.getBalance());
        Assertions.assertTrue(account.withdraw(50));
        assertEquals(50.00, account.getBalance());
        Assertions.assertFalse(account.withdraw(100.00));
        assertEquals(50.00, account.getBalance(), 0.01);
    }

    @Test
    public void testCreateSavingsAccount() {
        Bank bank = new Bank();

        Assertions.assertTrue(bank.createAccount("AA123456", 100.00, "SavingsAccount"));
        Assertions.assertEquals("SavingsAccount", bank.getAccountType("AA123456"));
    }

    @Test
    public void testCreateCheckingsAccount() {
        Bank bank = new Bank();

        Assertions.assertTrue(bank.createAccount("AA123456", 100.00, "CheckingsAccount"));
        Assertions.assertEquals("CheckingsAccount", bank.getAccountType("AA123456"));
    }

    @Test
    public void testSetDateWorks() {
        Transaction transaction = new Transaction("01-01-2000", 100.00, 100.00, 1000.00);

        Assertions.assertEquals("01-01-2000", transaction.getDate());
        transaction.setDate("01-10-2023");
        Assertions.assertEquals("01-10-2023", transaction.getDate());

    }

    @Test
    public void testBankStatement() {
        Bank bank = new Bank();

        CheckingsAccount checkingsAccount = new CheckingsAccount("AA123456", 0, "checkingsAccount");

        checkingsAccount.deposit(100);
        checkingsAccount.withdraw(50);

        checkingsAccount.bankStatement(checkingsAccount);
    }

}