package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private List<Account> accounts;

    public User(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public BankStatement generateStatement() {
        Map<Account, List<Transaction>> transactionMap = this.getAccounts().stream()
                .collect(Collectors.toMap(account -> account,Account::getTransactions));
        return new BankStatement(this,transactionMap);

    }
    public void printStatement(){
        System.out.println(this.generateStatement().toString());
    }
}
