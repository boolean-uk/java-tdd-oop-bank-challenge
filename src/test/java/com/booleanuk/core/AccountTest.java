package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AccountTest {
    private Current currentAccount;

    @BeforeEach
    public void setUp() {
        String accountNumber = "01234567891";
        this.currentAccount = new Current("Bobs Bagel", accountNumber);
    }

    @Test
    public void testDepositMoney() {
        currentAccount.deposit(500.0);
        double currentBalance = currentAccount.getBalance();
        Assertions.assertEquals(500.0, currentBalance);
    }

    @Test
    public void testWithdrawMoney() {
        currentAccount.deposit(500.0);
        currentAccount.withdraw(200.0);
        double currentBalance = currentAccount.getBalance();
        Assertions.assertEquals(300.0, currentBalance);
    }

    @Test
    public void testTransactionHistory() {
        ArrayList<Transaction> transactions = currentAccount.getTransactions();

        currentAccount.deposit(500.0);
        Assertions.assertEquals(500.0, transactions.getFirst().getBalance());

        currentAccount.deposit(200.0);
        Assertions.assertEquals(700.0, transactions.get(1).getBalance());

        currentAccount.withdraw(100.0);
        Assertions.assertEquals(600.0, transactions.get(2).getBalance());

    }
}
