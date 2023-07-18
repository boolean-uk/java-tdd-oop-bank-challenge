package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public static String generateAccountNumber() {
        return "TODO";
    }


}
