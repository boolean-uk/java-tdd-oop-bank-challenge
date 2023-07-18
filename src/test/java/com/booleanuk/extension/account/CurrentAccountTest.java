package com.booleanuk.extension.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentAccountTest {
    private CurrentAccount ACCOUNT;

    @BeforeEach
    void accountSetup() {
        ACCOUNT = new CurrentAccount(SwiftCode.CITIUS33XXX);
    }

    @Test
    void constructor_shouldCreateAccountWithoutOverdraftAllowedAndNoOverdraftRequest() {
        assertThat(ACCOUNT.overdraftAllowed())
                .isFalse();
        assertThat(ACCOUNT.overdraftRequestPending())
                .isFalse();
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
    void balance_shouldNotGoBelow0ForNonOverdraftAccount() {
        for (int i = 0; i < 3; i++) {
            ACCOUNT.withdraw(BigDecimal.TEN);
        }

        assertThat(ACCOUNT.balance())
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void balance_shouldGoBelow0ForOverdraftAccount() {
        ACCOUNT.requestOverdraft();
        ACCOUNT.reviewOverdraftRequest(true);

        for (int i = 0; i < 3; i++) {
            ACCOUNT.withdraw(BigDecimal.TEN);
        }

        assertThat(ACCOUNT.balance())
                .isEqualTo(BigDecimal.valueOf(-30));
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

    @Test
    void requestOverdraft_shouldSetPendingStatusToTrueAndNotChangeOverdraftPermission() {
        ACCOUNT.requestOverdraft();

        assertThat(ACCOUNT.overdraftAllowed())
                .isFalse();
        assertThat(ACCOUNT.overdraftRequestPending())
                .isTrue();
    }

    @Test
    void reviewOverdraftRequest_shouldDoNothingForNoPendingRequest() {
        ACCOUNT.reviewOverdraftRequest(true);

        assertThat(ACCOUNT.overdraftAllowed())
                .isFalse();
    }

    @Test
    void reviewOverdraftRequest_shouldAcceptPendingRequest() {
        ACCOUNT.requestOverdraft();
        ACCOUNT.reviewOverdraftRequest(true);

        assertThat(ACCOUNT.overdraftAllowed())
                .isTrue();
        assertThat(ACCOUNT.overdraftRequestPending())
                .isFalse();
    }

    @Test
    void reviewOverdraftRequest_shouldRejectPendingRequest() {
        ACCOUNT.requestOverdraft();
        ACCOUNT.reviewOverdraftRequest(false);

        assertThat(ACCOUNT.overdraftAllowed())
                .isFalse();
        assertThat(ACCOUNT.overdraftRequestPending())
                .isFalse();
    }
}