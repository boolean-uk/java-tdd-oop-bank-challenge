package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void generateBankStatement(){
        Account account = new Account("Test");
        account.deposit(100);
        account.deposit(20);
        account.generateBankStatement();
        account.printBankStatement();
    }

    @Test
    public void depositFunds(){
        Account account = new Account("Test");
        account.deposit(100);
        Assertions.assertEquals(100f, account.getBalance());
    }

    @Test
    public void withdrawFunds(){
        Account account = new Account("Test");
        Assertions.assertEquals("Not enough funds.", account.withdraw(100));
        account.deposit(100);
        Assertions.assertEquals("Funds withdrawed from account.", account.withdraw(50));
        Assertions.assertEquals(50f, account.getBalance());
    }
}
