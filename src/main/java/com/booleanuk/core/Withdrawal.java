package com.booleanuk.core;

import java.time.LocalDate;

public class Withdrawal {
    Currency withdrawalAmount;
    LocalDate date;

    public Withdrawal(Currency withdrawalAmount, LocalDate date){
        this.withdrawalAmount = withdrawalAmount;
        this.date = date;
    }
}
