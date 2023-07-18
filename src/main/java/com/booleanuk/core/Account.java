package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {;

    private final UUID id;
    private final Customer holder;
    private BigDecimal balance;
    private final List<Transaction> transactions;

    public Account(Customer holder) {
        this.id = UUID.randomUUID();
        this.holder = holder;
        balance = BigDecimal.ZERO;
        transactions = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }
}
