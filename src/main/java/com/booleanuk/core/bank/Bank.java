package com.booleanuk.core.bank;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.AccountType;
import com.booleanuk.core.accounts.CurrentAccount;
import com.booleanuk.core.accounts.SavingsAccount;
import com.booleanuk.core.idgenerator.IdGenerator;
import com.booleanuk.core.idgenerator.IdPrefix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private IdGenerator idGenerator;
    private Map<String, User> customers;
    private Map<String, Request> requests;

    public Bank() {
        this.customers = new HashMap<>();
        this.requests = new HashMap<>();
        this.idGenerator = new IdGenerator();
    }

    public User createUser(String personalNumber) {
        User customer = new User(personalNumber);
        this.customers.put(personalNumber, customer);
        return customer;
    }

    public void createUserAccount(User user, AccountType type) {

        String id = idGenerator.createId(IdPrefix.AC);

        if (type == AccountType.CURRENT) {
            Account currentAccount = new CurrentAccount(id);
            user.addAccount(currentAccount);

        } else if (type == AccountType.SAVINGS) {
            Account savingsAccount = new SavingsAccount(id);
            user.addAccount(savingsAccount);
        }
    }

    public ArrayList<Request> getAllRequests() {
        ArrayList<Request> list = new ArrayList<>(requests.values());
        Collections.reverse(list);

        return list;
    }

    private void addRequest(Request request) {
        this.requests.put(request.getId(), request);
    }

    public void makeRequest(Account account, Double overdraftSum) {
        String id = this.idGenerator.createId(IdPrefix.RE);

        Request request = new Request(id, account, overdraftSum);
        this.addRequest(request);
    }

    private void removeRequest(String requestId) {
        this.requests.remove(requestId);
    }
}
