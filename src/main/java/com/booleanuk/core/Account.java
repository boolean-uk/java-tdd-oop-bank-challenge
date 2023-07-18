package com.booleanuk.core;


import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    private String accountNr;
    private Branch branch;
    private ArrayList<Transfer> transfers;

    public Account(String accountNr, Branch branch) {
        this.accountNr = accountNr;
        this.branch = branch;
        this.transfers = new ArrayList<Transfer>();
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(ArrayList<Transfer> transfers) {
        this.transfers = transfers;
    }

    public int calculateBalance() {
        int sum = 0;
        for (Transfer transfer : transfers) {
            if (transfer instanceof Withdraw) sum -= transfer.getAmountOfMoney();
            else sum += transfer.getAmountOfMoney();
        }
        return sum;
    }

    public void deposit(int amountOfMoney) {
        transfers.add(new Deposit(amountOfMoney, LocalDate.now()));
    }

    public void withdraw(int amountOfMoney) {
        transfers.add(new Withdraw(amountOfMoney, LocalDate.now()));
    }

    public String generateBankStatements() {
        int balance = 0;
        StringBuilder s = new StringBuilder();
        s.append(String.format("\n%-17s%-17s%-17s%-17s\n", "Date", "Credit", "Debit", "Balance"));
        s.append(String.format("============================================================\n"));

        for (Transfer transfer : transfers) {
            balance += transfer.getAmountOfMoney();
            s.append(String.format("%-17s", transfer.getDate()));
            if (transfer instanceof Withdraw) {
                s.append(String.format("%-17s", ""));
                s.append(String.format("%-17s", transfer.getAmountOfMoney() / 100.0));
            } else {
                s.append(String.format("%-17s", transfer.getAmountOfMoney() / 100.0));
                s.append(String.format("%-17s", ""));
            }
            s.append(String.format("%-17s", balance / 100.0));
            s.append("\n");
        }

        return s.toString();
    }

    public void send() {
        TwilioService twilioService = new TwilioService();
        twilioService.send(generateBankStatements());
    }
}
