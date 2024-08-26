package com.booleanuk.core.bank;

import com.booleanuk.core.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private String name;
    private IdGenerator idGenerate;
    //    private ArrayList<Customer> customers;
    private HashMap<String, Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.idGenerate = new IdGenerator();
        this.customers = new HashMap<>();
    }

    // newCustomer does not contain any data, just "future proof" incase want to add names, address, etc.
    public Customer addCustomer(Customer newCustomer) {

        // Generating a new customer id
        String newId = "";
        do {
            newId = this.idGenerate.generateId(10);
        } while (this.customers.containsKey(newId));

        Customer toAdd = new Customer(newId);
        this.customers.put(newId, toAdd);
        return toAdd;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(this.customers.values());
    }

    public Account newAccount(Customer customer, Account newAccount) {
        if (!this.customers.containsKey(customer.getId())) return null;

        // Generating a new account number
        String newAccountNumber = "";
        do {
            newAccountNumber = this.idGenerate.generateId(5);
        } while (this.checkIfAccountNumberExists(newAccountNumber));

        newAccount.setAccountNumber(newAccountNumber);
        this.customers.get(customer.getId()).addAccount(newAccount);
        return newAccount;
    }

    private boolean checkIfAccountNumberExists(String newAccountNumber) {
        for (Customer c : this.customers.values()) {
            for (Account a : c.getAccounts()) if (a.getAccountNumber().equals(newAccountNumber)) return true;
        }
        return false;
    }

    private boolean checkIfTransactionIdExists(String newTransactionId) {
        for (Customer c : this.customers.values()) {
            for (Transaction t : c.getTransactions()) if (t.getId().equals(newTransactionId)) return true;
        }
        return false;
    }

    public boolean deposit(Customer customer, Account account, double amount) {
        if (!this.customers.containsKey(customer.getId())) return false;
        if (this.customers.get(customer.getId()).getAccount(account.getAccountNumber()) == null) return false;

        Customer actualCustomer = this.customers.get(customer.getId());
        Account actualAccount = actualCustomer.getAccount(account.getAccountNumber());

        if (!this.checkIfAccountNumberExists(actualAccount.getAccountNumber())) return false;

        actualCustomer.addTransaction(new Transaction(amount, actualCustomer.getBalance(actualAccount), actualCustomer.getAccount(account.getAccountNumber()), this.generateTransactionId(), Transaction.TransactionType.CREDIT));

        return true;
    }

    public boolean withdraw(Customer customer, Account account, double amount) {
        if (!this.customers.containsKey(customer.getId())) return false;
        if (this.customers.get(customer.getId()).getAccount(account.getAccountNumber()) == null) return false;

        Customer actualCustomer = this.customers.get(customer.getId());
        Account actualAccount = actualCustomer.getAccount(account.getAccountNumber());

        if (!this.checkIfAccountNumberExists(actualAccount.getAccountNumber())) return false;

        actualCustomer.addTransaction(new Transaction(amount, actualCustomer.getBalance(actualAccount), actualCustomer.getAccount(account.getAccountNumber()), this.generateTransactionId(), Transaction.TransactionType.DEBIT));

        return true;
    }

    private String generateTransactionId() {
        String newTransactionId = "";
        do {
            newTransactionId = this.idGenerate.generateId(5);
        } while (this.checkIfTransactionIdExists(newTransactionId));
        return newTransactionId;
    }

    public ArrayList<Transaction> getStatements(Customer customer) {
        return this.customers.get(customer.getId()).getTransactions();
    }

    public boolean requestOverdraft(Customer c, Account a, double amount) {
        // Check if given custom even exists
        if (!this.customers.containsKey(c.getId())) return false;

        // Check if given account is owned by the given customer
        if (this.customers.get(c.getId()).getAccount(a.getAccountNumber()) == null) return false;

        Overdraft overdraft = new Overdraft(this.generateOverdraftId(), a, amount);
        this.customers.get(c.getId()).registerOverdraft(overdraft);
        return true;
    }

    private String generateOverdraftId() {
        String newOverdraftId = "";
        do {
            newOverdraftId = this.idGenerate.generateId(6);
        } while (this.checkIfOverdraftIdExists(newOverdraftId));
        return newOverdraftId;
    }

    private boolean checkIfOverdraftIdExists(String id) {
        for (Customer c : this.customers.values()) {
            for (Overdraft o : c.getAllOverdrafts()) {
                if (o.getId().equals(id)) return true;
            }
        }
        return false;
    }

}
