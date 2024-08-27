package com.booleanuk.core;

import java.time.LocalDateTime;

public interface Depositable {
    public int deposit(int sum);
    public int deposit(Transaction transaction);
    public int deposit(int sum, LocalDateTime timeOfTransaction);
    public String getAccountId();
    public boolean isCurrentAccount();
}
