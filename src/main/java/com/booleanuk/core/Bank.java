package com.booleanuk.core;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bank {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void createAccount(String firstname, String lastname) {
        Account account = new CurrentAccount(firstname, lastname);
        accounts.add(account);
    }

    public boolean printStatement(Account account) {
        if (!accounts.contains(account)) {
            throw new IllegalStateException("Account does not exist!");
        }

        if (!account.isActivated()) {
            throw new IllegalStateException("Account exists but is not activated yet.");
        }
        printTransactionHistory(account);
        return true;
    }

    private void printTransactionHistory(Account account) {
        System.out.println("Date       || Credit   || Debit    || Balance");
        for (int i = account.balanceHistory.size() - 1; i >= 0; i--) {
            System.out.print(account.dateHistory.get(i) + " ||");
            printTransactionDetail(account.balanceMoveHistory.get(i));
            printCurrentBalance(account.balanceHistory.get(i));
        }
    }

    private void printTransactionDetail(int balanceMove) {
        if (balanceMove > 0) {
            System.out.printf("%9s ||         ", DECIMAL_FORMAT.format(balanceMove));
        } else {
            System.out.printf("          ||%9s", DECIMAL_FORMAT.format(balanceMove));
        }
    }

    private void printCurrentBalance(int currentBalance) {
        double histBalance = currentBalance / 100.0;
        System.out.print(" || " + DECIMAL_FORMAT.format(histBalance));
        System.out.println();
    }
}
