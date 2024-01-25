package com.booleanuk.core;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class AccountHandler {
    private ArrayList<Account> accounts;

    private ArrayList<Account> overdraftRequests;
    private int id;

    public AccountHandler(ArrayList<Account> accounts, ArrayList<Account> overdraftRequests){
        this();
        this.accounts = accounts;
        this.overdraftRequests = overdraftRequests;
        this.id = 1;

    }
    private AccountHandler(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                saveAccountsAndRequests();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }));
    }
    public boolean createSavingsAccount(String accountHolder, Branch branch){
        this.accounts.add(new SavingsAccount(this.id++, accountHolder, branch));
        return true;
    }
    public boolean createCurrentAccount(String accountHolder, Branch branch){
        this.accounts.add(new CurrentAccount(this.id++, accountHolder, branch));
        return true;
    }
    public boolean depositToAccount(int accountNumber, double amount){
        for(Account account : accounts){
            if(account.getAccountId() == accountNumber){
                return account.deposit(amount);
            }
        }
        return false;
    }
    public boolean withdrawFromAccount(int accountNumber, double amount){
        for(Account account : accounts){
            if(account.getAccountId() == accountNumber){
                return account.withdraw(amount);
            }
        }
        return false;
    }
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }
    public ArrayList<String> getAccountsInBranch(Branch branch){
        ArrayList<String> temp = new ArrayList<>();
        for(Account account : accounts){
            if(account.getBranch().equals(branch)){
                temp.add(account.toString());
            }
        }
        return temp;
    }

    public String getBankStatementsFromAccount(int accountNumber){
        ArrayList<String> statements = new ArrayList<>();
        for(Account account : accounts){
            if(account.getAccountId() == accountNumber){
                statements.addAll(account.getBankStatements());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : statements){
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
    public ArrayList<String> getRequestedOverdrafts(){
        ArrayList<String> temp = new ArrayList<>();
        for(Account account : accounts){
            temp.add(account.toString());
        }
        return temp;
    }

    public void approveOverDraft(int accountNumber){
        Iterator iterator = overdraftRequests.iterator();
        while(iterator.hasNext()){
            CurrentAccount account = (CurrentAccount) iterator.next();
            if(account.getAccountId() == accountNumber){
                account.setOverdraftApproved(true);
                iterator.remove();
                break;
            }

        }
    }
    public boolean requestOverdraft(int accountNumber){
        for(Account account : accounts){
            if(account.getAccountId() == accountNumber && account instanceof CurrentAccount
                    && !account.getOverdraftApproved() && !overdraftRequests.contains(account)){
                overdraftRequests.add(account);
                return true;
            }
        }
        return false;
    }
    private void saveAccountsAndRequests() throws FileNotFoundException {
        FileHandler.writeToFile("Test.txt", accounts);
        FileHandler.writeToFile("TestOverdraft.txt", overdraftRequests);

    }

}
