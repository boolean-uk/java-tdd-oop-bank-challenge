package com.booleanuk.core;

import java.time.LocalDate;
import java.util.Date;

public class Transfer {
    private int amountOfMoney;
    private LocalDate date;

    public Transfer(int amountOfMoney, LocalDate date) {
        this.amountOfMoney = amountOfMoney;
        this.date = date;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
