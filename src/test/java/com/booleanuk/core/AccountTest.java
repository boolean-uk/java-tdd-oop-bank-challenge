package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void createCurrentAccount(){
        CurrentAccount currentAccount=new CurrentAccount(1000, "Commerce");
        Assertions.assertEquals(1000, currentAccount.getBalance());

    }

    @Test
    public void createSavingsAccount(){
        SavingsAccount savingsAccount=new SavingsAccount(1000,"Commerce");
        Assertions.assertEquals(1000, savingsAccount.getBalance());

    }



    @Test
    public void createBankStatement(){
        CurrentAccount currentAccount=new CurrentAccount(1000,"Commerce");
        currentAccount.deposit(1000, "22/08/2024");
        currentAccount.withdraw(500, "23/08/2024");
        currentAccount.deposit(2000, "25/08/2024");
        currentAccount.generateBankStatement();
    }

    @Test
    public void calculateBalanceTest(){
        CurrentAccount currentAccount=new CurrentAccount(1000,"Commerce");
        currentAccount.deposit(1000, "22/08/2024");
        currentAccount.withdraw(500, "23/08/2024");
        currentAccount.deposit(2000, "25/08/2024");
        Assertions.assertEquals(2500, currentAccount.calculateBalance());
    }

    @Test
    public void branchTest(){
        CurrentAccount currentAccount=new CurrentAccount(1000,"Commerce");

        Assertions.assertEquals("Commerce", currentAccount.getBranch());
    }


    @Test

    public void requestOverdraft(){
        CurrentAccount currentAccount=new CurrentAccount(0,"Commerce");
        currentAccount.requestOverdraft();
        Assertions.assertTrue(currentAccount.isOverdraftRequest());
    }

    @Test
    public void answerOverdraftTest(){
        CurrentAccount currentAccount=new CurrentAccount(0,"Commerce");
        Assertions.assertFalse(currentAccount.answerOverdraft(true));
        currentAccount.requestOverdraft();
        Assertions.assertTrue(currentAccount.answerOverdraft(true));
        Assertions.assertTrue(currentAccount.isOverdraft());
    }






}
