package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    private Account currentAccount;
    private double initialBalance;
    private String branchName;
    @BeforeEach
    public void setup(){
        Bank bank = new Bank();
        initialBalance = 2500.0;
        branchName = "Alpha Bank Athens";
        int accountId = bank.createAccount(branchName, Bank.AccountType.CURRENT, initialBalance);
        currentAccount = bank.getAccounts().get(accountId);
    }



    @Test
    public void shouldNotDepositIfDepositAmountIsZeroOrNegative(){
        Assertions.assertFalse(currentAccount.deposit(-100.0));
        Assertions.assertEquals(BigDecimal.valueOf(initialBalance), currentAccount.getBalance());

    }

    @Test
    public void shouldReturnTrueIfDepositAmountIsValid(){
        double depositAmount = 500d;
        double balanceAfterDeposit = initialBalance + depositAmount;
        Assertions.assertTrue(currentAccount.deposit(depositAmount));
        Assertions.assertEquals(BigDecimal.valueOf(balanceAfterDeposit), currentAccount.getBalance());
    }

    @Test
    public void shouldNotWithdrawIfAmountIsGreaterThanBalanceAndIsNotOverdraft(){
        double withdrawAmount = 4000.0;

        Assertions.assertFalse(currentAccount.withdraw(withdrawAmount));
        Assertions.assertEquals(BigDecimal.valueOf(initialBalance), currentAccount.getBalance());
    }

    @Test
    public void shouldWithdrawIfAmountIsGreaterThanBalanceAndOverdraftAccepted(){
        double withdrawAmount = 4000.0;
        currentAccount.setOverdraftStatus(Bank.OverdraftStatus.ACCEPTED);
        double expectedBalance = initialBalance - withdrawAmount;
        currentAccount.withdraw(withdrawAmount);

        Assertions.assertEquals(BigDecimal.valueOf(expectedBalance), currentAccount.getBalance());

    }

    @Test
    public void shouldNotWithdrawIfOverdraftIsRejected(){
        double withdrawAmount = 7000.0;
        currentAccount.setOverdraftStatus(Bank.OverdraftStatus.REJECTED);
        currentAccount.withdraw(withdrawAmount);

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
