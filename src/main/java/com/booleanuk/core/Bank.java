package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Bank {
    ArrayList<Customer> customers;
    public Bank(Customer customers) {
        this.customers = new ArrayList<>();
        this.customers.add(customers);
    }

    public boolean createAccount(int  id, double amount){
        Customer customer = new Customer();
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date, amount, 0.0, "Debit");
        Account account = new Account("Current Account", amount, transaction);
//        Random random = new Random();
//        int generateAccountNumber = random.nextInt()+100;
        for (int i = 0; i<customers.size(); i++){
            if (customers.get(i).id==id){
                customers.get(i).Accounts.put(customer.accountNumber++,account);
                return true;
            }
        }
        return false;
    }
    public boolean createSavingsAccount(int  id, double amount){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date, amount, 0.0, "Debit");
        Account account = new Account("Saving Account", amount,transaction );
        Random random = new Random();
        int generateAccountNumber = random.nextInt()+100;
        for (int i = 0; i<customers.size(); i++){
            if (customers.get(i).id==id){
                customers.get(i).Accounts.put(generateAccountNumber,account);
                return true;
            }
        }
        return false;
    }

    public boolean deposit(int customerId, int accountNumber, double amount) {
        for (Customer customer : customers) {
            if (customer.id == customerId) {
                Account account = customer.Accounts.get(accountNumber);
                if (account != null) {
                    account.amountSaved += amount;
                    Transaction transaction = new Transaction(LocalDateTime.now(), amount, account.amountSaved, "Credit");
                    account.transactionHistory.put(account.accountType, transaction);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean withdraw(int customerId, int accountNumber, double amount) {
        for (Customer customer : customers) {
            if (customer.id == customerId) {
                Account account = customer.Accounts.get(accountNumber);
                if (account != null) {
                    account.amountSaved -= amount;
                    System.out.println(account.amountSaved);
                    Transaction transaction = new Transaction(LocalDateTime.now(), amount, account.amountSaved, "Debit");
                    account.transactionHistory.put(account.accountType, transaction);
                    printBankStatement(customerId,accountNumber);
                    return true;
                }
            }
        }
        return false;
    }

    public void printBankStatement(int id, int accontNumber){
        for (Customer customer : customers) {
            if (customer.id == id) {
                Account account = customer.Accounts.get(accontNumber);
                if (account != null) {
                    //System.out.println(account.transactionHistory.containsKey(account.accountType));
                    LocalDateTime date = account.transactionHistory.get(account.accountType).data;
                    double amount = account.transactionHistory.get(account.accountType).amount;
                    double balance = account.transactionHistory.get(account.accountType).currentBalance;
                    if (account.transactionHistory.get(account.accountType).debitOrCredit.equals("Debit")){
                        System.out.println(
                                "Date: " + date.getDayOfMonth() + "/" + date.getMonth() + "/" + date.getYear() + "\n"+
                                        "Debit: " + amount + "\n"+
                                        "Balance: " + balance + "\n"
                        );
                    }else {
                        System.out.println(
                                "Date: " + date.getDayOfMonth() + "/" + date.getMonth() + "/" + date.getYear() + "\n"+
                                        "Credit: " + amount + "\n"+
                                        "Balance: " + balance + "\n"
                        );
                    }

                }
            }
        }
    }

}
