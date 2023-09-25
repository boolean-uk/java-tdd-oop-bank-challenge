package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void generateBankStatement(Account account) {
        System.out.println("Bank Statement for Account Number: " + account.getAccountNumber());
        List<Transaction> transactions = account.getHistory();
        Collections.reverse(transactions);

        System.out.println("date       || credit  || debit  || balance");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDate() +
                    " || " + (transaction.getCredit() != 0 ? transaction.getCredit() : "        ") +
                    " || " + (transaction.getDebit() != 0 ? transaction.getDebit() : "      ") +
                    " || " + transaction.getBalance());
        }
    }
}
