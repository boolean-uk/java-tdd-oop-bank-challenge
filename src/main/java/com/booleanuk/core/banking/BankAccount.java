package com.booleanuk.core.banking;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
    public Boolean deposit(BigDecimal deposit) {
        return null;
    }

    @Override
    public Boolean withdraw(BigDecimal withdraw) {
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
