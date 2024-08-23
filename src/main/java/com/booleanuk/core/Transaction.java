package com.booleanuk.core;


import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime localDateTime = LocalDateTime.now();
    private int amount;
    private String type;

    Transaction(LocalDateTime localDateTime, int amount, String type) {
        this.localDateTime = localDateTime;
        this.amount = amount;
        this.type = type;
    }
}
