package com.booleanuk.core;

import java.util.ArrayList;

public class User {
    private static int counter = 1;
    private final int userID;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
        this.userID = counter;
        counter++;
    }

    public int getUserID(){
        return userID;
    }

    public boolean newAccount(Account account){
        if (account.getUserID() == 0){
            accounts.add(account);
            account.setUserID(userID);
            System.out.println("New " + account.getClass().getSimpleName() + " created.");

            return true;
        }
        System.out.println("This account is connected to another user.");
        return false;
    }

    public void showAccounts(){
        System.out.println(("=").repeat(51));
        System.out.printf("|%-15s| %-15s| %-15s| %n", "Account ID", "Type", "Balance");
        System.out.println(("=").repeat(51));

        if (!accounts.isEmpty()){
            for (Account account : accounts){
            System.out.printf("|%14s | %-15s| %14.2f | %n", account.getAccountID(), account.getClass().getSimpleName(), account.getBalance());
        }
            System.out.println(("-").repeat(51));
        } else {
            System.out.printf("%30s", "No entries");
        }

        System.out.println("\n");
    }

    public Account getAccount(int accountID){
        for (Account account : accounts){
            if (account.getAccountID() == accountID){
                return account;
            }
        }
        return null;
    }

    public boolean withdraw(int accountID, int fund){
        try {
            return getAccount(accountID).withdraw(Math.abs(fund));
        } catch (NullPointerException e){
            System.out.println("No account with this account ID.");
            return false;
        }
    }

    public boolean deposit(int accountID, int fund){
        if (Math.abs(fund) == fund){
            try {
                return getAccount(accountID).deposit(Math.abs(fund));
            } catch (NullPointerException e){
                System.out.println("No account with this account ID.");
                return false;
            }
        }
        return false;
    }

    public boolean requestOverdraft(int accountID, int overdraft){
        try {
            Account account = getAccount(accountID);
            if (account instanceof CurrentAccount){
                return ((CurrentAccount) account).setOverdraft(Math.abs(overdraft));
            }
            System.out.println("Cannot request overdraft on savings accounts.");
            return false;

        } catch (NullPointerException e){
            System.out.println("No account with this account ID.");
            return false;
        }
    }

    public void printBankStatements(){

    }
}
