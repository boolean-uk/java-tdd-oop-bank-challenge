package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class AccountTest {
    private Account account;
    private User user;

    @BeforeEach
    void setUp(){
        user = new User(38,"Thomas", "Oslo");
        account = new Account(user);
    }

    @Test
    public void testSetUpAccount(){
        account.setBalance(2000);
        Assertions.assertEquals(2000, account.getBalance());
        Assertions.assertEquals(0, account.getOverdraft());
    }

    @Test
    public void testWithdraw(){
        account.setBalance(2000);
        account.withdraw(200);
        Assertions.assertEquals(1800, account.getBalance());
    }
    @Test
    public void testWithdrawWithInsufficientFunds(){
        account.setBalance(20);
        account.withdraw(300);
        Assertions.assertFalse(account.withdraw(300));
    }

    @Test
    public void testDeposit(){
        account.setBalance(2000);
        account.deposit(800);
        Assertions.assertEquals(2800, account.getBalance());
    }

    @Test
    public void testIfTotalAccountBalanceChangesWithSavingAndCurrent(){
        SavingsAccount savingsAccount = new SavingsAccount(user);
        CurrentAccount currentAccount = new CurrentAccount(user);

        savingsAccount.deposit(4000);
        currentAccount.deposit(200);

        Assertions.assertEquals(4000, savingsAccount.getBalance());
        Assertions.assertEquals(200, currentAccount.getBalance());
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void testTransactionLog(){
        Date clock = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        account.setBalance(2000);
        account.deposit(800);
        account.withdraw(300);
        String expected = "User ID || Deposited   || Withdrew   || New Balance   || Date \n" +
                "              \n" +
                "38      || 800.0       || 0.0        || 2800.0        || "+ dateFormat.format(clock)+"    \n" +
                "38      || 0.0         || 300.0      || 2500.0        || "+ dateFormat.format(clock)+"    \n" ;

        Assertions.assertEquals(expected,account.getTransactionLog());
    }
}
