package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BankAccountTest {

    @Test
    public void testGetBalance(){
        Branch branch = new Branch("Name", "Location");
        BankAccount currentAccount = new CurrentAccount(branch, 500);
        Assertions.assertEquals(500, currentAccount.getBalance());
    }

    @Test
    public void testAddTransactionToTransactionsArrayList(){
        Branch branch = new Branch("Name", "Location");
        BankAccount currentAccount = new CurrentAccount(branch);
        new Transaction("deposit", 500, currentAccount);
        Assertions.assertEquals(1, currentAccount.getTransactions().size());
        new Transaction("withdraw", 250, currentAccount);
        Assertions.assertEquals(2, currentAccount.getTransactions().size());

    }

    @Test
    public void testPrintStatement(){
        Branch branch = new Branch("Name", "Location");
        BankAccount currentAccount = new CurrentAccount(branch);
        new Transaction("deposit", 500, currentAccount);
        Assertions.assertTrue(currentAccount.printStatement());
    }

}
