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
    public void shouldThrowBankAccountNotOpenedWhenTryingToDepositWithoutAccount() {
        BankAccountNotOpened bankAccountNotOpened = Assertions.assertThrows(BankAccountNotOpened.class, () -> customer.depositCurrentAccount(BigDecimal.valueOf(1000)));
        Assertions.assertEquals("Current Account not opened", bankAccountNotOpened.getMessage());
    }

    @Test
    public void shouldSuccessfullyDeposit() {
        customer.openCurrentAccount();
        BigDecimal transactionAmount = BigDecimal.valueOf(1000);
        BankTransaction result = customer.depositCurrentAccount(transactionAmount);

        Assertions.assertEquals(transactionAmount, result.getAmount());
        Assertions.assertEquals(TransactionResult.SUCCESSFUL, result.getTransactionResult());
        Assertions.assertEquals(BigDecimal.ZERO, result.getBalanceBefore());
        Assertions.assertEquals(transactionAmount, result.getBalanceAfter());
        Assertions.assertEquals(TransactionType.DEPOSIT, result.getTransactionType());
    }
}
