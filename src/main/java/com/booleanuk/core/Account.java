package com.booleanuk.core;

public class Account {


    private Client client;
    private String accountNumber;



    public Account(Client client) {
        this.client = client;
        accountNumber = ((int)(Math.random()*999999) +100000)+"";
    }
    public Account(Client client, String accountNumber) {
        this.client = client;
        this.accountNumber = accountNumber;
    }
}
