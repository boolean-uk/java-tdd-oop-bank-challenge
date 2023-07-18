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
        BigDecimal balance = BigDecimal.valueOf(0);
        statements.forEach(transaction -> {
            balance.add(transaction.getValue());
        });

        return balance;
    }
}
