package com.booleanuk.core;

import java.time.LocalDateTime;

public interface Depositable {
    public String deposit(int sum);
    public void deposit(Transaction transaction);
    public void deposit(int sum, LocalDateTime timeOfTransaction);
    public String getAccountId();
    public boolean isCurrentAccount();
}
