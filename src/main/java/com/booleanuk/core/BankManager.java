package com.booleanuk.core;

import com.booleanuk.Transaction;

import java.util.ArrayList;

public class BankManager {

    private static final double OVERDRAFT_LIMIT = -200;

    private static boolean isRequestAmountInValid(double amount) {
        return amount <= 0;
    }

    private static boolean hasNoTransactionHistory(ArrayList<Transaction> transactions) {
        return transactions == null || transactions.isEmpty();
    }

    private static boolean isWithinOverdraftLimit(double amount, ArrayList<Transaction> transactions) {
        double currentBalance = transactions.get(transactions.size() - 1).getBalanceAtTime();
        return currentBalance - amount >= OVERDRAFT_LIMIT;
    }

    public static boolean evaluateRequest (double amount, ArrayList<Transaction> transactions) {
        if (isRequestAmountInValid(amount) || hasNoTransactionHistory(transactions)) {
            return false;
        }
        return isWithinOverdraftLimit(amount, transactions);
    }
}
