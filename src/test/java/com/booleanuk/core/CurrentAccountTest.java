package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    private CurrentAccount currentAccount;
    private User user;
    @BeforeEach
    void setUp(){
        user = new User(777,"Thomas","Oslo");
        currentAccount = new CurrentAccount(user);
    }

    @Test
    public void testSavingsAccountBalance(){
        Assertions.assertEquals(0, currentAccount.getBalance());
    }

    @Test
    public void testDepositSavingsAccount(){
        currentAccount.deposit(4000);
        Assertions.assertEquals(4000, currentAccount.getBalance());
    }

    @Test
    public void testWithdrawSavingsAccount(){
        currentAccount.deposit(8000);
        currentAccount.withdraw(2000);
        Assertions.assertEquals(6000, currentAccount.getBalance());
    }

    @Test
    public void testSavingAndCurrentIsDifferent(){
        SavingsAccount savingsAccount = new SavingsAccount(user);
        currentAccount.deposit(4000);
        Assertions.assertNotEquals(savingsAccount.getBalance(),currentAccount.getBalance());
    }

    @Test
    public void testGenerateTransactionLog(){
        currentAccount.setBalance(40000);
        currentAccount.deposit(8000);
        currentAccount.withdraw(2000);
        currentAccount.withdraw(80);
        currentAccount.withdraw(400);
        System.out.println(currentAccount.getTransactionLog());
    }
}
