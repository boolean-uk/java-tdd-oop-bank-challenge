package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    private CurrentAccount currentAccount;
    private User user;
    @BeforeEach
    void setUp(){
        user = new User("Thomas","Oslo");
        currentAccount = new CurrentAccount(user);
    }

    @Test
    public void testSavingsAccountBalance(){
        Assertions.assertEquals(0, currentAccount.getBalance());
    }

    @Test
    public void testDepositSavingsAccount(){
        currentAccount.deposit(4000d);
        Assertions.assertEquals(4000d, currentAccount.getBalance());
    }

    @Test
    public void testWithdrawSavingsAccount(){
        currentAccount.deposit(8000d);
        currentAccount.withdraw(2000d);
        Assertions.assertEquals(6000d, currentAccount.getBalance());
    }

    @Test
    public void testSavingAndCurrentIsDifferent(){
        SavingsAccount savingsAccount = new SavingsAccount(user);
        currentAccount.deposit(4000d);
        Assertions.assertNotEquals(savingsAccount.getBalance(),currentAccount.getBalance());
    }

    @Test
    public void testGenerateTransactionLog(){
        currentAccount.setBalance(40000d);
        currentAccount.deposit(8000d);
        currentAccount.withdraw(2000d);
        currentAccount.withdraw(80d);
        currentAccount.withdraw(400.689);
        System.out.println(currentAccount.getTransactionLog());
    }
}
