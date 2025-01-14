package com.booleanuk.core;

public interface Depositable {
    public String deposit(int sum);
    public void deposit(Transaction transaction);
    public String getAccountId();
    public boolean isCurrentAccount();
}
