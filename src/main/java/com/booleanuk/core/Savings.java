package com.booleanuk.core;
import java.time.LocalDate;

public class Savings {
    Currency savingsAmount;
    LocalDate date;

    public Savings(Currency savingsAmount, LocalDate date){
        this.savingsAmount = savingsAmount;
        this.date = date;
    }
}
