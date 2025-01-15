package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
    public void withdrawingRemovesMoneyOnlyIfValidAmount() {
        assertTrue(true);
    }

    @Test
    public void depositAddsTheRightAmount() {
        BankAccount account = new CurrentAccount();
        assertTrue(account.deposit(1000));
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void transactionsAreStored() {
        assertTrue(true);
    }

    @Test
    public void generateStatementOnNoTransactions() {
        assertTrue(true);
    }

    @Test
    public void generateStatementOnSomeTransactions() {
        assertTrue(true);
    }
}
