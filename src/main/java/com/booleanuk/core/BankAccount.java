package com.booleanuk.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BankAccount {
    LinkedHashMap<String, List<Transaction>> accounts;

    public BankAccount() {
        accounts = new LinkedHashMap<>();
        accounts.put("main", new ArrayList<>());
    }

    public boolean makeTransaction(String accountName, Transaction transaction) {
        if(!accounts.containsKey(accountName))
            return false;

        accounts.get(accountName).add(transaction);
        return true;
    }
}
