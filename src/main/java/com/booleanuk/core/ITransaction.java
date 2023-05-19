package com.booleanuk.core;

import java.time.LocalDate;

public interface ITransaction {
    LocalDate date();
    double amount();
    double balance();
}
