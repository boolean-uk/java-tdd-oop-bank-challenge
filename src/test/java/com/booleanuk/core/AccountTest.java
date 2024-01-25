package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void createUserAndCurrentAccount(){
        User user = new User("John", "John@example.org");
        user.createCurrentAccount();
        Assertions.assertEquals(user.getCurrentAccount().getBalance(), 0.00);
    }
    @Test
    public void createUserAndSavingsAccount(){
        User user = new User("John", "John@example.org");
        user.createSavingsAccount();
        Assertions.assertEquals(user.getSavingsAccount().getBalance(), 0.00);
    }

    @Test
    public void deposit500ToCurrentAnd300ToSaving(){
        User user = new User("John", "John@example.org");
        user.createCurrentAccount();
        user.createSavingsAccount();
        user.getCurrentAccount().deposit(500);
        user.getSavingsAccount().deposit(300);
        Assertions.assertEquals(user.getCurrentAccount().getBalance(), 500.00);
        Assertions.assertEquals(user.getSavingsAccount().getBalance(), 300.00);

    }
    @Test
    public void WithdrawOverBalanceAmount(){
        User user = new User("John", "John@example.org");
        user.createCurrentAccount();
        user.getCurrentAccount().deposit(500);
        user.getCurrentAccount().withdraw(600);
        Assertions.assertEquals(user.getCurrentAccount().getBalance(), 500.00);
    }
}
