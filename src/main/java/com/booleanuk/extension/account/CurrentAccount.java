package com.booleanuk.extension.account;

import java.math.BigDecimal;

public class CurrentAccount extends Account {
    private boolean overdraftAllowed = false;
    private boolean overdraftRequestPending = false;

    public CurrentAccount(SwiftCode swiftCode) {
        super(swiftCode);
    }

    @Override
    public BigDecimal balance() {
        if (!overdraftAllowed) {
            return super.balance();
        }

        return transactions.stream()
                .map(t -> {
                    var modifier = BigDecimal.valueOf(t.type().getModifier());
                    return t.amount().multiply(modifier);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (!overdraftAllowed) {
            super.withdraw(amount);
            return;
        }

        transactions.add(Transaction.of(Transaction.Type.Withdrawal, amount, Transaction.Status.Accepted));
    }

    public boolean overdraftAllowed() {
        return overdraftAllowed;
    }

    public boolean overdraftRequestPending() {
        return overdraftRequestPending;
    }

    public void requestOverdraft() {
        overdraftRequestPending = true;
    }

    public void reviewOverdraftRequest(boolean approve) {
        if (!overdraftRequestPending) {
            return;
        }

        overdraftAllowed = approve;
        overdraftRequestPending = false;
    }
}
