package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AccountTest {

    private Account currentAccount;
    private double initialBalance;
    @BeforeEach
    public void setup(){
        Bank bank = new Bank();
        initialBalance = 2500.0;
        int accountId = bank.createAccount(Bank.AccountType.CURRENT, initialBalance);
        currentAccount = bank.getAccounts().get(accountId);
    }



    @Test
    public void shouldNotDepositIfDepositAmountIsZeroOrNegative(){
        Assertions.assertFalse(currentAccount.deposit(-100.0));
        Assertions.assertEquals(initialBalance, currentAccount.getBalance());

    }

    @Test
    public void shouldReturnTrueIfDepositAmountIsValid(){
        double depositAmount = 500d;
        double balanceAfterDeposit = initialBalance + depositAmount;
        Assertions.assertTrue(currentAccount.deposit(depositAmount));
        Assertions.assertEquals(BigDecimal.valueOf(balanceAfterDeposit), currentAccount.getBalance());
    }

    @Test
    public void shouldNotWithdrawIfAmountIsGreaterThanBalance(){
        double withdrawAmount = 4000.0;

        Assertions.assertFalse(currentAccount.withdraw(withdrawAmount));
        Assertions.assertEquals(BigDecimal.valueOf(initialBalance), currentAccount.getBalance());
    }

    @Test
    public void shouldReturnTrueIfWithdrawAmountIsValid(){
        double withdrawAmount = 1000.0;
        double balanceAfterWithdraw = initialBalance - withdrawAmount;

        Assertions.assertTrue(currentAccount.withdraw(withdrawAmount));
        Assertions.assertEquals(BigDecimal.valueOf(balanceAfterWithdraw), currentAccount.getBalance());
    }
}
