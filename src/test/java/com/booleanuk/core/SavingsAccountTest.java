package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;
    private User user;

    @BeforeEach
    void setUp(){
        user = new User(777, "Thomas", "Oslo");
        savingsAccount = new SavingsAccount(user);
    }

    @Test
    public void testSavingsAccountBalance(){
        Assertions.assertEquals(0, savingsAccount.getBalance());
    }

    @Test
    public void testDepositSavingsAccount(){
        savingsAccount.deposit(4000);
        Assertions.assertEquals(4000, savingsAccount.getBalance());
    }

    @Test
    public void testWithdrawSavingsAccount(){
        savingsAccount.deposit(8000);
        savingsAccount.withdraw(2000);
        Assertions.assertEquals(6000, savingsAccount.getBalance());
    }

    @Test
    public void testSavingAndCurrentIsDifferent(){
        CurrentAccount currentAccount = new CurrentAccount(user);
        savingsAccount.deposit(4000);
        Assertions.assertNotEquals(savingsAccount.getBalance(),currentAccount.getBalance());
    }
    @Test
    public void testGenerateTransactionLog(){
        savingsAccount.setBalance(40000);
        savingsAccount.deposit(8000);
        savingsAccount.withdraw(2000);
        savingsAccount.withdraw(80);
        savingsAccount.withdraw(400);
        System.out.println(savingsAccount.getTransactionLog());
    }
}
