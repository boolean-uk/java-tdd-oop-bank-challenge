package com.booleanuk.core;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class Customer {

   private final String owner;
   private List<Account> accounts;

    public Customer(String owner) {
        this.owner = owner;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public boolean depositFounds(double amount, Account account, DateFormat date) {
        return account.changeBalance(amount, date);
    }

    public boolean withdrawFounds(double amount, Account account, DateFormat date) {
        return account.changeBalance(-amount, date);
    }

    public double showCurrentBalance(Account account) {
        return account.getBalance();
    }

    public String printBankStatements(Account account) {
        StringBuilder output = new StringBuilder();
        if (account.getStatements().isEmpty()) {
            return "No bank statements has been made for this account";
        }
        output.append(" date      || credit   || debit    || balance  \n");
        for (BankStatement statement : account.getStatements()) {

        }
        return "";
    }
}
