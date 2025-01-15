package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private Double amount;
    private String typeOfTransaction;

    public Transaction(LocalDateTime date, Double amount, String typeOfTransaction){
        this.date = date;
        this.amount = amount;
        this.typeOfTransaction = typeOfTransaction;
    }
}
