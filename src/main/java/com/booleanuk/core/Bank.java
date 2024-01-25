package com.booleanuk.core;

import java.util.*;


public class Bank {

    private HashMap<Customer, ArrayList<Account>> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public int createCurrentAccount(Customer customer) {
        Account account = new CurrentAccount(customer);
        addAccountToCustomer(customer, account);
        return account.getId();
    }

    public int createSavingsAccount(Customer customer) {
        Account account = new SavingsAccount(customer);
        addAccountToCustomer(customer, account);
        return account.getId();
    }


    // For testing purposes
    protected ArrayList<Account> getAccounts(Customer customer) {
        return accounts.get(customer);
    }

    private void addAccountToCustomer(Customer customer, Account account) {
        if(accounts.containsKey(customer)) {
            ArrayList<Account> customerAccounts = accounts.get(customer);
            customerAccounts.add(account);
            accounts.put(customer, customerAccounts);
            return;
        }
        accounts.put(customer, new ArrayList<>(Collections.singletonList(account)));
    }

    //TODO: check so amount is >0
    public String deposit(double amount, Customer customer, int accountId) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                customerAccount.deposit(amount);
                return "The deposit has been performed.";
            }
        }
        return "Account doesn't exist.";
    }

    //TODO: check so amount is >0
    public String withdraw(double amount, Customer customer, int accountId) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                if(customerAccount.withdraw(amount)) {
                    return "The withdraw has been performed.";
                } else {
                    return "The withdrawal could not be performed. The balance is too low.";
                }
            }
        }
        return "Account doesn't exist.";
    }

    public String generateBankStatements(Customer customer, int accountId) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                return customerAccount.generateStatements();
            }
        }
        return "Account doesn't exist.";
    }

    public String requestsOverdraft(Customer customer, int accountId, double amount) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                if(customerAccount instanceof SavingsAccount) {
                    return "You can't have an overdraft on a savings account.";
                } else {
                    return "Your request has been sent.";
                }
            }
        }


        return "Account doesn't exist.";
    }
}
