package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Customer {

    private String id;

    private Map<String, Account> accounts;

    public Customer(){
        this.id = UUID.randomUUID().toString();
        accounts = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}
