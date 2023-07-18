package com.booleanuk.core.banking;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
abstract class BankAccount implements BankOperations {
    private final UUID uuid;
    private BigDecimal balance;
    private List<BankTransaction> transactions;

    public BankAccount() {
        this.uuid = UUID.randomUUID();
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>(0);
    }

    @Override
    public BankTransaction deposit(BigDecimal deposit) {

        BigDecimal newCurrentBalance = getBalance().add(deposit);
        BigDecimal balanceBefore = getBalance();
        this.balance = newCurrentBalance;

        BankTransaction transaction =
                BankTransaction.builder()
                        .createdAt(Instant.now())
                        .transactionType(TransactionType.DEPOSIT)
                        .balanceBefore(balanceBefore)
                        .amount(deposit)
                        .balanceAfter(newCurrentBalance)
                        .transactionResult(TransactionResult.SUCCESSFUL)
                        .build();

        transactions.add(transaction);

        return transaction;
    }

    @Override
    public BankTransaction withdraw(BigDecimal withdrawAmount) {
        if (isEnoughBalanceToWithdraw(withdrawAmount)) {
            BigDecimal balanceBefore = getBalance();
            this.balance = balanceBefore.subtract(withdrawAmount);

            BankTransaction bankTransaction = BankTransaction.builder()
                    .transactionType(TransactionType.WITHDRAW)
                    .createdAt(Instant.now())
                    .balanceBefore(balanceBefore)
                    .balanceAfter(getBalance())
                    .amount(withdrawAmount)
                    .transactionResult(TransactionResult.SUCCESSFUL)
                    .build();

            transactions.add(bankTransaction);
            return bankTransaction;
        }
        BankTransaction bankTransaction = BankTransaction.builder()
                .transactionType(TransactionType.WITHDRAW)
                .createdAt(Instant.now())
                .balanceBefore(getBalance())
                .balanceAfter(getBalance())
                .amount(withdrawAmount)
                .transactionResult(TransactionResult.REFUSED_INSUFFICIENT_FUNDS)
                .build();

        transactions.add(bankTransaction);

        return bankTransaction;


    }

    private boolean isEnoughBalanceToWithdraw(BigDecimal withdrawAmount) {
        return withdrawAmount.compareTo(getBalance()) <= 0;
    }

    @Override
    public String generateBankStatements() {
        return null;
    }

    @Override
    public Boolean payWithCard(BigDecimal amount) {
        return null;
    }

    @Override
    public Boolean payOnline(BigDecimal amount) {
        return null;
    }
}
