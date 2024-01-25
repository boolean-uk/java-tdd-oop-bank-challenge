package com.booleanuk.core;

import java.util.ArrayList;

public class BankStatement {
    ArrayList<Transaction> transactions = new ArrayList<>();
    public void add(Transaction transaction) {
        transactions.add(transaction);
    }
    public void printBankStatement() {
        System.out.printf("%-12s%-12s%-12s%-12s\n", "Date", "Credit", "Debit", "Balance");
        for (Transaction transaction : transactions) {
            System.out.printf("%-12s%-12s%-12s%-12s\n", transaction.getLocalDate(), transaction.getCredit(), transaction.getDebit(), transaction.getBalance());
        }
    }
}
