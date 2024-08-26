package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void generateBankStatement(){
        Assertions.assertTrue(bankStatement.contains("Bank statement extract"));
    }

    @Test
    public void depositFunds(){
        Account.deposit(100);
        Assertions.assertEquals(100, Account.getBalance);
    }

    @Test
    public void withdrawFunds(){;
        Assertions.assertEquals("Not enough funds.", Account.withdraw(100));
        Account.deposit(100);
        Assertions.assertEquals("Funds withdrawed from account.", Account.withdraw(50));
        Assertions.assertEquals(50, Account.getBalance);
    }
}
