package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class BankSystem {

    HashMap<UUID, ArrayList<Transaction>> transactionMap;
    HashMap<UUID, Account> accountMap;

    public BankSystem() {
        transactionMap = new HashMap<>();
        accountMap = new HashMap<>();
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
}
