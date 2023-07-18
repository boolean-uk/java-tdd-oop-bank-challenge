package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    public void depositSaving(){
        Account account=new SavingAccount(BigDecimal.ZERO);
        account.deposit(BigDecimal.valueOf(800));
        assertEquals(BigDecimal.valueOf(800),account.amount);
    }
    @Test
    public void depositCurrent(){
        Account account=new CurrentAccount(BigDecimal.ZERO);
        account.deposit(BigDecimal.valueOf(800));
        assertEquals(BigDecimal.valueOf(800),account.amount);
    }
    @Test
    public void withdrawCurrent(){
        Account account=new CurrentAccount(BigDecimal.ZERO);
        account.deposit(BigDecimal.valueOf(800));
        account.withdraw(BigDecimal.valueOf(300));
        assertEquals(BigDecimal.valueOf(500),account.amount);
    }
    @Test
    public void withdrawSaving(){
        Account account=new SavingAccount(BigDecimal.ZERO);
        account.deposit(BigDecimal.valueOf(800));
        account.withdraw(BigDecimal.valueOf(300));
        assertEquals(BigDecimal.valueOf(500),account.amount);
    }
}
