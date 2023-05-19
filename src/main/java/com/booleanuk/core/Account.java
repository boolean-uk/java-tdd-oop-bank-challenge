package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {
    final static List<Account> accounts = new ArrayList<>();
    final List<ITransaction> transactions = new ArrayList<>();
    final String branch;
    public boolean overdraft;

    protected Account(String branch) {
        this.branch = branch;
    }

    public static Account create(String branch) {
        return null;
    }

    public boolean transaction(ITransaction transaction) {
        return false;
    }

    public void statement() {

    }

    public double balance() {
        return -1.0;
    }
}
