package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    LocalDateTime date;
    HashMap<LocalDate, ArrayList<Double>> debit;
    HashMap<LocalDate, ArrayList<Double>> credit;
    String accountNumber;
    ArrayList<String> accounts;

    public HashMap<LocalDate, ArrayList<Double>> getDebitList() {
        return debit;
    }

    public HashMap<LocalDate, ArrayList<Double>> getCreditList() {
        return credit;
    }

    public Account(){

    }
}
