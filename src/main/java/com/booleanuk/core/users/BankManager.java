package com.booleanuk.core.users;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.StandardAccount;
import com.booleanuk.core.accounts.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankManager extends User{
    protected static int managerCount = 0;
    private List<Customer> customers;
    private List<Transaction> overdraftRequests;
    public BankManager(String name, String surname, String login, String password, String branchID) {
        super(name, surname, login, password, branchID);
        managerCount += 1;
        String id = "user" + managerCount;
        this.setId(id);
        this.customers = new ArrayList<>();
        this.overdraftRequests = new ArrayList<>();
    }

    public void decideOverdraft(Transaction overdraftRequest, boolean accept){
        if(overdraftRequest.getAccount() instanceof StandardAccount){
            overdraftRequest.setAccepted(accept);
            double overdraft = overdraftRequest.getAccount().calculateBalance(LocalDateTime.now());
            double maxOverdraft = Math.min(overdraft, 0.0);
            setMaxOverdraft((StandardAccount) overdraftRequest.getAccount(), maxOverdraft);
        } else{
            overdraftRequest.setAccepted(false);
        }
    }

    public void addOverdraftRequest(Transaction overdraftRequest){
        this.overdraftRequests.add(overdraftRequest);
    }

    public void setMaxOverdraft(StandardAccount account, double amount){
        account.setMaxOverdraft(amount);
    }

    public void addCustomer(Customer c){
        this.customers.add(c);
    }

    public static int getManagerCount() {
        return managerCount;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
