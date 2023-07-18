package com.booleanuk.extension.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class SavingsAccountTest {
    private SavingsAccount ACCOUNT;

    @BeforeEach
    void setupAccount() {
        ACCOUNT = new SavingsAccount(SwiftCode.CITIGB2L);
    }

    @Test
    void balance_shouldReturn0ForNoTransactions() {
        assertThat(ACCOUNT.balance())
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void balance_shouldReturnCorrectAmountForSingleTransaction() {
        ACCOUNT.deposit(BigDecimal.TEN);

        assertThat(ACCOUNT.balance())
                .isEqualTo(BigDecimal.TEN);
    }

    @Test
    void balance_shouldReturnCorrectAmountForMultipleTransactions() {
        ACCOUNT.deposit(BigDecimal.TEN);
        ACCOUNT.deposit(BigDecimal.TEN);
        ACCOUNT.withdraw(BigDecimal.TEN);
        ACCOUNT.withdraw(BigDecimal.ONE);

        assertThat(ACCOUNT.balance())
                .isEqualTo(BigDecimal.valueOf(9));
    }

    @Test
    void balance_shouldNeverGoBelow0() {
        for (int i = 0; i < 3; i++) {
            ACCOUNT.withdraw(BigDecimal.TEN);
        }

        assertThat(ACCOUNT.balance())
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void deposit_shouldAddTransactionToHistory() {
        var expectedBalance = BigDecimal.TEN;
        ACCOUNT.deposit(expectedBalance);

        var transaction = ACCOUNT.getTransactions().get(0);
        assertThat(transaction.amount())
                .isEqualTo(expectedBalance);
        assertThat(transaction.type())
                .isEqualTo(Transaction.Type.Deposit);
        assertThat(transaction.status())
                .isEqualTo(Transaction.Status.Accepted);
    }

    @Test
    void withdraw_shouldAddAcceptedTransactionToHistory() {
        ACCOUNT.deposit(BigDecimal.TEN);

        ACCOUNT.withdraw(BigDecimal.ONE);

        var transaction = ACCOUNT.getTransactions().get(1);
        assertThat(transaction.amount())
                .isEqualTo(BigDecimal.ONE);
        assertThat(transaction.type())
                .isEqualTo(Transaction.Type.Withdrawal);
        assertThat(transaction.status())
                .isEqualTo(Transaction.Status.Accepted);
    }

    @Test
    void withdraw_shouldAddRejectedTransactionToHistory() {
        ACCOUNT.withdraw(BigDecimal.ONE);

        var transaction = ACCOUNT.getTransactions().get(0);
        assertThat(transaction.amount())
                .isEqualTo(BigDecimal.ONE);
        assertThat(transaction.type())
                .isEqualTo(Transaction.Type.Withdrawal);
        assertThat(transaction.status())
                .isEqualTo(Transaction.Status.Rejected);
    }
}