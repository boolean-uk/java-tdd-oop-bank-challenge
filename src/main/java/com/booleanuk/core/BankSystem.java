package com.booleanuk.core;

import java.util.List;
import java.util.Map;

public class BankSystem {
    Map<String, BankAccount> bankAccounts;
    List<OverdraftRequest> overdraftRequests;
    Map<String, SavingsAccount> savingsAccounts;

    // maybe void?
    public boolean approve(OverdraftRequest or) {
        return savingsAccounts.get(or.accountNumber + or.branchNumber).setMaxOverdraft(or.getAmount());
    }

    public Map<String, BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public List<OverdraftRequest> getOverdraftRequests() {
        return overdraftRequests;
    }
}
