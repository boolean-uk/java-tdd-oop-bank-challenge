package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void testGetBalance(){
        BankAccount currentAccount = new CurrentAccount(500);
        Assertions.assertEquals(500, currentAccount.getBalance());
    }

    @Test
    public void testSetBalance(){
        BankAccount savingsAccount = new SavingsAccount();
        savingsAccount.setBalance(500);
        Assertions.assertEquals(500, savingsAccount.getBalance());
    }

    @Test
    public void testMakeTransaction(){
        BankAccount currentAccount = new CurrentAccount();
        Transaction transaction = new Transaction("deposit", 500);
        currentAccount.makeTransaction(transaction);
        Assertions.assertEquals(1, currentAccount.getTransactions().size());
        Assertions.assertEquals(500, currentAccount.getBalance());
        Transaction transaction2 = new Transaction("withdraw", 250);
        currentAccount.makeTransaction(transaction2);
        Assertions.assertEquals(2, currentAccount.getTransactions().size());
        Assertions.assertEquals(250, currentAccount.getBalance());
    }

    @Test
    public void testPrintStatement(){
        BankAccount currentAccount = new CurrentAccount();
        Transaction transaction = new Transaction("deposit", 500);
        currentAccount.makeTransaction(transaction);
        Assertions.assertTrue(currentAccount.printStatement());
    }

}
