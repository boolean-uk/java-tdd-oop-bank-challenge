package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBankAccount {
    @Test
    public void TestForBalance(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.depositMoneyToCurrent(new UsDollar(300));
        bankAccount.depositMoneyToSavings(new UsDollar(1000));
        bankAccount.withdrawMoney(new UsDollar(200));
        Assertions.assertEquals(1200, bankAccount.balance());
    }
    @Test
    public void TestForDepositMoneyToCurrent(){
        BankAccount bankAccount = new BankAccount();
        Assertions.assertEquals(500, bankAccount.depositMoneyToCurrent(new UsDollar(400)));
    }
    @Test
    public void TestForTotalCurrent(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.depositMoneyToCurrent(new UsDollar(300));
        Assertions.assertEquals(400,bankAccount.totalCurrent());
    }
    @Test
    public void TestForDepositMoneyToSavings(){
        BankAccount bankAccount = new BankAccount();
        Assertions.assertEquals(400, bankAccount.depositMoneyToSavings(new UsDollar(400)));
    }
    @Test
    public void TestForTotalSavings(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.depositMoneyToSavings(new UsDollar(1000));
        Assertions.assertEquals(1800, bankAccount.totalSavings(new UsDollar(800)));
    }
    @Test
    public void TestForWithdrawMoney(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.depositMoneyToCurrent(new UsDollar(900));
        Assertions.assertEquals(500, bankAccount.withdrawMoney(new UsDollar(500)));
    }
    @Test
    public void TestForWithdrawMoneyFromSavings(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.depositMoneyToSavings(new UsDollar(500));
        Assertions.assertEquals(100, bankAccount.withdrawMoneyFromSavings(new UsDollar(400)));
    }

}
