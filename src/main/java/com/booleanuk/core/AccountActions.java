package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class AccountActions {
    List<Integer> transactions = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();

    public boolean createAccount(String accountType, String accountNumber, String accountHolderFirstName, String accountHolderLastName, String branchCode) {

        //Current Account
        if (accountType.equalsIgnoreCase("Current")) {
            if (searchAccount(accountNumber) != null) {
                System.out.println("Could not create account because this account number is already in use");
                return false;
            }
            accounts.add(new CurrentAccount(accountNumber, accountHolderFirstName, accountHolderLastName, branchCode));
            System.out.println("Congratulations on your new Current Account!");
            return true;

        //Savings Account
        } else if (accountType.equalsIgnoreCase("Savings")) {
            if (searchAccount(accountNumber) != null) {
                System.out.println("Could not create account because this account number is already in use");
                return false;
            }
            accounts.add(new SavingsAccount(accountNumber, accountHolderFirstName, accountHolderLastName, branchCode));
            System.out.println("Congratulations on your new Savings Account!");
            return true;
        }

        //Invalid Account Type
        System.out.println("This account type is invalid. Please enter Current or Savings.");
        return false;
    }

    public Account searchAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account could not be found");
        return null;
    }

    public boolean deposit(String accountNumber, double amountInDollars) {
        if (searchAccount(accountNumber) == null) {
            System.out.println("Could not process deposit as this account does not exist");
            return false;
        }

        searchAccount(accountNumber).setBalanceInCents(amountInDollars);
        return true;
    }

    public boolean withdraw(String accountNumber, double amountInDollars) {
        if (searchAccount(accountNumber) == null) {
            System.out.println("Could not process deposit as this account does not exist");
            return false;
        } else if(searchAccount(accountNumber).getBalanceInDollars() - amountInDollars < 0) {
            System.out.println("Insufficient funds");
            return false;
        }

        searchAccount(accountNumber).setBalanceInCents(-amountInDollars);
        return true;
    }


}
