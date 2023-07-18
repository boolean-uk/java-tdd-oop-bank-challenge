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
    private List<BankTransaction> transaction;

    public BankAccount() {
        this.uuid = UUID.randomUUID();
        this.balance = BigDecimal.ZERO;
        this.transaction = new ArrayList<>(0);
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

        getTransaction().add(transaction);

        return transaction;
    }

    @Override
    public BankTransaction withdraw(BigDecimal withdraw) {
        return null;
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
