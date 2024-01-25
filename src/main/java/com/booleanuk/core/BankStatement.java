package com.booleanuk.core;

import com.booleanuk.core.enums.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankStatement implements Serializable {

    private final LocalDate date;
    private final double currentBalance;
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
