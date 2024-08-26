package com.booleanuk.core.bank;

import java.util.ArrayList;

public class Customer {

    private final String id;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Customer() {
        this.id = "";
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public Customer(String id) {
        this.id = id;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public String getId() {
        return id;
    }

    protected void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }

    public Account getAccount(String accountNumber) {
        for (Account a : this.accounts) if (a.getAccountNumber().equals(accountNumber)) return a;
        return null;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    protected void addTransaction(Transaction newTransaction) {
        this.transactions.addFirst(newTransaction);
    }

    public ArrayList<String> getTransactionPrintout() {
        ArrayList<String> toReturn = new ArrayList<>();

        toReturn.add("date \t\t || credit \t\t || debit \t\t || balance");

        for (Transaction t : this.transactions) {
            double balance = 0;
            String toAdd = "";
            toAdd += t.getDate() + "   || ";
            if (t.getTransactionType() == Transaction.TransactionType.CREDIT) { // Credit
                toAdd += t.getAmount();
                toAdd += " || ";
                balance = t.getBalanceBeforeTransaction() + t.getAmount();
            } else { // Debit
                toAdd += "\t\t || ";
                toAdd += t.getAmount();
                toAdd += " || ";
                balance = t.getBalanceBeforeTransaction() - t.getAmount();
            }

            toAdd += balance;

            toReturn.add(toAdd);
        }

        return toReturn;
    }

}
