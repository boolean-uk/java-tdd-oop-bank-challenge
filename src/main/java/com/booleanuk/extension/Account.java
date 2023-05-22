package com.booleanuk.extension;

import java.time.LocalDate;

public interface Account {
    void deposit(double amount, LocalDate date);
    String withdraw(double amount, LocalDate date);
    String generateStatement();
}
