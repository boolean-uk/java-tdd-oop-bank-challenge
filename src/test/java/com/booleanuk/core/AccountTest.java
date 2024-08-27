package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class AccountTest {
    // User story 1
    @Test
    public void createCurrentAccount(){
        CurrentAccount currentAccount=new CurrentAccount(1000, "Commerce");
        Assertions.assertEquals(1000, currentAccount.getBalance());

    }

    // User story 2
    @Test
    public void createSavingsAccount(){
        SavingsAccount savingsAccount=new SavingsAccount(1000,"Commerce");
        Assertions.assertEquals(1000, savingsAccount.getBalance());

    }


    // User story 3 & 4
    @Test
    public void createBankStatement(){
        CurrentAccount currentAccount=new CurrentAccount(1000,"Commerce");
        currentAccount.deposit(1000, "22/08/2024");
        currentAccount.withdraw(500, "23/08/2024");
        currentAccount.deposit(2000, "25/08/2024");
        currentAccount.generateBankStatement();
    }
    // Extension story 1
    @Test
    public void calculateBalanceTest(){
        CurrentAccount currentAccount=new CurrentAccount(1000,"Commerce");
        currentAccount.deposit(1000, "22/08/2024");
        currentAccount.withdraw(500, "23/08/2024");
        currentAccount.deposit(2000, "25/08/2024");
        Assertions.assertEquals(2500, currentAccount.calculateBalance());
    }

    // Extension story 2
    @Test
    public void branchTest(){
        CurrentAccount currentAccount=new CurrentAccount(1000,"Commerce");

        Assertions.assertEquals("Commerce", currentAccount.getBranch());
    }


    @Test
    // Extension story 3
    public void requestOverdraft(){
        CurrentAccount currentAccount=new CurrentAccount(0,"Commerce");
        currentAccount.requestOverdraft();
        Assertions.assertTrue(currentAccount.isOverdraftRequest());
    }

    // Extension story 4
    @Test
    public void answerOverdraftTest(){
        CurrentAccount currentAccount=new CurrentAccount(0,"Commerce");
        Assertions.assertFalse(currentAccount.answerOverdraft(true));
        currentAccount.requestOverdraft();
        Assertions.assertTrue(currentAccount.answerOverdraft(true));
        Assertions.assertTrue(currentAccount.isOverdraft());

    }

    @Test
    public void OverdraftTest(){
        CurrentAccount currentAccount=new CurrentAccount(0,"Commerce");
        Assertions.assertFalse(currentAccount.withdraw(1000, "27/07/2024"));
        currentAccount.requestOverdraft();
        Assertions.assertTrue(currentAccount.answerOverdraft(true));
        Assertions.assertTrue(currentAccount.isOverdraft());

        Assertions.assertTrue(currentAccount.withdraw(1000, "27/07/2024"));

    }

    @Test
    public void OverdraftLimitTest(){
        CurrentAccount currentAccount=new CurrentAccount(0,"Commerce");
        Assertions.assertFalse(currentAccount.withdraw(1000, "27/07/2024"));
        currentAccount.requestOverdraft();
        Assertions.assertTrue(currentAccount.answerOverdraft(true));
        Assertions.assertTrue(currentAccount.isOverdraft());

        Assertions.assertFalse(currentAccount.withdraw(1001, "27/07/2024"));

    }











}
