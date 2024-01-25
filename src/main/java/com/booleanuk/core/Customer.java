package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {

   private final String owner;
   private List<Account> accounts;

    public Customer(String owner) {
        this.owner = owner;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public boolean depositFounds(double amount, Account account, String date) {
        return account.changeBalance(amount, date);
    }

    public boolean withdrawFounds(double amount, Account account, String date) {
        return account.changeBalance(-amount, date);
    }

    public double showCurrentBalance(Account account) {
        return account.getBalance();
    }

    public String printBankStatements(Account account) {
        StringBuilder output = new StringBuilder();
        int columnSpace = 9;
        int spacesForBalance;
        int spacesForAmount;
        String amountString;
        String balanceString;

        if (account.getStatements().isEmpty()) {
            return "No bank statements has been made for this account";
        }
        output.append(" date      || credit   || debit    || balance  \n");
        for (BankStatement statement : account.getStatements()) {
            amountString = String.format("%.2f", statement.getAmount());
            balanceString = String.format("%.2f", statement.getBalanceAfter());
            spacesForAmount = columnSpace - amountString.length();
            spacesForBalance = columnSpace - balanceString.length();
            /* Column 1 */
            output.append(statement.getTransactionDate());
            output.append(" ||");
            if (statement.getType().equals("credit")) {
                /* Column 2 */
                output.append(createSpaces(spacesForAmount));
                output.append(amountString);
                output.append(" ||");
                /* Column 3 */
                output.append(createSpaces(columnSpace));
                output.append(" ||");
            } else {
                /* Column 2 */
                output.append(createSpaces(columnSpace));
                output.append(" ||");
                /* Column 3 */
                output.append(createSpaces(spacesForAmount));
                output.append(amountString);
                output.append(" ||");
            }
            /* Column 4 */
            output.append(createSpaces(spacesForBalance));
            output.append(balanceString);
            output.append(" \n");
        }
        return String.valueOf(output);
    }

    private String createSpaces(int amountOfSpaces) {
        StringBuilder spacesString = new StringBuilder();
        for (int i = 0; i < amountOfSpaces; i++) {
            spacesString.append(" ");
        }
        return spacesString.toString();
    }
}
