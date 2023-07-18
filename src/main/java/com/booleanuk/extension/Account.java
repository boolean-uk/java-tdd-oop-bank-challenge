package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Collections;

public class Account {
    private ArrayList<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }

    public boolean deposit(float amount){
        if(amount < 0) return false;

        this.transactions.add(new Transaction(amount, 0, checkBalance()));
        return true;
    }

    public boolean withdraw(float amount){
        if(amount < 0) return false;
        if(checkBalance() < amount) return false;

        this.transactions.add(new Transaction(0, amount, checkBalance()));
        return true;
    }

    public float checkBalance() {
        float balance = 0;

        for(Transaction transaction : this.transactions){
            if(transaction.getCredit() != 0) balance += transaction.getCredit();
            else if(transaction.getDebit() != 0) balance -= transaction.getDebit();
        }

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
