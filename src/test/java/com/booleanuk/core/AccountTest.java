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

    @Test
    public void addWithdrawCheckingAccountTest(){
        Account account = new Account("1111", 100, "Checking");
        account.withdraw(100);
        Assertions.assertEquals(0, account.getBalance());
    }


}
