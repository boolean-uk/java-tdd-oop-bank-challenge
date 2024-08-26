package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private LocalDateTime currentDateTime;
    private double depositAmount;
    private double withdrawAmount;
    private int transactionID;

    public Transaction(double depositAmount, double withdrawAmount){
        this.depositAmount = depositAmount;
        this.withdrawAmount = withdrawAmount;
        // Get the current date and time
        this.currentDateTime = LocalDateTime.now();
        // Define the format as dd:MM:yy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yy");
        // Format the current date and time
        String formattedDate = currentDateTime.format(formatter);
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}
