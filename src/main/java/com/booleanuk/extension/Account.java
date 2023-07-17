package com.booleanuk.extension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


abstract class Account {
    String firstname;
    String lastname;
    boolean activated;
    String type;
    String branch;

    ArrayList<Integer> balanceHistory;
    ArrayList<String> dateHistory;
    ArrayList<Double> balanceMoveHistory;

    public Account(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.activated = false;

        balanceHistory = new ArrayList<>();
        dateHistory = new ArrayList<>();
        balanceMoveHistory = new ArrayList<>();
    }

    public double getCurrentBalance() {
        if (balanceHistory.isEmpty()) {
            return 0.0;
        }
        return balanceHistory.get(balanceHistory.size()-1) / 100.0;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean deposit(double balance) {
        if (balance <= 0) {
            System.out.println("Can't deposit 0 or negative balance");
            return false;
        }

        // Activate account so it can print statement, to have at least one move
        if (!activated) {
            activated = true;
        }

        if (balanceHistory.isEmpty()) {
            balanceHistory.add(doubleToIntBalance(balance));
        } else {
            balanceHistory.add(balanceHistory.get(balanceHistory.size()-1) + doubleToIntBalance(balance));
        }
        balanceMoveHistory.add(balance);
        dateHistory.add(getDate());
        return true;
    }

    public boolean withdraw(double balance) {
        if (doubleToIntBalance(balance) > balanceHistory.get(balanceHistory.size()-1)) {
            System.out.println("Cant withdraw more than your current balance");
            return false;
        }

        balanceHistory.add(balanceHistory.get(balanceHistory.size()-1) - doubleToIntBalance(balance));
        balanceMoveHistory.add(-balance);
        dateHistory.add(getDate());
        return true;
    }

    protected int doubleToIntBalance(double balance) {
        return (int) (balance * 100);
    }

    protected String getDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(date);
    }

}
