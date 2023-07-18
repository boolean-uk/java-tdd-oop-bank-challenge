package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount extends BankAccount{

    private List<Transaction> transactions;

    public CurrentAccount() {
        transactions = new ArrayList<>();
    }
}
