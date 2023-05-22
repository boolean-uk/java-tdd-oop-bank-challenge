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
    public void testAddTransactionToTransactionsArrayList(){
        BankAccount currentAccount = new CurrentAccount();
        new Transaction("deposit", 500, currentAccount);
        Assertions.assertEquals(1, currentAccount.getTransactions().size());
        new Transaction("withdraw", 250, currentAccount);
        Assertions.assertEquals(2, currentAccount.getTransactions().size());

    }

    @Test
    public void testPrintStatement(){
        BankAccount currentAccount = new CurrentAccount();
        new Transaction("deposit", 500, currentAccount);
        Assertions.assertTrue(currentAccount.printStatement());
    }

    @Test
    public void testGetAccountNumber(){
        BankAccount currentAccount = new CurrentAccount();
        BankAccount currentAccount1 = new CurrentAccount();
        Assertions.assertEquals(1, currentAccount.getAccountNumber());
        Assertions.assertEquals(2, currentAccount1.getAccountNumber());
    }

}
