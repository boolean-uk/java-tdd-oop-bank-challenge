package com.booleanuk.core;

import java.util.ArrayList;

public class Statement {

    private Account account;
    private ArrayList<String> bankStatement;
    private String header1;
    private String header2;

    private String header3 = "|| Date       || Deposit    || Withdraw   || Balance    ||";

    public Statement(Account account) {
        this.account = account;
        bankStatement = new ArrayList<>();
        header1 = "Name: " + account.getLastName() + ", " + account.getFirstName() + "    Account Number: " + account.getAccountNr();
        header2 = "Account Type: " + account.getType() + "    Bank Branch: " + account.getBranch();
    }

    public void makeStatement() {
        // Add header lines to the bank statement list
        bankStatement.add(header1);
        bankStatement.add(header2);
        bankStatement.add(header3);

        double balance = 0.0;
        String deposit = "";
        String withdraw = "";

        // Iterate through transactions and build lines in the correct format
        for (Transaction transaction: account.getTransactions()) {
            String time = transaction.getTime();
            double amount = transaction.getAmount();
            balance += amount;

            // if this transaction is a withdrawal it will be marked with a negative value,
            // this is to catch and remove the negative sign
            boolean isDeposit = true;
            if (amount < 0) {
                isDeposit = false;
                amount = amount * -1;
            }

            // make the transaction amount into a string of max two decimals.
            String strAmount = Double.toString(amount);
            if (strAmount.length() >= strAmount.indexOf(".")+3)
                strAmount = strAmount.substring(0, strAmount.indexOf(".")+3);

            // To get a correct format in each colum the left-over space after
            // the amount is added to the column is calculated
            String space = " ";
            String spaceBig = "           ";
            for (int i = 0; i < 9-strAmount.length(); i++) {
                space += " ";
            }

            // set up column strings for deposit and withdrawal
            if (isDeposit) {
                deposit = " " + strAmount + space;
                withdraw = spaceBig;
            }
            else {
                withdraw = " " + strAmount + space;
                deposit = spaceBig;
            }

            // make the balance into a string of max two decimals
            String strBalance = Double.toString(balance);
            if (strBalance.length() >= strBalance.indexOf(".")+3)
                strBalance = strBalance.substring(0, strBalance.indexOf(".")+3);

            // Calculate the balance space in the column for correct format
            space = " ";
            for (int i = 0; i < 10-strBalance.length(); i++) {
                space += " ";
            }
            strBalance = " " + strBalance + space;

            // build line and add it to the bank statement list
            String line = "|| " + time + " || " + deposit + "|| " + withdraw + "||" + strBalance + "||";
            bankStatement.add(line);
        }

    }

    public ArrayList<String> getBankStatement() {
        for (String line: bankStatement) {
            System.out.println(line);
        }
        return bankStatement;
    }
}
