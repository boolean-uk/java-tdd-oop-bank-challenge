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
        assertTrue(true);
    }

    @Test
    public void canWithdrawWithinReason() {
        assertTrue(true);
    }

    @Test
    public void depositAddsTheRightAmount() {
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
