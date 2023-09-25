package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount extends BankAccount {
    private final String bankType = "current";
    private List<TransferData> transferItemms;

    public CurrentAccount() {
        this.transferItemms = new ArrayList<>();
    }

    public CurrentAccount(double balance) {
        super(balance);
        this.transferItemms = new ArrayList<>();
    }

    public String getBankType() {
        return bankType;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
            transferItemms.add(new TransferData(this.getDate(), amount, 0, balance));
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transferItemms.add(new TransferData(this.getDate(), 0, amount, balance));
            return true;
        } else {
            return false;
        }
    }

    public void transferHistory() {
        System.out.println("date       || credit  || debit  || balance");
        for (TransferData data : transferItemms) {
            String dateVal = data.getDate();
            String creditVal = data.getCredit() > 0 ? String.valueOf(data.getCredit()) : "       ";
            String debitVal = data.getDebit() > 0 ? String.valueOf(data.getDebit()) : "        ";
            String balanceVal = String.valueOf(data.getBalance());

            System.out.println(dateVal + " || " + creditVal + " || " + debitVal + " || " + balanceVal);
        }

    }


}
