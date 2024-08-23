package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;
    private User user;

    @BeforeEach
    void setUp(){
        user = new User(38,"Thomas", "Oslo");
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
    public void testWithdrawInsufficientFunds(){
        savingsAccount.deposit(50);
        Assertions.assertEquals(false, savingsAccount.withdraw(200));
    }

    @Test
    public void testSavingAndCurrentIsDifferent(){
        CurrentAccount currentAccount = new CurrentAccount(user);
        savingsAccount.deposit(4000);
        Assertions.assertNotEquals(savingsAccount.getBalance(),currentAccount.getBalance());
    }
    @Test
    public void testGenerateTransactionLog(){
        Date clock = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        savingsAccount.setBalance(2000);
        savingsAccount.deposit(800);
        savingsAccount.withdraw(300);
        String expected = "User ID || Deposited   || Withdrew   || New Balance   || Date \n" +
                "              \n" +
                "38      || 800.0       || 0.0        || 2800.0        || "+ dateFormat.format(clock)+"    \n" +
                "38      || 0.0         || 300.0      || 2500.0        || "+ dateFormat.format(clock)+"    \n" ;

        Assertions.assertEquals(expected,savingsAccount.getTransactionLog());
    }
}
