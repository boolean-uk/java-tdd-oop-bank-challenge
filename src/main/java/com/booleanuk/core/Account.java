package com.booleanuk.core;

import java.math.BigDecimal;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Account {


    private Client client;
    private String accountNumber;
    private BigDecimal debit;

    private BigDecimal overdraft;

    private Branch branch;


    private ArrayList<Transaction> statements;



    public Account(Client client) {
        this.client = client;
        accountNumber = ((int)(Math.random()*999999) +100000)+"";
        statements = new ArrayList<>();
        debit = BigDecimal.ZERO;
        overdraft = BigDecimal.ZERO;
    }
    public Account(Client client,Branch branch) {
        this.client = client;
        accountNumber = ((int)(Math.random()*999999) +100000)+"";
        statements = new ArrayList<>();
        debit = BigDecimal.ZERO;
        this.branch = branch;
        overdraft = BigDecimal.ZERO;
    }
    public Account(Client client, String accountNumber,Branch branch) {
        this.client = client;
        this.accountNumber = accountNumber;
        statements = new ArrayList<>();
        debit = BigDecimal.ZERO;
        this.branch = branch;
        overdraft = BigDecimal.ZERO;
    }


    public BigDecimal getBalance() {
        return getStatements().stream()
                .map(transaction -> transaction.getCredit().equals(BigDecimal.ZERO) ? transaction.getDebit() : transaction.getCredit())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
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

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Branch getBranch() {
        return branch;
    }

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }
}
