package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Account {

    private final String firstname;
    private final String lastname;
    private int currentBalance;
    private boolean isActivated;
    public  ArrayList<Integer> balanceHistory;
    public  ArrayList<String> dateHistory;
    public ArrayList<Integer> balanceMoveHistory;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Account(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.currentBalance = 0;
        this.isActivated = true;
        this.balanceHistory = new ArrayList<>();
        this.dateHistory = new ArrayList<>();
        this.balanceMoveHistory = new ArrayList<>();
    }

    protected void deposit(int amount) {
        currentBalance += amount;
        balanceHistory.add(currentBalance);
        dateHistory.add(getCurrentDate());
        balanceMoveHistory.add(amount);
    }

    protected void withdraw(int amount) {
        if (currentBalance < amount) {
            throw new IllegalStateException("Cannot withdraw money");
        }
        currentBalance -= amount;
        balanceHistory.add(currentBalance);
        dateHistory.add(getCurrentDate());
        balanceMoveHistory.add(amount);
    }

    private String getCurrentDate() {
        LocalDate date = LocalDate.now();
        return DATE_FORMATTER.format(date);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }
}
