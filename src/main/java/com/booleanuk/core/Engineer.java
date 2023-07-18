package com.booleanuk.core;

import java.util.List;

public class Engineer {
    private String fullname;

    public Engineer(String fullname) {
        this.fullname = fullname;
    }

    public double getAccountBalance(BankAccount bankAccount)
    {
        List<Transaction> transactions = bankAccount.getTransactions();
        double sum=0;
        for (Transaction transaction:transactions
             ) {
            if(transaction.getTransactionType()==TransactionType.debit)
            {
                sum-= transaction.getAmount();
            }
            else sum+= transaction.getAmount();
        }
        return sum;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
