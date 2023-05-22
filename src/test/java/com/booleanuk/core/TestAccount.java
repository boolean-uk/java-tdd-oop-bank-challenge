package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAccount {
    @Test
    public void testWithdraw(){
        Account account = new Account(new Balance(100,0));
        account.withdraw(new Balance(50,50));
        Assertions.assertEquals(account.getBalance().getIntPart(),49);
        Assertions.assertEquals(account.getBalance().getDecimalPart(),50);
    }
    @Test
    public void testDeposit(){
        Account account = new Account(new Balance(100,0));
        account.deposit(new Balance(150,0));
        Assertions.assertEquals(account.getBalance().getIntPart(),250);
        Assertions.assertEquals(account.getBalance().getDecimalPart(),0);
    }
    @Test
    public void testShowStatements(){
        Account account = new Account(new Balance(150,0));
        account.deposit(new Balance(150,0));
        account.withdraw(new Balance(20,50));
        account.showStatements();
    }
    @Test
    public void testGetBalanceByStatements(){
        //because setBalance is private, i test the setBalance using the Account class
        Balance balance = new Balance(10,0);
        Account account = new Account(balance);
        Assertions.assertEquals(balance,account.getBalance());
        Assertions.assertEquals("10,0",account.getBalanceByStatements().toString());
        Balance faultyBalance = new Balance(1,0);
        Balance anotherFaultyBalance = new Balance(-1,0);
        Account anotherAccount = new Account(faultyBalance);
        Account andAnotherAccount = new Account(anotherFaultyBalance);
        //on the 2 accounts above, their balance will not get initialized. This results in faulty accounts that can't be used.
        //this can be seen by messages in the terminal.
    }
    @Test
    public void testWriteStatements(){
        Account account = new Account(new Balance(150,0));
        account.deposit(new Balance(150,0));
        account.withdraw(new Balance(20,50));
        account.showStatements();
        //in the show statements the method writes to the file.
    }
}
