package com.booleanuk.core.Bank;

import java.util.Comparator;

public class TransactionTimestampComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction t1, Transaction t2) {
        return t2.getTimestamp().compareTo(t1.getTimestamp());
    }
}