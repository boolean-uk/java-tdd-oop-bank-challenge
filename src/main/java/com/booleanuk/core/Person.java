package com.booleanuk.core;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person {
    private String name;
    private String surname;
    private LocalDate birthdate;

    public Person(String name, String surname, LocalDate birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }
}
