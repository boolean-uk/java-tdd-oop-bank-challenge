package com.booleanuk.core;

import com.migzus.terminal.menus.Utils;

public class Transaction {
    private final double credit;
    private final String date;
    private final TransactionType type;

    public Transaction(double credit) {
        if (credit == 0.0) {
            type = TransactionType.NULL;
            this.credit = 0.0;
        }
        else if (credit > 0.0) {
            type = TransactionType.DEPOSIT;
            this.credit = credit;
        }
        else {
            type = TransactionType.WITHDRAW;
            this.credit = -credit; // reverse credit
        }

        date = Utils.getDateNow();
    }

    public Transaction(double credit, String date, TransactionType type) {
        this.credit = credit;
        this.date = date;
        this.type = type;
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

    public Transaction clone() {
        try {
            return (Transaction) super.clone();
        }
        catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
