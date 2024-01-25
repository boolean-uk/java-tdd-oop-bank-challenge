package com.booleanuk.core;

public class BankManager {

    private double overdraftLimit = 1000.0;


    public boolean checkOverdraftLimit(double overdraftAmount) {
        if(this.overdraftLimit < overdraftAmount) {
            return false;
        } else {
            return true;
        }

    }
}
