package com.booleanuk.extension;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private final LocalDate birthDate;
    private final String userName;
    private final String userID;
    private ArrayList<Account> accounts;
    private int accountNum;

    public User(String userName, LocalDate birthDate)
    {
        this.userName = userName;
        this.birthDate = birthDate;
        this.userID = birthDate + userName;
        this.accountNum = 0;
        this.accounts = new ArrayList<>();
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return userID;
    }

    public void createCurrentAccount(String name)
    {
        this.accountNum+=1;
        this.accounts.add(new CurrentAccount(name, this.userName, accountNum));
    }

    public void createSavingsAccount(String name)
    {
        this.accountNum+=1;
        this.accounts.add(new SavingsAccount(name, this.userName, accountNum));
    }

    public Account getAccount(String ID)
    {
        for(Account account : this.accounts)
        {
            if(account.getAccountID().equals(ID)) return account;
        }
        System.out.println("No account with id " + ID);
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean makeDeposit(String ID, int amount)
    {
        for(Account account : this.accounts)
        {
            if(account.getAccountID().equals(ID))
                return account.deposit(amount);
        }
        return false;
    }

    public boolean makeWithdrawal(String ID, int amount)
    {
        for(Account account : this.accounts)
        {
            if(account.getAccountID().equals(ID))
            {
                if(account.getBalance() > 0 && account.getBalance() > amount)
                {
                    return account.withdraw(amount);
                }   else {
                    System.out.println("Insufficient funds!");
                    return false;
                }
            }

        }
        return false;
    }

    public boolean makeDeposit(String ID, double amount)
    {
        for(Account account : this.accounts)
        {
            if(account.getAccountID().equals(ID))
                return account.deposit((int)(amount*100.0));
        }
        System.out.println("The account ID was not found!");
        return false;
    }

    public boolean makeWithdrawal(String ID, double amount)
    {
        for(Account account : this.accounts)
        {
            if(account.getAccountID().equals(ID))
                return account.withdraw((int)(amount*100.0));
        }
        System.out.println("The account ID was not found!");
        return false;
    }

    public int getBalance(String ID)
    {
        for(Account account : this.accounts)
        {
            if(account.getAccountID().equals(ID))
                return account.getBalance();
        }
        return 0;
    }

    public String generateTransactionHistory(String ID)
    {
        for(Account account : this.accounts)
        {
            if(account.getAccountID().equals(ID))
                return account.generateTransactionStatement();
        }
        return "";
    }

}
