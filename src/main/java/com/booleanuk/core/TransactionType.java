package com.booleanuk.core;

public enum TransactionType {
    DEPOSIT("Credit"),
    WITHDRAW("Debit");

    private String type;

    TransactionType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}

