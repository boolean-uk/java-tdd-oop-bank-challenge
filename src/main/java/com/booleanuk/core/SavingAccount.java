package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;

public class SavingAccount extends Account{


    public SavingAccount(Bank bank) {
        super(bank);
    }

    public String withdraw(double amount, LocalDate date) {
        ArrayList<Double> tmp = new ArrayList<>();
        if(amount > 0){
            if(countBalanceTotal(this.credit, this.debit) >= amount) {
                if (!getDebitList().containsKey(date)) {
                    tmp.add(amount);
                    getDebitList().put(date, tmp);
                } else {
                    getDebitList().get(date).add(amount);
                }
                return "Money withdrew";
            } else return "Saving account cannot have negative balance";
        } else return "No money to withdraw from deposit";
    }

    public String withdraw(double amount) {
        ArrayList<Double> tmp = new ArrayList<>();
        if(amount > 0) {
            if(countBalanceTotal(this.credit, this.debit) >= amount) {
                this.date = LocalDate.now();
                if (!getDebitList().containsKey(date)) {
                    tmp.add(amount);
                    getDebitList().put(this.date, tmp);
                } else {
                    getDebitList().get(date).add(amount);
                }
                return "Money withdrew";
            }else return "Saving account cannot have negative balance";
        } else return "No money to withdraw from deposit";
    }
}
