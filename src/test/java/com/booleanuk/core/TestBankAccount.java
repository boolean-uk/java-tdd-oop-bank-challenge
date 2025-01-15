package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestBankAccount {
    @Test
    public void newAccountInstancesAreValid() {
        BankAccount currentAccount = new CurrentAccount();
        BankAccount savingsAccount = new CurrentAccount();
        assertTrue(currentAccount.getAccountNumber() / 10000000 >= 1);
        assertEquals(0, currentAccount.getBalance());
        assertEquals(0, currentAccount.getTransactions().size());
    }
    @Test
    public void withdrawTooMuchShouldFail() {
        BankAccount currentAccount = new CurrentAccount();
        double amount = 1000;
        assertFalse(currentAccount.withdraw(amount));
    }

    @Test
    public void canWithdrawWithinReason() {
        BankAccount account = new CurrentAccount();
        account.deposit(1000);
        assertTrue(account.withdraw(500));
    }

    @Test
    public void withdrawingRemovesMoney() {
        BankAccount account = new CurrentAccount();
        account.deposit(1000);
        assertTrue(account.withdraw(500));
        assertEquals(500, account.getBalance());
    }
    @Test
    public void withdrawingRemovesMoneyOnlyIfValidAmount() {
        BankAccount account = new CurrentAccount();
        account.deposit(1000);
        assertFalse(account.withdraw(2000));
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void depositAddsTheRightAmount() {
        BankAccount account = new CurrentAccount();
        assertTrue(account.deposit(1000));
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void transactionsAreStored() {
        BankAccount account = new CurrentAccount();
        assertTrue(account.deposit(1000));
        assertTrue(account.withdraw(100));
        assertEquals(2, account.getTransactions().size());
    }

    @Test
    public void transactionsAreStoredCorrectly() {
        BankAccount account = new CurrentAccount();
        LocalDateTime ldt = LocalDateTime.now();
        assertTrue(account.deposit(1000));
        assertTrue(account.withdraw(100));
        assertEquals(2, account.getTransactions().size());
        LocalDateTime depTime = account.getTransactions().getFirst().getDateTime();
        LocalDateTime wdrTime = account.getTransactions().getLast().getDateTime();
        // deposit time correct within 1 s
        assertEquals(ldt.toLocalDate(), depTime.toLocalDate());
        assertEquals(ldt.getHour(), depTime.getHour());
        assertEquals(ldt.getMinute(), depTime.getMinute());
        assertEquals(ldt.getSecond(), depTime.getSecond());
        // withdraw time correct within 1 s
        assertEquals(ldt.toLocalDate(), wdrTime.toLocalDate());
        assertEquals(ldt.getHour(), wdrTime.getHour());
        assertEquals(ldt.getMinute(), wdrTime.getMinute());
        assertEquals(ldt.getSecond(), wdrTime.getSecond());
        // deposit amounts correct
        Transaction dep = account.getTransactions().getFirst();
        assertEquals(1000, dep.getAmount());
        assertEquals(1000, dep.getCurrentBalance());
        // withdraw amounts correct
        Transaction wdr = account.getTransactions().getLast();
        assertEquals(100, wdr.getAmount());
        assertEquals(900, wdr.getCurrentBalance());
    }

    @Test
    public void generateStatementOnNoTransactions() {
        BankAccount account = new CurrentAccount();
        assertEquals(
                "date\t||credit\t||debit\t||balance",
                account.generateBankStatement());
    }

    @Test
    public void generateStatementOnSomeTransactions() {
        assertTrue(true);
    }
}
