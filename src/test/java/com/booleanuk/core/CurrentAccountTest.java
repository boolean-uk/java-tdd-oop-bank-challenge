package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentAccountTest {
    private CurrentAccount currentAccount;
    private User user;
    @BeforeEach
    void setUp(){
        user = new User(38,"Thomas","Oslo");
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
    public void testWithdrawInsufficientFunds(){
        currentAccount.deposit(50);
        Assertions.assertEquals(false, currentAccount.withdraw(200));
        currentAccount.setOverdraft(1000);
        Assertions.assertEquals(true, currentAccount.withdraw(200));
        Assertions.assertEquals(-150, currentAccount.getBalance());
    }

    @Test
    public void testSavingAndCurrentIsDifferent(){
        SavingsAccount savingsAccount = new SavingsAccount(user);
        currentAccount.deposit(4000d);
        Assertions.assertNotEquals(savingsAccount.getBalance(),currentAccount.getBalance());
    }

    @Test
    public void testGenerateTransactionLog(){
        Date clock = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        currentAccount.setBalance(2000);
        currentAccount.deposit(800);
        currentAccount.withdraw(300);
        String expected = "User ID || Deposited   || Withdrew   || New Balance   || Date \n" +
                "              \n" +
                "38      || 800.0       || 0.0        || 2800.0        || "+ dateFormat.format(clock)+"    \n" +
                "38      || 0.0         || 300.0      || 2500.0        || "+ dateFormat.format(clock)+"    \n" ;

        Assertions.assertEquals(expected,currentAccount.getTransactionLog());
    }
/*
    @Test
    public void testWithdrawWithOverdraftRequest(){
        currentAccount.setBalance(30);
        int overdraftRequest = 600;
        currentAccount.requestOverdraft(overdraftRequest);
        currentAccount.setMaximumOverdraft(overdraftRequest);
        Assertions.assertEquals(true, currentAccount.requestAccepted(overdraftRequest));
        currentAccount.withdraw(300);
        Assertions.assertEquals(-270, );
    }

 */
}
