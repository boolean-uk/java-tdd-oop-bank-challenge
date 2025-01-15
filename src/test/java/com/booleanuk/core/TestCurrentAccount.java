package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public void testInsufficientFunds(){
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(100.00f);
        currentAccount.withdraw(500.00f);
        Assertions.assertEquals(100.00f, currentAccount.getBalance());
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
    public void testCalculateBalance(){
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(3000.00f);
        currentAccount.deposit(3000.00f);
        Assertions.assertEquals(6000.00f, currentAccount.calculateBalance());
        currentAccount.withdraw(500.00f);
        currentAccount.withdraw(50.00f);
        Assertions.assertEquals(5450.00f, currentAccount.calculateBalance());
        currentAccount.withdraw(50.00f);
        Assertions.assertEquals(5400.00f, currentAccount.calculateBalance());

    }

    @Test
    public void testStatement(){
        DateTimeFormatter testFormatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(1000.00f);
        currentAccount.deposit(2000.00f);
        currentAccount.withdraw(500.00f);
        String expected = "date||credit||debit||balance\n" + LocalDateTime.now().format(testFormatter) +
                "||||500.0||2500.0\n" + LocalDateTime.now().format(testFormatter) + "||2000.0||||3000.0\n" +
                LocalDateTime.now().format(testFormatter) + "||1000.0||||1000.0";
        Assertions.assertEquals(expected, currentAccount.generateStatement().replaceAll("[ ]+", "").strip());
    }
}
