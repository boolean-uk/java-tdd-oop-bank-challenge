package com.booleanuk.core;

import java.math.BigDecimal;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Account {


    private Client client;
    private String accountNumber;


    private ArrayList<Transaction> statements;



    public Account(Client client) {
        this.client = client;
        accountNumber = ((int)(Math.random()*999999) +100000)+"";
        statements = new ArrayList<>();
    }
    public Account(Client client, String accountNumber) {
        this.client = client;
        this.accountNumber = accountNumber;
        statements = new ArrayList<>();
    }


    public BigDecimal getBalance() {
        BigDecimal balance = statements.stream()
                .map(Transaction::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return balance;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ArrayList<Transaction> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<Transaction> statements) {
        this.statements = statements;
    }
}
