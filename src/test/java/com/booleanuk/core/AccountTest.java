package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    @Test
    public void depositSaving(){
        Account account=new SavingAccount(BigDecimal.ZERO,"KRK");
        account.deposit(BigDecimal.valueOf(800));
        assertEquals(BigDecimal.valueOf(800),account.amount);
    }
    @Test
    public void depositCurrent(){
        Account account=new CurrentAccount(BigDecimal.ZERO,"WRO");
        account.deposit(BigDecimal.valueOf(800));
        assertEquals(BigDecimal.valueOf(800),account.amount);
    }
    @Test
    public void withdrawCurrent(){
        Account account=new CurrentAccount(BigDecimal.ZERO,"WAR");
        account.deposit(BigDecimal.valueOf(800));
        account.withdraw(BigDecimal.valueOf(300));
        assertEquals(BigDecimal.valueOf(500),account.amount);
    }
    @Test
    public void withdrawCurrentOverdraftAccept(){
        CurrentAccount account=new CurrentAccount(BigDecimal.ZERO,"WAR");
        account.giveAcceptanceForOverdraft();
        account.deposit(BigDecimal.valueOf(800));
        account.withdraw(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(-200),account.amount);
    }
    @Test
    public void withdrawCurrentOverdraftDeny(){
        CurrentAccount account=new CurrentAccount(BigDecimal.ZERO,"WAR");
        account.denyOverdraft();
        account.deposit(BigDecimal.valueOf(800));
       // account.withdraw(BigDecimal.valueOf(1000));
       // assertEquals(BigDecimal.valueOf(-200),account.amount);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(1000)));
    }
    @Test
    public void withdrawCurrentOverdraftTooMuch(){
        Account account=new CurrentAccount(BigDecimal.ZERO,"WAR");
        account.deposit(BigDecimal.valueOf(800));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(1400)));
    }
    @Test
    public void withdrawSaving(){
        Account account=new SavingAccount(BigDecimal.ZERO,"WRO");
        account.deposit(BigDecimal.valueOf(800));
        account.withdraw(BigDecimal.valueOf(300));
        assertEquals(BigDecimal.valueOf(500),account.amount);
    }
}
