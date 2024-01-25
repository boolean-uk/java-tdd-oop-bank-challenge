package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<Customer> customerList;
    private ArrayList<Account> accountList;

    public Bank() {
        this.customerList = new ArrayList<>();
        this.accountList = new ArrayList<>();
    }

    public Account createAccount(Customer customer, String type) {
        findOrCreateCustomer(customer);
        Account account = null;
        if(type.equalsIgnoreCase("s")) {
            account = new SavingsAccount(customer);
        } else if(type.equalsIgnoreCase("c")) {
            account = new CurrentAccount(customer);
        }
        customer.getAccounts().add(account);
        this.accountList.add(account);
        return account;
    }

    private void findOrCreateCustomer(Customer customer) {
        if(!customerList.contains(customer)) {
            customerList.add(customer);
        }
    }

    public boolean requestOverdraft(Customer customer, CurrentAccount account, Scanner scanner) {
        boolean grantedOverdraft = false;
        System.out.println(customer.getName() + " has requested overdraft on his/her currentAccount\nWould you like to grant the overdraft? (y/n)");
        String input = scanner.nextLine();
        while(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
            System.out.println("Invalid input. Write 'y' or 'n'");
            input = scanner.nextLine();
        }
        if(input.equalsIgnoreCase("y")) {
            account.setOverdrafted();
            grantedOverdraft = true;
        }
        return grantedOverdraft;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }
}
