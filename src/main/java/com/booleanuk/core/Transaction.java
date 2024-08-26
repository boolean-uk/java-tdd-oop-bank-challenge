package com.booleanuk.core;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String date;
    private double deposit;
    private double withdrawal;
    private double balance;
    LocalDateTime dater = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");



    Transaction(double credit, double debit, double balance){
        this.date = dater.format(formatter);
        this.deposit = deposit;
        this.withdrawal = withdrawal;
        this.balance = balance;

    }


}
