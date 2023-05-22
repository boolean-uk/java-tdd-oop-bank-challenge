package com.booleanuk.core;

import org.jetbrains.annotations.NotNull;

public class Customer {
    private Account[] accounts;
    private int id;

    public Customer(int id){
        this.id = id;
        accounts = new Account[2];
    }

    public Account getCurrentAccount(){
        return accounts[0];
    }

    public void setCurrentAccount(Account currentAccount){
        this.accounts[0] = currentAccount;
    }

    public void setSavingsAccount(Account savingsAccount){
        this.accounts[1] = savingsAccount;
    }

    public Account getSavingsAccount(){
        return accounts[1];
    }

    public int getId() {
        return id;
    }

    public boolean hasCurrentAccount(){
        if (getCurrentAccount() == null) {
            return false;
        } else {
            return true;
        }
    }
    public boolean hasSavingsAccount(){
        if (getSavingsAccount() == null) {
            return false;
        } else {
            return true;
        }
    }


    public boolean createCurrentAccount(int initalDeposit) {

        if (hasCurrentAccount()){
            System.out.println("Customer already has a current account");
            return false;
        }
        setCurrentAccount(new Account( Account.getUniqueRandomAccountId(),getId(), "current"));
        getCurrentAccount().addDepositStatement(initalDeposit);
        //first id is account id, second is user id
        Bank.addAccount(getCurrentAccount().getId(), getId(), "current");
        return true;
    }


    public boolean createSavingsAccount(int initalDeposit) {

        if (hasSavingsAccount()) {
            System.out.println("Customer already has a savings account");
            return false;
        }

        setSavingsAccount(new Account(Account.getUniqueRandomAccountId(), getId(), "savings"));
        getSavingsAccount().addDepositStatement(initalDeposit);
        Bank.addAccount(getSavingsAccount().getId(), getId(), "savings");
        return true;
    }

    public boolean withdraw(@NotNull String accountType, int ammount) {

        if (accountType.equals("current") && hasCurrentAccount()) {

            int balance = getCurrentAccount().calculateBalance();
            if (balance >= ammount) {
//                getCurrentAccount().setBalance(balance - ammount);
                getCurrentAccount().addWithdrawStatement(ammount);
                return true;
            } else {
                return false;   // not enough balance
            }

        } else if (accountType.equals("savings") && hasSavingsAccount()) {

            int balance = getSavingsAccount().calculateBalance();
            if (balance >= ammount && ammount <= 200) {
//                getSavingsAccount().setBalance(balance - ammount);
                getSavingsAccount().addWithdrawStatement(ammount);
                return true;
            } else {
                return false; // not enough balance or ammount needed more than 200
            }

        }
        return false;   // such account does not exist
    }

    public boolean deposit(@NotNull String accountType, int ammount) {

        if (accountType.equals("current") && hasCurrentAccount()) {
            getCurrentAccount().addDepositStatement(ammount);
            return true;
        }

        else if (accountType.equals("savings") && hasSavingsAccount()) {
            getSavingsAccount().addDepositStatement(ammount);
            return true;
        }

        return false;
    }

    //statement generator for each account type
    public void generateSavingsAccountStatements () {
        if (hasSavingsAccount()) {
            getSavingsAccount().generateStatements();
        } else {
            System.out.println("You do not have a savings account yet!");
        }
    }

    public void generateCurrentAccountStatements () {
        if (hasCurrentAccount()) {
            getCurrentAccount().generateStatements();
        } else {
            System.out.println("You do not have a current account yet!");
        }
    }


    //OVERDRAFT
    public void requestOverdraft (int ammountRequested) {
        if (hasCurrentAccount()) {
            if (getCurrentAccount().calculateBalance() >= ammountRequested) {
                System.out.println("You have enough money deposited, no need to make overdraft request");
            } else {
                Bank.addOverdraft(getCurrentAccount().getId(), ammountRequested);
                System.out.println("Overdraft Requested");
            }
        } else {
            System.out.println("You do not have a current account yet.");
        }
    }

    public String getOverdraftRequestStatus () {

        String status = "You have not requested overdraft";

        for (OverdraftRequest overdraftRequest: Bank.getOverdraftRequests()) {
            if (overdraftRequest.getAccountId() == getCurrentAccount().getId()) {
                if (overdraftRequest.getAnswer() == null) {
                    status = "Not evaluated";
                    return status;
                } else if (overdraftRequest.getAnswer()) {
                    status = "Accepted";
                    return status;
                } else {
                    status = "Rejected";
                    return status;
                }
            }
        }
        return status;
    }


}
