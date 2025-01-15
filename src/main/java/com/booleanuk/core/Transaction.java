package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime date;
    private Double amount;
    private String typeOfTransaction;
    private Double newBalance;

    public Transaction(LocalDateTime date, Double amount, String typeOfTransaction, Double newBalance){
        this.date = date;
        this.amount = amount;
        this.typeOfTransaction = typeOfTransaction;
        this.newBalance = newBalance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public Double getNewBalance() {
        return newBalance;
    }

    public String formatTransactionForBankStatement(){
        String formatedTransaction = "";

        formatedTransaction = this.getDate().toString() + " || ";
        if(this.getTypeOfTransaction().equals("Withdraw")){
            formatedTransaction += "       || " + this.getAmount() + "    || " + this.getNewBalance();
        } else if (this.getTypeOfTransaction().equals("Deposit")) {
            formatedTransaction += this.getAmount() + "    ||        || " + this.getNewBalance();
        }

        return formatedTransaction;
    }
}
