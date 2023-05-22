package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void addDepositCheckingAccountTest(){
        Account account = new Account("1111", 100.0, "Checking");
        account.formerDeposit(100);
        Assertions.assertEquals(200, account.getBalance());
    }

    @Test
    public void withdrawCheckingAccountTest(){
        Account account = new Account("2222", 300.0, "Checking");
        account.withdraw(200);
        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void withdrawFailureCheckingAccountTest(){
        Account account1 = new Account("1111", 100.0, "Checking");
        Assertions.assertFalse(account1.withdraw(150.50));
        Assertions.assertEquals(100, account1.getBalance());
        Assertions.assertTrue(account1.withdraw(50.5));
        Assertions.assertEquals(49.5, account1.getBalance());
    }


}
