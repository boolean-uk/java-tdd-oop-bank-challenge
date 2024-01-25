package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Account savingsAccount;
    private Account currentAccount;
    private List<OverDraftRequest> requests;

    public Customer() {
        requests = new ArrayList<>();
    }

    public boolean createAccount(String type, Branch branch){
        if (type.equalsIgnoreCase("Savings")){
            savingsAccount = new SavingsAccount(branch);
            return true;
        } else if (type.equalsIgnoreCase("Current")){
            currentAccount = new CurrentAccount(branch);
            return true;
        }
        System.out.println("Invalid account type");
        return false;
    }

    public boolean deposit(Account account, double amount){
        return account.add(amount);
    }

    public boolean withdraw(Account account, double amount){
       return account.remove(amount);
    }

    public String generateBankStatement(Account account){

        StringBuilder res = new StringBuilder();

        res.append("| ").append(String.format("%-9s", "Date \t\t|"));
        res.append("| ").append(String.format("%-9s", "Transaction |"));
        res.append("| ").append(String.format("%-9s", "Balance |\n"));

        for(Transaction transaction : account.getTransactions()){

            res.append("| ").append(String.format("%-9s", transaction.getDate())).append(" |");
            res.append("| ").append(String.format("%-9s", transaction.getAmount())).append(" |");
            res.append("| ").append(String.format("%-9s", transaction.getBalance())).append(" |\n");

        }

        return res.toString();
    }

    public boolean requestOverDraft(CurrentAccount account, double limit){
        if (limit < 0){
            return false;
        }
        this.requests.add(new OverDraftRequest(limit, account));
        return true;
    }
}
