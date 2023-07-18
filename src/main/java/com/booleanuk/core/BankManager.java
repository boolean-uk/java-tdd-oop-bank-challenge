package com.booleanuk.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BankManager {
    LinkedHashMap<String, List<BankAccount>> banks;

    public BankManager() {
        banks = new LinkedHashMap<>();
    }

    public List<BankAccount> getBanks(String bankName) {
        return banks.get(bankName);
    }

    public void addBank(String key, BankAccount bankAccount) {
        if(banks.containsKey(key)) {
            banks.get(key).add(bankAccount);
            return;
        }
        banks.put(key, new ArrayList<>());
        banks.get(key).add(bankAccount);
    }
}
