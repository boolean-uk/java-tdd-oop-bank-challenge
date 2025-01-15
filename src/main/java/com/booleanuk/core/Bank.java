package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Bank {
    private ArrayList<Account> NORWAY = new ArrayList<>();
    private ArrayList<Account> UK = new ArrayList<>();
    private ArrayList<Account> SWEDEN = new ArrayList<>();

    public ArrayList<Account> getNORWAY() {
        return NORWAY;
    }

    public ArrayList<Account> getUK() {
        return UK;
    }

    public ArrayList<Account> getSWEDEN() {
        return SWEDEN;
    }

    public Account createAccount(String branch, String accountType) {
        Random random = new Random();
        int accNum = 100000000 + random.nextInt(900000000);
        if (accountType.equals("CURRENT")) {
            CurrentAccount account = new CurrentAccount(accNum);
            if (branch.equals("NORWAY")) {
                NORWAY.add(account);
            } else if (branch.equals("UK")) {
                UK.add(account);
            } else if (branch.equals("SWEDEN")) {
                SWEDEN.add(account);
            }
            return account;
        } else {
            SavingsAccount account = new SavingsAccount(accNum);
            if (branch.equals("NORWAY")) {
                NORWAY.add(account);
            } else if (branch.equals("UK")) {
                UK.add(account);
            } else if (branch.equals("SWEDEN")) {
                SWEDEN.add(account);
            }
            return account;
        }
    }
}
