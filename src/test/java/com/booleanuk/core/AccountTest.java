package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void addDepositCheckingAccountTest(){
        Account account = new Account("1111", 100, "Checking");
        account.formerDeposit(100);
        Assertions.assertEquals(200, account.getBalance());
    }

//    @Test
//    void depositTest() {
//        Account account = Account("1111", 1000.0, "Rose");
//        account.deposit(500.0);
//        Assertions.assertEquals(1500.0, account.getBalance(), 0.01);
//    }

}
