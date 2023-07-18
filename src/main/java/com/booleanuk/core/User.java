package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.booleanuk.core.TransactionType.*;

public class User {
    private String name;
    private List<Account> accounts;

    private boolean isManager;

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

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

    public Request sendRequest(double amount, String accountNumber) {
        Account account = Bank.getAccount(accountNumber);
        Request request = new Request(amount,account);
        account.getManager().approveRequest(request);
        return request;
    }

    public boolean approveRequest(Request request) {
        //Automatically approves all request but logic can be added to set isApproved
        boolean isApproved = true;
        if(isApproved) request.account().getTransactions().add(new Transaction(WITHDRAW, request.amount()));
        else return false;
        return true;
    }
}
