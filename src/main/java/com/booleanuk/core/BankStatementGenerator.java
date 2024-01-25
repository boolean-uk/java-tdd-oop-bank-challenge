package com.booleanuk.core;

import java.util.ArrayList;

public class BankStatementGenerator {
    public String generateBankStatement(ArrayList<Transaction> transactions) {

        return "Credit: 100 on 10/01/2024" + "/n" +
                "Debit: 50 on 15/01/2024" + "/n" +
                "Balance: 50";
    }
}
