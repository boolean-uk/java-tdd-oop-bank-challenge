package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class BankSystem {

    private HashMap<UUID, ArrayList<Transaction>> transactionMap;
    private HashMap<UUID, Account> accountMap;
    private HashMap<UUID, Float> overdraftRequests;

    public BankSystem() {
        transactionMap = new HashMap<>();
        accountMap = new HashMap<>();
        overdraftRequests = new HashMap<>();
    }

    public Account createBankAccount(AccountType accountType) {
        Account account = new Account(accountType);
        transactionMap.put(account.getID(), new ArrayList<>());
        accountMap.put(account.getID(), account);
        return account;
    }

    public Transaction makeDeposit(UUID accountID, float amount) {
        if(!accountMap.containsKey(accountID)) {
            System.out.println("Account ID doesn't exist. Deposit cancelled.");
            return null;
        }

        Transaction transaction = new Transaction(accountID, amount);
        accountMap.get(accountID).deposit(amount);
        transactionMap.get(accountID).add(transaction);
        return transaction;
    }

    public Transaction makeWithdrawal(UUID accountID, float amount) {
        if(!accountMap.containsKey(accountID)) {
            System.out.println("Account ID doesn't exist. Withdrawal cancelled.");
            return null;
        }

        Transaction transaction = new Transaction(accountID, amount*-1);
        if(!accountMap.get(accountID).withdraw(amount)) {
            System.out.println("Insufficient funds. Withdrawal cancelled.");
            return null;
        }
        transactionMap.get(accountID).add(transaction);
        return transaction;
    }

    public boolean requestOverdraft(UUID accountID, float amount) {
        if(amount <= 0) {
            System.out.println("Overdraft amount must be above £0");
            return false;
        }
        if(overdraftRequests.containsKey(accountID)) {
            System.out.println("Your previous overdraft request has been updated.");
        }
        overdraftRequests.put(accountID, amount);
        return true;
    }

    public void reviewOverdrafts() {

        Scanner sc = new Scanner(System.in);
        String input = "";
        for(UUID k : overdraftRequests.keySet()) {
            System.out.println("Account " + k + " requests an overdraft of £" + overdraftRequests.get(k) + ".");
            System.out.println("Would you like to confirm this request? (Y / N)");
            input = sc.nextLine();
            if(input.equalsIgnoreCase("y")) {
                this.accountMap.get(k).setOverdraft(overdraftRequests.get(k));
                System.out.println("Overdraft request has been granted.");
            } else {
                System.out.println("Overdraft request has been declined.");
            }
            overdraftRequests.remove(k);
        }
    }

    public StringBuilder generateStatement(UUID accountID) {
        ArrayList<Transaction> transactions = this.transactionMap.get(accountID);
        StringBuilder statement = new StringBuilder();
        float balance = 0;
        statement.append("Date\t\t\tCredit\tDebit\tBalance\n");
        for(Transaction t : transactions) {
            balance += t.getAmount();
            if(t.getAmount() > 0) {
                statement.append(t.getTransactionDate().toLocalDate() + "\t\t" + t.getAmount() + "\t\t\t" + balance + "\n");
            }
            else {
                statement.append(t.getTransactionDate().toLocalDate() + "\t\t\t\t" + (t.getAmount() * -1) + "\t" + balance + "\n");
            }
        }
        System.out.println(statement);
        return statement;
    }

    public HashMap<UUID, ArrayList<Transaction>> getTransactionMap() {
        return this.transactionMap;
    }

    public HashMap<UUID, Account> getAccountMap() {
        return this.accountMap;
    }

    public HashMap<UUID, Float> getOverdraftRequests() {
        return this.overdraftRequests;
    }
}
