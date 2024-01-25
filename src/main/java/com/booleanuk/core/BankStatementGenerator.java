package com.booleanuk.core;

import java.util.ArrayList;

public class BankStatementGenerator {
    public String generateBankStatement(ArrayList<Transaction> transactions) {
        String bankStatement = "";

        for(Transaction transaction : transactions) {
            bankStatement += transaction.getTransactionType();
            bankStatement += transaction.getDate();
            bankStatement += transaction.getAmount();
            bankStatement += transaction.getBalance();
            bankStatement += "/n";
        }

        return bankStatement;
    }
}
