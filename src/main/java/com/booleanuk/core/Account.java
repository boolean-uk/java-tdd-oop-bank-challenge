package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static com.booleanuk.core.NumberUtils.*;

public class Account {

    private ArrayList<Transaction> transactions;
    private ArrayList<String> bankStatement;
    private String accountName;
    private Branch branch;
    private Boolean canOverdraft;
    private Boolean overdraftRequestPending;

    public Account(String accountName, Branch branch){
        this.transactions = new ArrayList<>();
        this.bankStatement = new ArrayList<>();
        this.accountName = accountName;
        this.branch = branch;
        this.canOverdraft = false;
        this.overdraftRequestPending = false;
    }

    public String getAccountName() {
        return accountName;
    }

    public Branch getBranch() {
        return branch;
    }

    public int getBalance() {
        if (transactions.isEmpty()){
            return 0;
        }
        return transactions.getLast().getBalance();
    }

    public Boolean getOverdraftRequestPending() {
        return overdraftRequestPending;
    }

    public void setOverdraftRequestPending(Boolean overdraftRequestPending) {
        this.overdraftRequestPending = overdraftRequestPending;
    }

    public void setCanOverdraft(Boolean canOverdraft) {
        this.canOverdraft = canOverdraft;
    }

    public ArrayList<String> getBankStatement() {
        return bankStatement;
    }

    public void deposit(float amount){
        int newBalance = getBalance() + poundsToCents(amount);
        transactions.add(new Transaction(floatFormatter(amount)+ "£", newBalance));
    }

    public String withdraw(float amount){
        if (amount > centsToPounds(getBalance()) && !canOverdraft){
            return "Not enough funds.";
        }

        int newBalance = (getBalance() - ((int) (amount * 100)));
        transactions.add(new Transaction("-" + floatFormatter(amount) + "£", newBalance));
        return "Funds withdrawn from account.";
    }

    public void generateBankStatement(){
        bankStatement.add(String.format("%-11s %1s %10s %1s %11s", "Date", "||", "Amount", "||", "Balance"));
        bankStatement.add("----------------------------------------");
        for (Transaction transaction : transactions) {
            bankStatement.add(String.format("%-11s %1s %10s %1s %11s",
                    transaction.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "||",
                    transaction.getAmount(), "||",
                    floatFormatter(centsToPounds(transaction.getBalance())) + "£"));
        }
    }

    public void printBankStatement(){
        for (String s : bankStatement){
            System.out.println(s);
        }
    }

}
