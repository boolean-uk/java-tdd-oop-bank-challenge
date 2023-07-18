package com.booleanuk.core;

import java.sql.Statement;
import java.util.ArrayList;

public class Account {


    private Client client;
    private String accountNumber;

    ArrayList<Transaction> statements;



    public Account(Client client) {
        this.client = client;
        accountNumber = ((int)(Math.random()*999999) +100000)+"";
        statements = new ArrayList<Transaction>();
    }
    public Account(Client client, String accountNumber) {
        this.client = client;
        this.accountNumber = accountNumber;
    }


}
