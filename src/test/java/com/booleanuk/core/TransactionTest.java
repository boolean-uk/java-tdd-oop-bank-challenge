package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testGetAmount(){
        BankAccount currentAccount = new CurrentAccount();
        Transaction transaction = new Transaction("deposit", 500, currentAccount);
        Assertions.assertEquals(500, transaction.getAmount());
    }

    @Test
    public void testMakeDateStamp(){
        BankAccount currentAccount = new CurrentAccount();
        Transaction transaction = new Transaction("deposit", 500, currentAccount);
        Assertions.assertEquals("22/05/2023", transaction.getDate());
    }

    @Test
    public void testExecuteTransaction(){
        BankAccount currentAccount = new CurrentAccount();
        new Transaction("deposit", 500, currentAccount);
        Assertions.assertEquals(500, currentAccount.getBalance());
        new Transaction("withdraw", 100, currentAccount);
        Assertions.assertEquals(400, currentAccount.getBalance());
    }


}
