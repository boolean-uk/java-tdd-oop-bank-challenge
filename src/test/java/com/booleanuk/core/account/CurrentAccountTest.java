package com.booleanuk.core.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CurrentAccountTest {
    private Account ACCOUNT;

    @BeforeEach
    void accountSetup() {
        ACCOUNT = new CurrentAccount();
    }

    @Test
    void constructor_shouldCreateAccountWith0Balance() {
        assertThat(ACCOUNT.getBalance())
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void deposit_shouldIncreaseBalanceAndAddTransactionToHistory() {
        var expectedBalance = BigDecimal.TEN;
        ACCOUNT.deposit(expectedBalance);

        assertThat(ACCOUNT.getBalance())
                .isEqualTo(expectedBalance);
        var transaction = ACCOUNT.getTransactions().get(0);
        assertThat(transaction.amount())
                .isEqualTo(expectedBalance);
        assertThat(transaction.type())
                .isEqualTo(Transaction.Type.Deposit);
    }

    @Test
    void withdraw_shouldReduceBalanceForSufficientBalanceAndAddTransactionToHistory() {
        var expectedBalance = BigDecimal.valueOf(9);
        ACCOUNT.deposit(BigDecimal.TEN);

        ACCOUNT.withdraw(BigDecimal.ONE);

        assertThat(ACCOUNT.getBalance())
                .isEqualTo(expectedBalance);
        var transaction = ACCOUNT.getTransactions().get(1);
        assertThat(transaction.amount())
                .isEqualTo(BigDecimal.ONE);
        assertThat(transaction.type())
                .isEqualTo(Transaction.Type.Withdrawal);
    }

    @Test
    void withdraw_shouldThrowForInsufficientBalanceAndNotAddTransactionToHistory() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> ACCOUNT.withdraw(BigDecimal.ONE))
                .withMessageContaining("insufficient funds");
        assertThat(ACCOUNT.getTransactions())
                .isEmpty();
    }
}