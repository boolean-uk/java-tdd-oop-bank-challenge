package com.booleanuk.core;

import java.time.LocalDate;

public class Withdraw extends Transfer{
    public Withdraw(int amountOfMoney, LocalDate date) {
        super(amountOfMoney, date);
    }
}
