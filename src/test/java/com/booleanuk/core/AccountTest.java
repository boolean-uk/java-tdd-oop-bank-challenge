package com.booleanuk.core;

import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

public class AccountTest {
    private int balance;
    private int overdraft;
    private StringBuilder transactionLog;
    private Date transactionDate;

    @BeforeEach
    void setUp(){
        Account account = new Account(new User(286, "Thomas", "Oslo"));
    }
}
