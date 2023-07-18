package com.booleanuk.extension;

import com.booleanuk.core.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}