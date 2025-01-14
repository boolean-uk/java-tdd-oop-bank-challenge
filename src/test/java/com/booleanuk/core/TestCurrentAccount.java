package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCurrentAccount {

    @Test
    public void testDeposit(){
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(100.00f);
        Assertions.assertEquals(100.00f, currentAccount.getBalance());
        currentAccount.deposit(74.00f);
        Assertions.assertEquals(174.00f, currentAccount.getBalance());
    }

    @Test
    public void testWithdraw(){
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(100.00f);
        Assertions.assertEquals(100.00f, currentAccount.getBalance());
        currentAccount.withdraw(20.00f);
        Assertions.assertEquals(80.00f, currentAccount.getBalance());
        currentAccount.withdraw(74.00f);
        Assertions.assertEquals(6.00f, currentAccount.getBalance());
    }

    @Test
    public void testStatement(){
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(1000.00f);
        currentAccount.deposit(2000.00f);
        currentAccount.withdraw(500.00f);
        System.out.println(currentAccount.generateStatement());
    }
}
