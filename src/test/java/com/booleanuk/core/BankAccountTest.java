package com.booleanuk.core;

import com.booleanuk.core.banking.BankAccountNotOpened;
import com.booleanuk.core.banking.BankTransaction;
import com.booleanuk.core.banking.TransactionResult;
import com.booleanuk.core.banking.TransactionType;
import com.booleanuk.core.user.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    Customer customer = new Customer();

    @Test
    public void shouldThrowBankAccountNotOpenedWhenTryingToDepositWithoutCurrentAccount() {
        BankAccountNotOpened bankAccountNotOpened = Assertions.assertThrows(BankAccountNotOpened.class, () -> customer.depositCurrentAccount(BigDecimal.valueOf(1000)));
        Assertions.assertEquals("Current Account not opened", bankAccountNotOpened.getMessage());
    }

    @Test
    public void shouldSuccessfullyDepositCurrentAccount() {
        customer.openCurrentAccount();
        BigDecimal depositAmount = BigDecimal.valueOf(1000);
        BankTransaction result = customer.depositCurrentAccount(depositAmount);

        Assertions.assertEquals(depositAmount, result.getAmount());
        Assertions.assertEquals(TransactionResult.SUCCESSFUL, result.getTransactionResult());
        Assertions.assertEquals(BigDecimal.ZERO, result.getBalanceBefore());
        Assertions.assertEquals(depositAmount, result.getBalanceAfter());
        Assertions.assertEquals(TransactionType.DEPOSIT, result.getTransactionType());
        Assertions.assertEquals(1, customer.getCurrentAccount().getTransactions().size());
    }

    @Test
    public void shouldThrowBankAccountNotOpenedWhenTryingToDepositWithoutSavingAccount() {
        BankAccountNotOpened bankAccountNotOpened = Assertions.assertThrows(BankAccountNotOpened.class, () -> customer.depositSavingAccount(BigDecimal.valueOf(1000)));
        Assertions.assertEquals("Saving Account not opened", bankAccountNotOpened.getMessage());
    }

    @Test
    public void shouldSuccessfullyDeposit() {
        customer.openSavingAccount();
        BigDecimal depositAmount = BigDecimal.valueOf(2000);
        BankTransaction result = customer.depositSavingAccount(depositAmount);

        Assertions.assertEquals(depositAmount, result.getAmount());
        Assertions.assertEquals(TransactionResult.SUCCESSFUL, result.getTransactionResult());
        Assertions.assertEquals(BigDecimal.ZERO, result.getBalanceBefore());
        Assertions.assertEquals(depositAmount, result.getBalanceAfter());
        Assertions.assertEquals(TransactionType.DEPOSIT, result.getTransactionType());
        Assertions.assertEquals(1, customer.getSavingAccount().getTransactions().size());
    }

    @Test
    public void shouldSuccessfullyWithdrawFromAccount() {
        BigDecimal withdrawAmount = BigDecimal.valueOf(500);
        BigDecimal balanceBefore = BigDecimal.valueOf(1000);
        BigDecimal balanceAfter = balanceBefore.subtract(withdrawAmount);
        customer.openCurrentAccount();
        customer.getCurrentAccount().setBalance(balanceBefore);

        BankTransaction result = customer.withdrawCurrentAccount(withdrawAmount);

        Assertions.assertEquals(withdrawAmount, result.getAmount());
        Assertions.assertEquals(TransactionResult.SUCCESSFUL, result.getTransactionResult());
        Assertions.assertEquals(balanceBefore, result.getBalanceBefore());
        Assertions.assertEquals(balanceAfter, result.getBalanceAfter());
        Assertions.assertEquals(TransactionType.WITHDRAW, result.getTransactionType());
        Assertions.assertEquals(1, customer.getCurrentAccount().getTransactions().size());
    }

    @Test
    public void shouldFailedWithdrawFromWhenNotEnoughFunds() {
        BigDecimal withdrawAmount = BigDecimal.valueOf(1500);
        BigDecimal balanceBefore = BigDecimal.valueOf(1000);
        customer.openCurrentAccount();
        customer.getCurrentAccount().setBalance(balanceBefore);

        BankTransaction result = customer.withdrawCurrentAccount(withdrawAmount);

        Assertions.assertEquals(withdrawAmount, result.getAmount());
        Assertions.assertEquals(TransactionResult.REFUSED_INSUFFICIENT_FUNDS, result.getTransactionResult());
        Assertions.assertEquals(balanceBefore, result.getBalanceBefore());
        Assertions.assertEquals(balanceBefore, result.getBalanceAfter());
        Assertions.assertEquals(TransactionType.WITHDRAW, result.getTransactionType());
        Assertions.assertEquals(1, customer.getCurrentAccount().getTransactions().size());
    }
}
