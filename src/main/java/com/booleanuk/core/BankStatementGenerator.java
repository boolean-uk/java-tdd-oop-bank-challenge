package com.booleanuk.core;

import java.util.ArrayList;

public class BankStatementGenerator {
    public String generateBankStatement(ArrayList<Transaction> transactions) {
        String bankStatement = "\n";
        bankStatement += String.format("|| %-20s ", "Date");
        bankStatement += String.format("|| %-20s ", "Credit");
        bankStatement += String.format("|| %-20s ", "Debit");
        bankStatement += String.format("|| %-20s ||", "Balance");

        String date;
        String credit;
        String debit;
        String balance;

        for(Transaction transaction : transactions) {
            bankStatement += "\n";

            date = transaction.getDate();
            bankStatement += String.format("|| %20s ", date);

            if(transaction.getTransactionType().equalsIgnoreCase("Credit")) {
                credit = " " + transaction.getAmount();
                bankStatement += String.format("|| %20s ", credit);
                debit = "";
                bankStatement += String.format("|| %20s ", debit);
            }
            else {
                credit = "";
                bankStatement += String.format("|| %20s ", credit);
                debit = " " + transaction.getAmount();
                bankStatement += String.format("|| %20s ", debit);
            }
            balance = " " + transaction.getBalance();
            bankStatement += String.format("|| %20s ||", balance);
        }

        return bankStatement;
    }
}
