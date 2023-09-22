package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Statement {
    Date date;
    double amount;
    int balance;
    String statementId;
    HashMap<String,Statement> statementsList;

    public Statement (double amount, int balance, HashMap<String,Statement> statementsList) {
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
        this.statementsList = statementsList;
        this.statementId = generateStatementId();
    }

    private String generateStatementId() {
        do {
            Random random = new Random();
            this.statementId = String.format("%05d", random.nextInt(100000));
        } while (statementsList.containsKey(statementId));
        return statementId;
    }

    public String getStatementId() {
        return this.statementId;
    }

    @Override
    public String toString(){
        double balanceToDouble = (double) (balance / 100.00);
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formatedDate = formater.format(this.date);
        return formatedDate + "  |  " + this.amount + "   |  " + balanceToDouble;
    }
}
