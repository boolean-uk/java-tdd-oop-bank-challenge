package com.booleanuk.core;

import java.util.List;
import java.util.Map;

public class BankSystem {
    Map<String, BankAccount> bankAccounts;
    List<OverdraftRequest> overdraftRequests;

    public Map<String, BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public List<OverdraftRequest> getOverdraftRequests() {
        return overdraftRequests;
    }
}
