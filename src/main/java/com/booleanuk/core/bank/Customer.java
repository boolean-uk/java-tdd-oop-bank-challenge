package com.booleanuk.core.bank;

import java.util.ArrayList;

public class Customer {

    private final String id;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;
    private ArrayList<Overdraft> overdrafts;

    public Customer() {
        this.id = "";
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.overdrafts = new ArrayList<>();
    }

    public Customer(String id) {
        this.id = id;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.overdrafts = new ArrayList<>();
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

    public ArrayList<String> getTransactionPrintout() { // Returns an ArrayList with Strings, each String should be printed out on own line
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

    public double getBalance(Account account) { //  Returns the balance of the given account
        double balance = 0;
        for (Transaction transaction : this.transactions) {
            if (transaction.getFromAccount().getAccountNumber().equals(account.getAccountNumber())) {
                if (transaction.getTransactionType() == Transaction.TransactionType.CREDIT)
                    balance += transaction.getAmount();
                else
                    balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    protected void registerOverdraft(Overdraft o) {
        this.overdrafts.add(o);
    }

    public ArrayList<Overdraft> getOverdrafts(Account a) {
        ArrayList<Overdraft> toReturn = new ArrayList<>();
        for (Overdraft o : this.overdrafts) {
            if (o.getAccount().getAccountNumber().equals(a.getAccountNumber())) toReturn.add(o);
        }
        return toReturn;
    }

    public ArrayList<Overdraft> getAllOverdrafts() {
        return this.overdrafts;
    }

    public ArrayList<Overdraft> getOverdrafts(Overdraft.OverdraftStatus status) {
        ArrayList<Overdraft> toReturn = new ArrayList<>();
        for (Overdraft o : this.overdrafts) if (o.getStatus() == status) toReturn.add(o);
        return toReturn;
    }

}
