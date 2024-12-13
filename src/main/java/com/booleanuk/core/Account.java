package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;

public class Account {
    private float balance;
    private ArrayList<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public boolean deposit(float amount){
        if(amount < 0) return false;

        this.balance += amount;
        this.transactions.add(new Transaction(amount, 0, this.balance));
        return true;
    }

    public boolean withdraw(float amount){
        if(amount < 0) return false;
        if(this.balance < amount) return false;

        this.balance -= amount;
        this.transactions.add(new Transaction(0, amount, this.balance));
        return true;
    }

    public float checkBalance() {
        return balance;
    }

    public String generateBankStatement() {
        StringBuilder bankStatement = new StringBuilder();

        bankStatement
                .append("date      || credit  || debit  || balance\n");

        Collections.reverse(this.transactions);

        for (Transaction transaction : this.transactions){
            bankStatement
                    .append(transaction.getDate().getDayOfMonth() + "/"
                            + transaction.getDate().getMonthValue() + "/"
                            + transaction.getDate().getYear() + " || "
                            + (transaction.getCredit() == 0 ? "       " : String.format("%.2f", transaction.getCredit())) + " || "
                            + (transaction.getDebit() == 0 ? "      " : String.format("%.2f", transaction.getDebit())) + " || "
                            + String.format("%.2f", transaction.getBalance()) + "\n");
        }

        Collections.reverse(this.transactions);

        return bankStatement.toString();
    }
}
