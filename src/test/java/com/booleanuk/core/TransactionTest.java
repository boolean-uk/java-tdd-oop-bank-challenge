package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testGetAmount(){
        Branch branch = new Branch("Name", "Location");
        BankAccount currentAccount = new CurrentAccount(branch);
        Transaction transaction = new Transaction("deposit", 500, currentAccount);
        Assertions.assertEquals(500, transaction.getAmount());
    }

    @Test
    public void testMakeDateStamp(){
        Branch branch = new Branch("Name", "Location");
        BankAccount currentAccount = new CurrentAccount(branch);
        Transaction transaction = new Transaction("deposit", 500, currentAccount);
        Assertions.assertEquals("22/05/2023", transaction.getDate());
    }

    @Test
    public void testExecuteTransaction(){
        Branch branch = new Branch("Name", "Location");
        BankAccount currentAccount = new CurrentAccount(branch);
        new Transaction("deposit", 500, currentAccount);
        Assertions.assertEquals(500, currentAccount.getBalance());
        new Transaction("withdraw", 100, currentAccount);
        Assertions.assertEquals(400, currentAccount.getBalance());
    }

    @Test
    public void testMakeWithdrawalWithAndWithoutOverdraft(){
        Branch branch = new Branch("Name", "Location");
        BankAccount currentAccount = new CurrentAccount(branch);
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
