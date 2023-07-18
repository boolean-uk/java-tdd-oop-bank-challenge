package com.booleanuk.core.accounts;

import com.booleanuk.core.users.Customer;

import java.time.LocalDateTime;

public class OverdraftRequest {
    private double amount;
    private Customer customer;
    private StandardAccount standardAccount;
    private LocalDateTime date;
    private boolean accepted;

}
