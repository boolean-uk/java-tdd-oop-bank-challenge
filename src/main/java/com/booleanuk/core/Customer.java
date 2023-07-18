package com.booleanuk.core;

import java.time.LocalDate;

public class Customer extends Person{
    public Customer(String name, String surname, LocalDate birthdate) {
        super(name, surname, birthdate);
    }

    @Override
    public String toString() {
        return Customer.super.toString();
    }
}
