package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BankStatement {

    private LocalDate date;
    private double currentBalance;
    private double withdrawBalance;
    private double depositBalance;
    public BankStatement(double currentBalance, double amount, Type type ){
        if(type.equals(Type.WITHDRAW)){
            this.withdrawBalance = amount;
        }
        else if(type.equals(Type.DEPOSIT)){
            this.depositBalance = amount;
        }
        this.currentBalance = currentBalance;
        this.date = LocalDateTime.now().toLocalDate();
    }

    @Override
    public String toString() {


        if(withdrawBalance > 0){
            return this.date.toString() + " ||      || " + withdrawBalance + "   || " + currentBalance;
        }
        else if(depositBalance > 0){
            return this.date.toString() + " || " + depositBalance +  " ||     || " + currentBalance;
        }
        return "";
    }
}
