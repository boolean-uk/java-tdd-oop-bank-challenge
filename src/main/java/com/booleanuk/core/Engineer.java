package com.booleanuk.core;

import java.util.List;

public class Engineer {
    private String fullName;

    public Engineer(String fullName) {
        this.setFullName(fullName);
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
