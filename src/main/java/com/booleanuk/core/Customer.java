package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {
    private String ID;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private List<Account> accounts;

    public Customer(String name, String surname, LocalDate dateOfBirth) {
        String randomID = generateCustomRandomID(10);
        this.ID = randomID;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.accounts = new ArrayList<>();
    }

    private static String generateCustomRandomID(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomID = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomID.append(characters.charAt(index));
        }

        return randomID.toString();
    }


    @Override
    public String toString() {
        return "Customer{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", accounts=" + accounts +
                '}';
    }
}
