package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static com.booleanuk.core.NumberUtils.*;

public class Account {

    private final ArrayList<Transaction> transactions;
    private final ArrayList<String> bankStatement;
    private final String accountName;
    private final Branch branch;

    public Account(String accountName, Branch branch){
        this.transactions = new ArrayList<>();
        this.bankStatement = new ArrayList<>();
        this.accountName = accountName;
        this.branch = branch;
    }


    // Getters and setters

    public String getAccountName() {
        return accountName;
    }

    public Branch getBranch() {
        return branch;
    }

    public ArrayList<String> getBankStatement() {
        return bankStatement;
    }


    // Methods

    public int getBalanceInCents() {
        if (transactions.isEmpty()){
            return 0;
        }
        return transactions.getLast().getBalanceInCents();
    }

    public void deposit(float amountInPounds){
        int newBalanceInCents = getBalanceInCents() + poundsToCents(amountInPounds);
        transactions.add(new Transaction(floatFormatter(amountInPounds)+ "£", newBalanceInCents));
    }

    public String withdraw(float amountInPounds){
        // Change to class != savings!!:
        if (amountInPounds > centsToPounds(getBalanceInCents()) && getClass() != CurrentAccount.class){
            return "Not enough funds.";
        }

        int newBalanceInCents = (getBalanceInCents() - poundsToCents(amountInPounds));
        transactions.add(new Transaction("-" + floatFormatter(amountInPounds) + "£", newBalanceInCents));
        return "Funds withdrawn from account.";
    }

    public void generateBankStatement(){
        bankStatement.add(String.format("%-11s %1s %10s %1s %11s", "Date", "||", "Amount", "||", "Balance"));
        bankStatement.add("----------------------------------------");
        for (Transaction transaction : transactions) {
            bankStatement.add(String.format("%-11s %1s %10s %1s %11s",
                    transaction.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "||",
                    transaction.getAmount(), "||",
                    floatFormatter(centsToPounds(transaction.getBalanceInCents())) + "£"));
        }
    }

    public void printBankStatement(){
        for (String s : bankStatement){
            System.out.println(s);
        }
    }

}
