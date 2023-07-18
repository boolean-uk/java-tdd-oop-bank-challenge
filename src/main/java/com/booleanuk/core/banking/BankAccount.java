package com.booleanuk.core.banking;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


abstract class BankAccount implements BankOperations {
    private UUID uuid;
    private BigDecimal balance;

    private List<BankTransaction> transaction;

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
