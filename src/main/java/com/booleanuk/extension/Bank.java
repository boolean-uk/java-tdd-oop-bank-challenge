package com.booleanuk.extension;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bank {
    ArrayList<Account> accounts;



    public Bank() {
        accounts = new ArrayList<>();
    }


    public boolean createAccount(String firstname, String lastname) {
        for (Account account: accounts) {
            if (firstname.equals(account.firstname) && lastname.equals(account.lastname)) {
                System.out.println("Failed to create an account. The user already has an account!");
                return false;
            }
        }

        Account account= new CurrentAccount(firstname, lastname);
        accounts.add(account);
        System.out.println("New user created!");
        return true;
    }

    public boolean createAccount(String firstname, String lastname, String type) {
        if (type.equalsIgnoreCase("current")) {
            return createAccount(firstname, lastname);
        } else if (type.equalsIgnoreCase("savings")) {
            for (Account account: accounts) {
                if (firstname.equals(account.firstname) && lastname.equals(account.lastname) && account.getClass().equals(SavingAccount.class)) {
                    System.out.println("Failed to create an account. The user already has a savings account!");
                    return false;
                }
            }

            Account account= new SavingAccount(firstname, lastname);
            account.type = "savings";
            accounts.add(account);
            System.out.println("New user created!");
            return true;
        }

        return false;
    }

    public boolean printStatement(Account account) {


        if (!accounts.contains(account)) {
            System.out.println("Account does not exist!");
            return false;
        }

        if (!account.activated) {
            System.out.println("Account exists but is not activated and has no Statement yet.");
            return false;
        }


        // Up to 8 Digits after than it needs update!!  999999.99 upper limit!

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("date       || credit   || debit    || balance");
        for (int i = account.balanceHistory.size() -1; i >= 0 ; i--) {
            System.out.print(account.dateHistory.get(i)+ " ||");

            if (account.balanceMoveHistory.get(i) > 0) {

                System.out.printf("%9s ||         ", df.format(account.balanceMoveHistory.get(i)));
            } else {
                System.out.printf("          ||%9s",df.format(account.balanceMoveHistory.get(i)));
            }

            double histBalance = account.balanceHistory.get(i) / 100.0;
            System.out.print(" || " + df.format(histBalance));
            System.out.println();
        }

        return true;
    }

}
