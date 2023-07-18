package com.booleanuk.core.users;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.OverdraftRequest;

import java.util.ArrayList;
import java.util.List;

public class BankManager extends User{
    protected static int managerCount = 0;
    private List<Customer> customers;
    public BankManager(String name, String surname, String login, String password, String branchID) {
        super(name, surname, login, password, branchID);
        this.customers = new ArrayList<>();
    }

    public boolean decideOverdraft(OverdraftRequest overdraftRequest){
        return false;
    }

    public void setMaxOverdraft(Account account, double amount){}

    public static int getManagerCount() {
        return managerCount;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
