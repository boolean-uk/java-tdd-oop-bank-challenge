package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static com.booleanuk.core.TransactionType.*;

public class BankStatement {
    User owner;
    private final Map<Account, List<Transaction>> transactions;

    public BankStatement(User owner, Map<Account, List<Transaction>> transactions) {
        this.owner = owner;
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        StringBuilder statementBuilder = new StringBuilder();
        statementBuilder.append("User: ").append(owner.getName()); // Include the User's name at the top
        statementBuilder.append(System.lineSeparator());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        transactions.forEach((account, transactions) -> {
            statementBuilder.append("Account Number: ").append(account.getAccountNumber()); // Include account number
            statementBuilder.append(System.lineSeparator());
            statementBuilder.append("Date       ||  Credit   ||   Debit   || Balance");
            statementBuilder.append(System.lineSeparator());
            statementBuilder.append("-----------------------------------------");
            statementBuilder.append(System.lineSeparator());

            double[] balance = {0.0};
            transactions.forEach(transaction -> {
                String dateStr = formatter.format(transaction.getDate());
                String creditStr = "";
                String debitStr = "";

                if (transaction.getType() == WIRE_FROM || transaction.getType() == DEPOSIT) {
                    creditStr = String.format("%9.2f", transaction.getAmount());
                    debitStr = String.format("%9s", "");
                } else {
                    debitStr = String.format("%9.2f", -transaction.getAmount());
                    creditStr = String.format("%9s", "");
                }

                balance[0] += transaction.getType() == WIRE_FROM || transaction.getType() == DEPOSIT ? transaction.getAmount() : -transaction.getAmount();
                String balanceStr = String.format("%.2f", balance[0]);

                statementBuilder.append(dateStr).append(" || ").append(creditStr).append(" || ").append(debitStr).append(" || ").append(balanceStr);
                statementBuilder.append(System.lineSeparator());
            });

            statementBuilder.append("------------------------------------------");
            statementBuilder.append(System.lineSeparator());
            statementBuilder.append(String.format("%42.2f",account.getBalance()));
            statementBuilder.append(System.lineSeparator());
        });

        return statementBuilder.toString();

    }




    public Map<Account, List<Transaction>> getTransactions() {
        return transactions;
    }
}
