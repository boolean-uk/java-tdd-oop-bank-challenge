package com.booleanuk.core;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Statement {

    private int customerId;
    private int accountId;
    private int credit;
    private int debit;

    private String date;

    public Statement (int customerId, int accountId, int credit, int debit, String date) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.credit = credit;
        this.debit = debit;
        this.date = date;
    }

    //Getters
    public int getCustomerId() {
        return customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebit() {
        return debit;
    }

    public String getDate() {
        return date;
    }

    public static @NotNull String getDateNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = now.format(format);
        return date;
    }

}
