package com.booleanuk.core;

import java.util.List;
import java.util.Map;

public class BankStatement {
    User owner;
    private Map<String, List<Transaction>> transactions;

    public BankStatement(User owner, Map<String, List<Transaction>> transactions) {
        this.owner = owner;
        this.transactions = transactions;
    }

    public User getOwner() {
        return owner;
    }

    public Map<String, List<Transaction>> getTransactions() {
        return transactions;
    }
}
