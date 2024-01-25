package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract public class Account {
    private static int counter = 1;
    private int userID;
    private final int accountID;
    protected int overdraft;
    private HashMap<Transaction, LocalDateTime> history;
    private int balance = 0;

    private ArrayList<Integer> balanceHistory = new ArrayList<>();

    public Account(){
        accountID = counter;
        counter++;
        overdraft = 0;
        history = new HashMap<>();
    }
    public int getUserID(){
        return userID;
    }

    protected void setUserID(int userID){
        this.userID = userID;
    }

    public int getAccountID(){
        return accountID;
    }

    public double getBalance(){
        /*
        int balance = 0;
        for (Transaction transaction : history.values()){
            balance += transaction.getAmount();
        }
        */
        return balance;
    }

    public boolean withdraw(int fund){
        if (fund > 0){
            if (getBalance() >= fund + overdraft){
                history.put(new Transaction(-fund, "Withdrawal"), LocalDateTime.now());
                balance -= fund;
                balanceHistory.add(balance);
                return true;
            }
        }

        System.out.println("Insufficient funds. Withdrawal failed.");
        return false;
    }

    public boolean deposit(int fund){
        if (Math.abs(fund) == fund){
            history.put(new Transaction(fund, "Deposit"), LocalDateTime.now());
            balance += fund;
            balanceHistory.add(balance);
            return true;
        }
        System.out.println("Insufficient funds. Deposit failed.");
        return false;
    }

    public void printTransactions(){
        System.out.println(("=").repeat(75));
        System.out.printf("|%-22s| %-15s| %-15s| %-15s| %n", "Date", "Credit", "Debit", "Balance");
        System.out.println(("=").repeat(75));
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        int index = 0;
        for (Map.Entry<Transaction, LocalDateTime> set : history.entrySet()){
            String formattedDate = set.getValue().format(myFormat);
            if (set.getKey().getType().equals("Deposit")){
                System.out.printf("|%-22s| %-15s| %-15s| %-15s| %n", formattedDate, set.getKey().getAmount(), "", balanceHistory.get(index));
            } else {
                System.out.printf("|%-22s| %-15s| %-15s| %-15s| %n", formattedDate, "", set.getKey().getAmount(), balanceHistory.get(index));
            }
            index++;
        }
        System.out.println("\n");
    }

    private int previousBalanceHelper(Transaction transaction){
        int balance = 0;
        for (Map.Entry<Transaction, LocalDateTime> set : history.entrySet()){
            balance += set.getKey().getAmount();
            if (set.getKey() == transaction){
                return balance;
            }
        }

        return balance;
    }
}
