package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Bank {
    ArrayList<Customer> customers;
    public Bank(Customer customers) {
        this.customers = new ArrayList<>();
        this.customers.add(customers);
    }

    public boolean createAccount(int  id, double amount){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date, amount, 0.0);
        Account account = new Account("Current Account", amount, transaction);
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
    public boolean createSavingsAccount(int  id, double amount){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date, amount, 0.0);
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



}
