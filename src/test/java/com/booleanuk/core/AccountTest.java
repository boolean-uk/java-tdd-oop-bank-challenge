package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    private Bank bank;
    @BeforeEach
    public void setup(){
        bank = new Bank();
    }

    @Test
    public void shouldCreateCurrentAccount(){
        boolean created = bank.createAccount(Bank.AccountType.CURRENT, 2500);

        Assertions.assertTrue(created);
        Assertions.assertInstanceOf(CurrentAccount.class, bank.getAccounts().get(0));
        Assertions.assertFalse(bank.getAccounts().isEmpty());
    }

    @Test
    public void shouldIncrementAccountIdOnCreateAccount(){
        bank.createAccount(Bank.AccountType.CURRENT, 2500);
        bank.createAccount(Bank.AccountType.CURRENT, 5000);
        Assertions.assertEquals(1, bank.getAccounts().get(1).getId());
    }
    @Test
    public void shouldSetInitialBalanceToZeroIfBalanceLessThanZero(){
        bank.createAccount(Bank.AccountType.CURRENT, -34);

        Assertions.assertEquals(BigDecimal.ZERO, bank.getAccounts().get(0).getBalance());
    }
}
