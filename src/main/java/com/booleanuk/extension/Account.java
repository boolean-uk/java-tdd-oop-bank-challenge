package com.booleanuk.extension;

import java.time.LocalDate;

public interface Account {
    void deposit(double amount, LocalDate date);
    void withdraw(double amount, LocalDate date);
    void generateStatement();
}
