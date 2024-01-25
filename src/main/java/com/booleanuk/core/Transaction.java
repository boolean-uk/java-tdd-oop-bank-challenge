package com.booleanuk.core;

import com.migzus.terminal.menus.Utils;

public class Transaction {
    private double credit;
    private final String date;
    private final TransactionType type;

    public Transaction(double credit) {
        if (credit == 0.0)
            type = TransactionType.NULL;
        else if (credit > 0.0)
            type = TransactionType.DEPOSIT;
        else
            type = TransactionType.WITHDRAW;

        date = Utils.getDateNow();
    }

    public double getCredit() {
        return credit;
    }

    public String getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }
}
