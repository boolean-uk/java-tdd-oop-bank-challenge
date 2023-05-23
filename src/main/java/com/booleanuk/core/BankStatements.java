package com.booleanuk.core;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankStatements {
    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public String returnDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(dateTime);
    }

    public void printReceipt() {
        BankStatements bankStatements = new BankStatements();
//        System.out.println("\n date    ||  credit  ||  debit || balance  \n");
        System.out.println("%-20s %-6d $ %.2f \n date    ||  credit  ||  debit || balance  \n");
    }



}

