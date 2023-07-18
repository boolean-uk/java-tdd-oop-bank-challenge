package com.booleanuk.core;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Account {
    String firstname;
    String lastname;
    int currentBalance; // Balance in cents (int)
    boolean activated;
    String type;

    ArrayList<Integer> balanceHistory;
    ArrayList<String> dateHistory;
    ArrayList<Double> balanceMoveHistory;

    public Account(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.currentBalance = 0;
        this.activated = false;

        balanceHistory = new ArrayList<>();
        dateHistory = new ArrayList<>();
        balanceMoveHistory = new ArrayList<>();
    }

    public boolean deposit(double balance) {
        if (balance <= 0) {
            System.out.println("Cannot deposit 0 or negative balance!");
            return false;
        }

        if (!activated) {
            activated = true;
        }

        currentBalance += doubleToIntBalance(balance);
        balanceHistory.add(currentBalance);
        balanceMoveHistory.add(balance);
        dateHistory.add(getDate());
        return true;
    }

    public boolean withdraw(double balance) {
        if (doubleToIntBalance(balance) > currentBalance) {
            System.out.println("Cannot withdraw more than your current balance!");
            return false;
        }

        currentBalance -= doubleToIntBalance(balance);
        balanceHistory.add(currentBalance);
        balanceMoveHistory.add(-balance);
        dateHistory.add(getDate());
        return true;
    }

    private int doubleToIntBalance(double balance) {
        return (int) (balance * 100);
    }
    public String getFirstname() { return firstname; }
    public int getCurrentBalance() {
        return currentBalance;
    }
    public String getLastname() { return lastname; }

    private String getDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatter.format(date);
    }

}
