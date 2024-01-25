package com.booleanuk.core;

import java.util.ArrayList;

public class BankStatementGenerator {
    public String generateBankStatement(ArrayList<Transaction> transactions) {
        String bankStatement = "Date Credit Debit Balance";

        for(Transaction transaction : transactions) {
            bankStatement += "/n";

            bankStatement += transaction.getDate() + " ";

            if(transaction.getTransactionType().equalsIgnoreCase("Credit")) {
                bankStatement += transaction.getAmount() + " ";
                bankStatement += "0" + " ";
            }
            else {
                bankStatement += "0" + " ";
                bankStatement += transaction.getAmount() + " ";
            }
            bankStatement += transaction.getBalance();
        }

        return bankStatement;
    }
}
