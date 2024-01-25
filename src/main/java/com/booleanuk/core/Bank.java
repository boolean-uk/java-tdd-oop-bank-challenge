package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public boolean createAccount(int customerId, String accountType, double initialAmount) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            customer.addAccount(accountType, initialAmount);
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
            System.out.println(account.calculateBalance());
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
                    ); }
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
