package com.booleanuk.core;

import java.time.LocalDate;

public class Deposit extends Transfer{
    public Deposit(int amountOfMoney, LocalDate date) {
        super(amountOfMoney, date);
    }
}
