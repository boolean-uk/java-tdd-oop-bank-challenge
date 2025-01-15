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

    // newCustomer does not contain any data, just "future-proof" in case want to add names, address, etc.
    public Customer addCustomer(Customer newCustomer) {

        // Generating a new customer id
        String newId = "";
        do {
            newId = this.idGenerate.generateId(10);
        } while (this.customers.containsKey(newId)); // Continuing to generate a new id if the generated one already exists

        Customer toAdd = new Customer(newId);
        this.customers.put(newId, toAdd);
        return toAdd;
    }

    public String getName() { // Return name of the bank
        return this.name;
    }

    public ArrayList<Customer> getCustomers() { // Return a list of all the customers in this bank
        return new ArrayList<>(this.customers.values());
    }

    public Account newAccount(Customer customer, Account newAccount) {

        // If the given customer does not exist, no account can be created for them
        if (!this.customers.containsKey(customer.getId())) return null;

        // Generating a new account number
        String newAccountNumber = "";
        do {
            newAccountNumber = this.idGenerate.generateId(5);
        } while (this.checkIfAccountNumberExists(newAccountNumber)); // Continuing to generate a new id if the generated one already exists

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

        // Check if given customer exists, and check if given account is associated with the given customer
        if (!this.customers.containsKey(customer.getId())) return false;
        if (this.customers.get(customer.getId()).getAccount(account.getAccountNumber()) == null) return false;

        // Getting the "real" customer and account objects
        Customer actualCustomer = this.customers.get(customer.getId());
        Account actualAccount = actualCustomer.getAccount(account.getAccountNumber());

        if (!this.checkIfAccountNumberExists(actualAccount.getAccountNumber())) return false;

        // Adding the deposit as a new transaction
        Transaction newTransaction = new Transaction(amount, actualCustomer.getBalance(actualAccount), actualCustomer.getAccount(account.getAccountNumber()), this.generateTransactionId(), Transaction.TransactionType.CREDIT);
        actualCustomer.addTransaction(newTransaction);

        return true;
    }

    public boolean withdraw(Customer customer, Account account, double amount) {

        // Check if given customer exists, and check if given account is associated with the given customer
        if (!this.customers.containsKey(customer.getId())) return false;
        if (this.customers.get(customer.getId()).getAccount(account.getAccountNumber()) == null) return false;


        // Getting the "real" customer and account objects
        Customer actualCustomer = this.customers.get(customer.getId());
        Account actualAccount = actualCustomer.getAccount(account.getAccountNumber());

        if (!this.checkIfAccountNumberExists(actualAccount.getAccountNumber())) return false;

        if (actualCustomer.getBalance(actualAccount) < amount) { // Check if withdraw is more than account's balance

            // Check if customer has at least one approved overdraft in their account
            if (!actualCustomer.getOverdrafts(Overdraft.OverdraftStatus.APPROVED).isEmpty()) {
                double totalApprovedOverdraftAmount = 0;
                for (Overdraft o : actualCustomer.getOverdrafts(actualAccount)) {
                    if (o.getStatus() == Overdraft.OverdraftStatus.APPROVED) {
                        totalApprovedOverdraftAmount += o.getAmount();
                    }
                }

                // Need to have negative since account balance gets negative value when overdraft requests are approved
                if ((-totalApprovedOverdraftAmount + actualCustomer.getBalance(actualAccount)) >= amount) return false;
            } else return false; // No approved overdraft requests for the given account, so withdraw not possible
        }

        // Adding this withdrawal as a transaction
        Transaction newTransaction = new Transaction(amount, actualCustomer.getBalance(actualAccount), actualCustomer.getAccount(account.getAccountNumber()), this.generateTransactionId(), Transaction.TransactionType.DEBIT);
        actualCustomer.addTransaction(newTransaction);

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

    public boolean approveOverdraft(Overdraft o) {
        for (Customer c : this.customers.values()) {
            for (Overdraft oo : c.getAllOverdrafts()) {
                if (oo.getId().equals(o.getId())) {
                    oo.approveOverdraft();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean rejectOverdraft(Overdraft o) {
        for (Customer c : this.customers.values()) {
            for (Overdraft oo : c.getAllOverdrafts()) {
                if (oo.getId().equals(o.getId())) oo.rejectOverdraft();
                return true;
            }
        }
        return false;
    }

}
