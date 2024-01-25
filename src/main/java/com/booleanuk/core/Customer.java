package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    private ArrayList<Account> accounts;
    private int customerId;
    private String name;
    private Bank bank;
    private Scanner scanner = new Scanner(System.in);

    public Customer(int customerId, String name, Bank bank) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
        this.bank = bank;
    }

    public double deposit(Account account, double amount) {
        return account.deposit(amount);
    }

    public double withdraw(Account account, double amount) {
        return account.withdraw(amount);
    }


    public boolean requestOverdraftOnAccount(Account account, Scanner scanner) {
        boolean requestSent = false;
        if(account.getClass() == SavingsAccount.class) {
            System.out.println("You can't overdraft a savings account...");
        }
        if(account.getClass() == CurrentAccount.class) {
            requestSent = bank.requestOverdraft(this, (CurrentAccount) account, scanner);
        }
        return requestSent;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }
}
