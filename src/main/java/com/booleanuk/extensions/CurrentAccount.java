package com.booleanuk.extensions;

import java.time.LocalDate;

public class CurrentAccount extends Account {
    boolean approvedOverdraft;

    public CurrentAccount() {
        super();
        approvedOverdraft = false;
    }

    public void setOverdraft(boolean choice) {
        approvedOverdraft = choice;
    }


    public String withdraw(float amount, LocalDate date) {
        if (amount > 0) {
            float balance = countTheBalance();
            if (amount < balance) {
                if (transactionsHistory.size() == 0
                        || (date.isAfter(transactionsHistory.get(transactionsHistory.size() - 1).getDate())
                        || date.isEqual(transactionsHistory.get(transactionsHistory.size() - 1).getDate()))) {
                    transactionsHistory.add(new Transaction(date, amount * -1));
                    return amount + POUND + " withdrawn from your account.";

                } else return "You cannot withdraw any money before the last date in transactions history.";
            } else if (approvedOverdraft) {
                if (transactionsHistory.size() == 0
                        || (date.isAfter(transactionsHistory.get(transactionsHistory.size() - 1).getDate())
                        || date.isEqual(transactionsHistory.get(transactionsHistory.size() - 1).getDate()))) {
                    transactionsHistory.add(new Transaction(date, amount * -1));
                    return "Overdraft has been used. Your balance is: " + countTheBalance() + POUND;

                } else return "You cannot withdraw any money before the last date in transactions history.";
            } else return "You do not have enough money in your account.";

        } else return "Amount is invalid.";
    }
}
