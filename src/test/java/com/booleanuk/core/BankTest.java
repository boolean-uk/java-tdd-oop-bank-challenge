package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BankTest {

    private Bank bank;
    @BeforeEach
    public void setup(){
        bank = new Bank();
    }

    @Test
    public void shouldCreateCurrentAccount(){
        int accountId = bank.createAccount(Bank.AccountType.CURRENT, 2500);

        Assertions.assertFalse(bank.getAccounts().isEmpty());
        Assertions.assertInstanceOf(CurrentAccount.class, bank.getAccounts().get(accountId));
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

    @Test
    public void shouldPrintBankStatement(){
        int accountId = bank.createAccount(Bank.AccountType.CURRENT, 2500);
        bank.getAccounts().get(accountId).withdraw(1000);
        bank.getAccounts().get(accountId).deposit(LocalDateTime.of(LocalDate.of(2023, 5, 10), LocalTime.now()), 500);

        BankStatement bankStatement = bank.generateStatement(accountId);
        bankStatement.print();
    }
}
