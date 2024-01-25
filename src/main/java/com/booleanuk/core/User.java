package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private final LocalDate birthDate;
    private final String userName;
    private final String userID;
    private ArrayList<Account> accounts;

    public User(String userName, LocalDate birthDate)
    {
        this.userName = userName;
        this.birthDate = birthDate;
        this.userID = birthDate + userName;
    }
}
