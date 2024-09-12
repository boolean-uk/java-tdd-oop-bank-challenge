package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {

    double balance = 0.0;
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
            System.out.println("Account does not exist cant make deposit");
            return false;
        }
        findCustomerAccount(accountNumber).setBalanceCent(amountToDeposit);
        return true;
    }

    public boolean withdraw(String accountNumber, double amountToWithdrawDollar) {
        if(findCustomerAccount(accountNumber) == null){
            System.out.println("Account does not exist cant make withdraw");
            return false;
        } else if (findCustomerAccount(accountNumber).getBalance() - amountToWithdrawDollar < 0 && !findCustomerAccount(accountNumber).isApprovedOverdraft()) {
            System.out.println("Not enough money");
            return false;
        }
        findCustomerAccount(accountNumber).setBalanceCent(-amountToWithdrawDollar);
        return true;
    }

    public boolean approvedOverdraft(String accountNumber){
        if(findCustomerAccount(accountNumber) == null){
            System.out.println("Account does not exist");
            return false;
        }
        findCustomerAccount(accountNumber).setApprovedOverdraft(true);
        return true;
    }

    public void reciveStatement(String accountNumber) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\nBank statement for: " + accountNumber + "\n");
        System.out.println("Date         Amount         Balance");
        for (LocalDateTime localDateTime : findCustomerAccount(accountNumber).getTransactions().keySet()){
            balance += (findCustomerAccount(accountNumber).getTransactions().get(localDateTime) / 100.0);
            System.out.printf("%-10s %.2f %-2s %.2f \n", dateTimeFormatter.format(localDateTime) + " || $", (findCustomerAccount(accountNumber).getTransactions().get(localDateTime)/ 100.0), " || $", balance);
        }
    }
}
