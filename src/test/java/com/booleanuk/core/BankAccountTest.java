package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

public class BankAccountTest {

    @Test
    public void testGetBalance(){
        Branch branch = new Branch("Name", "Location");
        BankAccount currentAccount = new CurrentAccount(branch, 500);
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

    @Test
    public void testMakeWithdrawalWithoutOverdraft(){
        BankAccount currentAccount = new CurrentAccount();
        new Transaction("withdraw", 100, currentAccount);
        Assertions.assertNotEquals(-100, currentAccount.getBalance());
        Assertions.assertEquals(0, currentAccount.getTransactions().size());
        currentAccount.setHasOverdraft(true);
        currentAccount.setOverdraft(100);
        new Transaction("withdraw", 100, currentAccount);
        Assertions.assertEquals(-100, currentAccount.getBalance());
        Assertions.assertEquals(1, currentAccount.getTransactions().size());
    }

}
