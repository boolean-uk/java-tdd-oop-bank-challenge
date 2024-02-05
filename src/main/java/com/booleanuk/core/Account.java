package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {

    List<CustomerAccount> customerAccounts = new ArrayList<>();

    public boolean addCustomerAccount(String accountType, String accountNumber, String name, String branchCode) {

        if (accountType.equalsIgnoreCase("Current")) {
            if (findCustomerAccount(accountNumber) != null) {
                System.out.println("Current account number busy");
                return false;
            }
            customerAccounts.add(new CurrentCustomerAccount(accountNumber,name,branchCode));
            System.out.println("Added new current account");
            return true;
    } else if (accountType.equalsIgnoreCase("Savings")) {
            if (findCustomerAccount(accountNumber) != null){
                System.out.println("Savings account number busy");
                return false;
            }
            customerAccounts.add(new CustomerSavingAccount(accountNumber,name,branchCode));
            System.out.println("Added new savings account");
            return true;
        }
        System.out.println("Account type invalid");
        return false;
    }

    public CustomerAccount findCustomerAccount(String accountNumber) {
        for (CustomerAccount customerAccount : customerAccounts){
            if (customerAccount.getAccountNum().equals(accountNumber)) {
                return customerAccount;
            }
        }
        System.out.println("No such account");
        return null;
    }

    public boolean deposit(String accountNumber, double amountToDeposit) {
        if(findCustomerAccount(accountNumber) == null){
            System.out.println("Account does not exist");
            return false;
        }
        findCustomerAccount(accountNumber).setBalanceCent(amountToDeposit);
        return true;
    }
}
