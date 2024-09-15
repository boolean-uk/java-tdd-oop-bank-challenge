package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Customer> customers;
    private final List<Branch> branches;

    public Bank() {
        this.customers = new ArrayList<>();
        this.branches = new ArrayList<>();
        // Initialize with a default branch
        this.branches.add(new Branch("Default Branch", "Default Address"));
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

    private Branch findBranchByName(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(branchName)) {
                return branch;
            }
        }
        return null;
    }


    public boolean createAccount(int customerId, String accountType, double initialAmount, String branchName) {
        Customer customer = findCustomerById(customerId);
        Branch branch = findBranchByName(branchName);
        if (customer != null && branch != null) {
            Account newAccount = new Account(accountType, initialAmount, branch);
            customer.addAccount(newAccount); // Add to customer's account list
            branch.addAccount(newAccount); // Add to branch's account list
            return true;
        }
        return false;
    }


    public boolean deposit(int customerId, int accountNumber, double amount) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            Account account = customer.getAccount(accountNumber);
            if (account != null) {
                Transaction transaction = new Transaction(LocalDateTime.now(), amount, account.calculateBalance() + amount, "Credit");
                account.addTransaction(transaction);
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(int customerId, int accountNumber, double amount) {
        Customer customer = findCustomerById(customerId);
        assert customer != null;
        Account account = customer.getAccount(accountNumber);
        double currentBalance = account.calculateBalance();
        if (currentBalance >= amount) {
            Transaction transaction = new Transaction(LocalDateTime.now(), amount, currentBalance - amount, "Debit");
            account.addTransaction(transaction);
            return true;
        }
        return false;
    }

    public void printBankStatement(int customerId, int accountNumber) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            Account account = customer.getAccount(accountNumber);
            if (account != null) {
                for (Transaction transaction : account.getTransactionHistory()) {
                    System.out.println(
                            "Date: " + transaction.getData().getDayOfMonth() + "/" +
                                    transaction.getData().getMonth() + "/" +
                                    transaction.getData().getYear() + "\n" +
                                    transaction.getDebitOrCredit() + ": " + transaction.getAmount() + "\n" +
                                    "Balance: " + transaction.getCurrentBalance() + "\n"
                    );
                }
                System.out.println("Current Balance: " + account.calculateBalance());
            }
        }
    }

    Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }
}
