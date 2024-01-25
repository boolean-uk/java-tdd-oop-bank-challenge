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
        System.out.println(header1);
        System.out.println(header2);
        System.out.println(header3);


        int statmentWidth = header3.length();
        double balance = 0;
        String deposit = "";
        String withdraw = "";

        for (Transaction transaction: account.getTransactions()) {
            String time = "25/01/1995"; // transaction.getTime();
            double amount = transaction.getAmount();
            boolean isDeposit = true;
            if (amount < 0) {
                isDeposit = false;
                amount = amount * -1;
            }
            balance += amount;
            String strAmount = Double.toString(amount);
            if (strAmount.length() >= strAmount.indexOf(".")+3)
                strAmount = strAmount.substring(0, strAmount.indexOf(".")+3);



            String space = " ";
            String spaceBig = "            ";
            for (int i = 0; i < 9-strAmount.length(); i++) {
                space += " ";
            }


            if (amount > 0) { //deposit
                deposit = " " + strAmount + space;
                withdraw = spaceBig;
            }
            else {
                withdraw = " " + strAmount + space;
                deposit = spaceBig;
            }

            String strBalance = Double.toString(balance);
            if (strBalance.length() >= strBalance.indexOf(".")+3)
                strBalance = strBalance.substring(0, strBalance.indexOf(".")+3);

             space = " ";
            for (int i = 0; i < 12-strBalance.length(); i++) {
                space += " ";
            }
            strBalance = " " + strBalance + space;

            String line = "|| " + time + " || " + deposit + "||" + withdraw + "||" + strBalance + "||";

            bankStatement.add(line);
            System.out.println(line);
        }

    }


}
