package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Withdraw implements BankStatement{

    private double amount;
    private LocalDate date;

    public double amount(){return this.amount;};

    public LocalDate date(){return this.date = LocalDate.now();};

    public double signedAmount(){return -amount();}

    public Withdraw(double amount){
        this.amount = amount;
        this.date = date;
    }


}
