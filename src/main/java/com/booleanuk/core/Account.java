package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Account {
    protected String firstname;
    protected String lastname;
    protected int currentBalance; // Balance in cents (int)
    protected boolean activated;

    protected ArrayList<Integer> balanceHistory;
    protected ArrayList<String> dateHistory;
    protected ArrayList<Double> balanceMoveHistory;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Account(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.currentBalance = 0;
        this.activated = false;

        this.balanceHistory = new ArrayList<>();
        this.dateHistory = new ArrayList<>();
        this.balanceMoveHistory = new ArrayList<>();
    }

    public boolean deposit(double balance) {
        if (balance <= 0) {
            return false;
        }

        this.activated = true;
        this.currentBalance += doubleToIntBalance(balance);
        this.balanceHistory.add(this.currentBalance);
        this.balanceMoveHistory.add(balance);
        this.dateHistory.add(getCurrentDate());
        return true;
    }

    public boolean withdraw(double balance) {
        if (doubleToIntBalance(balance) > this.currentBalance) {
            return false;
        }

        this.currentBalance -= doubleToIntBalance(balance);
        this.balanceHistory.add(this.currentBalance);
        this.balanceMoveHistory.add(-balance);
        this.dateHistory.add(getCurrentDate());
        return true;
    }

    private int doubleToIntBalance(double balance) {
        return (int) (balance * 100);
    }

    public String getFirstname() {
        return this.firstname;
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

    public String getLastname() {
        return this.lastname;
    }

    public boolean isActivated() {
        return this.activated;
    }

    private String getCurrentDate() {
        LocalDate date = LocalDate.now();
        return DATE_FORMATTER.format(date);
    }
}
