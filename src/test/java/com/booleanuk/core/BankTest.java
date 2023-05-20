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
        int account1Id = bank.createAccount(Bank.AccountType.CURRENT, 2500);
        int account2Id = bank.createAccount(Bank.AccountType.CURRENT, 5000);
        int expected = account1Id + 1;

        Assertions.assertEquals(expected, bank.getAccounts().get(account2Id).getId());
    }
    @Test
    public void shouldSetInitialBalanceToZeroIfBalanceLessThanZero(){
        int accountId = bank.createAccount(Bank.AccountType.CURRENT, -34);

        Assertions.assertEquals(BigDecimal.ZERO, bank.getAccounts().get(accountId).getBalance());
    }

    @Test
    public void shouldReturnNullForBankStatementIfAccountDoesNotExist(){
        Assertions.assertNull(bank.generateStatement(-20));
    }
    @Test
    public void shouldPrintBankStatement(){
        int accountId = bank.createAccount(Bank.AccountType.CURRENT, 2500);
        LocalDateTime withdrawDateTime = LocalDateTime.of(LocalDate.of(2023, 5, 27), LocalTime.now());
        bank.getAccounts().get(accountId).withdraw(withdrawDateTime, 1000.0);

        LocalDateTime depositDateTime = LocalDateTime.of(LocalDate.of(2023, 7, 2), LocalTime.now());
        bank.getAccounts().get(accountId).deposit(depositDateTime, 500);

        BankStatement bankStatement = bank.generateStatement(accountId);
        bankStatement.print();
    }
}
