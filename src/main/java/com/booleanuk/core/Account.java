package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private double balance;
    private List<Transaction> transactions;

    public Account(){
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }

    public String generateBankStatements(List<Transaction> transactions){
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        sb.append("Date\t\t\t\t|| Credit\t|| Debit\t|| Balance\t||\n");
        for (Transaction transaction : transactions) {
            sb.append(transaction.getDate().format(formatter)).append("\t||\t");
            if(transaction.getCredit() == 0){
                sb.append(transaction.getCredit()).append("\t\t||\t");
            }else sb.append(transaction.getCredit()).append("\t||\t");
            if(transaction.getDebit() == 0){
                sb.append(transaction.getDebit()).append("\t\t||\t");
            } else sb.append(transaction.getDebit()).append("\t||\t");
            sb.append(transaction.getBalance()).append("\t||\t\n");
        }
        return sb.toString();
    }


    public double getBalance(){
        double balance = 0.00;
        for (int i = 0; i < this.getTransactions().size(); i++) {
            balance += this.getTransactions().get(i).getBalance();
        }
        return this.balance = balance;
    }

    public void withdraw(double withdraw){
        if(this.balance - withdraw < 0){
            System.out.println("Unable to withdraw more than balance!");
            return;
        }
        LocalDateTime dateTime = LocalDateTime.now();
        this.balance -= withdraw;
        transactions.add(new Transaction(dateTime,withdraw, 0, this.balance));
    }

    public void deposit(double deposit){
        LocalDateTime dateTime = LocalDateTime.now();
        this.balance += deposit;
        transactions.add(new Transaction(dateTime,0, deposit, this.balance));

    }
}
