package com.booleanuk.core;

import java.time.LocalDate;

public class Deposit implements BankStatement{
    private LocalDate date;
    private double amount;

    public LocalDate date(){return this.date = LocalDate.now();};
    public double amount(){ return this.amount;};

    public double signedAmount(){ return +amount();};

    public Deposit( double amount){
      //  this.date = date;
        this.amount = amount;
    }


}
